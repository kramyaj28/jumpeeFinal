package com.project.jumpee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.jumpee.model.Product;
import com.project.jumpee.service.ProductService;

@RestController
@RequestMapping("/api/auth")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/sort-products")
	public Page<Product> getProducts(@PageableDefault(direction = Direction.ASC, size = 9) Pageable page) {
		return productService.sortPage(page);
	}
	
	@GetMapping("/search-products")
	public List<Product> search(@Param("keyword") String keyword, Model model) {
		List<Product> searchResultList = productService.search(keyword);
		model.addAttribute("keyword", keyword);
		return searchResultList;
	}

}
