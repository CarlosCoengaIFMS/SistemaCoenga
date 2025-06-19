/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.cmc_compras_produtos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; // <-- ESSA LINHA É O QUE FALTA
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author notedarckbr
 */
public class cmc_compras_produtosDAO extends DAO_Abstract{

    private Connection cnt;
    
    
//    public cmc_compras_produtosDAO() {
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
    
     public cmc_compras_produtosDAO() {
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
     
     
     public void insert(Object object) {
        cmc_compras_produtos produto = (cmc_compras_produtos) object;
        String sql = "INSERT INTO cmc_compras_produtos (cmc_id_compra, cmc_id_produto, cmc_quantidade, cmc_valor_unitario, cmc_valor_total) VALUES (?, ?, ?, ?, ?)";

        try {
             java.sql.PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, produto.getCmc_id_compra());
            pst.setInt(2, produto.getCmc_id_produto());
            pst.setInt(3, produto.getCmc_quantidade());
            pst.setDouble(4, produto.getCmc_valor_unitario());
            pst.setDouble(5, produto.getCmc_valor_total());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public void update(Object object) {
        cmc_compras_produtos produto = (cmc_compras_produtos) object;
        String sql = "UPDATE cmc_compras_produtos SET cmc_id_compra=?, cmc_id_produto=?, cmc_quantidade=?, cmc_valor_unitario=?, cmc_valor_total=? WHERE cmc_id_compra_produto=?";

        try {
            java.sql.PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, produto.getCmc_id_compra());
            pst.setInt(2, produto.getCmc_id_produto());
            pst.setInt(3, produto.getCmc_quantidade());
            pst.setDouble(4, produto.getCmc_valor_unitario());
            pst.setDouble(5, produto.getCmc_valor_total());
            pst.setInt(6, produto.getCmc_id_compra_produto());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void delete(Object object) {
        cmc_compras_produtos produto = (cmc_compras_produtos) object;
        String sql = "DELETE FROM cmc_compras_produtos WHERE cmc_id_compra_produto=?";

        try {
            java.sql.PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, produto.getCmc_id_compra_produto());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }

    public Object list(int codigo) {
        cmc_compras_produtos produto = new cmc_compras_produtos();
        String sql = "SELECT * FROM cmc_compras_produtos WHERE cmc_id_compra_produto=?";

        try {
            java.sql.PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                produto.setCmc_id_compra_produto(rs.getInt("cmc_id_compra_produto"));
                produto.setCmc_id_compra(rs.getInt("cmc_id_compra"));
                produto.setCmc_id_produto(rs.getInt("cmc_id_produto"));
                produto.setCmc_quantidade(rs.getInt("cmc_quantidade"));
                produto.setCmc_valor_unitario(rs.getDouble("cmc_valor_unitario"));
                produto.setCmc_valor_total(rs.getDouble("cmc_valor_total"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }

        return produto;
    }

    public ArrayList<cmc_compras_produtos> listAll() {
        ArrayList<cmc_compras_produtos> lista = new ArrayList<>();
        String sql = "SELECT * FROM cmc_compras_produtos";

        try {
            java.sql.PreparedStatement pst = cnt.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cmc_compras_produtos produto = new cmc_compras_produtos();
                produto.setCmc_id_compra_produto(rs.getInt("cmc_id_compra_produto"));
                produto.setCmc_id_compra(rs.getInt("cmc_id_compra"));
                produto.setCmc_id_produto(rs.getInt("cmc_id_produto"));
                produto.setCmc_quantidade(rs.getInt("cmc_quantidade"));
                produto.setCmc_valor_unitario(rs.getDouble("cmc_valor_unitario"));
                produto.setCmc_valor_total(rs.getDouble("cmc_valor_total"));
                lista.add(produto);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar todos: " + e.getMessage());
        }

        return lista;
    }
}
