package esercizioDel5;

import java.util.List;

import javax.persistence.EntityTransaction;


public class Main {

	public static void main(String[] args) {
		try {
			AutoreDao autoreDao=new AutoreDao();
			LibroDao libroDao=new LibroDao();
			
			/* APRIAMO LA TRANSAZIONE */ 
			EntityTransaction  t=autoreDao.getEntityManager().getTransaction();
			t.begin();

			//creo un oggetto Autore e lo salvo su database
			Autore autore=new Autore();
			autore.setNome("Alessandro");
			autore.setCognome("Manzoni");
			autoreDao.save(autore);
			System.out.println("Ho inserito su database l'autore :" +autore);
			
			//creo un oggetto Autore2 e lo salvo su database
			Autore autore2=new Autore();
			autore2.setNome("Dante");
			autore2.setCognome("Alighieri");
			autoreDao.save(autore2);
			System.out.println("Ho inserito su database l'autore :" +autore2);
			
			autore2.setNome("pippo"); //vedete cosa fa
			
			//cerco su database l'oggetto Autore appena inserito
			Autore autore3=autoreDao.get(1);
			System.out.println("Ho cercato l'autore su database, trovato :" +autore3);
			

			//cerco su database l'oggetto Autore per nome
			List<Autore> autoriPerNome=autoreDao.getByName("Alessandro");
			System.out.println("Ho cercato gli autori di nome pippo, trovato: " +autoriPerNome.size());
			if(autoriPerNome.size()>=0) {
				for(int i=0;i<autoriPerNome.size();i++ ) {
					// Attenzione .get!!!!! 
					System.out.println(autoriPerNome.get(i).toString());
				}
			}else {
				System.out.println(" no riscontri");
			}

			//cerco su database tutti gli autori
			List<Autore> tuttiGliAutori=autoreDao.getAll();
			System.out.println("Ho cercato tutti gli autori, trovato: " +tuttiGliAutori);
			
			//cancellare un autore
			autoreDao.delete(autore2);
			System.out.println("Ho cancellato l'autore 2 ");
			tuttiGliAutori=autoreDao.getAll();
			System.out.println("Ho cercato tutti gli autori, trovato: " +tuttiGliAutori);
			
			//creare libro
			Libro libro= new Libro();
			libro.setTitolo("divina commedia");
			libro.setAutore(autore);
			libroDao.save(libro);
			System.out.println("Ho salvato un libro: " +libro);
			
			// COMMIT DELLA TRANSAZIONE (=salvataggio su db)
			t.commit();
			
			
			
		} catch (Exception e) {
			System.out.println("ERRORE! "+e.getMessage());
			e.printStackTrace();
		}

		System.out.println("Completato");


	}
}




