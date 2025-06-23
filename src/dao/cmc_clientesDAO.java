/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.cmc_clientes;
import bean.cmc_compras_produtos;
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
        String sql = "INSERT INTO cmc_clientes (cmc_id_clientes, cmc_nome, cmc_email, cmc_telefone, cmc_cpf, cmc_rg, cmc_data_nascimento, "
                + "cmc_genero, cmc_endereco, cmc_bairro, cmc_cidade, cmc_estado, cmc_cep, cmc_data_criacao, cmc_data_atualizacao, "
                + "cmc_ultima_compra, cmc_observacoes, cmc_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = cnt.prepareStatement(sql)) {
            pst.setInt(1, clientes.getCmc_id_clientes());
            pst.setString(2, clientes.getCmc_nome());
            pst.setString(3, clientes.getCmc_email());
            pst.setString(4, clientes.getCmc_telefone());
            pst.setString(5, clientes.getCmc_cpf());
            pst.setString(6, clientes.getCmc_rg());
            pst.setDate(7, null);
            pst.setString(8, clientes.getCmc_genero());
            pst.setString(9, clientes.getCmc_endereco());
            pst.setString(10, clientes.getCmc_bairro());
            pst.setString(11, clientes.getCmc_cidade());
            pst.setString(12, clientes.getCmc_estado());
            pst.setString(13, clientes.getCmc_cep());
            pst.setTimestamp(14, clientes.getCmc_data_criacao());
            pst.setTimestamp(15, clientes.getCmc_data_atualizacao());
            pst.setDate(16, null);
            pst.setString(17, clientes.getCmc_observacoes());
            pst.setString(18, clientes.getCmc_status());

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cliente inserido com sucesso.");
            } else {
                System.out.println("Erro na inserção do clientes.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_clientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object objeto) {
        cmc_clientes clientes = (cmc_clientes) objeto;
       try (PreparedStatement pst = cnt.prepareStatement(
        "UPDATE cmc_clientes SET cmc_nome = ?, cmc_email = ?, cmc_telefone = ?, cmc_cpf = ?, cmc_rg = ?, cmc_data_nascimento = ?, "
        + "cmc_genero = ?, cmc_endereco = ?, cmc_bairro = ?, cmc_cidade = ?, cmc_estado = ?, cmc_cep = ?, "
        + "cmc_data_criacao = ?, cmc_data_atualizacao = ?, cmc_ultima_compra = ?, cmc_observacoes = ?, cmc_status = ? "
        + "WHERE cmc_id_clientes = ?")) {

    pst.setString(1, clientes.getCmc_nome());
    pst.setString(2, clientes.getCmc_email());
    pst.setString(3, clientes.getCmc_telefone());
    pst.setString(4, clientes.getCmc_cpf());
    pst.setString(5, clientes.getCmc_rg());
    pst.setDate(6, null);  // ou clientes.getCmc_data_nacimento() se tiver valor
    pst.setString(7, clientes.getCmc_genero());
    pst.setString(8, clientes.getCmc_endereco());
    pst.setString(9, clientes.getCmc_bairro());
    pst.setString(10, clientes.getCmc_cidade());
    pst.setString(11, clientes.getCmc_estado());
    pst.setString(12, clientes.getCmc_cep());
    pst.setTimestamp(13, clientes.getCmc_data_criacao());
    pst.setTimestamp(14, clientes.getCmc_data_atualizacao());
    pst.setDate(15, null);  // ou clientes.getCmc_ultima_compra()
    pst.setString(16, clientes.getCmc_observacoes());
    pst.setString(17, clientes.getCmc_status());

    pst.setInt(18, clientes.getCmc_id_clientes());

    int affectedRows = pst.executeUpdate();
    if (affectedRows > 0) {
        System.out.println("Atualização realizada com sucesso.");
    } else {
        System.out.println("Erro na atualização.");
    }
} catch (SQLException ex) {
    Logger.getLogger(cmc_compras_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
}

    }

    @Override
public void delete(Object objeto) {
    cmc_clientes cliente = (cmc_clientes) objeto;

    String sql = "DELETE FROM cmc_clientes WHERE cmc_id_clientes = ?";
    
    try (PreparedStatement pst = cnt.prepareStatement(sql)) {
        pst.setInt(1, cliente.getCmc_id_clientes());

        int affectedRows = pst.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Exclusão realizada com sucesso. Registros apagados: " + affectedRows);
        } else {
            System.out.println("Nenhum registro encontrado para exclusão.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(cmc_compras_produtosDAO.class.getName()).log(Level.SEVERE, "Erro ao excluir compras do cliente", ex);
    }
}


    /**
     *
     * @param codigo
     * @return
     */
    @Override
    public cmc_clientes list(int codigo) {
    String sql = "SELECT * FROM cmc_clientes WHERE cmc_id_clientes = ?";
    
    try (PreparedStatement pst = cnt.prepareStatement(sql)) {
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            cmc_clientes cliente = new cmc_clientes();
            cliente.setCmc_id_clientes(rs.getInt("cmc_id_clientes"));
            cliente.setCmc_nome(rs.getString("cmc_nome"));
            cliente.setCmc_email(rs.getString("cmc_email"));
            cliente.setCmc_telefone(rs.getString("cmc_telefone"));
            cliente.setCmc_cpf(rs.getString("cmc_cpf"));
            cliente.setCmc_rg(rs.getString("cmc_rg"));
            cliente.setCmc_data_nascimento(rs.getDate("cmc_data_nascimento"));
            cliente.setCmc_genero(rs.getString("cmc_genero"));
            cliente.setCmc_endereco(rs.getString("cmc_endereco"));
            cliente.setCmc_bairro(rs.getString("cmc_bairro"));
            cliente.setCmc_cidade(rs.getString("cmc_cidade"));
            cliente.setCmc_estado(rs.getString("cmc_estado"));
            cliente.setCmc_cep(rs.getString("cmc_cep"));
            cliente.setCmc_data_criacao(rs.getTimestamp("cmc_data_criacao"));
            cliente.setCmc_data_atualizacao(rs.getTimestamp("cmc_data_atualizacao"));
            cliente.setCmc_ultima_compra(rs.getDate("cmc_ultima_compra"));
            cliente.setCmc_observacoes(rs.getString("cmc_observacoes"));
            cliente.setCmc_status(rs.getString("cmc_status"));
            return cliente;
        }
    } catch (SQLException ex) {
        Logger.getLogger(cmc_clientesDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return null;
}


    @Override
    public ArrayList<cmc_compras_produtos> listAll() {
        ArrayList<cmc_compras_produtos> lista = new ArrayList<>();
        try (Statement stmt = cnt.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM cmc_compras_produtos")) {

            while (rs.next()) {
                cmc_compras_produtos clientess = new cmc_compras_produtos();
                clientess.setCmc_id_compra_produto(rs.getInt("cmc_id_compra_produto"));
                clientess.setCmc_id_compra(rs.getInt("cmc_id_compra"));
                clientess.setCmc_id_produto(rs.getInt("cmc_id_produto"));
                clientess.setCmc_quantidade(rs.getInt("cmc_quantidade"));
                clientess.setCmc_valor_unitario(rs.getDouble("cmc_valor_unitario"));
                clientess.setCmc_valor_total(rs.getDouble("cmc_valor_total"));
                lista.add(clientess);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_compras_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void close() {
        try {
            if (cnt != null && !cnt.isClosed()) {
                cnt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_compras_produtosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
