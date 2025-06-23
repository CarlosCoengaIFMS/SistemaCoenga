/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.cmc_produtos;
import dao.DAO_Abstract;
import java.sql.*;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cmc_produtosDAO extends DAO_Abstract {
    private Connection cnt;

    public cmc_produtosDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.7.0.51:33062/db_carlos_coenga";
            String user = "carlos_coenga";
            String pass = "carlos_coenga";
            this.cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cmc_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void insert(Object object) {
        cmc_produtos produto = (cmc_produtos) object;
        try (PreparedStatement pst = cnt.prepareStatement(
                "INSERT INTO cmc_produtos (cmc_id_produtos,  cmc_nome, cmc_descricao, cmc_preco, cmc_categoria, cmc_quantidade, cmc_data_cadastro) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            
            pst.setInt(1, produto.getCmc_id_produtos());
            pst.setString(2, produto.getCmc_nome());
            pst.setString(3, produto.getCmc_descricao());
            pst.setDouble(4, produto.getCmc_preco());
            pst.setString(5, produto.getCmc_categoria());
            pst.setInt(6, produto.getCmc_quantidade());
            pst.setDate(7, null);
            
            if (pst.executeUpdate() > 0) {
                System.out.println("Produto inserido com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object objeto) {
        cmc_produtos produto = (cmc_produtos) objeto;
        try (PreparedStatement pst = cnt.prepareStatement(
                "UPDATE cmc_produtos SET  cmc_nome=?, cmc_descricao=?, cmc_preco=?, cmc_categoria=?, cmc_quantidade=?, cmc_data_cadastro=? WHERE cmc_id_produtos=?")) {
            
            pst.setString(1, produto.getCmc_nome());
            pst.setString(2, produto.getCmc_descricao());
            pst.setDouble(3, produto.getCmc_preco());
            pst.setString(4, produto.getCmc_categoria());
            pst.setInt(5, produto.getCmc_quantidade());
            pst.setDate(6, null);
            pst.setInt(7, produto.getCmc_id_produtos());
            
            
            if (pst.executeUpdate() > 0) {
                System.out.println("Produto atualizado com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        cmc_produtos produto = (cmc_produtos) objeto;
        try (PreparedStatement pst = cnt.prepareStatement("DELETE FROM cmc_produtos WHERE cmc_id_produtos=?")) {
            pst.setInt(1, produto.getCmc_id_produtos());
            
            if (pst.executeUpdate() > 0) {
                System.out.println("Produto excluído com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int codigo) {
        try (PreparedStatement pst = cnt.prepareStatement("SELECT * FROM cmc_produtos WHERE cmc_id_produtos=?")) {
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                cmc_produtos produto = new cmc_produtos();
                produto.setCmc_id_produtos(rs.getInt("cmc_id_produtos"));
                produto.setCmc_nome(rs.getString("cmc_nome"));
                produto.setCmc_descricao(rs.getString("cmc_descricao"));
                produto.setCmc_preco(rs.getDouble("cmc_preco"));
                produto.setCmc_categoria(rs.getString("cmc_categoria"));
                produto.setCmc_quantidade(rs.getInt("cmc_quantidade"));
                produto.setCmc_data_cadastro(rs.getTimestamp("cmc_data_cadastro"));
                return produto;
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<cmc_produtos> listAll() {
        ArrayList<cmc_produtos> lista = new ArrayList<>();
        try (Statement stmt = cnt.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM cmc_produtos")) {
            
            while (rs.next()) {
                cmc_produtos produto = new cmc_produtos();
                produto.setCmc_id_produtos(rs.getInt("cmc_id_produtos"));
                produto.setCmc_nome(rs.getString("cmc_nome"));
                produto.setCmc_descricao(rs.getString("cmc_descricao"));
                produto.setCmc_preco(rs.getDouble("cmc_preco"));
                produto.setCmc_categoria(rs.getString("cmc_categoria"));
                produto.setCmc_quantidade(rs.getInt("cmc_quantidade"));
                produto.setCmc_data_cadastro(rs.getTimestamp("cmc_data_cadastro"));
                lista.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void close() {
        try {
            if (cnt != null && !cnt.isClosed()) {
                cnt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}