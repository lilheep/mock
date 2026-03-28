package com.prmo.mock.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medical_check_data")
@Getter
@Setter
public class MedicalCheckData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "medical_check_id", nullable = false, unique = true)
    private MedicalCheck medicalCheck;

    @Column(name = "pulse", nullable = false)
    private Integer pulse;

    @Column(name = "systolic_pressure", nullable = false)
    private Integer systolicPressure;

    @Column(name = "diastolic_pressure", nullable = false)
    private Integer diastolicPressure;

    @Column(name = "temperature", nullable = false)
    private Double temperature;

    @Column(name = "alcoholTestResult", nullable = false)
    private Double alcoholTestResult;

    @Column(name = "complaints", columnDefinition = "TEXT")
    private String complaints;

    @Column(name = "admitted_to_drive", nullable = false)
    private Boolean admittedToDrive;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
