package pkg_1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public Company getCompany(String name) throws IOException, MalformedURLException, ParserConfigurationException, SAXException, ClassNotFoundException, SQLException {
        GetHTMLData k = new GetHTMLData();
        Company c = k.getData(name.trim());
        return c;
    }
    public int getDailyAsk(Connection con, int bound) throws SQLException, IOException, MalformedURLException, ParserConfigurationException, SAXException, ClassNotFoundException {
        int response = 0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String queryString = "Select symbol from company where id BETWEEN " + Integer.toString(bound - 200) + " , " + Integer.toString(bound);
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(queryString);
        while (rs.next()) {
            Company k = getCompany(rs.getString("symbol").trim());
            String queryColumn = "Alter Table company Add " + dateFormat.format(date);
            String queryInsert = "Update company Set " + dateFormat.format(date) + " = " + k.ask;
            statement.executeQuery(queryColumn);
            statement.executeQuery(queryInsert);
        }
        return response;
    }
    
    public String getMarketShare(Company c) throws IOException, MalformedURLException, ParserConfigurationException, SAXException, ClassNotFoundException, SQLException {
        //change to sum of all market share in database
        String marketShare = "";
        Double rev = 0.0;
        List<String> compet = c.getCompetitors();
        List<Company> temp = new ArrayList<>();
        for (int i = 0; i < compet.size(); i++) {
            String k = compet.get(i).trim();
            if (!k.equals("")) {
                temp.add(getCompany(k));
            }
        }
        temp.add(c);
        double sum = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        List<Double> revenues = new ArrayList<>();
        if (temp.size() > 1) {
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
                if (t.contains("T")) {
                    t = t.replace("T", "");
                    double d = Double.parseDouble(t);
                    d = d * 1000000;
                    rev = Double.parseDouble(df.format(d));
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
            if (t.contains("T")) {
                t = t.replace("T", "");
                double d = Double.parseDouble(t);
                d = d * 1000000;
                rev = Double.parseDouble(df.format(d));
            }
            for (int i = 0; i < revenues.size(); i++) {
                sum += revenues.get(i);
            }
            double k = Double.parseDouble(df.format((rev / sum)));
            marketShare = Double.toString(k);
        }
        return marketShare;
    }



    public String getCompanyName(Connection con, String symbol) throws SQLException {
        String companyName = "";
        String queryString = "SELECT name FROM company WHERE symbol LIKE '" + symbol.trim() + "'";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(queryString);
        while (rs.next()) {
            companyName = rs.getString("name").trim();
        }
        return companyName;
    }
    

    public int getAndInsertData(Connection con, int bound) throws SQLException, IOException, MalformedURLException, ParserConfigurationException, SAXException, ClassNotFoundException {
        int keystats = 0;
        int id = bound;
        String queryString = "Select symbol from company where id BETWEEN " + Integer.toString(id) + " AND " + Integer.toString(id + 200);
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(queryString);
        Double rev = 0.0;
        DecimalFormat df = new DecimalFormat("#.##");
        while (rs.next()) {
            Company k = getCompany(rs.getString("symbol").trim());
            String t = k.revenue;
            String marketCap = k.getMarketCap();
            String enterpriseValue = k.getEnterpriseValue();
            String trailingPE = k.getTrailingPE();
            String priceSales = k.getPriceSales();
            String priceBook = k.getPriceBook();
            String enterpriseValueRevenue = k.getEnterpriseValueRevenue();
            String enterpriseValueEBITDA = k.getEnterpriseValueEBIDTA();
            String revenuePerShare = k.getRevenuePerShare();
            String qtrlyRevenueGrowth = k.getQtrlyRevenueGrowth();
            String grossProfit = k.getGrossProfit();
            String ebitda = k.getEBITDA();
            String netIncomeAvl = k.getnetIncomeAvlToCommon();
            String dilutedEPS = k.getdilutedEPS();
            String totalCash = k.gettotalCash();
            String totalCashPerShare = k.gettotalCashPerShare();
            String totalDebt = k.getTotalDebt();
            String totalDebtEquity = k.getTotalDebtEquity();
            String currentRatio = k.getCurrentRatio();
            String bookValuePerShare = k.getBookValuePerShare();
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
            if (t.contains("T")) {
                t = t.replace("T", "");
                double d = Double.parseDouble(t);
                d = d * 1000000;
                rev = Double.parseDouble(df.format(d));
            }
            if (t.contains("K")) {
                t = t.replace("K", "");
                double d = Double.parseDouble(t);
                d = d * 1000;
                rev = Double.parseDouble(df.format(d));
            }

            if (t.equals("") || t.equals(null)) {
                rev = 0.0;
            }
            if (rev != 0.0)
                keystats = 1;
            
            String queryInsert = "Update company Set qtrly_revenue = " + rev + ",market_cap = '" + marketCap + "',enterprise_value = '" + enterpriseValue +
                    "' , trailing_pe = '" + trailingPE + "', price_sales = '" + priceSales + "', price_book = '" + priceBook + "', enterprise_value_revenue = '" +
                    enterpriseValueRevenue + "', enterprise_value_ebitda = '" + enterpriseValueEBITDA + "', revenue_per_share = '" + revenuePerShare + 
                    "', qtrly_revenue_growth = '" + qtrlyRevenueGrowth + "', gross_profit = '" + grossProfit + "', ebitda = '" + ebitda + "', net_income_avl_to_common = '" +
                    netIncomeAvl + "' , diluted_eps = '" + dilutedEPS + "' , total_cash = '" + totalCash + "' , total_cash_per_share = '" + totalCashPerShare +
                    "', total_debt = '" + totalDebt + "', total_debt_equity = '" + totalDebtEquity + "', current_ratio = '" + currentRatio + 
                    "', book_value_per_share = '" + bookValuePerShare + "', keystats = " + keystats + " WHERE id = " + Integer.toString(id);
            println(queryInsert);
            Statement tempStatement = con.createStatement();
            tempStatement.executeUpdate(queryInsert);
            id++;
        }
        return id;
    }

}
