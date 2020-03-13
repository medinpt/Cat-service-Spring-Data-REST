package org.sid.catservice.Repository;

import org.sid.catservice.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource                                                                          // creer le WS Rest

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    @RestResource(path = "/recherche")                                                           //Ajouter la methode list<Produit>
    public List<Produit> findByDesignationContains(@Param("mc") String des);                     // Recherche par mot cle
    }



