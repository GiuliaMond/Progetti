package esercizioDel5;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityTransaction;

public class MainMenu {

	public static void main(String[] args) {
		try {
			AutoreDao autoreDao=new AutoreDao();
			LibroDao libroDao=new LibroDao();
			
			/* APRIAMO LA TRANSAZIONE */ 
			EntityTransaction  t=autoreDao.getEntityManager().getTransaction();
			t.begin();
			Scanner input = new Scanner(System.in);
			while(true) {
				System.out.println(" Menu: premere 0 per uscire \n     premere 1 per aggiungere autore nel database \n     premere 2 per la ricerca dell' autore nel database");
				int n=input.nextInt();
				switch(n) {
				case 1:
					Autore autore=new Autore();
					System.out.println(" nome autore:");
					String nome=input.next();
					autore.setNome(nome);
					System.out.println(" cognome autore:");
					String cognome=input.next();
					autore.setCognome(cognome);
					System.out.println(" eta autore:");
					int eta=input.nextInt();
					autore.setEta(eta);
					autoreDao.save(autore);
					System.out.println("Ho inserito su database l'autore :" +autore);
					break;
				
				case 2:
					System.out.println("Inserire nome autore da ricercare ");
					System.out.println(" nome autore:");
					String nomeAut=input.next();
					List<Autore> autoriPerNome=autoreDao.getByName(nomeAut);
					System.out.println("Ho cercato gli autori di nome "+ nomeAut +" trovato: " +autoriPerNome.size());
					if(autoriPerNome.size()>=0) {
						for(int i=0;i<autoriPerNome.size();i++ ) {
							// Attenzione .get!!!!! 
							System.out.println(autoriPerNome.get(i).toString());
						}
					}else {
						System.out.println(" no riscontri");
					}
					break;
					
				case 0:
					System.out.println("Fine");
					input.close();
					return;
				}
			}
			
			
			
			
			
			}catch (Exception e) {
				System.out.println("ERRORE! "+e.getMessage());
				e.printStackTrace();
			}

			System.out.println("Completato");

		}
}
