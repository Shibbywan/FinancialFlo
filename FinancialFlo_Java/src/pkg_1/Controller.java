
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
    private final GetData getdata;
    private final DefaultTableModel tm;
    
    public Controller(Model model, GUI gui, GetData getdata) {
        this.model = model;
        this.gui = gui;
        this.getdata = getdata;
        tm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) { //makes the cells in the table uneditable
                return false;
            }
        };
        this.gui.addSearchBarListener(new searchListener());
    }
    
    public void getCompany(String name) throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
        if (this.model.getMap().contains(name)) {
            model.addToMap(name, this.getdata.requestData(name));
        } else {
            System.out.println("The Company does not exist\n");
        }
    }
    
    private class searchListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = gui.getSearchText();
            try {
                getCompany(s);
            } catch (IOException | ParserConfigurationException | SAXException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
