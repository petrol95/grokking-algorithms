import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

public class StudentErrorHandler extends DefaultHandler {
    private Logger logger = Logger.getLogger("valid");

    public StudentErrorHandler (String log) throws IOException {
        logger.addAppender(new FileAppender(new SimpleLayout(), log));
    }

    public void warning(SAXParseException e) {
        logger.warn(getLineAddress(e) + "-" + e.getMessage());
    }

    public void error(SAXParseException e) {
        logger.warn(getLineAddress(e) + "-" + e.getMessage());
    }

    public void fatalError(SAXParseException e) {
        logger.warn(getLineAddress(e) + "-" + e.getMessage());
    }

    private String getLineAddress(SAXParseException e) {
        // define error row and column
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
