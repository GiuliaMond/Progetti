package esercizioDel5;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Query;



public class AutoreDao extends GenericDao{
	List<Autore> autori= new ArrayList <Autore>();
	public void save(Autore autore) {
		getEntityManager().persist(autore);
	}
	
	public Autore get(int id) {
		return (Autore) getEntityManager().find(Autore.class, id);
	}
	
	public List<Autore> getAll(){
		Query query=getEntityManager().createNativeQuery("select * from autore", Autore.class);
		return query.getResultList();
	}
	
	public void update(Autore autore, String nuovoNome) {
		autore.setNome(nuovoNome);
		getEntityManager().merge(autore);
	}
	
	public void delete(Autore autore) {
		getEntityManager().remove(autore);
	}

	public List<Autore> getByName(String nome) {
		Query query= getEntityManager().createNativeQuery("select * from autore where nome=:parametroNome ",Autore.class);
		query.setParameter("parametroNome", nome);
		return query.getResultList();
		
	}

}