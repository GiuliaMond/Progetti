package esercizioDel5;

import java.util.List;

import javax.persistence.Query;

public class LibroDao extends GenericDao{
	
	public void save(Libro libro) {
		getEntityManager().persist(libro);
	}
	
	public Libro getId(int id) {
		return getEntityManager().find(Libro.class, id);
	}
	
	public List<Libro> getAll(){
		Query query=getEntityManager().createNativeQuery("select * from autore", Libro.class);
		return query.getResultList();
	}
	
	public void update(Libro libro, String nuovoTitolo) {
		libro.setTitolo(nuovoTitolo);
		getEntityManager().merge(libro);
	}
	
	public void delete(Libro libro) {
		getEntityManager().remove(libro);
	}

	public List<Autore> getByName(String titolo) {
		Query query= getEntityManager().createNativeQuery("select * from autore where nome=:parametroTitolo ");
		query.setParameter("parametroTitolo", titolo);
		
		List<Autore> libri=query.getResultList();
		return libri;
	}
}