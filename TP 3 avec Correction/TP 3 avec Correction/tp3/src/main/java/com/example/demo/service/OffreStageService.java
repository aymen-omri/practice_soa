package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.OffreStage;
import com.example.demo.repository.OffreStageRepository;

@Service
public class OffreStageService {
	
	private OffreStageRepository stageRep;

	@Autowired
	public OffreStageService(OffreStageRepository stageRep) {
		super();
		this.stageRep = stageRep;
	}
	
	public List<OffreStage> getAll(){
		
		List<OffreStage> listOffres;
		listOffres = stageRep.findAll();
		return listOffres;
	}
	
	public OffreStage getOffreStageById(Long id){
		OffreStage offre;
		offre = stageRep.findById(id).get();
		return offre;
	}
	
	public void deleteOffreStageById(Long id){
		stageRep.deleteById(id);
	}
	
	public OffreStage addOffreStage(OffreStage offre){
		offre = stageRep.save(offre);
		return offre;
	}
	
	public List<OffreStage> getOffreStageByIntitule(String intitule){
		List<OffreStage> listOffres;
		listOffres = stageRep.findByIntitule(intitule);
		return listOffres;
	}
	
	public List<OffreStage> getOffreStageBySocieteId(@PathVariable Long id){
		List<OffreStage> listOffres;
		listOffres = stageRep.findBySocieteId(id);
		return listOffres;
	}
	
	public void deleteOffreStageBySpecialite(String specialite){
		stageRep.deleteBySocieteSpecialite(specialite);
	}

}
