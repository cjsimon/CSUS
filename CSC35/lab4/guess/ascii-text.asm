# Prints text to the screen
# @Params:
# %eax: The text to print
# %ebx: The length of the text
PrintText:
	push %eax
	push %ebx
	
	mov $4, %eax
	mov $1, %ebx
	int $0x80
	
	pop %ebx
	pop %eax
	ret

# Reads text from the keyboard
# @Params:
# %ecx: The address to store the input
# %edx: The number of bytes to read off of the buffer
# @Returns:
# %eax: The length of the input returned in %ecx
ReadText:
	push %eax
	push %ebx
	
	mov $3, %eax
	mov $0, %ebx
	int $0x80
	
	pop %ebx
	pop %eax
	ret
