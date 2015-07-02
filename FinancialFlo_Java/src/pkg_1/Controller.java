
package pkg_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;



public class Controller {
    private final Model model;
    private final GUI gui;
    private final DefaultTableModel tm;
    
    public Controller(Model model, GUI gui) {
        this.model = model;
        this.gui = gui;
        tm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) { //makes the cells in the table uneditable
                return false;
            }
        };
        this.gui.addSearchBarListener(new searchListener());
        gui.setTableModel(tm);
        tm.addColumn("Symbol");
        tm.addColumn("Company");
        tm.addColumn("Market Price");
        
    }
    
    public Company getCompany(String name) throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
        GetHTMLData k = new GetHTMLData();
        Company c = k.getData(name);
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
}
