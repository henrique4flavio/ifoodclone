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
 String sql = "insert into pedido (id,data,COMIDA_ID,REST_ID,CLIENTE_ID,qta,precoTotal) values(?,?,?,?,?,?,?)";
            
           PreparedStatement comando = conn.prepareStatement(sql);

            
            
            comando.setInt(1, pedido.getId());
            comando.setDate(2, pedido.getData());
            comando.setInt(3, pedido.getComida_id());
            comando.setInt(4, pedido.getRestaurante_id());
            comando.setInt(5, pedido.getCliente_id());
            comando.setInt(6, pedido.getQtd());
            comando.setDouble(7, pedido.getPrecoTotal());
            
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

                Pedido pedido = new Pedido(
                        rs.getDate("data"),
                        rs.getInt("COMIDA_ID"),
                        rs.getInt("REST_ID"),
                        rs.getInt("CLIENTE_ID"),
                        rs.getInt("qtd"),
                        rs.getDouble("precoTotal"));
                        

                pedidos.add(pedido);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
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
    
    public static void edit(Pedido pedido) throws SQLException, ClassNotFoundException {
  
    }


}
