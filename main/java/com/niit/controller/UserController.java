package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Product;
@Controller
public class UserController {
	@Autowired
	private ProductDAO productDAOImpl;
	@Autowired
	private CategoryDAO categoryDAOImpl;
	@RequestMapping("viewProduct/{pid}")
	public String viewProduct(@PathVariable("pid")int id,Model m)
	{
		Product product = productDAOImpl.getProduct(id);
		m.addAttribute("product", product);
		m.addAttribute("products", productDAOImpl.listProducts());
		m.addAttribute("categories", categoryDAOImpl.listCategories());
		return "/user";
	}


}
