package pkg_1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import static scala.Console.println;

public class Company {
            TreeMap<String, Company> map = new TreeMap<>();
    Model model;
    public String symbol, companyName, exchange, marketCap, enterpriseValue, trailingPE, forwardPE, pegRatio, priceSales, priceBook, enterpriseValueRevenue, enterpriseValueEBITDA,
                fiscalYearEnds, mostRecentQuarter, profitMargin, operatingMargin, returnOnAssets, returnOnEquity, revenue, revenuePerShare, qtrlyRevenueGrowth, grossProfit, ebitda, netIncomeAvlToCommon,
                dilutedEPS, qtrlyEarningsGrowth, totalCash, totalCashPerShare, totalDebt, totalDebtEquity, currentRatio, bookValuePerShare, operatingCashFlow,
                leveredFreeCashFlow, beta, p_52_WeekChange, SP50052_WeekChange, p_52_WeekHigh, p_52_WeekLow, p_50_DayMovingAverage, p_200_DayMovingAverage,
                avgVol1, avgVol2, sharesOutstanding, shareFloat, percentageHeldByInsiders, percentageHeldByInstitutions,sharesShort1, shortRatio, shortPercentage, sharesShort2,
                forwardAnnualDividendRate, forwardAnnualDividendYield, trailingAnnualDividendYieldp, trailingAnnualDividendYieldn, p_5YearAverageDividendYield, 
                payoutRatio, dividendDate, ex_DividendDate, lastSplitFactor, lastSplitDate, averageDailyVolume, change, daysLow, daysHigh, yearLow, yearHigh, marketCapitalization, lastTradePriceOnly,daysRange, volume, stockExchange, ask;
    
    public ArrayList<String> competitors;
    
    public Company(String symbol,String exchange, String marketCap, String enterpriseValue, String trailingPE, String forwardPE, String pegRatio, String priceSales, String priceBook, String enterpriseValueRevenue,String enterpriseValueEBITDA,
                String fiscalYearEnds, String mostRecentQuarter, String profitMargin,  String operatingMargin, String returnOnAssets, String returnOnEquity, String revenue, String revenuePerShare, String qtrlyRevenueGrowth, String grossProfit, String ebitda, String netIncomeAvlToCommon,
                String dilutedEPS, String qtrlyEarningsGrowth, String totalCash,  String totalCashPerShare, String totalDebt, String totalDebtEquity, String currentRatio, String bookValuePerShare, String operatingCashFlow,
                String leveredFreeCashFlow, String beta, String p_52_WeekChange, String SP50052_WeekChange, String p_52_WeekHigh, String p_52_WeekLow, String p_50_DayMovingAverage, String p_200_DayMovingAverage,
                String avgVol1, String avgVol2, String sharesOutstanding, String shareFloat, String percentageHeldByInsiders, String percentageHeldByInstitutions, String sharesShort1, String shortRatio, String shortPercentage, String sharesShort2,
                String forwardAnnualDividendRate, String forwardAnnualDividendYield, String trailingAnnualDividendYieldp, String trailingAnnualDividendYieldn, String p_5YearAverageDividendYield, 
                String payoutRatio, String dividendDate, String ex_DividendDate, String lastSplitFactor, String lastSplitDate, String averageDailyVolume, String change, String daysLow, String daysHigh, String yearLow, String yearHigh, String marketCapitalization,
                String lastTradePriceOnly, String daysRange, String volume, String stockExchange, String ask, ArrayList<String> competitors) throws IOException, ClassNotFoundException, SQLException {
        this.model = new Model(map);
        this.symbol = symbol;
        this.exchange = exchange;
        this.marketCap = marketCap;
        this.enterpriseValue = enterpriseValue;
        this.trailingPE = trailingPE;
        this.forwardPE = forwardPE;
        this.pegRatio = pegRatio;
        this.priceSales = priceSales;
        this.priceBook = priceBook;
        this.enterpriseValueRevenue = enterpriseValueRevenue;
        this.enterpriseValueEBITDA = enterpriseValueEBITDA;
        this.fiscalYearEnds = fiscalYearEnds;
        this.mostRecentQuarter = mostRecentQuarter;
        this.profitMargin = profitMargin;
        this.operatingMargin = operatingMargin;
        this.returnOnAssets = returnOnAssets;
        this.returnOnEquity = returnOnEquity;
        this.revenue = revenue;
        this.revenuePerShare = revenuePerShare;
        this.qtrlyRevenueGrowth = qtrlyRevenueGrowth;
        this.grossProfit = grossProfit;
        this.ebitda = ebitda;
        this.netIncomeAvlToCommon = netIncomeAvlToCommon;
        this.dilutedEPS = dilutedEPS;
        this.qtrlyEarningsGrowth = qtrlyEarningsGrowth;
        this.totalCash = totalCash;
        this.totalCashPerShare = totalCashPerShare;
        this.totalDebt = totalDebt;
        this.totalDebtEquity = totalDebtEquity;
        this.currentRatio = currentRatio;
        this.bookValuePerShare = bookValuePerShare;
        this.operatingCashFlow = operatingCashFlow;
        this.leveredFreeCashFlow = leveredFreeCashFlow;
        this.beta = beta;
        this.p_52_WeekChange = p_52_WeekChange;
        this.SP50052_WeekChange = SP50052_WeekChange;
        this.p_52_WeekHigh = p_52_WeekHigh;
        this.p_52_WeekLow = p_52_WeekLow;
        this.p_50_DayMovingAverage = p_50_DayMovingAverage;
        this.p_200_DayMovingAverage = p_200_DayMovingAverage;
        this.avgVol1 = avgVol1;
        this.avgVol2 = avgVol2;
        this.sharesOutstanding = sharesOutstanding;
        this.shareFloat = shareFloat;
        this.percentageHeldByInsiders = percentageHeldByInsiders;
        this.percentageHeldByInstitutions = percentageHeldByInstitutions;
        this.sharesShort1 = sharesShort1;
        this.shortRatio = shortRatio;
        this.shortPercentage = shortPercentage;
        this.sharesShort2 = sharesShort2;
        this.forwardAnnualDividendRate = forwardAnnualDividendRate;
        this.forwardAnnualDividendYield = forwardAnnualDividendYield;
        this.trailingAnnualDividendYieldn = trailingAnnualDividendYieldn;
        this.trailingAnnualDividendYieldp = trailingAnnualDividendYieldp;
        this.p_5YearAverageDividendYield = p_5YearAverageDividendYield;
        this.payoutRatio = payoutRatio;
        this.dividendDate = dividendDate;
        this.ex_DividendDate = ex_DividendDate;
        this.lastSplitDate = lastSplitDate;
        this.lastSplitFactor = lastSplitFactor;
        this.change = change;
        this.averageDailyVolume = averageDailyVolume;
        this.daysLow = daysLow;
        this.daysHigh = daysHigh;
        this.yearLow = yearLow;
        this.yearHigh = yearHigh;
        this.marketCapitalization = marketCapitalization;
        this.lastTradePriceOnly = lastTradePriceOnly;
        this.daysRange = daysRange;
        this.volume = volume;
        this.stockExchange = stockExchange;
        this.ask = ask;
        this.competitors = competitors;
        
        String url = "jdbc:sqlserver://localhost:1433;" + 
                "databaseName=FF_DB;user=shibby;password=crimson";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(url);
        this.companyName = model.getCompanyName(conn, this.symbol.trim());
    
    }
    public String getSymbol() {
        return this.symbol;
    }
    
    public String getCompanyName() {
        return this.companyName;
    }
    public String getExchange() {
        return this.exchange;
    }
    
    public String getMarketCap() {
        if (this.marketCap.equals("")) {
            return null;
        } else 
         return this.marketCap;
    }
    
    public String getEnterpriseValue() {
         if (this.enterpriseValue.equals("")) {
            return null;
        } else 
        return this.enterpriseValue;
    }
    
    public String getTrailingPE() { 
         if (this.trailingPE.equals("")) {
            return null;
        } else 
        return this.trailingPE;
    }
    
    public String getForwardPE() {
         if (this.forwardPE.equals("")) {
            return null;
        } else 
        return this.forwardPE;
    }
    
    public String getPEGRatio() {
         if (this.pegRatio.equals("")) {
            return null;
        } else 
        return this.pegRatio;
    }
    
    public String getPriceSales() {
         if (this.priceSales.equals("")) {
            return null;
        } else 
        return this.priceSales;
    }
    
    public String getPriceBook() {
         if (this.priceBook.equals("")) {
            return null;
        } else 
        return this.priceBook;
    }
    
    public String getEnterpriseValueRevenue() {
         if (this.enterpriseValueRevenue.equals("")) {
            return null;
        } else 
        return this.enterpriseValueRevenue;
    }
    
    public String getEnterpriseValueEBIDTA() {
         if (this.enterpriseValueEBITDA.equals("")) {
            return null;
        } else 
        return this.enterpriseValueEBITDA;
    }
    
    public String getFiscalYearEnds() {
         if (this.fiscalYearEnds.equals("")) {
            return null;
        } else 
        return this.fiscalYearEnds;
    }
    
    public String getMostRecentQuarter() {
         if (this.mostRecentQuarter.equals("")) {
            return null;
        } else 
        return this.mostRecentQuarter;
    }
    
    public String getProfitMargin() {
         if (this.profitMargin.equals("")) {
            return null;
        } else 
        return this.profitMargin;
    }
    
    public String getOperatingMargin() {
         if (this.operatingMargin.equals("")) {
            return null;
        } else 
        return this.operatingMargin;
    }
    
    public String getReturnOnAssets() {
         if (this.returnOnAssets.equals("")) {
            return null;
        } else 
        return this.returnOnAssets;
    }
    
    public String getReturnOnEquity() {
         if (this.returnOnEquity.equals("")) {
            return null;
        } else 
        return this.returnOnEquity;
    }
    
    public String getRevenue() {
         if (this.revenue.equals("")) {
            return null;
        } else 
        return this.revenue;
    }
    
    public String getRevenuePerShare() {
         if (this.revenuePerShare.equals("")) {
            return null;
        } else 
        return this.revenuePerShare;
    }
    
    public String getQtrlyRevenueGrowth() {
         if (this.qtrlyRevenueGrowth.equals("")) {
            return null;
        } else 
        return this.qtrlyRevenueGrowth;
    }
    
    public String getGrossProfit() {
     if (this.grossProfit.equals("")) {
            return null;
        } else 
        return this.grossProfit;
    }
    
    public String getEBITDA() {
         if (this.ebitda.equals("")) {
            return null;
        } else 
        return this.ebitda;
    }
    
    public String getnetIncomeAvlToCommon() {
         if (this.netIncomeAvlToCommon.equals("")) {
            return null;
        } else 
        return this.netIncomeAvlToCommon;
    }
    
    public String getdilutedEPS() {
         if (this.dilutedEPS.equals("")) {
            return null;
        } else 
        return this.dilutedEPS;
    }
    
    public String getqtrlyEarningsGrowth() {
         if (this.qtrlyEarningsGrowth.equals("")) {
            return null;
        } else 
        return this.qtrlyEarningsGrowth;
    }
    
    public String gettotalCash() {
         if (this.totalCash.equals("")) {
            return null;
        } else 
        return this.totalCash;
    }
    
    public String gettotalCashPerShare() {
         if (this.totalCashPerShare.equals("")) {
            return null;
        } else 
        return this.totalCashPerShare;
    }
    
    public String getTotalDebt() {
         if (this.totalDebt.equals("")) {
            return null;
        } else 
        return this.totalDebt;
    }
    
    public String getTotalDebtEquity() {
         if (this.totalDebtEquity.equals("")) {
            return null;
        } else 
        return this.totalDebtEquity;
    }
    
    public String getCurrentRatio() {
         if (this.currentRatio.equals("")) {
            return null;
        } else 
        return this.currentRatio;
    }
    
    public String getBookValuePerShare() {
         if (this.bookValuePerShare.equals("")) {
            return null;
        } else 
        return this.bookValuePerShare;
    }
    
    public String getOperatingCashFlow() {
         if (this.operatingCashFlow.equals("")) {
            return null;
        } else 
        return this.operatingCashFlow;
    }
    
    public String getLeveredFreeCashFlow() {
         if (this.leveredFreeCashFlow.equals("")) {
            return null;
        } else 
        return this.leveredFreeCashFlow;
    }
    
    public String getBeta() {
         if (this.beta.equals("")) {
            return null;
        } else 
        return this.beta;
    }
    
    public String getP_52_WeekChange() {
         if (this.p_52_WeekChange.equals("")) {
            return null;
        } else 
        return this.p_52_WeekChange;
    }
    
    public String getSP50052_WeekChange() {
         if (this.SP50052_WeekChange.equals("")) {
            return null;
        } else 
        return this.SP50052_WeekChange;
    }
    
    public String getP_52_WeekHigh() {
         if (this.p_52_WeekHigh.equals("")) {
            return null;
        } else 
        return this.p_52_WeekHigh;
    }
    
    public String getP_52_WeekLow() {
         if (this.p_52_WeekLow.equals("")) {
            return null;
        } else 
        return this.p_52_WeekLow;
    }
    
    public String getP_50_DayMovingAverage() {
         if (this.p_50_DayMovingAverage.equals("")) {
            return null;
        } else 
        return this.p_50_DayMovingAverage;
    }
    
    public String getP_200_DayMovingAverage() {
         if (this.p_200_DayMovingAverage.equals("")) {
            return null;
        } else 
        return this.p_200_DayMovingAverage;
    }
    
    public String getAvgVol1() {
         if (this.avgVol1.equals("")) {
            return null;
        } else 
        return this.avgVol1;
    }
    
    public String getAvgVol2() {
         if (this.avgVol2.equals("")) {
            return null;
        } else 
        return this.avgVol2;
    }
    
    public String getSharesOutstanding() {
         if (this.sharesOutstanding.equals("")) {
            return null;
        } else 
        return this.sharesOutstanding;
    }
    
    public String getShareFloat() {
         if (this.shareFloat.equals("")) {
            return null;
        } else 
        return this.shareFloat;
    }
    
    public String getPercentageHeldByInsiders() {
         if (this.percentageHeldByInsiders.equals("")) {
            return null;
        } else 
        return this.percentageHeldByInsiders;
    }
    
    public String getPercentageHeldByInstitutions() {
         if (this.percentageHeldByInstitutions.equals("")) {
            return null;
        } else 
        return this.percentageHeldByInstitutions;
    }
    
    public String getSharesShort1() {
         if (this.sharesShort1.equals("")) {
            return null;
        } else 
        return this.sharesShort1;
    }
    
    public String getShortRatio() {
         if (this.shortRatio.equals("")) {
            return null;
        } else 
        return this.shortRatio;
    }
    
    public String getShortPercentage() {
         if (this.shortPercentage.equals("")) {
            return null;
        } else 
        return this.shortPercentage;
    }
    
    public String getSharesShort2() {
         if (this.sharesShort2.equals("")) {
            return null;
        } else 
        return this.sharesShort2;
    }
    
    public String getForwardAnnualDividendRate() {
         if (this.forwardAnnualDividendRate.equals("")) {
            return null;
        } else 
        return this.forwardAnnualDividendRate;
    }
    
    public String getForwardAnnualDividendYield() {
         if (this.forwardAnnualDividendYield.equals("")) {
            return null;
        } else 
        return this.forwardAnnualDividendYield;
    }
    
    public String getTrailingAnnualDividendYieldp() {
         if (this.trailingAnnualDividendYieldp.equals("")) {
            return null;
        } else 
        return this.trailingAnnualDividendYieldp;
    }
    
    public String getTrailingAnnualDividendYieldn() {
         if (this.trailingAnnualDividendYieldn.equals("")) {
            return null;
        } else 
        return this.trailingAnnualDividendYieldn;
    }
    
    public String getP_5YearAverageDividendYield() {
         if (this.p_5YearAverageDividendYield.equals("")) {
            return null;
        } else 
        return this.p_5YearAverageDividendYield;
    }
    
    public String getPayoutRatio() {
         if (this.payoutRatio.equals("")) {
            return null;
        } else 
        return this.payoutRatio;
    }
    
    public String getDividendDate() {
         if (this.dividendDate.equals("")) {
            return null;
        } else 
        return this.dividendDate;
    }
    
    public String getEx_DividendDate() {
         if (this.ex_DividendDate.equals("")) {
            return null;
        } else 
        return this.ex_DividendDate;
    }
    
    public String getLastSplitFactor() {
         if (this.lastSplitFactor.equals("")) {
            return null;
        } else 
        return this.lastSplitFactor;
    }
    
    public String getLastSplitDate() {
         if (this.lastSplitDate.equals("")) {
            return null;
        } else 
        return this.lastSplitDate;
    }
    
    public String getAverageDailyVolume() {
         if (this.averageDailyVolume.equals("")) {
            return null;
        } else 
        return this.averageDailyVolume;
    }
    
    public String getChange() {
         if (this.change.equals("")) {
            return null;
        } else 
        return this.change;
    }
    
    public String getDaysLow() {
         if (this.daysLow.equals("")) {
            return null;
        } else 
        return this.daysLow;
    }
    
    public String getDaysHigh() {
         if (this.daysHigh.equals("")) {
            return null;
        } else 
        return this.daysHigh;
    }
    
    public String getYearLow() {
         if (this.yearLow.equals("")) {
            return null;
        } else 
        return this.yearLow;
    }
    
    public String getYearHigh() {
         if (this.yearHigh.equals("")) {
            return null;
        } else 
        return this.yearHigh;
    }
    
    public String getMarketCapitalization() {
         if (this.marketCapitalization.equals("")) {
            return null;
        } else 
        return this.marketCapitalization;
    }
    
    public String getLastTradePriceOnly() {
         if (this.lastTradePriceOnly.equals("")) {
            return null;
        } else 
        return this.lastTradePriceOnly;
    }
    
    public String getDaysRange() {
         if (this.daysRange.equals("")) {
            return null;
        } else 
        return this.daysRange;
    }
    
    public String getVolume() {
         if (this.volume.equals("")) {
            return null;
        } else 
        return this.volume;
    }
    
    public String getStockExchange() {
         if (this.stockExchange.equals("")) {
            return null;
        } else 
        return this.stockExchange;
    }
    
    public String getAsk() {
         if (this.ask.equals("")) {
            return null;
        } else 
        return this.ask;
    }
    
    public ArrayList<String> getCompetitors() {
        return this.competitors;
    }
    
    
}

