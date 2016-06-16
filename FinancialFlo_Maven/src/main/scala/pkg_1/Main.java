/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_1;

/**
 *
 * @author Kevin
 */
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static scala.Console.println;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.Spark;
import org.xml.sax.SAXException;
import java.net.MalformedURLException;
import java.util.StringTokenizer;
import javax.xml.parsers.ParserConfigurationException;

public class Main {
    
    private static Map<String, Object> populateMap(Company k) {
            Map<String, Object> var = new HashMap<>();
            
            var.put("avgVol1", k.getAvgVol1());
            var.put("avgVol2", k.getAvgVol2());
            var.put("beta", k.getBeta());
            var.put("bookValuePerShare", k.getBookValuePerShare());
            var.put("companyName", k.getCompanyName());
            var.put("currentRatio",k.getCurrentRatio());
            var.put("dividendDate", k.getDividendDate());
            var.put("EBITDA", k.getEBITDA());
            var.put("enterpriseValue", k.getEnterpriseValue());
            var.put("enterpriseValueEBIDTA", k.getEnterpriseValueEBIDTA());
            var.put("enterpriseValueRevenue", k.getEnterpriseValueRevenue());
            var.put("exDividendDate", k.getEx_DividendDate());
            var.put("exchange", k.getExchange());
            var.put("fiscalYearEnds", k.getFiscalYearEnds());
            var.put("forwardAnnualDividendRate", k.getForwardAnnualDividendRate());
            var.put("forwardAnnualDividendYield", k.getForwardAnnualDividendYield());
            var.put("forwardPE", k.getForwardPE());
            var.put("grossProfit", k.getGrossProfit());
            var.put("lastSplitDate", k.getLastSplitDate());
            var.put("lastSplitFactor", k.getLastSplitFactor());
            var.put("leveredFreeCashFlow", k.getLeveredFreeCashFlow());
            var.put("marketCap", k.getMarketCap());
            var.put("mostRecentQuarter", k.getMostRecentQuarter());
            var.put("getOperatingCashFlow", k.getOperatingCashFlow());
            var.put("operatingMargin", k.getOperatingMargin());
            var.put("pegRatio", k.getPEGRatio());
            var.put("pDayMovingAverage_200", k.getP_200_DayMovingAverage());
            var.put("pDayMovingAverage_50", k.getP_50_DayMovingAverage());
            var.put("pWeekChange_52", k.getP_52_WeekChange());
            var.put("pWeekHigh_52", k.getP_52_WeekHigh());
            var.put("pWeekLow_52", k.getP_52_WeekLow());
            var.put("pAverageDividendYield_5y", k.getP_5YearAverageDividendYield());
            var.put("payoutRatio", k.getPayoutRatio());
            var.put("percentHeldByInsiders", k.getPercentageHeldByInsiders());
            var.put("percentageHeldByInstitutions", k.getPercentageHeldByInstitutions());
            var.put("priceBook", k.getPriceBook());
            var.put("priceSales", k.getPriceSales());
            var.put("profitMargin", k.getProfitMargin());
            var.put("qtrlyRevenueGrowth", k.getQtrlyRevenueGrowth());
            var.put("returnOnAssets", k.getReturnOnAssets());
            var.put("returnOnEquity", k.getReturnOnEquity());
            var.put("revenue", k.getRevenue());
            var.put("revenuePerShare", k.getRevenuePerShare());
            var.put("spWeekChange_50052", k.getSP50052_WeekChange());
            var.put("shareFloat", k.getShareFloat());
            var.put("sharesOutstanding", k.getSharesOutstanding());
            var.put("sharesShort1", k.getSharesShort1());
            var.put("sharesShort2", k.getSharesShort2());
            var.put("shortPercentage", k.getShortPercentage());
            var.put("shortRatio", k.getShortRatio());
            var.put("symbol", k.getSymbol());
            var.put("totalDebt", k.getTotalDebt());
            var.put("totalDebtEquity", k.getTotalDebtEquity());
            var.put("trailingAnnualDividendYieldn", k.getTrailingAnnualDividendYieldn());
            var.put("trailingAnnualDividendYieldp", k.getTrailingAnnualDividendYieldp());
            var.put("trailingPE", k.getTrailingPE());
            var.put("dilutedEPS", k.getdilutedEPS());
            var.put("netIncomeAvlToCommon", k.getnetIncomeAvlToCommon());
            var.put("qtrlyEarningsGrowth", k.getqtrlyEarningsGrowth());
            var.put("totalCash", k.gettotalCash());
            var.put("totalCashPerShare", k.gettotalCashPerShare());
            var.put("averageDailyVolume", k.getAverageDailyVolume());
            var.put("change", k.getChange());
            var.put("daysLow", k.getDaysLow());
            var.put("daysHigh", k.getDaysHigh());
            var.put("yearLow", k.getYearLow());
            var.put("yearHigh", k.getYearHigh());
            var.put("marketCapitalization", k.getMarketCapitalization());
            var.put("lastTradePriceOnly", k.getLastTradePriceOnly());
            var.put("daysRange", k.getDaysRange());
            var.put("volume", k.getVolume());
            var.put("stockExchange", k.getStockExchange());
            var.put("ask", k.getAsk());
            return var;
    }
    private static List<String> getSearchResults(String str, Connection con) throws SQLException {
        List<String> list = new ArrayList<>();
        String queryString = "Select DISTINCT symbol, name, exchange, country FROM company WHERE symbol LIKE '%" + str + "%' OR name LIKE '%" + str +"%' OR exchange LIKE '%" + str +"%' OR country LIKE '%" + str + "%'";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(queryString);
        while (rs.next()) {
            String t = rs.getString("symbol");
            list.add(t);
        }
        return list;
    }
    public static void main(String[] args) throws IOException, TemplateException, SQLException, ClassNotFoundException {
        TreeMap<String, Company> map = new TreeMap<>();
        Model model = new Model(map);
        String url = "jdbc:sqlserver://localhost:1433;" + 
                "databaseName=FF_DB;user=shibby;password=crimson";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(url);
        externalStaticFileLocation("src/main/resources");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration freeMarkerConfiguration = new Configuration();
        freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(Company.class, "/"));
        freeMarkerEngine.setConfiguration(freeMarkerConfiguration);

        
        get("/", (req, res) -> {
            Map<String, Object> var = new HashMap<>();
            return freeMarkerEngine.render(new ModelAndView(var, "views/home.html"));
        });
        
        get("/compare/:symbol", (req, res) -> {
            List<Company> companies = new ArrayList<>();
            Map<String, Object> var = new HashMap<>();
            String sym = req.params(":symbol");
            if (sym.contains("+") && sym.charAt(sym.length() - 1) != '+') {
                String[] arr = sym.split("\\+");
                println(Arrays.toString(arr));
                for(String k : arr) {
                    companies.add(model.getCompany(k));
                }
            } else {
                res.status(404);
                return null;
            }
            var.put("companies", companies);
            return freeMarkerEngine.render(new ModelAndView(var,"views/compare.ftl"));
        });
        
        get("/company/:symbol", (req, res) -> {
            List<String> competitors = new ArrayList<>();
            Map<String, Object> var = new HashMap<>();
            List<Company> companies = new ArrayList<>();
            String sym = req.params(":symbol");
            Company k = model.getCompany(sym);
            if (k.competitors != null) {
                competitors=k.competitors;
            } else {
                competitors.add("N/A");
            }
            companies.add(k);
            var.put("companies", companies);
            var.put("competitors", competitors);
            return freeMarkerEngine.render(new ModelAndView(var,"views/company.ftl"));
        });
        
        get("/search/:query", (req, res) -> {
            Map<String, Object> var = new HashMap<>();
            String query = req.params(":query");
            String result = java.net.URLDecoder.decode(query, "UTF-8");
            List<String> results = new ArrayList();
            results = getSearchResults(result, conn);
            var.put("results", results);
            return freeMarkerEngine.render(new ModelAndView(var, "views/search.ftl"));
        });
        
    }

}