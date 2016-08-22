CC=gcc
CFLAGS=-g
OBJ=csc60mshell.o
EXE=crash

all: $(EXE)
$(EXE): $(OBJ)
	$(CC) $(OBJ) -o $(EXE)
csc60mshell.o: csc60mshell.c
	$(CC) $(CFLAGS) -c csc60mshell.c $(CFLAGS)
clean:
	rm $(OBJ)
debug:
	gdb $(EXE)
run:
	./$(EXE)
