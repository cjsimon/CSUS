.data
error: .ascii "Please enter 'Y' or 'N'\n"
errorLength: .long 24

question1: .ascii "Are you schizophrenic? "
questionLength1: .long 23

question2: .ascii "Do you desire to take over the world and all of humanity for no reason at all but for the sole purpose of pure evil? "
questionLength2: .long 117

question3: .ascii "Is your one purpose in life to collect the Blue Eyes White Dragon of the ultimate forbidden skies? "
questionLength3: .long 99

answer1: .space 2
answerLength1: .long 0
answer2: .space 2
answerLength2: .long 0
answer3: .space 2
answerLength3: .long 0

message1: .ascii "You must be... "
messageLength1: .long 15

person1: .ascii "Bakoura!\n"
personLength1: .long 9

person2: .ascii "Yugioh!\n"
personLength2: .long 8

person3: .ascii "Kaiba!\n"
personLength3: .long 7

person4: .ascii "Exodia, the almighty God of the forbidden one!\n"
personLength4: .long 47

.text

.global _start

_start:
q1:
	# Question 1
	mov $question1, %ecx		# Message address ($) to write into %ecx. %ecx is read by UNIX
	mov questionLength1, %edx	# Store the messageLength. %edx is the number of bytes to write from the buffer. Can be part of the buffer
	call PrintText
	
	mov $answer1, %ecx			# Store the input data address ($) into %ecx. %ecx = data address
	mov $2, %edx				# Store long 2 into %edx as a buffer. %edx = the max bytes stored for the message
	call ReadText
	
	sub $1, %eax				# Subtract 1 from %eax, the answerLength. This will in turn remove the '\n' char
	mov %eax, answerLength1		# Store the length from %eax into answerLength
	
	# Compare the input of answer1 to the ascii letter Y and N
	# which have respective ascii values of $89 and $78
	mov answer1, %al
	cmp $89, %al
	je q2						# Jump to question2 on Yes
	cmp $78, %al
	je q3						# Jump to question3 on No
	# If the input is anything else, indicate so and re-ask the question
	# Question 1
	mov $error, %ecx
	mov errorLength, %edx 
	call PrintText
	jmp q1

q2:
	# Question 2
	mov $question2, %ecx		# Message address ($) to write into %ecx. %ecx is read by UNIX
	mov questionLength2, %edx	# Store the messageLength. %edx is the number of bytes to write from the buffer. Can be part of the buffer
	call PrintText
	
	mov $answer2, %ecx			# Store the input data address ($) into %ecx. %ecx = data address
	mov $2, %edx				# Store long 2 into %edx as a buffer. %edx = the max bytes stored for the message
	call ReadText
	
	sub $1, %eax				# Subtract 1 from %eax, the answerLength. This will in turn remove the '\n' char
	mov %eax, answerLength2		# Store the length from %eax into answerLength
	
	# Compare the input of answer1 to the ascii letter Y and N
	# which have respective ascii values of $89 and $78
	mov answer2, %al
	cmp $89, %al
	je p1						# Jump to person1 on Yes
	cmp $78, %al
	je p2						# Jump to person2 on No
	# If the input is anything else, indicate so and re-ask the question
	mov $error, %ecx
	mov errorLength, %edx 
	call PrintText
	jmp q2
	
q3:
	# Question 3
	mov $question3, %ecx		# Message address ($) to write into %ecx. %ecx is read by UNIX
	mov questionLength3, %edx	# Store the messageLength. %edx is the number of bytes to write from the buffer. Can be part of the buffer
	call PrintText
	
	mov $answer3, %ecx			# Store the input data address ($) into %ecx. %ecx = data address
	mov $2, %edx				# Store long 2 into %edx as a buffer. %edx = the max bytes stored for the message
	call ReadText
	
	sub $1, %eax				# Subtract 1 from %eax, the answerLength. This will in turn remove the '\n' char
	mov %eax, answerLength3		# Store the length from %eax into answerLength
	
	# Compare the input of answer1 to the ascii letter Y and N
	# which have respective ascii values of $89 and $78
	mov answer3, %al
	cmp $89, %al
	je p3						# Jump to person1 on Yes
	cmp $78, %al
	je p4						# Jump to person2 on No
	# If the input is anything else, indicate so and re-ask the question
	mov $error, %ecx
	mov errorLength, %edx 
	call PrintText
	jmp q3

p1:
	mov $person1, %ecx
	mov personLength1, %edx
	Call PrintText
	Call Exit
p2:
	mov $person2, %ecx
	mov personLength2, %edx
	Call PrintText
	Call Exit
p3:
	mov $person3, %ecx
	mov personLength3, %edx
	Call PrintText
	Call Exit
p4:
	mov $person4, %ecx
	mov personLength4, %edx
	Call PrintText
	Call Exit

Exit:
	mov $1, %eax
	int $0x80

# Subroutines for reading and writing text
PrintText:
	mov $4, %eax
	mov $1, %ebx
	int $0x80
	ret

ReadText:
	mov $3, %eax
	mov $0, %ebx
	int $0x80
	ret
	