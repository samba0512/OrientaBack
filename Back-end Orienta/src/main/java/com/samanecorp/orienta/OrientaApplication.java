package com.samanecorp.orienta;

import com.samanecorp.orienta.entities.Niveau;
import com.samanecorp.orienta.entities.TypeFormations;
import com.samanecorp.orienta.entities.TypePiece;
import com.samanecorp.orienta.entities.User;
import com.samanecorp.orienta.repos.*;
import com.samanecorp.orienta.security.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class OrientaApplication implements CommandLineRunner {

	@Autowired
	private AccountService accountService;
	@Autowired
	private TypePieceRepository typePieceRepository;
	@Autowired
	private NiveauRepository niveauReposi
	 tory;
	@Autowired
	private TypeFormationsRepository typeFormationsRepository;
//	@Autowired
//	private PaysRepository paysRepository;


	public static void main(String[] args) {
		SpringApplication.run(OrientaApplication.class, args);

	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {


//		accountService.saveUser(new User("karaba15@gmail.com", "Karaba128", "@Karaba158","12/01/2020",1));
//		accountService.addRoleToUser("Karaba128","ETUDIANT");
//		accountService.saveUser(new User("ngorseck15@gmail.com", "Ngor128", "@Ngor12","12/01/2020",1));
//		accountService.addRoleToUser("Ngor128","ADMIN");
//		accountService.saveUser(new User("ngorseckS15@gmail.com", "Ngor18", "@Ngor128","12/01/2020",1));
//		accountService.addRoleToUser("Ngor18","ADMIN");
//		accountService.saveUser(new User("Grenoble15@gmail.com", "Grenoble78", "@Grenoble265","24/01/2020",1));
//		accountService.addRoleToUser("Grenoble78","UNIVERSITE");
//		accountService.saveUser(new User("Bordeaux56@gmail.com", "Bordeaux78", "@Bordeaux265","24/01/2020",1));
//		accountService.addRoleToUser("Bordeaux78","UNIVERSITE");
//		accountService.saveUser(new User("AixMarseille15@gmail.com", "AixMarseille22", "@Marseille255","24/01/2020",1));
//		accountService.addRoleToUser("AixMarseille22","UNIVERSITE");
//		accountService.saveUser(new User("malick266@gmail.com", "Malick128", "@Malick987","28/01/2020",1));
//		accountService.addRoleToUser("Malick128","ETUDIANT");
//		accountService.saveUser(new User("ndeye58@gmail.com", "Ndeye18", "@Ndeye596","28/01/2020",1));
//		accountService.addRoleToUser("Ndeye18","ETUDIANT");
//		accountService.saveUser(new User("penda54@gmail.com", "Penda12", "@Penda98","28/01/2020",1));
//		accountService.addRoleToUser("Penda12","ETUDIANT");
//		accountService.saveUser(new User("amina85@gmail.com", "Amina987", "@Amina963","28/01/2020",1));
//		accountService.addRoleToUser("Amina987","ETUDIANT");
//		accountService.saveUser(new User("assane15@gmail.com", "Assane566", "@Assane947","28/01/2020",1));
//		accountService.addRoleToUser("Assane566","ETUDIANT");
//		accountService.saveUser(new User("alioune31@gmail.com", "Alioune66", "@Alioune64","28/01/2020",1));
//		accountService.addRoleToUser("Alioune66","ETUDIANT");
//		accountService.saveUser(new User("baba195@gmail.com", "Baba963", "@Baba9999","28/01/2020",1));
//		accountService.addRoleToUser("Baba963","ETUDIANT");
//		accountService.saveUser(new User("diarys195@gmail.com", "Diary973", "@Diary999","01/02/2020",1));
//		accountService.addRoleToUser("Diary973","ETUDIANT");
//		accountService.saveUser(new User("strasbourg195@gmail.com", "Strasbourg973", "@Strasbourg999","10/02/2020",1));
//		accountService.addRoleToUser("Strasbourg973","UNIVERSITE");
//		accountService.saveUser(new User("lorraine195@gmail.com", "Lorraine973", "@Lorraine999","10/02/2020",1));
//		accountService.addRoleToUser("Lorraine973","UNIVERSITE");
//		accountService.saveUser(new User("sorbonne195@gmail.com", "Sorbonne973", "@Sorbonne999","10/02/2020",1));
//		accountService.addRoleToUser("Sorbonne973","UNIVERSITE");
//		accountService.saveUser(new User("ecolensup195@gmail.com", "Ensup973", "@Ensup999","10/02/2020",1));
//		accountService.addRoleToUser("Ensup973","UNIVERSITE");
//		accountService.saveUser(new User("americanup195@gmail.com", "Americanup973", "@Americanup999","10/02/2020",1));
//		accountService.addRoleToUser("Americanup973","UNIVERSITE");
//		accountService.saveUser(new User("psl195@gmail.com", "Psl973", "@Pslparis999","10/02/2020",1));
//		accountService.addRoleToUser("Psl973","UNIVERSITE");
//		accountService.saveUser(new User("greno195@gmail.com", "Greno973", "@Grenob999","10/02/2020",1));
//		accountService.addRoleToUser("Greno973","UNIVERSITE");
//		accountService.saveUser(new User("sofama15@gmail.com", "FamaS168", "@Poulo1997","03/03/2020",1));
//		accountService.addRoleToUser("FamaS168","ADMIN");
//		accountService.saveUser(new User("diama@gmail.com", "Diama1997", "@Diama1970","07/05/2020",1));
//		accountService.addRoleToUser("Diama1997","SUPER_ADMIN");

//		typePieceRepository.save(new TypePiece("carte d'identite"));
//		typePieceRepository.save(new TypePiece("passeport"));
		//typePieceRepository.save(new TypePiece("Permis de conduire"));

//		niveauRepository.save(new Niveau("Licence 1"));
//		niveauRepository.save(new Niveau("Licence 2"));
//		niveauRepository.save(new Niveau("Licence 3"));
//		niveauRepository.save(new Niveau("Master 1"));
//		niveauRepository.save(new Niveau("Master 2"));
//		niveauRepository.save(new Niveau("Doctorat"));

//		typeFormationsRepository.save(new TypeFormations("Plein temps"));
//		typeFormationsRepository.save(new TypeFormations("Alternance"));

	}
}
