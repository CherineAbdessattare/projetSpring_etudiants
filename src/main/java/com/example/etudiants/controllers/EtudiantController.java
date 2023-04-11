package com.example.etudiants.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.etudiants.entities.Etudiant;
import com.example.etudiants.service.EtudiantService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class EtudiantController {
	
	@Autowired
	EtudiantService etudiantService;
	
	@RequestMapping("/showCreate")
	public String showcreate()
	{
		return "createEtudiant";
	}
	@RequestMapping("/saveEtudiant")
	public String saveEtudiant(@ModelAttribute("Etudiant") Etudiant etudiant,@RequestParam("date") String date, ModelMap modelMap) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateInscription = dateFormat.parse(String.valueOf(date));
		etudiant.setDateInscription(dateInscription);
		
		Etudiant saveEtudiant = etudiantService.saveEtudiant(etudiant);
		String msg ="Etudiant enregistré avec Id "+saveEtudiant.getIdEtudiant();
		modelMap.addAttribute("msg", msg);
		return "createEtudiant";
	}
	
	@RequestMapping("/ListeEtudiants")
	public String listeEtudiants(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(page, size);
		modelMap.addAttribute("etudiants", etuds);
		modelMap.addAttribute("pages", new int[etuds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeEtudiants";
		}
	
	@RequestMapping("/supprimerEtudiant")
	public String supprimerProduit(@RequestParam("id") Long id,
			ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{ 
		etudiantService.deleteEtudiantById(id);
		Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(page,size);
		modelMap.addAttribute("etudiants", etuds);
		modelMap.addAttribute("pages", new int[etuds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeEtudiants";
		}
	
	@RequestMapping("/modifierEtudiant")
	public String editerEtudiant(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Etudiant e= etudiantService.getEtudiant(id);
	modelMap.addAttribute("etudiant", e);
	return "editerEtudiant";
	}
	
	@RequestMapping("/updateEtudiant")
	public String updateEtudiant(@ModelAttribute("etudiant") Etudiant etudiant,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
	{
		//conversion de la date 
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateInscription = dateformat.parse(String.valueOf(date));
		 etudiant.setDateInscription(dateInscription);
		 
		 etudiantService.updateEtudiant(etudiant);
		 List<Etudiant> etuds = etudiantService.getAllEtudiants();
		 modelMap.addAttribute("etudiants", etuds);
		return "listeEtudiants";
		}


}
