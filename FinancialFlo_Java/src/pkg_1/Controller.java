
package pkg_1;

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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private final List<String> companynames;
    private List<String> companyMarketCaps;
    
    public Controller(Model model, GUI gui) {
        this.model = model;
        this.gui = gui;
        tm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) { //makes the cells in the table uneditable
                return false;
            }
        };
        this.companies = new ArrayList();
        this.companynames = new ArrayList();
        this.companyMarketCaps = new ArrayList();
        companynames.add("");
        companyMarketCaps.add("Market Cap");
        this.gui.addSearchBarListener(new searchListener());
        this.gui.addExcelButtonListener(new excelListener());
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
    
    
    private class searchListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = gui.getSearchText();
            try {
                Company c = getCompany(s);
                tm.addRow(new Object[]{c.getSymbol(), " ", " "});
            } catch (IOException | ParserConfigurationException | SAXException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            }
            data.put("1", companynames.toArray());
            data.put("2", companyMarketCaps.toArray());
            Set<String> keyset = data.keySet();
            System.out.println(data.keySet().toString());       
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
                try (FileOutputStream out = new FileOutputStream(new File("new.xls"))) {
                    workbook.write(out);
                }
                System.out.println("Excel written successfully..");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

