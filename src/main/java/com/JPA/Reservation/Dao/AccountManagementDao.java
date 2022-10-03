package com.JPA.Reservation.Dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountManagementDao {
	private Connection con;
	private java.sql.Statement st;

	public AccountManagementDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b7262", "root", "Gokulgokul123");
		} catch (ClassNotFoundException e) {
			System.out.println("No class found" + e);
		} catch (SQLException e) {
			System.out.println("SQL Error" + e);
		}

	}

	public void createTable() {
		try {
			st = con.createStatement();
			String sql = "create table Account(accntno int primary key, accntholdername varchar(50), mblno varchar(15),accntbalance double, accntholderDOB date)";
			st.execute(sql);
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR..." + e);
		}
	}

	public void insertAccountDetails(int accntno, String accntholdername, String mblno, double accntbalance,
			String accntholderDOB) {
		try {
			st = con.createStatement();
			String sql = "insert into Account values(" + accntno + ",'" + accntholdername + "','" + mblno + "','"
					+ accntbalance + "','" + accntholderDOB + "')";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR...");
		}
	}

	public void viewAccount(int accntno) {
		try {
			st = con.createStatement();
			String sql = "select * from Account where accntno = " + accntno;
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				System.out.println(rs.getString("accntno") + " " + rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR..." + e);
		}
	}

	public void viewAllAccountHolder() {
		try {
			st = con.createStatement();
			String sql = "select * from Account";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("accntno") + " " + rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR..." + e);
		}
	}

	public void updateAccountDetails(int accntno, String accntholdername, String mblno, String dob) {
		try {
			st = con.createStatement();
			String sql = "update Account set accntholdername ='" + accntholdername + "',mblno='" + mblno
					+ "',accntholderDOB='" + dob + "' where accntno = " + accntno;
			st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR..." + e);
		}
	}

	public boolean creditBalance(int accntno, double amt) {
		boolean flag = false;
		try {
			con.setAutoCommit(false);
			st = con.createStatement();
			String sql = "select accntbalance from Account where accntno = " + accntno;
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				double bal = rs.getDouble(1);
				bal = bal + amt;
				sql = "update Account set accntbalance=" + bal + " where accntno =" + accntno;
				if (st.executeUpdate(sql) == 1) {
					con.commit();
					flag = true;
				} else {
					con.rollback();

				}
			}
			con.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR..." + e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return flag;
	}

	public int deleteAccount(int accntno) {
		try {
			st = con.createStatement();
			String sql = "delete from Account where accntno = " + accntno;
			return st.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR..." + e);
			return 0;
		}
	}
}
