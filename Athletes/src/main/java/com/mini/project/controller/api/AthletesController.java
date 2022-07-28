package com.mini.project.controller.api;

import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mini.project.model.AthletesModel;
import com.mini.project.service.IAthletesService;

@RestController
@RequestMapping("/api")
public class AthletesController {

	@Autowired
	IAthletesService athletesservice;
	
	@PostMapping("/insert")
	public String beranda(@RequestBody AthletesModel model) {
		athletesservice.insert(model);
		return "success";
	}
	
	@GetMapping("/readall")
	public List<AthletesModel> getAllData(){
		return athletesservice.readAllData();
	}
	
	@GetMapping("/deletebyid")
	public String deleteById(@RequestParam int id) {
		return "delete success "+ athletesservice.deleteById(id);
	}
	
	@PutMapping("/update")
	public String putData(@RequestParam int id, AthletesModel model) {
		return "update success "+ athletesservice.gantidata(id,model);
	}
}
