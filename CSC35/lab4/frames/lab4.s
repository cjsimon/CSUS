.data
# The message
message:
	.ascii "What do you want to say: "
messageLength:
	.long 25
message1:
	.ascii "You said: "
message1Length:
	.long 10

# The response
response:
	.space 100
responseLength:
	.long 0

.text

.global _start
_start:

	# Display the message
	mov $message, %ecx
	mov messageLength, %edx
	call printText

	# Prompt for a response
	mov $response, %ecx
	mov $100, %edx
	call readText

	sub $1, %eax
	# Move the length to the resposeLength
	mov %eax, responseLength

	mov $message1, %ecx
	mov message1Length, %edx
	call printText

	mov $response, %ecx
	mov responseLength, %edx
	call printText
	
	# End
	call end

# Subroutines for reading and writing text
printText:
	mov $4, %eax
	mov $1, %ebx
	int $0x80
	ret

readText:
	mov $3, %eax
	mov $0, %ebx
	int $0x80
	ret
end:
	mov $1, %eax
	int $0x80
