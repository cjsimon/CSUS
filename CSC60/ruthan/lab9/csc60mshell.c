/**
 * Author(s):
 * Christopher Simon  Section 4
 * Pablo Verbovshchuk Section 2
 *
 * This is a csc60mshell.c
 * This program serves as a skeleton for starting for lab 8.
 * Student is required to use this program to build a mini shell
 * using the specification as documented in direction.
 * Date: Spring 2016
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdbool.h>
#include <signal.h>
 
// The maximum characters and arguments a command can have
#define MAXLINE 80
#define MAXARGS 20
#define MAX_PATH_LENGTH 50

// Prototypes
void process_input(int argc, char **argv);
int parseline(char *cmdline, char **argv);
bool isBuiltInCommand(int argc, char **argv);
void shouldBackground(int argc, char **argv);
void sigHandler(int sig);

// Include the job_array structure, and two counters (start both at zero):
// Variable to keep count of the jobs running
int jobsRunning;
// Variable to use to name the next job
int nextJobNumber = 0;

int runningInBackground = 0;


typedef struct {
	char status[80];
	int process_id;
	char command[80];
	int job_number;
} jobs;

jobs job_array[20];


int main(void)
{
	char cmdline[MAXLINE];
	char *argv[MAXARGS];
	int argc;
	int status;
	pid_t pid;
		
	// Wait for process commands
	int i, j;
	
	/*
	struct sigaction act;
	if(pid != 0)
	{
		act.sa_handler = SIG_IGN;
	}
	else
	{
		act.sa_handler=SIG_DFL;
	}
	sigemptyset(&act.sa_mask);
	act.sa_flags = 0;
	sigaction(SIGINT, &act, 0);
	*/

	if(signal(SIGCHLD, sigHandler) == SIG_ERR)
	{
		fprintf(stderr, "signal");
	}
	
	// Listen for interupt events from child processes
	// Use the sigHandler function to check for the process that has terminated
	// due to the SIGINT being called
	if(signal(SIGINT, sigHandler) == SIG_ERR)
	{
		fprintf(stderr, "signal error");
	}
	
	for(;;) //for(i = 0; i < 10; i++)
	{
		printf("crash> ");
		fgets(cmdline, MAXLINE, stdin);
		// Call parseline to build argc/argv: their limits declared above
		argc = parseline(cmdline, argv);
		
		// Check if built in command or no command
		if(argc == 0 || isBuiltInCommand(argc, argv)) continue;
		
		// Fork a new process to run the command
		pid = fork();
		switch(pid)
		{
			case -1:
				perror("Shell Program fork error");
				exit(1);
				break;
			case 0:
				/* I am child process. I will execute the command, call: execvp */
				process_input(argc, argv);
				break;
			default:
				/* I am parent process */
				if(runningInBackground == 1)
				{
					sigset_t newmask, oldmask;
					sigemptyset(&newmask);
					sigaddset(&newmask, SIGINT);
					/* block SIGINT; save old mask */
					sigprocmask(SIG_BLOCK, &newmask, &oldmask);
					
					jobs job = job_array[nextJobNumber++];
					job.process_id = pid;
					
					strcat(job.command, "");
					int a;
					for(a = 0; a < argc-1; a++)
					{
						strcat(job.command, argv[a]);
						strcat(job.command, " ");
					}
					
					job.job_number = nextJobNumber;
					jobsRunning++;
					sigprocmask(SIG_SETMASK, &oldmask, NULL);
				}
				else if(wait(&status) == -1)
				{
					perror("Shell Program error");
				}
				else
				{
					printf("Child returned status: %d\n", status);
					
					if(WIFEXITED(status))
					{
						printf("child process exited with value %d\n", WEXITSTATUS(status));
					}
					else if(WIFSIGNALED(status))
					{
						printf("Child process exited due to signal %d\n", WTERMSIG(status));
					}	
					else if(WIFSTOPPED(status))
					{
						printf("Child process was stopped by signal %d\n", WIFSTOPPED(status));
					}
				}
				break;
		}
	}
}


/**
 * Special case built in commands for 
 */
bool isBuiltInCommand(int argc, char **argv)
{
	bool builtIn = true;
	if(argc == 1 && strcmp(argv[0], "exit") == 0)
	{
		exit(EXIT_SUCCESS);
	}
	else if(strcmp(argv[0], "cd") == 0)
	{
		char buff[MAXLINE];
		char *ptr;
		if(argc == 1)
		{
			chdir(getenv("HOME"));
		}
		else
		{
			chdir(argv[1]);
		}
	}
	else if(strcmp(argv[0], "pwd") == 0)
	{
		char buf[1024];
		if(getcwd(buf, sizeof(buf)) != NULL)
		{
			fprintf(stdout, "%s\n", buf);
		}
		else
		{
			perror("error: ");
		}
	}
	else if(strcmp(argv[0], "jobs") == 0)
	{
		// Critical Code Region
		// Loop through jobs and print them
		int j;
		if(jobsRunning == 0) printf("No jobs running\n");
		for(j = 0; j < jobsRunning; j++)
		{
			sigset_t newmask, oldmask;
			sigemptyset(&newmask);
			sigaddset(&newmask, SIGINT);
			/* block SIGINT; save old mask */
			sigprocmask(SIG_BLOCK, &newmask, &oldmask);
			
			// Print the current job
			jobs job = job_array[j];
			printf(
				"[%d]\tPID = %d\t%s\n",
				job.job_number,
				job.process_id,
				job.command
			);
			
			sigprocmask(SIG_SETMASK, &oldmask, NULL);
		}
	}
	else
	{
		// Check if the command should be backgrounded
		shouldBackground(argc, argv);
		builtIn = false;
	}
	return builtIn;
}

void shouldBackground(int argc, char **argv)
{
	if(strcmp(argv[argc-1], "&") == 0)
	{
		runningInBackground = 1;
		argv[--argc] = NULL;
	}
	else
	{
		runningInBackground = 0;
	}
}

/* parse input line into argc/argv format */
int parseline(char *cmdline, char **argv)
{
	int count = 0;
	char *separator = " \n\t";
	
	argv[count] = strtok(cmdline, separator);
	while((argv[count] != NULL) && (count+1 < MAXARGS))
	{
		argv[++count] = strtok((char *) 0, separator);
	}
	return count;
}

void process_input(int argc, char **argv)
{
	/* Problem 1: perform system call execvp to execute command          */
	/*            No special operator(s) detected                        */
	/* Hint: Please be sure to review execvp.c sample program            */
	/* Problem 2: Handle redirection operators: < , or  >, or both       */
	/* open file at position 1 after carrot. dup2 it to the input/output */
	/* close the file and set the carrot to null                         */
	
	// A redirection cannot be the first and only argument in the command
	if((strcmp(argv[0], "<") == 0 || strcmp(argv[0] , ">") == 0) && argc == 1)
	{
		printf("Error!");
		_exit(0);
	}
	
	int fileId, i;
	int io;
	
	for(i = 0; i < argc; i++)
	{
		if(strcmp(argv[i], ">") == 0)
		{
			// Try to use the next argument as a file to open
			int fileId = open(argv[i + 1], O_RDWR | O_CREAT, S_IRUSR);
			// Attach the file descriptor to stdout
			dup2(fileId, 1);
			// Close the fileId
			close(fileId);
			// Unset the argument as it has been applied
			argv[i] = NULL;
			// Execute the command
			execvp(argv[0], argv);
		}
		else if(strcmp(argv[i], "<") == 0)
		{
			fileId = open(argv[i+1], O_RDWR | O_CREAT | S_IWUSR);
			// Attach the file descriptor to stdout
			dup2(fileId, 0);
			// Close the fileId
			close(fileId);
			// Unset the argument as it has been applied
			argv[i]= NULL;
			// Execute the command
			execvp(argv[0], argv);
		}
	}
	
	// Execute the command at argv
	if(execvp(argv[0], argv) == -1)
	{
		perror("Error with execvp");
		_exit(-1);
	}
}

void sigHandler(int sig)
{
	pid_t pid;
	int status;
	
	while(pid = waitpid(-1, &status, WNOHANG) > 0)
	{
		printf("%i", pid);
		int j;
		for(j = 0; j < jobsRunning; j++)
		{
			jobs job = job_array[j];
			if(job.process_id == pid)
			{
				// Found job that died
				printf("[%i] Done %s", job.job_number, job.command);
				int i;
				for(i = job.job_number+1; i < jobsRunning; i++)
				{
					job_array[i-1] = job_array[i];
				}
				jobsRunning--;
				// We found the job that died. We are done. break
				break;
			}
		}
	}
}
