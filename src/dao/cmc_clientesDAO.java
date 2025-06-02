/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.cmc_clientes;
import dao.DAO_Abstract;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cmc_clientesDAO extends DAO_Abstract {
    private Connection cnt;

    public cmc_clientesDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.7.0.51:33062/db_carlos_coenga";
            String user = "carlos_coenga";
            String pass = "carlos_coenga";
            this.cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cmc_clientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void insert(Object object) {
        cmc_clientes clientes = (cmc_clientes) object;
        try (PreparedStatement pst = cnt.prepareStatement("INSERT INTO usuarios VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            
            pst.setInt(1, clientes.getCmc_id_clientes());
            pst.setString(2, clientes.getCmc_nome());
            pst.setString(3, clientes.getCmc_bairro());
            pst.setString(4, clientes.getCmc_cpf());
            pst.setString(5, clientes.getCmc_cep());
            pst.setString(6, clientes.getCmc_email());
            pst.setDate(7, new java.sql.Date(clientes.getCmc_data_atualizacao().getTime()));
            pst.setDate(8, new java.sql.Date(clientes.getCmc_data_criacao().getTime()));
            pst.setDate(9, new java.sql.Date(clientes.getCmc_data_nacimento().getTime()));
            
            int affectedRows = pst.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("Inserção realizada com sucesso.");
            } else {
                System.out.println("Erro na inserção.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_clientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object objeto) {
        cmc_clientes clientes = (cmc_clientes) objeto;
        try (PreparedStatement pst = cnt.prepareStatement(
                "UPDATE usuarios SET cmc_nome=?, cmc_bairro=?, cmc_cpf=?, cmc_cep=?, cmc_email=?, cmc_data_atualizacao=?, cmc_data_criacao=?, cmc_data_nacimento=? WHERE cmc_id_clientes=?")) {
            
            pst.setString(1, clientes.getCmc_nome());
            pst.setString(2, clientes.getCmc_bairro());
            pst.setString(3, clientes.getCmc_cpf());
            pst.setString(4, clientes.getCmc_cep());
            pst.setString(5, clientes.getCmc_email());
            pst.setDate(6, new java.sql.Date(clientes.getCmc_data_atualizacao().getTime()));
            pst.setDate(7, new java.sql.Date(clientes.getCmc_data_criacao().getTime()));
            pst.setDate(8, new java.sql.Date(clientes.getCmc_data_nacimento().getTime()));
            pst.setInt(9, clientes.getCmc_id_clientes());
            
            int affectedRows = pst.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("Atualização realizada com sucesso.");
            } else {
                System.out.println("Erro na atualização.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_clientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        cmc_clientes clientes = (cmc_clientes) objeto;
        try (PreparedStatement pst = cnt.prepareStatement("DELETE FROM usuarios WHERE cmc_id_clientes=?")) {
            pst.setInt(1, clientes.getCmc_id_clientes());
            
            int affectedRows = pst.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("Exclusão realizada com sucesso.");
            } else {
                System.out.println("Erro na exclusão.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_clientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int codigo) {
        try (PreparedStatement pst = cnt.prepareStatement("SELECT * FROM usuarios WHERE cmc_id_clientes=?")) {
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                cmc_clientes clientes = new cmc_clientes();
                clientes.setCmc_id_clientes(rs.getInt("cmc_id_clientes"));
                clientes.setCmc_nome(rs.getString("cmc_nome"));
                clientes.setCmc_bairro(rs.getString("cmc_bairro"));
                clientes.setCmc_cpf(rs.getString("cmc_cpf"));
                clientes.setCmc_cep(rs.getString("cmc_cep"));
                clientes.setCmc_email(rs.getString("cmc_email"));
                clientes.setCmc_data_atualizacao(rs.getDate("cmc_data_atualizacao"));
                clientes.setCmc_data_criacao(rs.getDate("cmc_data_criacao"));
                clientes.setCmc_data_nacimento(rs.getDate("cmc_data_nacimento"));
                return clientes;
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_clientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<cmc_clientes> listAll() {
        ArrayList<cmc_clientes> lista = new ArrayList<>();
        try (Statement stmt = cnt.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")) {
            
            while (rs.next()) {
                cmc_clientes clientes = new cmc_clientes();
                clientes.setCmc_id_clientes(rs.getInt("cmc_id_clientes"));
                clientes.setCmc_nome(rs.getString("cmc_nome"));
                clientes.setCmc_bairro(rs.getString("cmc_bairro"));
                clientes.setCmc_cpf(rs.getString("cmc_cpf"));
                clientes.setCmc_cep(rs.getString("cmc_cep"));
                clientes.setCmc_email(rs.getString("cmc_email"));
                clientes.setCmc_data_atualizacao(rs.getDate("cmc_data_atualizacao"));
                clientes.setCmc_data_criacao(rs.getDate("cmc_data_criacao"));
                clientes.setCmc_data_nacimento(rs.getDate("cmc_data_nacimento"));
                lista.add(clientes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_clientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void close() {
        try {
            if (cnt != null && !cnt.isClosed()) {
                cnt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_clientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        cmc_clientes clientes = new cmc_clientes();
        // Set clientes properties here before inserting
        
        cmc_clientesDAO dao = new cmc_clientesDAO();
        
        try {
            dao.insert(clientes);
            System.out.println("Executou com sucesso.");
        } finally {
            dao.close();
        }
    }
}