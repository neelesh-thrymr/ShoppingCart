package org.shopping.model;

public class CartItems {
	private int id;
	private String iname;
	private int reqQty;
	private int price;
	public static int tprice;
	public int getId() {
		return id;
	}
	public String getIname() {
		return iname;
	}
	public int getReqQty() {
		return reqQty;
	}
	public int getPrice() {
		return price;
	}
	public int getTprice() {
		return tprice;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public void setReqQty(int reqQty) {
		this.reqQty = reqQty;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setTprice(int tprice) {
		this.tprice = tprice;
	}
	public CartItems(int id, String iname, int reqQty, int price) {
		super();
		this.id = id;
		this.iname = iname;
		this.reqQty = reqQty;
		this.price = price;
	}
	public CartItems() {
		super();
	}
	

}
