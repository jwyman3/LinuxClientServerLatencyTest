# LinuxClientServerLatencyTest
<p> Server: A single-threaded program that waits for a connection on port 2020 and recieves a int numbet coresponding to an operation to perform</p>
<p> Client: A multi-threaded program that creates a connection on port 2020 and a specified IP address with the server program. This program creates multiple running instances to test the response time of a server that is flooded with connections. In this case the connection is used to run a Linux command and record the total execution time of each thread, the total overall time, and the average execution time </p>
<p> How to run Server: Navigate to directory that the Server.class file exists in a terminal Window. Execute command 'java Server.class' NOTE: Server.class will only work in a Linux environment. When a command is recieved from the Client then the therminal window will distplay a message for each client connection. </p>
<p> How to run Client: Navigate to directory that the Client.class file exists in a terminal Window. Execute command 'java Server.class'. Input the IP address of the server host. Input how many clients/threads you would like to create. Input the number corresponding to the command you would like to perform. </p> 
