package JAXB;

import javax.naming.StringRefAddr;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Serialization {

    public static void main(String[] args) throws JAXBException {
        // creating an object for XML serialization
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        StringWriter writer = new StringWriter();

        JAXBContext contextWriter = JAXBContext.newInstance(Cat.class);
        Marshaller marshaller = contextWriter.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // serialization
        marshaller.marshal(cat, writer);

        String result = writer.toString();
        System.out.println(result);

        // deserialization
        String xmldata = "<cat><name>Barsik</name><age>3</age><weight>2</weight></cat>";
        StringReader reader = new StringReader(xmldata);

        JAXBContext contextReader = JAXBContext.newInstance(Cat.class);
        Unmarshaller unmarshaller = contextReader.createUnmarshaller();

        Cat catReader = (Cat) unmarshaller.unmarshal(reader);
        System.out.println(catReader);
    }
}
