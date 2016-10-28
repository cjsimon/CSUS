import sys
import socket
import select

if __name__ == '__main__':
	host = '127.0.0.1'
	port = 9754
	
	# Create a client socket
	client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	client.settimeout(2)
	
	# Try to connect the client to the server
	try:
		client.connect((host, port))
		print('Connected!')
		sys.stdout.write('Client: '); sys.stdout.flush()
	except:
		print('Error: Unable to connect to the host!')
		sys.exit()
		
	while True:
		clientIn = [sys.stdin, client]

		# Get the client file descriptors
		socketsOut, socketsIn, socketsError = select.select(clientIn , [], [])

		for sock in socketsOut:
			# Get data from the server when looking at the server
			# file descriptor, which the client is connected to
			if sock == client:
				# Get the data from the server	
				serverData = sock.recv(1024)
				if not serverData:
					# If there is no server data, assume that
					# client has disconnected from the server
					print '\nDisconnected from chat server'
					sys.exit()
				else:
					# Write the data from the server to stdout
					sys.stdout.write(serverData)
					sys.stdout.write('Client: '); sys.stdout.flush()
			else:
				# On every other iteration, besides when a message is being
				# recieved from the server, allow the client to type in and
				# send a message to the server
				clientData = sys.stdin.readline()
				if clientData.lower() == 'exit':
					break
				# Send the clientData to the server
				client.send(clientData)
				sys.stdout.write('Client: '); sys.stdout.flush()
	sys.exit()
