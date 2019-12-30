import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class ValidatorSAX {
    public static void main(String[] args) {

        String filename = "xml/students/students.xml";
        String schemaname = "xml/students/students.xsd";
        String logname = "xml/students/log/log.txt";

//        String filename = "xml/estate/estate.xml";
//        String schemaname = "xml/estate/estate.xsd";
//        String logname = "xml/estate/log/log.txt";

//        String filename = "xml/simple/simple.xml";
//        String schemaname = "xml/simple/simple.xsd";
//        String logname = "xml/simple/log/log.txt";

        Schema schema = null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            // checking using XSD
            schema = factory.newSchema(new File(schemaname));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            // creating an parser object
            SAXParser parser = spf.newSAXParser();
            // error handling and launching
            parser.parse(filename, new ErrorHandler(logname));
            System.out.println(filename + " is valid");
        } catch (ParserConfigurationException e) {
            System.err.println(filename + " config error: " + e.getMessage());
        } catch (SAXException e) {
            System.err.println(filename + " SAX error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
