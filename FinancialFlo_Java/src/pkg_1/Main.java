/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Kevin
 */
public class Main {
        public static void main(String[] args) throws IOException, MalformedURLException, ParserConfigurationException, SAXException {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            TreeMap<String, Company> companyMap = new TreeMap();
            Model model = null;
            try {
                model = new Model(companyMap);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            GUI gui = new GUI();
            Controller controller = new Controller(model,gui);
            gui.setVisible(true);
            }
        });
    }
}
