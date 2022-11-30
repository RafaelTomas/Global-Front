package com.globalHealth.globalHealth.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.globalHealth.globalHealth.patient.Dto.PatientRequestDTO;
import com.globalHealth.globalHealth.patient.Dto.PatientResponseDTO;

import java.util.List;


@RestController
@RequestMapping(value = "/patient", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {
  @Autowired
  private PatientService service;

  @PostMapping
  @ResponseBody
  public PatientRequestDTO criar(@RequestBody PatientRequestDTO patientDTO) {
    return service.create(patientDTO);
  }

  @PutMapping("/{id}")
  @ResponseBody
  public PatientResponseDTO atualizar(@PathVariable("id") Integer id,
      @RequestBody PatientResponseDTO patientDTO) {
    return service.update(patientDTO, id);
  }

  @GetMapping
  @ResponseBody
  public List<PatientResponseDTO> getAll() {
    return service.getAll();
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  public String deletar(@PathVariable("id") Integer id) {
    return service.delete(id);
  }
}