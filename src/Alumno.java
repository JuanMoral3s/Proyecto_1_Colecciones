import java.util.*;

public class Alumno {

    private long numero_cuenta;
    private String nombre;
    private Grupo[][] horario = new Grupo[6][7];

    private List<Integer> materiasInscritas = new ArrayList<>();
    public static Hashtable<Long,Alumno> alumnos = new Hashtable<Long,Alumno>();



    public Alumno(long numero_cuenta, String nombre) {
        this.numero_cuenta = numero_cuenta;
        this.nombre = nombre;
    }

    public long getNumero_cuenta() {
        return this.numero_cuenta;
    }

    public String getNombre() {
        return this.nombre;
    }



    public Grupo[][] getHorario() {
        return this.horario;
    }

    public void setHorario(Grupo[][] horario) {
        this.horario = horario;
    }

    public void setNombres(String nombres) {
        this.nombre = nombres;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }


    public static void menu_inicio(){
        Scanner scanner = new Scanner(System.in);
        byte eleccion_usuario;
        Alumno sesion_actual = null;
        while (sesion_actual == null) {
            do {
                System.out.println("[1]Registrarse\n[2]Iniciar Sesión");
                eleccion_usuario = scanner.nextByte();
                switch (eleccion_usuario) {
                    case 1 -> sesion_actual = registrarse();
                    case 2 -> sesion_actual = iniciar_sesion();
                    default -> System.out.println("Opcion invalida.");
                }
            } while (eleccion_usuario != 1 && eleccion_usuario != 2);
        }

        menu_Alumno(sesion_actual);

    }

    private static void menu_Alumno(Alumno alumno) {
        Scanner scanner = new Scanner(System.in);
        int eleccion_usuario;
        do {
            System.out.println("Que operacion desea realizar: ");
            System.out.println("[1] Inscribir materia\n[2] Lista de asignaturas\n[3] Lista de grupos\n[4] Terminar Sesion ");
            eleccion_usuario = scanner.nextInt();
            switch (eleccion_usuario) {
                case 1 -> alumno.inscribir_materia();
                case 2 -> Asignatura.imprimirAsignaturas();
                case 3 -> Grupo.imprimirGrupos();
                case 4 -> System.out.println("Hasta luego");
                default -> System.out.println("Opcion invalida.");
            }
            }while (eleccion_usuario != 4) ;

            }

    private void inscribir_materia() {
        Scanner scannerMateria = new Scanner(System.in);
        Scanner scannerHorario = new Scanner(System.in);
        Scanner scannerDia = new Scanner(System.in);
        System.out.println("Clave de la materia que desea inscribir: ");
        int clave = scannerMateria.nextInt();
        Grupo grupoActual = Grupo.buscadorDeGrupos(clave);
        if (grupoActual == null) {
            System.out.println("No hay grupos para la materia que desea inscribir");
            return;
        }
        System.out.println("En que horario deseas inscribir la materia?");
        System.out.println("[0]7-9 [1]9-11 [2]11-1 [3]1-3 [4]3-5 [5]5-7 [6]7-9");
        int horario = scannerHorario.nextInt();
        System.out.println("En que dia deseas inscribir la materia?");
        System.out.println("[0]Lunes [1]Martes [2]Miercoles [3]Jueves[4]Viernes [5]Sabado");
        int dia = scannerDia.nextInt();
        introducirHorario(horario,dia,grupoActual);


    }

    private void introducirHorario(int horario,int dia, Grupo grupo){
        if (this.horario[dia][horario] == null && !(this.materiasInscritas.contains(grupo.getAsignaturaImpartida()))){
            this.materiasInscritas.add(grupo.getAsignaturaImpartida());
            grupo.alumnoInscrito();
            this.setHorario(horario,dia,grupo);
            System.out.println("Horario actualizado exitosamente!");
            imprimirHorario(this.horario,grupo);
        }
        else{
            System.out.println("Ya tienes materias inscritas en este horario o ya cuentas con gurpo de esta materia");
        }
    }

    private void setHorario(int horario, int dia, Grupo grupo) {
        this.horario[horario][dia] = grupo;
    }


    private static Alumno registrarse() {
        Scanner scannerNumero = new Scanner(System.in);
        Scanner scannerNombre = new Scanner(System.in);
        Alumno nuevo_alumno;
        System.out.println("Ingrese su numero de cuenta:");
        long numero_cuenta = scannerNumero.nextLong();
        System.out.println("Ingrese su nombre empezando por apellidos:");
        String nombre = scannerNombre.nextLine();
        nuevo_alumno = new Alumno(numero_cuenta,nombre);
        alumnos.put(numero_cuenta,nuevo_alumno);
        return nuevo_alumno;
    }


    public static Alumno iniciar_sesion(){
        System.out.println("Introduzca su numero de cuenta:");
        Scanner scanner = new Scanner(System.in);
        long numero_cuenta = scanner.nextLong();
        if(alumnos.containsKey(numero_cuenta)){
            return alumnos.get(numero_cuenta);
        }
        else{
            System.out.println("El numero de cuenta no esta registrado.");
        }
        return null;

    }

    public static void imprimirHorario(Grupo[][] horario,Grupo grupo) {
        for (int i = 0; i < horario.length; i++) {
            for (int k = 0; k < horario[i].length; k++) {
                if (horario[i][k] == null){
                    System.out.printf("%15s" , "  ---  ");
                }
                else {
                    System.out.printf("%15s", Asignatura.asignaturaPorClave(horario[i][k].getAsignaturaImpartida()) + " Grupo: " + grupo.getNumeroDeGrupo());
                }
            }
            System.out.println();
        }
    }



}