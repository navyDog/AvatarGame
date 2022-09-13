package formation.sopra.AvatarGameBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class AvatarGameBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvatarGameBootApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void atStart() {
		System.out.println("Salut l'elite");
	}
}
