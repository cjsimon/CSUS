#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <fcntl.h>
#include <signal.h>

#define MAXLINE 80
#define MAXARGS 20
//just added path max for the cd code
#ifndef PATH_MAX
#define PATH_MAX 255
#endif

// this is for buffer size
#define BUFF 50
void process_input(int argc, char **argv) {
  /* Problem 1: perform system call execvp to execute command     */ 
  /*            No special operator(s) detected                   */
  /* Hint: Please be sure to review execvp.c sample program       */
  /* if (........ == -1) {                                        */  
  /*  perror("Shell Program");                                    */
  /*  _exit(-1);                                                  */
  /* }                                                            */
  /* Problem 2: Handle redirection operators: < , or  >, or both  */
/*open file at position 1 after carrot. dup2 it to the input/output
 * close the file and set the carrot to null*/
        int pos = 0;
        int i=0;
	if((strcmp(argv[0],"<")==0 || strcmp(argv[0],">")==0)&& argc==1)
	{
		printf("");
		_exit(0);
	}
        for(i=0; i<argc; i++) {
                if(strcmp(argv[i], ">") == 0) {
                        pos = i;
                        int fileId = open(argv[pos+1],O_RDWR  | O_TRUNC |  S_IRUSR | S_IWUSR);
                        dup2(fileId,1);
                        close(fileId);
                        argv[pos]= NULL;
			execvp(argv[0],argv);
                }else if( strcmp(argv[i], "<") == 0){
			pos = i;
			int fileId = open(argv[pos + 1],O_RDWR | O_CREAT | S_IRUSR );
			argv[pos] = NULL;
			dup2( fileId, 0);
			close(fileId);
			execvp(argv[0],argv);	
		} 
	//	else continue;
        }
	execvp(argv[0],argv);
        if (execvp(argv[0],argv) == -1) {
                perror("Error with execvp:");
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
 	while((argv[count] != NULL) && (count+1 < MAXARGS))
 	{
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
    /// creating buffer here, buffer stores the path and uses it
	char  *tempbuf;
/* Loop forever to wait and process commands */
while (1) {
	struct sigaction act;
	if(pid!=0){	
		act.sa_handler = SIG_IGN;
	}
	else act.sa_handler=SIG_DFL;
	sigemptyset( &act.sa_mask );
	act.sa_flags = 0;
	sigaction( SIGINT, &act, 0 );
	int i=0;
	for(i=0; i<10;i++){
		/*Set up the Sigaction handler*/
		struct sigaction act;
	        if(pid==0){//default if child
	                act.sa_handler = SIG_DFL;
        }//ignore if parent
	        else act.sa_handler=SIG_IGN;
	        sigemptyset( &act.sa_mask );
	        act.sa_flags = 0;
	        sigaction( SIGINT, &act, 0 );
	
		printf(" csc60mshell - m > ");
  		fgets(cmdline, MAXLINE, stdin);
  		argc = parseline(cmdline, argv);
  	//check if a built-in command
	if(argc==0 || strcmp(argv[0],"exit")==0 || strcmp(argv[0],"pwd")==0 || strcmp(argv[0],"cd")==0 || strcmp(argv[0],"jobs")==0 )
	{
		if(argc == 0) continue;//Do nothing if person didnt enter anything
		//Exit
		if(argc == 1 && strcmp(argv[0],"exit")==0)
		{
			/* Check the jobs array. semaphore value will equal number of jobs running 
	 		 * semaphore value will go down by one every time a job terminates
	 		 * If semaphore value = 0 exit the shell
	 		 * if not let the user know there are background processes still running*/
	 		 _exit(0);
		}
		//PWD
		if(argc == 1 && strcmp(argv[0],"pwd")==0)
		{
			char *cwd;
			cwd=getcwd(buff,MAXLINE+1);
			if(cwd != NULL)
     			printf(" %s\n", getenv("PWD"));   
   		  	continue;
		}
		else if (strcmp(argv[0],"cd")==0)
		{      
			if(argc==2)
			{
				if(chdir(argv[1])==0)//chdir returns 0 if successful	
				{	
					printf("Directory has been changed to %s\n",argv[1]);
				}	
				else perror(argv[1]);//if not successful print out where you were trying to go
			}else{
				if(chdir(getenv("HOME")))
				{
					printf("Directory has been changed to HOME");
				}	
				else perror("Error occured when going to home directory");
			}
			getcwd(buff,PATH_MAX);
			setenv("PWD",buff,1);

		}
		else if(strcmp(argv[0],"jobs")==0)
		{
		printf("Inside jobs");
		continue;	
		}
		else continue;		
	}else {//if it is not a built-in command
		pid = fork();
		if (pid == -1) 
			perror("Shell Program fork error");
		else if (pid == 0) 
   			 /* I am child process. I will execute the command, call: execvp */
			process_input(argc, argv);
 		else{ 
 			/* I am parent process */
			/*if(isBackgrounjob(cmd))
  				record in list of background jobs*/    			

			if (wait(&status) == -1)
				perror("Shell Program error");
    			else{
      			//	printf("Child returned status: %d\n",WEXITSTATUS(status));
		if (WIFEXITED(status))     /* process exited normally */
      			printf("child process exited with value %d\n", WEXITSTATUS(status));
     		else if (WIFSIGNALED(status))      /* child exited on a signal */
      			printf("child process exited due to signal %d\n", WTERMSIG(status));
     		else if (WIFSTOPPED(status))       /* child was stopped */
      			printf("child process was stopped by signal %d\n", WIFSTOPPED(status));
			}
		}
	}
}
