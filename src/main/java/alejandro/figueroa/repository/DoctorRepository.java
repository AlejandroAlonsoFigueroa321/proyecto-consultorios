package alejandro.figueroa.repository;

import alejandro.figueroa.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
