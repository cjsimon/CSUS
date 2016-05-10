.data
	question1:
		.ascii "What is your name?\n"
	question2:
		.ascii "What is your favorite animal?\n"
	question3:
		.ascii "What is your favorite day of the week?\n"
		
	message1:
		.ascii " ate their "
	message2:
		.ascii " on "
	newLine:
		.ascii "\n"
			
	input1:
		.space 100
	input2:
		.space 100
	input3:
		.space 100
	
	inputLength1:
		.long 0
	inputLength2:
		.long 0
	inputLength3:
		.long 0
.text
.global _start

_start:
	# question1
	mov $4, %eax
	mov $1, %ebx
	mov $question1, %ecx
	mov $19, %edx
	int $0x80
	
	# input1
	mov $3, %eax		# Prepare the read data to be placed in %eax. UNIX returns the number of bytes
	mov $0, %ebx		# Read from the keyboard. %ebx = Source of input
	mov $input1, %ecx	# Store the input data address (denoted $) into %ecx. %ecx = data address
	mov $100, %edx		# Store long 100 into %edx as a buffer. %edx = the max bytes stored for the message
	int $0x80			# Call linux to run the commands
	
	# Remove the enter key appended to the input on submission
	sub $1, %eax
	mov %eax, inputLength1
	
	# question2
	mov $4, %eax
	mov $1, %ebx
	mov $question2, %ecx
	mov $30, %edx
	int $0x80
	
	# input2
	mov $3, %eax
	mov $0, %ebx
	mov $input2, %ecx
	mov $100, %edx
	int $0x80
	
	sub $1, %eax
	mov %eax, inputLength2
	
	# question3
	mov $4, %eax
	mov $1, %ebx
	mov $question3, %ecx
	mov $39, %edx
	int $0x80
	
	sub $1, %eax
	mov %eax, inputLength3
	
	# input3
	mov $3, %eax
	mov $0, %ebx
	mov $input3, %ecx
	mov $100, %edx
	int $0x80
	
	sub $1, %eax
	mov %eax, inputLength3
	
	# Print the whole message
	# input1
	mov $4, %eax
	mov $1, %ebx
	mov $input1, %ecx
	mov inputLength1, %edx
	int $0x80
	
	# message1
	mov $4, %eax
	mov $1, %ebx
	mov $message1, %ecx
	mov $11, %edx
	int $0x80
	
	# input2
	mov $4, %eax
	mov $1, %ebx
	mov $input2, %ecx
	mov inputLength2, %edx
	int $0x80
	
	# message2
	mov $4, %eax
	mov $1, %ebx
	mov $message2, %ecx
	mov $4, %edx
	int $0x80
	
	# input3
	mov $4, %eax
	mov $1, %ebx
	mov $input3, %ecx
	mov inputLength3, %edx
	int $0x80
	
	# New Line
	mov $4, %eax
	mov $1, %ebx
	mov $newLine, %ecx
	mov $1, %edx
	int $0x80
	
	# Terminate the program
	mov $1, %eax
	int $0x80
	