package com.zuikc.domain;
/*
 * �ͻ���Ϣ��
 * */

import java.util.Date;

public class Customer {
	private Integer customerID;
	private String customerName;
	private String contact;//��ϵ��
	private String address;
	private String cellphone ;//�绰
	private String landline ;//����
	private String intro;//���
	private String comments;//��ע
	private	Date pubdate;//���ʱ��
	private	Date modifydate;// ���/�޸�ʱ��
	
	public Customer() {
		super();
	}
	public Customer(Integer customerID) {
		super();
		this.customerID = customerID;
	}
	public Customer(String customerName, String contact, String address, String cellphone, String landline,
			String intro, String comments, Date pubdate, Date modifydate) {
		super();
		this.customerName = customerName;
		this.contact = contact;
		this.address = address;
		this.cellphone = cellphone;
		this.landline = landline;
		this.intro = intro;
		this.comments = comments;
		this.pubdate = pubdate;
		this.modifydate = modifydate;
	}
	
	public Customer(Integer customerID, String customerName, String contact, String address, String cellphone,
			String landline, String intro, String comments, Date pubdate, Date modifydate) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.contact = contact;
		this.address = address;
		this.cellphone = cellphone;
		this.landline = landline;
		this.intro = intro;
		this.comments = comments;
		this.pubdate = pubdate;
		this.modifydate = modifydate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getLandline() {
		return landline;
	}
	public void setLandline(String landline) {
		this.landline = landline;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", contact=" + contact
				+ ", address=" + address + ", cellphone=" + cellphone + ", landline=" + landline + ", intro=" + intro
				+ ", comments=" + comments + ", pubdate=" + pubdate + ", modifydate=" + modifydate + "]";
	}
	
}