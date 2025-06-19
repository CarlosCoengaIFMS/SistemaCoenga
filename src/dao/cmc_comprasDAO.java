/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.cmc_compras;
import dao.DAO_Abstract;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cmc_comprasDAO extends DAO_Abstract {
    private Connection cnt;

//    public cmc_comprasDAO() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://10.7.0.51:33062/db_carlos_coenga";
//            String user = "carlos_coenga";
//            String pass = "carlos_coenga";
//            this.cnt = DriverManager.getConnection(url, user, pass);
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(cmc_comprasDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public cmc_comprasDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db_carlos_coenga";
            String user = "root";
            String pass = "16515647";
            this.cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cmc_clientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(Object object) {
       cmc_compras compra = (cmc_compras) object;
    try (PreparedStatement pst = cnt.prepareStatement(
            "INSERT INTO compra (id_compra, quantidade, data_compra, status, valor_total) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

        pst.setInt(1, compra.getCmc_id_compra());
        pst.setInt(2, compra.getCmc_quantidade());
        pst.setDate(3,null); // data atual
        pst.setString(4, compra.getCmc_status());
        pst.setDouble(5, compra.getCmc_valor_total()); // ou setBigDecimal

        if (pst.executeUpdate() > 0) {
            System.out.println("Compra inserida com sucesso.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(cmc_comprasDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void update(Object objeto) {
    cmc_compras compra = (cmc_compras) objeto;
    try (PreparedStatement pst = cnt.prepareStatement(
            "UPDATE compra SET  quantidade=?, data_compra=?, status=?, valor_total=? WHERE id_compra=?")) {

        pst.setInt(1, compra.getCmc_quantidade());
        pst.setDate(2, new java.sql.Date(System.currentTimeMillis())); // data atual
        pst.setString(3, compra.getCmc_status());
        pst.setDouble(4, compra.getCmc_valor_total());
        pst.setInt(5, compra.getCmc_id_compra());

        if (pst.executeUpdate() > 0) {
            System.out.println("Compra atualizada com sucesso.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(cmc_comprasDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void delete(Object objeto) {
     cmc_compras compra = (cmc_compras) objeto;
        try (PreparedStatement pst = cnt.prepareStatement("DELETE FROM compra WHERE id_compra=?")) {
            pst.setInt(1, compra.getCmc_id_compra());
            
            if (pst.executeUpdate() > 0) {
                System.out.println("Compra excluída com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_comprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       @Override
public Object list(int codigo) {
    try (PreparedStatement pst = cnt.prepareStatement("SELECT * FROM compra WHERE cmc_id_compra=?")) {
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            cmc_compras compra = new cmc_compras();
            compra.setCmc_id_compra(rs.getInt("id_compra"));
            compra.setCmc_quantidade(rs.getInt("quantidade"));
            compra.setCmc_data_compra(rs.getDate("data_compra"));
            compra.setCmc_status(rs.getString("status"));
            compra.setCmc_valor_total(rs.getDouble("valor_total"));
            return compra;
        }
    } catch (SQLException ex) {
        Logger.getLogger(cmc_comprasDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}


   @Override
public ArrayList<cmc_compras> listAll() {
    ArrayList<cmc_compras> lista = new ArrayList<>();
    try (Statement stmt = cnt.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM compra")) {

        while (rs.next()) {
            cmc_compras compra = new cmc_compras();
            compra.setCmc_id_compra(rs.getInt("id_compra"));
            compra.setCmc_quantidade(rs.getInt("quantidade"));
            compra.setCmc_data_compra(rs.getDate("data_compra"));
            compra.setCmc_status(rs.getString("status"));
            compra.setCmc_valor_total(rs.getDouble("valor_total"));
            lista.add(compra);
        }
    } catch (SQLException ex) {
        Logger.getLogger(cmc_comprasDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return lista;
}

}