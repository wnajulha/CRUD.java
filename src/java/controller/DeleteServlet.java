package controller;

import DAO.ClienteDAO;
import model.Cliente;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("_method");
        if ("delete".equalsIgnoreCase(method)) {
            doDelete(request, response);
        } else {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");

            System.out.println("nome:" + nome + "email:" + email);

            Cliente cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setEmail(email);

            try {
                ClienteDAO.adicionarCliente(cliente);
            } catch (Exception e) {
                throw new ServletException(e);
            }
            response.sendRedirect("views/read.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("oi galera");
        try {
            String id = request.getParameter("id");
            System.out.println("id:" + id);

            if (id != null) {
                Cliente cliente = ClienteDAO.obterCliente(Integer.parseInt(id));
                request.setAttribute("cliente", cliente);
                request.getRequestDispatcher("views/delete.jsp").forward(request, response);
            } else {
                List<Cliente> clientes = ClienteDAO.getAllClientes();
                request.setAttribute("clientes", clientes);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");

        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(id));
        cliente.setNome(nome);
        cliente.setEmail(email);

        try {
            ClienteDAO.atualizarCliente(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("views/read.jsp");

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("oi to no delete");
        String id = request.getParameter("id");

        try {
            ClienteDAO.deletarCliente(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("views/read.jsp");
    }

}
