package com.gogreen.servlet;

import javax.servlet.Servlet;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.Connection;


import com.gogreen.dao.ClientDao;
import com.gogreen.dto.Client;
import com.gogreen.dao.DBConnection;

@WebServlet("/client")
public class ClientController extends HttpServlet implements Servlet {
	
private static final long serialVersionUID = -7558166539389234332L;
	   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperam l'acció a realitzar i es crida a la funció corresponent
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "edit":
				this.editClient(request, response);
				break;
			
			default:
				this.showListClient(request, response);
			}
		} else {
			this.showListClient(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recuperam l'acció a realitzar i es crida a la funció corresponent
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "login":
				this.login(request, response);
				break;
			case "delete":
				this.deleteClient(request, response);
				break;
			case "insert":
				this.insertClient(request, response);
				break;
			case "update":
				this.updateClient(request, response);
				break;
			default:
				this.showListClient(request, response);
			}
		} else {
			this.showListClient(request, response);
		}
	}
	
	private void login (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = null;
		String password = null;
		name = request.getParameter("name");
		password = request.getParameter("password");

        String securePass = SHA256.sha256(password);
		try {
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DBConnection.getConnection();
			String sql = "SELECT * FROM client WHERE cli_name = '"+name+"' AND cli_password = '"+password+"'";
			PreparedStatement stmt = con.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        
	        
	        if (rs.next()) {

                // Prueba login mediante objeto usuario

	        	Client client = new Client();

	        	String name2 = rs.getString("cli_name");
				String password2 = rs.getString("cli_password");
				
              
				client.setName(name2);
				client.setPassword(password2);


                HttpSession sessio = request.getSession(true);
                sessio.setAttribute("client", client);
                
                
                // If admin redirect to backoffice page
                // Else redirect to user page
                
                if (name2.equals("admin")) {
                    request.getRequestDispatcher("frmClient.jsp").forward(request, response);
                    response.sendRedirect("frmClient.jsp");
                } else {
                    request.getRequestDispatcher("frontOffice.jsp").forward(request, response);
                    response.sendRedirect("frontOffice.jsp");
                }

            } else {

                response.sendRedirect("login.jsp?log=E");
            }
		}catch (Exception e){
            System.out.println(e);
		 }
	}
 
	private void showListClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> clientes = new ClientDao().listar();

		System.out.println("clientes = " + clientes);
		
		// Dades a desar a la sessió de la classe
		HttpSession session = request.getSession();
		session.setAttribute("clientes", clientes);
		session.setAttribute("totalClientes", clientes.size());
		session.setAttribute("balanceTotal", this.calcularbalanceTotal(clientes));

		// request.getRequestDispatcher("frmClient.jsp").forward(request, response);
		response.sendRedirect("frmClient.jsp");
	}

	private void editClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperamos el idCliente
		int id = Integer.parseInt(request.getParameter("id"));
		Client client = new ClientDao().findById(new Client(id));
		request.setAttribute("cliente", client);
		String jspEditar = "/editClient.jsp";
		request.getRequestDispatcher(jspEditar).forward(request, response);

	}

	private void insertClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		// recuperamos los valores del formulario agregarCliente
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String password = request.getParameter("password");
		double balance = 0;
		String balanceString = request.getParameter("balance");
		if (balanceString != null && !"".equals(balanceString)) {
			balance = Double.parseDouble(balanceString);
		}

		// Creamos el objeto de cliente (modelo)
		Client client = new Client(name, surname, password, balanceString, balance);

		// Insertamos el nuevo objeto en la base de datos
		int registrosModificados = new ClientDao().create(client);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListClient(request, response);
	}

	private void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		System.out.println("Modifigogreen client");
		
		// Recuperam els valors del formulari editClient
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		System.out.println("Nombre:" + name);
		String surname = request.getParameter("surname");
		double balance = 0;
		String balanceString = request.getParameter("balance");
		if (balanceString != null && !"".equals(balanceString)) {
			balance = Double.parseDouble(balanceString);
		}

		// Creamos el objeto de cliente (modelo)
		Client client = new Client(id, name, surname, balanceString, balance);

		// Modifigogreen el objeto en la base de datos
		int registrosModificados = new ClientDao().update(client);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListClient(request, response);
	}

	private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperamos los valores del formulario editarCliente
		int id = Integer.parseInt(request.getParameter("id"));

		// Creamos el objeto de cliente (modelo)
		Client client = new Client(id);

		// Eliminamos el objeto en la base de datos
		int registrosModificados = new ClientDao().delete(client);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListClient(request, response);
	}
	
	private double calcularbalanceTotal(List<Client> clientes) {
		double balanceTotal = 0;
		for (Client client : clientes) {
			balanceTotal += client.getBalance();
		}
		return balanceTotal;
	}

}
