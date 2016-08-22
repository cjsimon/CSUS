#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <fcntl.h>

#define MAXLINE 80
#define MAXARGS 20

void process_input(int argc, char **argv) {
	/* Problem 1: perform system call execvp to execute command     */ 
	/*            No special operator(s) detected                   */
	/* Hint: Please be sure to review execvp.c sample program       */
	/* if (........ == -1) {                                        */  
	/*  perror("Shell Program");                                    */
	/*  _exit(-1);                                                  */
	/* }                                                            */
	/* Problem 2: Handle redirection operators: < , or  >, or both  */ 

	int i;
	int count = 0;
	for(i = 0; i < argc; i++) {
		if (((strcmp(argv[i], "<") == 0 || (strcmp(argv[i], ">") == 0))) && argc == 1) {
			printf("");
			_exit(0);
		} 		
	}
	for (i = 0; i < argc; i++) {
		if (strcmp(argv[i], "<") == 0)  {
			int pos = 1;
			int fileId = open(argv[pos + 1], O_RDWR | O_CREAT | S_IWUSR);
			dup2(fileId, 1);
			close(fileId);
			execvp(argv[0], argv);
			argv[pos] = NULL;
		}else if(strcmp(argv[i], ">") == 0) {
			int pos = i;
			int fileId = open(argv[pos + 1], O_RDWR | O_CREAT, S_IRUSR);
			argv[pos] = NULL;
			dup2(fileId, 1);
			close(fileId);    
			execvp(argv[0], argv);
		}
	}  
	execvp(argv[0], argv);
	if (execvp(argv[0], argv) == -1) {
		perror("Error with execvp: ");
		_exit(0);
	} 
}

/* ----------------------------------------------------------------- */
/*                  parse input line into argc/argv format           */
/* ----------------------------------------------------------------- */
int parseline(char *cmdline, char **argv)
{
	int count = 0;
	char *separator = " \n\t";
	argv[count] = strtok(cmdline, separator);
	while ((argv[count] != NULL) && (count+1 < MAXARGS)) {
		argv[++count] = strtok((char *) 0, separator);
	}
	return count;
}
/* ----------------------------------------------------------------- */
/*                  The main program starts here                     */
/* ----------------------------------------------------------------- */
int main(void)
{
	char cmdline[MAXLINE];
	char *argv[MAXARGS];
	int argc;
	int status;
	pid_t pid;
	int MAXLENGTH = 80;
	char buff[MAXLENGTH];
	int i;
	char *ptr;
	/* Loop forever to wait and process commands */
	while (1) {
		printf("csc60mshell");
		fgets(cmdline, MAXLINE, stdin); 
		argc = parseline(cmdline, argv);
		if (argc == 0) {
			continue;
		}
		if (argc == 1 && strcmp(argv[0], "exit") == 0) {
			exit(0);
		}  
		if (strcmp(argv[0], "cd") == 0) {
			if (argc == 1) { 
				chdir(getenv("HOME"));
			}else{
				chdir(argv[1]);
			}
			chdir(ptr);
			getcwd(buff, MAXLENGTH);
			setenv("PWD", buff, 1);
		}else if (strcmp(argv[0], "pwd") == 0) {
			char *cwd;
			cwd = getcwd(buff, MAXLENGTH + 1);
			if (cwd != NULL) {  
				printf("Current working directory %s\n", cwd);
			}
		}else{ 
			pid = fork();
			if (pid == -1) { 
				perror("Shell Program fork error");
			}else if (pid == 0) {
				process_input(argc, argv);
			}else{ 
				if (wait(&status) == -1) {
					perror("Shell Program error");
				}else{
					printf("Child returned status: %d\n",status);
				}  
			}
		}
	}      
}
