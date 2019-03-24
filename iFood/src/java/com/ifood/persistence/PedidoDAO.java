package com.ifood.persistence;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ifood.model.Pedido;

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
            st.execute("insert into pedido (precoToltal, listaPratos, restaurante, cliente)" + "values('" + pedido.getPrecoTotal() + "', '" + pedido.getPratos() + "', '" + pedido.getRestaurante() + "','" + pedido.getCliente() + "')");

        } catch (SQLException e) {

            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void edit(Pedido pedido) throws
            SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "update pedido set situacao=?where codigo = ?";
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1, pedido.getEstado().getEstado());

            comando.setInt(2, pedido.getId());
            comando.execute();
            comando.close();
            conn.close();
            // st.execute("update pedido set situacao=" + "'" + pedido.getSituacao() + "'where id = '" + pedido.getCodigo()+ "'");

        } catch (SQLException e) {

            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public List<Pedido> list() throws ClassNotFoundException {

        Connection conn = null;
        Statement st = null;

        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido");
            while (rs.next()) {

               // Pedido pedido = new Pedido(
                //       rs.getInt("c"),
                //     rs.getString("nome"),
                //   rs.getString("remetente"),
                // rs.getString("destinatario"),
                //rs.getString("situacao"));
               // pedidos.add(pedido);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;

    }

    public Pedido get(int codigo) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;

        conn = DatabaseLocator.getInstance().getConnection();
        st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from pedido where codigo =" + codigo);

       // Pedido pedido = new Pedido(
         //       rs.getInt("codigo"),
          //      rs.getString("nome"),
           //     rs.getString("remetente"),
            //    rs.getString("destinatario"),
              //  rs.getString("situacao"));
        Pedido pedido = new Pedido();

        return pedido;

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
}
