package org.shopping.controller;


import javax.servlet.http.HttpSession;

import org.shopping.model.ItemModel;
import org.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@SessionAttributes("titem")
public class UserController {
	
	@Autowired
	ShoppingService ss;
	@GetMapping("profile")
	public String getProfile(Model m) {
	 return "userprofile";
	}
	@GetMapping("/userhome")
	public String setHome() {
		return ss.home();
	}

@GetMapping("totalitems")
public String showItems(Model m,HttpSession hs) {
	return ss.showItems(m,hs);
	
}
@GetMapping("citems")
public String cshowItems(Model m,HttpSession hs) {
	return ss.cshowItems(m,hs);
	
}
@GetMapping("uloginforms")
public String logForm(Model m,HttpSession session,SessionStatus sst) {
	      
	return ss.logForm(m, session, sst);
	
}

}
