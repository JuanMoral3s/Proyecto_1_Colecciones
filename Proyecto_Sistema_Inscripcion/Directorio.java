import javax.swing.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
/**
 * HashMaps
 */
public class Directorio {

    public static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    public static ArrayList<Profesor> profesores = new ArrayList<>();
    public static ArrayList<Grupo> grupos = new ArrayList<>();


    public static void inicializar_asignarutras(){
        List<Integer> clave = new ArrayList<Integer>();
        List<String> materias = new ArrayList<String>();
        clave.add(1120);
        clave.add(1121);
        clave.add(1123);
        clave.add(1130);
        clave.add(1122);
        clave.add(1220);
        clave.add(1221);
        clave.add(1228);
        clave.add(1124);
        clave.add(1227);
        clave.add(1317);
        clave.add(1323);
        materias.add("Algebra");//1120
        materias.add("Calculo y Geometria Analitica");//1121
        materias.add("Quimica");//1123
        materias.add("Fundamentos de fisica");//1130
        materias.add("Fundamentos de programacion");//1122
        materias.add("Algebra Lineal");//1220
        materias.add("Calculo Integral");//1221
        materias.add("Mecanica");//1228
        materias.add("Redaccion y Exposicion de Temas de ingenieria");//1124
        materias.add("Estructura de datos y algoritmos");//1227
        materias.add("Estructura de datos y algoritmos II");//1317
        materias.add("Programacion Orientada a Objetos");//1323

        for ( int i = 0 ; i < clave.size(); i++){
        Asignatura.anadir_a_lista(clave.get(i),materias.get(i));
        asignaturas.add(new Asignatura(materias.get(i),clave.get(i)));
        }

    }

    public static void inicializar_profesores() {
        int contadorInicializacion = 0;
        ArrayList<String> nombre = new ArrayList<>();
        List<ArrayList> materiasImparte = new ArrayList<>();
        nombre.add("Edgar Tista");
        nombre.add("Elba Karen");
        nombre.add("Perez Perez");
        nombre.add("Barconada");
        nombre.add("Quebrados");
        nombre.add("El Pug");
        nombre.add("Oscar Rene");
        nombre.add("El Bernal");
        nombre.add("Profe Random");
        nombre.add("Profe MasRandom");
        ArrayList<Integer> materiasTista = new ArrayList<>(Arrays.asList(1227, 1317, 1323, 1122));//Edgar Tista
        materiasImparte.add(contadorInicializacion++,materiasTista);
        ArrayList<Integer> materiasElba = new ArrayList<>(Arrays.asList(1227, 1317, 1323, 1122));//Elba Karen
        materiasImparte.add(contadorInicializacion++,materiasElba);
        ArrayList<Integer> materiasPerez = new ArrayList<>(Arrays.asList(1120, 1121, 1221, 1220));//Perez Perez
        materiasImparte.add(contadorInicializacion++,materiasPerez);
        ArrayList<Integer> materiasBarconada = new ArrayList<>(Arrays.asList(1121, 1221));//Barconada
        materiasImparte.add(contadorInicializacion++,materiasBarconada);
        ArrayList<Integer> materiasQuebrados = new ArrayList<>(Arrays.asList(1120, 1220));//Quebrados
        materiasImparte.add(contadorInicializacion++,materiasQuebrados);
        ArrayList<Integer> materiasElpug= new ArrayList<>(Arrays.asList(1228, 1221));//El pug
        materiasImparte.add(contadorInicializacion++,materiasElpug);
        ArrayList<Integer> materiasRene = new ArrayList<>(Arrays.asList(1122));//Oscar Rene
        materiasImparte.add(contadorInicializacion++,materiasRene);
        ArrayList<Integer> materiasBernal= new ArrayList<>(Arrays.asList(1130));//El Bernal
        materiasImparte.add(contadorInicializacion++,materiasBernal);
        ArrayList<Integer> materiasRandom = new ArrayList<>(Arrays.asList(1123, 1323));//Profe Random
        materiasImparte.add(contadorInicializacion++,materiasRandom);
        ArrayList<Integer> materiasRandom2 = new ArrayList<>(Arrays.asList(1124, 1228));//Profe MasRandom
        materiasImparte.add(contadorInicializacion++,materiasRandom2);

        for ( int i = 0 ; i < nombre.size(); i++) {
            Profesor.anadir_a_lista(nombre.get(i), materiasImparte.get(i));
            profesores.add(new Profesor(nombre.get(i), materiasImparte.get(i)));
        }

    }
    
    public static void inicializarGrupos(){
        ArrayList<Integer> materia = new ArrayList<>();
        ArrayList<String> profesor = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            profesor.add(profesores.get(i).getNombre());
        }
        for (int i = 0; i < profesores.size(); i++){
            materia.add(profesores.get(i).getAsignaturas().get(0));
        }
        for ( int i = 0 ; i < materia.size(); i++) {
            Grupo.anadir_a_lista(materia.get(i), profesor.get(i));
            grupos.add(new Grupo(materia.get(i),profesor.get(i)));
        }

    }
    


    
}

