import java.time.LocalDate;

public class Enseignants extends Personne{
    private final String specialite;

    public Enseignants(int id, String nom, String prenom, LocalDate dateNaissance, String email, String numeroTelephone, String specialite) {
        super(id, nom, prenom, dateNaissance, email, numeroTelephone);
        this.specialite = specialite;
    }
}
