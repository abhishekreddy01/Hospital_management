package com.example.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dao.IPatientRepo;
import com.example.hospital.model.PatientModel;

@Service
public class PatientService {
    @Autowired
    IPatientRepo patRepo;

    public void savePat1(PatientModel patientDetails) {
        patRepo.save(patientDetails);
    }

    public List<PatientModel> getAllPatient(PatientModel patient) {
        return patRepo.findAll();
    }

    public PatientModel getPatientById(Integer patId) {
        return patRepo.findById(patId).get();
    }

    public void updatePat1(PatientModel patientupdate, String patId) {
        if (patRepo.findById(Integer.valueOf(patId)).isPresent()) {
            patRepo.findById(Integer.valueOf(patId)).get();
            patRepo.save(patientupdate);
        }
    }

    public void deleteById(Integer patId) {
        patRepo.deleteById(patId);
    }
}
