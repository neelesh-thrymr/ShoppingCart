package org.shopping.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.shopping.model.ItemModel;
import org.shopping.model.UserModel;
import org.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	
	@Autowired
	ShoppingService ss;
	
	@RequestMapping("loginforms")
	public String getForm(Model m) {
		m.addAttribute("u",new UserModel());
			return "loginform";
	}
	
	@RequestMapping("exer")
	public String show() {
		return "exercise";
	}
	
@RequestMapping("/login")
public String userHome(@ModelAttribute("u") UserModel usrmdl,Model m,HttpSession hs) {

String vname=ss.userHome(usrmdl,m,hs);
 return vname;
	
}


@RequestMapping("/newusers")
public String newUserData(Model m) {
	
	return ss.newUserData(m);
}

@RequestMapping("newuser")
public String newUser(@ModelAttribute UserModel umm,Model m){
 
	return ss.newUser(umm, m);
	
}

}


