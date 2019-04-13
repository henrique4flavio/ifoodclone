package com.ifood.action.pedido;

import com.ifood.controller.Action;
import com.ifood.model.Cliente;
import com.ifood.model.Comida;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifood.model.Pedido;
import com.ifood.model.PedidoComida;
import com.ifood.model.Restaurante;
import com.ifood.persistence.ComidaDAO;
import com.ifood.persistence.PedidoComidaDAO;
import com.ifood.persistence.PedidoDAO;
import com.ifood.persistence.RestauranteDAO;
import com.ifood.state.pedido.PedidoEstado;
import com.ifood.state.pedido.PedidoEstadoEfetuado;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
/**
 *
 * @author jonat
 */
import org.json.JSONObject;

public class EfetuarPedidoAction implements Action {

    public EfetuarPedidoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {

            int restauranteId = Integer.parseInt(request.getParameter("id"));
            Restaurante restaurante = RestauranteDAO.getInstance().getRestauranteById(restauranteId);

            String pedidoJS = request.getParameter("cart_list");
            JSONObject pedidoJSON = new JSONObject(pedidoJS);
            JSONArray comidasJSON = pedidoJSON.getJSONArray("comidas");

            System.out.println(comidasJSON);
            boolean create = true;
            HttpSession session = request.getSession(create);

            Cliente cliente = (Cliente) session.getAttribute("cliente");

            double precoTotal = 0;

            Date data = new Date();
            SimpleDateFormat formatar = new SimpleDateFormat("H:m dd/MM/yyy");
            String dataPedido = formatar.format(data);
            

            Pedido pedido = new Pedido(dataPedido, restaurante, cliente, precoTotal);
            PedidoDAO.getInstance().save(pedido);
            
            for (int i = 0; i < comidasJSON.length(); i++) {
                int quantidade = comidasJSON.getJSONObject(i).getInt("product_quantity");
                int comidaId = Integer.parseInt(comidasJSON.getJSONObject(i).getString("product_id"));
                double preco = Double.parseDouble(comidasJSON.getJSONObject(i).getString("product_price"));

                precoTotal = precoTotal + preco;

                try {

                    Comida comida = ComidaDAO.getInstance().getComidaById(comidaId);
                    PedidoComida pedidoComida = new PedidoComida(pedido, comida, quantidade);
                    PedidoComidaDAO.getInstance().save(pedidoComida);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EfetuarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EfetuarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EfetuarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
