package com.example.etudiants.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.etudiants.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository <Etudiant, Long> {
	

}
