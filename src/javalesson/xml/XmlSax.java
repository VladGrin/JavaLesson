package javalesson.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XmlSax {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
        DefaultHandler handler = new DefaultHandler(){
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                super.startElement(uri, localName, qName, attributes);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String str = "";
                for (int i = 0; i < length; i++) {
                    str += ch[start + i];
                }
                System.out.println(str);
            }
        };

//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = factory.newSAXParser();
//        parser.parse(new File("pom.xml"), handler);

        XMLInputFactory factory1 = XMLInputFactory.newInstance();
        XMLStreamReader parse1 = factory1.createXMLStreamReader(new FileInputStream("pom.xml"));
        while(parse1.hasNext()){
            int event = parse1.next();
            if (event == XMLStreamConstants.START_ELEMENT){
                System.out.println(parse1.getLocalName());
            }
        }
    }
}
