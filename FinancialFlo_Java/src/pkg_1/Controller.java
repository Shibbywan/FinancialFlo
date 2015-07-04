
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Date;
import java.util.HashSet;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;


public class Controller {
    private final Model model;
    private final GUI gui;
    private final DefaultTableModel tm;
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
    
    public Controller(Model model, GUI gui) {
        this.model = model;
        this.gui = gui;
        gui.hideLoad();
        tm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) { //makes the cells in the table uneditable
                return false;
            }
        };
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
        this.gui.addSearchBarListener(new searchListener());
        this.gui.addExcelButtonListener(new excelListener());
        this.gui.addClearButtonListener(new clearListener());
        this.gui.addDialogOKListener(new dialogListener());
        gui.setTableModel(tm);
        tm.addColumn("Symbol");
        tm.addColumn("Company");
        tm.addColumn("Market Price");
        
    }
    
    public Company getCompany(String name) throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
        GetHTMLData k = new GetHTMLData();
        Company c = k.getData(name);
        companies.add(c);
        companynames.add(name);
        return c;
    }
    
    
    private class searchListener extends SwingWorker<String, Object> implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
                gui.showLoad();
                execute();
        }

        @Override
        protected String doInBackground() throws Exception {
            System.out.println("started");
            String s = gui.getSearchText();
            try {
                Company c = getCompany(s);
                tm.addRow(new Object[]{c.getSymbol(), " ", " "});
            } catch (IOException | ParserConfigurationException | SAXException ex) {
                gui.showDialog();
                gui.setDialogText("Connection Interrupted");
            }
            System.out.println("yeah");
            return "ok";
        }
        @Override
        protected void done() {
            System.out.println("done");
            gui.hideLoad();
        }
    }
    
    private class clearListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            companies.clear();
            companynames.clear();
            tm.setRowCount(0);
            companynames.add("Symbol");
        }
    }
    
    private class dialogListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.hideDialog();
        }
    }
    
    private class excelListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Sample sheet");
            Map<String, Object[]> data = new HashMap<>();
            for (Company j: companies) {
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
            data.put("0", companynames.toArray());
            data.put("1", companyMarketCaps.toArray());
            data.put("2", companyEnterpriseValues.toArray());
            data.put("3", companyTrailingPE.toArray());
            data.put("4", companyForwardPE.toArray());
            data.put("5", companyPEGRatio.toArray());
            data.put("6", companyPriceSales.toArray());
            data.put("7", companyPriceBook.toArray());
            data.put("8", companyEnterpriseValueRevenue.toArray());
            data.put("9", companyEnterpriseValueEBITDA.toArray());
            data.put("A", companyFiscalYearEnds.toArray());
            data.put("B", companyMostRecentQuarter.toArray());
            data.put("C", companyProfitMargin.toArray());
            data.put("D", companyOperatingMargin.toArray());
            data.put("E", companyReturnOnAssets.toArray());
            data.put("F", companyReturnOnEquity.toArray());
            data.put("G", companyRevenue.toArray());
            data.put("H", companyRevenuePerShare.toArray());
            data.put("I", companyQtrlyRevenueGrowth.toArray());
            data.put("J", companyGrossProfit.toArray());
            data.put("K", companyEBITDA.toArray());
            data.put("L", companyNetIncomeAvlToCommon.toArray());
            data.put("M", companyDilutedEPS.toArray());
            data.put("N", companyQtrlyEarningsGrowth.toArray());
            data.put("O", companyTotalCash.toArray());
            data.put("P", companyTotalCashPerShare.toArray());
            data.put("Q", companyTotalDebt.toArray());
            data.put("R", companyTotalDebtEquity.toArray());
            data.put("S", companyCurrentRatio.toArray());
            data.put("T", companyBookValuePerShare.toArray());
            data.put("U", companyOperatingCashFlow.toArray());
            data.put("V", companyLeveredFreeCashFlow.toArray());
            data.put("W", companyBeta.toArray());
            data.put("X", companyP_52_WeekChange.toArray());
            data.put("Y", companySP50052_WeekChange.toArray());
            data.put("Z", companyP_52_WeekHigh.toArray());
            data.put("a", companyP_52_WeekLow.toArray());
            data.put("b", companyP_50_DayMovingAverage.toArray());
            data.put("c", companyP_200_DayMovingAverage.toArray());
            data.put("d", companyAvgVol.toArray());
            data.put("e", companyAvgVol1.toArray());
            data.put("f", companySharesOutstanding.toArray());
            data.put("g", companyShareFloat.toArray());
            data.put("h", companyPercentageHeldByInsiders.toArray());
            data.put("i", companyPercentageHeldByInstitutions.toArray());
            data.put("j", companySharesShort1.toArray());
            data.put("k", companyShortRatio.toArray());
            data.put("l", companyShortPercentage.toArray());
            data.put("m", companySharesShort2.toArray());
            data.put("n", companyForwardAnnualDividendRate.toArray());
            data.put("o", companyForwardAnnualDividendYield.toArray());
            data.put("p", companyTrailingAnnualDividendYieldp.toArray());
            data.put("q", companyTrailingAnnualDividendYieldn.toArray());
            data.put("r", companyP_5YearAverageDividendYield.toArray());
            data.put("s", companyPayoutRatio.toArray());
            data.put("t", companyDividendDate.toArray());
            data.put("u", companyEx_DividendDate.toArray());
            data.put("v", companyLastSplitFactor.toArray());
            data.put("w", companyLastSplitDate.toArray());
            Set<String> keyset = data.keySet();
            int rownum = 0;
            for (String key : keyset) {
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
                try (FileOutputStream out = new FileOutputStream(new File("D:\\new.xls"))) {
                    workbook.write(out);
                }
                try {
            Desktop.getDesktop().open(new File("D:\\new.xls"));
            } catch (IOException k) {
            }

            } catch (FileNotFoundException ex) {
                gui.showDialog();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

