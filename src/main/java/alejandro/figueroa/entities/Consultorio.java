package alejandro.figueroa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Consultorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NUMERO_CONSULTORIO")
    private Integer numConsultorio;

    @Column(name = "PISO")
    private String piso;

    @OneToMany(mappedBy = "consultorio")
    private List<Cita> citas;


    public Consultorio() {

    }
}
