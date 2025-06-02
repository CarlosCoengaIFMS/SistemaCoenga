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

    public cmc_comprasDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.7.0.51:33062/db_carlos_coenga";
            String user = "carlos_coenga";
            String pass = "carlos_coenga";
            this.cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cmc_comprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(Object object) {
        cmc_compras compra = (cmc_compras) object;
        try (PreparedStatement pst = cnt.prepareStatement("INSERT INTO compra VALUES (?, ?, ?, ?, ?)")) {
            pst.setInt(1, compra.getCmc_id_compra());
            pst.setInt(2, compra.getCmc_id_fornecedor());
            pst.setInt(3, compra.getCmc_id_produto());
            pst.setInt(4, compra.getCmc_quantidade());
            pst.setDate(5, null);
            pst.setString(6,compra.getCmc_status());
            pst.set(7,compra.getCmc_valor_total());
            
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
                "UPDATE compra SET id_fornecedor=?, id_produto=?, quantidade=?, data_compra=? WHERE id_compra=?")) {
            pst.setInt(1, compra.getCmc_id_fornecedor());
            pst.setInt(2, compra.getCmc_id_produto());
            pst.setInt(3, compra.getCmc_quantidade());
            pst.setDate(4, new java.sql.Date(compra.getCmc_data_compra().getTime()));
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
        try (PreparedStatement pst = cnt.prepareStatement("SELECT * FROM compra WHERE id_compra=?")) {
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                cmc_compras compra = new cmc_compras();
                compra.setCmc_id_compra(rs.getInt("id_compra"));
                compra.setCmc_id_fornecedor(rs.getInt("id_fornecedor"));
                compra.setCmc_id_produto(rs.getInt("id_produto"));
                compra.setCmc_quantidade(rs.getInt("quantidade"));
                compra.setCmc_data_compra(rs.getDate("data_compra"));
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
                compra.setCmc_id_fornecedor(rs.getInt("id_fornecedor"));
                compra.setCmc_id_produto(rs.getInt("id_produto"));
                compra.setCmc_quantidade(rs.getInt("quantidade"));
                compra.setCmc_data_compra(rs.getDate("data_compra"));
                lista.add(compra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_comprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void close() {
        try {
            if (cnt != null && !cnt.isClosed()) {
                cnt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_comprasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}