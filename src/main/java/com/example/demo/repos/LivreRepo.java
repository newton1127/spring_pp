package com.example.demo.repos;
import com.example.demo.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepo extends JpaRepository<Livre, Long>{
public List<Livre> findByOrderByTitre();
}
