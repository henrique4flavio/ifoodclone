/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.persistence;
import com.ifood.model.Comida;
import com.ifood.model.Pedido;
import com.ifood.model.PedidoComida;
import com.ifood.model.Restaurante;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PedidoComidaDAO {
 
  
    private static PedidoComidaDAO instance = new PedidoComidaDAO();

    private PedidoComidaDAO() {
    }

    public static PedidoComidaDAO getInstance() {

        return instance;
    }

    public void save(PedidoComida pedidoComida) throws
            SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;
  
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into pedido_pedidoComida (PEDIDO_ID, COMIDA_ID, quantidade, )" + "values('"
                    + pedidoComida.getPedido().getId() + "', '" + pedidoComida.getComida().getId() + "', '" + pedidoComida.getQuantidade()
                    + "')");


        } catch (SQLException e) {

            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public List<PedidoComida> list() throws ClassNotFoundException {

        Connection conn = null;
        Statement st = null;

        List<PedidoComida> pedidoComidaes = new ArrayList<PedidoComida>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedidoComida");
            while (rs.next()) {
                PedidoComida pedidoComida = new PedidoComida(
                        rs.getInt("id"),                    
                        rs.getInt("quantidade"),                    
                        (Pedido) rs.getObject("PEDIDO_ID"));
                        (Comida) rs.getObject("COMIDA_ID"));


                pedidoComidaes.add(pedidoComida);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidoComidaes;

    }

    public void delete(PedidoComida pedidoComida) throws
            SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from pedidoComida where codigo =" + pedidoComida.getId());
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
    
    
     public static void edit(PedidoComida pedidoComida) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement comando = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "update pedidoComida set nome=?,=?,descricao=?,preco=?,REST_ID=? where id =?";

            comando = conn.prepareStatement(sql);
            
            comando.setInt(5, pedidoComida.getId());

            comando.execute();
            comando.close();
            conn.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
