package com.mini.project.controller.api;

import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mini.project.model.AthleteStyleModel;
import com.mini.project.model.AthletesModel;
import com.mini.project.model.DataModel;
import com.mini.project.model.DivisiModel;
import com.mini.project.model.FightingStyleModel;
import com.mini.project.service.IAthletesService;

@RestController
@RequestMapping("/api")
public class AthletesController {

	@Autowired
	IAthletesService athletesservice;
	
	
	@PostMapping("/insert/athlete")
	public String beranda(@RequestBody AthletesModel model) {
		athletesservice.insert(model);
		return "success";
	}
	
	@PostMapping("/insert/style")	
	public String beranda(@RequestBody FightingStyleModel model) {
		athletesservice.insertstyle(model);
		return "success";
	}
	
	@PostMapping("/insert/divisi")	
	public String beranda(@RequestBody DivisiModel model) {
		athletesservice.insertdivisi(model);
		return "success";
	}
	
	@PostMapping("/insert/astyle")	
	public String beranda(@RequestBody AthleteStyleModel model) {
		athletesservice.insertathletestyle(model);
		return "success";
	}
	
	@GetMapping("/read/athlete")
	public List<AthletesModel> getDataathletes(){
		return athletesservice.readDataathletes();
	}
	
	@GetMapping("/read/style")
	public List<FightingStyleModel> getDatastyle(){
		return athletesservice.readDatastyle();
	}
	
	@GetMapping("/read/divisi")
	public List<DivisiModel> getDataDivisi(){
		return athletesservice.readDatadivisi();
	}
	
	@GetMapping("/read/astyle")
	public List<AthleteStyleModel> getAstyle(){
		return athletesservice.readAstyle();
	}
	
	@GetMapping("/readall")
	public List<AthletesModel> readAllData() {
		return athletesservice.readAllData();
	}
	
	@GetMapping("/readbystyle")
	public List<DataModel> readDataByStyle(@RequestParam String style) {
		return athletesservice.readDataByStyle(style);
	}
	
	@GetMapping("/delete/athlete")
	public String deleteAthlete(@RequestParam int id) {
		return "delete success "+ athletesservice.deleteAthlete(id);
	}
	
	@GetMapping("/delete/divisi")
	public String deleteDivisi(@RequestParam int id) {
		return "delete success "+ athletesservice.deleteDivisi(id);
	}
	
	@GetMapping("/delete/style")
	public String deleteStyle(@RequestParam int id) {
		return "delete success "+ athletesservice.deleteStyle(id);
	}
	
	@GetMapping("/delete/astyle")
	public String deleteAstyle(@RequestParam int id) {
		return "delete success "+ athletesservice.deleteAstyle(id);
	}
	
	@PutMapping("/update/athlete")
	public String putData(@RequestParam int id, AthletesModel model) {
		return "update success "+ athletesservice.updateAthlete(id,model);
	}
	
	@PutMapping("/update/style")
	public String putData(@RequestParam int id, FightingStyleModel model) {
		return "update success "+ athletesservice.updateStyle(id,model);
	}
	
	@PutMapping("/update/divisi")
	public String putData(@RequestParam int id, DivisiModel model) {
		return "update success "+ athletesservice.updateDivisi(id,model);
	}
	
	@PutMapping("/update/astyle")
	public String putData(@RequestParam int id, AthleteStyleModel model) {
		return "update success "+ athletesservice.updateAthleteStyle(id,model);
	}
}
