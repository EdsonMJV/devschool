package br.com.mjv.bank.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mjv.bank.cliente.model.Cliente;
import br.com.mjv.bank.login.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String iniciarLogin() {
		return "login";
	}
	
	
	public ModelAndView home() {
		
		
		return new ModelAndView("/home");
	}
	
	
	@PostMapping
	public String autenticar(Login login, RedirectAttributes atributos) {
		Cliente cliente = service.buscarClienteUsuario(login.getUsuario());
		
		if(cliente == null) {
			
			atributos.addFlashAttribute("mensagem", "Usuário e/ ou senha inválida.");
			
			
			return "redirect:/login";
		}
		
		return "login";
	}
	
}
