package com.globalHealth.globalHealth.patient;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.globalHealth.globalHealth.patient.Dto.PatientRequestDTO;
import com.globalHealth.globalHealth.patient.Dto.PatientResponseDTO;

@Service
public class PatientService {

  final PatientRepository repository;

  public PatientService(PatientRepository repository) {
    this.repository = repository;
  }

  public PatientRequestDTO create(PatientRequestDTO patientDTO) {
    Patient patient = new Patient();
    patient.setName(patientDTO.getName());
    patient.setHealthInsuranceCardId(patientDTO.getHealthInsuranceCardId());
    patient.setAddress(patientDTO.getAddress());
    patient.setCreatedAt(LocalDate.now());
    repository.save(patient);
    return patientDTO;
  }

  public PatientResponseDTO update(PatientResponseDTO patientDTO, Integer id) {
    Patient patientDatabase = repository.findById(id).get();
    patientDatabase.setName(patientDTO.getName());
    patientDatabase.setHealthInsuranceCardId(patientDTO.getHealthInsuranceCardId());
    patientDatabase.setAddress(patientDTO.getAddress());
    patientDatabase.setUpdatedAt(LocalDate.now());
    repository.save(patientDatabase);
    return patientDTO;
  }

  private PatientResponseDTO convertGet(Patient patient) {
    PatientResponseDTO result = new PatientResponseDTO();
    result.setId(patient.getId());
    result.setName(patient.getName());
    result.setHealthInsuranceCardId(patient.getHealthInsuranceCardId());
    result.setAddress(patient.getAddress());
    return result;
  }

  public List<PatientResponseDTO> getAll() {
    return repository
        .findAll()
        .stream()
        .map(this::convertGet).collect(Collectors.toList());
  }


  public String delete(Integer id) {
    repository.deleteById(id);
    return "DELETED";
  }


}