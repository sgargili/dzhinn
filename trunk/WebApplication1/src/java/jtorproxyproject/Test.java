/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtorproxyproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Test {

    public static void whois(String query, String server) throws IOException {
        Socket sock = new Socket(server, 9051);
        int c = 0;
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
        wr.write(query);
        wr.flush();

        BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        String str;
        while ((str = rd.readLine()) != null) {
            System.out.println(str);
        }
        rd.close();
        wr.close();
    }

    public static void main(String[] args) throws Exception {
        String hostname = "127.0.0.1";
        whois("authenticate\r\n", hostname);
        whois("", hostname);
        whois("\r\nsignal newnym", hostname);
    }
}


