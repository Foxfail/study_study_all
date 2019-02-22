import com.sun.org.apache.bcel.internal.classfile.ConstantUtf8;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class XmlTest {

    static String filename = "C:\\Users\\VDorofeyev\\file.png";
    static String imageFilePath = "C:\\Users\\VDorofeyev\\IdeaProjects\\socketstudy\\src\\main\\resources\\ruwiki-1.5x.png";

    public static void main(String[] args) {

    }

    /**
     * Создает файл XML по заданному пути
     * @param filepath - путь к результирующему XML-файлу
     */
    private void createXML(String filepath) throws ParserConfigurationException, TransformerException {
        // создаем объект документа
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        // корневой элемент
        Element root = document.createElement("root");
        document.appendChild(root);

        // элемент, который будет в корневом элементе
        Element element = document.createElement("element");
        Text text = document.createTextNode("text value");
        element.appendChild(text);
        root.appendChild(element);

        // подготавливаем к преобразованию объектов в файл
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(filepath));

        // преобразуем всё в файл
        transformer.transform(domSource, streamResult);
    }


    /**
     * Создает из строки байтов разделенных пробелами файл, по заданному пути
     * @param byteString - строка представляющая текстовые значения byte, разделенные пробелами вида "-16 120 -125 1"
     * @param filepath - путь к файлу задается строкой вида "C:\\Users\\image.png"
     */
    private void fromByteStringToFile(String byteString, String filepath) throws IOException {
        // Разбиваем строку на массив текстовых представлений байтов
        String[] byteStrings = byteString.split(" ");

        // Массив текстовых представлений байтов приводим к байтовому представлению
        byte[] bytes = new byte[byteStrings.length];
        for (int i = 0; i < byteStrings.length; i++) {
            String e = byteStrings[i];
            bytes[i] = Byte.valueOf(e);
        }

        // Записываем массив байтов в файл по указанному пути
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filepath));
        fileOutputStream.write(bytes);
    }

    /**
     * Выводит в консоль массив нулей и единиц, которые представляют байты файла переведенные в двоичное представление
     * @param filepath - путь до файла, который хотим увидеть в нулях и единицах
     */
    private void fileToBinaryString(String filepath) throws IOException {
        // Читаем файл в массив байтов
        File file = new File(filepath);
        byte[] fileContent = Files.readAllBytes(file.toPath());

        // Переводим массив байтов в строку нулей и единиц
        StringBuilder s = new StringBuilder();
        for (byte b : fileContent){
            // через преобразование в Integer, разделенные пробелами
            s.append(Integer.toBinaryString((b & 0xFF) + 0x100).substring(1)).append(" ");
        }

        // Выводим в консоль
        System.out.println(s);
    }
}
