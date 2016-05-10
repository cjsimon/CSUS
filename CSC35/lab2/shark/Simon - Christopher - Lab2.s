# Lab2 - Christopher Simon
.data

# Inputs
excuse:
	# 100 char buffer
	.space 100
excuseLength:
	# Long int with init val of 0
	.long 0

bs:
	.space 100
bsLength:
	.long 0


# Messages
message:
	.ascii "What is your excuse? "
messageLength:
	.long 21

nextTime:
	.ascii "...and next time? "
nextTimeLength:
	.long 18

leftShark:
	.ascii "Left shark blames "
leftSharkLength:
	.long 18

will:
	.ascii " and now will "
willLength:
	.long 14


.text
.global _start

_start:
	# Print "What is your excuse? "
	mov $4, %eax			# Store the unix command $4 into %eax. $4 = Unix write command
	mov $1, %ebx			# %ebx = Specify location. $1 = Screen
	mov $message, %ecx		# Message address ($) to write into %ecx. %ecx is read by UNIX
	mov messageLength, %edx	# Store the messageLength. %edx is the number of bytes to write from the buffer. Can be part of the buffer
	int $0x80

	# Get keyboard input for excuse
	mov $3, %eax			# Prepare the read data to be placed in %eax. UNIX returns the number of bytes
	mov $0, %ebx			# Read from the keyboard. %ebx = Source of input
	mov $excuse, %ecx		# Store the input data address ($) into %ecx. %ecx = data address
	mov $100, %edx			# Store long 100 into %edx as a buffer. %edx = the max bytes stored for the message
	int $0x80				# Call Linux

	sub $1, %eax			# Subtract 1 from %eax, the excuseLength. This will in turn remove the '\n' char
	mov %eax, excuseLength	# Store the length from %eax into excuseLength
	
	# Print "And now? "
	mov $4, %eax
	mov $1, %ebx
	mov $nextTime, %ecx
	mov nextTimeLength, %edx
	int $0x80

	# Get keyboard input for bs
	mov $3, %eax
	mov $0, %ebx
	mov $bs, %ecx
	mov $100, %edx
	int $0x80
	
	sub $1, %eax		# Subtract 1 from %eax, the bsLength
	mov %eax, bsLength	# Store %eax in bsLength. Since we subtracted 1, the last char, '\n' will not be included when writing to the screen


	# Print the message
	# Left Shark
	mov $4, %eax
	mov $1, %ebx
	mov $leftShark, %ecx
	mov leftSharkLength, %edx
	int $0x80

	# Excuse Message
	mov $4, %eax
	mov $1, %ebx
	mov $excuse, %ecx
	mov excuseLength, %edx
	int $0x80
	
	# " and now will "
	mov $4, %eax
	mov $1, %ebx
	mov $will, %ecx
	mov willLength, %edx
	int $0x80

	# BS Message
	mov $4, %eax
	mov $1, %ebx
	mov $bs, %ecx
	mov bsLength, %edx
	int $0x80

	# Terminate the program
	mov $1, %eax
	int $0x80
