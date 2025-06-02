/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.cmc_fornecedores;
import dao.DAO_Abstract;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cmc_fornecedoresDAO extends DAO_Abstract {
    private Connection cnt;

    public cmc_fornecedoresDAO() {
        try {
             Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.7.0.51:33062/db_carlos_coenga";
            String user = "carlos_coenga";
            String pass = "carlos_coenga";
            this.cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cmc_fornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(Object object) {
        cmc_fornecedores fornecedor = (cmc_fornecedores) object;
        try (PreparedStatement pst = cnt.prepareStatement("INSERT INTO fornecedores VALUES (?, ?, ?, ?, ?)")) {
            pst.setInt(1, fornecedor.getCmc_id_fornecedor());
            pst.setString(2, fornecedor.getCmc_nome());
            pst.setString(3, fornecedor.getCmc_cnpj());
            pst.setString(4, fornecedor.getCmc_telefone());
            pst.setString(5, fornecedor.getCmc_email());
            
            if (pst.executeUpdate() > 0) {
                System.out.println("Fornecedor inserido com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_fornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object objeto) {
        cmc_fornecedores fornecedor = (cmc_fornecedores) objeto;
        try (PreparedStatement pst = cnt.prepareStatement(
                "UPDATE fornecedores SET nome=?, cnpj=?, telefone=?, email=? WHERE id_fornecedor=?")) {
            pst.setString(1, fornecedor.getCmc_nome());
            pst.setString(2, fornecedor.getCmc_cnpj());
            pst.setString(3, fornecedor.getCmc_telefone());
            pst.setString(4, fornecedor.getCmc_email());
            pst.setInt(5, fornecedor.getCmc_id_fornecedor());
            
            if (pst.executeUpdate() > 0) {
                System.out.println("Fornecedor atualizado com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_fornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        cmc_fornecedores fornecedor = (cmc_fornecedores) objeto;
        try (PreparedStatement pst = cnt.prepareStatement("DELETE FROM fornecedores WHERE id_fornecedor=?")) {
            pst.setInt(1, fornecedor.getCmc_id_fornecedor());
            
            if (pst.executeUpdate() > 0) {
                System.out.println("Fornecedor excluído com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_fornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int codigo) {
        try (PreparedStatement pst = cnt.prepareStatement("SELECT * FROM fornecedores WHERE id_fornecedor=?")) {
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                cmc_fornecedores fornecedor = new cmc_fornecedores();
                fornecedor.setCmc_id_fornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setCmc_nome(rs.getString("nome"));
                fornecedor.setCmc_cnpj(rs.getString("cnpj"));
                fornecedor.setCmc_telefone(rs.getString("telefone"));
                fornecedor.setCmc_email(rs.getString("email"));
                return fornecedor;
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_fornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<cmc_fornecedores> listAll() {
        ArrayList<cmc_fornecedores> lista = new ArrayList<>();
        try (Statement stmt = cnt.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM fornecedores")) {
            
            while (rs.next()) {
                cmc_fornecedores fornecedor = new cmc_fornecedores();
                fornecedor.setCmc_id_fornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setCmc_nome(rs.getString("nome"));
                fornecedor.setCmc_cnpj(rs.getString("cnpj"));
                fornecedor.setCmc_telefone(rs.getString("telefone"));
                fornecedor.setCmc_email(rs.getString("email"));
                lista.add(fornecedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_fornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void close() {
        try {
            if (cnt != null && !cnt.isClosed()) {
                cnt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_fornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}