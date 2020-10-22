package br.com.mjv.bank.cliente;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/cliente")
public class ClienteController {

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView inicio(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("home");
//		mv.addObject("cliente", service.buscarPorId(id));
		return mv;
	}
}
