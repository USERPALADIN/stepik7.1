package server;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class TestRunnableClientTester extends Thread {

    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public TestRunnableClientTester(Socket socket) {
        try {
            this.socket = socket;
            // создаём сокет общения на стороне клиента в конструкторе объекта

            System.out.println("Client connected to socket");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            while (true) {
                String str = in.readLine();
                if (str.equals("Bue."))
                    break;
                out.println(str);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

