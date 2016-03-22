package com.ers.valueobject;


/**
 *TeamDetails.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class has employee's team details both supervisor and subordinate employees details
 *as applicable
 *
*/
public class TeamDetailsVO{
	int[] subordinateList ;
	int supervisor;
	
	public boolean  isSupervisor(){
		boolean isSupervisor = false;
		if (subordinateList.length!=0){
			isSupervisor = true;
		}
		return isSupervisor;
	}
	public int[] getSubordinateList() {
		return subordinateList;
	}

	public void setSubordinateList(int[] subordinateList) {
		this.subordinateList = subordinateList;
	}

	public int getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(int supervisor) {
		this.supervisor = supervisor;
	}
}