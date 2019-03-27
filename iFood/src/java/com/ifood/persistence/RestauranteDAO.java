package com.ifood.persistence;

import com.ifood.model.Restaurante;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RestauranteDAO {

    private static RestauranteDAO instance = new RestauranteDAO();

    private RestauranteDAO() {
    }

    public static RestauranteDAO getInstance() {

        return instance;
    }

    public void save(Restaurante restaurante) throws
            SQLException, ClassNotFoundException {

        com.mysql.jdbc.Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            st.execute("insert into restaurante (nome, email, senha, descricao, foto, horaDeAbrir, horaDeFechar, categoria)" + "values('"
                    + restaurante.getNome() + "', '" + restaurante.getEmail() + "', '" + restaurante.getSenha() + "','" + restaurante.getDescricao() + "', '" + restaurante.getFoto()
                    + "', '" + restaurante.getHoraDeAbrir() + "', '" + restaurante.getHoraDeFechar() + "', '" + restaurante.getCategoria() + "')");

        } catch (SQLException e) {

            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public List<Restaurante> list() throws ClassNotFoundException {

        com.mysql.jdbc.Connection conn = null;
        Statement st = null;

        List<Restaurante> restaurantes = new ArrayList<Restaurante>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from restaurante");
            while (rs.next()) {

                Restaurante restaurante = new Restaurante(
                        rs.getString("descricao"),
                        rs.getBlob("foto"),
                        rs.getDate("horaDeAbrir"),
                        rs.getDate("horaDeFechar"),
                        rs.getString("categoria"),
                        rs.getDouble("valorDoFrete"),
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getString("email"));

                restaurantes.add(restaurante);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurantes;

    }

    public void delete(Restaurante restaurante) throws
            SQLException, ClassNotFoundException {
        com.mysql.jdbc.Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from restaurante where codigo =" + restaurante.getId());
        } catch (SQLException e) {

            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void closeResources(com.mysql.jdbc.Connection conn, Statement st) {
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
