package server;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static int PORT = 5050;

    public static void main(String[] args) throws IOException, InterruptedException { // запустим пул нитей в которых колличество возможных нитей ограничено -
        // 10-ю.
        System.out.println("Server started");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            // стартуем цикл в котором с паузой в 10 милисекунд стартуем Runnable
            // клиентов,
            // которые пишут какое-то количество сообщений
            while (true) {
                Socket socket =  serverSocket.accept();

                 Thread thread =  new Thread(new TestRunnableClientTester(socket));
                 thread.start();
            }


        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }


}


