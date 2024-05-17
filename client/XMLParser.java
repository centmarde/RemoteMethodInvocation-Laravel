import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XMLParser {

  protected Document parseXML(String filePath) {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(filePath);
      document.getDocumentElement().normalize();
      return document;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
