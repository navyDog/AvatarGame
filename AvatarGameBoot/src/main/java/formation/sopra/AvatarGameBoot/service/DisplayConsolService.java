package formation.sopra.AvatarGameBoot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DisplayConsolService implements CommandLineRunner{

	private static final Logger LOGGER=LoggerFactory.getLogger(DisplayConsolService.class); //init des loggers
	
	//affichage console avec spring boot
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		LOGGER.trace("trace");
//		LOGGER.debug("debug");
//		LOGGER.info("info");
//		LOGGER.warn("warning");
//		LOGGER.error("error");
		System.out.println("hello world");
	}
}
