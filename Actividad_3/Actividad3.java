/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad3;
import java.util.Scanner;
/**
 *
 * @author heckl
 */

 class Closet_Marques{
     Scanner scanner = new Scanner(System.in);
    String descripcion;
    String codigo;
    String tipo;
    double costo;
    double impuesto;
    
    //Metodos descipcion
    //Metodo establcedor para asignar descripcion
    public void setdescripcion(String ndescripcion){
        this.descripcion = ndescripcion ;    

    }
    //Metodo para devolver descripcion 
    public String getdescripcion(){
        return descripcion;
    }
    
    //Metodos codigo
    public void setcodigo(String ncodigo){
        this.codigo = ncodigo ;    

    }
    public String getcodigo(){
        return codigo;
    }
    
    //Metodos tipo
     public void settipo(String ntipo){
        this.tipo = ntipo ;    

    }
    public String gettipo(){
        return tipo;
    }
    
    //Metodos costo
     public void setcosto(double ncosto){
        this.costo = ncosto ;    

    }
    public double getcosto(){
        return costo;
    }
    
    //Metodos impuesto
     public void setimpuesto(double nimpuesto){
        this.impuesto = nimpuesto ;    

    }
    public double getimpuesto(){
        return impuesto;
    }
    
//Metodo para mostrar atributos
    public void muestra_producto(){
        System.out.println("Descripcion: "+ getdescripcion());
        System.out.println("Codigo: " + getcodigo());
        System.out.println("Tipo: " + gettipo());
        System.out.println("Costo: " + getcosto());
        System.out.println("Impuesto " + getimpuesto());
    }
    
    //Calculo precio de venta
    public double calcular_precio(){
        System.out.println("Ingresa el porcentaje de utilidad del producto");
       double utilidad = scanner.nextDouble();
       double utilidad_real = utilidad/100;
       double impuesto_real = getimpuesto() /100;
       double precio_ut = getcosto() + (getcosto()*utilidad_real);
       double precio = precio_ut + (getcosto()*impuesto_real);
        return precio;
    }
    
    // Método estático para comparar dos productos
    public static String compararProductos(Closet_Marques p1, Closet_Marques p2) {
        double precio1 = p1.calcular_precio();
        double precio2 = p2.calcular_precio();

        if (precio1 > precio2) {
            return "El producto más caro es: " + p1.getdescripcion() + " con un precio de $" + precio1;
        } else if (precio2 > precio1) {
            return "El producto más caro es: " + p2.getdescripcion() + " con un precio de $" + precio2;
        } else {
            return "Ambos productos tienen el mismo precio de $" + precio1;
        }
    }
}

public class Actividad3 {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         
        Closet_Marques obj = new Closet_Marques();
        Closet_Marques obj2 = new Closet_Marques();
        
        System.out.println("Bienvenid@, este programa te ayudara a a comparar 2 productos");
        
        //Asignar atributos de objeto 1
        System.out.println("Ingresa la descripcion del primer articulo");
        String desc1 = scanner.nextLine();
        obj.setdescripcion(desc1); 
        
        System.out.println("Ingresa el codigo del primer articulo");
        String code1 = scanner.nextLine();
        obj.setcodigo(code1); 
        
        System.out.println("Ingresa el tipo del primer articulo");
        String tipo1 = scanner.nextLine();
        obj.settipo(tipo1); 
        
        System.out.println("Ingresa el costo del primer articulo");
        double costo1 = scanner.nextDouble();
        obj.setcosto(costo1); 
        
        System.out.println("Ingresa el porcentaje de impuesto del primer articulo");
        double imp1 = scanner.nextDouble();
        obj.setimpuesto(imp1); 
        scanner.nextLine();
        
        
        
        //Asignar atributos de objeto 2
        System.out.println("Ingresa la descripcion del segundo articulo");
        String desc2 = scanner.nextLine();
        obj2.setdescripcion(desc2); 
        
        System.out.println("Ingresa el codigo del segundo articulo");
        String code2 = scanner.nextLine();
        obj2.setcodigo(code2); 
        
        System.out.println("Ingresa el tipo del segundo articulo");
        String tipo2 = scanner.nextLine();
        obj2.settipo(tipo2); 
        
        System.out.println("Ingresa el costo del segundo articulo");
        double costo2 = scanner.nextDouble();
        obj2.setcosto(costo2); 
        
        System.out.println("Ingresa el porcentaje de impuesto del segundo articulo");
        double imp2 = scanner.nextDouble();
        obj2.setimpuesto(imp2); 
        
        obj.muestra_producto();
        obj2.muestra_producto();
        
            // Comparar productos
            String resultado = Closet_Marques.compararProductos(obj, obj2);
            System.out.println(resultado);
        
        System.out.println(obj.calcular_precio());
        
    }
}
