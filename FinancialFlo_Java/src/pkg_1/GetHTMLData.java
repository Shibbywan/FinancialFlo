
package pkg_1;
import java.io.IOException;
import java.net.URL;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.ccil.cowan.tagsoup.jaxp.SAXParserImpl;
import org.xml.sax.SAXException;
/**
 *
 * @author Kevin
 */
public class GetHTMLData {
    public void getData() throws SAXException, IOException {
         SAXParserImpl.newInstance(null).parse(
            new URL("https://finance.yahoo.com/q/ks?s=KMB").openConnection().getInputStream(),
            new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName,
                                         String name, Attributes a)
                {
                    if (name.equalsIgnoreCase("img"))
                        System.out.println(a.getValue("src"));
                }
            }
        );
    }
}
