package org.sid.catservice;

import org.sid.catservice.Repository.ProduitRepository;
import org.sid.catservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")                                     // pour la partie frontend , autoriser l'accés à cette API à travers n'importe quel nom de domaine .
@RestController                                       //  Creer le WS REST
public class ProduitRestController {

    @Autowired                                        // Injecter l'independance
    private ProduitRepository produitRepository ;

    @GetMapping("/list")
    public List<Produit> ListProduits(){
        return produitRepository.findAll(); }
    @GetMapping("/list/{id}")
    public Produit ListProduits(@PathVariable(name="id") Long id ){
        return produitRepository.findById(id).get(); }
    @PutMapping("/list/{id}")
    public Produit UpdateProduits(@PathVariable(name="id") Long id , @RequestBody Produit p){
        p.setId(id);
        return produitRepository.save(p); }
    @PostMapping ("/list")
    public Produit save( @RequestBody Produit p){
        return produitRepository.save(p); }
    @DeleteMapping ("/list/{id}")
    public void delete(@PathVariable(name="id") Long id ) {
        produitRepository.deleteById(id);
        }




}
