/*************************************************************************\
 *                  Copyright (C) Michael Kerrisk, 2014.                   *
 *                                                                         *
 * This program is free software. You may use, modify, and redistribute it *
 * under the terms of the GNU General Public License as published by the   *
 * Free Software Foundation, either version 3 or (at your option) any      *
 * later version. This program is distributed without any warranty.  See   *
 * the file COPYING.gpl-v3 for details.                                    *
* \*************************************************************************/

#define _BSD_SOURCE // Get major() and minor() from <sys/types.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <time.h>
#include <grp.h>
#include <pwd.h>
#include "file_perms.h"
#include "tlpi_hdr.h"

static void displayStatInfo(const struct stat *sb, char *fileName) {
	//printf("Size: %lld\t\t", (long long) sb->st_size);
 	//printf("Blocks: %lld\t", sb->st_blocks);
 	//printf("I/O block: %ld ", (long) sb->st_blksize);
	
	/*
    printf(
		"Device containing i-node: major=%ld   minor=%ld\n",
		(long) major(sb->st_dev), (long) minor(sb->st_dev)
	);
	*/
	
	/*
    printf(
		"Mode:                     (%lo/-%s)\n",
		(unsigned long) sb->st_mode, filePermStr(sb->st_mode, 0)
	);
	*/

	/*
    printf(
    	"Ownership:                UID=%ld   GID=%ld\n",
		(long)sb->st_uid, (long)sb->st_gid
	);
	*/

	if(sb->st_mode & (S_ISUID | S_ISGID | S_ISVTX)) {
		printf(
			"Special bits set:     %s%s%s\n",
			(sb->st_mode & S_ISUID) ? "set-UID " : "",
			(sb->st_mode & S_ISGID) ? "set-GID " : "",
			(sb->st_mode & S_ISVTX) ? "sticky " : ""
		);
	}
	
	if(S_ISCHR(sb->st_mode) || S_ISBLK(sb->st_mode)) {
		printf(
			"Device number (st_rdev):  major=%ld; minor=%ld\n",
			(long)major(sb->st_rdev), (long) minor(sb->st_rdev)
		);
	}
	
	// File and Size Blocks IO Block
	printf(
		"  File: '%s'\n  Size: %lld            Blocks: %lld            IO Block: %ld ",
		fileName,
		(long long) sb->st_size,
		(long long)sb->st_blocks,
		(long)sb->st_blksize
	);
	// Filetype
	switch (sb->st_mode & S_IFMT) {
 		case S_IFREG:  printf("regular file\n");            break;
 		case S_IFDIR:  printf("directory\n");               break;
 		case S_IFCHR:  printf("character device\n");        break;
 		case S_IFBLK:  printf("block device\n");            break;
 		case S_IFLNK:  printf("symbolic (soft) link\n");    break;
 		case S_IFIFO:  printf("FIFO or pipe\n");            break;
 		case S_IFSOCK: printf("socket\n");                  break;
 		default:       printf("unknown file type?\n");      break;
 	}
 	
	// Device and Inode
 	printf(
	 	"Device: %lxh/%ldd   Inode: %ld   Links: %ld\n",
	 	(long)sb->st_dev,
	 	(long)sb->st_dev,
		(long) sb->st_ino,
		(long)sb->st_nlink
	);
	
	// Access Uid and Gid
	// See: http://linux.die.net/man/3/getpwuid for details
	// getpwuid returns a passwd struct based on the passed user id
	struct passwd *pwd; pwd = getpwuid(sb->st_uid);
	// getgrgid returns a group struct based on the passed group id
	struct group *gp; gp = getgrgid(sb->st_gid);
	
	printf(
		"Access: (%4o/%s%s) Uid: (%ld/%s) Gid: (%ld/%s)\n",
		sb->st_mode & 007777, //Bitshift the  //(unsigned long) sb->st_mode,
		((S_ISDIR(sb->st_mode)) ? "d" : "-"), // Check if it is a dir and change the 
		filePermStr(sb->st_mode, 0),
		// Get the uid and gid from the respective structs
		// Note that sb->st_uid and sb->gid also contain these values
		// See: http://linux.die.net/man/3/getpwuid for details
		(long)pwd->pw_uid,
		pwd->pw_name,
		(long)gp->gr_gid,
		gp->gr_name
	);

	// Print the access modify and change times
	char buf[200];
	strftime(buf, sizeof(buf), "Access: %Y-%m-%d %T %z\n", localtime(&sb->st_atime));
	printf("%s", buf);

	buf[200];
	strftime(buf, sizeof(buf), "Modify: %Y-%m-%d %T %z\n", localtime(&sb->st_mtime));
	printf("%s", buf);

	buf[200];
	strftime(buf, sizeof(buf), "Change: %Y-%m-%d %T %z\n", localtime(&sb->st_ctime));
	printf("%s", buf);

	/*	
	printf("Last file access:         %s", ctime(&sb->st_atime));
	printf("Last file modification:   %s", ctime(&sb->st_mtime));
	printf("Last status change:       %s", ctime(&sb->st_ctime));
	*/
}

int main(int argc, char *argv[]) {
	struct stat sb;
    Boolean statLink;           /* True if "-l" specified (i.e., use lstat) */
    int fname;                  /* Location of filename argument in argv[] */
	
	// Check if -l was specified. Does the first argument equal "-l"?
	statLink = (argc > 1) && strcmp(argv[1], "-l") == 0;
	// If the -l was specified, then the file name is argument 2. Otherwise it is 1.
	fname = statLink ? 2 : 1;

	// Has a file been specified?
	if(fname >= argc || (argc > 1 && strcmp(argv[1], "--help") == 0)) {
		// A file has not been specified. Throw an error
		usageErr(
			"%s [-l] file\n"
			"l = use lstat() instead of stat()\n", argv[0]
		);
	}

	// If -l was specified
	if(statLink) {
		// Run and also check the error status of lstat.
		// -1 indicates that an error occurred while running lstat given the filename
		// 0 means successful run 
		if(lstat(argv[fname], &sb) == -1)
			errExit("lstat");
	} else {
		// Otherwise run and also check the error status of stat(fname)
		if(stat(argv[fname], &sb) == -1)
			errExit("stat");
	}

	// Get the info for the specified file including it's name
	// using our custom csc60 stat command
	displayStatInfo(&sb, argv[fname]);
	
	// Exit with exit success int code, which is typically 0
	exit(EXIT_SUCCESS);
}