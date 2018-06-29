package dsweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dsweb.model.Usuario;
import dsweb.repository.UsuarioRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@GetMapping("/cadastro_usuario")
	public String insereUser(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/insere_usuario";
	}
	
		
	@RequestMapping("/efetuar_login")
	public String buscarUsuarioLogin(Model model, Usuario usuario, HttpServletRequest request, HttpServletResponse responde, HttpSession session, 
			RedirectAttributes redirectAttributes) {
		Usuario u = usuarioRepo.findOne(usuario.getLogin());
		if (u != null) {
			if (u.getSenha().equals(usuario.getSenha())) {
				session.setAttribute("login", usuario.getLogin());
				session.setAttribute("usuario_logado", usuario);
				redirectAttributes.addFlashAttribute("msg", "Login feito com sucesso.");
				return "redirect:/produtos";
			}
		}
		redirectAttributes.addFlashAttribute("msg", "Login ou senha incorreta.");
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String efetuarLogin(Model model) {
		return "login/login";
	}
	
	@GetMapping("/logout")
	public String efetuarLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
