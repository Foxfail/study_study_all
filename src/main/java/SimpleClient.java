import java.io.FileOutputStream;
import java.net.Socket;

public class SimpleClient {
    public static void main(String args[])
    {
        for (int i = 1; i < 10; i++) {
            new SimpleClient(i);
        }
    }

    public SimpleClient(int i) {
        try
        {
            String[] dataArray =new String[1];
            dataArray[0] = "Client" + i;
            // открываем сокет и коннектимся к localhost:3128
            // получаем сокет сервера
            Socket socket = new Socket("localhost", 3128);

            // берём поток вывода и выводим туда первый аргумент
            // заданный при вызове, адрес открытого сокета и его порт
            dataArray[0] = dataArray[0]+"\n"+
                    socket.getInetAddress().getHostAddress()
                    +":"+socket.getLocalPort();
            socket.getOutputStream().write(dataArray[0].getBytes());



            // читаем ответ
            byte buf[] = new byte[64*1024]; // 65536
            int r = socket.getInputStream().read(buf);
            String data = new String(buf, 0, r);

            // выводим ответ в консоль
            System.out.println();
            System.out.println(data);
            System.out.println();
        }
        catch(Exception e){
            System.out.println("init error: "+e); // вывод исключений
            e.printStackTrace();
        }
    }
}
