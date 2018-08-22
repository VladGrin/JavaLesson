package javalesson.jaxbexample;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBReader {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Customer.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Customer customer = (Customer) unmarshaller.unmarshal(new File("myxml.xml"));
        System.out.println(customer.getId());
        System.out.println(customer.getName());
        System.out.println(customer.getAge());
    }
}
