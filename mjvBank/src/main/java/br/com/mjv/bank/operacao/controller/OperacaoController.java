package br.com.mjv.bank.operacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mjv.bank.cliente.service.ClienteService;

@Controller
@RequestMapping("cliente/{id}/operacao")
public class OperacaoController {
	
	@Autowired
	private ClienteService service;
	
	
	@GetMapping()
	public ModelAndView iniciarOperacao(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("/operacao/transferencia");
		
		mv.addObject("cliente", service.buscarPorId(id));
		
		return mv;
	}

}
