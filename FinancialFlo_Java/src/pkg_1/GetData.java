package pkg_1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Kevin
 */
public class GetData {
    private final String s1 = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22";
    private final String s2 = "%22)&env=store://datatables.org/alltableswithkeys";
    public GetData() {

    }
    
    private void requestData(String name) throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        URL url = new URL(s1 + name + s2);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");
        
        InputStream xml = connection.getInputStream();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = (Document) db.parse(xml);
        
        doc.get
        
    }
}
