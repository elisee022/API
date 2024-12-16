package com.autourducode.demo.services;


import com.autourducode.demo.models.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {

    Produit creer(Produit produit);

    List<Produit> lire();

    Optional<Produit> modifier(Long id, Produit produit);

    String supprimer(Long id);

}
