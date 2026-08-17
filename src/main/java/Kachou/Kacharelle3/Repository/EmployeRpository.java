package Kachou.Kacharelle3.Repository;

import Kachou.Kacharelle3.Entity.Employe;
import java.util.List;
import java.util.Optional;

public interface EmployeRpository {
    Employe sauvegarder(Employe employe);
    List<Employe> trouverTous();
    Optional<Employe> trouverParId(Long id);
    boolean supprimer(Long id);

}
