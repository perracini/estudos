package br.com.rafa.estudo2.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.annotation.Profile;

import br.com.rafa.estudo2.daos.CategoryDao;
import br.com.rafa.estudo2.daos.ProductDao;
import br.com.rafa.estudo2.models.Product;

@Controller
@Transactional
@Profile("ROLE_ADMIN")
public class ProfiledProductController {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private CategoryDao categoryDao;

	@PostMapping("/product")
	public ModelAndView save(@Valid Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(product);
		}
		productDao.save(product);
		return new ModelAndView("redirect:/product");
	}

	@GetMapping("/product/form")
	public ModelAndView form(Product product) {
		ModelAndView modelAndView = new ModelAndView("product/form-add");
		return loadFormDependencies(modelAndView);

	}

	private ModelAndView loadFormDependencies(ModelAndView modelAndView) {
		modelAndView.addObject("categoryList", categoryDao.all());
		return modelAndView;
	}

}
