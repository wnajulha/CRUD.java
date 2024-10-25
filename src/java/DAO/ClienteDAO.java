package DAO;

import conexao.Conexao;
import model.Cliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClienteDAO {

    public static void adicionarCliente(Cliente cliente){
        String sql = "INSERT  INTO clientes (nome, email) VALUES(?, ?)";
        Connection connection = null;
        PreparedStatement pst = null;
        try{
            System.out.println("ENTROU NO DAO");
            System.out.println("CHAMOU O CONNEXCAO NULL: " + connection);
            connection = Conexao.conectar();
            System.out.println("CHAMOU O CONNEXCAO: " + connection );
            pst = connection.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Cliente obterCliente(int id) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try ( Connection conn = Conexao.conectar();  PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            try ( ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(id);
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    System.out.println("cliente: "+ cliente.getNome());
                    return cliente;
                }
            }
        }
        return null;
    }

    public static void atualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, email = ? WHERE id = ?";
        try ( Connection conn = Conexao.conectar();  PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.setInt(3, cliente.getId());
            pst.executeUpdate();

        }
    }

    public static void deletarCliente(int id) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try ( Connection conn = Conexao.conectar();  PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    public static List<Cliente> getAllClientes() {

            List<Cliente> clientes = new ArrayList<>();
            String sql = "SELECT * FROM clientes";

            try ( Connection conn = Conexao.conectar();  PreparedStatement pst = conn.prepareStatement(sql);  ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    Cliente cliente = new Cliente();

                    cliente.setId(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    
                    clientes.add(cliente);
                }
            } catch (SQLException e) {
            e.printStackTrace();

        }
            return clientes;
    }    

    
}
