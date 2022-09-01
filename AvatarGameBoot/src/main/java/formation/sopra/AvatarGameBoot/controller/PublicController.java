package formation.sopra.AvatarGameBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import formation.sopra.AvatarGameBoot.entities.user.Utilisateur;
import formation.sopra.AvatarGameBoot.repositories.UtilisateurRepository;

@Controller
public class PublicController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@GetMapping({"/","/home"})
	public String home() {	
		return "public/home";
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "public/login";
	}
	
	@GetMapping("/inscription")
	public String inscription(Model model) {
		return goInscription(new Utilisateur(), model);
	}
	
	private String goInscription(Utilisateur utilisateur, Model model) {
		model.addAttribute("compte", utilisateur);
		return "public/inscription";
	}
	
	@PostMapping("/inscription")
	public String saveCompte(@Valid @ModelAttribute Utilisateur utilisateur, BindingResult br, Model model) {
		if(br.hasErrors()) {return goInscription(utilisateur, model);}
		utilisateur.setLogin(utilisateur.getLogin().toLowerCase());
		utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		utilisateurRepository.save(utilisateur);
		return "redirect:/login";
	}
}
