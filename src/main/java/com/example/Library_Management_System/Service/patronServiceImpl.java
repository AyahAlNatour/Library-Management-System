@Service
@Transactional
public class PatronServiceImpl implements PatronService {

    private final PatronRepository patronRepository;

    public PatronServiceImpl(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    @Override
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    @Override
    public Optional<Patron> getPatronById(Long id) {
        return patronRepository.findById(id);
    }

    @Override
    public Patron createPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    @Override
    public Optional<Patron> updatePatron(Long id, Patron patronDetails) {
        return patronRepository.findById(id).map(existingPatron -> {
            existingPatron.setName(patronDetails.getName());
            existingPatron.setContactInfo(patronDetails.getContactInfo());
            return patronRepository.save(existingPatron);
        });
    }

    @Override
    public void deletePatron(Long id) {
        patronRepository.findById(id).ifPresent(patronRepository::delete);
    }
}
