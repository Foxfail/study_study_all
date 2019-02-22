import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
//        String host = "127.0.0.1";
//
//        byte[] addr = {127, 123,0,2};
//        InetAddress serverhost = InetAddress.getByAddress(addr);
//        int port = 65111;
//        ServerSocket serverSocket = new ServerSocket(port,0, serverhost);
//        Socket socket = new Socket(serverhost, port);
//        socket.close();
//
//
//        byte b = (byte) 128; // 0-255
//        System.out.println(b & 0xFF);
//        System.out.println(b);


        byte b = 0;
        System.out.println(Integer.toBinaryString((b & 0xFF) + 0x100).substring(1));
    }
}