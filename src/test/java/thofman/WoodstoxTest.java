package thofman;

import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.junit.Assert;
import org.junit.Test;

public class WoodstoxTest {

    @Test
    public void testStreamReader() throws FileNotFoundException, XMLStreamException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("data.xml");
        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(is);
        while (reader.hasNext()) {
            if (reader.getEventType() == XMLStreamConstants.START_ELEMENT
                    && "body".equals(reader.getLocalName())) {
                reader.next();
                reader.next();
                String characters = new String(reader.getTextCharacters(), reader.getTextStart(), reader.getTextLength());
                System.out.println(characters.length());
                Assert.assertEquals(540, characters.length());
            }
            reader.next();
        }
    }
}
