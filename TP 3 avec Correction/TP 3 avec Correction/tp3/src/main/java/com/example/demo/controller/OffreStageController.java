package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OffreStage;
import com.example.demo.service.OffreStageService;

@RestController
@RequestMapping(path="RestApi/stages")
public class OffreStageController {
	
	private OffreStageService stageService;

	@Autowired
	public OffreStageController(OffreStageService stageService) {
		super();
		this.stageService = stageService;
	}
	
	@GetMapping
	public List<OffreStage> getAll(){
		
		List<OffreStage> listOffres;
		listOffres = stageService.getAll();
		return listOffres;
	}
	
	@GetMapping(value="{id}")
	public OffreStage getOffreStageById(@PathVariable Long id){
		OffreStage offre;
		offre = stageService.getOffreStageById(id);
		return offre;
	}
	
	@DeleteMapping(value="{id}")
	public void deleteOffreStageById(@PathVariable Long id){
		stageService.deleteOffreStageById(id);
	}
	
	@PostMapping
	public OffreStage addOffreStage(@RequestBody OffreStage offre){
		offre = stageService.addOffreStage(offre);
		return offre;
	}
	
	@PutMapping(value="{id}")
	public void UpdateOffreStage(@RequestBody OffreStage offre, @PathVariable Long id){
		OffreStage isOffre;
		isOffre = stageService.getOffreStageById(id);
		if(isOffre!=null)
		{
			isOffre.setIntitule(offre.getIntitule());
			isOffre.setSociete(offre.getSociete());
			isOffre.setSpecialite(offre.getSpecialite());
			stageService.addOffreStage(isOffre);
		}
	}
	
	@GetMapping(value="/intitule/{intitule}")
	public List<OffreStage> getOffreStageByIntitule(@PathVariable String intitule){
		List<OffreStage> listOffres;
		listOffres = stageService.getOffreStageByIntitule(intitule);
		return listOffres;
	}
	
	@GetMapping(value="/societe/{id}")
	public List<OffreStage> getOffreStageBySocieteId(@PathVariable Long id){
		List<OffreStage> listOffres;
		listOffres = stageService.getOffreStageBySocieteId(id);
		return listOffres;
	}
	
	@DeleteMapping(value="/specialite/{specialite}")
	public void deleteOffreStageBySpecialite(@PathVariable String specialite){
		stageService.deleteOffreStageBySpecialite(specialite);
	}

}
