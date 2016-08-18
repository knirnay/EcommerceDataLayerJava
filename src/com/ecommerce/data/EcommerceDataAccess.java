/**
 * 
 */
package com.ecommerce.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import oracle.jdbc.*;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

/**
 * The data access layer. This class is responsible for connecting to the database for manipulating/get/post data.
 * @author NK
 * @version 1.0
 * @since 08/14/2016
 */
public class EcommerceDataAccess {
	/**
	 * Initializes a new instance of the {@link EcommerceDataAccess} class.
	 * @param url
	 * @param user
	 * @param password
	 * @throws SQLException
	 */
	public EcommerceDataAccess(String url, String user, String password) throws SQLException {
		// url = jdbc:oracle:thin:@localhost:1521:orcl
		// user = Ecommerce
		// password = Ecommerce
		this.setURL(url);
		this.setUser(user);
		this.setPassword(password);
		this.setConn();
	}
	
	/**
	 * The database connection.
	 */
	private Connection Conn;
	
	/**
	 * The database connection URL.
	 */
	private String URL;
	
	/**
	 * The user.
	 */
	private String User;
	
	/**
	 * The password.
	 */
	private String Password;
	
	/**
	 * Gets the database {@link Connection}.
	 * @return The database {@link Connection}.
	 * @throws SQLException
	 */
	private Connection getConn() throws SQLException{
		if(this.Conn != null){
			return this.Conn;
		}
	    OracleDriver ora = new OracleDriver();
	    Properties info = new Properties();
	    info.put("user", this.User);
	    info.put("password", this.Password);
	    return ora.connect(this.getURL(), info);
	}
	
	/**
	 * Sets the database {@link Connection}.
	 * @throws SQLException
	 */
	private void setConn() throws SQLException{
		OracleDriver ora = new OracleDriver();
		Properties info = new Properties();
		info.put("user", this.getUser());
		info.put("password", this.getPassword());
		this.Conn = ora.connect(this.getURL(), info);
	}
	
	/**
	 * Gets the database connection URL.
	 * @return The database connection URL.
	 */
	private String getURL() {
		return this.URL;
	}

	/**
	 * Sets the database connection URL.
	 * @param url The database connection URL.
	 */
	private void setURL(String url) {
		this.URL = url;
	}

	/**
	 * Gets the user.
	 * @return The user.
	 */
	private String getUser() {
		return this.User;
	}

	/**
	 * Sets the user.
	 * @param user The user.
	 */
	private void setUser(String user) {
		this.User = user;
	}

	/**
	 * Gets the password.
	 * @return The password.
	 */
	private String getPassword() {
		return this.Password;
	}

	/**
	 * Sets the password.
	 * @param password The password.
	 */
	private void setPassword(String password) {
		this.Password = password;
	}

	/**
	 * Creates a new {@link Product} in the database table.
	 * @param product The {@link Product} to create.
	 * @return The product identifier.
	 * @throws SQLException 
	 */
	public int createNewProductWithSpecification(Product product) throws SQLException{
		int productId;
		// Connection conn = DriverManager.getConnection(this.getURL(), this.getUser(), this.getPassword());
		CallableStatement cstmt = null;
		try{
			cstmt = this.getConn().prepareCall("{call InsertNewProductWithSpec(?,?,?,?,?)}");
			cstmt.setInt(1, product.getCategoryId());
			cstmt.setString(2, product.getName());
			cstmt.setString(3, product.getDescription());
			
			StructDescriptor specDesc = StructDescriptor.createDescriptor("SPEC", this.getConn());
			List<STRUCT> specificationsTypeSturct = new ArrayList<STRUCT>();
			for(Specification spec : product.getSpecs()){
				List<Object> params = new ArrayList<Object>();
				params.add(spec.getName());
				params.add(spec.getSpecValue());
				specificationsTypeSturct.add(new STRUCT(specDesc, this.getConn(), params.toArray()));
			}
			
			ArrayDescriptor specificationsDesc = ArrayDescriptor.createDescriptor("SPECIFICATIONS", this.getConn());
			ARRAY arrayOfSpecs = new ARRAY(specificationsDesc, this.getConn(), specificationsTypeSturct.toArray());
			
			cstmt.setArray(4, arrayOfSpecs);
			cstmt.registerOutParameter(5, Types.INTEGER);
			cstmt.execute();
			productId = cstmt.getInt(5);
		}
		finally{
			if(cstmt != null){
				cstmt.close();
			}
			
			if(this.getConn() != null){
				this.getConn().close();
			}
		}
		
		return productId;
	}
}
