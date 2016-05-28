package pkg_1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Kevin
 */
public class Model {
    private final Map <String, Company> companyMap;
    private  Map <String, String> companyNames;
    
    public Model(TreeMap<String, Company> companyMap) throws IOException{
        this.companyMap = companyMap;

    }
    
    public Set <String> getMap() {
        return this.companyMap.keySet();
    }

    
    public void addToMap(String name, Company k) {
        this.companyMap.put(name, k);
        this.companyNames.put(name, k.getCompanyName());
    }
    

    public Set<String> getSymbols() {
        return this.companyNames.keySet();
    }
    
    
    public Map<String, String> getCompanyMap() {
        return this.companyNames;
    }
}
