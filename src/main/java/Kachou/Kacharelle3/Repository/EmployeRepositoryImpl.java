package Kachou.Kacharelle3.Repository;

import Kachou.Kacharelle3.Entity.Employe;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EmployeRepositoryImpl implements EmployeRpository {

    private final List<Employe> employes = new ArrayList<>();

    private final AtomicLong compteurId = new AtomicLong(1);

    @Override
    public Employe sauvegarder(Employe employe) {
        employe.setId(compteurId.getAndIncrement());
        employes.add(employe);
        return employe;
    }

    @Override
    public List<Employe> trouverTous() {
        return employes;
    }

    @Override
    public Optional<Employe> trouverParId(Long id) {
        return employes.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean supprimer(Long id) {
        return employes.removeIf(e -> e.getId().equals(id));
    }
}


