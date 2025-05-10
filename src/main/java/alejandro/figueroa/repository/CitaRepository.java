package alejandro.figueroa.repository;

import alejandro.figueroa.entities.Cita;
import alejandro.figueroa.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
    @Query(value = "SELECT * FROM cita WHERE ID_DOCTOR = :idDoctor AND HORARIO BETWEEN :startOfDay AND :now", nativeQuery = true)
    List<Cita> findCitasByDoctorAndDate(@Param("idDoctor") Integer idDoctor, @Param("startOfDay") Date startOfDay, @Param("now") Date now);

    @Query(value = "SELECT * FROM cita WHERE ID_CONSULTORIO = :idConsultorio AND HORARIO = :desiredDate", nativeQuery = true)
    List<Cita> findCitasByConsultorioAndDate(@Param("idConsultorio") Integer idConsultorio, @Param("desiredDate") Date desiredDate);

    @Query(value = "SELECT * FROM cita WHERE ID_DOCTOR = :idDoctor AND HORARIO = :desiredDate", nativeQuery = true)
    List<Cita> findCitasByDoctorSameTime(@Param("idDoctor") Integer idDoctor, @Param("desiredDate") Date desiredDate);

}
