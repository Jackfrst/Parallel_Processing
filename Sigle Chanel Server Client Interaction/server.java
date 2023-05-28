import java.io.*;
import java.net.*;

public class server{
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String message = (String) dis.readUTF();
            System.out.println(message);
            dis.close();
            ss.close();
        }
        catch(Exception exception_message){
            System.out.println(exception_message);
        }
    }
}