package com.gogreen.dao;

import java.sql.*;
import java.util.*;


import com.gogreen.dto.Product;

public class ProductDao {

	/*
	 * Llista tots els clients de la base de dades
	 * 
	 */
	public List<Product> listar() {
		String SQL_SELECT = "SELECT pro_code, pro_name, pro_price, pro_description " + " FROM products";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> products = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int code = rs.getInt("pro_code");
				String name = rs.getString("pro_name");
				Float price = rs.getFloat("pro_price");
				String description = rs.getString("pro_description");

				product = new Product(code, name, price, description, price);
				products.add(product);
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return products;
	}

	/*
	 * Recupera un client a la base de dades segons el seu ID
	 * 
	 */
	public Product findById(Product product) {
		String SQL_SELECT_BY_ID = "SELECT pro_code, pro_name, pro_price, pro_description "
				+ " FROM products WHERE pro_code = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, product.getCode());
			rs = stmt.executeQuery();
			rs.absolute(1);// nos posicionamos en el primer registro devuelto

			String name = rs.getString("pro_name");
			Float price = rs.getFloat("pro_price");
			String description = rs.getString("pro_description");

			product.setName(name);
			product.setPrice(price);
			product.setDescription(description);

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return product;
	}

	/*
	 * Crea un client a la base de dades
	 * 
	 */
	public int create(Product product) {
		String SQL_INSERT = "INSERT INTO products( pro_name, pro_price, pro_description) VALUES(?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, product.getName());
			stmt.setFloat(2, product.getPrice());
			stmt.setString(3, product.getDescription());
System.out.println(product.toString());
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
	 * Modifica un client de la base de dades
	 * 
	 */
	public int update(Product product) {
		String SQL_UPDATE = "UPDATE products "
				+ " SET pro_name=?, pro_price=?, pro_description=?, WHERE pro_code=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			int i = 1;
			stmt.setString(i++, product.getName());
			stmt.setFloat(i++, product.getPrice());
			stmt.setString(i++, product.getDescription());
			stmt.setInt(i++, product.getCode());

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
	 * Esborra un producte de la base de dades
	 * 
	 */
	public int delete(Product product) {
		String SQL_DELETE = "DELETE FROM products WHERE pro_code = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, product.getCode());
			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	public Product findByCode(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
