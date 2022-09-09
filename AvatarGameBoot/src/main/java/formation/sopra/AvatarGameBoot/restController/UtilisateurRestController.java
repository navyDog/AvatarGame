package formation.sopra.AvatarGameBoot.restController;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.AvatarGameBoot.entities.user.Role;
import formation.sopra.AvatarGameBoot.entities.user.Utilisateur;
import formation.sopra.AvatarGameBoot.entities.view.JsonViews;
import formation.sopra.AvatarGameBoot.repositories.UtilisateurRepository;

//de la merde


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class UtilisateurRestController {
	
	@Autowired
	private UtilisateurRepository utilisateurRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	private final static Logger LOGGER=LoggerFactory.getLogger(UtilisateurRestController.class);
	
	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public Utilisateur auth(@AuthenticationPrincipal Utilisateur utilisateur) {
		LOGGER.info(utilisateur.getLogin());
		return utilisateur;
	}
	
	@PostMapping("/inscription")
	@JsonView(JsonViews.Base.class)
	public Utilisateur inscription(@Valid @RequestBody Utilisateur utilisateur,BindingResult br) {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);	
		}
		if(utilisateurRepo.findByLogin(utilisateur.getLogin()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPass()));
		utilisateur.setRole(Role.ROLE_USER);
		return utilisateurRepo.save(utilisateur);
	}
	
	@GetMapping("/check/{login}")
	public boolean loginExist(@PathVariable String login) {
		return utilisateurRepo.findByLogin(login).isPresent();
	}
}
