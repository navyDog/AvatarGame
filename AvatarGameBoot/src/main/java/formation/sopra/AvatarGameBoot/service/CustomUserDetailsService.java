package formation.sopra.AvatarGameBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import formation.sopra.AvatarGameBoot.repositories.UtilisateurRepository;

public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return utilisateurRepository
				.findByLogin(username)
					.orElseThrow(()->{throw new UsernameNotFoundException("utilisateur inconnu");});
		}
}
