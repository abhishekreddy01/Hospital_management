# Doctor Patient Project

## FrameWorks and Language used
- SpringBoot
- Java

## Controller
- DoctorController
- DoctorController

## Repository (Dao)
- DoctorRepo
- PatientRepo

## Model
- DoctorModel
- PatientModel

## Service
- DoctorService
- PatientService

## DataBase Used
- SQL DataBase

## Project Summary
- In this project we are saving the Patient details and assiging the Doctor Id to patient 
   and performing the CRUD operation.

### Doctor 
 - PostMapping -> http://localhost:8080/Hospital/Doctor/addDoc
 - GetMapping  -> http://localhost:8080/Hospital/Doctor/GetDoctor/Details
 - GetMapping  -> http://localhost:8080/Hospital/Doctor/GetDoctor/Details/docId/3 (By Id)
 - PutMapping  -> http://localhost:8080/Hospital/Doctor/Update/Doctor/docId/2
 - DeleteMapping -> http://localhost:8080/Hospital/Doctor/Delete/Doctor/docId/5

### Patient
 - PostMapping -> http://localhost:8080/Patient/Add/patient/Details
 - GetMapping  -> http://localhost:8080/Patient/Get/Patient
 - GetMapping  -> http://localhost:8080/Patient/GetPatient/patId/2
 - PutMapping  -> http://localhost:8080/updatePatient/patId
 - DeleteMapping -> http://localhost:8080/DeletePatient

