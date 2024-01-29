package Modelo;

import java.util.ArrayList;

import Dao.DaoItem;
import Entidad.Items;

public class ItemManager {

	private DaoItem daoItem;
	
	// Constructor de la clase. Inicializa el DaoItem y crea el fichero .dat si no existiera
	public ItemManager() {
		this.daoItem = new DaoItem();
		daoItem.createFile();
	}
	
	//ADD
	/**
	 * Método para agregar un nuevo artículo a la lista
	 * @param item
	 */
	public boolean addItem(Items item) {
		return daoItem.addItem(item);
		
	}
	
	//DELETE
	/**
	 * Método para borrar un artículo por su ID
	 * @param id
	 */
	public void deleteItem(int id) {
		daoItem.deleteItem(id);
	}
	
	// CONSULTAR POR ID
	/**
	 * Método para obtener un artículo por su ID
	 * @param id
	 * @return
	 */
	public Items toListItemById(int id) {
		return daoItem.toListItemById(id);
		
	}
	
	// LISTAR TODOS
	/**
	 * Método para obtener una lista de todos los artículos
	 * @return
	 */
	public ArrayList<Items> toListItems() {
		return daoItem.toListItems();
	}
	
	// ESCRIBIR EN FICHERO
	/**
	 * Método para escribir los artículos en el fichero .dat
	 */
	public void toWriteFile() {
		daoItem.writeFile();
	}
	
	// REQ 2
	// EXPORTAR CSV
	/**
	 * Métoto que exporta los datos de los artículos a un archivo CSV
	 * @param itemList
	 */
	public void  toExport(ArrayList<Items> itemList) {
		daoItem.toExport(itemList);
	}
	
	
	
}
