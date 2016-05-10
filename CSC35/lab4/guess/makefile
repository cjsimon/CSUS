# Compile Assembly using GCC
GCC=gcc
GCCFLAGS=-Wall -O3 -m32
LINK=ld
ASM=as
ASMFILE=lab4.s
EXE=lab4

# Assemble and generate necessary links for the assembly file using gcc 
all: $(EXE)
$(EXE): $(ASMFILE)
	@# The @ Symbol is used for suppressing output to the screen
	$(GCC) $(GCCFLAGS) $(ASMFILE) -o $(EXE)
	@echo $(EXE) successfully compiled to assembly using $(GCC)!
clean:
	rm $(EXE)
