package dsweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dsweb.model.Carrinho;
import dsweb.model.Produto;
import dsweb.model.Usuario;
import dsweb.repository.ProdutoRepository;
import dsweb.repository.UsuarioRepository;

@Controller
public class CarrinhoController {
	
	@Autowired
	ProdutoRepository produtoRepo;
	
	@Autowired
	UsuarioRepository userRepo;
	
	
	@GetMapping("/carrinho")
	public String listaCarrinho() {
		return "carrinho/lista_carrinho";
	}
	
	@RequestMapping("carrinho/{id}/comprar")
	public String comprarProduto(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse responde, HttpSession session, 
			RedirectAttributes redirectAttributes) {
		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
		if(carrinho == null) {
			carrinho = new Carrinho();
		}
		Produto p = produtoRepo.findOne(id);
		carrinho.getProdutos().add(p);
		session.setAttribute("carrinho", carrinho);
		redirectAttributes.addFlashAttribute("msg", "Produto adicionado ao carrinho.");
		return "redirect:/produtos";
	}
	
	@GetMapping("/carrinho/{id}/deletar")
	public String deletarProduto(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse responde, HttpSession session, 
			RedirectAttributes redirectAttributes) {
		
		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
		
		Produto p = produtoRepo.findOne(id);
		System.out.println(p.getId());
		
		for(Produto e : carrinho.getProdutos()) {
			if(e.getId() == p.getId()) {
				carrinho.getProdutos().remove(e);
				break;
			}
		}
		
		redirectAttributes.addFlashAttribute("msg", "Produto removido do carrinho.");
		session.setAttribute("carrinho", carrinho);

		return "redirect:/carrinho";
	}
	
	@GetMapping("carrinho/finalizar_compra")
	public String finalizarCompra(HttpServletRequest request, HttpServletResponse responde, HttpSession session, 
			RedirectAttributes redirectAttributes) {
		
		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
		String login = (String) session.getAttribute("login");
		
		if(carrinho != null) {
			Usuario usuario = userRepo.findOne(login);
			for(Produto p : carrinho.getProdutos()) {
				usuario.getHistoricoProdutos().add(p);
				p.getCompradores().add(usuario);
				produtoRepo.save(p);
			}
			userRepo.save(usuario);
			carrinho = null;
			session.setAttribute("carrinho", carrinho);
		}
		return "redirect:/produtos";
		
	}
}
