import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorArchivos {

    // Escribe TODOS los estudiantes en el archivo (reemplaza el contenido, no duplica)
    public boolean guardar(ArrayList<Estudiante> lista, String ruta) {
        new File("datos").mkdir(); // crea la carpeta datos si no existe
        BufferedWriter escritor = null;
        try {
            escritor = new BufferedWriter(new FileWriter(ruta));
            for (int i = 0; i < lista.size(); i++) {
                Estudiante e = lista.get(i);
                int[] n = e.getNotas();
                escritor.write(e.getCodigo() + ";" + e.getNombre() + ";" + n[0] + ";" + n[1] + ";" + n[2]);
                escritor.newLine();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("Error al guardar el archivo: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (escritor != null) {
                    escritor.close();
                }
            } catch (IOException ex) {
                System.out.println("Error al cerrar el archivo.");
            }
        }
    }

    // Lee el archivo y devuelve la lista de estudiantes
    public ArrayList<Estudiante> cargar(String ruta) {
        ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
        File archivo = new File(ruta);

        if (!archivo.exists()) {
            System.out.println("Archivo no encontrado. Se inicia con una lista vacia.");
            return lista;
        }

        BufferedReader lector = null;
        try {
            lector = new BufferedReader(new FileReader(archivo));
            String linea = lector.readLine();
            while (linea != null) {
                String[] partes = linea.split(";"); // separa por punto y coma
                if (partes.length == 5) {
                    try {
                        int[] notas = new int[3];
                        notas[0] = Integer.parseInt(partes[2]);
                        notas[1] = Integer.parseInt(partes[3]);
                        notas[2] = Integer.parseInt(partes[4]);
                        lista.add(new Estudiante(partes[0], partes[1], notas));
                    } catch (NumberFormatException ex) {
                        System.out.println("Linea con notas invalidas, se omite: " + linea);
                    }
                } else {
                    System.out.println("Linea con formato incorrecto, se omite: " + linea);
                }
                linea = lector.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
        } finally {
            try {
                if (lector != null) {
                    lector.close();
                }
            } catch (IOException ex) {
                System.out.println("Error al cerrar el archivo.");
            }
        }
        return lista;
    }
}
