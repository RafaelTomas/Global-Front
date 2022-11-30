package com.globalHealth.globalHealth.patient.Dto;

import javax.validation.constraints.*;

public class PatientRequestDTO{

  @NotBlank
  private String name;
  @NotBlank
  @Size(max = 9)
  private String healthInsuranceCardId;
  @NotBlank
  private String address;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getHealthInsuranceCardId() {
    return healthInsuranceCardId;
  }
  public void setHealthInsuranceCardId(String healthInsuranceCardId) {
    this.healthInsuranceCardId = healthInsuranceCardId;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }


}