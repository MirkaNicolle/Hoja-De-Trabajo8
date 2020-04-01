/**
 * Mirka Monzon 18139
 * HDT 8
 * Sistema de colas con prioridad para atender pacientes en la emergencia de un hospital.
 *
 * Main
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.print("\nIngrese path del archivo: ");
        Scanner input = new Scanner(System.in);
        String path = input.next();
        Vector pacientes = readPacientes(path);

        PriorityQueue priorityQueue = new VectorHeap(pacientes);

        boolean wantsToContinue = true;

        while (wantsToContinue){

            System.out.println(mainMenu());
            System.out.print("\nIngrese una opcion: ");
            Scanner input2 = new Scanner(System.in);
            String op = input2.next();

            switch (op){
                case "1":
                    if (priorityQueue.size() > 0){
                        System.out.println(priorityQueue.remove());
                    } else {
                        System.out.println("\nERROR: No hay pacientes por atender.");
                    }
                    break;
                case "2":
                    wantsToContinue = false;
                    break;
                default:
                    System.out.println("\nERROR: Opcion ingresada no es valida.");
                    break;
            }

        }

    }

    //Main menu
    public static String mainMenu(){
        return "\n\tMenu" +
                "\n1. Siguiente paciente" +
                "\n2. Salir";

    }

    //lectura txt
    public static Vector readPacientes(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        Vector pacientes = new Vector();

        while ((line = bufferedReader.readLine()) != null) {

            String[] info = line.split(", ");
            String nombre = info[0];
            String sintomas = info[1];
            String codigo = info[2];

            Paciente paciente = new Paciente(nombre, sintomas, codigo);

            pacientes.add(paciente);

        }

        return pacientes;
    }

}
