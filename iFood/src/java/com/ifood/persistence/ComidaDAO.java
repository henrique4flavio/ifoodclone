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
            String sql = "insert into comida (nome, descricao, preco, REST_ID) values(?,?,?,?)";

            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1, comida.getNome());
            comando.setString(2, comida.getDescricao());
            comando.setDouble(3, comida.getPreco());
            comando.setDouble(4, comida.getRestaurante().getId());

            comando.execute();
            comando.close();
            conn.close();
        } catch (SQLException e) {

            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public List<Comida> list(int restauranteId) throws ClassNotFoundException {

        com.mysql.jdbc.Connection conn = null;
        Statement st = null;

        List<Comida> comidas = new ArrayList<Comida>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from comida WHERE REST_ID = " + restauranteId);

            while (rs.next()) {

                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                Double preco = rs.getDouble("preco");
                String foto = rs.getString("foto");
                int id = rs.getInt("id");

                Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteById(restauranteId);

                Comida comida = new Comida(id, nome, foto, descricao, preco, restaurante);
                comidas.add(comida);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comidas;

    }

    public Comida getComida(String nomeComida, double precoComida, int restauranteComida) throws ClassNotFoundException {

        com.mysql.jdbc.Connection conn = null;
        Statement st = null;

        List<Comida> comidas = new ArrayList<Comida>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from comida WHERE nome="+ "'" + nomeComida + "'" + " AND preco ="+ precoComida+"");

            while (rs.next()) {

                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                Double preco = rs.getDouble("preco");
                String foto = rs.getString("foto");
                int restauranteId = rs.getInt("REST_ID");
                int id = rs.getInt("id");

                Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteById(restauranteId);

                Comida comida = new Comida(id, nome, foto, descricao, preco, restaurante);
                return comida;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Comida getComidaById(int id) throws ClassNotFoundException {

        com.mysql.jdbc.Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from comida WHERE id=" +id);

            while (rs.next()) {

                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                Double preco = rs.getDouble("preco");
                String foto = rs.getString("foto");
                int restauranteId = rs.getInt("REST_ID");
                

                Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteById(restauranteId);

                Comida comida = new Comida(id, nome, foto, descricao, preco, restaurante);
                
                return comida;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

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
            String sql = "update comida set nome=?,descricao=?,preco=?,foto=?,REST_ID=? where id =?";

            comando = conn.prepareStatement(sql);
            comando.setString(1, comida.getNome());
            comando.setString(2, comida.getDescricao());
            comando.setDouble(3, comida.getPreco());
            comando.setString(4, comida.getFoto());
            comando.setInt(5, comida.getRestaurante().getId());
            comando.setInt(6, comida.getId());

            comando.execute();
            comando.close();
            conn.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
