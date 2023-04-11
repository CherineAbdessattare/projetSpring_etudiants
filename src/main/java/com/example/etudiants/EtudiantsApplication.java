package com.example.etudiants;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.etudiants.entities.Etudiant;
import com.example.etudiants.service.EtudiantService;

@SpringBootApplication
public class EtudiantsApplication implements CommandLineRunner {
	
	@Autowired
	EtudiantService etudiantService;

	public static void main(String[] args) {
		SpringApplication.run(EtudiantsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//etudiantService.saveEtudiant(new Etudiant("Mohamed","Ali",new Date(),"SEM21","mohamedali@gmail.com"));
	//etudiantService.saveEtudiant(new Etudiant("Mohamed ","Azize",new Date(),"MDW21","mohamedazize@gmail.com"));
		
	}

}
