package pkg_1;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Controller {

    private final Model model;
    private final GUI gui;
    private final DefaultTableModel tm, tm2;
    private final List<Company> companies;
    private final List<String> companynames, companyMarketCaps, companyEnterpriseValues, companyTrailingPE, companyForwardPE, companyPEGRatio, companyPriceSales, companyPriceBook,
            companyEnterpriseValueRevenue, companyEnterpriseValueEBITDA, companyFiscalYearEnds, companyMostRecentQuarter, companyProfitMargin, companyOperatingMargin, companyReturnOnAssets,
            companyReturnOnEquity, companyRevenue, companyRevenuePerShare, companyQtrlyRevenueGrowth, companyGrossProfit, companyEBITDA, companyNetIncomeAvlToCommon, companyDilutedEPS,
            companyQtrlyEarningsGrowth, companyTotalCash, companyTotalCashPerShare, companyTotalDebt, companyTotalDebtEquity, companyCurrentRatio, companyBookValuePerShare,
            companyOperatingCashFlow, companyLeveredFreeCashFlow, companyBeta, companyP_52_WeekChange, companySP50052_WeekChange, companyP_52_WeekHigh, companyP_52_WeekLow,
            companyP_50_DayMovingAverage, companyP_200_DayMovingAverage, companyAvgVol, companyAvgVol1, companySharesOutstanding, companyShareFloat, companyPercentageHeldByInsiders,
            companyPercentageHeldByInstitutions, companySharesShort1, companyShortRatio, companyShortPercentage, companySharesShort2, companyForwardAnnualDividendRate, companyForwardAnnualDividendYield,
            companyTrailingAnnualDividendYieldp, companyTrailingAnnualDividendYieldn, companyP_5YearAverageDividendYield, companyPayoutRatio, companyDividendDate, companyEx_DividendDate, companyLastSplitFactor,
            companyLastSplitDate;
    private SwingWorker worker;

    public Controller(final Model model, final GUI gui) {
        this.model = model;
        this.gui = gui;
        gui.hideLoad();
        tm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) { //makes the cells in the table uneditable
                return false;
            }
        };
        tm2 = new DefaultTableModel();
        this.companies = new ArrayList();
        this.companynames = new ArrayList();
        this.companyMarketCaps = new ArrayList();
        this.companyEnterpriseValues = new ArrayList();
        this.companyTrailingPE = new ArrayList();
        this.companyForwardPE = new ArrayList();
        this.companyPEGRatio = new ArrayList();
        this.companyPriceSales = new ArrayList();
        this.companyPriceBook = new ArrayList();
        this.companyEnterpriseValueRevenue = new ArrayList();
        this.companyEnterpriseValueEBITDA = new ArrayList();
        this.companyFiscalYearEnds = new ArrayList();
        this.companyMostRecentQuarter = new ArrayList();
        this.companyProfitMargin = new ArrayList();
        this.companyOperatingMargin = new ArrayList();
        this.companyReturnOnAssets = new ArrayList();
        this.companyReturnOnEquity = new ArrayList();
        this.companyRevenue = new ArrayList();
        this.companyRevenuePerShare = new ArrayList();
        this.companyQtrlyRevenueGrowth = new ArrayList();
        this.companyGrossProfit = new ArrayList();
        this.companyEBITDA = new ArrayList();
        this.companyNetIncomeAvlToCommon = new ArrayList();
        this.companyDilutedEPS = new ArrayList();
        this.companyQtrlyEarningsGrowth = new ArrayList();
        this.companyTotalCash = new ArrayList();
        this.companyTotalCashPerShare = new ArrayList();
        this.companyTotalDebt = new ArrayList();
        this.companyTotalDebtEquity = new ArrayList();
        this.companyCurrentRatio = new ArrayList();
        this.companyBookValuePerShare = new ArrayList();
        this.companyOperatingCashFlow = new ArrayList();
        this.companyLeveredFreeCashFlow = new ArrayList();
        this.companyBeta = new ArrayList();
        this.companyP_52_WeekChange = new ArrayList();
        this.companySP50052_WeekChange = new ArrayList();
        this.companyP_52_WeekHigh = new ArrayList();
        this.companyP_52_WeekLow = new ArrayList();
        this.companyP_50_DayMovingAverage = new ArrayList();
        this.companyP_200_DayMovingAverage = new ArrayList();
        this.companyAvgVol = new ArrayList();
        this.companyAvgVol1 = new ArrayList();
        this.companySharesOutstanding = new ArrayList();
        this.companyShareFloat = new ArrayList();
        this.companyPercentageHeldByInsiders = new ArrayList();
        this.companyPercentageHeldByInstitutions = new ArrayList();
        this.companySharesShort1 = new ArrayList();
        this.companyShortRatio = new ArrayList();
        this.companyShortPercentage = new ArrayList();
        this.companySharesShort2 = new ArrayList();
        this.companyForwardAnnualDividendRate = new ArrayList();
        this.companyForwardAnnualDividendYield = new ArrayList();
        this.companyTrailingAnnualDividendYieldp = new ArrayList();
        this.companyTrailingAnnualDividendYieldn = new ArrayList();
        this.companyP_5YearAverageDividendYield = new ArrayList();
        this.companyPayoutRatio = new ArrayList();
        this.companyDividendDate = new ArrayList();
        this.companyEx_DividendDate = new ArrayList();
        this.companyLastSplitFactor = new ArrayList();
        this.companyLastSplitDate = new ArrayList();
        initRows();
        searchListener x = new searchListener();
        this.gui.addSearchBarListener(x);
        this.gui.addExcelButtonListener(new excelListener());
        this.gui.addClearButtonListener(new clearListener());
        this.gui.addDialogOKListener(new dialogListener());
        this.gui.addSpreadListener(new spreadListener());
        this.gui.addCloseSpreadListener(new closeSpreadListener());
        gui.setTableModel(tm);
        gui.setSpreadModel(tm2);
        tm2.setColumnCount(10);
        tm.addColumn("Symbol");
        tm.addColumn("Company");
    }

    private void initRows() {
        companynames.add("Symbol");
        companyMarketCaps.add("Market Cap (intraday)");
        companyEnterpriseValues.add("Enterprise Value");
        companyTrailingPE.add("Trailing P/E (ttm, intraday)");
        companyForwardPE.add("Forward P/E");
        companyPEGRatio.add("PEG Ratio");
        companyPriceSales.add("Price/Sales(ttm)");
        companyPriceBook.add("Price/Book(mrq)");
        companyEnterpriseValueRevenue.add("Enterprise Value/Revenue (ttm)");
        companyEnterpriseValueEBITDA.add("Enterprise Value/EBITDA (ttm)");
        companyFiscalYearEnds.add("Fiscal Year Ends");
        companyMostRecentQuarter.add("Most Recent Quarter(mrq)");
        companyProfitMargin.add("Profit Margin (ttm)");
        companyOperatingMargin.add("Operating Margin (ttm)");
        companyReturnOnAssets.add("Return on Assets (ttm)");
        companyReturnOnEquity.add("Return on Equity (ttm)");
        companyRevenue.add("Revenue (ttm)");
        companyRevenuePerShare.add("Revenue Per Share (ttm)");
        companyQtrlyRevenueGrowth.add("Qrtly Revenue Growth (yoy)");
        companyGrossProfit.add("Gross Profit (ttm)");
        companyEBITDA.add("EBITDA (ttm)");
        companyNetIncomeAvlToCommon.add("Net Income Avl to Common (ttm)");
        companyDilutedEPS.add("Diluted EPS (ttm)");
        companyQtrlyEarningsGrowth.add("Qtrly Earnings Growth (yoy)");
        companyTotalCash.add("Total Cash (mrq)");
        companyTotalCashPerShare.add("Total Cash Per Share (mrq)");
        companyTotalDebt.add("Total Debt (mrq)");
        companyTotalDebtEquity.add("Total Debt/Equity (mrq)");
        companyCurrentRatio.add("Current Ratio (mrq)");
        companyBookValuePerShare.add("Book Value Per Share (mrq)");
        companyOperatingCashFlow.add("Operating Cash Flow (ttm)");
        companyLeveredFreeCashFlow.add("Levered Free Cash Flow (ttm)");
        companyBeta.add("Beta");
        companyP_52_WeekChange.add("52-Week Change");
        companySP50052_WeekChange.add("S&P500 52-Week Change");
        companyP_52_WeekHigh.add("52-Week High");
        companyP_52_WeekLow.add("52-Week Low");
        companyP_50_DayMovingAverage.add("50-Day Moving Average");
        companyP_200_DayMovingAverage.add("200-Day Moving Average");
        companyAvgVol.add("Avg Vol (3 month)");
        companyAvgVol1.add("Avg Vol (10 day)");
        companySharesOutstanding.add("Shares Outstanding");
        companyShareFloat.add("Float");
        companyPercentageHeldByInsiders.add("% Held by Insiders");
        companyPercentageHeldByInstitutions.add("% Held by Institutions");
        companySharesShort1.add("Shares Short (current)");
        companyShortRatio.add("Short Ratio (current)");
        companyShortPercentage.add("Short % of Float (current)");
        companySharesShort2.add("Shares Short (prior month)");
        companyForwardAnnualDividendRate.add("Forward Annual Dividend Rate");
        companyForwardAnnualDividendYield.add("Forward Annual Dividend Yield");
        companyTrailingAnnualDividendYieldp.add("Trailing Annual Dividend Yield");
        companyTrailingAnnualDividendYieldn.add("Trailing Annual Dividend Yield");
        companyP_5YearAverageDividendYield.add("5 Year Average Dividend Yield");
        companyPayoutRatio.add("Payout Ratio");
        companyDividendDate.add("Dividend Date");
        companyEx_DividendDate.add("Ex-Dividend Date");
        companyLastSplitFactor.add("Last Split Factor (new per old)");
        companyLastSplitDate.add("Last Split Date");
    }

    public Company getCompany(String name) throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
        GetHTMLData k = new GetHTMLData();
        Company c = k.getData(name);
        companies.add(c);
        return c;
    }

    public SwingWorker makeWorker() {
        worker = new SwingWorker<String, Void>() {

            @Override
            protected String doInBackground() throws Exception {
                while (!isCancelled()) {
                    gui.disableSearch();
                    String s = gui.getSearchText().toUpperCase();
                    if ((s.length() != 0) == true && (model.getSymbols().contains(s.toUpperCase())) == true) {
                        Company c = null;
                        try {
                            c = getCompany(s);
                            gui.toggleExcelButton(true);
                            gui.toggleSpreadButton(true);
                        } catch (IOException | ParserConfigurationException | SAXException ex) {
                            if (tm.getRowCount() == 0) {
                                gui.toggleExcelButton(false);
                                gui.toggleSpreadButton(false);
                            }
                            gui.showDialog();
                            gui.setDialogText("Connection Interrupted");
                        }
                        tm.addRow(new Object[]{c.getSymbol(), model.getCompanyMap().get(c.getSymbol())});
                        gui.getSearchBar().setText("");
                    } else {
                        gui.showDialog();
                        gui.setDialogText("Invalid Entry");
                    }
                    gui.enableSearch();
                    cancel(true);
                }
                gui.hideLoad();
                return null;
            }
        };
        return worker;
    }

    private class searchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            worker = makeWorker();
            gui.showLoad();
            worker.execute();

        }
    }
    private class closeSpreadListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.hideSpread();
        }
        
    }
    private void clearData() {
        companynames.clear();
        companyMarketCaps.clear();
        companyEnterpriseValues.clear();
        companyTrailingPE.clear();
        companyForwardPE.clear();
        companyPEGRatio.clear();
        companyPriceSales.clear();
        companyPriceBook.clear();
        companyEnterpriseValueRevenue.clear();
        companyEnterpriseValueEBITDA.clear();
        companyFiscalYearEnds.clear();
        companyMostRecentQuarter.clear();
        companyProfitMargin.clear();
        companyOperatingMargin.clear();
        companyReturnOnAssets.clear();
        companyReturnOnEquity.clear();
        companyRevenue.clear();
        companyRevenuePerShare.clear();
        companyQtrlyRevenueGrowth.clear();
        companyGrossProfit.clear();
        companyEBITDA.clear();
        companyNetIncomeAvlToCommon.clear();
        companyDilutedEPS.clear();
        companyQtrlyEarningsGrowth.clear();
        companyTotalCash.clear();
        companyTotalCashPerShare.clear();
        companyTotalDebt.clear();
        companyTotalDebtEquity.clear();
        companyCurrentRatio.clear();
        companyBookValuePerShare.clear();
        companyOperatingCashFlow.clear();
        companyLeveredFreeCashFlow.clear();
        companyBeta.clear();
        companyP_52_WeekChange.clear();
        companySP50052_WeekChange.clear();
        companyP_52_WeekHigh.clear();
        companyP_52_WeekLow.clear();
        companyP_50_DayMovingAverage.clear();
        companyP_200_DayMovingAverage.clear();
        companyAvgVol.clear();
        companyAvgVol1.clear();
        companySharesOutstanding.clear();
        companyShareFloat.clear();
        companyPercentageHeldByInsiders.clear();
        companyPercentageHeldByInstitutions.clear();
        companySharesShort1.clear();
        companyShortRatio.clear();
        companyShortPercentage.clear();
        companySharesShort2.clear();
        companyForwardAnnualDividendRate.clear();
        companyForwardAnnualDividendYield.clear();
        companyTrailingAnnualDividendYieldp.clear();
        companyTrailingAnnualDividendYieldn.clear();
        companyP_5YearAverageDividendYield.clear();
        companyPayoutRatio.clear();
        companyDividendDate.clear();
        companyEx_DividendDate.clear();
        companyLastSplitFactor.clear();
        companyLastSplitDate.clear();
    }

    private class clearListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            companies.clear();
            companynames.clear();
            companyMarketCaps.clear();
            companyEnterpriseValues.clear();
            companyTrailingPE.clear();
            companyForwardPE.clear();
            companyPEGRatio.clear();
            companyPriceSales.clear();
            companyPriceBook.clear();
            companyEnterpriseValueRevenue.clear();
            companyEnterpriseValueEBITDA.clear();
            companyFiscalYearEnds.clear();
            companyMostRecentQuarter.clear();
            companyProfitMargin.clear();
            companyOperatingMargin.clear();
            companyReturnOnAssets.clear();
            companyReturnOnEquity.clear();
            companyRevenue.clear();
            companyRevenuePerShare.clear();
            companyQtrlyRevenueGrowth.clear();
            companyGrossProfit.clear();
            companyEBITDA.clear();
            companyNetIncomeAvlToCommon.clear();
            companyDilutedEPS.clear();
            companyQtrlyEarningsGrowth.clear();
            companyTotalCash.clear();
            companyTotalCashPerShare.clear();
            companyTotalDebt.clear();
            companyTotalDebtEquity.clear();
            companyCurrentRatio.clear();
            companyBookValuePerShare.clear();
            companyOperatingCashFlow.clear();
            companyLeveredFreeCashFlow.clear();
            companyBeta.clear();
            companyP_52_WeekChange.clear();
            companySP50052_WeekChange.clear();
            companyP_52_WeekHigh.clear();
            companyP_52_WeekLow.clear();
            companyP_50_DayMovingAverage.clear();
            companyP_200_DayMovingAverage.clear();
            companyAvgVol.clear();
            companyAvgVol1.clear();
            companySharesOutstanding.clear();
            companyShareFloat.clear();
            companyPercentageHeldByInsiders.clear();
            companyPercentageHeldByInstitutions.clear();
            companySharesShort1.clear();
            companyShortRatio.clear();
            companyShortPercentage.clear();
            companySharesShort2.clear();
            companyForwardAnnualDividendRate.clear();
            companyForwardAnnualDividendYield.clear();
            companyTrailingAnnualDividendYieldp.clear();
            companyTrailingAnnualDividendYieldn.clear();
            companyP_5YearAverageDividendYield.clear();
            companyPayoutRatio.clear();
            companyDividendDate.clear();
            companyEx_DividendDate.clear();
            companyLastSplitFactor.clear();
            companyLastSplitDate.clear();
            initRows();
            tm.setRowCount(0);
            //companynames.add("Symbol");
            gui.toggleExcelButton(false);
            gui.toggleSpreadButton(false);
        }
    }

    private class dialogListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.hideDialog();
        }
    }

    private class spreadListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            companynames.clear();
            companyMarketCaps.clear();
            companyEnterpriseValues.clear();
            companyTrailingPE.clear();
            companyForwardPE.clear();
            companyPEGRatio.clear();
            companyPriceSales.clear();
            companyPriceBook.clear();
            companyEnterpriseValueRevenue.clear();
            companyEnterpriseValueEBITDA.clear();
            companyFiscalYearEnds.clear();
            companyMostRecentQuarter.clear();
            companyProfitMargin.clear();
            companyOperatingMargin.clear();
            companyReturnOnAssets.clear();
            companyReturnOnEquity.clear();
            companyRevenue.clear();
            companyRevenuePerShare.clear();
            companyQtrlyRevenueGrowth.clear();
            companyGrossProfit.clear();
            companyEBITDA.clear();
            companyNetIncomeAvlToCommon.clear();
            companyDilutedEPS.clear();
            companyQtrlyEarningsGrowth.clear();
            companyTotalCash.clear();
            companyTotalCashPerShare.clear();
            companyTotalDebt.clear();
            companyTotalDebtEquity.clear();
            companyCurrentRatio.clear();
            companyBookValuePerShare.clear();
            companyOperatingCashFlow.clear();
            companyLeveredFreeCashFlow.clear();
            companyBeta.clear();
            companyP_52_WeekChange.clear();
            companySP50052_WeekChange.clear();
            companyP_52_WeekHigh.clear();
            companyP_52_WeekLow.clear();
            companyP_50_DayMovingAverage.clear();
            companyP_200_DayMovingAverage.clear();
            companyAvgVol.clear();
            companyAvgVol1.clear();
            companySharesOutstanding.clear();
            companyShareFloat.clear();
            companyPercentageHeldByInsiders.clear();
            companyPercentageHeldByInstitutions.clear();
            companySharesShort1.clear();
            companyShortRatio.clear();
            companyShortPercentage.clear();
            companySharesShort2.clear();
            companyForwardAnnualDividendRate.clear();
            companyForwardAnnualDividendYield.clear();
            companyTrailingAnnualDividendYieldp.clear();
            companyTrailingAnnualDividendYieldn.clear();
            companyP_5YearAverageDividendYield.clear();
            companyPayoutRatio.clear();
            companyDividendDate.clear();
            companyEx_DividendDate.clear();
            companyLastSplitFactor.clear();
            companyLastSplitDate.clear();
            initRows();
            for (Company j : companies) {
                companynames.add(j.getSymbol());
                companyMarketCaps.add(j.getMarketCap());
                companyEnterpriseValues.add(j.getEnterpriseValue());
                companyTrailingPE.add(j.getTrailingPE());
                companyForwardPE.add(j.getForwardPE());
                companyPEGRatio.add(j.getPEGRatio());
                companyPriceSales.add(j.getPriceSales());
                companyPriceBook.add(j.getPriceBook());
                companyEnterpriseValueRevenue.add(j.getEnterpriseValueRevenue());
                companyEnterpriseValueEBITDA.add(j.getEnterpriseValueEBIDTA());
                companyFiscalYearEnds.add(j.getFiscalYearEnds());
                companyMostRecentQuarter.add(j.getMostRecentQuarter());
                companyProfitMargin.add(j.getProfitMargin());
                companyOperatingMargin.add(j.getOperatingMargin());
                companyReturnOnAssets.add(j.getReturnOnAssets());
                companyReturnOnEquity.add(j.getReturnOnEquity());
                companyRevenue.add(j.getRevenue());
                companyRevenuePerShare.add(j.getRevenuePerShare());
                companyQtrlyRevenueGrowth.add(j.getQtrlyRevenueGrowth());
                companyGrossProfit.add(j.getGrossProfit());
                companyEBITDA.add(j.getEBITDA());
                companyNetIncomeAvlToCommon.add(j.getnetIncomeAvlToCommon());
                companyDilutedEPS.add(j.getdilutedEPS());
                companyQtrlyEarningsGrowth.add(j.getqtrlyEarningsGrowth());
                companyTotalCash.add(j.gettotalCash());
                companyTotalCashPerShare.add(j.gettotalCashPerShare());
                companyTotalDebt.add(j.getTotalDebt());
                companyTotalDebtEquity.add(j.getTotalDebtEquity());
                companyCurrentRatio.add(j.getCurrentRatio());
                companyBookValuePerShare.add(j.getBookValuePerShare());
                companyOperatingCashFlow.add(j.getOperatingCashFlow());
                companyLeveredFreeCashFlow.add(j.getLeveredFreeCashFlow());
                companyBeta.add(j.getBeta());
                companyP_52_WeekChange.add(j.getP_52_WeekChange());
                companySP50052_WeekChange.add(j.getSP50052_WeekChange());
                companyP_52_WeekHigh.add(j.getP_52_WeekHigh());
                companyP_52_WeekLow.add(j.getP_52_WeekLow());
                companyP_50_DayMovingAverage.add(j.getP_50_DayMovingAverage());
                companyP_200_DayMovingAverage.add(j.getP_200_DayMovingAverage());
                companyAvgVol.add(j.getAvgVol1());
                companyAvgVol1.add(j.getAvgVol2());
                companySharesOutstanding.add(j.getSharesOutstanding());
                companyShareFloat.add(j.getShareFloat());
                companyPercentageHeldByInsiders.add(j.getPercentageHeldByInsiders());
                companyPercentageHeldByInstitutions.add(j.getPercentageHeldByInstitutions());
                companySharesShort1.add(j.getSharesShort1());
                companyShortRatio.add(j.getShortRatio());
                companyShortPercentage.add(j.getShortPercentage());
                companySharesShort2.add(j.getSharesShort2());
                companyForwardAnnualDividendRate.add(j.getForwardAnnualDividendRate());
                companyForwardAnnualDividendYield.add(j.getForwardAnnualDividendYield());
                companyTrailingAnnualDividendYieldp.add(j.getTrailingAnnualDividendYieldp());
                companyTrailingAnnualDividendYieldn.add(j.getTrailingAnnualDividendYieldn());
                companyP_5YearAverageDividendYield.add(j.getP_5YearAverageDividendYield());
                companyPayoutRatio.add(j.getPayoutRatio());
                companyDividendDate.add(j.getDividendDate());
                companyEx_DividendDate.add(j.getEx_DividendDate());
                companyLastSplitFactor.add(j.getLastSplitFactor());
                companyLastSplitDate.add(j.getLastSplitDate());
            }
            tm2.setRowCount(0);
            tm2.addRow(companynames.toArray());
            tm2.addRow(companyMarketCaps.toArray());
            tm2.addRow(companyEnterpriseValues.toArray());
            tm2.addRow(companyTrailingPE.toArray());
            tm2.addRow(companyForwardPE.toArray());
            tm2.addRow(companyPEGRatio.toArray());
            tm2.addRow(companyPriceSales.toArray());
            tm2.addRow(companyPriceBook.toArray());
            tm2.addRow(companyEnterpriseValueRevenue.toArray());
            tm2.addRow(companyEnterpriseValueEBITDA.toArray());
            tm2.addRow(companyFiscalYearEnds.toArray());
            tm2.addRow(companyMostRecentQuarter.toArray());
            tm2.addRow(companyProfitMargin.toArray());
            tm2.addRow(companyOperatingMargin.toArray());
            tm2.addRow(companyReturnOnAssets.toArray());
            tm2.addRow(companyReturnOnEquity.toArray());
            tm2.addRow(companyRevenue.toArray());
            tm2.addRow(companyRevenuePerShare.toArray());
            tm2.addRow(companyQtrlyRevenueGrowth.toArray());
            tm2.addRow(companyGrossProfit.toArray());
            tm2.addRow(companyEBITDA.toArray());
            tm2.addRow(companyNetIncomeAvlToCommon.toArray());
            tm2.addRow(companyDilutedEPS.toArray());
            tm2.addRow(companyQtrlyEarningsGrowth.toArray());
            tm2.addRow(companyTotalCash.toArray());
            tm2.addRow(companyTotalCashPerShare.toArray());
            tm2.addRow(companyTotalDebt.toArray());
            tm2.addRow(companyTotalDebtEquity.toArray());
            tm2.addRow(companyCurrentRatio.toArray());
            tm2.addRow(companyBookValuePerShare.toArray());
            tm2.addRow(companyOperatingCashFlow.toArray());
            tm2.addRow(companyLeveredFreeCashFlow.toArray());
            tm2.addRow(companyBeta.toArray());
            tm2.addRow(companyP_52_WeekChange.toArray());
            tm2.addRow(companySP50052_WeekChange.toArray());
            tm2.addRow(companyP_52_WeekHigh.toArray());
            tm2.addRow(companyP_52_WeekLow.toArray());
            tm2.addRow(companyP_50_DayMovingAverage.toArray());
            tm2.addRow(companyP_200_DayMovingAverage.toArray());
            tm2.addRow(companyAvgVol.toArray());
            tm2.addRow(companyAvgVol.toArray());
            tm2.addRow(companySharesOutstanding.toArray());
            tm2.addRow(companyShareFloat.toArray());
            tm2.addRow(companyPercentageHeldByInsiders.toArray());
            tm2.addRow(companyPercentageHeldByInstitutions.toArray());
            tm2.addRow(companySharesShort1.toArray());
            tm2.addRow(companyShortRatio.toArray());
            tm2.addRow(companyShortPercentage.toArray());
            tm2.addRow(companySharesShort2.toArray());
            tm2.addRow(companyForwardAnnualDividendRate.toArray());
            tm2.addRow(companyForwardAnnualDividendYield.toArray());
            tm2.addRow(companyTrailingAnnualDividendYieldp.toArray());
            tm2.addRow(companyTrailingAnnualDividendYieldn.toArray());
            tm2.addRow(companyP_5YearAverageDividendYield.toArray());
            tm2.addRow(companyPayoutRatio.toArray());
            tm2.addRow(companyDividendDate.toArray());
            tm2.addRow(companyEx_DividendDate.toArray());
            tm2.addRow(companyLastSplitFactor.toArray());
            tm2.addRow(companyLastSplitDate.toArray());
            gui.showSpread();
        }
    }

    private class excelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Sample sheet");
            Map<Integer, Object[]> data = new HashMap<>();
            companynames.clear();
            companyMarketCaps.clear();
            companyEnterpriseValues.clear();
            companyTrailingPE.clear();
            companyForwardPE.clear();
            companyPEGRatio.clear();
            companyPriceSales.clear();
            companyPriceBook.clear();
            companyEnterpriseValueRevenue.clear();
            companyEnterpriseValueEBITDA.clear();
            companyFiscalYearEnds.clear();
            companyMostRecentQuarter.clear();
            companyProfitMargin.clear();
            companyOperatingMargin.clear();
            companyReturnOnAssets.clear();
            companyReturnOnEquity.clear();
            companyRevenue.clear();
            companyRevenuePerShare.clear();
            companyQtrlyRevenueGrowth.clear();
            companyGrossProfit.clear();
            companyEBITDA.clear();
            companyNetIncomeAvlToCommon.clear();
            companyDilutedEPS.clear();
            companyQtrlyEarningsGrowth.clear();
            companyTotalCash.clear();
            companyTotalCashPerShare.clear();
            companyTotalDebt.clear();
            companyTotalDebtEquity.clear();
            companyCurrentRatio.clear();
            companyBookValuePerShare.clear();
            companyOperatingCashFlow.clear();
            companyLeveredFreeCashFlow.clear();
            companyBeta.clear();
            companyP_52_WeekChange.clear();
            companySP50052_WeekChange.clear();
            companyP_52_WeekHigh.clear();
            companyP_52_WeekLow.clear();
            companyP_50_DayMovingAverage.clear();
            companyP_200_DayMovingAverage.clear();
            companyAvgVol.clear();
            companyAvgVol1.clear();
            companySharesOutstanding.clear();
            companyShareFloat.clear();
            companyPercentageHeldByInsiders.clear();
            companyPercentageHeldByInstitutions.clear();
            companySharesShort1.clear();
            companyShortRatio.clear();
            companyShortPercentage.clear();
            companySharesShort2.clear();
            companyForwardAnnualDividendRate.clear();
            companyForwardAnnualDividendYield.clear();
            companyTrailingAnnualDividendYieldp.clear();
            companyTrailingAnnualDividendYieldn.clear();
            companyP_5YearAverageDividendYield.clear();
            companyPayoutRatio.clear();
            companyDividendDate.clear();
            companyEx_DividendDate.clear();
            companyLastSplitFactor.clear();
            companyLastSplitDate.clear();
            initRows();
            for (Company j : companies) {
                companynames.add(j.getSymbol());
                companyMarketCaps.add(j.getMarketCap());
                companyEnterpriseValues.add(j.getEnterpriseValue());
                companyTrailingPE.add(j.getTrailingPE());
                companyForwardPE.add(j.getForwardPE());
                companyPEGRatio.add(j.getPEGRatio());
                companyPriceSales.add(j.getPriceSales());
                companyPriceBook.add(j.getPriceBook());
                companyEnterpriseValueRevenue.add(j.getEnterpriseValueRevenue());
                companyEnterpriseValueEBITDA.add(j.getEnterpriseValueEBIDTA());
                companyFiscalYearEnds.add(j.getFiscalYearEnds());
                companyMostRecentQuarter.add(j.getMostRecentQuarter());
                companyProfitMargin.add(j.getProfitMargin());
                companyOperatingMargin.add(j.getOperatingMargin());
                companyReturnOnAssets.add(j.getReturnOnAssets());
                companyReturnOnEquity.add(j.getReturnOnEquity());
                companyRevenue.add(j.getRevenue());
                companyRevenuePerShare.add(j.getRevenuePerShare());
                companyQtrlyRevenueGrowth.add(j.getQtrlyRevenueGrowth());
                companyGrossProfit.add(j.getGrossProfit());
                companyEBITDA.add(j.getEBITDA());
                companyNetIncomeAvlToCommon.add(j.getnetIncomeAvlToCommon());
                companyDilutedEPS.add(j.getdilutedEPS());
                companyQtrlyEarningsGrowth.add(j.getqtrlyEarningsGrowth());
                companyTotalCash.add(j.gettotalCash());
                companyTotalCashPerShare.add(j.gettotalCashPerShare());
                companyTotalDebt.add(j.getTotalDebt());
                companyTotalDebtEquity.add(j.getTotalDebtEquity());
                companyCurrentRatio.add(j.getCurrentRatio());
                companyBookValuePerShare.add(j.getBookValuePerShare());
                companyOperatingCashFlow.add(j.getOperatingCashFlow());
                companyLeveredFreeCashFlow.add(j.getLeveredFreeCashFlow());
                companyBeta.add(j.getBeta());
                companyP_52_WeekChange.add(j.getP_52_WeekChange());
                companySP50052_WeekChange.add(j.getSP50052_WeekChange());
                companyP_52_WeekHigh.add(j.getP_52_WeekHigh());
                companyP_52_WeekLow.add(j.getP_52_WeekLow());
                companyP_50_DayMovingAverage.add(j.getP_50_DayMovingAverage());
                companyP_200_DayMovingAverage.add(j.getP_200_DayMovingAverage());
                companyAvgVol.add(j.getAvgVol1());
                companyAvgVol1.add(j.getAvgVol2());
                companySharesOutstanding.add(j.getSharesOutstanding());
                companyShareFloat.add(j.getShareFloat());
                companyPercentageHeldByInsiders.add(j.getPercentageHeldByInsiders());
                companyPercentageHeldByInstitutions.add(j.getPercentageHeldByInstitutions());
                companySharesShort1.add(j.getSharesShort1());
                companyShortRatio.add(j.getShortRatio());
                companyShortPercentage.add(j.getShortPercentage());
                companySharesShort2.add(j.getSharesShort2());
                companyForwardAnnualDividendRate.add(j.getForwardAnnualDividendRate());
                companyForwardAnnualDividendYield.add(j.getForwardAnnualDividendYield());
                companyTrailingAnnualDividendYieldp.add(j.getTrailingAnnualDividendYieldp());
                companyTrailingAnnualDividendYieldn.add(j.getTrailingAnnualDividendYieldn());
                companyP_5YearAverageDividendYield.add(j.getP_5YearAverageDividendYield());
                companyPayoutRatio.add(j.getPayoutRatio());
                companyDividendDate.add(j.getDividendDate());
                companyEx_DividendDate.add(j.getEx_DividendDate());
                companyLastSplitFactor.add(j.getLastSplitFactor());
                companyLastSplitDate.add(j.getLastSplitDate());
            }
            data.put(1, companynames.toArray());
            data.put(2, companyMarketCaps.toArray());
            data.put(3, companyEnterpriseValues.toArray());
            data.put(4, companyTrailingPE.toArray());
            data.put(5, companyForwardPE.toArray());
            data.put(6, companyPEGRatio.toArray());
            data.put(7, companyPriceSales.toArray());
            data.put(8, companyPriceBook.toArray());
            data.put(9, companyEnterpriseValueRevenue.toArray());
            data.put(10, companyEnterpriseValueEBITDA.toArray());
            data.put(11, companyFiscalYearEnds.toArray());
            data.put(12, companyMostRecentQuarter.toArray());
            data.put(13, companyProfitMargin.toArray());
            data.put(14, companyOperatingMargin.toArray());
            data.put(15, companyReturnOnAssets.toArray());
            data.put(16, companyReturnOnEquity.toArray());
            data.put(17, companyRevenue.toArray());
            data.put(18, companyRevenuePerShare.toArray());
            data.put(19, companyQtrlyRevenueGrowth.toArray());
            data.put(20, companyGrossProfit.toArray());
            data.put(21, companyEBITDA.toArray());
            data.put(22, companyNetIncomeAvlToCommon.toArray());
            data.put(23, companyDilutedEPS.toArray());
            data.put(24, companyQtrlyEarningsGrowth.toArray());
            data.put(25, companyTotalCash.toArray());
            data.put(26, companyTotalCashPerShare.toArray());
            data.put(27, companyTotalDebt.toArray());
            data.put(28, companyTotalDebtEquity.toArray());
            data.put(29, companyCurrentRatio.toArray());
            data.put(30, companyBookValuePerShare.toArray());
            data.put(31, companyOperatingCashFlow.toArray());
            data.put(32, companyLeveredFreeCashFlow.toArray());
            data.put(33, companyBeta.toArray());
            data.put(34, companyP_52_WeekChange.toArray());
            data.put(35, companySP50052_WeekChange.toArray());
            data.put(36, companyP_52_WeekHigh.toArray());
            data.put(37, companyP_52_WeekLow.toArray());
            data.put(38, companyP_50_DayMovingAverage.toArray());
            data.put(39, companyP_200_DayMovingAverage.toArray());
            data.put(40, companyAvgVol.toArray());
            data.put(41, companyAvgVol1.toArray());
            data.put(42, companySharesOutstanding.toArray());
            data.put(43, companyShareFloat.toArray());
            data.put(44, companyPercentageHeldByInsiders.toArray());
            data.put(45, companyPercentageHeldByInstitutions.toArray());
            data.put(46, companySharesShort1.toArray());
            data.put(47, companyShortRatio.toArray());
            data.put(48, companyShortPercentage.toArray());
            data.put(49, companySharesShort2.toArray());
            data.put(50, companyForwardAnnualDividendRate.toArray());
            data.put(51, companyForwardAnnualDividendYield.toArray());
            data.put(52, companyTrailingAnnualDividendYieldp.toArray());
            data.put(53, companyTrailingAnnualDividendYieldn.toArray());
            data.put(54, companyP_5YearAverageDividendYield.toArray());
            data.put(55, companyPayoutRatio.toArray());
            data.put(56, companyDividendDate.toArray());
            data.put(57, companyEx_DividendDate.toArray());
            data.put(58, companyLastSplitFactor.toArray());
            data.put(59, companyLastSplitDate.toArray());
            Set<Integer> keyset = data.keySet();
            int rownum = 0;
            for (Integer key : keyset) {
                HSSFRow row = sheet.createRow(rownum++);
                Object[] objArr = data.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    HSSFCell cell = row.createCell(cellnum++);
                    if (obj instanceof Date) {
                        cell.setCellValue((Date) obj);
                    } else if (obj instanceof Boolean) {
                        cell.setCellValue((Boolean) obj);
                    } else if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Double) {
                        cell.setCellValue((Double) obj);
                    }
                }
            }
            try {
                try (FileOutputStream out = new FileOutputStream(new File("new.xls"))) {
                    workbook.write(out);
                }
                try {
                    Desktop.getDesktop().open(new File("new.xls"));
                } catch (IOException k) {
                }

            } catch (FileNotFoundException ex) {
                gui.showDialog();
                clearData();
                initRows();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
