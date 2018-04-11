package com.niit.controller;


import java.io.File;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;

import com.niit.model.Category;
import com.niit.model.Product;

@Controller

public class ProductController {
	@Autowired
	private ProductDAO productDAOImpl;
	@Autowired
	private CategoryDAO categoryDAOImpl;

	@ModelAttribute("product")
	public Product createProductModel() {
		Product product = new Product();
		return product;
	}

	@ModelAttribute("category")
	public Category createCategoryModel() {
		Category category = new Category();
		return category;
	}

	@RequestMapping(value = { "/Product" })
	public String showProductPage(Model model) {

		model.addAttribute("products", productDAOImpl.listProducts());
		model.addAttribute("categories", categoryDAOImpl.listCategories());
		System.out.println("success");
		return "Product";

	}

	@RequestMapping(value = "/Category", method = RequestMethod.POST)
	public String showCategoryPage(@Valid @ModelAttribute Category category,BindingResult result, Model m) {
		if (result.hasErrors()) {
			return "redirect:/category";
		} else {
			System.out.println("cname" + category.getCname());
			System.out.println("cdesc" + category.getCdesc());
			System.out.println("getting the Category ");
		
		System.out.println("---get category--");
		m.addAttribute("category", category);
		m.addAttribute("categories", categoryDAOImpl.listCategories());
		System.out.println("Category ID-> " + category.getId());
		categoryDAOImpl.addCategory(category);
		}
		return "redirect:/Product";

	}

	@RequestMapping(value = "getProduct", method = RequestMethod.POST)
	public String showProductPage(@Valid @ModelAttribute Product product,BindingResult Result, Model m) {
		
		if (Result.hasErrors())

		{

			return "redirect:/Product";
		} else {
			
			System.out.println("pname" + product.getPname());
		System.out.println("pdesc"+product.getPdesc());
		System.out.println("price"+product.getPrice());
		System.out.println("category.id"+product.getCategory());
		System.out.println("getting the product ");
		System.out.println("Product -> " + product.getPname());
		System.out.println("Product ID -> " + product.getId());
		m.addAttribute("product", product);
		productDAOImpl.addProduct(product);
		}
		return "redirect:/Product";
	}

	@RequestMapping("getProductForEdit/{pid}")
	public String getProductForEdit(@PathVariable("pid") int id, Model model) {
		Product product = productDAOImpl.getProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("products", productDAOImpl.listProducts());
		model.addAttribute("categories", categoryDAOImpl.listCategories());
		return "Product";
	}
	
	@RequestMapping("getProductFor/Upload/{pid}")
	public String getProductForUpload(@PathVariable("pid") int id, Model model) {
		Product product = productDAOImpl.getProduct(id);
		model.addAttribute("uploadProduct", product);
		model.addAttribute("products", productDAOImpl.listProducts());
		model.addAttribute("categories", categoryDAOImpl.listCategories());
		return "Product";
	}
	
	@RequestMapping("getProductForDelete/{pid}")
	public String getProductForDelete(@PathVariable("pid") int id, Model model) {
		Product product = productDAOImpl.getProduct(id);
		productDAOImpl.deleteProduct(product);
		model.addAttribute("products", productDAOImpl.listProducts());
		model.addAttribute("categories", categoryDAOImpl.listCategories());
		return "Product";
	}

	@RequestMapping(value = "upload/{id}", method = RequestMethod.POST)
	public String upload(@PathVariable("id") int id, @RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) {
		
		String upload = "";
		String imgPath = request.getSession().getServletContext().getRealPath("/resources/images");
		File dir = new File(imgPath + File.separator +id+ ".jpg");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File serverFile = new File(dir.getAbsolutePath());
		upload = file.getOriginalFilename();
		try {
			file.transferTo(serverFile);
			System.out.println("File Transfered to =-> "+dir.getPath());
		} catch (IOException e) {
			System.out.println("error : " + e.getMessage());
		}
		return "redirect:/Product";
	}
}
