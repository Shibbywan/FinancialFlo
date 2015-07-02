
package pkg_1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
                payoutRatio, dividendDate = null, ex_DividendDate = null, lastSplitFactor = null, lastSplitDate = null, t, temp = "";
        int z = -1;
         
        File fout = new File("data.txt");
        Document doc = (Document) Jsoup.connect("https://finance.yahoo.com/q/ks?s=SUN").get();
        Elements ps = (Elements) doc.select("tbody");
        String[] parts = Jsoup.parse(ps.toString()).text().split("Valuation Measures");
        String k = parts[1];
        parts = k.split("See Key Statistics Help");
        k = parts[0];
        k = k.trim();
        StringTokenizer st = new StringTokenizer(k);
        while (st.hasMoreTokens()) {
            t = st.nextToken(":");
            if (z == 0)
                marketCap = t.trim().split(" ")[0];
            if (z == 1)
                enterpriseValue = t.trim().split(" ")[0];
            if (z == 2)
                trailingPE = t.trim().split(" ")[0];
            if (z == 3)
                forwardPE = t.trim().split(" ")[0];
            if (z == 4)
                pegRatio = t.trim().split(" ")[0];
            if (z == 5)
                priceSales = t.trim().split(" ")[0];
            if (z == 6)
                priceBook = t.trim().split(" ")[0];
            if (z == 7)
                enterpriseValueRevenue = t.trim().split(" ")[0];
            if (z == 8)
                enterpriseValueEBITDA = t.trim().split(" ")[0];
            if (z == 9)
                fiscalYearEnds = t.trim().split(" ")[0];
            if (z == 10)
                mostRecentQuarter = t.trim().split(" ")[0];
            if (z == 11)
                profitMargin = t.trim().split(" ")[0];
            if (z == 12)
                operatingMargin = t.trim().split(" ")[0];
            if (z == 13)
                returnOnAssets = t.trim().split(" ")[0];
            if (z == 14)
                returnOnEquity = t.trim().split(" ")[0];
            if (z == 15)
                revenue = t.trim().split(" ")[0];
            if (z == 16)
                revenuePerShare = t.trim().split(" ")[0];
            if (z == 17)
                qtrlyRevenueGrowth = t.trim().split(" ")[0];
            if (z == 18)
                grossProfit = t.trim().split(" ")[0];
            if (z == 19)
                ebitda = t.trim().split(" ")[0];
            if (z == 20)
                netIncomeAvlToCommon = t.trim().split(" ")[0];
            if (z == 21)
                dilutedEPS = t.trim().split(" ")[0];
            if (z == 22)
                qtrlyEarningsGrowth = t.trim().split(" ")[0];
            if (z == 23)
                totalCash = t.trim().split(" ")[0];
            if (z == 24)
                totalCashPerShare = t.trim().split(" ")[0];
            if (z == 25)
                totalDebt = t.trim().split(" ")[0];
            if (z == 26)
                totalDebtEquity = t.trim().split(" ")[0];
            if (z == 27)
                currentRatio = t.trim().split(" ")[0];
            if (z == 28)
                bookValuePerShare = t.trim().split(" ")[0];
            if (z == 29)
                operatingCashFlow = t.trim().split(" ")[0];
            if (z == 30)
                leveredFreeCashFlow = t.trim().split(" ")[0];
            if (z == 31)
                beta = t.trim().split(" ")[0];
            if (z == 32)
                p_52_WeekChange = t.trim().split(" ")[0];
            if (z == 33)
                SP50052_WeekChange = t.trim().split(" ")[0];
            if (z == 34)
                p_52_WeekHigh = t.trim().split(" ")[0];
            if (z == 35)
                p_52_WeekLow = t.trim().split(" ")[0];
            if (z == 36)
                p_50_DayMovingAverage = t.trim().split(" ")[0];
            if (z == 37)
                p_200_DayMovingAverage = t.trim().split(" ")[0];
            if (z == 38)
                avgVol = t.trim().split(" ")[0];
            if (z == 39)
                avgVol1 = t.trim().split(" ")[0];
            if (z == 40)
                avgVol2 = t.trim().split(" ")[0];
            if (z == 41)
                sharesOutstanding = t.trim().split(" ")[0];
            if (z == 42)
                shareFloat = t.trim().split(" ")[0];
            if (z == 43)
                percentageHeldByInsiders = t.trim().split(" ")[0];
            if (z == 44)
                percentageHeldByInstitutions = t.trim().split(" ")[0];
            if (z == 45)
                shortRatio = t.trim().split(" ")[0];
            if (z == 46)
                shortPercentage = t.trim().split(" ")[0];
            if (z == 47)
                sharesShort = t.trim().split(" ")[0];
            if (z == 48)
                forwardAnnualDividendRate = t.trim().split(" ")[0];
            if (z == 49)
                forwardAnnualDividendYield = t.trim().split(" ")[0];
            if (z == 50)
                trailingAnnualDividendYieldp = t.trim().split(" ")[0];
            if (z == 51)
                trailingAnnualDividendYieldn = t.trim().split(" ")[0];
            if (z == 52)
                p_5YearAverageDividendYield = t.trim().split(" ")[0];
            if (z == 53)
                payoutRatio = t.trim().split(" ")[0];
            if (z == 54)
                dividendDate = t.trim().split("Ex")[0];
            if (z == 55)
                ex_DividendDate = t.trim().split("Last")[0];
            if (z == 56)
                lastSplitFactor = t.trim().split(" ")[0];
            if (z == 57) {
                if (t.contains("/") == false) {
                    temp = t.split(" ")[0] + ":";
                    lastSplitFactor = lastSplitFactor.trim();
                    lastSplitFactor = temp + lastSplitFactor;
                }
            }
            if (st.hasMoreElements() == false) {
                lastSplitDate = t;
            }         
            z++;
        }
         System.out.println("last split date is "+ lastSplitDate);
         System.out.println("short ratio is " + shortRatio);
         System.out.println("market cap is "+ marketCap);
         System.out.println("last split factor is " +lastSplitFactor);
         System.out.println("ex_dividend date is " + ex_DividendDate);
         System.out.println("dividend date is " + dividendDate);
         System.out.println("short percentage is "+ shortPercentage);
         System.out.println("forward annual dividend rate is " + forwardAnnualDividendRate);
        //System.out.println(k);
    }
}
