package com.techlab.articulo;
import java.util.Scanner;
import java.util.ArrayList;
import com.techlab.articulo.model.*;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Articulo> articulos = new ArrayList<>();
        ArrayList<Categoria> categorias = new ArrayList<>();

        //Precargar categorias
        precargarCategorias(categorias);

        //Para visualizar el menu principal y permitir al usuario elegir una opción
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    //Ingresar artículo
                    ingresarArticulo(scanner, articulos, categorias);
                    break;
                case 2:
                    //Listar artículos
                    listarArticulos(articulos);
                    break;
                case 3:
                    //Consultar un artículo
                    consultarArticulo(scanner, articulos);
                    break;
                case 4:
                    //Modificar un artículo
                    modificarArticulo(scanner, articulos);
                    break;
                case 5:
                    //Eliminar un artículo
                    eliminarArticulo(scanner, articulos);
                    break;
                case 6:
                    //Listar categorías
                    listarCategorias(categorias);
                    break;
                }
        }while (opcion != 0);
    }

    //Metodo para precargar categorias
    public static void precargarCategorias(ArrayList<Categoria> categorias) {
            categorias.add(new Categoria(1, "Electrónica", "Productos tecnológicos y electrónicos"));
            categorias.add(new Categoria(2, "Perifericos", "Accesorios para computadora"));
            categorias.add(new Categoria(3, "Alimentos", "Artículos alimenticios"));
            categorias.add(new Categoria(4, "Limpieza", "Productos de limpieza y cuidado del hogar"));
        }

    //Metodo para mostrar el menu principal
    public static void mostrarMenuPrincipal() {
        System.out.println("======================================================");
        System.out.println("SISTEMA DE ARTÍCULOS - CLASE 4 (HERENCIA Y TO_STRING)");
        System.out.println("======================================================");
        System.out.println("1 - Ingresar artículo");
        System.out.println("2 - Listar artículos");
        System.out.println("3 - Consultar un artículo");
        System.out.println("4 - Modificar un artículo");
        System.out.println("5 - Eliminar un artículo");
        System.out.println("6 - Listar categorías");
        System.out.println("0 - Salir");
        System.out.println("======================================================");
        System.out.print("Ingrese una opción: ");
     }

     //Metodo para mostrar el menu de ingreso del tipo de articulo
        public static void mostrarMenuTipoArticulo() {
            System.out.println("======================================================");
            System.out.println("TIPO DE ARTÍCULO");
            System.out.println("======================================================");
            System.out.println("1 - Artículo Alimenticio");
            System.out.println("2 - Artículo Electrónico");
            System.out.println("======================================================");
            System.out.print("Seleccione el tipo de articulo: ");
        }

        //Metodo para verificar que el codigo ingresado sea unico
        public static Boolean verificarCodigoUnico(int codigo, ArrayList<Articulo> articulos) {
            for (Articulo articulo : articulos) {
                if (articulo.getCodigo() == codigo) {
                    System.out.println("El código ingresado ya existe. Por favor, ingrese un código único.");
                    return false;
                }
            }
            return true;
        }

        //Metodo para validar que la categoria ingresada sea valida
        public static Boolean validarCategoria(int codigoCategoria, ArrayList<Categoria> categorias) {
            for (Categoria categoria : categorias) {
                if (categoria.getCodigo() == codigoCategoria) {
                    return true;
                }
            }
            System.out.println("Categoría no válida. Por favor, ingrese un código de categoría válido.");
            return false;
        }

        //Metodos auxiliares para verificar la integridad de los datos ingresados
        public static int leerEntero(Scanner scanner, String mensaje) {
            System.out.print(mensaje);
            String numero = scanner.nextLine();
            try {
                return Integer.parseInt(numero);
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                return leerEntero(scanner, mensaje);
            }
        }

        public static int leerEnteroNoNegativo(Scanner scanner, String mensaje) {
            System.out.print(mensaje);
            String numero = scanner.nextLine();
            try {
                int valor = Integer.parseInt(numero);
                if (valor < 0) {
                    System.out.println("Error: Ingrese un número entero no negativo.");
                    return leerEnteroNoNegativo(scanner, mensaje);
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                return leerEnteroNoNegativo(scanner, mensaje);
            }
        }

        public static Double leerDoubleNoNegativo(Scanner scanner, String mensaje) {
            System.out.print(mensaje);
            String numero = scanner.nextLine();
            try {
                Double valor = Double.parseDouble(numero);
                if (valor < 0) {
                    System.out.println("Error: Ingrese un número no negativo.");
                    return leerDoubleNoNegativo(scanner, mensaje);
                }else if (valor.isNaN() || valor.isInfinite()) {
                    System.out.println("Error: Ingrese un número mayor a cero.");
                    return leerDoubleNoNegativo(scanner, mensaje);
                }else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
                return leerDoubleNoNegativo(scanner, mensaje);
            }
        }

        public static String leerTextoNoVacio(Scanner scanner, String mensaje) {
            System.out.print(mensaje);
            String texto = scanner.nextLine();
            if (texto.trim().isEmpty()) {
                System.out.println("Error: Ingrese un texto no vacío.");
                return leerTextoNoVacio(scanner, mensaje);
            } else {
                return texto;
            }
        }

        // Verificar si el código ya existe en la lista de artículos
        public static boolean esCodigoUnicoArticulo(int codigo, ArrayList<Articulo> articulos) {
            if (articulos.isEmpty()) {
                return true; // Si no hay artículos, el código es único
            }

            for (Articulo articulo : articulos) {
                if (articulo.getCodigo() == codigo) {
                    return false;
                }
            }
            return true;
        }

        //Metodo para ingresar un articulo
        public static void ingresarArticulo(Scanner scanner, ArrayList<Articulo> articulos, ArrayList<Categoria> categorias) {
            
            //Muestro el menu de tipos de articulos y uso un while para validar la opción ingresada
            mostrarMenuTipoArticulo();
            int tipoArticulo = leerEntero(scanner, "Seleccione el tipo de articulo: ");

            while (tipoArticulo != 1 && tipoArticulo != 2) {
                System.out.println("Tipo de artículo no válido.Ingrese una opción válida.");
                tipoArticulo = leerEntero(scanner, "Seleccione el tipo de articulo: ");
            }

            int codigo = leerEntero(scanner, "Ingrese el código del artículo: ");

            // Verificar que el código sea único
            while (!esCodigoUnicoArticulo(codigo, articulos)) {
                codigo = leerEntero(scanner, "Ingrese un código único para el artículo: ");
            }

            //Ingreso el nombre del artículo y valido que no esté vacío
            String nombre = leerTextoNoVacio(scanner, "Ingrese el nombre del artículo: ");

            //Ingreso el precio del artículo y valido que sea un número positivo
            double precio = leerDoubleNoNegativo(scanner, "Ingrese el precio del artículo: ");
            
            // Mostrar las categorías disponibles
            System.out.println("Seleccione la categoría del artículo:");
            for (Categoria categoria : categorias) {
                System.out.println(categoria.getCodigo() + " - " + categoria.getNombre());
            }
            int codigoCategoria = leerEntero(scanner, "Ingrese el código de la categoría: ");

            while (!validarCategoria(codigoCategoria, categorias)) {
                System.out.print("Ingrese un código de categoría válido: ");
                codigoCategoria = leerEntero(scanner, "Ingrese un código de categoría válido: ");
            }

            // Obtener la categoría seleccionada
            Categoria categoriaSeleccionada = null;
            for (Categoria categoria : categorias) {
                if (categoria.getCodigo() == codigoCategoria) {
                    categoriaSeleccionada = categoria;
                    break;
                }
            }

            if (tipoArticulo == 1) { // Artículo Alimenticio
                System.out.print("Ingrese los días para vencimiento: ");
                int diasParaVencimiento = leerEnteroNoNegativo(scanner, "Ingrese los días para vencimiento: ");

                ArticuloAlimenticio articuloAlimenticio = new ArticuloAlimenticio(codigo, nombre, precio, categoriaSeleccionada, diasParaVencimiento);
                articulos.add(articuloAlimenticio);
                System.out.println("Artículo alimenticio ingresado correctamente.");
                System.out.println("Articulo creado: " + articuloAlimenticio.toString());

            } else if (tipoArticulo == 2) { // Artículo Electrónico
                System.out.print("Ingrese la garantía en meses: ");
                int garantiaMeses = leerEnteroNoNegativo(scanner, "Ingrese la garantía en meses: ");

                ArticuloElectronico articuloElectronico = new ArticuloElectronico(codigo, nombre, precio, categoriaSeleccionada, garantiaMeses);
                articulos.add(articuloElectronico);
                System.out.println("Artículo electrónico ingresado correctamente.");
                System.out.println("Articulo creado: " + articuloElectronico.toString());
            } else {
                System.out.println("Tipo de artículo no válido. El artículo no se ingresará.");
            }
        }

        //Metodo para listar articulos
        public static void listarArticulos(ArrayList<Articulo> articulos) {
            if (articulos.isEmpty()) {
                System.out.println("No hay artículos cargados.");
            } else {
                System.out.println("======================================================");
                System.out.println("Listado de artículos:");
                System.out.println("======================================================");
                for (Articulo articulo : articulos) {
                    System.out.println(articulo.toString());
                    System.out.println("------------------------------------------------------");
                }
            }
        }

        //Metodo que buscar un articulo por su codigo y devuelve el articulo encontrado o null si no lo encuentra
        public static Articulo buscarArticuloPorCodigo(int codigo, ArrayList<Articulo> articulos) {
            for (Articulo articulo : articulos) {
                if (articulo.getCodigo() == codigo) {
                    return articulo;
                }
            }
            return null; // Retorna null si no se encuentra el artículo
        }

        //Metodo para consultar un articulo
        public static void consultarArticulo(Scanner scanner, ArrayList<Articulo> articulos) {

            //Verifico si hay articulos cargados, si no hay, muestro un mensaje y retorno
            if (articulos.isEmpty()) {
                System.out.println("No hay artículos cargados.");
                return;
            }
            System.out.print("Ingrese el código del artículo a consultar: ");
            int codigo = leerEntero(scanner, "Ingrese el código del artículo a consultar: ");

            Articulo articuloEncontrado = null;
            articuloEncontrado = buscarArticuloPorCodigo(codigo, articulos);

            if (articuloEncontrado != null) {
                System.out.println("Artículo encontrado:");
                System.out.println(articuloEncontrado.toString());
                System.out.println(articuloEncontrado.getDetalleEspecifico());
            } else {
                System.out.println("El artículo ingresado no existe.");
            }
        }
     
        //Metodo para modificar un articulo
        public static void modificarArticulo(Scanner scanner, ArrayList<Articulo> articulos) {
            //Verifico si hay articulos cargados, si no hay, muestro un mensaje y retorno
            if (articulos.isEmpty()) {
                System.out.println("No hay artículos cargados.");
                return;
            }
            System.out.print("Ingrese el código del artículo a modificar: ");
            int codigo = leerEntero(scanner, "Ingrese el código del artículo a modificar: ");

            Articulo articuloEncontrado = buscarArticuloPorCodigo(codigo, articulos);

            if (articuloEncontrado != null) {
                System.out.println("Artículo encontrado:");
                System.out.println(articuloEncontrado.toString());

                //Solicito los nuevos datos del artículo
                System.out.print("Ingrese el nuevo nombre del artículo: ");
                String nuevoNombre = leerTextoNoVacio(scanner, "Ingrese el nuevo nombre del artículo: ");
                articuloEncontrado.setNombre(nuevoNombre);

                System.out.print("Ingrese el nuevo precio del artículo: ");
                double nuevoPrecio = leerDoubleNoNegativo(scanner, "Ingrese el nuevo precio del artículo: ");
                articuloEncontrado.setPrecio(nuevoPrecio);

                //Si es un articulo alimenticio, solicito los dias para vencimiento
                if (articuloEncontrado instanceof ArticuloAlimenticio) {
                    System.out.print("Ingrese los nuevos días para vencimiento: ");
                    int nuevosDiasParaVencimiento = leerEnteroNoNegativo(scanner, "Ingrese los nuevos días para vencimiento: ");
                    ((ArticuloAlimenticio) articuloEncontrado).setDiasParaVencimiento(nuevosDiasParaVencimiento);
                }

                //Si es un articulo electronico, solicito la garantia en meses
                if (articuloEncontrado instanceof ArticuloElectronico) {
                    System.out.print("Ingrese la nueva garantía en meses: ");
                    int nuevaGarantiaMeses = leerEnteroNoNegativo(scanner, "Ingrese la nueva garantía en meses: ");
                    ((ArticuloElectronico) articuloEncontrado).setGarantiaMeses(nuevaGarantiaMeses);
                }

                System.out.println("Artículo modificado correctamente.");
            } else {
                System.out.println("El artículo ingresado no existe.");
            }
        }

        //Metodo para eliminar un articulo por su codigo
        public static void eliminarArticulo(Scanner scanner, ArrayList<Articulo> articulos) {
            //Verifico si hay articulos cargados, si no hay, muestro un mensaje y retorno
            if (articulos.isEmpty()) {
                System.out.println("No hay artículos cargados.");
                return;
            }
            System.out.print("Ingrese el código del artículo a eliminar: ");
            int codigo = leerEntero(scanner, "Ingrese el código del artículo a eliminar: ");

            Articulo articuloEncontrado = buscarArticuloPorCodigo(codigo, articulos);

            if (articuloEncontrado != null) {
                articulos.remove(articuloEncontrado);
                System.out.println("Artículo eliminado correctamente.");
            } else {
                System.out.println("El artículo ingresado no existe.");
            }
        }

        //Metodo para listar categorias
        public static void listarCategorias(ArrayList<Categoria> categorias) {
            if (categorias.isEmpty()) {
                System.out.println("No hay categorías cargadas.");
            } else {
                System.out.println("======================================================");
                System.out.println("Listado de categorías:");
                System.out.println("======================================================");
                for (Categoria categoria : categorias) {
                    System.out.println(categoria.toString());
                    System.out.println("----------------------------------------------------");
                }
            }
        }
    }
