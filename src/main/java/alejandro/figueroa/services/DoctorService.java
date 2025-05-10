package alejandro.figueroa.services;


import alejandro.figueroa.entities.Doctor;
import alejandro.figueroa.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor>  getDoctors(){
        List<Doctor> doctorList = this.doctorRepository.findAll();
        return doctorList;
    }
}
