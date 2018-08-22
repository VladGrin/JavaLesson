package javalesson.jaxbexample;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class JAXBWriter {
    public static void main(String[] args) throws JAXBException {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Vlad");
        customer.setAge(39);

        JAXBContext context = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(customer, new File("myxml.xml"));
        marshaller.marshal(customer, System.out);
    }
}
