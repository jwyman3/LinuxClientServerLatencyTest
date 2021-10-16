# LinuxClientServerLatencyTest
<p> Server: A single-threaded program that waits for a connection on port 2020 and recieves a int numbet coresponding to an operation to perform</p>
<p> Client: A multi-threaded program that creates a connection on port 2020 and a specified IP address with the server program. This program creates multiple running instances to test the response time of a server that is flooded with connections. In this case the connection is used to run a Linux command and record the total execution time of each thread, the total overall time, and the average execution time </p>
