package com.Hospital.Management.System.doclogin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.Entity.Patient;
import com.Hospital.Management.System.doclogin.entity.Medicine;
import com.Hospital.Management.System.doclogin.repository.MedicinesRepository;
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
	@PostMapping("/insert")
	public Medicine createMedicines(@RequestBody Medicine medicine) {
		return medicinesRepository.save(medicine);
	}
	@GetMapping
	public List<Medicine>getAllPatient(){
		return medicinesRepository.findAll();
	}

	
}
