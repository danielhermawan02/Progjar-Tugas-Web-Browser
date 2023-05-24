package tugas1;

import java.io.*;
import java.net.*;

public class OpenWebPage {
    public static void main(String[] args) {
        String url = "monta.if.its.ac.id";
        String path = "/index.php/berita/lihatBerita";
        int port = 80;

        try {
            Socket socket = new Socket(url, port);

            // send HTTP request
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("GET " + path +  " HTTP/1.1");
            writer.println("Host: " + url);
            writer.println("Connection: close");
            writer.println();

            // read HTTP response
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuffer response = new StringBuffer();
            
            String line = reader.readLine();
            while (line != null && line.length() > 0) {
                line = reader.readLine();
            }

//            String line;
            while ((line = reader.readLine()) != null) {
//            	response.append("---------------------------------------------------------------------\n");
                response.append(line + "\n");
            }

            // Require .toString() because response is not a String but StringBuffer
            System.out.println(response.toString());

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}