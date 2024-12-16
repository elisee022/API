package com.autourducode.demo.services;

import com.autourducode.demo.models.Produit;
import com.autourducode.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitSerivceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    // Injection explicite du produitRepository via le constructeur
    @Autowired
    public ProduitSerivceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit creer(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> lire() {
        return produitRepository.findAll();
    }

    @Override
    public Optional<Produit> modifier(Long id, Produit produit) {
        return Optional.ofNullable(produitRepository.findById(id)
                .map(p -> {
                    produit.setNom(produit.getNom());
                    produit.setDescription(produit.getDescription());
                    produit.setPrix(produit.getPrix());
                    return produitRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Produit avec l'ID " + id + " non trouvé")));
    }

    @Override
    public String supprimer(Long id) {
        produitRepository.deleteById(id);
        return "Produit supprimé";
    }
}
