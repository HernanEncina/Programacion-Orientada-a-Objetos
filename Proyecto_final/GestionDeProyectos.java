/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestiondeproyectos;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Hernan Encina Martinez
 */
class Usuario{
   private String login;
   private String contraseña;
   private String telefono;
    
   //Metodo constructor clase Usuario
   public Usuario (String login, String contraseña, String telefono){
     this.login=login;
     this.contraseña=contraseña;
     this.telefono=telefono;
   }
   
   //Getters y setters
   public String getLogin(){
       return login;
   }
   
   public void setLogin(String login){
       this.login = login;
       
   }
   
   public String getContraseña(){
       return contraseña;
   }
   
   public void setContraseña(String contraseña){
       this.contraseña = contraseña;
   }
   
   public String getTelefono(){
       return telefono;
   }
   
   public void setTelefono(String telefono){
       this.telefono=telefono;
   }
   
//Metodo login
public boolean login(String inputLogin, String inputContraseña){ //Usa los parametros inputLogin e inputContraseña que ingresa el usuario en la clase main
return this.login.equals(inputLogin) && this.contraseña.equals(inputContraseña);//Despues los compara con los login y contraseña del objeto, si coinciden devuelve un valor true
}
}

//Creacion de la clase para usuarios administradores
  class Admin extends Usuario {
      private GestorProyectos gestorProyectos;//Le asigna un objeto de clase Gestorproyectos a la clase admin
      
      //Metodo constructor
        public Admin (String login, String contraseña, String telefono){
            super(login, contraseña, telefono);
            this.gestorProyectos = new GestorProyectos();
        }
        
        //Metodo para crear poyectos que solo llama el metodo que esta en la clase GestorProyectos
        public Proyecto crearProyecto(String nombre, String descripcion){
            return gestorProyectos.crearProyecto(nombre, descripcion);
        }
    }
//Creacion de la subclase para usuarios comunes
class Comun extends Usuario{
    //Metodo constructor
        public Comun (String login, String contraseña, String telefono){
            super(login, contraseña, telefono);
        }
    }

//Creacion de la clase proyecto
 class Proyecto{
    String nombre;
    String descripcion;
    List<Usuario> usuariosAsignados; //Lista de usuarios asignados al proyecto
    List<Tarea> tareas;//Lista de taras a realizar del proyecto
    
    //Metodo constructor:
    public Proyecto (String nombre, String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.usuariosAsignados  = new ArrayList<>();
        this.tareas  = new ArrayList<>();
    }

    //getters
    public String getnombre(){
        return this.nombre;
    }
    public String getdescripcion(){
        return this.descripcion;
    }
    public List<Usuario> getUsuariosAsignados(){
        return this.usuariosAsignados;
    }
    public List<Tarea> getTareas(){
    return this.tareas;
    }
    
    //metodo para asignar un usuario al proyecto
    public void AsignarAProyecto(Usuario usuario){
        usuariosAsignados.add(usuario);
    }
}

class Tarea{
    private String descripcion;
    private Usuario usuarioAsignado;
    private boolean terminada;
    
    public Tarea (String descripcion, Usuario usuario){
    this.descripcion=descripcion;
    this.usuarioAsignado = usuarioAsignado;
}
}
class GestorProyectos{//Clase para gestionar proyectos
    
    //Metodo para crear proyecto
    public Proyecto crearProyecto(String nombre, String descripcion){
        return new Proyecto(nombre, descripcion);
    }
    
    //Metodo para agregar usuarios al proyecto
    public void AsignarAProyecto(Proyecto proyecto, Usuario usuario){
        proyecto.AsignarAProyecto(usuario);
    }
}
public class GestionDeProyectos {

    public static void main(String[] args) {
        
        //Mensaje de bienvenida
        System.out.println("Bienvenido al Programa de Gestion de Proyectos");
        //Usar una lista para almacenar los usuarios, tuve que aprender a usar listas en Java ya q no recordaba
        List<Usuario> usuarios = new ArrayList<>(); //Se declara una Lista que solo puede contener objetos de la superclase usuario y sus subclases, osea admin y comun
        usuarios.add (new Admin("admin", "admin", "55544332211"));
        usuarios.add (new Comun("comun", "SGPcomun2025", "5511223344"));
        
        //Scanner para pedir login y contraseña
        Scanner sc = new Scanner(System.in);
        
        //Solicitar Login y contraseña
        System.out.println("Ingresa tu login");
        String inputLogin = sc.nextLine();
        System.out.println("Ingresa tu contraseña");
        String inputContraseña = sc.nextLine();
        
        //Declaracion vacia de usuario actual
        Usuario usuarioActual = null;        
        
        //Verificacion de identidad
        for (Usuario usuario : usuarios){ //Ciclo que itera por cada una de las instancias de la lista usuarios
            if(usuario.login(inputLogin, inputContraseña)){ //SI el metodo login que compara el input con las variables del sistema devuelve un true se dispara la sentencia if que asigna el usuario actual al usuario del login;
            usuarioActual = usuario;
            break;
            }
        }
            //Si el usuario fue encontrado
            if(usuarioActual != null){
                System.out.println("Bienvenido "+ usuarioActual.getLogin());
                
                //Menu para usuarios administradores
                if (usuarioActual instanceof Admin){//La sentencia que se dispara si el usuario actual es una instancia de la clase Admin
                    boolean salir = false;
                    
                    while (!salir){
                   System.out.println("Tienes permisos de administrador");
                   System.out.println("1.Crear un proyecto");
                    System.out.println("0.Sslir");
                   System.out.println("Selecciona una opcion");
                   int opcion = sc.nextInt();
                   sc.nextLine();
                   
                   //Sentencia que se dispara si la opcion seleccionada es 1 (Creacion de proyecto)
                   switch (opcion){ 
                       
                       case 0:
                           salir=true;
                       break;
                       case 1:
                           System.out.println("Ingresa el nombre del proyecto");
                             String nombre = sc.nextLine();
                   System.out.println("Ingresa la descripcion del proyecto");
                   String descripcion = sc.nextLine();
                   Proyecto proyecto = ((Admin) usuarioActual).crearProyecto(nombre, descripcion);
                   proyecto.AsignarAProyecto(usuarioActual);
                   System.out.println("Se ha creado el proyecto de nombre "+ proyecto.getnombre()+ " con la descripcion: \n"+ proyecto.getdescripcion());
                   
                   //Mostrar los usuarios asignados al proyecto
                   System.out.println("Usuarios asignados al proyecto:");
                   for (Usuario usuario : proyecto.getUsuariosAsignados()){
                       System.out.println("-"+usuario.getLogin());
                   }
                   System.out.println(proyecto.getUsuariosAsignados());
                   break;
                       case 2:
                           System.out.println("esta es la opcion 2 lol");
                           break;
                   
                   
                   }
                   
                   
                   
                
                }}
                else if (usuarioActual instanceof Comun) {
                    System.out.println("Eres un usuario tipo comun");
                }
                
            }else{//Si el usuario no fue encontrado
                System.out.println("Tu nombre de usuario o contraseña son equivocados");
            }
        
        
        
    }
}
