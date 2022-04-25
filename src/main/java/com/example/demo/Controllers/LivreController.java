package com.example.demo.Controllers;

import com.example.demo.entities.Livre;
import com.example.demo.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RequestMapping("/emsi_api")
@RestController
public class LivreController {
    @Autowired
    private LivreService service;


    // RESTful API methods for Retrieval operations
    @GetMapping("/livres")
    public List<Livre> list() {
        System.out.println("testtest");
        return service.listAll();
    }
    @GetMapping("/livres/{id}")
    public ResponseEntity<Livre> get(@PathVariable Long id) {
        try {
            Livre livre = service.get(id);
            return new ResponseEntity<Livre>(livre, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Livre>(HttpStatus.NOT_FOUND);
        }
    }
    // RESTful API method for Create operation
    @PostMapping("/addlivres")
    public void add(@RequestBody Livre livre) {
        service.save(livre);
    }

    // RESTful API method for Update operation
    @PutMapping("/updateLivres/{id}")
    public ResponseEntity<?> update(@RequestBody Livre livre, @PathVariable Long id) {
        try {
            Livre exist = service.get(id);
            service.save(livre);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // RESTful API method for Delete operation
    @DeleteMapping("/deleteLivres/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
