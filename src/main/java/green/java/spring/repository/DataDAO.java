package green.java.spring.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.green.spring.vo.SpringPracDTO;

@Repository
public class DataDAO {

	private Connection getConnection() throws SQLException {
	    Connection conn = null;

	    try {
	        Class.forName("com.mysql.jdbc.Driver");

	        String url = "jdbc:mysql://localhost:3306/springPractice";
	        conn = DriverManager.getConnection(url, "root", "1234");
	    }
	    catch (ClassNotFoundException e) {
	        System.out.println(e);
	    }

	    return conn;
	}

	public List<SpringPracDTO> getList(){
	    List<SpringPracDTO> list = new ArrayList<SpringPracDTO>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = getConnection();

	        String sql = "select * from springprac;";

	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        while(rs.next()) {

	        	SpringPracDTO dto = new SpringPracDTO();
	        	
	        	dto.setId(rs.getString("id"));
	        	dto.setName(rs.getString("name"));
	        	dto.setGender(rs.getNString("gender"));
	        	dto.setEmail(rs.getNString("email"));
	        	dto.setCellnum(rs.getNString("cellnum"));
	        	
	        	list.add(dto);
	        	
	        }
	    }
	    catch (SQLException e) {
	        System.out.println( e);
	    }

	    return list;
	}
	
	public void insertData(SpringPracDTO dto){
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {
	        conn = getConnection();
	        
	        String id = dto.getId();
	        String name = dto.getName();
	        String gender = dto.getGender();
	        String email = dto.getEmail();
	        String cellnum = dto.getCellnum();
	        
	        String sql = "insert into springprac values('"+id+"','"+name+"','"+gender+"','"+email+"','"+cellnum+"')";

	        pstmt = conn.prepareStatement(sql);
	        pstmt.executeUpdate();

	       
	    }
	    catch (SQLException e) {
	    	e.printStackTrace();
	    }finally {
	    	
	    }

	}
	
}
