/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg_1;

import javax.script.*;

public class invokeScript {
    public static final String script
            = "var BASE_URI = 'http://query.yahooapis.com/v1/yql';\n" +
            "var yql_results =\"\";\n" +
            "var yql_query = \"SELECT * FROM yahoo.finance.balancesheet WHERE symbol='KMB'\";\n" +
            "\n" +
            "\n" +
            "function handler(rsp) {\n" +
            "    if(rsp.data) {\n" +
            "        yql_results = rsp.data; \n" +
            "    }\n" +
            "    console.log(rsp.data.toString());\n" +
            "}";
    
            
        public static void main(String[] args) throws Exception {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");

            engine.eval(script);
            Invocable inv =(Invocable) engine;

            inv.invokeFunction("handler", "rsp");
        }
}
