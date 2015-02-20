package pkg_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class Queries {
    QuandlConnection q;

    public Queries() {
            
        this.q = new QuandlConnection("_L_sd9g2X9JSw5oDVNpS");
        QDataset d1 = this.q.getDataset("PRAGUESE/PX");
        //get dataset between two sets of dates... don't forget to use this format for the date.
        QDataset data2 = q.getDatasetBetweenDates("PRAGUESE/PX","2012-01-01","2012-11-26");
        //get dataset with custom parameters
        HashMap<String, String> params = new HashMap<>();
        params.put("trim_start","2012-09-30");
        QDataset data3 = q.getDatasetWithParams("PRAGUESE/PX");
        //get Dataset as List matrix
        List<List<String>> data3Matrix = data3.getMatrix();
        //get Dataset as String Matrix
        String[][] data3StringMatrix = data3.getStringMatrix();
        System.out.println(Arrays.toString(data3StringMatrix));
        
    }
    
}
