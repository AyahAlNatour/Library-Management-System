import java.util.List;
import java.util.Optional;

public interface PatronService {
    List<Patron> getAllPatrons();
    Optional<Patron> getPatronById(Long id);
    Patron createPatron(Patron patron);
    Optional<Patron> updatePatron(Long id, Patron patronDetails);
    void deletePatron(Long id);
}
