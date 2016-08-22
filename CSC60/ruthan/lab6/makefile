# The C Compiler
# If using C++ set this to g++
CC=gcc
# The compiler flags
# -g adds debugging information to the executable file
# -Wall turns on most, but not all, compiler warnings
CFLAGS=-g -Wall -O3
LIBS=-lm
# The associated object files that are compiled to form the main program
OBJ=main.o radius_inside_circle.o radius_outside_circle.o semi_perimeter.o
# The name of the executable to generate from the object files
EXE=lab6
# The output file created upon running the exe
OUT=lab6.out

all: $(EXE)
	@printf %"s\n" "" "$(EXE) sucessfully compiled!" "Type 'make run' to execute the program"
$(EXE): $(OBJ)
	@# Compile all object files that make up the exe
	$(CC) -o $(EXE) $(OBJ) $(LIBS)
main.o: main.c lab6.h
	@# Create an object file from the header and c file
	$(CC) $(CFLAGS) -c $<
radius_inside_circle.o: radius_inside_circle.c lab6.h
	@# The $< is a variable containing the c file
	$(CC) $(CFLAGS) -c $<
radius_outside_circle.o: radius_outside_circle.c lab6.h
	$(CC) $(CFLAGS) -c $<
semi_perimeter.o: semi_perimeter.c lab6.h
	$(CC) $(CFLAGS) -c $<
run:
	@# Only run the $(EXE) if it exists
ifeq ("$(wildcard $(EXE))", "")
	@printf %"s\n" "The $(EXE) file does not exist!" "Type 'make' or 'make all' to generate an executable"
else
	@printf %"s\n" "Running $(EXE)"
	@./$(EXE)
	@printf %"s\n" "Finished Running!" "Type 'make view' to view the generated $(OUT) file"
endif
edit:
	@cat "main.c"
view:
	@# Only allow the output to be viewed if the output file exists, else indicate that it must be created first
	@# Makefile conditionals must not be indented, otherwise they are interpreted as shell commands
	@# Check if the path of the output file is empty
ifeq ("$(wildcard $(OUT))", "")
	@printf %"s\n" "The $(OUT) file does not exist!" "Type 'make run' or './$(EXE)' to generate an output file"
else
	@# The output exists, so display it
	@cat lab6.out
endif
clean:
	@printf %"s\n" "The following files were removed: " "Objects:    $(OBJ)" "Output:     $(OUT)" "Executable: $(EXE)"
	@$(RM) $(OBJ) $(OUT) *~ $(EXE)