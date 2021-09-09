package com.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Donation implements Serializable{
	@Id
	@GeneratedValue
	private int dId;
	private String dName;
	private int dQuantity;
	private String dDate;
	public Donation(int dId, String dName, int dQuantity, String dDate) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.dQuantity = dQuantity;
		this.dDate = dDate;
	}
	public Donation() {
		// TODO Auto-generated constructor stub
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public int getdQuantity() {
		return dQuantity;
	}
	public void setdQuantity(int dQuantity) {
		this.dQuantity = dQuantity;
	}
	public String getdDate() {
		return dDate;
	}
	public void setdDate(String dDate) {
		this.dDate = dDate;
	}
	@Override
	public String toString() {
		return "Donation [dId=" + dId + ", dName=" + dName + ", dQuantity=" + dQuantity + ", dDate=" + dDate + "]";
	}
	

}
