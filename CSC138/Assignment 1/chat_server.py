import socket
import select

# Broadcasts data to all other connected clients in the server,
# not including the broadcasting client
def broadcast(broadcastingClient, data):
	for client in clients:
		# Do not broadcast the data to the server
		# or the broadcasting client itself
		if client == broadcastingClient:
			continue
		try:
			# Send data to the current client
			client.send(data)
		except:
			# If there is an error, close the current client
			# and remove it from the list. It was probably disconnected
			client.close()
			clients.remove(client)
 
if __name__ == '__main__': 
	# The list of connected clients, including the server
	clients = []
	
	# 0.0.0.0 is both localhost and the ip of the computer
	ip = '0.0.0.0'
	port = 8001
	
	# Create a server socket
	server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	
	# Bind the socket to the ip of the server
	server.bind((ip, port))
	
	# Listen for up to 10 client connections
	server.listen(10)
	
	# Add the server to the list of clients
	clients.append(server)
	print("Listening on port %i" % port)
	
	# Keep the server running...
	while True:
		# Get the list of file descriptors for each of the sockets
		# select gets the read, write, and error file descriptors
		socketsOut, socketsIn, socketsError = select.select(clients, [], [])
		
		# Check for new connections
		client, clientAddress = server.accept()
		clients.append(client)
		print "Client Connected: (%s, %s)" % clientAddress
		broadcast(client, "Client has entered room: (%s:%s)\n" % clientAddress)
		
		for socket in socketsOut:
			try:
				# Get data from the current client socket
				data = socket.recv(4096)
				# If any data was received, broadcast it to all other clients
				if data:
					broadcast(socket, '\r%s: %s' % str(socket.getpeername()), data)
			except:
				disconnectMessage = "Client (%s, %s) has disconnected" % clientAddress
				# Indicate that the client has been disconnected
				broadcast(socket, disconnectMessage)
				print(disconnectMessage)
				# Close the client connection and remove it from the list of connected clients
				socket.close()
				clients.remove(socket)
				# This client no longer exists. Goto the next one
				continue
	server.close()