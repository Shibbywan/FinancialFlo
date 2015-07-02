
package pkg_1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.ccil.cowan.tagsoup.jaxp.SAXParserImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;
/**
 *
 * @author Kevin
 */
public class GetHTMLData {
    public void getData() throws SAXException, IOException {
         String marketCap = null, enterpriseValue, trailingPE, forwardPE, pegRatio, priceSales, priceBook, enterpriseValueRevenue, enterpriseValueEBITDA,
                fiscalYearEnds, mostRecentQuarter, profitMargin, operatingMargin, returnOnAssets, returnOnEquity, revenue, revenuePerShare, qtrlyRevenueGrowth, grossProfit, ebitda, netIncomeAvlToCommon,
                dilutedEPS, qtrlyEarningsGrowth, totalCash, totalCashPerShare, totalDebt, totalDebtEquity, currentRatio, bookValuePerShare, operatingCashFlow,
                leveredFreeCashFlow, beta, p_52_WeekChange, SP50052_WeekChange, p_52_WeekHigh, p_52_WeekLow, p_50_DayMovingAverage, p_200_DayMovingAverage,
                avgVol, avgVol1, avgVol2, sharesOutstanding, shareFloat, percentageHeldByInsiders, percentageHeldByInstitutions, shortRatio = null, shortPercentage = null, sharesShort = null,
                forwardAnnualDividendRate = null, forwardAnnualDividendYield, trailingAnnualDividendYieldp, trailingAnnualDividendYieldn, p_5YearAverageDividendYield, 
                payoutRatio, dividendDate, ex_DividendDate = null, lastSplitFactor = null, lastSplitDate = null, t, temp = "";
        int z = -1;
         
        File fout = new File("data.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        Document doc = (Document) Jsoup.connect("https://finance.yahoo.com/q/ks?s=YHOO").get();
        Elements ps = (Elements) doc.select("tbody");
        String[] parts = Jsoup.parse(ps.toString()).text().split("Valuation Measures");
        String k = parts[1];
        parts = k.split("See Key Statistics Help");
        k = parts[0];
        k = k.trim();
        bw.write(k);
        bw.close();
        StringTokenizer st = new StringTokenizer(k);
        while (st.hasMoreTokens()) {
            t = st.nextToken(":");
            if (z == 0) 
                marketCap = t;
            if (z == 1)
                enterpriseValue = t;
            if (z == 2)
                trailingPE = t;
            if (z == 3)
                forwardPE = t;
            if (z == 4)
                pegRatio = t;
            if (z == 5)
                priceSales = t;
            if (z == 6)
                priceBook = t;
            if (z == 7)
                enterpriseValueRevenue = t;
            if (z == 8)
                enterpriseValueEBITDA = t;
            if (z == 9)
                fiscalYearEnds = t;
            if (z == 10)
                mostRecentQuarter = t;
            if (z == 11)
                profitMargin = t;
            if (z == 12)
                operatingMargin = t;
            if (z == 13)
                returnOnAssets = t;
            if (z == 14)
                returnOnEquity = t;
            if (z == 15)
                revenue = t;
            if (z == 16)
                revenuePerShare = t;
            if (z == 17)
                qtrlyRevenueGrowth = t;
            if (z == 18)
                grossProfit = t;
            if (z == 19)
                ebitda = t;
            if (z == 20)
                netIncomeAvlToCommon = t;
            if (z == 21)
                dilutedEPS = t;
            if (z == 22)
                qtrlyEarningsGrowth = t;
            if (z == 23)
                totalCash = t;
            if (z == 24)
                totalCashPerShare = t;
            if (z == 25)
                totalDebt = t;
            if (z == 26)
                totalDebtEquity = t;
            if (z == 27)
                currentRatio = t;
            if (z == 28)
                bookValuePerShare = t;
            if (z == 29)
                operatingCashFlow = t;
            if (z == 30)
                leveredFreeCashFlow = t;
            if (z == 31)
                beta = t;
            if (z == 32)
                p_52_WeekChange = t;
            if (z == 33)
                SP50052_WeekChange = t;
            if (z == 34)
                p_52_WeekHigh = t;
            if (z == 35)
                p_52_WeekLow = t;
            if (z == 36)
                p_50_DayMovingAverage = t;
            if (z == 37)
                p_200_DayMovingAverage = t;
            if (z == 38)
                avgVol = t;
            if (z == 39)
                avgVol1 = t;
            if (z == 40)
                avgVol2 = t;
            if (z == 41)
                sharesOutstanding = t;
            if (z == 42)
                shareFloat = t;
            if (z == 43)
                percentageHeldByInsiders = t;
            if (z == 44)
                percentageHeldByInstitutions = t;
            if (z == 45)
                shortRatio = t;
            if (z == 46)
                shortPercentage = t;
            if (z == 47)
                sharesShort = t;
            if (z == 48)
                forwardAnnualDividendRate = t;
            if (z == 49)
                forwardAnnualDividendYield = t;
            if (z == 50)
                trailingAnnualDividendYieldp = t;
            if (z == 51)
                trailingAnnualDividendYieldn = t;
            if (z == 52)
                p_5YearAverageDividendYield = t;
            if (z == 53)
                payoutRatio = t;
            if (z == 54)
                dividendDate = t;
            if (z == 55)
                ex_DividendDate = t;
            if (z == 56)
                lastSplitFactor = t;
            if (z == 57) {
                if (t.contains("/") == false) 
                    temp = t.split(" ")[0] + ":";
                lastSplitFactor = lastSplitFactor.trim();
                lastSplitFactor = temp + lastSplitFactor;
            }
            if (st.hasMoreElements() == false) {
                lastSplitDate = t;
            }
            //System.out.println(t);

            
            z++;
        }
         System.out.println(lastSplitDate);
         System.out.println(shortRatio);
         System.out.println(marketCap);
         System.out.println(lastSplitFactor);
         System.out.println(ex_DividendDate);
         System.out.println(shortPercentage);
         System.out.println(forwardAnnualDividendRate);
        //System.out.println(k);
    }
}
