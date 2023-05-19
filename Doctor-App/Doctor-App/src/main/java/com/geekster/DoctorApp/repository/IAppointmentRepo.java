package com.geekster.DoctorApp.repository;

import com.geekster.DoctorApp.model.Appointment;
import com.geekster.DoctorApp.model.AppointmentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment, AppointmentKey>{
    public String findByIdAppId(Long id);
}
