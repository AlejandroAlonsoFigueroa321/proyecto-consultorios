<%@ page import="java.util.Date" %>
<%@ page import="alejandro.figueroa.entities.Doctor" %>
<%@ page import="java.util.List" %>
<%@ page import="alejandro.figueroa.entities.Consultorio" %>
<%@ page import="alejandro.figueroa.entities.Cita" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Testing JSP</title>
    <style>
        *{
            font-family: Arial;
            padding: 0px;
            margin: 0px;
        }
        .box{
            border: solid black 1px;
        }
        p{
            font-size: 15px;
        }

        .container{
            display: flex;
            padding: 30px;
            justify-content: center;

        }
        .upper-container{
            padding: 30px;
        }
    </style>
</head>
<body>
<%
    // Traer la lista de doctores
    List<Doctor> doctores = (List<Doctor>) request.getAttribute("doctores");

    List<Consultorio> consultorios = (List<Consultorio>) request.getAttribute("consultorios");


    List<Cita> citas = (List<Cita>) request.getAttribute("citas");
    // Traer la lista de consultorios
%>

<div class = "container"><h1>Formulario citas</h1></div>
<h2>${name}</h2>
    <div class = "container">
       <form action="/guardar-cita" method = "POST">
           <!-- doctores -->
           <div>
               <h3>Doctores</h3>
               <select name = "idDoctor">
                   <%
                       for(Doctor d: doctores){
                           out.println("<option value = '"+d.getId()+"'>"+d.getNombre() +" " +d.getApPaterno()+"</option>");
                       }
                   %>
               </select>
           </div>
           <div>
               <h3>Numero de consultorios</h3>
               <select name = "idConsultorio">
                   <%
                       for(Consultorio c: consultorios){
                           out.println("<option value = '"+c.getId()+"'>"+c.getNumConsultorio()+"</option>");
                       }
                   %>
               </select>
           </div>

           <!--<input type="number" name="idDoctor" />
           <input type="number" name="idConsultorio" />-->
           <div>
               <h3>Horario</h3>
               <input type="text" name="horario" placeholder="12/12/2025 12:12:13"/>
           </div>

           <div>
               <h3>Nombre del paciente</h3>
               <input type="text" name="nombrePaciente" />
           </div>
           <div>
               <button type="submit">Guardar cita</button>
           </div>
       </form>

    </div>

    <div>
        <div class = "container"><h1>Citas</h1></div>

            <div class = "container">
                <div>
                <%
                    for(Cita c: citas){
                        out.println("<div class = 'box'>");
                        out.println("<div> <p>Consultorio " +c.getConsultorio().getNumConsultorio()+ "</p><div>");
                        out.println("<div> <p>Piso " +c.getConsultorio().getPiso()+ "</p><div>");
                        out.println("<div>  <p>Doctor " +c.getDoctor().getNombre() + " "+ c.getDoctor().getApPaterno()+ "</p><div>");
                        out.println("<div>  <p>Horario " +c.getHorario()+ "</p><div>");
                        out.println("</div>");
                    }
                %>
                </div>
            </div>
    </div>
</body>
</html>