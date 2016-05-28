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
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import spark.ModelAndView;
import spark.Spark;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

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
            
            return var;
    }
    
    public static void main(String[] args) throws IOException, TemplateException {
        TreeMap<String, Company> map = new TreeMap<>();
        Model model = new Model(map);
        externalStaticFileLocation("src/main/resources");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration freeMarkerConfiguration = new Configuration();
        freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(Company.class, "/"));
        freeMarkerEngine.setConfiguration(freeMarkerConfiguration);

        
        get("/", (req, res) -> {
            Map<String, Object> var = new HashMap<>();
            return freeMarkerEngine.render(new ModelAndView(var, "views/home.html"));
        });
        
        get("/company/:symbol", (req, res) -> {
            List<String> data = new ArrayList<>();
            String sym = req.params(":symbol");
            Company k = model.getCompany(sym);
            Map<String, Object> var = populateMap(k);
            return freeMarkerEngine.render(new ModelAndView(var,"views/company.ftl"));
        });
        
    }

}