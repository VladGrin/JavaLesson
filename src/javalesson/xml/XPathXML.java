package javalesson.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class XPathXML {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("pom.xml"));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        System.out.println(xPath.evaluate("/project/dependencies/dependency/version", document));
        System.out.println(xPath.evaluate("/project/dependencies/dependency[2]/version", document));
        System.out.println(xPath.evaluate("count(/project/dependencies)", document));

        NodeList list = (NodeList) xPath.evaluate("/project/dependencies", document, XPathConstants.NODESET);
        Node node = (Node) xPath.evaluate("/project/dependencies/dependency[2]/version", document, XPathConstants.NODE);
        int count = ((Number)xPath.evaluate("/project/dependencies", document,XPathConstants.NUMBER)).intValue();

        for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i) instanceof Element){
                System.out.println(((Element) list.item(i)).getTagName());
            }
        }
        System.out.println(node);
        System.out.println(count);
    }
}
