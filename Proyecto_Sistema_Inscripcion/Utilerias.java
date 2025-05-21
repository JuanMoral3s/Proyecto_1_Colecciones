import java.util.Scanner;

public class Utilerias {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        boolean exit = true;

        while ( exit ) {
            System.out.println("------------------------------------------");
            System.out.println("| Bienvenido al Sistema de Inscripciones |");
            System.out.println("|                 INSANO                 |");
            System.out.println("------------------------------------------");
            System.out.println("| 1. Alumnos                             |");
            System.out.println("| 2. Profesores                          |");
            System.out.println("| 3. Grupos                              |");
            System.out.println("| 4. Salir                               |");
            System.out.println("------------------------------------------");
            System.out.print("Ingrese una opción: ");

            int opc = sc.nextInt();

            switch( opc ){

                case 1:
                Alumno.menu_inicio();
                break;

                case 2:
                Profesor.menu_inicio();
                break;

                case 3:
                Grupo.menu_inicio();
                break;

                case 4:
                System.out.println("|Gracias por usar el sistema de inscripciones insano|");
                exit = false;
                break;

                default:
                System.out.println("|opcion invalida intente de nuevo        |");

            }
        }
    }
}
