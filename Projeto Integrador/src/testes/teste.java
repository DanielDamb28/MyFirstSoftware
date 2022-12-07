package testes;

import model.entities.Deserializar;
import model.entities.ItemsSerializados;
import model.entities.Serializar;

public class teste {

	public static void main(String[] args) {
		Deserializar d = new Deserializar();
		ItemsSerializados item = new ItemsSerializados();
		item.setId(1);
		
		Serializar s = new Serializar();
		try {
			s.serializar("./id.obj", item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
