package br.com.mjv.bank.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mjv.bank.cliente.model.Cliente;
import br.com.mjv.bank.cliente.service.ClienteService;
import br.com.mjv.bank.exception.BusinessException;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	
	@RequestMapping(path = "/cadastrar", method = RequestMethod.GET)
	public String cadastrarCliente() {
		return "cliente/cadastro";
	}
	
	
	@RequestMapping(path = "/cadastrar", method = RequestMethod.POST)
	public String incluirCliente(Cliente cliente, RedirectAttributes atributos) {
		
		if(StringUtils.isEmpty(cliente.getNome())) {
			atributos.addFlashAttribute("mensagem", "Nome não informado");
			return "redirect:/cliente/cadastrar";
		}
		
		if(StringUtils.isEmpty(cliente.getUsuario())) {
			//RETORNA ERRO PARA A TELA
			atributos.addFlashAttribute("mensagem", "Usuário não informado");
			return "redirect:/cliente/cadastrar";
		}
		
		if(StringUtils.isEmpty(cliente.getCpf())) {
			atributos.addFlashAttribute("mensagem", "CPF não informado");
			return "redirect:/cliente/cadastrar";
		}
		
		try {
			Integer id = service.incluirCliente(cliente);
		} catch (BusinessException be) {
			atributos.addFlashAttribute("mensagem", "Houve um erro ao incluir o cliente: " + be.getMessage());
			return "redirect:/cliente/cadastrar";
		} catch (Exception e) {
			atributos.addFlashAttribute("mensagem", "Houve um erro ao incluir o cliente");
			return "redirect:/cliente/cadastrar";
		}
		
		return "";
	}
	
}
