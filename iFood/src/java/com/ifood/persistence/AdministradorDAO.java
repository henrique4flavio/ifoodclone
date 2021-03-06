/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.persistence;

import com.ifood.model.Administrador;
import com.ifood.model.Administrador;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO {

    private static AdministradorDAO instance = new AdministradorDAO();

    private AdministradorDAO() {
    }

    public static AdministradorDAO getInstance() {

        return instance;
    }

    public void save(Administrador administrador) throws
            SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into administrador (nome, senha, email)" + "values('" + administrador.getNome() + "', '" + administrador.getSenha() + "', '" + administrador.getEmail() + "')");

        } catch (SQLException e) {

            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public List<Administrador> list() throws ClassNotFoundException {

        Connection conn = null;
        Statement st = null;

        List<Administrador> administradores = new ArrayList<Administrador>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from administrador");
            while (rs.next()) {

                administradores.add(resultSet(rs));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return administradores;

    }

    public void delete(Administrador administrador) throws
            SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from administrador where codigo =" + administrador.getId());
        } catch (SQLException e) {

            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Administrador logar(String email, String senha) throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement comando = null;

        Administrador administrador = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "select * from administrador WHERE email = ? and senha = ?";
            comando = conn.prepareStatement(sql);
            comando.setString(1, email);
            comando.setString(2, senha);
            ResultSet rs = comando.executeQuery();
            if (rs.first()) {
                administrador = resultSet(rs);
            }

            comando.close();
            conn.close();
        } catch (SQLException e) {
        } finally {
            closeResources(conn, comando);
        }

        return administrador;
    }

    public void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
    }

    public static void edit(Administrador administrador) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement comando = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "update administrador set nome=?,senha=?,email=?  where id =?";

            comando = conn.prepareStatement(sql);
            comando.setString(1, administrador.getNome());
            comando.setString(2, administrador.getSenha());
            comando.setString(3, administrador.getEmail());

            comando.setInt(10, administrador.getId());

            comando.execute();
            comando.close();
            conn.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    //Metodo criado para eliminar duplicação
    public Administrador resultSet(ResultSet rs) throws SQLException {
        Administrador administrador = new Administrador();
        administrador.setId(rs.getInt("id"))
                .setNome(rs.getString("nome"))
                .setSenha(rs.getString("senha"))
                .setEmail(rs.getString("email"));

        return administrador;

    }
}
