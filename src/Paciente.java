/**
 * Mirka Monzon 18139
 * HDT 8
 * Sistema de colas con prioridad para atender pacientes en la emergencia de un hospital.
 *
 * Clase paciente
 */

public class Paciente implements Comparable<Paciente>{
    //atributos
    String nombre = "";
    String sintomas = "";
    String codigo = "";

    Paciente(){
    }

    //Constructor
    Paciente(String nombre, String sintomas, String codigo) {
        setNombre(nombre);
        setSintomas(sintomas);
        setCodigo(codigo);
    }

    //Comparacion de prioridad
    public int compareTo(Paciente paciente){
        if (this.codigo.compareTo(paciente.getCodigo()) < 0){
            return (-1);
        } else if (this.codigo.compareTo(paciente.getCodigo()) > 0){
            return (1);
        } else if (this.codigo.compareTo(paciente.getCodigo()) == 0){
            return 0;
        }
        return 0;
    }

    //set nombre
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    //set sintomas
    public String getSintomas() {return sintomas;}
    public void setSintomas(String sintomas) {this.sintomas = sintomas;}

    //set codigo
    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}

    //String
    public String toString(){
        return "\nPaciente:\n" +
                "\nNombre: " + getNombre() +
                "\nSintomas: " + getSintomas() +
                "\nCodigo (prioridad): " + getCodigo();

    }
}
