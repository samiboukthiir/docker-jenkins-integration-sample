package spring.jpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;

import jakarta.transaction.Transactional;
import spring.jpa.model.Produit;


public interface ProduitRepository extends JpaRepository<Produit, Long>
 {
@Query ("select p from Produit p where p.designation like %:x% ")
public List<Produit> findByDesignation(@Param ("x") String mc);


@Query("update Produit p set p.designation =:designation where p.id = :id")
@Modifying
@Transactional
public int mettreAJourDesignation(
@Param("designation")String designation, 
@Param("id") Long idProduit);

List<Produit> findByPrixGreaterThan(double prixMin);

//Retourner la liste des Produits par recherche par designation
List<Produit> findByDesignationLike(String mc);

//Retourner la liste des Produits par recherche par designation
// et dont le prix est supérieur à un prix minimal
List<Produit> findByDesignationLikeAndPrixGreaterThan(String mc, double prixMin);


//1. Retourner la liste de tous les produits en ordre croissant selon le prix
List<Produit> findByOrderByPrixAsc();

// 2. Retourner la liste des produits dont la date d’achat est supérieure à une date spécifiée
List<Produit> findByDateAchatAfter(Date date);
}




