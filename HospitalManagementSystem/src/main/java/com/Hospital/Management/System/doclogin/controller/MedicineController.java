package com.Hospital.Management.System.doclogin.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.Entity.Patient;
import com.Hospital.Management.System.doclogin.entity.Medicine;
import com.Hospital.Management.System.doclogin.repository.MedicinesRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class MedicineController {
	private MedicinesRepository medicinesRepository;

	public MedicineController(MedicinesRepository medicinesRepository) {
		super();
		this.medicinesRepository = medicinesRepository;
	}

	public MedicinesRepository getMedicinesRepository() {
		return medicinesRepository;
	}

	public void setMedicinesRepository(MedicinesRepository medicinesRepository) {
		this.medicinesRepository = medicinesRepository;
	}
	@PostMapping("/medicines")
	public Medicine createMedicines(@RequestBody Medicine medicine) {
		return medicinesRepository.save(medicine);
	}
	@GetMapping("/medicines")
	public List<Medicine>getAllPatient(){
		return medicinesRepository.findAll();
	}

	
	@GetMapping("/medicines/{id}")
	public ResponseEntity<Medicine> getPatientById(@PathVariable Long id) throws AttributeNotFoundException {
		
		Medicine medicine = medicinesRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("ABCD" + id));
		
		return ResponseEntity.ok(medicine);
	}

	
	@PutMapping("/medicines/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicineDetails) throws AttributeNotFoundException{
		
		Medicine medicine = medicinesRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("ABCD" + id));
		
		medicine.setDrugName(medicineDetails.getDrugName());
		medicine.setStock(medicineDetails.getStock());
	
		
		Medicine updatedMedicine = medicinesRepository.save(medicine);
		return ResponseEntity.ok(updatedMedicine);
	}
	
	
	
	
	@DeleteMapping("/medicines/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteMedicine(@PathVariable Long id) throws AttributeNotFoundException{
		
		Medicine medicine = medicinesRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("ABCD" + id));
		
		medicinesRepository.delete(medicine);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	
	
	
	
	
	
}
