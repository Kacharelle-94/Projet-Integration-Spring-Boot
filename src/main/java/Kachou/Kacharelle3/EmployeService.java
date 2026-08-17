package Kachou.Kacharelle3;

import Kachou.Kacharelle3.Entity.Employe;
import Kachou.Kacharelle3.Repository.EmployeRpository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    private final EmployeRpository employeRepository;
    public EmployeService(EmployeRpository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public Employe ajouterEmploye(Employe employe) {
        if (employe.getNom() == null || employe.getNom().isBlank()) {
            throw new IllegalArgumentException("Le nom de l'employé est obligatoire");
        }
        if (employe.getSalaire() < 0) {
            throw new IllegalArgumentException("Le salaire ne peut pas être négatif");
        }
        return employeRepository.sauvegarder(employe);
    }

    public List<Employe> listerEmployes() {
        return employeRepository.trouverTous();
    }

    public Optional<Employe> obtenirEmploye(Long id) {
        return employeRepository.trouverParId(id);
    }

    public Optional<Employe> modifierEmploye(Long id, Employe nouvellesInfos) {
        Optional<Employe> employeExistant = employeRepository.trouverParId(id);

        if (employeExistant.isPresent()) {
            Employe employe = employeExistant.get();
            employe.setNom(nouvellesInfos.getNom());
            employe.setPrenom(nouvellesInfos.getPrenom());
            employe.setPoste(nouvellesInfos.getPoste());
            employe.setSalaire(nouvellesInfos.getSalaire());
            return Optional.of(employe);
        }
        return Optional.empty();
    }

    public boolean supprimerEmploye(Long id) {
        return employeRepository.supprimer(id);
    }
}
