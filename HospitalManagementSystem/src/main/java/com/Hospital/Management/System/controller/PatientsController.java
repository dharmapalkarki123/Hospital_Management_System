package com.Hospital.Management.System.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.Entity.Patient;
import com.Hospital.Management.System.Repository.PatientsRepository;

@RestController
@RequestMapping("/api/v0")
public class PatientsController {
	private PatientsRepository patientsRepositry;

	public PatientsController(PatientsRepository patientsRepositry) {
		super();
		this.patientsRepositry = patientsRepositry;
	}

	@PostMapping("/insert")
	public Patient CreatePatient(@RequestBody Patient patient) {
		return patientsRepositry.save(patient);
	}
	@GetMapping
	public List<Patient>getAllPatient(){
		return patientsRepositry.findAll();
	}

}
