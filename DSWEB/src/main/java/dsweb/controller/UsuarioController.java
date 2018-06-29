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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dsweb.model.Usuario;
import dsweb.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository userRepo;
	
	@GetMapping("/usuarios")
	public String listaUsuarios (Model model) {
		Iterable<Usuario> lista = userRepo.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "nome")));
		
		model.addAttribute("usuarios", lista);
		return "lista_usuario";				
	}
	
	@GetMapping("/usuarios/add")
	public String insereForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "insere_usuario";
	}
	
	@PostMapping("/usuarios")
	public String addUsarios(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("usuario", usuario);
			return "insere_usuario";
		}
		
		if (usuario.getLogin() != null) {
			Usuario u = userRepo.findOne(usuario.getLogin());
			if(u != null) {
				redirectAttributes.addFlashAttribute("msg", "Login já está cadastrado.");
				return "redirect:/usuarios/add";
			}
			else {
				userRepo.save(usuario);
				redirectAttributes.addFlashAttribute("msg", "Usuário adicionado com sucesso.");
			}
		}
		return "redirect:/login";
	}
	
	@GetMapping("/usuarios/{login}/delete")
	public String deleteUsuario(@PathVariable String login, RedirectAttributes redirectAttributes) {
		Usuario usuario = new Usuario(login);
		userRepo.delete(usuario);
		redirectAttributes.addFlashAttribute("msg", "Usuário removido com sucesso.");
		return "redirect:/usuarios";
	}
	
}
