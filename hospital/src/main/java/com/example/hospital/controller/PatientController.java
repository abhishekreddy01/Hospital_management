package com.example.hospital.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.dao.IDocRepo;
import com.example.hospital.model.DoctorModel;
import com.example.hospital.model.PatientModel;
import com.example.hospital.service.PatientService;

import io.micrometer.common.lang.Nullable;


@RestController
@RequestMapping("Patient")
public class PatientController {
    
    @Autowired
    IDocRepo docRepo;
    @Autowired
    PatientService service;
    
    @PostMapping("Add/patient/Details")
    public String addPatient(@RequestBody String patient){
        JSONObject obj = new JSONObject(patient);
        PatientModel patientDetails = setpatient(obj);
        service.savePat1(patientDetails);
        return "Patient Details saved with name =" + patientDetails.getPatName();
    }

    private PatientModel setpatient(JSONObject obj) {
        PatientModel pat1 = new PatientModel();
        pat1.setPatId(obj.getInt("patId"));
        pat1.setPatName(obj.getString("patName"));
        pat1.setPatAddress(obj.getString("patAddress"));
        pat1.setPatConcern(obj.getString("patConcerns"));
        pat1.setPatNum(obj.getString("patNum"));
        String docId = obj.getString("docId");
        DoctorModel doc = docRepo.findById(Integer.valueOf(docId)).get();
        pat1.setDoctor(doc);
        return pat1;
    }

    @GetMapping("/Get/Patient")
    public List<PatientModel> getPatient(@Nullable PatientModel patient){

        return service.getAllPatient(patient);
    }

    @GetMapping("/GetPatient/patId/{patId}")
    public PatientModel getPatientById(@PathVariable Integer patId){
        return service.getPatientById(patId);
    }

    @PutMapping("/updatePatient/patId/{patId}")
    public String updateById(@PathVariable String patId, @RequestBody String newPatient){
        JSONObject obj = new JSONObject(newPatient);
        PatientModel patientupdate = setpatient(obj);
        service.updatePat1(patientupdate,patId);
        return " updated details with patient name :-"+patientupdate.getPatName();
    }

    @DeleteMapping("DeletePatient")
    public void deletePatient(@PathVariable Integer patId){
        service.deleteById(patId);
    }

}
