# Análisis del problema — AulaLogic

**Estudiante:** Jeremy Masabanda  **Variante:** D (promedio mínimo de aprobación = 14)

## Entradas
- Opción del menú (entero 1–6).
- Código (String), nombre completo (String) y tres calificaciones (int, 0–20).
- Código a buscar (String).
- Archivo `datos/estudiantes.txt` al iniciar.

## Proceso
- Validar: código único, sin vacíos ni `;`, notas entre 0 y 20 (se repite la petición si es incorrecta).
- Calcular promedio (`(double) suma / 3`), nota máxima, nota mínima y estado (APROBADO si promedio ≥ límite).
- Buscar por código en el `ArrayList`.
- Reporte: contadores (aprobados/reprobados), acumulador (promedio general), máximo/mínimo de promedios, filtro de promedios bajo el general y ordenamiento burbuja descendente.
- Guardar con `BufferedWriter` (sobrescribe el archivo completo, sin duplicar) y leer con `BufferedReader`.

## Salida
- Menú, mensajes de validación, listado, ficha del estudiante, reporte académico y archivo `estudiantes.txt`.

## Diseño de clases
| Clase | Responsabilidad |
|---|---|
| `Estudiante` | Datos (`codigo`, `nombre`, `int[] notas`) y cálculos individuales. |
| `GestionAcademica` | `ArrayList<Estudiante>`, registro, búsqueda, listado, indicadores y ordenamiento. |
| `GestorArchivos` | `guardar()` y `cargar()` con manejo de excepciones. |
| `Main` | Menú, lectura de datos y coordinación. |

## Prueba de escritorio (promedio en el límite)
Notas 15, 14, 13 → suma = 42 → 42 / 3 = 14.0 → 14.0 ≥ 14 → **Aprobado**.
