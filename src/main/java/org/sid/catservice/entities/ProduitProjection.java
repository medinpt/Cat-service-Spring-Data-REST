package org.sid.catservice.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(name ="P1",types =Produit.class) // personnaliser/choisir des methodes
public interface ProduitProjection {
    public double getPrice();              // methodes choisies
    public String getDesignation();
}
