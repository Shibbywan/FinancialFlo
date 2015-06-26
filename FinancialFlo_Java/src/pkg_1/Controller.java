
package pkg_1;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;



public class Controller {
    private final Model model;
    private final GUI gui;
    private GetData getdata;
    
    public Controller(Model model, GUI gui, GetData getdata) {
        this.model = model;
        this.gui = gui;
        this.getdata = getdata;
    }
    
    public void getCompany(String name) throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
        if (this.model.getMap().contains(name)) {
            model.addToMap(name, this.getdata.requestData(name));
        } else {
            System.out.println("The Company does not exist\n");
        }
    }
}
