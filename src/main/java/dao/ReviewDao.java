package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Review;

public class ReviewDao extends AbstractDao {
	
	public List<Review> showAllList(){
		List<Review>list = new ArrayList<>();
		String sql = "SELECT * FROM review";
		try (Connection con = getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
			
			ResultSet rs = st.executeQuery();
		 while (rs.next()) {
			 Review review = new Review();
			 review.setName(rs.getString("name"));
			 review.setTitle(rs.getString("title"));
			 review.setReason(rs.getString("reason"));
			 review.setStar(rs.getInt("star"));
			 
			 list.add(review);
		 }
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
			
	}
	public int insert(Review review) {
		int result = -1;
		String sql = "INSERT INTO review(name,title,reason,star) VALUES(?,?,?,?)";
		try (Connection con = getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
			st.setString(1, review.getName());
			st.setString(2, review.getTitle());
			st.setString(3, review.getReason());
			st.setInt(4, review.getStar());
			result = st.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;		
	}
	public Review searchByName(String name) {
		String sql = "SELECT name,title,reason,star FROM review WHERE name = ?";
		Review r = null;
		try (Connection con = getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
			st.setString(1, name);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				
				r = new Review();

				r.setName(rs.getString("name"));
				r.setTitle(rs.getString("title"));
				r.setReason(rs.getString("reason"));
				r.setStar(rs.getInt("star"));

			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public int updateReviewByName(String title, String reason, int star,String name) {
		int result = -1;
		String sql = "UPDATE review SET title = ? ,reason = ? ,star = ? WHERE name = ?";
		try (Connection con = getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setString(1, title);
			st.setString(2, reason);
			st.setInt(3, star);
			st.setString(4, name);
			result = st.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;	
	}
	
	public int deleteByName(String name) {
		int result = -1;
		String sql = "DELETE FROM review WHERE name = ?";
		try (Connection con = getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setString(1, name);
			result = st.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;	
	}
	
}
