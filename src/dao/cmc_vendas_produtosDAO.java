/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.cmc_vendas_produtos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cmc_vendas_produtosDAO extends DAO_Abstract {

    private Connection cnt;

    public cmc_vendas_produtosDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db_carlos_coenga";
            String user = "root";
            String pass = "16515647";
            this.cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cmc_vendas_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Object object) {
        cmc_vendas_produtos vendaProduto = (cmc_vendas_produtos) object;
        String sql = "INSERT INTO cmc_vendas_produtos (cmc_fk_venda, cmc_fk_produto, cmc_quantidade, cmc_valor_unitario, cmc_valor_total) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, vendaProduto.getCmc_fk_venda());
            pst.setInt(2, vendaProduto.getCmc_fk_produto());
            pst.setInt(3, vendaProduto.getCmc_quantidade());
            pst.setDouble(4, vendaProduto.getCmc_valor_unitario());
            pst.setDouble(5, vendaProduto.getCmc_valor_total());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    @Override
    public void update(Object object) {
        cmc_vendas_produtos vendaProduto = (cmc_vendas_produtos) object;
        String sql = "UPDATE cmc_vendas_produtos SET cmc_fk_venda=?, cmc_fk_produto=?, cmc_quantidade=?, cmc_valor_unitario=?, cmc_valor_total=? WHERE cmc_id_venda_produto=?";

        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, vendaProduto.getCmc_fk_venda());
            pst.setInt(2, vendaProduto.getCmc_fk_produto());
            pst.setInt(3, vendaProduto.getCmc_quantidade());
            pst.setDouble(4, vendaProduto.getCmc_valor_unitario());
            pst.setDouble(5, vendaProduto.getCmc_valor_total());
            pst.setInt(6, vendaProduto.getCmc_id_venda_produto());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    @Override
    public void delete(Object object) {
        cmc_vendas_produtos vendaProduto = (cmc_vendas_produtos) object;
        String sql = "DELETE FROM cmc_vendas_produtos WHERE cmc_id_venda_produto=?";

        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, vendaProduto.getCmc_id_venda_produto());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }

    @Override
    public Object list(int codigo) {
        cmc_vendas_produtos vendaProduto = new cmc_vendas_produtos();
        String sql = "SELECT * FROM cmc_vendas_produtos WHERE cmc_id_venda_produto=?";

        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                vendaProduto.setCmc_id_venda_produto(rs.getInt("cmc_id_venda_produto"));
                vendaProduto.setCmc_fk_venda(rs.getInt("cmc_fk_venda"));
                vendaProduto.setCmc_fk_produto(rs.getInt("cmc_fk_produto"));
                vendaProduto.setCmc_quantidade(rs.getInt("cmc_quantidade"));
                vendaProduto.setCmc_valor_unitario(rs.getDouble("cmc_valor_unitario"));
                vendaProduto.setCmc_valor_total(rs.getDouble("cmc_valor_total"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }

        return vendaProduto;
    }

    @Override
    public ArrayList<cmc_vendas_produtos> listAll() {
        ArrayList<cmc_vendas_produtos> lista = new ArrayList<>();
        String sql = "SELECT * FROM cmc_vendas_produtos";

        try {
            PreparedStatement pst = cnt.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cmc_vendas_produtos vendaProduto = new cmc_vendas_produtos();
                vendaProduto.setCmc_id_venda_produto(rs.getInt("cmc_id_venda_produto"));
                vendaProduto.setCmc_fk_venda(rs.getInt("cmc_fk_venda"));
                vendaProduto.setCmc_fk_produto(rs.getInt("cmc_fk_produto"));
                vendaProduto.setCmc_quantidade(rs.getInt("cmc_quantidade"));
                vendaProduto.setCmc_valor_unitario(rs.getDouble("cmc_valor_unitario"));
                vendaProduto.setCmc_valor_total(rs.getDouble("cmc_valor_total"));
                lista.add(vendaProduto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar todos: " + e.getMessage());
        }

        return lista;
    }
}
