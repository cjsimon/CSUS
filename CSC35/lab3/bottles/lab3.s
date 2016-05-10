.data
bottles:
	.ascii " bottles"
bottlesLength:
	.long 8

bottle:
	.ascii " bottle"
bottleLength:
	.long 7

verse:
	.ascii " of beer. Take one down!\n"
verseLength:
	.long 25

none:
	.ascii "No more bottles of beer!"
noneLength:
	.long 24

count:
	.long 99

.text

.include "ascii-int.asm"

.global _start

_start:
	mov count, %eax				# Start with $99 bottles

	Do:							# Main Do loop
		mov %eax, count			# Store the number of bottles in count as PrintInt uses %eax
		call PrintInt			# Call the PrintInt subroutine from ascii-int.asm
		
		cmp $1, %eax
		jg Bottles
		je Bottle
	
	ShouldMinus:				# Print the next verse and then subtract one if necessary
		mov $4, %eax
		mov $1, %ebx
		mov $verse, %ecx
		mov verseLength, %edx
		int $0x80

		mov count, %eax			# Resotre the count

		cmp $1, %eax			# Compare $1 to %eax which has the number of bottles
		jg Minus				# Jump to Minus if greater than $1
		je End					# Jump to End if equal to $1


	Bottles:					# Print bottles
		mov $4, %eax			# $4 Print
		mov $1, %ebx			# $1 To Screen
		mov $bottles, %ecx		# message	
		mov bottlesLength, %edx	# messageLength
		int $0x80
		jmp ShouldMinus			# Go back to ShouldMinus as a part of Do
		
	Bottle:						# Print bottle
		mov $4, %eax			# $4 Print
		mov $1, %ebx			# $1 To Screen
		mov $bottle, %ecx		# message	
		mov bottleLength, %edx	# messageLength
		int $0x80
		jmp ShouldMinus			# Go back to ShouldMinus


	Minus:						# Subtraction loop
		sub $1, %eax			# Subtract $1 from the bottle count
		jmp Do					# Jump back to Do from the beginning

	End:						# End program loop
		mov $4, %eax
		mov $1, %ebx
		mov $none, %ecx
		mov noneLength, %edx
		int $0x80				# Print end message

		mov $1, %eax			# $1 Terminate Program
		int $0x80				# Call Linux
