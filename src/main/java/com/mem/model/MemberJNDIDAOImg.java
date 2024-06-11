package com.mem.model;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberJNDIDAOImg implements MemberDAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CIA102G2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = 
			"INSERT INTO member (mem_name, mem_sex, mem_phone, mem_email, mem_uid, mem_birthday, mem_account, mem_password, mem_img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT mem_no, mem_name, mem_sex, mem_phone, mem_email, mem_uid, mem_birthday, mem_account, mem_password, mem_status FROM member ORDER BY mem_no";
		private static final String GET_ONE_STMT = 
			"SELECT mem_no, mem_name, mem_sex, mem_phone, mem_email, mem_uid, mem_birthday, mem_account, mem_password, mem_status FROM member WHERE mem_no = ?";
		private static final String DELETE = 
			"DELETE FROM member WHERE mem_no = ?";
		private static final String UPDATE = 
			"UPDATE member SET mem_name=?, mem_sex=?, mem_phone=?, mem_email=?, mem_uid=?, mem_birthday=?, mem_account=?, mem_password=?, mem_status=?, mem_img=? WHERE mem_no = ?";
		private static final String UPDATE_WITHOUT_IMG =
			"UPDATE member SET mem_name=?, mem_sex=?, mem_phone=?, mem_email=?, mem_uid=?, mem_birthday=?, mem_account=?, mem_password=?, mem_status=?, mem_img=null WHERE mem_no = ?";

		@Override
		public void insert(MemberVO memberVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setString(1, memberVO.getMemName());
				pstmt.setString(2, memberVO.getMemSex());
				pstmt.setString(3, memberVO.getMemPhone());
				pstmt.setString(4, memberVO.getMemEmail());
				pstmt.setString(5, memberVO.getMemUid());
				pstmt.setDate(6, memberVO.getMemBirthday());
				pstmt.setString(7, memberVO.getMemAccount());
				pstmt.setString(8, memberVO.getMemPassword());
				pstmt.setBytes(9, memberVO.getMemImg());

				pstmt.executeUpdate();

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
		public void updateWithoutImg(MemberVO memberVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE_WITHOUT_IMG);

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

				con = ds.getConnection();
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
				pstmt.setBytes(10, memberVO.getMemImg());
				pstmt.setInt(11, memberVO.getMemNo());

				pstmt.executeUpdate();
				
				// Handle any driver errors
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

				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, memNo);

				pstmt.executeUpdate();

				// Handle any driver errors
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

				con = ds.getConnection();
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

				con = ds.getConnection();
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


		@Override
		public List<MemberVO> findBySearching(String input) {
			// TODO Auto-generated method stub
			return null;
		}


}