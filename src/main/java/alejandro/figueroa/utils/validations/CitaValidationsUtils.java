package alejandro.figueroa.utils.validations;


import alejandro.figueroa.entities.Cita;
import alejandro.figueroa.repository.CitaRepository;
import alejandro.figueroa.repository.ConsultorioRepository;
import alejandro.figueroa.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class CitaValidationsUtils {


    @Autowired
    private CitaRepository citaRepository;


    public String validarLimiteCitasPorDia(Integer idDoctor, Date desiredDate){
        String error = "";

        Calendar cal = Calendar.getInstance();
        cal.setTime(desiredDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date startOfDay = cal.getTime();

        System.out.println(startOfDay);
        System.out.println (new Date());
        List<Cita> citas = this.citaRepository.findCitasByDoctorAndDate(idDoctor, startOfDay, desiredDate);

        if(citas.size() >= 8){

            error = "Ya se alcanzó el limite de 8 citas diarias del doctor";
            System.out.println(error);
        }

        return error;
    }

    public String validarMismoDr(Date horario, Integer idDoctor){
        List<Cita>citas = this.citaRepository.findCitasByDoctorSameTime(idDoctor,horario);
        String error = "";
        if(!citas.isEmpty()){
            error = "Ya existe una cita para el doctor en la hora solicitada";
            System.out.println(error);
        }
        return error;
    }

    public String validarMismoConsultorio(Integer idConsultorio, Date horario){
        String error = "";
        List<Cita>citas = this.citaRepository.findCitasByConsultorioAndDate(idConsultorio, horario);
        if(!citas.isEmpty()){
            error = "Ya existe una cita en el consultorio en la hora solicitada";
            System.out.println(error);
        }
        return error;
    }

    public boolean validarPacienteHrsDiferencia(Integer idPaciente, Date horario){
        return false;
    }

    public Date fromStringToDate(String dateStr)  {
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return  formatter.parse(dateStr);
        }catch(ParseException e){
            return null;
        }
    }
}
