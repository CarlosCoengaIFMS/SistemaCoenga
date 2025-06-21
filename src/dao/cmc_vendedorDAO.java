/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.cmc_vendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cmc_vendedorDAO extends DAO_Abstract {
    private Connection cnt;

//    public cmc_vendedorDAO() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://10.7.0.51:33062/db_carlos_coenga";
//            String user = "carlos_coenga";
//            String pass = "carlos_coenga";
//            this.cnt = DriverManager.getConnection(url, user, pass);
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(cmc_vendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public cmc_vendedorDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
        cmc_vendedor vendedor = (cmc_vendedor) object;
        try (PreparedStatement pst = cnt.prepareStatement(
                "INSERT INTO cmc_vendedor (cmc_nome, cmc_cpf, cmc_data_nascimento, cmc_telefone, cmc_email, cmc_usuario, cmc_senha, cmc_ativo, cmc_data_cadastro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            pst.setString(1, vendedor.getCmc_nome());
            pst.setString(2, vendedor.getCmc_cpf());
            pst.setTimestamp(3, (Timestamp) vendedor.getCmc_data_nascimento());
            pst.setString(4, vendedor.getCmc_telefone());
            pst.setString(5, vendedor.getCmc_email());
            pst.setString(6, vendedor.getCmc_usuario());
            pst.setString(7, vendedor.getCmc_senha());
            pst.setString(8, vendedor.getCmc_ativo());
            pst.setTimestamp(9, vendedor.getCmc_data_cadastro());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(cmc_vendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        cmc_vendedor vendedor = (cmc_vendedor) object;
        try (PreparedStatement pst = cnt.prepareStatement(
                "UPDATE cmc_vendedor SET cmc_nome=?, cmc_cpf=?, cmc_data_nascimento=?, cmc_telefone=?, cmc_email=?, cmc_usuario=?, cmc_senha=?, cmc_ativo=?, cmc_data_cadastro=? WHERE cmc_id_vendedor=?")) {

            pst.setString(1, vendedor.getCmc_nome());
            pst.setString(2, vendedor.getCmc_cpf());
            pst.setTimestamp(3, (Timestamp) vendedor.getCmc_data_nascimento());
            pst.setString(4, vendedor.getCmc_telefone());
            pst.setString(5, vendedor.getCmc_email());
            pst.setString(6, vendedor.getCmc_usuario());
            pst.setString(7, vendedor.getCmc_senha());
            pst.setString(8, vendedor.getCmc_ativo());
            pst.setTimestamp(9, vendedor.getCmc_data_cadastro());
            pst.setInt(10, vendedor.getCmc_id_vendedor());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(cmc_vendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        cmc_vendedor vendedor = (cmc_vendedor) object;
        try (PreparedStatement pst = cnt.prepareStatement("DELETE FROM cmc_vendedor WHERE cmc_id_vendedor=?")) {
            pst.setInt(1, vendedor.getCmc_id_vendedor());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(cmc_vendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public cmc_vendedor list(int codigo) {
        try (PreparedStatement pst = cnt.prepareStatement("SELECT * FROM cmc_vendedor WHERE cmc_id_vendedor=?")) {
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cmc_vendedor vendedor = new cmc_vendedor();
                vendedor.setCmc_id_vendedor(rs.getInt("cmc_id_vendedor"));
                vendedor.setCmc_nome(rs.getString("cmc_nome"));
                vendedor.setCmc_cpf(rs.getString("cmc_cpf"));
                vendedor.setCmc_data_nascimento(rs.getTimestamp("cmc_data_nascimento"));
                vendedor.setCmc_telefone(rs.getString("cmc_telefone"));
                vendedor.setCmc_email(rs.getString("cmc_email"));
                vendedor.setCmc_usuario(rs.getString("cmc_usuario"));
                vendedor.setCmc_senha(rs.getString("cmc_senha"));
                vendedor.setCmc_ativo(rs.getString("cmc_ativo"));
                vendedor.setCmc_data_cadastro(rs.getTimestamp("cmc_data_cadastro"));
                return vendedor;
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_vendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<cmc_vendedor> listAll() {
        ArrayList<cmc_vendedor> lista = new ArrayList<>();
        try (Statement stmt = cnt.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM cmc_vendedor")) {

            while (rs.next()) {
                cmc_vendedor vendedor = new cmc_vendedor();
                vendedor.setCmc_id_vendedor(rs.getInt("cmc_id_vendedor"));
                vendedor.setCmc_nome(rs.getString("cmc_nome"));
                vendedor.setCmc_cpf(rs.getString("cmc_cpf"));
                vendedor.setCmc_data_nascimento(rs.getTimestamp("cmc_data_nascimento"));
                vendedor.setCmc_telefone(rs.getString("cmc_telefone"));
                vendedor.setCmc_email(rs.getString("cmc_email"));
                vendedor.setCmc_usuario(rs.getString("cmc_usuario"));
                vendedor.setCmc_senha(rs.getString("cmc_senha"));
                vendedor.setCmc_ativo(rs.getString("cmc_ativo"));
                vendedor.setCmc_data_cadastro(rs.getTimestamp("cmc_data_cadastro"));
                lista.add(vendedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_vendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void close() {
        try {
            if (cnt != null && !cnt.isClosed()) {
                cnt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_vendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
