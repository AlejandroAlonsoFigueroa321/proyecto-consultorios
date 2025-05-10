package alejandro.figueroa.request.dto;


import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class CitaDTO {

    //private Integer id;

    private Integer idDoctor;

    private Integer idConsultorio;

    private String horario;

    private String nombrePaciente;
}
