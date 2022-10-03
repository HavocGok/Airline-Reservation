package com.JPA.Reservation.Service;

import com.JPA.Reservation.Dao.AccountManagementDao;

public class Account_Service {

	private AccountManagementDao accDao = new AccountManagementDao();

	public void createAccTable() {
		accDao.createTable();
		System.out.println("Table created successfully");
	}

	public boolean insertAccount(int accNO, String accName, String accMobileNO, double accBalance, String accDob) {
		accDao.insertAccountDetails(accNO, accName, accMobileNO, accBalance, accDob);
		return true;
	}

	public boolean updateAccountDetails(int accNO, String accName, String accMobileNO, String dob) {
		accDao.updateAccountDetails(accNO, accName, accMobileNO, dob);
		return true;
	}

	public void viewAccount(int accNO) {
		accDao.viewAccount(accNO);
	}

	public void viewAllAccount() {
		accDao.viewAllAccountHolder();
	}

	public boolean creditAccount(int accNO, double amt)
	{
		return accDao.creditBalance(accNO, amt);
		 
	}
	public boolean deleteAccount(int accNO) {
		if (accDao.deleteAccount(accNO) == 1)
			return true;
		else
			return false;
	}

}