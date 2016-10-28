import socket
import sys

if __name__ == "__main__":
	# Create a client socket    
	client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
	
	# Bind the socket to localhost on port 8000
	ip, port = '127.0.0.1', 8000
	
	# Allow the client to send and recieve messages
	# to and from the server so long as the client
	# doesn't send 'exit'
	clientData = ''
	while(clientData.lower() != 'exit'):
		clientData = raw_input('Type a message to send to the server: ')
		client.sendto(clientData, (ip, port))
		
		# Get the responce data from the server 
		serverData, serverAddress = client.recvfrom(1024)
		print('Server Response: %s' % serverData)
	
	client.close()
print('Connection Terminated.\nBye!')