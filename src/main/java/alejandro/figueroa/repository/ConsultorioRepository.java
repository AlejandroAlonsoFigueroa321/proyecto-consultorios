package alejandro.figueroa.repository;

import alejandro.figueroa.entities.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConsultorioRepository extends JpaRepository<Consultorio, Integer> {


}
