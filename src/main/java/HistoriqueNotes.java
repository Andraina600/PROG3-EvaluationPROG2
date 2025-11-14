import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor

public class HistoriqueNotes {
    private double valeur;
    private String motif;
    private final Instant date;
}
