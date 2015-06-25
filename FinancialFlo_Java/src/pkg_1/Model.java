package pkg_1;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Kevin
 */
public class Model {
    private final Map <String, Company> companyMap;
    
    public Model(TreeMap<String, Company> companyMap){
        this.companyMap = companyMap;
    }
    
    public Set <String> getMap() {
        return this.companyMap.keySet();
    }
    
    public void addToMap(String name, Company k) {
        this.companyMap.put(name, k);
    }
}
