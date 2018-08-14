package com.frontEnd.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frontEnd.dao.RoleDao;
import com.frontEnd.dao.UserDao;
import com.frontEnd.domain.User;
import com.frontEnd.domain.security.UserRole;
import com.frontEnd.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	 
	@RequestMapping(value = "/signup", method = RequestMethod.GET) 
	public String signup(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") User user, Model model) {
		if (userService.checkUserExists(userDao, user.getUsername(), user.getEmail())) {
			if (userService.checkEmailExists(userDao, user.getEmail())) {
				model.addAttribute("emailExists",true);
			}
			if (userService.checkUsernameExists(userDao, user.getUsername())) {
				model.addAttribute("usernameExists",true);
			}
			
			return "signup";
		} else {
			Set<UserRole> userRoles = new HashSet<>();
			userRoles.add(new UserRole(user,roleDao.findByName("ROLE_USER")));
			userService.create(user,userRoles);
					
			return "redirect:/";
		}
	}

}
