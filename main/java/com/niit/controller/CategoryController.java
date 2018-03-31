package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAOImpl;

	@ModelAttribute("category")
	public Category createCategoryModel() {
		Category category = new Category();
		return category;

	}

	@RequestMapping(value = { "/Category" })
	public String showCategoryPage(Model model) {
		model.addAttribute("categories", categoryDAOImpl.listCategories());

		return "Category";
	}

	@RequestMapping(value = "getCategory", method = RequestMethod.POST)

	public String showCategoryPage(@ModelAttribute Category category, Model m) {
		System.out.println("getting the Category ");
		m.addAttribute("category", category);
		categoryDAOImpl.addCategory(category);
		return "redirect:/Category";

	}

	@RequestMapping("getCategoryForEdit/{cid}")
	public String getCategoryForEdit(@PathVariable("cid") int id, Model model) {
		Category category = categoryDAOImpl.getCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("categories", categoryDAOImpl.listCategories());
		return "Category";
	}

	@RequestMapping("getCategoryForDelete/{cid}")
	public String getCategoryForDelete(@PathVariable("cid") int id, Model model) {
		Category category = categoryDAOImpl.getCategory(id);
		categoryDAOImpl.deleteCategory(category);
		model.addAttribute("category", category);
		model.addAttribute("categories", categoryDAOImpl.listCategories());
		return "Category";
	}
}
