package com.Hospital.Management.System.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.Entity.Patient;
import com.Hospital.Management.System.Repository.PatientsRepository;
import com.Hospital.Management.System.doclogin.entity.Appointment;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v0")
public class PatientsController {
	private PatientsRepository patientsRepositry;

	public PatientsController(PatientsRepository patientsRepositry) {
		super();
		this.patientsRepositry = patientsRepositry;
	}

	@PostMapping("/patients")
	public Patient CreatePatient(@RequestBody Patient patient) {
		return patientsRepositry.save(patient);
	}
	@GetMapping("/patients")
	public List<Patient>getAllPatient(){
		return patientsRepositry.findAll();
	}

	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException {
	    Patient patient = patientsRepositry.findById(id).orElseThrow(() -> new AttributeNotFoundException("Patient not found for this id  " + id));

	    patientsRepositry.delete(patient);
	    Map<String, Boolean> response = new HashMap<String,Boolean>();
	    response.put("deleted", Boolean.TRUE);
	    return ResponseEntity.ok(response);
	}
	
	
}
