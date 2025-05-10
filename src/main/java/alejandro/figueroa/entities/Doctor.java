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
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "doctor")
    private List<Cita> citas;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO_PATERNO")
    private String apPaterno;

    @Column(name = "APELLIDO_MATERNO")
    private String apMaterno;

    @Column(name = "ESPECIALIDAD")
    private String especialidad;

    public Doctor() {

    }
}