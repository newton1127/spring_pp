package com.example.demo.service;
import javax.transaction.Transactional;

import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class LivreService {
    @Autowired
    private LivreRepo repo;
    public List<Livre> listAll() {

        return repo.findByOrderByTitre();
    }

    public void save(Livre livre) {
        livre.setTitre("zfzf");
        livre.setDate_sortie(new Date());
        livre. setDate_consultation(new Date());
        livre.setAuteur("zefzef");
        livre.setAvailable(true); ;


        repo.save(livre);
    }

    public Livre get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}

