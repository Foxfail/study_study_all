import com.sun.org.apache.bcel.internal.classfile.ConstantUtf8;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class XmlTest {

    static String filename = "C:\\Users\\VDorofeyev\\file.png";

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("root");
        document.appendChild(root);


        // из файла в строку нулей и едениц
        File image = new File("C:\\Users\\VDorofeyev\\IdeaProjects\\socketstudy\\src\\main\\resources\\ruwiki-1.5x.png");
        byte[] fileContent = Files.readAllBytes(image.toPath());

        StringBuilder s = new StringBuilder();
        for (byte b : fileContent){
            s.append(Integer.toBinaryString((b & 0xFF) + 0x100).substring(1)).append("");
        }

        System.out.println(s);

        // из строки байтов разделенных пробелами в файл
//        String[] sar = s.toString().split(" ");
//        byte[] bytes = new byte[sar.length];
//        for (int i = 0; i < sar.length; i++) {
//            String e = sar[i];
//            bytes[i] = Byte.valueOf(e);
//        }
//
//        FileOutputStream fileOutputStream = new FileOutputStream(new File(filename));
//        fileOutputStream.write(bytes);


        // создание XML
//        Element element = document.createElement("element");
//        Text text = document.createTextNode(s);
//        element.appendChild(text);
//        root.appendChild(element);
//        Element element2 = document.createElement("element2");
//        Text text2 = document.createTextNode("zxzxzx");
//        element.appendChild(text2);
//        element.appendChild(element2);
//        root.appendChild(text2);
//
//
//        TransformerFactory transformerFactory = TransformerFactory.newInstance();
//        Transformer transformer = transformerFactory.newTransformer();
//        DOMSource domSource = new DOMSource(document);
//        StreamResult streamResult = new StreamResult(new File(filename));
//
//        transformer.transform(domSource, streamResult);
    }
}
