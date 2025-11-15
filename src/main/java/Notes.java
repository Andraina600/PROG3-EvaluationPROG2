import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor

public class Notes {
    private Etudiants etudiants;
    private Examens examens;
    private List<HistoriqueNotes> historiqueNotes;

    public Notes(Etudiants etudiant, Examens examen, List<HistoriqueNotes> historiqueNotes) {
        this.etudiants = etudiant;
        this.examens = examen;
        this.historiqueNotes = historiqueNotes;
    }

    public double getExamGrade(Examens examens, Etudiants etudiants, Instant t) {
        return historiqueNotes.stream()
                .filter(note -> note.getDate().isBefore(t))
                .max(Comparator.comparing(HistoriqueNotes::getDate))
                .map(HistoriqueNotes::getValeur)
                .get();
    }

    public static double getCourseGrade(Cours cours, Etudiants etudiant, List<Notes> tousLesNotsDeEtudiant, Instant t) {
        double total = 0;
        int totalCoeff = 0;

        for (Notes note : tousLesNotsDeEtudiant) {
            if (note.examens.getCours().equals(cours)) {

                double valeur = note.getExamGrade(note.getExamens(), etudiant,t);

                total += valeur * note.examens.getCoefficient();
                totalCoeff += note.examens.getCoefficient();
            }
        }
        return total / totalCoeff;
    }
}
