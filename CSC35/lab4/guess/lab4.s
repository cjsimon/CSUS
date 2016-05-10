.data
	message: 				.ascii	"Random Number Generator\n"
	messageLength:			.long	24
	
	randomNumber:			.long	0

	prompt:					.ascii	"Select your difficulty (1-5): "
	promptLength:			.long 	31
	promptError:			.ascii	"Please select a number between 1 and 5!\n"
	promptErrorLength:		.long	41
	
	gamePick:				.ascii	"Pick a number between "
	gamePickLength:			.long 	22
	gameErrorStart:			.ascii	"Please select a number between "
	gameErrorStartLength:	.long	30
	gameErrorEnd:			.ascii	"!\n"
	gameErrorEndLength:		.long	2
	gameAnd:				.ascii	" and "
	gameAndLength:			.long	5
	gameColon:				.ascii	": "
	gameColonLength:		.long	2
	gameHigher:				.ascii	"Guess Higher!\n"
	gameHigherLength:		.long	14
	gameLower:				.ascii	"Guess Lower!\n"
	gameLowerLength:		.long	13
	gameWinner:				.ascii	"Congratulations!\nIt took you "
	gameWinnerLength:		.long	29
	gameTries:				.ascii	" tries!\n"
	gameTriesLength:		.long	8
	
	question: 				.ascii	"Would you like to play again? "
	questionLength:			.long	30
	questionError: 			.ascii	"Please type in either 'Yes' or 'No'\n"
	questionErrorLength:	.long	36
	answer:					.space	2
	answerLength:			.long	0
	
	enter:					.ascii	"\n"
	enterLength:			.long	1
	
	exit:					.ascii	"Thanks for playing! Good Bye!\n"
	exitLength:				.long	30
	
	clear:					.ascii	"\x1B[H\x1B[2J"
	clearLength:			.long	11

.text
.include "ascii-int.asm"
.include "ascii-text.asm"

.globl main
	# Indicate that main is a function
	.type main,@function
	
main:
	# Clear the screen using a virtual terminal command
	mov $clear, %ecx
	mov clearLength, %edx
	call PrintText
	
	# Prompt for a difficulty from the user
	call PromptDifficulty
	
	# Calculate the range of numbers based on the input difficulty
	# The equation used to calculate the range is (10 ^ difficulty)
	#mov %eax, %ebx	# The user number, containing the exponent for %ebx
	#mov $10, %eax	# Use 10 as the base for %eax
	#call Pow
	call GetRange	# Replacement for calculating the range using the pow function
	mov %eax, %ebx	# The range of numbers for PlayGame
	
	# Generate a random number from the range of (1 to %eax)
	call RandomNumber
	
	# DEBUG: Print the random number
	#call PrintInt
	
	# Play the game with the given number to guess and range of numbers
	call PlayGame
	
	# Prompt for another game
	call Prompt
	
	# Terminate the program by returning from main.
	# This instruction is a replacement for invoking
	# an interrupt call for termination.
	# This only works if the main method was invoked
	# by a caller. If there is no caller, an unknown return
	# address will be used and result in a segmentation fault
	#ret
	# Therefore terminating via an interrupt call is much safer
	call End

# Prompt the user for the difficulty
# @Returns:
# %eax: The input number (1 - 5)
PromptDifficulty:
	# Print the prompt message
	mov $prompt, %ecx
	mov promptLength, %edx
	call PrintText
	
	# Get the input number
	call ReadInt
	
	# Check if the input number is within the bounds of 1 - 5
	cmpl $1, %eax
	jl PromptDifficultyError
	cmpl $5, %eax
	jg PromptDifficultyError
	
	# Both bound tests passed
	ret
	
# The number is out of bounds
PromptDifficultyError:
	# Print a message indicating so
	mov $promptError, %ecx
	mov promptErrorLength, %edx
	call PrintText
	# Prompt again for a valid number
	call PromptDifficulty

# Calculates the power of an integer given a base and an exponent.
# As I couldn't figure out how to use FYL2X, I implemented this using
# a loop that multiplies the base (%eax) by itself, exponent (%ebx) number of times.
# @Params:
# %eax: Integer Base
# %ebx: Integer Exponent
# @Returns:
# %eax: Exponential Result
Pow:
	push %edi
	push %ecx
	push %edx
	mov %eax, %ecx
	cmp $0, %ebx	# Check if the exponent is zero
	je ZeroExp		# Base Case: Exponent is zero
	mov $1, %edi	# Not base case
	jmp Exp			
# Base Case: When the exponent is zero, return 1
ZeroExp:
	mov $1, %eax
	jmp ExpDone
Exp:
	cmp %ebx, %edi
	mul %ecx # The answer is stored as %edx and %eax, containing the higher and lower bytes respectively
	mov %edx, %eax
	inc %edi
	jl Exp
ExpDone:
	pop %edx
	pop %ecx
	pop %edi
	ret

# Hardcoded values for the range calculated based on the user input
# TODO: Replace with Pow subroutine once multiplication problem is fixed
GetRange:
	cmp $1, %eax
	je range1
	cmp $2, %eax
	je range2
	cmp $3, %eax
	je range3
	cmp $4, %eax
	je range4
	jg range5
range1:
	mov $10, %eax
	jmp GetRangeDone
range2:
	mov $100, %eax
	jmp GetRangeDone
range3:
	mov $1000, %eax
	jmp GetRangeDone
range4:
	mov $10000, %eax
	jmp GetRangeDone
range5:
	mov $100000, %eax
GetRangeDone:
	ret
	
# Generate a random number between 1 and %eax inclusive
# @Params:
# %eax: The upper bound
# @Returns:
# %eax: The random number
RandomNumber:
	push %ebx
	push %ecx
	push %edx
	
	# Mov the upper bound to the divisor
	mov %eax, %ebx
	
	# Get the time as the seed value
	push $0
	call time
	add $4, %esp
	
	# Generate a seed value
	push %eax
	call srand
	add $4, %esp
	# Generate a random number using the current seed value
	call rand
	
	# (C)alculate (D)ouble (Q)uad: makes %eax a quad, (64 bits)
	# so that a 32 bit integer is the output of division
	# as opposed to a 16 bit integer, since division cuts
	# the number of bytes of the quotient, %eax in half
	cdq
	# Divide %eax by %ebx
	# @Parameters:
	# %eax: Dividend: Randomly Generated Number
	# %ebx: Divisor:  Range calculated based on difficulty
	# @Returns:
	# %eax: Quotient
	# %edx: Remainder
	# 
	# Getting the remainder, or modulus, will
	# give a number in between 0 and the divisor-1.
	# Incrementing this result by 1 will give us a range
	# from 1 to the divisor, or 1 to %ebx.
	# 
	# The equation is as follows:
	# (%eax MOD %ebx) + 1
	div %ebx
	inc %edx
	# Return the number in %eax
	mov %edx, %eax
	
	pop %edx
	pop %ecx
	pop %ebx
	ret

# Plays the game given the number to guess and the range to guess that number from
# @Params:
# %eax: Number to Guess
# %ebx: Range to guess from
PlayGame:
	push %ebp			# Save the caller base pointer address location
	mov	 %esp, %ebp		# Set the base pointer to the current bottom of the stack, %esp
	# Local Variables
	push $1 			# -4(%ebp) : Lower Range Bound starting at 1
	push %ebx 			# -8(%ebp) : Upper Range Bound starting at the max range, %ebx
	push %eax 			# -12($ebp): The Number
	push $0				# -16($ebp): The count of how many tries
	
	pusha
	
GameLoop:
	# "Pick a number in between"
	mov $gamePick, %ecx
	mov gamePickLength, %edx
	call PrintText
	
	mov -4(%ebp), %eax
	mov -8(%ebp), %ebx
	call PrintRange
	
	mov $gameColon, %ecx
	mov gameColonLength, %edx
	call PrintText
	
	call ReadInt
	cmp -12(%ebp), %eax
	jl GameGuessHigher	# Guess Higher
	jg GameGuessLower	# Guess Lower
	je GameWinner		# Winner

GameGuessHigher:
	# Keep track of the tries. We need to indicate that we are incrementing a long
	incl -16(%ebp)
	# Higher!
	mov $gameHigher, %ecx
	mov gameHigherLength, %edx
	call PrintText
	# If the guess is higher than the lower bound, update the lower bound
	cmp -4(%ebp), %eax
	jg	GameUpdateLower
	jmp GameLoop
	
GameGuessLower:
	# Keep track of the tries. We need to indicate that we are incrementing a long
	incl -16(%ebp)
	# Lower!
	mov $gameLower, %ecx
	mov gameLowerLength, %edx
	call PrintText
	# If the guess is lower than the higher bound, update the higher bound
	cmp -8(%ebp), %eax
	jl	GameUpdateUpper
	jmp GameLoop

GameUpdateUpper:
	mov %eax, -8(%ebp)
	jmp GameLoop

GameUpdateLower:
	mov %eax, -4(%ebp)
	jmp GameLoop

GameWinner:
	# Winner
	mov $gameWinner, %ecx
	mov gameWinnerLength, %edx
	call PrintText
	
	mov -16(%ebp), %eax
	call PrintInt
	
	mov $gameTries, %ecx
	mov gameTriesLength, %edx
	call PrintText

GameEnd:
	popa
	mov %ebp, %esp		# Restore the stack pointer to the caller stack pointer, which is where the base pointer currently is
	pop %ebp			# Restore and essentially return to the address of the caller, where the original caller base pointer is
	ret

# Prints the sentence containing the range of numbers from %eax to %ebx
PrintRange:
	push %eax
	push %ebx
	push %ecx
	push %edx
	
	# Lower Bound
	call PrintInt
	
	# "and"
	mov $gameAnd, %ecx
	mov gameAndLength, %edx
	call PrintText
	
	# Upper Bound
	mov %ebx, %eax
	call PrintInt
	
	pop %edx
	pop %ecx
	pop %ebx
	pop %eax
	ret

# Prompt for a (y)es or (n)o answer given a question
# @Params:
# %eax: message
# %ebx: messageLength
# @Return:
# @TODO: Setup parameters for ascii address and length
Prompt:
	# Ask the question
	mov $question, %ecx
	mov questionLength, %edx
	call PrintText
	
	# Get the answer
	mov $answer, %ecx	# Store the input from the keyboard into the address of answer
	mov $100, %edx		# Read $100 bytes off of the buffer
	call ReadText
	sub $1, %eax
	mov %eax, answerLength
	
	# Check if the input $answer is valid
	# using the different methods of addressing for fun
	mov $0, %edi
	mov $answer, %eax
	cmpb $'y', answer(, %edi, 4)
	je main
	cmpb $'Y', (%eax, %edi)
	je main
	cmpb $'n', (%eax)
	je End
	cmpb $'N', answer(%edi)
	je End
	
	# The input was not 'y' or 'n'. Indicate so and ask the question again
	mov $questionError, %ecx
	mov questionErrorLength, %edx
	call PrintText
	jmp Prompt
	ret
	
End:
	# We don't really need to backup and restore the registers for this subroutine
	# because we terminate the application at this point, but it's safe to do so just in case
	push %eax
	push %ecx
	push %edx
	
	mov $exit, %ecx
	mov exitLength, %edx
	call PrintText
	mov $1, %eax
	int $0x80
	
	pop %edx
	pop %ecx
	pop %eax
	ret
	