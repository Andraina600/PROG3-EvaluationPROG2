import java.time.LocalDate;
import lombok.Getter;
@Getter

public class Etudiants extends Personne {
    private final String groupe;
    private final Tuteurs tuteurs;

    public Etudiants(int id, String nom, String prenom, LocalDate dateNaissance, String email, String numeroTelephone, String groupe, Tuteurs tuteurs) {
        super(id, nom, prenom, dateNaissance, email, numeroTelephone);
        this.groupe = groupe;
        this.tuteurs = tuteurs;
    }
}
