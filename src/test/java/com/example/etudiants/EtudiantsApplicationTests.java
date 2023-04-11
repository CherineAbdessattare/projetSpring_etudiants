package com.example.etudiants;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

import com.example.etudiants.repos.EtudiantRepository;
import com.example.etudiants.service.EtudiantService;
import com.example.etudiants.entities.Etudiant;
@SpringBootTest
class EtudiantsApplicationTests {

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private EtudiantService etudiantService;
	
	@Test
	public void testCreateEtudiant() {
		Etudiant etud = new Etudiant("Cherine","Abdessattare",new Date(),"DSI22","shirine073@gmail.com");
		etudiantRepository.save(etud);
	}
	
	@Test
	public void testUpdaateEtudiant() {
		Etudiant e = etudiantRepository.findById(1L).get();
		System.out.println(e);
	}
	
	@Test
	public void testUpdateEtudiant()
	{
	Etudiant e = etudiantRepository.findById(1L).get();
	e.setNom("Abdessattare");
	e.setPrenom("Cherine");
	etudiantRepository.save(e);
	}
	
	@Test
	public void testdeleteEtudiant() {
		etudiantRepository.deleteById(1L);
	}
	
	@Test
	public void testListerTousEtudiants() {
		List<Etudiant> etuds = etudiantRepository.findAll();
		for (Etudiant e : etuds)
		{
		System.out.println(e);
		}

	}
	
	@Test
	public void testFindByNomEtudiantContains()
	{
	Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(0,2);
	System.out.println(etuds.getSize());
	System.out.println(etuds.getTotalElements());
	System.out.println(etuds.getTotalPages());
	etuds.getContent().forEach(e -> {System.out.println(e.toString());
	 });
	/*ou bien
	for (Etudiant e : etuds)
	{
	System.out.println(e);
	} */
	}



}
