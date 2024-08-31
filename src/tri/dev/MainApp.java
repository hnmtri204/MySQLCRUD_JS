package tri.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import tri.dev.data.CategoryImpl;
import tri.dev.data.OrderImpl;
import tri.dev.data.OrderItemImpl;
import tri.dev.data.ProductImpl;
import tri.dev.data.UserImpl;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn = getConnection();
		CategoryImpl categoryImpl = new CategoryImpl(conn);
		categoryImpl.insert();
		categoryImpl.update();
		categoryImpl.delete();
		categoryImpl.select();
		categoryImpl.find(0);
		categoryImpl.findAll();

		UserImpl userImpl = new UserImpl(conn);
		userImpl.insert();
		userImpl.update();
		userImpl.delete(1);
		userImpl.find(0);
		userImpl.findAll();

		ProductImpl productImpl = new ProductImpl(conn);
		productImpl.insert();
		productImpl.update();
		productImpl.delete(1);
		productImpl.find(0);
		productImpl.findAll();

		OrderImpl orderImpl = new OrderImpl(conn);
		orderImpl.insert();
		orderImpl.update();
		orderImpl.delete(1);
		orderImpl.find(0);
		orderImpl.findAll();

		OrderItemImpl orderitemImpl = new OrderItemImpl(conn);
		orderitemImpl.insert();
		orderitemImpl.update();
		orderitemImpl.delete(1);
		orderitemImpl.find(0);
		orderitemImpl.findAll();
	}

	private static Connection getConnection() {
		// TODO Auto-generated method stub
		final String DB_URL = "jdbc:mysql://localhost:3306/shop";
		final String USER = "root";
		final String PASS = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
