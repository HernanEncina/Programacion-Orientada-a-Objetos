/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad4;
import java.util.Scanner;

/**
 * Programa para gestionar el control escolar.
 * Permite manejar profesores, alumnos, cursos y materias.
 * 
 * @author heckl
 */

// Clase Materia
class Materia {
    String nombre;
    String clave;
    int creditos;
    int horasSemanales;
    
    // Constructores
    public Materia() {}
    public Materia(String nombre, String clave, int creditos, int horasSemanales) {
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
    }
    public Materia(Materia otra) {
        this.nombre = otra.nombre;
        this.clave = otra.clave;
        this.creditos = otra.creditos;
        this.horasSemanales = otra.horasSemanales;
    }
}

// Clase Curso
class Curso {
    String nombre;
    Materia materia1, materia2, materia3;
    
    // Constructores
    public Curso() {}
    public Curso(String nombre, Materia m1, Materia m2, Materia m3) {
        this.nombre = nombre;
        this.materia1 = m1;
        this.materia2 = m2;
        this.materia3 = m3;
    }
    public Curso(Curso otro) {
        this.nombre = otro.nombre;
        this.materia1 = otro.materia1;
        this.materia2 = otro.materia2;
        this.materia3 = otro.materia3;
    }
    
    // Metodo para calcular los creditos totales del curso
    public int calcularCreditos() {
        return materia1.creditos + materia2.creditos + materia3.creditos;
    }
}

// Clase Profesor
class Profesor {
    String nombre;
    int numNomina;
    double sueldoPorHora;
    Materia materia;
    
    // Constructores
    public Profesor() {}
    public Profesor(String nombre, int numNomina, double sueldoPorHora, Materia materia) {
        this.nombre = nombre;
        this.numNomina = numNomina;
        this.sueldoPorHora = sueldoPorHora;
        this.materia = materia;
    }
    public Profesor(Profesor otro) {
        this.nombre = otro.nombre;
        this.numNomina = otro.numNomina;
        this.sueldoPorHora = otro.sueldoPorHora;
        this.materia = otro.materia;
    }
    
    // Metodo para calcular sueldo semanal
    public double calcularSueldoSemanal() {
        return sueldoPorHora * materia.horasSemanales;
    }
}

// Clase Alumno
class Alumno {
    String matricula;
    String nombre;
    int edad;
    Curso curso;
    
    // Constructores
    public Alumno() {}
    public Alumno(String matricula, String nombre, int edad, Curso curso) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }
    public Alumno(Alumno otro) {
        this.matricula = otro.matricula;
        this.nombre = otro.nombre;
        this.edad = otro.edad;
        this.curso = otro.curso;
    }
}

public class Actividad4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bienvenid@ al sistema de control escolar");
        
        try {
            // Creando materias
            System.out.println("Ingresa el nombre de la primera materia:");
            String nombreM1 = scanner.nextLine();
            Materia m1 = new Materia(nombreM1, "MAT101", 5, 4);
            
            System.out.println("Ingresa el nombre de la segunda materia:");
            String nombreM2 = scanner.nextLine();
            Materia m2 = new Materia(nombreM2, "MAT102", 4, 3);
            
            System.out.println("Ingresa el nombre de la tercera materia:");
            String nombreM3 = scanner.nextLine();
            Materia m3 = new Materia(nombreM3, "MAT103", 6, 5);
            
            // Creando curso
            Curso curso1 = new Curso("Curso de Ciencias", m1, m2, m3);
            
            // Creando profesor
            System.out.println("Ingresa el nombre del profesor:");
            String nombreProf = scanner.nextLine();
            Profesor profesor1 = new Profesor(nombreProf, 12345, 200.0, m1);
            
            // Creando alumno
            System.out.println("Ingresa la matricula del alumno:");
            String matriculaAlum = scanner.nextLine();
            System.out.println("Ingresa el nombre del alumno:");
            String nombreAlum = scanner.nextLine();
            System.out.println("Ingresa la edad del alumno:");
            int edadAlum = scanner.nextInt();
            
            Alumno alumno1 = new Alumno(matriculaAlum, nombreAlum, edadAlum, curso1);
            
            // Mostrando informacion
            System.out.println("\nProfesor: " + profesor1.nombre + "\nMateria que imparte: " + profesor1.materia.nombre + "\nSueldo semanal: " + profesor1.calcularSueldoSemanal());
            System.out.println("\nAlumno: " + alumno1.nombre + "\nCurso inscrito: " + alumno1.curso.nombre + "\nCreditos del curso: " + alumno1.curso.calcularCreditos());
            
        } catch (Exception e) {
            System.out.println("Error: Entrada de datos invalida. Asegurate de ingresar valores correctos.");
        }
    }
}
