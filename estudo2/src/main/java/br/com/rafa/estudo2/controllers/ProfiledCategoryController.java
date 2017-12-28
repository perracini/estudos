package br.com.rafa.estudo2.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.rafa.estudo2.daos.CategoryDao;
import br.com.rafa.estudo2.models.Category;

@Controller
@Transactional
@Profile("ROLE_ADMIN")
public class ProfiledCategoryController {

	  @Autowired
	   private CategoryDao categoryDao;

	   @GetMapping("/category/form")
	   public ModelAndView form(Category category)
	   {
	      ModelAndView modelAndView = new ModelAndView("category/form-add");
	      return modelAndView;

	   }

	   @PostMapping("/category")
	   public ModelAndView save(@Valid Category category, BindingResult bindingResult)
	   {
	      if (bindingResult.hasErrors())
	      {
	         return form(category);
	      }
	      categoryDao.save(category);
	      return new ModelAndView("redirect:/category");
	   }
	
}
