package org.shopping.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@SessionAttributes({"titem","citem","totPrice"})
public class UserController {
	
	@Autowired
	ShoppingService ss;
	@GetMapping("profile")
	public String getProfile(Model m) {
		
	 return ss.getProfile(m);
	}
	@GetMapping("/userhome")
	public String setHome(Model m) {
		return ss.home(m);
	}

@GetMapping("totalitems")
public String showItems(Model m,HttpSession hs) {
	return ss.showItems(m,hs);
	
}
@PostMapping("cart")
public String getCartItems(HttpServletRequest req,Model m,HttpSession hs) {
	return ss.getCartItems(req,m,hs);
	
}
@GetMapping("citems")
public String cshowItems(Model m,HttpSession hs) {
	return ss.cshowItems(m,hs);
	
}
@GetMapping("logout")
public String logOut(Model m) {
	
return ss.logOut(m);	
}
@GetMapping("uloginforms")
public String logForm(Model m) {
	      
	return ss.logForm(m);
	
}
@GetMapping("del")
public String delUser(Model m,HttpSession session,SessionStatus sst) {
	      
	return ss.delUser(m, session, sst);
	
}
}
