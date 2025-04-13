import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server{

    public Consumer<Socket>getConsumer(){
        // return new Consumer<Socket>() {
        //     @Override
        //      public void accept(Socket clienSocket){

        //     }
        // };
        return (clientSocket)->{
            try{
                PrintWriter toClient=new PrintWriter(clientSocket.getOutputStream());
                toClient.println("hello from the server");
                toClient.close();
                clientSocket.close();
            }catch(IOException ex){
                ex.printStackTrace();

            }
            
        };
    }
    public static void main(String[] args){
        int port=8010;
        Server server=new Server();
        try{
            ServerSocket serverSocket=new ServerSocket(port);
            serverSocket.setSoTimeout(100000);
            System.out.println("Server is listening on the port "+port);
            while(true){
                Socket acceptedSocket=serverSocket.accept();
                Thread thread=new Thread(()->server.getConsumer().accept(acceptedSocket));
                thread.start();
            }

        }catch(IOException ex){
            ex.printStackTrace();

        }
    

    }
}