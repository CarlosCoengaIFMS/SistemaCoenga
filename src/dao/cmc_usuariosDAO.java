/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.cmc_usuarios;
import dao.DAO_Abstract;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cmc_usuariosDAO extends DAO_Abstract {

    private Connection cnt;

    public cmc_usuariosDAO() {
        try {
             Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://10.7.0.51:33062/db_carlos_coenga";
            String user = "carlos_coenga";
            String pass = "carlos_coenga";
            this.cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cmc_usuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Object object) {
        cmc_usuarios usuario = (cmc_usuarios) object;
        try {
                PreparedStatement pst = cnt.prepareStatement("INSERT INTO cmc_usuarios (cmc_id_usuario, cmc_nome, cmc_apelido, cmc_cpf, cmc_data_nascimento, cmc_nivel, cmc_ativo, cmc_senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

             pst.setInt(1, usuario.getCmc_id_usuario());
            pst.setString(2, usuario.getCmc_nome());
            pst.setString(3, usuario.getCmc_apelido());
            pst.setString(4, usuario.getCmc_cpf());
            pst.setDate(5, null);
            pst.setString(6, String.valueOf(usuario.getCmc_nivel())); // enum
            pst.setString(7, usuario.getCmc_ativo());//ativo
            pst.setString(8, usuario.getCmc_senha());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(cmc_usuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object objeto) {
        cmc_usuarios usuario = (cmc_usuarios) objeto;
        try (PreparedStatement pst = cnt.prepareStatement(
                "UPDATE usuarios SET nome=?, apelido=?, cpf=?, datanascimento=?, senha=?, nivel=?, ativo=? WHERE id_usuario=?")) {
            pst.setString(1, usuario.getCmc_nome());
            pst.setString(2, usuario.getCmc_apelido());
            pst.setString(3, usuario.getCmc_cpf());
            pst.setDate(4, null);
            pst.setString(5, usuario.getCmc_senha());
            pst.setInt(6, usuario.getCmc_nivel());
            pst.setString(7, usuario.getCmc_ativo());
            pst.setInt(8, usuario.getCmc_id_usuario());

            if (pst.executeUpdate() > 0) {
                System.out.println("Usuário atualizado com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_usuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object objeto) {
        cmc_usuarios usuario = (cmc_usuarios) objeto;
        try (PreparedStatement pst = cnt.prepareStatement("DELETE FROM usuarios WHERE id_usuario=?")) {
            pst.setInt(1, usuario.getCmc_id_usuario());

            if (pst.executeUpdate() > 0) {
                System.out.println("Usuário excluído com sucesso.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_usuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int codigo) {
        try (PreparedStatement pst = cnt.prepareStatement("SELECT * FROM usuarios WHERE id_usuario=?")) {
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cmc_usuarios usuario = new cmc_usuarios();
                usuario.setCmc_id_usuario(rs.getInt("id_usuario"));
                usuario.setCmc_nome(rs.getString("nome"));
                usuario.setCmc_apelido(rs.getString("apelido"));
                usuario.setCmc_cpf(rs.getString("cpf"));
                usuario.setCmc_data_nascimento(rs.getDate("datanascimento"));
                usuario.setCmc_senha(rs.getString("senha"));
                usuario.setCmc_nivel(rs.getInt("nivel"));
                usuario.setCmc_ativo(rs.getString("ativo"));
                return usuario;
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_usuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<cmc_usuarios> listAll() {
        ArrayList<cmc_usuarios> lista = new ArrayList<>();
        try (Statement stmt = cnt.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")) {

            while (rs.next()) {
                cmc_usuarios usuario = new cmc_usuarios();
                usuario.setCmc_id_usuario(rs.getInt("id_usuario"));
                usuario.setCmc_nome(rs.getString("nome"));
                usuario.setCmc_apelido(rs.getString("apelido"));
                usuario.setCmc_cpf(rs.getString("cpf"));
                usuario.setCmc_data_nascimento(rs.getDate("datanascimento"));
                usuario.setCmc_senha(rs.getString("senha"));
                usuario.setCmc_nivel(rs.getInt("nivel"));
                usuario.setCmc_ativo(rs.getString("ativo"));
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_usuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void close() {
        try {
            if (cnt != null && !cnt.isClosed()) {
                cnt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(cmc_usuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static void main(String[] args) {
        cmc_usuarios usuarios = new cmc_usuarios();
        usuarios.setCmc_id_usuario(200);
        usuarios.setCmc_nome("marcos");
        usuarios.setCmc_apelido("mpv");
        usuarios.setCmc_cpf("456.546.879-87");
        usuarios.setCmc_data_nascimento(null);
        usuarios.setCmc_senha("123");
        usuarios.setCmc_nivel(1);
        usuarios.setCmc_ativo("S");
        cmc_usuariosDAO usuariosDao = new cmc_usuariosDAO();
        usuariosDao.insert(usuarios);
        System.out.println("executou com sucesso.");
    }
}
