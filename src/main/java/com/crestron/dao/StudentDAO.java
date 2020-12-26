package com.crestron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.crestron.db.DataSource;
import com.crestron.dto.StudentDTO;



public class StudentDAO implements DAO<StudentDTO>{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());
	private Connection conn;
	
	
	{
		try {
			conn = DataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Optional<StudentDTO> get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDTO> getAll() {
		// TODO Auto-generated method stub
		List<StudentDTO> allStudents = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		String selectSql1 = "SELECT * FROM studentappdb.student_details";
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(selectSql1);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			StudentDTO st1 = new StudentDTO();
			st1.setFirstName(rs.getString("FIRST_NAME"));
			st1.setMiddleName(rs.getString("MIDDLE_NAME"));
			st1.setLastName(rs.getString("LAST_NAME"));
			st1.setGender(rs.getString("GENDER"));
			st1.setAge(Integer.valueOf(rs.getString("AGE")));
			st1.setMark1(Integer.valueOf(rs.getString("MARK1")));
			st1.setMark2(Integer.valueOf(rs.getString("MARK2")));
			st1.setMark3(Integer.valueOf(rs.getString("MARK3")));
			st1.setTotal(Integer.valueOf(rs.getString("TOTAL")));
			allStudents.add(st1);
		}
		conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return allStudents;
	}

	@SuppressWarnings("resource")
	@Override
	public void save(StudentDTO st) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String student_id=null;
		try {
		String insertSql1 = "INSERT INTO studentappdb.TCOODS_STUDENT(FIRST_NAME,MIDDLE_NAME,LAST_NAME,GENDER,AGE) VALUES(?,?,?,?,?)";
		String lastinsertSql1 = "SELECT LAST_INSERT_ID() as STUDENT_ID;";
		String insertSql2 = "INSERT INTO studentappdb.TCOODS_STUDENT_MARKS(STUDENT_ID,MARK1,MARK2,MARK3) VALUES(?,?,?,?)";
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(insertSql1);
		pstmt.setString(1,st.getFirstName());
		pstmt.setString(2,st.getMiddleName());
		pstmt.setString(3,st.getLastName());
		pstmt.setString(4,st.getGender());
		pstmt.setInt(5,st.getAge());
		int cnt = pstmt.executeUpdate();
		logger.info("Student inserted : "+cnt);
		
		
		pstmt = conn.prepareStatement(lastinsertSql1);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			student_id=rs.getString("STUDENT_ID");
		}
		logger.info("Student_ID : "+student_id);
		
		pstmt = conn.prepareStatement(insertSql2);
		pstmt.setString(1,student_id);
		pstmt.setInt(2,st.getMark1());
		pstmt.setInt(3,st.getMark2());
		pstmt.setInt(4,st.getMark3());
		int cnt2 = pstmt.executeUpdate();
		logger.info("Marks inserted : "+cnt2);
		
		conn.commit();
		
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void update(StudentDTO t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(StudentDTO t) {
		// TODO Auto-generated method stub
		
	}

	

}
