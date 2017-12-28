package br.com.rafa.estudo2.controllers;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.rafa.estudo2.models.PaymentData;
import br.com.rafa.estudo2.daos.ProductDao;
import br.com.rafa.estudo2.models.Product;
import br.com.rafa.estudo2.models.ShoppingCart;
import br.com.rafa.estudo2.models.ShoppingItem;

@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCart shoppingCart;
	
	@Autowired
	private ProductDao productDAO;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(Long productId) {
		ShoppingItem item = createItem(productId);
		shoppingCart.add(item);
		return new ModelAndView("redirect:/product");
	}
	
	private ShoppingItem createItem(Long productId) {
		Product product = productDAO.findById(productId);
		ShoppingItem item = new ShoppingItem(product);
		return item;
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public Callable<String> checkout() {
		return () -> {
			BigDecimal total = shoppingCart.getTotal();
			String uriToPay = "http://book-payment.herokuapp.com/payment";
			try {
				String response = restTemplate.postForObject(uriToPay, new PaymentData(total), String.class);
				System.out.println(response);
				return "redirect:/product";
			} catch (HttpClientErrorException exception) {
				System.out.println("Ocorreu	um	erro ao	criar o	Pagamento:	" + exception.getMessage());
				return "redirect:/shopping";
			}
		};
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "shoppingCart/items";
	}

}
