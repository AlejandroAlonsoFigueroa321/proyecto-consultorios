package alejandro.figueroa.controllers;

import alejandro.figueroa.entities.Cita;
import alejandro.figueroa.entities.Consultorio;
import alejandro.figueroa.entities.Doctor;
import alejandro.figueroa.repository.CitaRepository;
import alejandro.figueroa.repository.ConsultorioRepository;
import alejandro.figueroa.repository.DoctorRepository;
import alejandro.figueroa.request.dto.CitaDTO;
import alejandro.figueroa.services.DoctorService;
import alejandro.figueroa.utils.validations.CitaValidationsUtils;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Controller
public class HelloWorldControler {


    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ConsultorioRepository consultorioRepository;

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private CitaValidationsUtils cvu;


    @GetMapping("/citas")
    public String home(Model model) {
        List<Doctor> doctores = this.doctorRepository.findAll();
        List<Consultorio> consultorios = this.consultorioRepository.findAll();
        List<Cita> citas = this.citaRepository.findAll();

        model.addAttribute("doctores", doctores);
        model.addAttribute("consultorios", consultorios);
        model.addAttribute("citas", citas);

        return "consultas";
    }

    @PostMapping("/guardar-cita")
    public String guardarCita(@ModelAttribute CitaDTO cita, Model model){
        List<Doctor> doctores = this.doctorRepository.findAll();

        Cita c  = new Cita();

        c.setIdDoctor(cita.getIdDoctor());
        c.setIdConsultorio(cita.getIdConsultorio());
        c.setNombrePaciente(cita.getNombrePaciente());

        //dd/MM/yyyy HH:mm:ss
        c.setHorario(this.cvu.fromStringToDate(cita.getHorario()));

        String errors = this.runValidations(cita);

        if(errors.isEmpty()){
            System.out.println("//// No hay errores, se guarda /////////");
            this.citaRepository.save(c);

            return "redirect:/citas";
        }else{
            model.addAttribute("errores", errors);
            return "error";
        }

    }


    public String runValidations(CitaDTO cita){
        Date horario  = this.cvu.fromStringToDate(cita.getHorario());

        //1.-No se puede agendar cita en un mismo consultorio a la misma hora.
        String e1= this.cvu.validarMismoConsultorio(cita.getIdConsultorio(),horario);


        //2.-No se puede agendar cita para un mismo Dr. a la misma hora.

        String e2 = this.cvu.validarMismoDr(horario, cita.getIdDoctor());

        //4.- Un mismo doctor no puede tener más de 8 citas en el día.
        String e3= this.cvu.validarLimiteCitasPorDia(cita.getIdDoctor(), horario);

        if(e1.isEmpty() && e2.isEmpty() && e3.isEmpty()){
            return "";
        }

        return e1.concat(e2).concat(e3);
    }

}
