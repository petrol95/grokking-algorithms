package JAXB;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "tiger")
public class Animal {
    @XmlElement(name = "catname")
    public String name;
    @XmlAttribute(name = "a")
    public int age;
    @XmlAttribute(name = "w")
    public int weight;

    public Animal() {
    }
}
