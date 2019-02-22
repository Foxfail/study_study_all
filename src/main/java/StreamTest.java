import java.io.*;

public class StreamTest {

    static String filename = "C:\\Users\\VDorofeyev\\file.txt";

    public static void main(String[] args) throws IOException {
        String s[] = new String[1];
        try {
            args[5] = "sttt";
            System.out.println("attr хранится в args[0]");
        } catch (Exception e) {
            String a[] = new String[1];
            a[0] = "attr";
        } finally {
            System.out.println("attr хранится в a[0]");
        }
    }

    private static void readFile() throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        System.out.println(line);
    }

    private static void createFile() {
        String text = "adsfasdfasd%";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            byte[] bytes = text.getBytes();
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFile2() throws IOException {
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("line");
            bufferedWriter.close();
    }



}
