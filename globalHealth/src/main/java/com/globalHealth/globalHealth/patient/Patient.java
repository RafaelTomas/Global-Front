package com.globalHealth.globalHealth.patient;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "patient")
@Data
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(nullable = false, length = 150)
  private String name;
  @Column(nullable = false, unique = true, length = 9)
  private String healthInsuranceCardId;
  @Column(nullable = false, length = 100)
  private String address;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate createdAt;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate updatedAt;
}
