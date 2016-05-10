# lab1.s
# Christopher Simon
#
# 1. assemble : as -o lab1.o lab1.s
# 2. link	  : ld -o lab1.out lab1.o
# 3. execute  : lab1.out

.data						# Data section containing storage
message:					# 'Message' is an address constant
	.ascii "Hello World!\n"	# Create a buffer with ASCII chars
message1:
	.ascii "My name is Christopher Simon!\n"
message2:
	.ascii "\"We must embrace pain and burn it as fuel for our journey\"\n"

length:
	.long 13	# Create space to store integers
length1:
	.long 30
length2:
	.long 59

.text			# Text/code section is the program
.global _start	# Start at the address in '_start'

_start:
	mov $4, %eax		# Linux command: 4 = write
	mov $1, %ebx		# Linux command: write target is the screen
	mov $message, %ecx	# Message is the ADDRESS of the buffer
	mov length, %edx	# Total number of bytes to write stored in edx
	int $0x80			# Call linux which reacts to this interupt

	mov $4, %eax		# Linux command: 4 = write
	mov $1, %ebx		# linux command: write target is the screen
	mov $message1, %ecx	# Message is the ADDRESS of the buffer
	mov length1, %edx	# Total number of bytes to write stored in edx
	int $0x80			# Call linux which reacts to this interupt

	mov $4, %eax		# Linux command: 4 = write
	mov $1, %ebx		# Linux command: write target is the screen
	mov $message2, %ecx	# Message is the ADDRESS of the buffer
	mov length2, %edx	# Total number of bytes to write stored in edx
	int $0x80			# Call linux which reacts to this interupt

	mov $1, %eax		# Linux command: end the program
	int $0x80			# Call linux
