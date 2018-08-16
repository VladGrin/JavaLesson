package javalesson.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlDomXPath {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("pom.xml"));

        Element element = document.getDocumentElement();
//        System.out.println(element.getTagName());
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element){
                System.out.println(nodeList.item(i));
            }
        }
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element){
                System.out.println(((Element) nodeList.item(i)).getTagName());
            }
        }
        System.out.println("------------------------------------------------------------");
        printElements(element.getChildNodes());
    }
    static void printElements(NodeList nodeList){
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element){
                String value = "";
                if(!nodeList.item(i).getTextContent().trim().isEmpty() &&
                        !((Text)nodeList.item(i).getFirstChild()).getData().trim().isEmpty() &&
                        !((Text)nodeList.item(i).getFirstChild()).getData().trim().equals("\n")
                        ){
                    Text text = (Text)nodeList.item(i).getFirstChild();
                    value += text.getData().trim();
                }
                System.out.println(((Element) nodeList.item(i)).getTagName());
                System.out.println(value);
                if(((Element) nodeList.item(i)).hasAttribute("artifactId")){
                    System.out.println(((Element) nodeList.item(i)).getAttribute("artifactId"));
                }
                if (nodeList.item(i).hasChildNodes()){
                    printElements(nodeList.item(i).getChildNodes());
                }
            }
        }
    }
}
