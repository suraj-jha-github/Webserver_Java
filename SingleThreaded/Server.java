// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.PrintWriter;
// import java.net.ServerSocket;
// import java.net.Socket;
// import java.net.SocketTimeoutException;

// public class Server {

//     public void run() throws IOException {
//         int port = 8010;
//         ServerSocket socket = new ServerSocket(port);
//         socket.setSoTimeout(10000); // ✅ Corrected line

//         while (true) {
//             try {
//                 System.out.println("Server is listening on port " + port);
//                 Socket acceptedConnection = socket.accept();
//                 System.out.println("Connection accepted from the client " + acceptedConnection.getRemoteSocketAddress());

//                 PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true);
//                 BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));

//                 toClient.println("Hello from the server");

//                 // Optional: read response from client
//                 String line = fromClient.readLine();
//                 System.out.println("Client says: " + line);

//                 acceptedConnection.close(); // Close after single exchange
//             } catch (SocketTimeoutException ste) {
//                 System.out.println("No client connected within the timeout period.");
//             } catch (IOException ex) {
//                 ex.printStackTrace();
//             }
//         }
//     }

//     public static void main(String[] args) {
//         Server server = new Server();
//         try {
//             server.run();
//         } catch (Exception ex) {
//             ex.printStackTrace();
//         }
//     }
// }



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    public void run() throws IOException {
        int port =8010;
        ServerSocket socket=new ServerSocket(port);
        socket.setSoTimeout(10000);

        while(true){
            try{System.out.println("Server is listening on port "+ port);
            Socket acceptedConnection=socket.accept();
            System.out.println("Cnnection accepted from the client"+acceptedConnection.getRemoteSocketAddress());
            PrintWriter toClient =new PrintWriter(acceptedConnection.getOutputStream());
            BufferedReader fromClient=new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
            toClient.println("hello from the server");
            toClient.close();
            fromClient.close();
            acceptedConnection.close();
        }catch(IOException ex){
            ex.printStackTrace();

        }

        }
        
    }
    public static void main(String[] args){
        Server server=new Server();
        try{
            server.run();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}