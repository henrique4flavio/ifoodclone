package com.ifood.persistence;

import com.ifood.model.Cliente;
import com.ifood.model.Comida;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ifood.model.Pedido;
import com.ifood.model.Restaurante;

public class PedidoDAO {

    private static PedidoDAO instance = new PedidoDAO();

    private PedidoDAO() {
    }

    public static PedidoDAO getInstance() {

        return instance;
    }

    public void save(Pedido pedido) throws
            SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "insert into pedido (data,REST_ID,CLIENTE_ID,precoTotal, estado) values(?,?,?,?,?)";

            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1, pedido.getData());
            comando.setInt(2, pedido.getRestaurante().getId());
            comando.setInt(3, pedido.getCliente().getId());
            comando.setDouble(4, pedido.getPrecoTotal());
            comando.setString(5, pedido.getEstado().getEstado());

            comando.execute();
            comando.close();
            conn.close();
        } catch (SQLException e) {

            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public List<Pedido> list() throws ClassNotFoundException {
        com.mysql.jdbc.Connection conn = null;
        Statement st = null;

        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido");
            while (rs.next()) {

                String data = rs.getString("data");
                int restauranteId = rs.getInt("REST_ID");
                int clienteId = rs.getInt("CLIENTE_ID");
                double precoTotal = rs.getDouble("precoTotal");

                Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteById(restauranteId);
                Cliente cliente = ClienteDAO.getInstance().getClienteById(clienteId);

                Pedido pedido = new Pedido(data, restaurante, cliente, precoTotal);
                pedidos.add(pedido);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }
    
     public List<Pedido> getPedidos(int id) throws ClassNotFoundException {
        com.mysql.jdbc.Connection conn = null;
        Statement st = null;

        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido");
            while (rs.next()) {

                String data = rs.getString("data");
                int restauranteId = rs.getInt("REST_ID");
                int clienteId = rs.getInt("CLIENTE_ID");
                double precoTotal = rs.getDouble("precoTotal");

                Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteById(restauranteId);
                Cliente cliente = ClienteDAO.getInstance().getClienteById(clienteId);

                Pedido pedido = new Pedido(data, restaurante, cliente, precoTotal);
                pedidos.add(pedido);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }

    public Pedido getPedidoById(int id) throws ClassNotFoundException {

        com.mysql.jdbc.Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido WHERE id=?" + id);
            while (rs.next()) {

                String data = rs.getString("data");
                int restauranteId = rs.getInt("REST_ID");
                int clienteId = rs.getInt("CLIENTE_ID");
                double precoTotal = rs.getDouble("precoTotal");

                Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteById(restauranteId);
                Cliente cliente = ClienteDAO.getInstance().getClienteById(clienteId);

                Pedido pedido = new Pedido(id, data, restaurante, cliente, precoTotal);
                
                return pedido;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Pedido getUltimoPedido() throws ClassNotFoundException {

        com.mysql.jdbc.Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(ID), data, REST_ID, CLIENTE_ID, precoTotal, estado FROM pedido");
            while (rs.next()) {

                String data = rs.getString("data");
                int restauranteId = rs.getInt("REST_ID");
                int clienteId = rs.getInt("CLIENTE_ID");
                double precoTotal = rs.getDouble("precoTotal");
                int id = rs.getInt("MAX(ID)");


                Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteById(restauranteId);
                Cliente cliente = ClienteDAO.getInstance().getClienteById(clienteId);

                Pedido pedido = new Pedido(id, data, restaurante, cliente, precoTotal);
                
                return pedido;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(Pedido pedido) throws
            SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from pedido where codigo =" + pedido.getId());
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

    public void edit(Pedido pedido) throws SQLException, ClassNotFoundException {

   Connection conn = null;
        PreparedStatement comando = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "update pedido set precoTotal=? where id =?";

            comando = conn.prepareStatement(sql);
            comando.setDouble(1, pedido.getPrecoTotal());
            comando.setInt(2, pedido.getId());
            

            comando.execute();
            comando.close();
            conn.close();
        } catch (SQLException e) {
            throw e;
        }
    }

}
