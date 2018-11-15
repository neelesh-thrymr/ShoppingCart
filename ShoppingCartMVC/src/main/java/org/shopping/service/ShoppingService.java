package org.shopping.service;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.shopping.model.ItemModel;
import org.shopping.model.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Service

public class ShoppingService {


		List<ItemModel> item=new ArrayList<ItemModel>();
		
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

	public String home() {
		return "userhome";
	}

	public String newUser(UserModel umm,Model m){
		if(umm==null) {
			System.out.println("Please Insert the Data First");
			return "newuser";
		}
		UserModel um=new UserModel();
		um.setName(umm.getName());
		um.setEmail(umm.getEmail());
		um.setPassword(umm.getPassword());
		um.setAddress(umm.getAddress());
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
	
	List<ItemModel> lst=(ArrayList<ItemModel>)hs.getAttribute("imodel");
	m.addAttribute("titem",lst);
		return "itemlist";
		
	}

public String cshowItems(Model m,HttpSession hs) {

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


	public String logForm(Model m, HttpSession session, SessionStatus sst) {
		sst.setComplete();
		session.removeAttribute("user");
		m.addAttribute("titem",new ArrayList<ItemModel>());
		m.addAttribute("u",new UserModel());
		return "loginform";
	}
}
