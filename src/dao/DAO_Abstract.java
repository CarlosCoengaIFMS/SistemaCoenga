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
