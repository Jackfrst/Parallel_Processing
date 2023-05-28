import java.net.*;
import java.io.*;
import com.sun.net.httpserver.*;

public class server{

    public static int a = 0;
    public static int b = 0;
    public static int result = 0;

    public static void main(String[] args) throws Exception{
        HttpServer ob = HttpServer.create(new InetSocketAddress(8000),0);
        ob.createContext("/a",new aHandler());
        ob.createContext("/b",new bHandler());
        ob.createContext("/result",new resultHandler());
        ob.createContext("/info",new infoHandler());
        ob.createContext("/name",new nameHandler());
        ob.createContext("/id",new idHandler());
        ob.setExecutor(null);
        ob.start();
    }
    
    static class aHandler implements HttpHandler{
        public void handle(HttpExchange t) throws IOException{
            a = Integer.parseInt(t.getRequestURI().getQuery());
            String s1 = "a = " + a;
            t.sendResponseHeaders(200,s1.length());
            OutputStream  os = t.getResponseBody();
            os.write(s1.getBytes());
            os.close();
        }
    }

    static class bHandler implements HttpHandler{
        public void handle(HttpExchange t) throws IOException{
            b = Integer.parseInt(t.getRequestURI().getQuery());
            String s1 = "b = " + b;
            t.sendResponseHeaders(200,s1.length());
            OutputStream  os = t.getResponseBody();
            os.write(s1.getBytes());
            os.close();
        }
    }

    static class resultHandler implements HttpHandler{
        public void handle(HttpExchange t) throws IOException{
            int result = a + b;
            String s1 = "a + b = " + result ;
            t.sendResponseHeaders(200,s1.length());
            OutputStream  os = t.getResponseBody();
            os.write(s1.getBytes());
            os.close();
        }
    }

    static class infoHandler implements HttpHandler{
        public void handle(HttpExchange t) throws IOException{
            byte [] res  = "<h1>This is a info Handeler </h1>".getBytes();
            t.sendResponseHeaders(200,res.length);
            OutputStream  os = t.getResponseBody();
            os.write(res);
            os.close();
        }
    }

    static class nameHandler implements HttpHandler{
        public void handle(HttpExchange t) throws IOException{
            byte [] res  = "<h1>Arnob</h1>".getBytes();
            t.sendResponseHeaders(200,res.length);
            OutputStream  os = t.getResponseBody();
            os.write(res);
            os.close();
        }
    }
    
    static class idHandler implements HttpHandler{
        public void handle(HttpExchange t) throws IOException{
            byte [] res  = "<h1>192311014</h1>".getBytes();
            t.sendResponseHeaders(200,res.length);
            OutputStream  os = t.getResponseBody();
            os.write(res);
            os.close();
        }
    }
}