package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.OffreStage;

@Repository
public interface OffreStageRepository extends JpaRepository<OffreStage, Long> {
	
	List<OffreStage> findByIntitule(String intitule);

	@Query("select o from OffreStage o where o.societe.idSociete = ?1")
	List<OffreStage> findBySocieteId(Long idSociete);
	
	@Query("select o from OffreStage o where o.societe.activite = ?1")
	List<OffreStage> findBySocieteActivite(String activite);
	
	@Query("select o from OffreStage o where o.societe.pays = ?1")
	List<OffreStage> findBySocietePays(String paysSociete);
	
	@Transactional
	@Modifying
	@Query("delete from OffreStage o where o.specialite = ?1")
	void deleteBySocieteSpecialite(String specialite);
}
