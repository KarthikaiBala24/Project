package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String showCategoryPage(@ModelAttribute Category category, Model m) {
		System.out.println("---get category--");
		m.addAttribute("category", category);
		m.addAttribute("categories", categoryDAOImpl.listCategories());
		System.out.println("Category ID-> " + category.getId());
		categoryDAOImpl.addCategory(category);

		return "redirect:/Product";

	}

	@RequestMapping(value = "getProduct", method = RequestMethod.POST)
	public String showProductPage(@ModelAttribute Product product, Model m) {
		System.out.println("getting the product ");
		System.out.println("Product -> " + product.getPname());
		System.out.println("Product ID -> " + product.getId());
		m.addAttribute("product", product);
		productDAOImpl.addProduct(product);

		return "redirect:/Product";
	}

	@RequestMapping("getProductForEdit/{pid}")
	public String getProductForEdit(@PathVariable("pid") int id, Model model) {
		Product product = productDAOImpl.getProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("products", productDAOImpl.listProducts());
		return "Product";
	}

	@RequestMapping("getProductForDelete/{pid}")
	public String getProductForDelete(@PathVariable("pid") int id, Model model) {
		Product product = productDAOImpl.getProduct(id);
		productDAOImpl.deleteProduct(product);
		model.addAttribute("products", productDAOImpl.listProducts());
		return "Product";
	}

	/*@RequestMapping(value = "/upload/{pid}", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			@PathVariable("pid") int id, @ModelAttribute Product product, Model model) {
		model.addAttribute("upload", product);
		model.addAttribute("upload", productDAOImpl.listProducts());

		String imagepath = request.getServletContext().getRealPath("/resources/images");
		System.out.println("Directory:" + imagepath);
		Path path = Paths.get(imagepath + File.separator + product.getProduct(id) + ".jpg");
		File imageFile = new File(path.toString());
		System.out.println("Path:" + path.toString());
		if (!imageFile.exists()) {
			imageFile.mkdirs();
		}
		try {
			file.transferTo(imageFile);
			return "redirect:/Product";

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Product";
	}
*/
@RequestMapping(value="upload", method=RequestMethod.POST)
public  String upload(@RequestParam("file") MultipartFile file,HttpServletRequest request, @ModelAttribute Product product ,Model model )

{
	model.addAttribute("upload", product);
	model.addAttribute("uploads", productDAOImpl.listProducts());
	 String upload="";
	 String imgPath = request.getSession().getServletContext().getRealPath("/resources/images");
     File dir = new File(imgPath + File.separator + ".jpg");
     if (!dir.exists()) {
         dir.mkdirs();
     }
     File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
     upload = file.getOriginalFilename();
     try {
         try (InputStream is = file.getInputStream(); 
        		 BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
             int i;
             while ((i = is.read()) != -1) {
                 stream.write(i);
             }
             stream.flush();
             return "redirect:/Product";
         }
     } catch (IOException e) {
         System.out.println("error : " + e.getMessage());
     }
	return "Product";
}











/*{
	System.out.println("File name:"+file);
	String fileName = null;
	if (!file.isEmpty()) {
		try {
            fileName = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            BufferedOutputStream buffStream = 
                    new BufferedOutputStream(new FileOutputStream(new File("resource/images/.jpg" + fileName)));
            buffStream.write(bytes);
            buffStream.close();
            return "You have successfully uploaded " + fileName;
        } catch (Exception e) {
            return "redirect:/Product";
        }
    } 
	
	else {
        return "Product";
    }
*/
	}
	







