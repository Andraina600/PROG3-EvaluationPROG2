import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class Examens {
    private int id;
    private String titre;
    private Cours cours;
    private Instant dateEtHeure;
    private int coefficient;
}
