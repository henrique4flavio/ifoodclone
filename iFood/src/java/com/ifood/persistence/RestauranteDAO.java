package com.ifood.persistence;

import com.ifood.model.Restaurante;
import com.ifood.model.Restaurante;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
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

            st.execute("insert into restaurante (nome, email, senha, descricao, horaDeAbrir, horaDeFechar, categoria, valorDoFrete)" + "values('"
                    + restaurante.getNome() + "', '" + restaurante.getEmail() + "', '" + restaurante.getSenha() + "','" + restaurante.getDescricao() + "', '"
                    + restaurante.getHoraDeAbrir() + "', '" + restaurante.getHoraDeFechar() + "', '" + restaurante.getCategoria() + "', '" + restaurante.getValorDoFrete() + "')");

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

                Restaurante restaurante = new Restaurante();
                restaurante.setCategoria(rs.getString("categoria"))
                        .setValorDoFrete(rs.getDouble("valorDoFrete"))
                        .setHoraDeAbrir(rs.getString("horaDeAbrir"))
                        .setHoraDeFechar(rs.getString("horaDeFechar"))
                        .setDescricao(rs.getString("descricao"))
                        .setFoto(rs.getString("foto"))
                        .setNome(rs.getString("nome"))
                        .setEmail(rs.getString("email"))
                        .setSenha(rs.getString("senha"))
                        .setId(rs.getInt("id"));

                restaurantes.add(restaurante);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurantes;

    }

    public Restaurante getRestauranteById(int id) throws ClassNotFoundException, SQLException {

        com.mysql.jdbc.Connection conn = null;
        Statement st = null;

        conn = DatabaseLocator.getInstance().getConnection();
        st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from restaurante WHERE id=" + id);

        while (rs.next()) {

            String descricao = rs.getString("descricao");
            String foto = rs.getString("foto");
            String horaDeAbrir = rs.getString("horaDeAbrir");
            String horaDeFechar = rs.getString("horaDeFechar");
            String categoria = rs.getString("categoria");
            double valorDoFrete = rs.getDouble("valorDoFrete");
            String nome = rs.getString("nome");
            String senha = rs.getString("senha");
            String email = rs.getString("email");

            Restaurante restaurante = new Restaurante();
            restaurante.setCategoria(categoria)
                    .setValorDoFrete(valorDoFrete)
                    .setHoraDeAbrir(horaDeAbrir)
                    .setHoraDeFechar(horaDeFechar)
                    .setDescricao(descricao)
                    .setFoto(foto)
                    .setNome(nome)
                    .setEmail(email)
                    .setSenha(senha)
                    .setId(id);
            return restaurante;
        }
        return null;
    }

    public Restaurante getRestauranteByEmail(String email) throws ClassNotFoundException, SQLException {

        com.mysql.jdbc.Connection conn = null;
        Statement st = null;

        conn = DatabaseLocator.getInstance().getConnection();
        st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from restaurante WHERE email=" + "'" + email + "'");

        while (rs.next()) {

            String descricao = rs.getString("descricao");
            String foto = rs.getString("foto");
            String horaDeAbrir = rs.getString("horaDeAbrir");
            String horaDeFechar = rs.getString("horaDeFechar");
            String categoria = rs.getString("categoria");
            double valorDoFrete = rs.getDouble("valorDoFrete");
            String nome = rs.getString("nome");
            String senha = rs.getString("senha");
            int id = rs.getInt("id");

            Restaurante restaurante = new Restaurante();
            restaurante.setCategoria(categoria)
                    .setValorDoFrete(valorDoFrete)
                    .setHoraDeAbrir(horaDeAbrir)
                    .setHoraDeFechar(horaDeFechar)
                    .setDescricao(descricao)
                    .setFoto(foto)
                    .setNome(nome)
                    .setEmail(email)
                    .setId(id)
                    .setSenha(senha);
            return restaurante;
        }
        return null;
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

    public Restaurante logar(String email, String senha) throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement comando = null;

        Restaurante restaurante = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "select * from restaurante WHERE email = ? and senha = ?";
            comando = conn.prepareStatement(sql);
            comando.setString(1, email);
            comando.setString(2, senha);
            ResultSet rs = comando.executeQuery();
            if (rs.first()) {
                restaurante = new Restaurante();
                restaurante.setCategoria(rs.getString("categoria"))
                        .setValorDoFrete(rs.getDouble("valorDoFrete"))
                        .setHoraDeAbrir(rs.getString("horaDeAbrir"))
                        .setHoraDeFechar(rs.getString("horaDeFechar"))
                        .setDescricao(rs.getString("descricao"))
                        .setFoto(rs.getString("foto"))
                        .setNome(rs.getString("nome"))
                        .setEmail(rs.getString("email"))
                        .setSenha(rs.getString("senha"))
                        .setId(rs.getInt("id"));
            }

            comando.close();
            conn.close();
        } catch (SQLException e) {
        } finally {
            closeResources(conn, comando);
        }

        return restaurante;
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

    public void edit(Restaurante restaurante) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement comando = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "update restaurante set nome=?,email=?,senha=?,descricao=?,foto=?,horaDeAbrir=?,horaDeFechar=?,categoria=?,valorDoFrete=? where id =?";

            comando = conn.prepareStatement(sql);
            comando.setString(1, restaurante.getNome());
            comando.setString(2, restaurante.getEmail());
            comando.setString(3, restaurante.getSenha());
            comando.setString(4, restaurante.getDescricao());
            comando.setString(5, restaurante.getFoto());
            comando.setString(6, restaurante.getHoraDeAbrir());
            comando.setString(7, restaurante.getHoraDeFechar());
            comando.setString(8, restaurante.getCategoria());
            comando.setDouble(9, restaurante.getValorDoFrete());
            comando.setInt(10, restaurante.getId());

            comando.execute();
            comando.close();
            conn.close();
        } catch (SQLException e) {
            throw e;
        }
    }

}
