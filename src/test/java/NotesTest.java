import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class NotesTest {

    @Test
    void getExamGrade() {
        Etudiants etu = new Etudiants(
                1, "Jean", "Marc",
                LocalDate.of(2000, 1, 1),
                "jean@mail.com", "123456", "G1",
                new Tuteurs(10, "Tuteur", "Paul", LocalDate.of(1980, 1, 1),
                        "t@mail.com", "555", "Parent"
                )
        );

        Enseignants ens = new Enseignants(
                2, "Rakoto", "Letie", LocalDate.of(1985, 1, 1),
                "rakoto@mail.com", "111", "Maths"
        );

        Cours cours = new Cours(1, "MATH", 4, ens);
        Examens exam = new Examens(1, "Exam 1", cours, Instant.now(), 2);

        Instant t1 = Instant.parse("2024-01-01T10:00:00Z");
        Instant t2 = Instant.parse("2024-01-02T10:00:00Z");
        Instant t3 = Instant.parse("2024-01-03T10:00:00Z");

        Notes notes = new Notes(
                etu,
                exam,
                List.of(
                        new HistoriqueNotes(12.0, "initiale", t1),
                        new HistoriqueNotes(14.0, "correction", t2)
                )
        );
        double result = notes.getExamGrade(t3);
        assertEquals(14.0, result);
    }

    @Test
    void getCourseGrade() {
        Etudiants etu = new Etudiants(
                1, "Jean", "Paul",
                LocalDate.of(2000, 1, 1),
                "jean@mail.com", "123456", "G1",
                new Tuteurs(10, "Tuteur", "X", LocalDate.of(1980, 1, 1),
                        "t@mail.com", "555", "Parent"
                )
        );

        Enseignants ens = new Enseignants(
                2, "Benja", "Benoit", LocalDate.of(1985, 1, 1),
                "benja@mail.com", "111", "PROG"
        );

        Cours prog2 = new Cours(1, "PROG2", 5, ens);

        Instant t = Instant.parse("2024-01-05T00:00:00Z");

        Examens exam1 = new Examens(1, "Exam 1", prog2, Instant.now(), 2);
        Examens exam2 = new Examens(2, "Exam 2", prog2, Instant.now(), 3);

        Notes noteExam1 = new Notes(
                etu,
                exam1,
                List.of(
                        new HistoriqueNotes(10.0, "initial", Instant.parse("2024-01-01T00:00:00Z"))
                )
        );

        Notes noteExam2 = new Notes(
                etu,
                exam2,
                List.of(
                        new HistoriqueNotes(15.0, "initial", Instant.parse("2024-01-02T00:00:00Z"))
                )
        );

        List<Notes> allNotes = List.of(noteExam1, noteExam2);

        double result = Notes.getCourseGrade(prog2, etu, allNotes, t);
        assertEquals(13.0, result);
    }
}