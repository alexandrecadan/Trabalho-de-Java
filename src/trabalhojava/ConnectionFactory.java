/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alexandre
 */
public class ConnectionFactory {
     public Connection getConnection() {
         try {
            return
        DriverManager.getConnection("jdbc:mysql://localhost/java",
        "root", "Jeancl96");
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
}
