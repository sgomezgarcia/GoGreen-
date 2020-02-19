package com.gogreen.dao;

import java.sql.*;
import java.util.*;

import com.gogreen.dto.Client;

public class ClientDao {

	/*
	 * Llista tots els Clients de la base de dades
	 * 
	 */
	public List<Client> listar() {
		String SQL_SELECT = "SELECT cli_id, cli_name, cli_surname, cli_password, cli_balance " + " FROM Client";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Client Client = null;
		List<Client> Clients = new ArrayList<>();

		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("cli_id");
				String name = rs.getString("cli_name");
				String surname = rs.getString("cli_surname");
				String password = rs.getString("cli_password");
				double balance = rs.getDouble("cli_balance");

				Client = new Client(id, name, surname, password, balance);
				Clients.add(Client);
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return Clients;
	}

	/*
	 * Recupera un Client a la base de dades segons el seu ID
	 * 
	 */
	public Client findById(Client Client) {
		String SQL_SELECT_BY_ID = "SELECT cli_id, cli_name, cli_surname, cli_balance "
				+ " FROM Client WHERE cli_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);

			stmt.setInt(1, Client.getId());
			rs = stmt.executeQuery();
			rs.absolute(1);// nos posicionamos en el primer registro devuelto

			String name = rs.getString("cli_name");
			String surname = rs.getString("cli_surname");
			double balance = rs.getDouble("cli_balance");

			Client.setName(name);
			Client.setSurname(surname);
			Client.setBalance(balance);

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return Client;
	}

	/*
	 * Crea un Client a la base de dades
	 * 
	 */
	public int create(Client Client) {
		String SQL_INSERT = "INSERT INTO Client(cli_name, cli_surname, cli_password, cli_balance) "
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, Client.getName());
			stmt.setString(2, Client.getSurname());
			stmt.setString(3, Client.getPassword());
			stmt.setDouble(4, Client.getBalance());
			System.out.println(Client.toString());
			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	/*
	 * Modifica un Client de la base de dades
	 * 
	 */
	public int update(Client Client) {
		String SQL_UPDATE = "UPDATE Client "
				+ " SET cli_name=?, cli_surname=?, cli_matr=?, cli_balance=? WHERE cli_id=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			int i = 1;
			stmt.setString(i++, Client.getName());
			stmt.setString(i++, Client.getSurname());
			stmt.setDouble(i++, Client.getBalance());
			stmt.setInt(i++, Client.getId());

			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	/*
	 * Esborra un Client de la base de dades
	 * 
	 */
	public int delete(Client Client) {
		String SQL_DELETE = "DELETE FROM Client WHERE cli_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, Client.getId());
			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

}
