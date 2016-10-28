import socket
import sys

if __name__ == "__main__":
	# Create a server socket
	server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
	
	# Bind the socket to localhost on port 8000
	ip, port = '127.0.0.1', 8000
	server.bind((ip, port))
	
	# Start listening for connections.
	# Accept up to one connection
	print('Listening on port %i' % port)
	
	# Keep accepting messages from the client
	# so long as the client doesn't send 'exit'
	clientData = ''
	while(clientData.lower() != 'exit'):
		# Receive data from the client. Then Uppercase it
		clientData, clientAddress = server.recvfrom(2048)
		serverData = clientData.upper()
		print('Data received from Client: %s' % clientData)
		print('Data to send to Client:    %s' % serverData.upper())
		# Send back the modified data
		server.sendto(serverData, clientAddress)
		
	# Close the socket and release the resources
	# clientAddress.close()
print('Connection closed by client.\nBye!')