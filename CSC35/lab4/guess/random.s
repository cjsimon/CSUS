	.file	"random.c"
	.section	.rodata.str1.1,"aMS",@progbits,1
.LC0:
	.string	"%i\n"
	.text
	.p2align 4,,15
.globl main
	.type	main, @function
main:
	pushl	%ebp
	movl	%esp, %ebp
	andl	$-16, %esp
	subl	$16, %esp
	movl	$0, (%esp)
	call	time
	movl	%eax, (%esp)
	call	srand
	call	rand
	movl	$1374389535, %edx
	movl	$.LC0, (%esp)
	movl	%eax, %ecx
	imull	%edx
	movl	%ecx, %eax
	sarl	$31, %eax
	sarl	$5, %edx
	subl	%eax, %edx
	imull	$100, %edx, %edx
	subl	%edx, %ecx
	addl	$1, %ecx
	movl	%ecx, 4(%esp)
	call	printf
	xorl	%eax, %eax
	leave
	ret
	.size	main, .-main
	.ident	"GCC: (GNU) 4.4.7 20120313 (Red Hat 4.4.7-16)"
	.section	.note.GNU-stack,"",@progbits
