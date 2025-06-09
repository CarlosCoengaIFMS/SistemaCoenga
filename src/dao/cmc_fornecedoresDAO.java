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
        try (PreparedStatement pst = cnt.prepareStatement(
                "INSERT INTO cmc_fornecedores (cmc_nome, cmc_senha, cmc_email, cmc_endereco, cmc_estado, cmc_telefone, cmc_cidade) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            
            pst.setString(1, fornecedor.getCmc_nome());
            pst.setString(2, fornecedor.getCmc_senha());
            pst.setString(3, fornecedor.getCmc_email());
            pst.setString(4, fornecedor.getCmc_endereco());
            pst.setString(5, fornecedor.getCmc_estado());
            pst.setString(6, fornecedor.getCmc_telefone());
            pst.setString(7, fornecedor.getCmc_cidade());
            
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
                "UPDATE cmc_fornecedores SET cmc_nome=?, cmc_senha=?, cmc_email=?, cmc_endereco=?, cmc_estado=?, cmc_telefone=?, cmc_cidade=? WHERE cmc_id_fornecedores=?")) {
            
            pst.setString(1, fornecedor.getCmc_nome());
            pst.setString(2, fornecedor.getCmc_senha());
            pst.setString(3, fornecedor.getCmc_email());
            pst.setString(4, fornecedor.getCmc_endereco());
            pst.setString(5, fornecedor.getCmc_estado());
            pst.setString(6, fornecedor.getCmc_telefone());
            pst.setString(7, fornecedor.getCmc_cidade());
            pst.setInt(8, fornecedor.getCmc_id_fornecedores());
            
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
        try (PreparedStatement pst = cnt.prepareStatement("DELETE FROM cmc_fornecedores WHERE cmc_id_fornecedores=?")) {
            pst.setInt(1, fornecedor.getCmc_id_fornecedores());
            
            if (pst.executeUpdate() > 0) {
                System.out.println("Fornecedor excluído com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_fornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int codigo) {
        try (PreparedStatement pst = cnt.prepareStatement("SELECT * FROM cmc_fornecedores WHERE cmc_id_fornecedores=?")) {
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                cmc_fornecedores fornecedor = new cmc_fornecedores();
                fornecedor.setCmc_id_fornecedores(rs.getInt("cmc_id_fornecedores"));
                fornecedor.setCmc_nome(rs.getString("cmc_nome"));
                fornecedor.setCmc_senha(rs.getString("cmc_senha"));
                fornecedor.setCmc_email(rs.getString("cmc_email"));
                fornecedor.setCmc_endereco(rs.getString("cmc_endereco"));
                fornecedor.setCmc_estado(rs.getString("cmc_estado"));
                fornecedor.setCmc_telefone(rs.getString("cmc_telefone"));
                fornecedor.setCmc_cidade(rs.getString("cmc_cidade"));
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
             ResultSet rs = stmt.executeQuery("SELECT * FROM cmc_fornecedores")) {
            
            while (rs.next()) {
                cmc_fornecedores fornecedor = new cmc_fornecedores();
                fornecedor.setCmc_id_fornecedores(rs.getInt("cmc_id_fornecedores"));
                fornecedor.setCmc_nome(rs.getString("cmc_nome"));
                fornecedor.setCmc_senha(rs.getString("cmc_senha"));
                fornecedor.setCmc_email(rs.getString("cmc_email"));
                fornecedor.setCmc_endereco(rs.getString("cmc_endereco"));
                fornecedor.setCmc_estado(rs.getString("cmc_estado"));
                fornecedor.setCmc_telefone(rs.getString("cmc_telefone"));
                fornecedor.setCmc_cidade(rs.getString("cmc_cidade"));
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