package Kachou.Kacharelle3.Controler;

import Kachou.Kacharelle3.Service.EmployeService;
import Kachou.Kacharelle3.Entity.Employe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employes")
public class EmplyeControler {

    private final EmployeService employeService;

    public EmplyeControler(EmployeService employeService) {
        this.employeService = employeService;
    }

    @PostMapping
    public ResponseEntity<Employe> ajouterEmploye(@RequestBody Employe employe) {
        Employe nouvelEmploye = employeService.ajouterEmploye(employe);
        return new ResponseEntity<>(nouvelEmploye, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employe>> listerEmployes() {
        return new ResponseEntity<>(employeService.listerEmployes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> obtenirEmploye(@PathVariable Long id) {
        Optional<Employe> employe = employeService.obtenirEmploye(id);
        return employe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> modifierEmploye(@PathVariable Long id, @RequestBody Employe employe) {
        Optional<Employe> employeModifie = employeService.modifierEmploye(id, employe);
        return employeModifie.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEmploye(@PathVariable Long id) {
        boolean supprime = employeService.supprimerEmploye(id);
        return supprime
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

