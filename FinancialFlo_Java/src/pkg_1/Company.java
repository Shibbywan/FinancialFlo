package pkg_1;

public class Company {
    private String symbol, companyName, exchange, marketCap, enterpriseValue, trailingPE, forwardPE, pegRatio, priceSales, priceBook, enterpriseValueRevenue, enterpriseValueEBITDA,
                fiscalYearEnds, mostRecentQuarter, profitMargin, operatingMargin, returnOnAssets, returnOnEquity, revenue, revenuePerShare, qtrlyRevenueGrowth, grossProfit, ebitda, netIncomeAvlToCommon,
                dilutedEPS, qtrlyEarningsGrowth, totalCash, totalCashPerShare, totalDebt, totalDebtEquity, currentRatio, bookValuePerShare, operatingCashFlow,
                leveredFreeCashFlow, beta, p_52_WeekChange, SP50052_WeekChange, p_52_WeekHigh, p_52_WeekLow, p_50_DayMovingAverage, p_200_DayMovingAverage,
                avgVol1, avgVol2, sharesOutstanding, shareFloat, percentageHeldByInsiders, percentageHeldByInstitutions,sharesShort1, shortRatio, shortPercentage, sharesShort2,
                forwardAnnualDividendRate, forwardAnnualDividendYield, trailingAnnualDividendYieldp, trailingAnnualDividendYieldn, p_5YearAverageDividendYield, 
                payoutRatio, dividendDate, ex_DividendDate, lastSplitFactor, lastSplitDate;
    
    public Company(String symbol,String companyName,String exchange, String marketCap, String enterpriseValue, String trailingPE, String forwardPE, String pegRatio, String priceSales, String priceBook, String enterpriseValueRevenue,String enterpriseValueEBITDA,
                String fiscalYearEnds, String mostRecentQuarter, String profitMargin,  String operatingMargin, String returnOnAssets, String returnOnEquity, String revenue, String revenuePerShare, String qtrlyRevenueGrowth, String grossProfit, String ebitda, String netIncomeAvlToCommon,
                String dilutedEPS, String qtrlyEarningsGrowth, String totalCash,  String totalCashPerShare, String totalDebt, String totalDebtEquity, String currentRatio, String bookValuePerShare, String operatingCashFlow,
                String leveredFreeCashFlow, String beta, String p_52_WeekChange, String SP50052_WeekChange, String p_52_WeekHigh, String p_52_WeekLow, String p_50_DayMovingAverage, String p_200_DayMovingAverage,
                 String avgVol1, String avgVol2, String sharesOutstanding, String shareFloat, String percentageHeldByInsiders, String percentageHeldByInstitutions, String sharesShort1, String shortRatio, String shortPercentage, String sharesShort2,
                String forwardAnnualDividendRate, String forwardAnnualDividendYield, String trailingAnnualDividendYieldp, String trailingAnnualDividendYieldn, String p_5YearAverageDividendYield, 
                String payoutRatio, String dividendDate, String ex_DividendDate, String lastSplitFactor, String lastSplitDate) {
        this.symbol = symbol;
        this.companyName = companyName;
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
         return this.marketCap;
    }
    
    public String getEnterpriseValue() {
        return this.enterpriseValue;
    }
    
    public String getTrailingPE() { 
        return this.trailingPE;
    }
    
    public String getForwardPE() {
        return this.forwardPE;
    }
    
    public String getPEGRatio() {
        return this.pegRatio;
    }
    
    public String getPriceSales() {
        return this.priceSales;
    }
    
    public String getPriceBook() {
        return this.priceBook;
    }
    
    public String getEnterpriseValueRevenue() {
        return this.enterpriseValueRevenue;
    }
    
    public String getEnterpriseValueEBIDTA() {
        return this.enterpriseValueEBITDA;
    }
    
    public String getFiscalYearEnds() {
        return this.fiscalYearEnds;
    }
    
    public String getMostRecentQuarter() {
        return this.mostRecentQuarter;
    }
    
    public String getProfitMargin() {
        return this.profitMargin;
    }
    
    public String getOperatingMargin() {
        return this.operatingMargin;
    }
    
    public String getReturnOnAssets() {
        return this.returnOnAssets;
    }
    
    public String getReturnOnEquity() {
        return this.returnOnEquity;
    }
    
    public String getRevenue() {
        return this.revenue;
    }
    
    public String getRevenuePerShare() {
        return this.revenuePerShare;
    }
    
    public String getQtrlyRevenueGrowth() {
        return this.qtrlyRevenueGrowth;
    }
    
    public String getGrossProfit() {
        return this.grossProfit;
    }
    
    public String getEBITDA() {
        return this.ebitda;
    }
    
    public String getnetIncomeAvlToCommon() {
        return this.netIncomeAvlToCommon;
    }
    
    public String getdilutedEPS() {
        return this.dilutedEPS;
    }
    
    public String getqtrlyEarningsGrowth() {
        return this.qtrlyEarningsGrowth;
    }
    
    public String gettotalCash() {
        return this.totalCash;
    }
    
    public String gettotalCashPerShare() {
        return this.totalCashPerShare;
    }
    
    public String getTotalDebt() {
        return this.totalDebt;
    }
    
    public String getTotalDebtEquity() {
        return this.totalDebtEquity;
    }
    
    public String getCurrentRatio() {
        return this.currentRatio;
    }
    
    public String getBookValuePerShare() {
        return this.bookValuePerShare;
    }
    
    public String getOperatingCashFlow() {
        return this.operatingCashFlow;
    }
    
    public String getLeveredFreeCashFlow() {
        return this.leveredFreeCashFlow;
    }
    
    public String getBeta() {
        return this.beta;
    }
    
    public String getP_52_WeekChange() {
        return this.p_52_WeekChange;
    }
    
    public String getSP50052_WeekChange() {
        return this.SP50052_WeekChange;
    }
    
    public String getP_52_WeekHigh() {
        return this.p_52_WeekHigh;
    }
    
    public String getP_52_WeekLow() {
        return this.p_52_WeekLow;
    }
    
    public String getP_50_DayMovingAverage() {
        return this.p_50_DayMovingAverage;
    }
    
    public String getP_200_DayMovingAverage() {
        return this.p_200_DayMovingAverage;
    }
    
    public String getAvgVol1() {
        return this.avgVol1;
    }
    
    public String getAvgVol2() {
        return this.avgVol2;
    }
    
    public String getSharesOutstanding() {
        return this.sharesOutstanding;
    }
    
    public String getShareFloat() {
        return this.shareFloat;
    }
    
    public String getPercentageHeldByInsiders() {
        return this.percentageHeldByInsiders;
    }
    
    public String getPercentageHeldByInstitutions() {
        return this.percentageHeldByInstitutions;
    }
    
    public String getSharesShort1() {
        return this.sharesShort1;
    }
    
    public String getShortRatio() {
        return this.shortRatio;
    }
    
    public String getShortPercentage() {
        return this.shortPercentage;
    }
    
    public String getSharesShort2() {
        return this.sharesShort2;
    }
    
    public String getForwardAnnualDividendRate() {
        return this.forwardAnnualDividendRate;
    }
    
    public String getForwardAnnualDividendYield() {
        return this.forwardAnnualDividendYield;
    }
    
    public String getTrailingAnnualDividendYieldp() {
        return this.trailingAnnualDividendYieldp;
    }
    
    public String getTrailingAnnualDividendYieldn() {
        return this.trailingAnnualDividendYieldn;
    }
    
    public String getP_5YearAverageDividendYield() {
        return this.p_5YearAverageDividendYield;
    }
    
    public String getPayoutRatio() {
        return this.payoutRatio;
    }
    
    public String getDividendDate() {
        return this.dividendDate;
    }
    
    public String getEx_DividendDate() {
        return this.ex_DividendDate;
    }
    
    public String getLastSplitFactor() {
        return this.lastSplitFactor;
    }
    
    public String getLastSplitDate() {
        return this.lastSplitDate;
    }
}
