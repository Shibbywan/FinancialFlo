package pkg_1;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Kevin
 */
public class GetData {
    private final String s1 = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.keystats%20where%20symbol%20in%20%28%22";
    private Map <String, Company> companyMap;

    private final String s2 = "%22%29&diagnostics=true&env=http%3A%2F%2Fdatatables.org%2Falltables.env";
    
    
    public Company requestData(String name) throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        String marketCap, enterpriseValue, trailingPE, forwardPE, pegRatio, priceSales, priceBook, enterpriseValueRevenue, enterpriseValueEBITDA,
                fiscalYearEnds, mostRecentQuarter, profitMargin, operatingMargin, returnOnAssets, returnOnEquity, revenue, revenuePerShare, qtrlyRevenueGrowth, grossProfit, ebitda, netIncomeAvlToCommon,
                dilutedEPS, qtrlyEarningsGrowth, totalCash, totalCashPerShare, totalDebt, totalDebtEquity, currentRatio, bookValuePerShare, operatingCashFlow,
                leveredFreeCashFlow, beta, p_52_WeekChange, SP50052_WeekChange, p_52_WeekHigh, p_52_WeekLow, p_50_DayMovingAverage, p_200_DayMovingAverage,
                avgVol, avgVol1, avgVol2, sharesOutstanding, shareFloat, percentageHeldByInsiders, percentageHeldByInstitutions, shortRatio, shortPercentage,
                forwardAnnualDividendRate, forwardAnnualDividendYield, trailingAnnualDividendYieldp, trailingAnnualDividendYieldn, p_5YearAverageDividendYield, 
                payoutRatio, dividendDate, ex_DividendDate, lastSplitFactor, lastSplitDate;
        
        URL url = new URL(s1 + name + s2);
        companyMap = new TreeMap<>();
        System.out.println("url is" + url.toString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");
        Company k = null;
        InputStream xml = connection.getInputStream();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        //org.w3c.dom.Document doc = db.parse(new File(s));
        Document doc = (Document) db.parse(xml);
        
        doc.getDocumentElement().normalize();
            System.out.println("Root element of the doc is "
                    + doc.getDocumentElement().getNodeName());
        
        NodeList nl = doc.getElementsByTagName("results");
        int length = nl.getLength();
        for (int z = 0; z < length; z++) {
            Node firstNode = nl.item(z);
            if (firstNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element firstElement = (Element) firstNode;
                 marketCap = doc.getElementsByTagName("MarketCap").item(0).getTextContent();
                 enterpriseValue = doc.getElementsByTagName("EnterpriseValue").item(0).getTextContent();
                 trailingPE = doc.getElementsByTagName("TrailingPE").item(0).getTextContent();
                 forwardPE = doc.getElementsByTagName("ForwardPE").item(0).getTextContent();
                 pegRatio = doc.getElementsByTagName("PEGRatio").item(0).getTextContent();
                 priceSales = doc.getElementsByTagName("PriceSales").item(0).getTextContent();
                 priceBook = doc.getElementsByTagName("PriceBook").item(0).getTextContent();
                 enterpriseValueRevenue = doc.getElementsByTagName("EnterpriseValueRevenue").item(0).getTextContent();
                 enterpriseValueEBITDA = doc.getElementsByTagName("EnterpriseValueEBITDA").item(0).getTextContent();
                 fiscalYearEnds = doc.getElementsByTagName("FiscalYearEnds").item(0).getTextContent();
                 mostRecentQuarter = doc.getElementsByTagName("MostRecentQuarter").item(0).getTextContent();
                 profitMargin = doc.getElementsByTagName("ProfitMargin").item(0).getTextContent();
                 operatingMargin = doc.getElementsByTagName("OperatingMargin").item(0).getTextContent();
                 returnOnAssets = doc.getElementsByTagName("ReturnonAssets").item(0).getTextContent();
                 returnOnEquity = doc.getElementsByTagName("ReturnonEquity").item(0).getTextContent();
                 revenue = doc.getElementsByTagName("Revenue").item(0).getTextContent();
                 revenuePerShare = doc.getElementsByTagName("RevenuePerShare").item(0).getTextContent();
                 qtrlyRevenueGrowth = doc.getElementsByTagName("QtrlyRevenueGrowth").item(0).getTextContent();
                 grossProfit = doc.getElementsByTagName("GrossProfit").item(0).getTextContent();
                 ebitda = doc.getElementsByTagName("EBITDA").item(0).getTextContent();
                 netIncomeAvlToCommon = doc.getElementsByTagName("NetIncomeAvltoCommon").item(0).getTextContent();
                 dilutedEPS = doc.getElementsByTagName("DilutedEPS").item(0).getTextContent();
                 qtrlyEarningsGrowth = doc.getElementsByTagName("QtrlyEarningsGrowth").item(0).getTextContent();
                 totalCash = doc.getElementsByTagName("TotalCash").item(0).getTextContent();
                 totalCashPerShare = doc.getElementsByTagName("TotalCashPerShare").item(0).getTextContent();
                 totalDebt = doc.getElementsByTagName("TotalDebt").item(0).getTextContent();
                 totalDebtEquity = doc.getElementsByTagName("TotalDebtEquity").item(0).getTextContent();
                 currentRatio = doc.getElementsByTagName("CurrentRatio").item(0).getTextContent();
                 bookValuePerShare = doc.getElementsByTagName("BookValuePerShare").item(0).getTextContent();
                 operatingCashFlow = doc.getElementsByTagName("OperatingCashFlow").item(0).getTextContent();
                 leveredFreeCashFlow = doc.getElementsByTagName("LeveredFreeCashFlow").item(0).getTextContent();
                 beta = doc.getElementsByTagName("Beta").item(0).getTextContent();
                 p_52_WeekChange = doc.getElementsByTagName("p_52_WeekChange").item(0).getTextContent();
                 SP50052_WeekChange = doc.getElementsByTagName("SP50052_WeekChange").item(0).getTextContent();
                 p_52_WeekHigh = doc.getElementsByTagName("p_52_WeekHigh").item(0).getTextContent();
                 p_52_WeekLow = doc.getElementsByTagName("p_52_WeekLow").item(0).getTextContent();
                 p_50_DayMovingAverage = doc.getElementsByTagName("p_50_DayMovingAverage").item(0).getTextContent();
                 p_200_DayMovingAverage = doc.getElementsByTagName("p_200_DayMovingAverage").item(0).getTextContent();
                 avgVol1 = doc.getElementsByTagName("AvgVol").item(0).getTextContent();
                 avgVol2 = doc.getElementsByTagName("AvgVol").item(1).getTextContent();
                 sharesOutstanding = doc.getElementsByTagName("SharesOutstanding").item(0).getTextContent();
                 shareFloat = doc.getElementsByTagName("Float").item(0).getTextContent();
                 percentageHeldByInsiders = doc.getElementsByTagName("PercentageHeldbyInsiders").item(0).getTextContent();
                 percentageHeldByInstitutions = doc.getElementsByTagName("PercentageHeldbyInstitutions").item(0).getTextContent();
                 shortRatio = doc.getElementsByTagName("ShortRatio").item(0).getTextContent();
                 shortPercentage = doc.getElementsByTagName("ShortPercentageofFloat").item(0).getTextContent();
                 forwardAnnualDividendRate = doc.getElementsByTagName("ForwardAnnualDividendRate").item(0).getTextContent();
                 forwardAnnualDividendYield = doc.getElementsByTagName("ForwardAnnualDividendYield").item(0).getTextContent();
                 trailingAnnualDividendYieldp = doc.getElementsByTagName("TrailingAnnualDividendYield").item(0).getTextContent();
                 trailingAnnualDividendYieldn = doc.getElementsByTagName("TrailingAnnualDividendYield").item(1).getTextContent();
                 p_5YearAverageDividendYield = doc.getElementsByTagName("p_5YearAverageDividendYield").item(0).getTextContent();
                 payoutRatio = doc.getElementsByTagName("PayoutRatio").item(0).getTextContent();
                 dividendDate = doc.getElementsByTagName("DividendDate").item(0).getTextContent();
                 ex_DividendDate = doc.getElementsByTagName("Ex_DividendDate").item(0).getTextContent();
                 lastSplitFactor = doc.getElementsByTagName("LastSplitFactor").item(0).getTextContent();
                 lastSplitDate = doc.getElementsByTagName("LastSplitDate").item(0).getTextContent();
                 System.out.println(avgVol1);
                 System.out.println(avgVol2);
                 System.out.println(marketCap);
                 k = new Company(marketCap,  enterpriseValue,  trailingPE,  forwardPE,  pegRatio,  priceSales,  priceBook,  enterpriseValueRevenue, enterpriseValueEBITDA,
                 fiscalYearEnds,  mostRecentQuarter,  profitMargin,   operatingMargin,  returnOnAssets,  returnOnEquity,  revenue,  revenuePerShare,  qtrlyRevenueGrowth,  grossProfit,  ebitda,  netIncomeAvlToCommon,
                 dilutedEPS,  qtrlyEarningsGrowth,  totalCash,   totalCashPerShare,  totalDebt,  totalDebtEquity,  currentRatio,  bookValuePerShare,  operatingCashFlow,
                 leveredFreeCashFlow,  beta,  p_52_WeekChange,  SP50052_WeekChange,  p_52_WeekHigh,  p_52_WeekLow,  p_50_DayMovingAverage,  p_200_DayMovingAverage,
                  avgVol1,  avgVol2,  sharesOutstanding,  shareFloat,  percentageHeldByInsiders,  percentageHeldByInstitutions,  shortRatio,  shortPercentage,
                 forwardAnnualDividendRate,  forwardAnnualDividendYield,  trailingAnnualDividendYieldp,  trailingAnnualDividendYieldn,  p_5YearAverageDividendYield, payoutRatio,  dividendDate,  ex_DividendDate,  lastSplitFactor,  lastSplitDate);

            }
        }
        return k;
    }
    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }
}
