import java.io.*;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;

public class http {
    public static void main(String[] args) throws Exception {
        HttpServer ob = HttpServer.create(new InetSocketAddress(800), 0);
        ob.createContext("/name", new nameHandler());
        ob.createContext("/id", new idHandler());
        ob.setExecutor(null);
        ob.start();
    }

    static class nameHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange arg0) throws IOException {
            byte[] res = "<h1 style=\"color:red\">MD.Mahfujur Rahman</h1>".getBytes();
            arg0.sendResponseHeaders(200, res.length);
            OutputStream os = arg0.getResponseBody();
            os.write(res);
            os.close();
        }
    }

    static class idHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange arg0) throws IOException {
            byte[] res = "<h1 style=\"color:red\">192311014</h1>".getBytes();
            arg0.sendResponseHeaders(200, res.length);
            OutputStream os = arg0.getResponseBody();
            os.write(res);
            os.close();
        }
    }
}