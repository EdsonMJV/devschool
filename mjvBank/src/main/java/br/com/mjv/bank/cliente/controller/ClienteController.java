package br.com.mjv.bank.cliente.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mjv.bank.cliente.model.Cliente;
import br.com.mjv.bank.cliente.service.ClienteService;
import br.com.mjv.bank.exception.BusinessException;
import br.com.mjv.bank.operacao.model.Operacao;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	private static final String MENSAGEM = "mensagem";
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView meusDados(@PathVariable Integer id) {
		
		ModelAndView mv = new ModelAndView("cliente/meusdados");
		Cliente cliente = service.buscarPorId(id);
		mv.addObject("cliente", cliente);
		
		return mv;
	}
	
	@RequestMapping(path = "/cadastrar", method = RequestMethod.GET)
	public String cadastrarCliente() {
		LOGGER.info("Inicio do metodo cadastrarCliente()");
		
		LOGGER.info("Fim do metodo cadastrarCliente()");
		return "cliente/cadastro";
	}
	
	
	@RequestMapping(path = "/cadastrar", method = RequestMethod.POST)
	public String incluirCliente(Cliente cliente, RedirectAttributes atributos) {
		LOGGER.info("Inicio do metodo incluirCliente()");
		
		List<String> mensagens = new ArrayList<>();
		
		if(StringUtils.isEmpty(cliente.getNome())) {
			mensagens.add("Nome não informado");
		}
		
		if(StringUtils.isEmpty(cliente.getUsuario())) {
			mensagens.add("Usuário não informado");
		}
		
		if(StringUtils.isEmpty(cliente.getCpf())) {
			mensagens.add("CPF não informado");
		}
		
		try {
			
			if(!mensagens.isEmpty()) {
				atributos.addFlashAttribute(MENSAGEM, mensagens);
				return "redirect:/cliente/cadastrar";
			}
			
			Integer id = service.incluirCliente(cliente);
			LOGGER.info("Fim do metodo incluirCliente()");
			return "redirect:/cliente/" + id;
			
		} catch (BusinessException be) {
			mensagens.add("Houve um erro ao incluir o cliente: " + be.getMessage());
			atributos.addFlashAttribute(MENSAGEM, mensagens);
			LOGGER.error("Houve um erro ao incluir o cliente: " + be.getMessage(), be);
			return "redirect:/cliente/cadastrar";
		} catch (Exception e) {
			mensagens.add("Houve um erro ao incluir o cliente");
			atributos.addFlashAttribute(MENSAGEM, mensagens);
			LOGGER.error("Houve um erro ao incluir o cliente: " + e.getMessage(), e);
			return "redirect:/cliente/cadastrar";
		}
		
		
	}
	
	/*
	 * Este metodo deveria ser GET (/agencia/{agencia}/conta/{conta}) e nao POST. Foi feito assim so para mostrar o ajax no jquery passando dados no corpo
	 */
	@RequestMapping(path = "/buscarcliente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
	@ResponseBody
	public ResponseEntity<Cliente> buscarcliente(@RequestBody Operacao operacao) {
		
		Cliente cliente = service.findClienteByAgenciaConta(operacao.getCliente().getAgencia(), 
				                                            operacao.getCliente().getConta());
		if(cliente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(cliente ,HttpStatus.OK);
	}
	
}
