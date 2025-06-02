/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.cmc_produtos;
import dao.DAO_Abstract;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cmc_produtosDAO extends DAO_Abstract {
    private Connection cnt;

    public cmc_produtosDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
            String user = "marcos_vilhanueva";
            String pass = "marcos_vilhanueva";
            this.cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cmc_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(Object object) {
        cmc_produtos produto = (cmc_produtos) object;
        try (PreparedStatement pst = cnt.prepareStatement("INSERT INTO produtos VALUES (?, ?, ?, ?, ?)")) {
            pst.setInt(1, produto.getCmc_id_produto());
            pst.setString(2, produto.getCmc_nome());
            pst.setString(3, produto.getCmc_descricao());
            pst.setDouble(4, produto.getCmc_preco());
            pst.setInt(5, produto.getCmc_quantidade_estoque());
            
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
                "UPDATE produtos SET nome=?, descricao=?, preco=?, quantidade_estoque=? WHERE id_produto=?")) {
            pst.setString(1, produto.getCmc_nome());
            pst.setString(2, produto.getCmc_descricao());
            pst.setDouble(3, produto.getCmc_preco());
            pst.setInt(4, produto.getCmc_quantidade_estoque());
            pst.setInt(5, produto.getCmc_id_produto());
            
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
        try (PreparedStatement pst = cnt.prepareStatement("DELETE FROM produtos WHERE id_produto=?")) {
            pst.setInt(1, produto.getCmc_id_produto());
            
            if (pst.executeUpdate() > 0) {
                System.out.println("Produto excluído com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int codigo) {
        try (PreparedStatement pst = cnt.prepareStatement("SELECT * FROM produtos WHERE id_produto=?")) {
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                cmc_produtos produto = new cmc_produtos();
                produto.setCmc_id_produto(rs.getInt("id_produto"));
                produto.setCmc_nome(rs.getString("nome"));
                produto.setCmc_descricao(rs.getString("descricao"));
                produto.setCmc_preco(rs.getDouble("preco"));
                produto.setCmc_quantidade_estoque(rs.getInt("quantidade_estoque"));
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
             ResultSet rs = stmt.executeQuery("SELECT * FROM produtos")) {
            
            while (rs.next()) {
                cmc_produtos produto = new cmc_produtos();
                produto.setCmc_id_produto(rs.getInt("id_produto"));
                produto.setCmc_nome(rs.getString("nome"));
                produto.setCmc_descricao(rs.getString("descricao"));
                produto.setCmc_preco(rs.getDouble("preco"));
                produto.setCmc_quantidade_estoque(rs.getInt("quantidade_estoque"));
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