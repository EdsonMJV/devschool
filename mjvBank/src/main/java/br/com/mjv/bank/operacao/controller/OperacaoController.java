package br.com.mjv.bank.operacao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.mjv.bank.cliente.service.ClienteService;
import br.com.mjv.bank.operacao.model.Operacao;
import br.com.mjv.bank.operacao.service.OperacaoService;

@Controller
@RequestMapping("cliente/{id}/operacao")
public class OperacaoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OperacaoController.class);
	
	@Autowired
	private OperacaoService service;
	
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping("/transferencia")
	public ModelAndView iniciarTransferencia(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("/operacao/transferencia");
		mv.addObject("cliente", clienteService.buscarPorId(id));
		return mv;
	}
	

	/** Metodo que realiza a trasferencia de valores entre contas.
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/transferencia", method = RequestMethod.POST)
	public ModelAndView realizarTransferencia(@PathVariable Integer id, Operacao operacao) {
		ModelAndView mv = new ModelAndView("/operacao/transferenciaconfirmada");
		mv.addObject("id", id);
		mv.addObject("operacao", operacao);
		
		try {
			service.realizarTransferencia(id, operacao);
		} catch (Exception e) {
			LOGGER.error("Erro ao gravar transferencia: " + e.getMessage(), e);
			mv.addObject("mensagem", "Houve um erro ao gravar a operação.");
			mv.setViewName("/operacao/transferencia");
		}

		return mv;
	}
}
