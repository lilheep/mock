package com.prmo.mock.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "medical_check")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicalCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "driver_id", nullable = false)
    private Long driverId;

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "driver_start_time", nullable = false)
    private LocalDateTime driverStartTime;

    @Column(name = "driver_end_time")
    private LocalDateTime driverEndTime;

    @Column(name = "doctor_start_time")
    private LocalDateTime doctorStartTime;

    @Column(name = "doctor_end_time")
    private LocalDateTime doctorEndTime;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MedicalCheckStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();


}
