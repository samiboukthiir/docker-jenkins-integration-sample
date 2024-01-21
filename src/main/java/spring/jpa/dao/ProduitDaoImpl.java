package spring.jpa.dao;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import spring.jpa.model.Produit;
@Repository
@Transactional
public class ProduitDaoImpl implements IProduitDao{
@PersistenceContext
private EntityManager em;


public Produit save(Produit p) {
em.persist(p);
return p;
}


public List<Produit> findAll() {
Query query= 
 em.createQuery("select p from Produit p order by p.designation");
return query.getResultList();
}


public Produit findOne(Long id) {
Produit p = em.find(Produit.class, id);
return p;
}


public Produit update(Produit p) {
em.merge(p);
return p;
}


public void delete(Long id) {
	Produit p = em.find(Produit.class, id);
	em.remove(p);
	}


	public List<Produit> findByDesignation(String mc) {
	Query query= 
	 em.createQuery("select p from Produit p where p.designation like :x");
	query.setParameter("x", "%"+mc+"%");
	return query.getResultList();
	}
	
	public List<Produit> findByDesignationAndPrix(String mc, double prix) {
	    Query query = em.createQuery("select p from Produit p where p.designation like :mc and p.prix = :prix");
	    query.setParameter("mc", "%" + mc + "%");
	    query.setParameter("prix", prix);
	    return query.getResultList();
	}

	}