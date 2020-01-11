package JAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "zoo")
@XmlRootElement
public class Zoo {
    @XmlElementWrapper(name = "wild-animals", nillable = true)
    @XmlElement(name = "tiger")
    public List<Animal> animals = new ArrayList<>();

    public Zoo() {
    }
}
