/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad2;
import java.util .Scanner;
/**
 *
 * @author heckl
 */
public class Actividad2 {
    //Hernan Encina Martinez AL07008702
    //Act 2: Uso de Java, scanner y ciclos 
    //Profesor Hector Aguilar
    //En esta actividad se usaron varias funciones de Java para poder crear programas que cumplan con lo especificado en la actividad, detalles mas adelante
    //Se omitio la creacion de reporte debido al comentario del profesor sobre que si el codigo estaba bien comentado entonces bastaria con ello
    //Por eso he decidio que mi codigo hablara por si mismo
    
    public static void main(String[] args) {
        //Programa 1. Comparacion de dos nombres
        String nombrepred ="Hernan Encina Martinez";//Nombre predeterminado del sistema
        System.out.println("Este programa comparara el nommbre ingresado por el usuario al nombre predeterminado de la aplicacion \n Ingresa el nombre que deseas comparar");
Scanner scanner = new Scanner(System.in);
String nombre= scanner.nextLine();//Uso de la funcion scanner para que el usuario ingrese el nombre a comparar
System.out.println("hola " + nombre);

if(nombre.equals(nombrepred)){//Ciclo if para comparar el nombre ingresado por el usuario con el del sistema
System.out.println("El nombre es el mismo que el preterminado");//En caso de ser el mismo nombre este mensaje sera mostrado
}else{
System.out.println("El nombre no es el mismo al predeterminado");//En cualquier otro caso este sera el mensaje disparado
}
//Programa 2. Numeros pares del 1 al 100 usando arrays y un ciclo for
 System.out.println("Este otro programa te dara una lista de numeros del 1 al 100 \n Presiona enter para continuar");
 scanner.nextLine();//Este scanner solo sirve como control hasta que el usuario haga una accion
 int [] pares = new int [51];//Declaracion de un array llamado pares con 51 espacios para almacenar los numeros pares
 int index=0;//index que sera usado por el programa para determinar la posicion del array en el ciclo
 for(int i=0; i<=100; i+=2){//Ciclo While que empieza con la variable i en 0, dandole a esta misma un incremento de 2 por cada ciclo mientras que sea igual o menor que 100
     pares[index]=i;//Se le asigna el valor de i al espacio en el array dictado por index.
     System.out.println(pares[index]);//Se imprime el valor asignado en la posicion del array dictaminado de nuevo por index
     index++;//Index se incrementa +1 al final del ciclo para que en el siquiente ciclo se use el siguiente espacio del array, ej: 0 en el primero, 1 en el segundo

    }
    }
    
}
