/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.cmc_vendas;
import dao.DAO_Abstract;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cmc_vendasDAO extends DAO_Abstract {
    private Connection cnt;

    public cmc_vendasDAO() {
        try {
           Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.7.0.51:33062/db_carlos_coenga";
            String user = "carlos_coenga";
            String pass = "carlos_coenga";
            this.cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cmc_vendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(Object object) {
        cmc_vendas venda = (cmc_vendas) object;
        try (PreparedStatement pst = cnt.prepareStatement("INSERT INTO vendas VALUES (?, ?, ?, ?, ?)")) {
            pst.setInt(1, venda.getCmc_id_venda());
            pst.setInt(2, venda.getCmc_id_cliente());
            pst.setInt(3, venda.getCmc_id_produto());
            pst.setInt(4, venda.getCmc_quantidade());
            pst.setDate(5, new java.sql.Date(venda.getCmc_data_venda().getTime()));
            
            if (pst.executeUpdate() > 0) {
                System.out.println("Venda inserida com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_vendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object objeto) {
        cmc_vendas venda = (cmc_vendas) objeto;
        try (PreparedStatement pst = cnt.prepareStatement(
                "UPDATE vendas SET id_cliente=?, id_produto=?, quantidade=?, data_venda=? WHERE id_venda=?")) {
            pst.setInt(1, venda.getCmc_id_cliente());
            pst.setInt(2, venda.getCmc_id_produto());
            pst.setInt(3, venda.getCmc_quantidade());
            pst.setDate(4, new java.sql.Date(venda.getCmc_data_venda().getTime()));
            pst.setInt(5, venda.getCmc_id_venda());
            
            if (pst.executeUpdate() > 0) {
                System.out.println("Venda atualizada com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_vendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        cmc_vendas venda = (cmc_vendas) objeto;
        try (PreparedStatement pst = cnt.prepareStatement("DELETE FROM vendas WHERE id_venda=?")) {
            pst.setInt(1, venda.getCmc_id_venda());
            
            if (pst.executeUpdate() > 0) {
                System.out.println("Venda excluída com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_vendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int codigo) {
        try (PreparedStatement pst = cnt.prepareStatement("SELECT * FROM vendas WHERE id_venda=?")) {
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                cmc_vendas venda = new cmc_vendas();
                venda.setCmc_id_venda(rs.getInt("id_venda"));
                venda.setCmc_id_cliente(rs.getInt("id_cliente"));
                venda.setCmc_id_produto(rs.getInt("id_produto"));
                venda.setCmc_quantidade(rs.getInt("quantidade"));
                venda.setCmc_data_venda(rs.getDate("data_venda"));
                return venda;
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_vendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<cmc_vendas> listAll() {
        ArrayList<cmc_vendas> lista = new ArrayList<>();
        try (Statement stmt = cnt.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM vendas")) {
            
            while (rs.next()) {
                cmc_vendas venda = new cmc_vendas();
                venda.setCmc_id_venda(rs.getInt("id_venda"));
                venda.setCmc_id_cliente(rs.getInt("id_cliente"));
                venda.setCmc_id_produto(rs.getInt("id_produto"));
                venda.setCmc_quantidade(rs.getInt("quantidade"));
                venda.setCmc_data_venda(rs.getDate("data_venda"));
                lista.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_vendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void close() {
        try {
            if (cnt != null && !cnt.isClosed()) {
                cnt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_vendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}