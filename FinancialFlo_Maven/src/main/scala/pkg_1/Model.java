package pkg_1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import static scala.Console.println;

/**
 *
 * @author Kevin
 */
public class Model {

    private final Map<String, Company> companyMap;
    private Map<String, String> companyNames;

    public Model(TreeMap<String, Company> companyMap) throws IOException {
        this.companyMap = companyMap;

    }

    public Set<String> getMap() {
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

    public Company getCompany(String name) throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
        GetHTMLData k = new GetHTMLData();
        Company c = k.getData(name);
        return c;
    }

    public String getMarketShare(Company c) throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
        String marketShare;
        Double rev = 0.0;
        List<String> compet = c.getCompetitors();
        List<Company> temp = new ArrayList<>();
        for (int i = 0; i < compet.size(); i++) {
            temp.add(getCompany(compet.get(i).trim()));
        }
        temp.add(c);
        double sum = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        List<Double> revenues = new ArrayList<>();
        for (Company k : temp) {
            String t = k.revenue;
            if (t.contains("B")) {
                t = t.replace("B", "");
                double d = Double.parseDouble(t);
                d = d * 1000000000;
                revenues.add(d);
            }
            if (t.contains("M")) {
                t = t.replace("M", "");
                double d = Double.parseDouble(t);
                d = d * 1000000;
                revenues.add(d);
            }
        }
        String t = c.revenue;
        if (t.contains("B")) {
            t = t.replace("B", "");
            double d = Double.parseDouble(t);
            d = d * 1000000000;
            rev = Double.parseDouble(df.format(d));
        }
        if (t.contains("M")) {
            t = t.replace("M", "");
            double d = Double.parseDouble(t);
            d = d * 1000000;
            rev = Double.parseDouble(df.format(d));
            
        }
        println(rev);
        for (int i = 0; i < revenues.size(); i++) {
            sum += revenues.get(i);
        }
        println(sum);
        double k = Double.parseDouble(df.format((rev / sum)));
        println(k);
        marketShare = Double.toString(k);
        return marketShare;
    }
}
