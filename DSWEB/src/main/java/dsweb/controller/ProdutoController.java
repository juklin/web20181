package dsweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dsweb.model.Produto;
import dsweb.repository.ProdutoRepository;

@Controller 
public class ProdutoController {	
	
	@Autowired
	private ProdutoRepository produtosRepo;
	
	@GetMapping("/produtos")
	public String listaProdutos (Model model) {
		Iterable<Produto> lista = produtosRepo.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "nome")));
		
		model.addAttribute("produtos", lista);
		return "lista_produto";
	}
	
	@GetMapping("/produtos/add")
	public String insereForm(Model model) {
		model.addAttribute("produto", new Produto());
		return "insere_produto";
	}
	
	@RequestMapping("/produtos/{id}/update")
	public String updateForm(@PathVariable Integer id, Model model) {
		Produto p = produtosRepo.findOne(id);
		model.addAttribute("produto", p);
		return "altera_produto";
	}
	
	@PostMapping("/produtos")
	public String addProduto(@Valid Produto produto, BindingResult result, 
			Model model, RedirectAttributes redirectAttributes) {
		
		
		System.out.println(produto.getImagem());
		
		if (result.hasErrors()) {
			System.out.println("hehe");
			model.addAttribute("produto", produto);
			if (produto.getId() == null) {
				return "insere_produto";
			}
			else {
				return "altera_produto";
			}
		}
		
		if (produto.getId() == null) {
			produtosRepo.save(produto);
			redirectAttributes.addFlashAttribute("msg", "Produto inserido com sucesso");
		}
		
		else {
			produtosRepo.save(produto);
			redirectAttributes.addFlashAttribute("msg", "Produto alterado com sucesso");
		}
		return "redirect:/produtos";
	}
	
	@GetMapping("/produtos/{id}/delete")
	public String deleteProduto(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		Produto produto = new Produto(id);
		produtosRepo.delete(produto);
		redirectAttributes.addFlashAttribute("msg", "Produto removido com sucesso.");
		return "redirect:/produtos";
	}
}

