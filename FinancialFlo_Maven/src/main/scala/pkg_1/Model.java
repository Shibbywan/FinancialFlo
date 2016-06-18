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
        String queryString = "Select symbol from company where id BETWEEN " + Integer.toString(bound - 200) + " AND " + Integer.toString(bound);
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
        println(symbol.trim());
        String queryString = "SELECT name FROM company WHERE symbol LIKE '" + symbol.trim() + "'";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(queryString);
        while (rs.next()) {
            companyName = rs.getString("name").trim();
        }
        return companyName;
    }
    

    public int getRevenue(Connection con, int bound) throws SQLException, IOException, MalformedURLException, ParserConfigurationException, SAXException, ClassNotFoundException {
        int response = 0;
        int keystats = 0;
        int id = bound - 199;
        String queryString = "Select symbol from company where id BETWEEN " + Integer.toString(id) + " AND " + Integer.toString(bound);
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(queryString);
        Double rev = 0.0;
        DecimalFormat df = new DecimalFormat("#.##");
        while (rs.next()) {
            Company k = getCompany(rs.getString("symbol").trim());
            String t = k.revenue;
            String marketCap = k.marketCap;
            String enterpriseValue = k.enterpriseValue;
            String trailingPE = k.trailingPE;
            String priceSales = k.priceSales;
            String priceBook = k.priceBook;
            String enterpriseValueRevenue = k.enterpriseValue;
            String enterpriseValueEBITDA = k.enterpriseValueEBITDA;
            String revenuePerShare = k.revenuePerShare;
            String qtrlyRevenueGrowth = k.qtrlyRevenueGrowth;
            String grossProfit = k.grossProfit;
            String ebitda = k.ebitda;
            String netIncomeAvl = k.netIncomeAvlToCommon;
            String dilutedEPS = k.dilutedEPS;
            String totalCash = k.totalCash;
            String totalCashPerShare = k.totalCashPerShare;
            String totalDebt = k.totalDebt;
            String totalDebtEquity = k.totalDebtEquity;
            String currentRatio = k.currentRatio;
            String bookValuePerShare = k.bookValuePerShare;
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

            if (t.equals("")) {
                rev = 0.0;
            }
            if (!marketCap.equals(""))
                keystats = 1;
            
            String queryInsert = "Update company Set qtrly_revenue = " + rev + " AND market_cap = '" + marketCap + "' AND enterprise_value = '" + enterpriseValue +
                    "' AND trailing_pe = '" + trailingPE + "' AND price_sales = '" + priceSales + "' AND price_book = '" + priceBook + "' AND enterprise_value_revenue = '" +
                    enterpriseValueRevenue + "' AND enterprise_value_ebitda = '" + enterpriseValueEBITDA + "' AND revenue_per_share = '" + revenuePerShare + 
                    "' AND qtrly_revenue_growth = '" + qtrlyRevenueGrowth + "' AND gross_profit = '" + grossProfit + "' AND ebitda = '" + ebitda + "' AND net_income_avl_to_common = '" +
                    netIncomeAvl + " AND diluted_eps = " + dilutedEPS + " AND total_cash = " + totalCash + " AND total_cash_per_share = " + totalCashPerShare +
                    "' AND total_debt = '" + totalDebt + "' AND total_debt_equity = '" + totalDebtEquity + "' AND current_ratio = '" + currentRatio + 
                    "' AND book_value_per_share = '" + bookValuePerShare + "' AND keystats = " + keystats + " WHERE id = " + Integer.toString(id);
            Statement tempStatement = con.createStatement();
            tempStatement.executeUpdate(queryInsert);
            id++;
        }
        return response;
    }

}
