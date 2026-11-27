import java.util.Scanner;

public class Main {
    static final String RUTA = "datos/estudiantes.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GestorArchivos gestor = new GestorArchivos();
        GestionAcademica gestion = new GestionAcademica();
        gestion.setEstudiantes(gestor.cargar(RUTA)); // recupera los datos al iniciar

        int opcion = 0;
        while (opcion != 6) {
            mostrarMenu();
            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    registrar(gestion);
                    break;
                case 2:
                    gestion.listar();
                    break;
                case 3:
                    buscar(gestion);
                    break;
                case 4:
                    gestion.generarReporte();
                    break;
                case 5:
                    if (gestor.guardar(gestion.getEstudiantes(), RUTA)) {
                        System.out.println("Registros guardados correctamente.");
                    }
                    break;
                case 6:
                    gestor.guardar(gestion.getEstudiantes(), RUTA);
                    System.out.println("Registros guardados. Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion incorrecta. Intente de nuevo.");
            }
        }
    }

    static void mostrarMenu() {
        System.out.println("=====================================");
        System.out.println(" SISTEMA AULALOGIC");
        System.out.println("=====================================");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Buscar estudiante");
        System.out.println("4. Generar reporte academico");
        System.out.println("5. Guardar registros");
        System.out.println("6. Salir");
        System.out.println("=====================================");
        System.out.print("Seleccione una opcion: ");
    }

    // Lee un numero entero; si escriben letras devuelve -1 (opcion incorrecta)
    static int leerEntero() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Pide texto hasta que no este vacio y no tenga punto y coma
    static String leerTexto(String mensaje) {
        String texto = "";
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty() || texto.contains(";")) {
                System.out.println("Dato invalido: no puede estar vacio ni tener ';'.");
            } else {
                valido = true;
            }
        }
        return texto;
    }

    // Pide una nota hasta que este entre 0 y 20
    static int leerNota(int numero) {
        int nota = -1;
        while (nota < 0 || nota > 20) {
            System.out.print("Calificacion " + numero + " (0-20): ");
            nota = leerEntero();
            if (nota < 0 || nota > 20) {
                System.out.println("Nota incorrecta. Debe ser un entero entre 0 y 20.");
            }
        }
        return nota;
    }

    static void registrar(GestionAcademica gestion) {
        String codigo = leerTexto("Codigo del estudiante: ");
        if (gestion.existeCodigo(codigo)) {
            System.out.println("Error: el codigo ya existe. No se registro el estudiante.");
            return;
        }
        String nombre = leerTexto("Nombre completo: ");
        int[] notas = new int[3];
        for (int i = 0; i < 3; i++) {
            notas[i] = leerNota(i + 1);
        }
        gestion.registrar(new Estudiante(codigo, nombre, notas));
        System.out.println("Estudiante registrado correctamente.");
    }

    static void buscar(GestionAcademica gestion) {
        System.out.print("Codigo a buscar: ");
        String codigo = sc.nextLine().trim();
        Estudiante e = gestion.buscarPorCodigo(codigo);
        if (e == null) {
            System.out.println("No existe un estudiante con el codigo " + codigo + ".");
        } else {
            gestion.mostrarDetalle(e);
        }
    }
}
