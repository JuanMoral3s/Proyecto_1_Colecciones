import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.List;

public class Asignatura {

    private int claveAsignatura;
    private String nombreAsinatura;
    private List<Profesor> profesores; 
    //private ArrayList<Profesor> profesoresDeLaMateria = new ArrayList();
    
    
    public static Hashtable<Integer,Asignatura> asignaturas = new Hashtable<Integer,Asignatura>();
  

    //public void setProfesoresDeLaMateria(ArrayList<Profesor> profesoresDeLaMateria){
     //   this.profesoresDeLaMateria=profesoresDeLaMateria;
   // }

    //public ArrayList<Profesor> getProfesoresDeLaMateria(){
     //   return this.profesoresDeLaMateria;
   // }

   public void setProfe( Profesor profesor){
    this.profesores.add(profesor);
   }

   public List<Profesor> getProfesors(){
    return this.profesores;
   }

   public void agregarProfesor(Profesor profesor) { //Shit nueva
    this.profesores.add(profesor);
}



    public Asignatura(String nombreAsignatura,int claveAsignatura){
        this.claveAsignatura=claveAsignatura;
        this.nombreAsinatura=nombreAsignatura;
        this.profesores = new ArrayList<>();
    }
    
    public void setClaveAsignatura(int claveAsignatura){
        this.claveAsignatura=claveAsignatura;
    }

    public int getClaveAsignatura(){
        return this.claveAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura){
        this.nombreAsinatura=nombreAsignatura;
    }

    public String getNombreAsignatura(){
        return this.nombreAsinatura;
    }

    public static void AnadirAsignatura(){
        Asignatura nuevaAsignatura;
        System.out.println("Ingrese el nombre de la asignatura");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("Ingrese la clave de la asignatura");
        int clave = sc.nextInt();
        nuevaAsignatura = new Asignatura(nombre,clave);
        asignaturas.put(clave,nuevaAsignatura);

    }

    public static void anadir_a_lista(int clave,String materia){
        Asignatura nueva_Asignatura = new Asignatura(materia,clave);
        asignaturas.put(clave,nueva_Asignatura);
    }

    public static void imprimirAsignaturas() {
    for (Map.Entry<Integer, Asignatura> entry : asignaturas.entrySet()) {
        int clave = entry.getKey();
        String nombre = entry.getValue().getNombreAsignatura();
        System.out.println("Clave: " + clave + " |  Asignatura: "+ nombre.toString());
    }
}

public static List<Profesor> obtenerProfesoresPorClave(int claveAsignatura) {
    Asignatura asignatura = asignaturas.get(claveAsignatura);
    if (asignatura != null) {
        return asignatura.getProfesors();
    } else {
        return new ArrayList<>(); // Retorna una lista vacía si la asignatura no se encuentra
    }
}

public static String asignaturaPorClave(int claveAsignatura){
       return asignaturas.get(claveAsignatura).getNombreAsignatura();
}



 
}