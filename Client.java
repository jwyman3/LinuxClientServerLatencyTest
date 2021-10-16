import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.Scanner;

public class Client extends Thread{
    int port = 2020;
   static int operation = 0;

    public static void main(String[] args){
        String ip;
        long beg;
        long fin;
        long length;
        long average;
        int clientno = 0;
        int i;
        String[] opcode = {"(0. Date & Time)", "(1. Uptime)", "(2. Memory Use)", "(3. Netstat)" ,"(4.Current Users)" ,"(5. Running Processes)"};

        Scanner in = new Scanner(System.in);

        System.out.println("What ip address are you connecting to?");
            ip = in.next();
        System.out.println("How many clients?");
            clientno = in.nextInt();
        System.out.println("Operations:");
        for(i = 0; i < 6; i++){
            System.out.print(opcode[i]);
        }
        System.out.println("\nWhich operation would you like to perform? (Enter a Number)");
            operation = in.nextInt();

        System.out.println("Operation Selected:" + opcode[operation]);

            beg = System.currentTimeMillis();
            for(i = 0; i < clientno; i++){
                Client thread = new Client();
                thread.run(ip);
            }
            fin = System.currentTimeMillis();
            length = fin - beg;
            average = length / clientno;
            System.out.println("Total Execution Time: " + length + "ms");
            System.out.println("Average Execution Time: " + average + "ms");
    }

    public void run(String ip){
        long beg;
        long fin;
        long length;
        beg = System.currentTimeMillis();
        try (Socket socket = new Socket(ip, port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            output.write(operation);
            output.flush();
            output.close();

            String hey = reader.readLine();

            socket.close();

        } catch (IOException ex) {
          //  System.out.println("Socket Creation Error");
        }
        fin = System.currentTimeMillis();
        length = fin - beg;
        System.out.println("Thread Execution Time: " + length + "ms");
    }
}
