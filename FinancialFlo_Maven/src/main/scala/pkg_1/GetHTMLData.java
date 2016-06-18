package pkg_1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
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
import static scala.Console.println;

/**
 *
 * @author Kevin
 */
public class GetHTMLData {

    private final String s1 = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20%28%22";
    private final String s2 = "%22%29&diagnostics=true&env=http%3A%2F%2Fdatatables.org%2Falltables.env";

    public Company getData(String company) throws SAXException, IOException, ParserConfigurationException, ClassNotFoundException, SQLException {
        String marketCap = "", enterpriseValue = "", trailingPE = "", forwardPE = "", pegRatio = "", priceSales = "", priceBook = "", enterpriseValueRevenue = "", enterpriseValueEBITDA = "",
                fiscalYearEnds = "", mostRecentQuarter = "", profitMargin = "", operatingMargin = "", returnOnAssets = "", returnOnEquity = "", revenue = "", revenuePerShare = "", qtrlyRevenueGrowth = "", grossProfit = "", ebitda = "", netIncomeAvlToCommon = "",
                dilutedEPS = "", qtrlyEarningsGrowth = "", totalCash = "", totalCashPerShare = "", totalDebt = "", totalDebtEquity = "", currentRatio = "", bookValuePerShare = "", operatingCashFlow = "",
                leveredFreeCashFlow = "", beta = "", p_52_WeekChange = "", SP50052_WeekChange = "", p_52_WeekHigh = "", p_52_WeekLow = "", p_50_DayMovingAverage = "", p_200_DayMovingAverage = "",
                avgVol = "", avgVol1 = "", sharesOutstanding = "", shareFloat = "", percentageHeldByInsiders = "", percentageHeldByInstitutions = "", shortRatio = "", shortPercentage = "", sharesShort1 = "", sharesShort2 = "",
                forwardAnnualDividendRate = "", forwardAnnualDividendYield = "", trailingAnnualDividendYieldp = "", trailingAnnualDividendYieldn = "", p_5YearAverageDividendYield = "",
                payoutRatio = "", dividendDate = "", ex_DividendDate = "", lastSplitFactor = "", lastSplitDate = "", averageDailyVolume = "", change = "", daysLow = "", daysHigh = "", yearLow = "", yearHigh = "", marketCapitalization = "", lastTradePriceOnly = "", daysRange = "", symbol = "", volume = "", stockExchange = "", ask = "", t, temp = "", companyName = "", exchange = "";
        int z = -1;
        ArrayList<String> compArray = new ArrayList<>();
        String link = "https://finance.yahoo.com/q/ks?s=" + company;
        String comp = "https://finance.yahoo.com/q/co?s=" + company;
        HttpURLConnection con = (HttpURLConnection) new URL(link).openConnection();
        con.setInstanceFollowRedirects(false);
        con.connect();
        int responseCode = con.getResponseCode();

        HttpURLConnection con2 = (HttpURLConnection) new URL(comp).openConnection();
        con2.setInstanceFollowRedirects(false);
        con2.connect();
        int responseCode2 = con2.getResponseCode();

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

        Document doc = (Document) Jsoup.connect(link).timeout(10 * 1000).get();
        Elements check = (Elements) doc.select("p");
        Elements check2 = (Elements) doc.select("h2");
        String p = Jsoup.parse(check.toString()).text();
        String o = Jsoup.parse(check2.toString()).text();
        if (!p.contains("no Key Statistics data available") && !o.contains("are no results for the given")) {
            Elements ps2 = (Elements) doc.select("h2");
            Elements ps = (Elements) doc.select("tbody");
            Elements ps3 = (Elements) doc.select("span.rtq_exch");
            exchange = Jsoup.parse(ps3.toString()).text().split("-")[1].trim();
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
        }
        Document document = (Document) Jsoup.connect(comp).timeout(10 * 1000).get();
        Elements ele = (Elements) document.getElementsByAttributeValueContaining("href", "q?s");
        String example = ele.html();
        if (example.contains("strong")) {
            String[] splitArray = example.split("\n");
            for (String splitArray1 : splitArray) {
                if (splitArray1.contains("strong")) {
                    compArray.add(Jsoup.parse(splitArray1).body().text());
                }
            }
        }
        Company c = new Company(company, exchange, marketCap, enterpriseValue, trailingPE, forwardPE, pegRatio, priceSales, priceBook, enterpriseValueRevenue, enterpriseValueEBITDA,
                fiscalYearEnds, mostRecentQuarter, profitMargin, operatingMargin, returnOnAssets, returnOnEquity, revenue, revenuePerShare, qtrlyRevenueGrowth, grossProfit, ebitda, netIncomeAvlToCommon,
                dilutedEPS, qtrlyEarningsGrowth, totalCash, totalCashPerShare, totalDebt, totalDebtEquity, currentRatio, bookValuePerShare, operatingCashFlow,
                leveredFreeCashFlow, beta, p_52_WeekChange, SP50052_WeekChange, p_52_WeekHigh, p_52_WeekLow, p_50_DayMovingAverage, p_200_DayMovingAverage,
                avgVol, avgVol1, sharesOutstanding, shareFloat, percentageHeldByInsiders, percentageHeldByInstitutions, sharesShort1, shortRatio, shortPercentage, sharesShort2,
                forwardAnnualDividendRate, forwardAnnualDividendYield, trailingAnnualDividendYieldp, trailingAnnualDividendYieldn, p_5YearAverageDividendYield,
                payoutRatio, dividendDate, ex_DividendDate, lastSplitFactor, lastSplitDate, averageDailyVolume, change, daysLow, daysHigh, yearLow, yearHigh, marketCapitalization, lastTradePriceOnly, daysRange, volume, stockExchange, ask, compArray);
        return c;
    }
}
