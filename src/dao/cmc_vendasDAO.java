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
        try (PreparedStatement pst = cnt.prepareStatement(
                "INSERT INTO vendas (id_venda, forma_pagamento, observacoes, status, data_venda) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            pst.setInt(1, venda.getCmc_id_venda());
            pst.setString(2, venda.getCmc_forma_pagamento());
            pst.setString(3, venda.getCmc_observacoes());
            pst.setString(4, venda.getCmc_status());
            pst.setDate(5, null);

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
                "UPDATE vendas SET id_cliente=?, id_usuario=?, forma_pagamento=?, observacoes=?, status=?, data_venda=? WHERE id_venda=?")) {
            
            pst.setString(1, venda.getCmc_forma_pagamento());
            pst.setString(2, venda.getCmc_observacoes());
            pst.setString(3, venda.getCmc_status());
           pst.setDate(4, null);
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
        try (PreparedStatement pst = cnt.prepareStatement("DELETE FROM vendas WHERE cmc_id_venda=?")) {
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
        try (PreparedStatement pst = cnt.prepareStatement("SELECT * FROM vendas WHERE cmc_id_venda=?")) {
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cmc_vendas venda = new cmc_vendas();
                venda.setCmc_id_venda(rs.getInt("id_venda"));
                venda.setCmc_forma_pagamento(rs.getString("forma_pagamento"));
                venda.setCmc_observacoes(rs.getString("observacoes"));
                venda.setCmc_status(rs.getString("status"));
                venda.setCmc_cmc_data_venda(rs.getTimestamp("data_venda"));
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
                venda.setCmc_forma_pagamento(rs.getString("forma_pagamento"));
                venda.setCmc_observacoes(rs.getString("observacoes"));
                venda.setCmc_status(rs.getString("status"));
                venda.setCmc_cmc_data_venda(rs.getTimestamp("data_venda"));
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
