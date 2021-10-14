package com.cafeapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafeapp.models.Cafe;
import com.cafeapp.repository.CafeRepository;

@Controller
public class CafeController {
	
	@Autowired
	private CafeRepository cr;
	
	@RequestMapping(value="/cadastrarCafe", method=RequestMethod.GET)
	public String form() {
		return "cafe/formCadastrarCafe";
	}
	
	@RequestMapping(value="/cadastrarCafe", method=RequestMethod.POST)
	public String form(@Valid Cafe cafe, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "* Preencha todos os campos!");
			return "redirect:/cadastrarCafe";
		}
		
		cr.save(cafe);
		attributes.addFlashAttribute("mensagemSucesso", "Café da manhã cadastrado com sucesso!");
		return "redirect:/cadastrarCafe";
	}
	
	@RequestMapping("/cafedamanha")
	public ModelAndView listaCafe() {
		ModelAndView mv = new ModelAndView("cafe/formListarCafe");
		Iterable<Cafe> cafedamanha = cr.findAll();
		mv.addObject("cafedamanha",cafedamanha);
		return mv;
	}
	
	@RequestMapping("/deletar")
	public String deletarCafe(long id) {
		Cafe cafe = cr.findById(id);
		cr.delete(cafe);
		return "redirect:/cafedamanha";	
	}
	
}
