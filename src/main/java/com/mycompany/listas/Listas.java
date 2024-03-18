package com.mycompany.listas;

import com.mycompany.Colecciones.Lista;
import com.mycompany.Colecciones.ListaDoblementeEnlazada;
import java.util.Scanner;

public class Listas {

    public static void main(String[] args) {
        Lista<Paciente> listaPacientes = new ListaDoblementeEnlazada<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu centro medico");
            System.out.println("1.Registro de pacientes");
            System.out.println("2.Solicitar cita");
            System.out.println("3.Revisar ticket");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese el nombre del paciente :");
                    String nombrePaciente=scanner.next();
                    System.out.println("Ingrese el apellido del paciente :");
                    String apellidoPaciente = scanner.next();
                    System.out.println("Ingrese la edad del paciente :");
                    int edadPaciente = scanner.nextInt();
                    System.out.println("Ingrese la identificacion del paciente :");
                    int identificacionPaciente = scanner.nextInt();
                    System.out.println("Inugrese el numero de telefono del paciente :");
                    int numeroDeTelefono = scanner.nextInt();
                    Paciente nuevoPaciente = new Paciente(nombrePaciente, apellidoPaciente, edadPaciente, identificacionPaciente, numeroDeTelefono);
                    listaPacientes.agregarAlFinal(nuevoPaciente);
                }
                case 2 ->{
                    System.out.println("Ingrese la especialidad que necesita :");
                    String especialidadNecesitada = scanner.next();
                    System.out.println("El profesional asignado es :");
                    String profesionalAsginado = "DR. Juan";
                    Cita nuevaCita = new Cita(especialidadNecesitada, profesionalAsginado);
                }
                case 3 ->{
                    System.out.println("Su tickect es :");
                }
                default -> throw new AssertionError();
            }
        } while (opcion != 0);

    }
}
