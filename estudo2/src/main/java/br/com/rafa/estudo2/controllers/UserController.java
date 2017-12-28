package br.com.rafa.estudo2.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.rafa.estudo2.models.User;
import br.com.rafa.estudo2.services.SecurityService;
import br.com.rafa.estudo2.services.UserService;


	@Controller
	public class UserController {
		@Autowired
	    private UserService userService;

	    @Autowired
	    private SecurityService securityService;

	    
	    @RequestMapping(value="user/cadastro_usuario", method=RequestMethod.GET)
		public ModelAndView form(User user){
			ModelAndView mv = new ModelAndView("user/cadastro_usuario");
			return mv;
		}

		@RequestMapping(value="user/cadastro_usuario", method=RequestMethod.POST)
		@Transactional
		public ModelAndView save(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes){
			if (bindingResult.hasErrors()){
				return form(user);
			}

			userService.save(user);
			securityService.autologin(user.getUsername(), user.getPasswordConfirm());
			redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso");
			return new ModelAndView("redirect:/home");
		}
		
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", "Invalid username and password!");
			}

			if (logout != null) {
				model.addObject("msg", "You've been logged out successfully.");
			}
			model.setViewName("/login");

			return model;

		}

}
