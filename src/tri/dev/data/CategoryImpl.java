package tri.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

public class CategoryImpl {
	private Connection conn;

	public CategoryImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public void findAll() {
		// TODO Auto-generated method stub
		List<Category> cateList = new ArrayList();
		String sql = "SELECT * FROM CATEGORIES";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String thumbnail = rs.getString("thumbnail");

				System.out.format("%id:%s:%s", id, name, thumbnail).println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void find(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CATEGORIES WHERE ID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id); // id la id của category cần tìm

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String thumbnail = rs.getString("thumbnail");
				System.out.format("%id:%s:%s", id, name, thumbnail).println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void select() {
		// TODO Auto-generated method stub
		String spl = "SELECT * FROM CATEGORIES";
		try {
			PreparedStatement stmt = conn.prepareStatement(spl);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String thumbnail = rs.getString("thumbnail");
				System.out.format("id:%d - name:%s - thumbnail:%s", id, name, thumbnail).println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete() {
		// TODO Auto-generated method stub
		String spl = "DELETE FROM CATEGORIES WHERE ID=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(spl);
			stmt.setInt(1, 1);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {
		// TODO Auto-generated method stub
		String spl = "UPDATE CATEGORIES SET NAME=?, THUMBNAIL=? WHERE ID=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(spl);
			stmt.setString(1, "Ao Nu");
			stmt.setString(2, "http://image.com/2.jpg");
			stmt.setInt(3, 1);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert() {
		// TODO Auto-generated method stub
		String spl = "INSERT INTO CATEGORIES(NAME, THUMBNAIL) VALUES (?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(spl);
			stmt.setString(1, "Ao Nam");
			stmt.setString(2, "http://image.com/1.jpg");

			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
