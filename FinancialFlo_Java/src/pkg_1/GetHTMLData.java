
package pkg_1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.ccil.cowan.tagsoup.jaxp.SAXParserImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;
/**
 *
 * @author Kevin
 */
public class GetHTMLData {
    public void getData() throws SAXException, IOException {
         /*SAXParserImpl.newInstance(null).parse(
            new URL("https://finance.yahoo.com/q/ks?s=KMB").openConnection().getInputStream(),
            new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName,
                                         String name, Attributes a)
                {
       
}
             if (name.equalsIgnoreCase("td"))
                        System.out.println(a.getValue("yfnc_tablehead1"));
                }
            }
        );
    }*/
        File fout = new File("data.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        Document doc = (Document) Jsoup.connect("https://finance.yahoo.com/q/ks?s=KMB").get();
        Elements ps = (Elements) doc.select("tbody");
        for (Element p : ps) {
            bw.write(p.toString());
            bw.newLine();
        }
        System.out.println(Jsoup.parse(ps.toString()).text());
    }
}
