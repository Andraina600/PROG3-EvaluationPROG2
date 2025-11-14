import java.time.LocalDate;

public class Tuteurs extends Personne{
    private final String description;

    public Tuteurs(int id, String nom, String prenom, LocalDate dateNaissance, String email, String numeroTelephone, String description) {
        super(id, nom, prenom, dateNaissance, email, numeroTelephone);
        this.description = description;
    }
}
