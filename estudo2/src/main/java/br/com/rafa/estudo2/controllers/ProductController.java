package br.com.rafa.estudo2.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.rafa.estudo2.daos.ProductDao;
import br.com.rafa.estudo2.models.Product;
import br.com.rafa.estudo2.daos.CategoryDao;


@Controller
@RequestMapping("/product")
@Transactional
public class ProductController
{

   @Autowired
   private ProductDao productDao;
   @Autowired
   private CategoryDao categoryDao;

   @PostMapping
	public ModelAndView save(@Valid Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(product);
		}
		productDao.save(product);
		return new ModelAndView("redirect:/product");
	}

	@GetMapping("/form")
	public ModelAndView form(Product product) {
		ModelAndView modelAndView = new ModelAndView("product/form-add");
		return loadFormDependencies(modelAndView);

	}
   
   private ModelAndView loadFormDependencies(ModelAndView modelAndView)
   {
      modelAndView.addObject("categoryList", categoryDao.all());
      return modelAndView;
   }

   @GetMapping("/{id}")
   public ModelAndView load(@PathVariable("id") Long id)
   {
      ModelAndView modelAndView = new ModelAndView("product/form-update");
      modelAndView.addObject("product", productDao.findById(id));
      loadFormDependencies(modelAndView);
      return modelAndView;
   }

   @GetMapping
   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
   {
      ModelAndView modelAndView = new ModelAndView("product/list");
      modelAndView.addObject("paginatedList", productDao.paginated(page, 10));
      return modelAndView;
   }

   @GetMapping("/remove/{id}")
   public String remove(@PathVariable("id") Long id)
   {
      Product product = productDao.findById(id);
      productDao.remove(product);
      return "redirect:/product";
   }

   @PostMapping("/{id}")
   public ModelAndView update(@PathVariable("id") Long id, @Valid Product product, BindingResult bindingResult)
   {
      product.setId(id);
      if (bindingResult.hasErrors())
      {
         return loadFormDependencies(new ModelAndView("product/form-update"));
      }
      productDao.update(product);
      return new ModelAndView("redirect:/product");
   }
   
   @GetMapping("/show/{id}")
   public ModelAndView show(@PathVariable("id") Long id)
   {
      ModelAndView modelAndView = new ModelAndView("product/show");
      modelAndView.addObject("product", productDao.findById(id));
      return modelAndView;
   }
}
