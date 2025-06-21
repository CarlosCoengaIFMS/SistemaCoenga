/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.cmc_clientes;
import bean.cmc_clientes;
import bean.cmc_compras_produtos;
import dao.DAO_Abstract;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class cmc_clientesDAO extends DAO_Abstract {
    private Connection cnt;

//    public cmc_clientesDAO() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://10.7.0.51:33062/db_carlos_coenga";
//            String user = "carlos_coenga";
//            String pass = "carlos_coenga";
//            this.cnt = DriverManager.getConnection(url, user, pass);
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(cmc_clientesDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
     public cmc_clientesDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/db_carlos_coenga";
            String user = "root";
            String pass = "16515647";
            this.cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cmc_clientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(Object object) {
        cmc_compras_produtos item = (cmc_compras_produtos) object;
        try (PreparedStatement pst = cnt.prepareStatement("INSERT INTO cmc_compras_produtos VALUES (?, ?, ?, ?, ?, ?)")) {
            pst.setInt(1, item.getCmc_id_compra_produto());
            pst.setInt(2, item.getCmc_id_compra());
            pst.setInt(3, item.getCmc_id_produto());
            pst.setInt(4, item.getCmc_quantidade());
            pst.setDouble(5, item.getCmc_valor_unitario());
            pst.setDouble(6, item.getCmc_valor_total());

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Inserção realizada com sucesso.");
            } else {
                System.out.println("Erro na inserção.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_compras_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Object objeto) {
        cmc_compras_produtos item = (cmc_compras_produtos) objeto;
        try (PreparedStatement pst = cnt.prepareStatement(
                "UPDATE cmc_compras_produtos SET cmc_id_compra=?, cmc_id_produto=?, cmc_quantidade=?, cmc_valor_unitario=?, cmc_valor_total=? WHERE cmc_id_compra_produto=?")) {

            pst.setInt(1, item.getCmc_id_compra());
            pst.setInt(2, item.getCmc_id_produto());
            pst.setInt(3, item.getCmc_quantidade());
            pst.setDouble(4, item.getCmc_valor_unitario());
            pst.setDouble(5, item.getCmc_valor_total());
            pst.setInt(6, item.getCmc_id_compra_produto());

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Atualização realizada com sucesso.");
            } else {
                System.out.println("Erro na atualização.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_compras_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Object objeto) {
        cmc_compras_produtos item = (cmc_compras_produtos) objeto;
        try (PreparedStatement pst = cnt.prepareStatement("DELETE FROM cmc_compras_produtos WHERE cmc_id_compra_produto=?")) {
            pst.setInt(1, item.getCmc_id_compra_produto());

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Exclusão realizada com sucesso.");
            } else {
                System.out.println("Erro na exclusão.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_compras_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object list(int codigo) {
        try (PreparedStatement pst = cnt.prepareStatement("SELECT * FROM cmc_compras_produtos WHERE cmc_id_compra_produto=?")) {
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cmc_compras_produtos item = new cmc_compras_produtos();
                item.setCmc_id_compra_produto(rs.getInt("cmc_id_compra_produto"));
                item.setCmc_id_compra(rs.getInt("cmc_id_compra"));
                item.setCmc_id_produto(rs.getInt("cmc_id_produto"));
                item.setCmc_quantidade(rs.getInt("cmc_quantidade"));
                item.setCmc_valor_unitario(rs.getDouble("cmc_valor_unitario"));
                item.setCmc_valor_total(rs.getDouble("cmc_valor_total"));
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_compras_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<cmc_compras_produtos> listAll() {
        ArrayList<cmc_compras_produtos> lista = new ArrayList<>();
        try (Statement stmt = cnt.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM cmc_compras_produtos")) {

            while (rs.next()) {
                cmc_compras_produtos item = new cmc_compras_produtos();
                item.setCmc_id_compra_produto(rs.getInt("cmc_id_compra_produto"));
                item.setCmc_id_compra(rs.getInt("cmc_id_compra"));
                item.setCmc_id_produto(rs.getInt("cmc_id_produto"));
                item.setCmc_quantidade(rs.getInt("cmc_quantidade"));
                item.setCmc_valor_unitario(rs.getDouble("cmc_valor_unitario"));
                item.setCmc_valor_total(rs.getDouble("cmc_valor_total"));
                lista.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_compras_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void close() {
        try {
            if (cnt != null && !cnt.isClosed()) {
                cnt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_compras_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}