package pkg_1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Kevin
 */
public class Model {
    private final Map <String, Company> companyMap;
    private  Map <String, String> companyNames;
    
    public Model(TreeMap<String, Company> companyMap) throws IOException{
        this.companyMap = companyMap;
        loadCompanyNames();
    }
    
    public Set <String> getMap() {
        return this.companyMap.keySet();
    }
    
    public void addToMap(String name, Company k) {
        this.companyMap.put(name, k);
    }
    
    private void loadCompanyNames() throws FileNotFoundException, IOException {
        this.companyNames = new TreeMap();
        FileInputStream fstream1 = new FileInputStream("all.txt");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
        String line;
        
        while ((line = br1.readLine()) != null) {
            line = line.replaceAll("\\s+"," ");
            companyNames.put(line.substring(0,line.indexOf(" ")), line.substring(line.indexOf(" ")+1));
        }
        br1.close();
    }
    public Set<String> getSymbols() {
        return this.companyNames.keySet();
    }
    
    
    public Map<String, String> getCompanyMap() {
        return this.companyNames;
    }
}
