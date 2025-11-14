import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor

public class Cours {
    private  int id;
    private String label;
    private int credit;
    private Enseignants enseignant;
}
