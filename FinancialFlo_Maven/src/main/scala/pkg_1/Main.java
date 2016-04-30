/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_1;

/**
 *
 * @author Kevin
 */
import java.util.HashMap;
import spark.Spark;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {

        externalStaticFileLocation("src/main/resources");
        get("/", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            ViewUtil view = new ViewUtil();
            return view.render("views/home.html", model);
        });
    }
}