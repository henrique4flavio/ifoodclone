/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifood.persistence;

import com.ifood.model.Cliente;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static ClienteDAO instance = new ClienteDAO();

    private ClienteDAO() {
    }

    public static ClienteDAO getInstance() {

        return instance;
    }

    public void save(Cliente cliente) throws
            SQLException, ClassNotFoundException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into cliente (nome, email, senha, cpf, rua, numero, bairro, cep)" + "values('"
                    + cliente.getNome() + "', '" + cliente.getEmail() + "', '" + cliente.getSenha() + "', '" + cliente.getCpf()
                    + "', '" + cliente.getRua() + "', '" + cliente.getNumero() + "', '" + cliente.getBairro() + "', '" + cliente.getCep() + "')");

        } catch (SQLException e) {

            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public List<Cliente> list() throws ClassNotFoundException {

        Connection conn = null;
        Statement st = null;

        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from cliente");
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setBairro(rs.getString("bairro"))
                        .setRua(rs.getString("rua"))
                        .setNumero(rs.getString("numero"))
                        .setCep(rs.getString("cep"))
                        .setCpf(rs.getString("cpf"))
                        .setNome(rs.getString("nome"))
                        .setEmail(rs.getString("email"))
                        .setSenha(rs.getString("senha"));

                clientes.add(cliente);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;

    }

    public Cliente getClienteById(int id) throws ClassNotFoundException {

        com.mysql.jdbc.Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from cliente WHERE id=" + id);
            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setBairro(rs.getString("bairro"))
                        .setRua(rs.getString("rua"))
                        .setNumero(rs.getString("numero"))
                        .setCep(rs.getString("cep"))
                        .setCpf(rs.getString("cpf"))
                        .setNome(rs.getString("nome"))
                        .setEmail(rs.getString("email"))
                        .setSenha(rs.getString("senha"));

                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(Cliente cliente) throws
            SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from cliente where codigo =" + cliente.getId());
        } catch (SQLException e) {

            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Cliente logar(String email, String senha) throws ClassNotFoundException {

        Connection conn = null;
        PreparedStatement comando = null;

        Cliente cliente = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "select * from cliente WHERE email = ? and senha = ?";
            comando = conn.prepareStatement(sql);
            comando.setString(1, email);
            comando.setString(2, senha);
            ResultSet rs = comando.executeQuery();
            if (rs.first()) {
                cliente = new Cliente();
                cliente.setBairro(rs.getString("bairro"))
                        .setRua(rs.getString("rua"))
                        .setNumero(rs.getString("numero"))
                        .setCep(rs.getString("cep"))
                        .setCpf(rs.getString("cpf"))
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

        return cliente;
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

    public static void edit(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement comando = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "update cliente set nome=?,email=?,senha=?,cpf=?,rua=?,numero=?,bairro=?,cep=? where id =?";

            comando = conn.prepareStatement(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getSenha());
            comando.setString(4, cliente.getCpf());

            comando.setString(5, cliente.getCpf());
            comando.setString(6, cliente.getRua());
            comando.setString(7, cliente.getNumero());
            comando.setString(8, cliente.getBairro());
            comando.setString(9, cliente.getCep());
            comando.setInt(10, cliente.getId());

            comando.execute();
            comando.close();
            conn.close();
        } catch (SQLException e) {
            throw e;
        }
    }

}
