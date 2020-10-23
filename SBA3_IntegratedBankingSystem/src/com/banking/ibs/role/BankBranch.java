package com.banking.ibs.role;

public class BankBranch {

	private int bankBranchID;
	private String bankAddress;
	private String IFSC_code;
	
	public int getBankBranchID() {
		return bankBranchID;
	}
	public void setBankBranchID(int bankBranchID) {
		this.bankBranchID = bankBranchID;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public String getIFSC_code() {
		return IFSC_code;
	}
	public void setIFSC_code(String iFSC_code) {
		IFSC_code = iFSC_code;
	}
	
}
