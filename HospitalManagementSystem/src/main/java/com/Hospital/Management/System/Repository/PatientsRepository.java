package com.Hospital.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hospital.Management.System.Entity.Patient;
@Repository
public interface PatientsRepository extends JpaRepository<Patient,Long>
{

}
