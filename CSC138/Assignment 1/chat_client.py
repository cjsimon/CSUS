import sys
import socket
import select

if __name__ == '__main__':
	host = '127.0.0.1'
	port = 8001
	
	# Create a client socket
	client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	client.settimeout(2)
	
	# Try to connect the client to the server
	try:
		client.connect((host, port))
	except:
		print('Error: Unable to connect to the host!')
		sys.exit()
		
	print('Connected!')
	#sys.stdout.write('[Me] '); sys.stdout.flush()
	
	while True:
		clientIn = [sys.stdin, client]

		# Get the client file descriptors
		socketsOut, socketsIn, socketsError = select.select(clientIn , [], [])

		for sock in socketOut:
			if sock == client:
				# incoming message from remote server, s
				data = sock.recv(4096)
				if not data :
					print '\nDisconnected from chat server'
					sys.exit()
				else:
					sys.stdout.write(data)
					sys.stdout.write('[Me] '); sys.stdout.flush()
			else:
				# user entered a message
				msg = sys.stdin.readline()
				if msg == 'exit':
					sys.exit('EXIT TYPED')
				client.send(msg)
				sys.stdout.write('[Me] '); sys.stdout.flush()
	sys.exit()