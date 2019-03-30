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
            st.execute("insert into comida (nome, descricao, preco, REST_ID)" + "values('"
                    + comida.getNome() + "', '" + comida.getDescricao() + "', '" + comida.getPreco() + "', '" + comida.getRestaurante().getId()
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
                        (Restaurante) rs.getObject("REST_ID"));
                       

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
    
    
     public static void edit(Comida comida) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement comando = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "update comida set nome=?,=?,descricao=?,preco=?,REST_ID=? where id =?";

            comando = conn.prepareStatement(sql);
            comando.setString(1, comida.getNome());
            comando.setString(2, comida.getDescricao());
            comando.setDouble(3, comida.getPreco());
            comando.setInt(4, comida.getRestaurante().getId());
            comando.setInt(5, comida.getId());

            comando.execute();
            comando.close();
            conn.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
