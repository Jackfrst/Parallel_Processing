import java.io.*;
import java.net.*;

public class client{
    public static void main(String[] args){
        try{
            Socket s = new Socket("localhost",6666);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("Hello");
            dos.flush();
            dos.close();
            s.close();
        }
        catch(Exception exception_message){
            System.out.println(exception_message);
        }
    }

}