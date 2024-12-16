package com.autourducode.demo.controllers;

import com.autourducode.demo.models.Produit;
import com.autourducode.demo.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Produit")
public class ProduitController {

    @Autowired

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping("/create")
    public Produit create(@RequestBody Produit produit) {
        return produitService.creer(produit);
    }

    @GetMapping("/read")
    public List<Produit>read(){
        return produitService.lire();
    }

    @PutMapping("/update/{id}")
    public Optional<Produit> update(@PathVariable long id, @RequestBody Produit produit) {
        return produitService.modifier(id, produit);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        return produitService.supprimer(id);
    }

}

