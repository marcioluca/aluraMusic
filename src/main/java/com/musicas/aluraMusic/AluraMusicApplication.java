package com.musicas.aluraMusic;

import com.musicas.aluraMusic.principal.Main;
import com.musicas.aluraMusic.repository.ArtistaRepository;
import com.musicas.aluraMusic.service.ConsultaGermini;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraMusicApplication implements CommandLineRunner {
	@Autowired
	private ArtistaRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(AluraMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main principal = new Main(repository);
		principal.Menu();
	}
}
