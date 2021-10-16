import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args){
        String[] opcode = {"(0. Date & Time)", "(1. Uptime)", "(2. Memory Use)", "(3. Netstat)" ,"(4.Current Users)" ,"(5. Running Processes)"};
        int operation;

        try(ServerSocket serversocket = new ServerSocket(2020)){

            while(true){
                Socket socket = serversocket.accept();
                System.out.println("New Connection");

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                operation = reader.read();
                System.out.println(operation);
                dowork(operation);

            }
        }catch(IOException ex){
            System.out.println("Server Exception :(" + ex.getMessage());
        }
    }

public static void dowork(int commandno){
    String s = null;
    String[] cmd = {"date", "uptime -p", "free -m", "netstat -1", "users", "ps aux"}; // Need to test current users command

    System.out.println(cmd[commandno]);
    try {
        Process p = Runtime.getRuntime().exec(cmd[commandno]);

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        while((s = stdInput.readLine()) != null){
            System.out.println(s);
        }
    }catch(IOException e){
        System.out.println("Exception Happened at Processing Command");
        e.printStackTrace();
        //System.exit(-1);
    }
}
}
