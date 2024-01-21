package spring.jpa.dao;
import java.util.List;
import spring.jpa.model.Produit;
public interface IProduitDao
{
Produit save (Produit p);
List<Produit> findAll();
Produit findOne(Long id);
Produit update (Produit p);
void delete (Long id);
List<Produit> findByDesignation( String mc);
List<Produit> findByDesignationAndPrix( String mc, double prix);
}
