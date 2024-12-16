package com.autourducode.demo.repository;

import com.autourducode.demo.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    // Vous pouvez ajouter ici des méthodes personnalisées si nécessaire
}