package org.shopping.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.shopping.model.ItemModel;
import org.shopping.model.UserModel;
import org.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("imodel")
public class AdminController {

	@Autowired
	ShoppingService ss;
@RequestMapping("ahome")
public String ahome() {
 return "admin";
}
@RequestMapping("additems")
public String addItems(Model m) {
	m.addAttribute("ai",new ItemModel());
	return "additems";
}
@RequestMapping("items")
public String ashowItems() {
	return "ashowitem";
	
}
@RequestMapping("add")
public String addItm(@ModelAttribute("ai") ItemModel im ,Model m) {
	return ss.addItm(im, m);
}
@RequestMapping("ditems")
public String deleteItem() {
	return "deleteitem";
	
}

@RequestMapping("del")
public String delItem(@ModelAttribute ItemModel id , Model m) {
		return ss.delItem(id,m);
}
@GetMapping("aloginforms")
public String logForm(Model m,HttpSession hs) {
	UserModel um=(UserModel) hs.getAttribute("user");
	m.addAttribute("user",um);
	m.addAttribute("u",new UserModel());
	return "loginform";
	
}
}
