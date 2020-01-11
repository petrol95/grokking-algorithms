package JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class ZooSerialization {

    public static void main(String[] args) throws JAXBException {
        // creating objects Animal & Zoo  for XML serialization
        Animal cat = new Animal();
        cat.name = "Fluffy";
        cat.age = 10;
        cat.weight = 6;

        Zoo zoo = new Zoo();
        zoo.animals.add(cat);
        zoo.animals.add(cat);

        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(Animal.class, Zoo.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // serialization
        marshaller.marshal(zoo, writer);

        System.out.println(writer.toString());
    }
}

