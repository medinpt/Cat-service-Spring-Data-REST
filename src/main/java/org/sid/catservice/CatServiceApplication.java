package org.sid.catservice;

import org.sid.catservice.Repository.ProduitRepository;
import org.sid.catservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {
    @Autowired
    private ProduitRepository produitRepository ;

    @Autowired
   private RepositoryRestConfiguration restConfiguration ;     // pour l'affichage des Ids

    public static void main(String[] args) {
        SpringApplication.run(CatServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        restConfiguration.exposeIdsFor(Produit.class);         // pour l'affichage des Ids

        produitRepository.save(new Produit(null,"Ordinateur", 23,34));
        produitRepository.save(new Produit(null,"Imprimante ", 28,4));
        produitRepository.save(new Produit(null,"tablette", 983,39));

        produitRepository.findAll().forEach(produit -> {
            System.out.println(produit.toString());
        });

    }
}
