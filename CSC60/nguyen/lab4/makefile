CC=gcc
CFLAGS=-g
OBJ=csc60mshell.o
EXE:csc60mshell

all: $(EXE)
$(EXE): $(OBJ)
	$(CC) $(OBJ) -o $(EXE)
csc60mshell.o: csc60mshell.c
	$(CC) $(CFLAGS) -c csc60mshell.c
clear:
	rm $(OBJ)
