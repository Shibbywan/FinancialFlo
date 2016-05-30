package pkg_1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Kevin
 */
public class GetHTMLData {
    private final String s1 = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20%28%22";
    private final String s2 = "%22%29&diagnostics=true&env=http%3A%2F%2Fdatatables.org%2Falltables.env";
    
    public Company getData(String company) throws SAXException, IOException, ParserConfigurationException {
        String marketCap = null, enterpriseValue = null, trailingPE = null, forwardPE = null, pegRatio = null, priceSales = null, priceBook = null, enterpriseValueRevenue = null, enterpriseValueEBITDA = null,
                fiscalYearEnds = null, mostRecentQuarter = null, profitMargin = null, operatingMargin = null, returnOnAssets = null, returnOnEquity = null, revenue = null, revenuePerShare = null, qtrlyRevenueGrowth = null, grossProfit = null, ebitda = null, netIncomeAvlToCommon = null,
                dilutedEPS = null, qtrlyEarningsGrowth = null, totalCash = null, totalCashPerShare = null, totalDebt = null, totalDebtEquity = null, currentRatio = null, bookValuePerShare = null, operatingCashFlow = null,
                leveredFreeCashFlow = null, beta = null, p_52_WeekChange = null, SP50052_WeekChange = null, p_52_WeekHigh = null, p_52_WeekLow = null, p_50_DayMovingAverage = null, p_200_DayMovingAverage = null,
                avgVol = null, avgVol1 = null, sharesOutstanding = null, shareFloat = null, percentageHeldByInsiders = null, percentageHeldByInstitutions = null, shortRatio = null, shortPercentage = null, sharesShort1 = null, sharesShort2 = null,
                forwardAnnualDividendRate = null, forwardAnnualDividendYield = null, trailingAnnualDividendYieldp = null, trailingAnnualDividendYieldn = null, p_5YearAverageDividendYield = null,
                payoutRatio = null, dividendDate = null, ex_DividendDate = null, lastSplitFactor = null, lastSplitDate = null, averageDailyVolume = null, change = null, daysLow = null, daysHigh = null, yearLow = null, yearHigh = null, marketCapitalization = null, lastTradePriceOnly = null, daysRange = null, symbol = null, volume = null, stockExchange = null, ask = null, t, temp = "";
        int z = -1;

        String link = "https://finance.yahoo.com/q/ks?s=" + company;
        HttpURLConnection con = (HttpURLConnection) new URL(link).openConnection();
        con.setInstanceFollowRedirects(false);
        con.connect();
        int responseCode = con.getResponseCode();
                          URL url = new URL(s1 + company + s2);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");
        InputStream xml = connection.getInputStream();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        org.w3c.dom.Document docc = (org.w3c.dom.Document) db.parse(xml);
        
        docc.getDocumentElement().normalize();
        
        NodeList nl = docc.getElementsByTagName("results");
        int length = nl.getLength();
        for (int i = 0; i < length; i++) {
            Node firstNode = nl.item(i);
            if (firstNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element firstElement = (Element) firstNode;
                 averageDailyVolume = docc.getElementsByTagName("AverageDailyVolume").item(0).getTextContent();
                 change = docc.getElementsByTagName("Change").item(0).getTextContent();
                 daysLow = docc.getElementsByTagName("DaysLow").item(0).getTextContent();
                 daysHigh = docc.getElementsByTagName("DaysHigh").item(0).getTextContent();
                 yearLow = docc.getElementsByTagName("YearLow").item(0).getTextContent();
                 yearHigh = docc.getElementsByTagName("YearHigh").item(0).getTextContent();
                 marketCapitalization = docc.getElementsByTagName("MarketCapitalization").item(0).getTextContent();
                 lastTradePriceOnly = docc.getElementsByTagName("LastTradePriceOnly").item(0).getTextContent();
                 daysRange = docc.getElementsByTagName("DaysRange").item(0).getTextContent();
                 stockExchange = docc.getElementsByTagName("StockExchange").item(0).getTextContent();
                 ask = docc.getElementsByTagName("Ask").item(0).getTextContent();

            }
        }
        if (responseCode == 200) {
        
            Document doc = (Document) Jsoup.connect(link).get();

            Elements ps2 = (Elements) doc.select("h2");
            String[] parts2 = Jsoup.parse(ps2.toString()).text().split(company);
            Elements ps = (Elements) doc.select("tbody");
            Elements ps3 = (Elements) doc.select("span.rtq_exch");
            String exchange = Jsoup.parse(ps3.toString()).text().split("-")[1].trim();
            String companyName = parts2[1].replace("(", "").trim();
            String[] parts = Jsoup.parse(ps.toString()).text().split("Valuation Measures");
            String k = parts[1];
            parts = k.split("See Key Statistics Help");
            k = parts[0];
            k = k.trim();
            StringTokenizer st = new StringTokenizer(k);
            
            while (st.hasMoreTokens()) {
                t = st.nextToken(":");
                if (z == 0) {
                    marketCap = t.trim().split(" ")[0];
                }
                if (z == 1) {
                    enterpriseValue = t.trim().split(" ")[0];
                }
                if (z == 2) {
                    trailingPE = t.trim().split(" ")[0];
                }
                if (z == 3) {
                    forwardPE = t.trim().split(" ")[0];
                }
                if (z == 4) {
                    pegRatio = t.trim().split(" ")[0];
                }
                if (z == 5) {
                    priceSales = t.trim().split(" ")[0];
                }
                if (z == 6) {
                    priceBook = t.trim().split(" ")[0];
                }
                if (z == 7) {
                    enterpriseValueRevenue = t.trim().split(" ")[0];
                }
                if (z == 8) {
                    enterpriseValueEBITDA = t.trim().split(" ")[0];
                }
                if (z == 9) {
                    fiscalYearEnds = t.trim().split(" ")[0];
                }
                if (z == 10) {
                    mostRecentQuarter = t.trim().split(" ")[0];
                }
                if (z == 11) {
                    profitMargin = t.trim().split(" ")[0];
                }
                if (z == 12) {
                    operatingMargin = t.trim().split(" ")[0];
                }
                if (z == 13) {
                    returnOnAssets = t.trim().split(" ")[0];
                }
                if (z == 14) {
                    returnOnEquity = t.trim().split(" ")[0];
                }
                if (z == 15) {
                    revenue = t.trim().split(" ")[0];
                }
                if (z == 16) {
                    revenuePerShare = t.trim().split(" ")[0];
                }
                if (z == 17) {
                    qtrlyRevenueGrowth = t.trim().split(" ")[0];
                }
                if (z == 18) {
                    grossProfit = t.trim().split(" ")[0];
                }
                if (z == 19) {
                    ebitda = t.trim().split(" ")[0];
                }
                if (z == 20) {
                    netIncomeAvlToCommon = t.trim().split(" ")[0];
                }
                if (z == 21) {
                    dilutedEPS = t.trim().split(" ")[0];
                }
                if (z == 22) {
                    qtrlyEarningsGrowth = t.trim().split(" ")[0];
                }
                if (z == 23) {
                    totalCash = t.trim().split(" ")[0];
                }
                if (z == 24) {
                    totalCashPerShare = t.trim().split(" ")[0];
                }
                if (z == 25) {
                    totalDebt = t.trim().split(" ")[0];
                }
                if (z == 26) {
                    totalDebtEquity = t.trim().split(" ")[0];
                }
                if (z == 27) {
                    currentRatio = t.trim().split(" ")[0];
                }
                if (z == 28) {
                    bookValuePerShare = t.trim().split(" ")[0];
                }
                if (z == 29) {
                    operatingCashFlow = t.trim().split(" ")[0];
                }
                if (z == 30) {
                    leveredFreeCashFlow = t.trim().split(" ")[0];
                }
                if (z == 31) {
                    beta = t.trim().split(" ")[0];
                }
                if (z == 32) {
                    p_52_WeekChange = t.trim().split(" ")[0];
                }
                if (z == 33) {
                    SP50052_WeekChange = t.trim().split(" ")[0];
                }
                if (z == 34) {
                    p_52_WeekHigh = t.trim().split(" ")[0];
                }
                if (z == 35) {
                    p_52_WeekLow = t.trim().split(" ")[0];
                }
                if (z == 36) {
                    p_50_DayMovingAverage = t.trim().split(" ")[0];
                }
                if (z == 37) {
                    p_200_DayMovingAverage = t.trim().split(" ")[0];
                }
                if (z == 38) {
                    avgVol = t.trim().split(" ")[0];
                }
                if (z == 39) {
                    avgVol1 = t.trim().split(" ")[0];
                }
                if (z == 40) {
                    sharesOutstanding = t.trim().split(" ")[0];
                }
                if (z == 41) {
                    shareFloat = t.trim().split(" ")[0];
                }
                if (z == 42) {
                    percentageHeldByInsiders = t.trim().split(" ")[0];
                }
                if (z == 43) {
                    percentageHeldByInstitutions = t.trim().split(" ")[0];
                }
                if (z == 44) {
                    sharesShort1 = t.trim().split(" ")[0];
                }
                if (z == 45) {
                    shortRatio = t.trim().split(" ")[0];
                }
                if (z == 46) {
                    shortPercentage = t.trim().split(" ")[0];
                }
                if (z == 47) {
                    sharesShort2 = t.trim().split(" ")[0];
                }
                if (z == 48) {
                    forwardAnnualDividendRate = t.trim().split(" ")[0];
                }
                if (z == 49) {
                    forwardAnnualDividendYield = t.trim().split(" ")[0];
                }
                if (z == 50) {
                    trailingAnnualDividendYieldp = t.trim().split(" ")[0];
                }
                if (z == 51) {
                    trailingAnnualDividendYieldn = t.trim().split(" ")[0];
                }
                if (z == 52) {
                    p_5YearAverageDividendYield = t.trim().split(" ")[0];
                }
                if (z == 53) {
                    payoutRatio = t.trim().split(" ")[0];
                }
                if (z == 54) {
                    dividendDate = t.trim().split("Ex")[0];
                }
                if (z == 55) {
                    ex_DividendDate = t.trim().split("Last")[0];
                }
                if (z == 56) {
                    lastSplitFactor = t.trim().split(" ")[0];
                }
                if (z == 57) {
                    if (t.contains("/") == false) {
                        temp = t.split(" ")[0];
                        lastSplitFactor = lastSplitFactor.trim();
                        lastSplitFactor = lastSplitFactor + ":" + temp;
                    }
                }
                if (st.hasMoreElements() == false) {
                    lastSplitDate = t;
                }
                z++;
            }
            Company c = new Company(company, companyName, exchange, marketCap, enterpriseValue, trailingPE, forwardPE, pegRatio, priceSales, priceBook, enterpriseValueRevenue, enterpriseValueEBITDA,
                    fiscalYearEnds, mostRecentQuarter, profitMargin, operatingMargin, returnOnAssets, returnOnEquity, revenue, revenuePerShare, qtrlyRevenueGrowth, grossProfit, ebitda, netIncomeAvlToCommon,
                    dilutedEPS, qtrlyEarningsGrowth, totalCash, totalCashPerShare, totalDebt, totalDebtEquity, currentRatio, bookValuePerShare, operatingCashFlow,
                    leveredFreeCashFlow, beta, p_52_WeekChange, SP50052_WeekChange, p_52_WeekHigh, p_52_WeekLow, p_50_DayMovingAverage, p_200_DayMovingAverage,
                    avgVol, avgVol1, sharesOutstanding, shareFloat, percentageHeldByInsiders, percentageHeldByInstitutions, sharesShort1, shortRatio, shortPercentage, sharesShort2,
                    forwardAnnualDividendRate, forwardAnnualDividendYield, trailingAnnualDividendYieldp, trailingAnnualDividendYieldn, p_5YearAverageDividendYield,
                    payoutRatio, dividendDate, ex_DividendDate, lastSplitFactor, lastSplitDate, averageDailyVolume, change, daysLow, daysHigh, yearLow, yearHigh, marketCapitalization, lastTradePriceOnly,daysRange, volume, stockExchange, ask);
            return c;
        } else {
            return null;
        }
    }
}
