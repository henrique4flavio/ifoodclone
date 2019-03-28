/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.persistence;

import com.ifood.model.Comida;
import com.ifood.model.Restaurante;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ComidaDAO {

    private static ComidaDAO instance = new ComidaDAO();

    private ComidaDAO() {
    }

    public static ComidaDAO getInstance() {

        return instance;
    }

    public void save(Comida comida) throws
            SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;
  

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into comida (nome, descricao, preco, restaurante)" + "values('"
                    + comida.getNome() + "', '" + comida.getDescricao() + "', '" + comida.getPreco() + "', '" + comida.getRestaurante()
                    + "')");

        } catch (SQLException e) {

            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public List<Comida> list() throws ClassNotFoundException {

        Connection conn = null;
        Statement st = null;

        List<Comida> comidaes = new ArrayList<Comida>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from comida");
            while (rs.next()) {
                Comida comida = new Comida(
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("preco"), 
                        (Restaurante) rs.getObject("restaurante"));
                       

                comidaes.add(comida);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comidaes;

    }

    public void delete(Comida comida) throws
            SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from comida where codigo =" + comida.getId());
        } catch (SQLException e) {

            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Comida logar(String email, String senha) throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement comando = null;

        Comida comida = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "select * from comida WHERE email = ? and senha = ?";
            comando = conn.prepareStatement(sql);
            comando.setString(1, email);
            comando.setString(2, senha);
            ResultSet rs = comando.executeQuery();
            if (rs.first()) {
                comida = new Comida(
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("preco"), 
                        (Restaurante) rs.getObject("restaurante"));

            }

            comando.close();
            conn.close();
        } catch (SQLException e) {
        } finally {
            closeResources(conn, comando);
        }
    
        return comida;
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
}
