/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_1;

import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;
/**
 *
 * @author Kevin
 */
public class ViewUtil {
    public static String render(String templatePath, HashMap<String, Object> model) {
        return new FreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }
}
