package Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Entidad.Items;

public class DaoItem {
	
	
	private static final String FILE = "items.dat";
	private static final String CSV_FILE = "items.csv";
	private ArrayList<Items> items;
	
	// Constructor de la clase. Carga los items desde el archivo si este estuviera ya creado
	public DaoItem() {
		this.items = new ArrayList<>();
		loadData(); 
 	}
	
	/**
	 * Método para crear un nuevo fichero si no existiese dicho fichero
	 */
	
	public void createFile() {
		
		File file = new File(FILE);
		
		if(!file.exists()) {
			try {
				if(file.createNewFile()) {
					System.out.println("Fichero creado");
				} else {
					System.out.println("Error al crear el fichero");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { 
			System.out.println("Archivo cargado.");
		}
	}
	
	//ADD, DELETE, CONSULTAR POR ID,  CONSULTAR TODOS
	
	// ADD 
	/**
	 * Añade un artículo a la lista a traves de un objeto Item. Comprueba si exte existe por su id y, si 
	 * no existe, lo añade a la lista. En caso contrario, nos informará de que ese artñiculo ya existe en la
	 * lista
	 * @param item
	 * @return True si añade el articulo a la lista. False en caso contrario.
	 */
	public boolean addItem(Items item) {
		if(!itemExists(item.getId())) {
			items.add(item);
			System.out.println("El item con id: " + item.getId() + "se ha añadido");
			return true;
		}else {
			System.out.println("El item con id: " + item.getId() + "ya se encuentra en la lista");
			return false;
		}
		
	}
	
	// DELETE by ID
	/**
	 * Método para eliminar un articulo de la lista por su id
	 * @param id
	 */
	public void deleteItem(int id) {
		Items deleteItem = null;
		for(Items aux : items) {
			if(aux.getId() == id) {
				deleteItem = aux;
				break;
			}
		}
		if(deleteItem != null) {
			items.remove(deleteItem);
			System.out.println("El Artículo con id: " + id + " ha sido eliminado");
		} else {
			System.out.println("No se encontró el artículo");
		}
	}
	
	// CONSULTAR ITEM POR ID
	/**
	 * Método para consultar un artículo por su id
	 * 
	 * @param id del artículo
	 * @return Si encuentra el artículo por el ID, devuelve el objeto. En caso contrario, 
	 * devuelve null
	 */
	
	public Items toListItemById (int id) {
		for (Items item : items) {
			if(item.getId() == id) {
				return item;
			}
		}
		return null;
		
		
	}
	
	// LISTAR ITEMS
	/**
	 * Lista todos los artículos de la lista
	 */
	
	public ArrayList<Items> toListItems() {
		return items;
		
	}
	
	// Métodos para cargar los datos en el constructor en caso de que exista el archivo con dicho nombre
	
	public void loadData() {
		try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(FILE))) {
			
			while(true)  {
				try {
					Items item = (Items) oos.readObject();
					items.add(item);
				} catch (Exception e) {
					break;
				}
			}
		}  catch (FileNotFoundException e) {
			System.out.println("El fichero " + FILE + " no existe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * Método para comprobar si un item existe en la lista por su id
	 * @param id
	 * @return Si el artículo existe en la lista, nos devuelve true.En caso 
	 * contrario, false.
	 */
	
	public boolean itemExists(int id) {
		for(Items item : items) {
			if(item.getId() == id) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Método para escribir los artículos dentro del archivo creado o ya existente.
	 */
	
	public void writeFile () {
		try (ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(FILE))) {
			for (Items item : items) {
				objectOutput.writeObject(item);
			}
			System.out.println("Los artículos se han añadido correctamente");
		} catch (IOException e) {
			System.out.println("Error al añadir artículos al fichero");
			e.printStackTrace();
		}
	}
	
	
	// REQ 2
	/**
	 * Método que exporta los datos de los artículos de la lista a un archivo CSV
	 * @param toListItems
	 */
	public void toExport (ArrayList<Items> toListItems) {
		try (FileWriter fw = new FileWriter(CSV_FILE)) {
			
			fw.append("ID - Nombre - Descepción - Stock - Precio\n");
			
			for(Items item : toListItems) {
				fw.append(String.valueOf(item.getId()));
				fw.append("-");
				fw.append(String.valueOf(item.getName()));
				fw.append("-");
				fw.append(String.valueOf(item.getDescription()));
				fw.append("-");
				fw.append(String.valueOf(item.getStock()));
				fw.append("-");
				fw.append(String.valueOf(item.getPrice()));
				fw.append("-");
			}
			System.out.println("Los datos se han exportado correctamente.");
		} catch (IOException e) {
			System.out.println("Error al exportar los datos.");
			e.printStackTrace();
		}
	}
	
	
	

}
