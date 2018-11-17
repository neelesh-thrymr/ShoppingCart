package org.shopping.service;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.shopping.model.CartItems;
import org.shopping.model.ItemModel;
import org.shopping.model.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import org.springframework.web.bind.support.SessionStatus;

@Service

public class ShoppingService {

private static boolean  ACTIVE=true;
private static boolean DELACC=false;

		List<ItemModel> item=new ArrayList<ItemModel>();
		List<CartItems> cim=new ArrayList<CartItems>();
		public String show() {
			return "exercise";
		}
		

	public String userHome(UserModel usrmdl,Model m,HttpSession hs) {
		UserModel um=(UserModel)hs.getAttribute("user");
		String p1=usrmdl.getPassword();
		String n1=usrmdl.getEmail();
		if(n1.equals("admin") && p1.equals("admin")) {
			
			return "admin";
		}
		else
		{
			String n2=um.getEmail();
			String p2=usrmdl.getPassword();
			if(n1.equals(n2) && p1.equals(p2)) {
		 m.addAttribute("name",um.getName().toUpperCase());
		 ShoppingService.ACTIVE=true;
		return "userhome";
		}
			else
			{
				m.addAttribute("u",new UserModel());
				System.out.println("Invalid username or password");
				
			}
		}
			
		return "loginform";
		
	}
	
	public String newUserData(Model m) {
		m.addAttribute("nu",new UserModel());
		return "newuser";
	}

	public String home(Model m) {
		if(ShoppingService.ACTIVE==false || ShoppingService.DELACC==true)
		{m.addAttribute("msg","Please Login First");
		m.addAttribute("u",new UserModel());
			return "loginform";
		}
		return "userhome";
	}

	public String newUser(UserModel umm,Model m){
		
		UserModel um=new UserModel();
		um.setName(umm.getName());
		um.setEmail(umm.getEmail());
		um.setPassword(umm.getPassword());
		um.setAddress(umm.getAddress());
		ShoppingService.ACTIVE=true;
		ShoppingService.DELACC=false;
		m.addAttribute("user",um);
		m.addAttribute("u",new UserModel());
		return "loginform";
		
	}

	public String addItm(ItemModel im ,Model m) {
		if(!im.equals(null))
		{
			ItemModel imo=new ItemModel();
			imo.setId(im.getId());
			imo.setIname(im.getIname());
			imo.setPrice(im.getPrice());
			imo.setQty(im.getQty());
			item.add(imo);
			m.addAttribute("imodel",item);
			m.addAttribute("msg","Item Added Successfully.");
			return "admin";
		}
		m.addAttribute("ai",new ItemModel());
		
		return "additems";
	}

public String showItems(Model m,HttpSession hs) {
	if(ShoppingService.ACTIVE==false || ShoppingService.DELACC==true) 
	{m.addAttribute("u",new UserModel());
		hs.removeAttribute("titem");
		m.addAttribute("msg","Please Login First");
		return "loginform";
	}
	m.addAttribute("titem",hs.getAttribute("imodel"));
		return "itemlist";
		
	}

public String cshowItems(Model m,HttpSession hs) {
	if(ShoppingService.ACTIVE==false || ShoppingService.DELACC==true) 
	{
		hs.removeAttribute("titem");
		m.addAttribute("u",new UserModel());
		m.addAttribute("msg","Please Login First");
		return "loginform";
	}
		return "cartitem";
	}


	public String delItem(ItemModel id , Model m) {
		int ind=0;
		ItemModel im=new ItemModel();
		for(int i=0;i<item.size();i++) {
			im=item.get(i);
			if(im.getId()==id.getId()) {
				ind=i;break;
			}
		}
		item.remove(ind);
		m.addAttribute("imodel",item);
		m.addAttribute("msg","Data Deleted Successfully");
		return "admin";
	}


	public String logForm(Model m) {
		ShoppingService.ACTIVE=false;
		m.addAttribute("u",new UserModel());
		return "loginform";
	}


	public String getCartItems(HttpServletRequest req,Model m, HttpSession hs) {
		String [] itmIds=(req.getParameterValues("ids"));
		String[] qtys;
		List<ItemModel> im=(List<ItemModel>)hs.getAttribute("titem");
		int tprice=0;
		for(int i=0;i<itmIds.length;i++) {
			for (ItemModel mm : im) {
				if(mm.getId()==Integer.parseInt(itmIds[i]))
				{
					int id=mm.getId();
					String name=mm.getIname();
					int rqty=Integer.parseInt(req.getParameter(mm.getId()+"qty"));
					int price= rqty * (int)mm.getPrice();
					mm.setQty(mm.getQty()-rqty);
					cim.add(new CartItems(id,name,rqty,price));
					CartItems.tprice+=price;
				}
			}
		}
		m.addAttribute("citem",cim);
		m.addAttribute("totPrice",CartItems.tprice);
		m.addAttribute("msg","Items Added To the Cart Successfully.");
		return "itemlist";
	}


	public String delUser(Model m, HttpSession session, SessionStatus sst) {
		sst.setComplete();
		session.removeAttribute("user");
		ShoppingService.ACTIVE=false;
		ShoppingService.DELACC=true;
		cim.clear();
		item.clear();
		m.addAttribute("u",new UserModel());
		return "loginform";
	}


	public String logOut(Model m) {
		ShoppingService.ACTIVE=false;
		return "loginform";
	}


	public String getProfile(Model m) {
		if(ShoppingService.ACTIVE==false || ShoppingService.DELACC==true)
		{m.addAttribute("msg"," Please Login First");
		 m.addAttribute("u",new UserModel());
			return "loginform";
		}
		return "userprofile";
		
	}
}
