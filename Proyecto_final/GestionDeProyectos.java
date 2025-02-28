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
class Usuario {
    private String login;
    private String contraseña;
    private String telefono;

    // Metodo constructor clase Usuario
    public Usuario(String login, String contraseña, String telefono) {
        this.login = login;
        this.contraseña = contraseña;
        this.telefono = telefono;
    }

    // Getters y setters
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Metodo login
    public boolean login(String inputLogin, String inputContraseña) {
        return this.login.equals(inputLogin) && this.contraseña.equals(inputContraseña);
    }
}

// Creacion de la clase para usuarios administradores
class Admin extends Usuario {
    private GestorProyectos gestorProyectos;

    // Método constructor
    public Admin(String login, String contraseña, String telefono) {
        super(login, contraseña, telefono);
        this.gestorProyectos = new GestorProyectos();
    }

    // Método para crear proyectos
    public Proyecto crearProyecto(String nombre, String descripcion) {
        return gestorProyectos.crearProyecto(nombre, descripcion);
    }

    // Método para listar todos los proyectos
    public void listarProyectos() {
        gestorProyectos.listarProyectos();
    }

    // Método para asignar usuarios a proyectos
    public void asignarUsuarioAProyecto(Proyecto proyecto, Usuario usuario) {
        gestorProyectos.AsignarAProyecto(proyecto, usuario);
    }

    // Método público para obtener el gestor de proyectos
    public GestorProyectos getGestorProyectos() {
        return gestorProyectos;
    }
}

// Creacion de la subclase para usuarios comunes
class Comun extends Usuario {
    // Metodo constructor
    public Comun(String login, String contraseña, String telefono) {
        super(login, contraseña, telefono);
    }
}

// Creacion de la clase proyecto
class Proyecto {
    String nombre;
    String descripcion;
    List<Usuario> usuariosAsignados; // Lista de usuarios asignados al proyecto
    List<Tarea> tareas; // Lista de tareas a realizar del proyecto

    // Metodo constructor:
    public Proyecto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuariosAsignados = new ArrayList<>();
        this.tareas = new ArrayList<>();
    }

    // Getters
    public String getnombre() {
        return this.nombre;
    }

    public String getdescripcion() {
        return this.descripcion;
    }

    public List<Usuario> getUsuariosAsignados() {
        return this.usuariosAsignados;
    }

    public List<Tarea> getTareas() {
        return this.tareas;
    }

    // Metodo para asignar un usuario al proyecto
    public void AsignarAProyecto(Usuario usuario) {
        if (!usuariosAsignados.contains(usuario)) {
            usuariosAsignados.add(usuario);
        } else {
            System.out.println("El usuario ya está asignado a este proyecto.");
        }
    }

    // Metodo para agregar una tarea al proyecto
    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    // Metodo para listar tareas de un usuario
    public void listarTareasDeUsuario(Usuario usuario) {
        System.out.println("Tareas asignadas a " + usuario.getLogin() + ":");
        for (Tarea tarea : tareas) {
            if (tarea.getUsuarioAsignado().equals(usuario)) {
                System.out.println("- " + tarea.getDescripcion() + " (" + (tarea.isTerminada() ? "Completada" : "Pendiente") + ")");
            }
        }
    }
}

class Tarea {
    private String descripcion;
    private Usuario usuarioAsignado;
    private boolean terminada;

    // Metodo constructor
    public Tarea(String descripcion, Usuario usuarioAsignado) {
        this.descripcion = descripcion;
        this.usuarioAsignado = usuarioAsignado;
        this.terminada = false;
    }

    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public Usuario getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public boolean isTerminada() {
        return terminada;
    }

    // Metodo para marcar la tarea como completada
    public void marcarComoCompletada() {
        this.terminada = true;
    }
}

class GestorProyectos {
    private List<Proyecto> proyectos;

    // Metodo constructor
    public GestorProyectos() {
        this.proyectos = new ArrayList<>();
    }

    // Metodo para crear proyecto
    public Proyecto crearProyecto(String nombre, String descripcion) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getnombre().equals(nombre)) {
                System.out.println("Ya existe un proyecto con ese nombre.");
                return null;
            }
        }
        Proyecto proyecto = new Proyecto(nombre, descripcion);
        proyectos.add(proyecto);
        return proyecto;
    }

    // Metodo para agregar usuarios al proyecto
    public void AsignarAProyecto(Proyecto proyecto, Usuario usuario) {
        proyecto.AsignarAProyecto(usuario);
    }

    // Metodo para listar todos los proyectos
    public void listarProyectos() {
        System.out.println("Lista de proyectos:");
        for (Proyecto proyecto : proyectos) {
            System.out.println("- " + proyecto.getnombre() + ": " + proyecto.getdescripcion());
        }
    }

    // Metodo para obtener todos los proyectos
    public List<Proyecto> getProyectos() {
        return proyectos;
    }
}

public class GestionDeProyectos {

    public static void main(String[] args) {
        // Mensaje de bienvenida
        System.out.println("Bienvenido al Programa de Gestion de Proyectos");

        // Usar una lista para almacenar los usuarios
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Admin("admin", "admin", "55544332211"));
        usuarios.add(new Comun("comun", "SGPcomun2025", "5511223344"));

        // Scanner para pedir login y contraseña
        Scanner sc = new Scanner(System.in);

        // Solicitar Login y contraseña
        System.out.println("Ingresa tu login");
        String inputLogin = sc.nextLine();
        System.out.println("Ingresa tu contraseña");
        String inputContraseña = sc.nextLine();

        // Declaracion vacia de usuario actual
        Usuario usuarioActual = null;

        // Verificacion de identidad
        for (Usuario usuario : usuarios) {
            if (usuario.login(inputLogin, inputContraseña)) {
                usuarioActual = usuario;
                break;
            }
        }

        // Si el usuario fue encontrado
if (usuarioActual != null) {
    System.out.println("Bienvenido " + usuarioActual.getLogin());

    // Menu para usuarios administradores
    if (usuarioActual instanceof Admin) {
        boolean salir = false;
        GestorProyectos gestorProyectos = ((Admin) usuarioActual).getGestorProyectos(); // Usar el método público

        while (!salir) {
            System.out.println("Tienes permisos de administrador");
            System.out.println("1. Crear un proyecto");
            System.out.println("2. Listar proyectos");
            System.out.println("3. Asignar usuario a proyecto");
            System.out.println("0. Salir");
            System.out.println("Selecciona una opcion");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    System.out.println("Ingresa el nombre del proyecto");
                    String nombre = sc.nextLine();
                    System.out.println("Ingresa la descripcion del proyecto");
                    String descripcion = sc.nextLine();
                    Proyecto proyecto = ((Admin) usuarioActual).crearProyecto(nombre, descripcion);
                    if (proyecto != null) {
                        proyecto.AsignarAProyecto(usuarioActual);
                        System.out.println("Se ha creado el proyecto de nombre " + proyecto.getnombre() + " con la descripcion: \n" + proyecto.getdescripcion());
                    }
                    break;
                case 2:
                    ((Admin) usuarioActual).listarProyectos();
                    break;
                case 3:
                    System.out.println("Ingresa el nombre del proyecto");
                    String nombreProyecto = sc.nextLine();
                    System.out.println("Ingresa el login del usuario a asignar");
                    String loginUsuario = sc.nextLine();
                    Usuario usuarioAsignar = null;
                    for (Usuario usuario : usuarios) {
                        if (usuario.getLogin().equals(loginUsuario)) {
                            usuarioAsignar = usuario;
                            break;
                        }
                    }
                    if (usuarioAsignar != null) {
                        for (Proyecto p : gestorProyectos.getProyectos()) {
                            if (p.getnombre().equals(nombreProyecto)) {
                                ((Admin) usuarioActual).asignarUsuarioAProyecto(p, usuarioAsignar);
                                System.out.println("Usuario asignado al proyecto.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    } else if (usuarioActual instanceof Comun) {
        boolean salir = false;
        GestorProyectos gestorProyectos = new GestorProyectos();

        while (!salir) {
            System.out.println("Eres un usuario tipo comun");
            System.out.println("1. Ver proyectos asignados");
            System.out.println("2. Ver tareas pendientes");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("0. Salir");
            System.out.println("Selecciona una opcion");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    System.out.println("Proyectos asignados:");
                    for (Proyecto proyecto : gestorProyectos.getProyectos()) {
                        if (proyecto.getUsuariosAsignados().contains(usuarioActual)) {
                            System.out.println("- " + proyecto.getnombre() + ": " + proyecto.getdescripcion());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Tareas pendientes:");
                    for (Proyecto proyecto : gestorProyectos.getProyectos()) {
                        proyecto.listarTareasDeUsuario(usuarioActual);
                    }
                    break;
                case 3:
                    System.out.println("Ingresa el nombre del proyecto");
                    String nombreProyecto = sc.nextLine();
                    System.out.println("Ingresa la descripcion de la tarea");
                    String descripcionTarea = sc.nextLine();
                    for (Proyecto proyecto : gestorProyectos.getProyectos()) {
                        if (proyecto.getnombre().equals(nombreProyecto)) {
                            for (Tarea tarea : proyecto.getTareas()) {
                                if (tarea.getDescripcion().equals(descripcionTarea) && tarea.getUsuarioAsignado().equals(usuarioActual)) {
                                    tarea.marcarComoCompletada();
                                    System.out.println("Tarea marcada como completada.");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
} else {
    System.out.println("Tu nombre de usuario o contraseña son incorrectos");
}
    }
}