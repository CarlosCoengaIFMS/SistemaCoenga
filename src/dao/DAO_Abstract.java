/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author notedarckbr
 */
public abstract class DAO_Abstract {
    // foi criado para que não pressise repetir para os outros daos
     private java.sql.Connection cnt;

    public DAO_Abstract(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.7.0.51:33062/db_carlos_coenga";
            String user = "carlos_coenga";
            String pass = "carlos_coenga";
            this.cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAO_Abstract.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(Object object){
    }
    public void update(Object objeto) {
    }
    public void delete(Object objeto) {
    }
    public  Object list(int codigo){
        return null;
    }
    public ArrayList listAll(){
        return null;
    }
}
