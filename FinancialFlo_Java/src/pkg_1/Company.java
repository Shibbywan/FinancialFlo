package pkg_1;

public class Company {
    private String marketCap, enterpriseValue, trailingPE, forwardPE, pegRatio, priceSales, priceBook, enterpriseValueRevenue, enterpriseValueEBITDA,
                fiscalYearEnds, mostRecentQuarter, profitMargin, operatingMargin, returnOnAssets, returnOnEquity, revenue, revenuePerShare, qtrlyRevenueGrowth, grossProfit, ebitda, netIncomeAvlToCommon,
                dilutedEPS, qtrlyEarningsGrowth, totalCash, totalCashPerShare, totalDebt, totalDebtEquity, currentRatio, bookValuePerShare, operatingCashFlow,
                leveredFreeCashFlow, beta, p_52_WeekChange, SP50052_WeekChange, p_52_WeekHigh, p_52_WeekLow, p_50_DayMovingAverage, p_200_DayMovingAverage,
                avgVol1, avgVol2, sharesOutstanding, shareFloat, percentageHeldByInsiders, percentageHeldByInstitutions, shortRatio, shortPercentage,
                forwardAnnualDividendRate, forwardAnnualDividendYield, trailingAnnualDividendYieldp, trailingAnnualDividendYieldn, p_5YearAverageDividendYield, 
                payoutRatio, dividendDate, ex_DividendDate, lastSplitFactor, lastSplitDate;
    
    public Company(String marketCap, String enterpriseValue, String trailingPE, String forwardPE, String pegRatio, String priceSales, String priceBook, String enterpriseValueRevenue,String enterpriseValueEBITDA,
                String fiscalYearEnds, String mostRecentQuarter, String profitMargin,  String operatingMargin, String returnOnAssets, String returnOnEquity, String revenue, String revenuePerShare, String qtrlyRevenueGrowth, String grossProfit, String ebitda, String netIncomeAvlToCommon,
                String dilutedEPS, String qtrlyEarningsGrowth, String totalCash,  String totalCashPerShare, String totalDebt, String totalDebtEquity, String currentRatio, String bookValuePerShare, String operatingCashFlow,
                String leveredFreeCashFlow, String beta, String p_52_WeekChange, String SP50052_WeekChange, String p_52_WeekHigh, String p_52_WeekLow, String p_50_DayMovingAverage, String p_200_DayMovingAverage,
                 String avgVol1, String avgVol2, String sharesOutstanding, String shareFloat, String percentageHeldByInsiders, String percentageHeldByInstitutions, String shortRatio, String shortPercentage,
                String forwardAnnualDividendRate, String forwardAnnualDividendYield, String trailingAnnualDividendYieldp, String trailingAnnualDividendYieldn, String p_5YearAverageDividendYield, 
                String payoutRatio, String dividendDate, String ex_DividendDate, String lastSplitFactor, String lastSplitDate) {
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
        this.shortRatio = shortRatio;
        this.shortPercentage = shortPercentage;
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
        return this.pegRatio;
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
    
    public String get
}
