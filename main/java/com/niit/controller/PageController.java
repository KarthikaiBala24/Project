package com.niit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	@RequestMapping(value = { "/user" })
	public String showProduct() {
		return "user";
	}
	@RequestMapping(value = { "/Login" })
	public String showLoginPage() {
		
		return "Login";
	}
	@RequestMapping(value = { "/logout" })
	public String showLogoutPage() {
		return "index";
	}

	@RequestMapping(value = "getData", method = RequestMethod.POST)

	public String showRegisterPage(@Valid @ModelAttribute UserDetails userdetails, BindingResult Result, Model m) {
		if (Result.hasErrors())

		{

			return "Register";
		} else {
			System.out.println("username" + userdetails.getUsername());
			System.out.println("password" + userdetails.getPassword());
			System.out.println("Confirmpassword" + userdetails.getConfirmpassword());
			System.out.println("emailid" + userdetails.getEmailid());
			System.out.println("address.door" + userdetails.getAddress());
			System.out.println("address.street" + userdetails.getAddress());
			System.out.println("address.state" + userdetails.getAddress());
			System.out.println("address.pin" + userdetails.getAddress());

			System.out.println("userdetails are created");
			m.addAttribute("userdetails", userdetails);

			List<Address> addresses = new ArrayList<Address>();

			addresses.add(userdetails.getAddress());
			userdetails.setAddresses(addresses);

			userDetailsDAOImpl.addUserDetails(userdetails);
		}

		return "redirect:/Login";

	}

}
