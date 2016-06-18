/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import static scala.Console.println;

/**
 *
 * @author Kevin
 */
public class QuarterlyProcedure {

    Model model;

    public QuarterlyProcedure(Model model) {
        this.model = model;
    }

    public int runProcedure() throws ClassNotFoundException, SQLException, IOException, MalformedURLException, ParserConfigurationException, SAXException {
        String url = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=FF_DB;user=shibby;password=crimson";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(url);
        int response = 0;
        int current = 0;
        String filename = "progress.txt";
        //TODO: needs error checking
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            current = Integer.parseInt(line);
        }
        response = model.getAndInsertData(conn, current);
        //FileReader in = new FileReader("progress.txt");
        try (Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "utf-8"))) {
            out.write(Integer.toString(response));
        }

        return response;
    }

}
