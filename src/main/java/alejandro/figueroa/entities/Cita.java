package alejandro.figueroa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "ID_DOCTOR", insertable = false, updatable = false)
    private Doctor doctor;

    @Column(name = "ID_DOCTOR")
    private Integer idDoctor;

    @ManyToOne()
    @JoinColumn(name = "ID_CONSULTORIO", insertable = false, updatable = false)
    private Consultorio consultorio;

    @Column(name = "ID_CONSULTORIO")
    private Integer idConsultorio;


    @Column(name = "HORARIO")
    private Date horario;

    @Column(name = "NOMBRE_PACIENTE")
    private String nombrePaciente;


    public Cita() {

    }
}
