package tri.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderItemImpl {
	private Connection conn;

	public OrderItemImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean insert(int quantity, double price, int orderId, int productId) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO ORDER_ITEMS(ID, QUANTITY, PRICE, ORDER_ID, PRODUCT_ID) VALUES(NULL, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, quantity);
            stmt.setDouble(2, price);
            stmt.setInt(3, orderId);
            stmt.setInt(4, productId);
            
            stmt.execute();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	
	public boolean update(int id, int quantity, double price, int orderId, int productId) {
        // TODO Auto-generated method stub
        String sql = "UPDATE ORDER_ITEMS SET quantity = ?, price = ?, order_id = ?, product_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, quantity);
            stmt.setDouble(2, price);
            stmt.setInt(3, orderId);
            stmt.setInt(4, productId);
            stmt.setInt(5, id);
            return stmt.execute();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	
	public boolean delete(int id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM ORDER-ITEMS WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            return stmt.execute();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	
	public void find(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM ORDER-ITEMS" ;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int orderId = rs.getInt("order_id");
                int productId = rs.getInt("product_id");
                
                System.out.format("%d:%d:%.2f:%d:%d", id, quantity, price, orderId, productId).println();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	public void findAll() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM CATEGORIES" ;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int orderId = rs.getInt("order_id");
                int productId = rs.getInt("product_id");
                
                System.out.format("%d:%d:%.2f:%d:%d", id, quantity, price, orderId, productId).println();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void findByOder(int orderId) {
        String sql = "SELECT * FROM ORDER_ITEMS WHERE order_id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int productId = rs.getInt("product_id");
                System.out.format("%d:%d:%.2f:%d:%d", id, quantity, price, orderId, productId).println();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
