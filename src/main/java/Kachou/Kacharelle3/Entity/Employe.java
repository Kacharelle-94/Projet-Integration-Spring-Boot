package Kachou.Kacharelle3.Entity;

public class Employe {
    private Long id;
    private String nom;
    private String prenom;
    private String poste;
    private Double salaire;

    public Employe() {
    }

    public Employe(Long id, String nom, String prenom, String poste, Double salaire){
        this.id =id;
        this.nom =nom;
        this.prenom =prenom;
        this.poste =poste;
        this.salaire =salaire;
    }

    public Long getId(){return id;}
    public String getNom() {return nom;}
    public String getPrenom() {return prenom;}
    public String getPoste() {return poste;}
    public Double getSalaire() {return salaire;}

    public void setId(Long id) {this.id = id;}
    public void setNom(String nom) {this.nom = nom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public void setPoste(String poste) {this.poste = poste;}
    public void setSalaire(Double salaire) {this.salaire = salaire;}
}



