package com.niit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.UserDetailsDAO;
import com.niit.model.Address;
import com.niit.model.UserDetails;

@Controller
public class PageController {

	@Autowired
	private UserDetailsDAO userDetailsDAOImpl;

	@ModelAttribute("userdetails")

	public UserDetails createUserDetailsModel() {
		UserDetails userdetails = new UserDetails();
		return userdetails;

	}

	@RequestMapping(value = { "/" })
	public String showHomePage() {
		return "index";
	}

	@RequestMapping(value = { "/Register" })
	public String showRegisterPage() {
		return "Register";
	}

	@RequestMapping(value = { "/Login" })
	public String showLoginPage() {
		return "Login";
	}

	@RequestMapping(value = "getData", method = RequestMethod.POST)

	public String showRegisterPage(@ModelAttribute UserDetails userdetails, Model m) {
		System.out.println("userdetails are created");
		m.addAttribute("userdetails", userdetails);

		List<Address> addresses = new ArrayList<Address>();

		addresses.add(userdetails.getAddress());
		userdetails.setAddresses(addresses);

		userDetailsDAOImpl.addUserDetails(userdetails);

		return "redirect:/Login";
	}

	@RequestMapping(value = "/Edit", method = RequestMethod.GET)

	public String showEditPage(@ModelAttribute UserDetails userdetails, Model m) {

		return "Register";
	}

}
