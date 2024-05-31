package com.mem.model;

import java.util.*;
import java.sql.*;

public class MemberJDBCDAO implements MemberDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cia102g2db?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Aa034200817@";

	private static final String INSERT_STMT = 
		"INSERT INTO member (mem_name, mem_sex, mem_phone, mem_email, mem_uid, mem_birthday, mem_account, mem_password, mem_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT mem_no, mem_name, mem_sex, mem_phone, mem_email, mem_uid, mem_birthday, mem_account, mem_password, mem_status FROM member ORDER BY mem_no";
	private static final String GET_ONE_STMT = 
		"SELECT mem_no, mem_name, mem_sex, mem_phone, mem_email, mem_uid, mem_birthday, mem_account, mem_password, mem_status FROM member WHERE mem_no = ?";
	private static final String DELETE = 
		"DELETE FROM member WHERE mem_no = ?";
	private static final String UPDATE = 
		"UPDATE member SET mem_name=?, mem_sex=?, mem_phone=?, mem_email=?, mem_uid=?, mem_birthday=?, mem_account=?, mem_password=?, mem_status=? WHERE mem_no = ?";

	@Override
	public void insert(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memberVO.getMemName());
			pstmt.setString(2, memberVO.getMemSex());
			pstmt.setString(3, memberVO.getMemPhone());
			pstmt.setString(4, memberVO.getMemEmail());
			pstmt.setString(5, memberVO.getMemUid());
			pstmt.setDate(6, memberVO.getMemBirthday());
			pstmt.setString(7, memberVO.getMemAccount());
			pstmt.setString(8, memberVO.getMemPassword());
			pstmt.setByte(9, memberVO.getMemStatus());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memberVO.getMemName());
			pstmt.setString(2, memberVO.getMemSex());
			pstmt.setString(3, memberVO.getMemPhone());
			pstmt.setString(4, memberVO.getMemEmail());
			pstmt.setString(5, memberVO.getMemUid());
			pstmt.setDate(6, memberVO.getMemBirthday());
			pstmt.setString(7, memberVO.getMemAccount());
			pstmt.setString(8, memberVO.getMemPassword());
			pstmt.setByte(9, memberVO.getMemStatus());
			pstmt.setInt(10, memberVO.getMemNo());

			pstmt.executeUpdate();
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer memNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, memNo);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public MemberVO findByPrimaryKey(Integer memNo) {

		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, memNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemNo(rs.getInt("mem_no"));
				memberVO.setMemName(rs.getString("mem_name"));
				memberVO.setMemSex(rs.getString("mem_sex"));
				memberVO.setMemPhone(rs.getString("mem_phone"));
				memberVO.setMemEmail(rs.getString("mem_email"));
				memberVO.setMemUid(rs.getString("mem_uid"));
				memberVO.setMemBirthday(rs.getDate("mem_birthday"));
				memberVO.setMemAccount(rs.getString("mem_account"));
				memberVO.setMemPassword(rs.getString("mem_password"));
				memberVO.setMemStatus(rs.getByte("mem_status"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return memberVO;
	}

	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemNo(rs.getInt("mem_no"));
				memberVO.setMemName(rs.getString("mem_name"));
				memberVO.setMemSex(rs.getString("mem_sex"));
				memberVO.setMemPhone(rs.getString("mem_phone"));
				memberVO.setMemEmail(rs.getString("mem_email"));
				memberVO.setMemUid(rs.getString("mem_uid"));
				memberVO.setMemBirthday(rs.getDate("mem_birthday"));
				memberVO.setMemAccount(rs.getString("mem_account"));
				memberVO.setMemPassword(rs.getString("mem_password"));
				memberVO.setMemStatus(rs.getByte("mem_status"));
				list.add(memberVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		MemberJDBCDAO dao = new MemberJDBCDAO();

		//新增
//		MemberVO memberVO1 = new MemberVO();
//		memberVO1.setMemName("大吳老師");
//		memberVO1.setMemSex("m");
//		memberVO1.setMemPhone("0911111111");
//		memberVO1.setMemEmail("dawu@gmail.com");
//		memberVO1.setMemUid("a123456789");
//		memberVO1.setMemBirthday(java.sql.Date.valueOf("2005-01-01"));
//		memberVO1.setMemAccount("dawu0121");
//		memberVO1.setMemPassword("password321");
//		memberVO1.setMemStatus(Byte.valueOf((byte)1));
//		dao.insert(memberVO1);
//		System.out.println("新增成功！");
		

		//修改
//		MemberVO memberVO2 = new MemberVO();
//		memberVO2.setMemNo(1004);
//		memberVO2.setMemName("董老師");
//		memberVO2.setMemSex("f");
//		memberVO2.setMemPhone("0922222222");
//		memberVO2.setMemEmail("doung@gmail.com");
//		memberVO2.setMemUid("a223345678");
//		memberVO2.setMemBirthday(java.sql.Date.valueOf("2000-01-01"));
//		memberVO2.setMemAccount("dawu0121");
//		memberVO2.setMemPassword("password098");
//		memberVO2.setMemStatus(Byte.valueOf((byte)1));
//		dao.update(memberVO2);
//		System.out.println("修改成功！");
		
//
//		//刪除
//		dao.delete(1005);
//		System.out.println("刪除成功！");

		
//		//單一查詢
//		MemberVO memberVO3 = dao.findByPrimaryKey(1001);
//		System.out.print(memberVO3.getMemNo() + ",");
//		System.out.print(memberVO3.getMemName() + ",");
//		System.out.print(memberVO3.getMemSex() + ",");
//		System.out.print(memberVO3.getMemPhone() + ",");
//		System.out.print(memberVO3.getMemEmail() + ",");
//		System.out.print(memberVO3.getMemUid() + ",");
//		System.out.print(memberVO3.getMemBirthday() + ",");
//		System.out.print(memberVO3.getMemAccount() + ",");
//		System.out.print(memberVO3.getMemPassword() + ",");
//		System.out.print(memberVO3.getMemStatus());

		
		//查詢全部
		List<MemberVO> list = dao.getAll();
		for (MemberVO aMem : list) {
			System.out.print(aMem.getMemNo() + ",");
			System.out.print(aMem.getMemName() + ",");
			System.out.print(aMem.getMemSex() + ",");
			System.out.print(aMem.getMemPhone() + ",");
			System.out.print(aMem.getMemEmail() + ",");
			System.out.print(aMem.getMemUid() + ",");
			System.out.print(aMem.getMemBirthday() + ",");
			System.out.print(aMem.getMemAccount() + ",");
			System.out.print(aMem.getMemPassword() + ",");
			System.out.print(aMem.getMemStatus() + ",");
			System.out.println();
		}
	}

}