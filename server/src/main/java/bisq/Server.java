package bisq;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    public static void main(String[] args) {
        new Server().run();
    }

    @Override
    public void run() {
        try {
            int port = 9999;
            ServerSocket socket = new ServerSocket(port);
            System.out.println("listening on port " + port);
            Socket s = socket.accept();
            OutputStream out = s.getOutputStream();
            out.write(new byte[]{'4', '2', '\n'});
            out.flush();
            System.out.println("exiting");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}