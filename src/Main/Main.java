package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Entidad.Items;
import Modelo.ItemManager;

public class Main {

	private static ItemManager im;
	
	public static void main(String[] args) {
		
		im = new ItemManager();
		menu();
		
	}
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		
		int option = 0;
		
		while (option!=6) {
			
			menuOptions();
			option = sc.nextInt();
			
			switch (option) {
			case 1: 
				addItem(sc);
				break;
			case 2: 
				deleteitem(sc);
				break;
			case 3: 
				toListItemById(sc);
				break;
			case 4:
				toListItems();
				break;
			case 5: 
				toExport();
				break;
			case 6: 
				System.out.println("Fin del programa");
				break;
				
			default:
				System.out.println("Opción incorrecta. Por favor introduzca una opción válida");
				break;
			}
		}
	}
	
	public static void menuOptions() {
		System.out.println("****** Menú gestión ******");
		System.out.println("__________________________");
		System.out.println("1.- Añadir nuevo artículo.");
		System.out.println("2.- Borrar artículo por ID.");
		System.out.println("3.- Consultar artículo por ID.");
		System.out.println("4.- Listar artículos.");
		System.out.println("5.- Exportar artículos a archivo CSV.");
		System.out.println("6.- Salir.");
		System.out.println("__________________________");
	}
		
	// Añadimos los métodos para poder introducir los datos en cada una de las opciones del menú
	
	//ADD ITEM
	
	/**
	 * Método para introducir los datos de un artículo en el menú para llamar al ItemManager y que 
	 * añada el aartículo con los datos introducidos por el usuario en una lista.
	 * 
	 * @param sc Entrada de los datos del usuario
	 */
	public static void addItem(Scanner sc) {
		
		System.out.println("Introduzca el ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Nombre: ");
		String name = sc.nextLine();
		
		System.out.println("Descripción: ");
		String description = sc.nextLine();
		
		System.out.println("Stock: ");
		int stock = sc.nextInt();
		
		System.out.println("Precio: ");
		double price = sc.nextDouble();
		
		Items item = new Items(id, name, description, stock, price);
		im.addItem(item);
	}
	
	// DELETE ITEM
	
	/**
	 * Método para introducir el id del artículo que queremos borrar de la lista mediante el ItemManager
	 * 
	 * @param sc. El usuario introduce un número entero que referencia al ID del artículo a eliminar
	 */
	public static void deleteitem(Scanner sc) {
		System.out.println("Introduzca el ID del artículo que quiere eliminar de la lista: ");
		// se introduce el ID del artículo
		im.deleteItem(sc.nextInt());
	}
	
	// CONSULTAR POR ID
	
	/**
	 * Método para listar el artículo que el usuario quiere buscar mediante la introduccion por consola
	 * de su ID.
	 * 
	 */
	
	public static void toListItemById (Scanner sc) {
		System.out.println("Introduzca el ID: ");
		int id = sc.nextInt();
		
		Items item = im.toListItemById(id);
		
		if(item == null) {
			System.out.println("No se ha encontrado el artículo");
		} else {
			System.out.println("Artículo con ID: " + id);
			System.out.println("Nombre: " + item.getName());
			System.out.println("Descripción: " +item.getDescription());
			System.out.println("Stock: " + item.getStock());
			System.out.println("Precio: " + item.getPrice());
		}
	}
	
	
	// LISTAR TODOS
	
	/**
	 * Lista todos los artículos que se encuentren en la lista por medio del ItemManager.
	 */
	
	public static void toListItems() {
		
		ArrayList<Items> items = im.toListItems();
		
		if(!items.isEmpty()) {
			System.out.println("----- Artículos -----");
			
			for ( Items item : items) {
				System.out.println("__________________________");
				System.out.println("ID -> " + item.getId());
				System.out.println("Nombre -> " + item.getName());
				System.out.println("Descripción -> " + item.getDescription());
				System.out.println("Stock -> " + item.getStock());
				System.out.println("Precio -> " + item.getPrice()+"\n");
				//System.out.println("");
			}
			
		} else {
			System.out.println("No hay datos");
		}
	}
	
	
	// REQ 2
	// EXPORTAR CSV
	
	public static void toExport() {
		if (im.toListItems().isEmpty()) {
			System.out.println("No hay datos para exportar");
		} else {
		im.toExport(im.toListItems());
		System.out.println("Datos exportados correctamente");
		}
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


