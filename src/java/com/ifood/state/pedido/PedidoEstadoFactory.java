
package com.ifood.state.pedido;

/**
 *
 * @author jonat
 */
public class PedidoEstadoFactory {

    public static PedidoEstado create(String estado) {

        PedidoEstado estadoObject = null;
        String nomeClasse = "com.ifood.state.pedido.PedidoEstado"+ estado;

        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();

        } catch (Exception ex) {
            return null;
        }

        if (!(objeto instanceof PedidoEstado)) {
            return null;
        }
        estadoObject = (PedidoEstado) objeto;
        return estadoObject;
    }
}
