@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    private final PatronRepository patronRepository;

    public PatronController(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    // Retrieve a list of all patrons
    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    // Retrieve details of a specific patron by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Long id) {
        return patronRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Add a new patron to the system
    @PostMapping
    public ResponseEntity<Patron> createPatron(@RequestBody Patron patron) {
        Patron savedPatron = patronRepository.save(patron);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatron);
    }

    // Update an existing patron's information
    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @RequestBody Patron patronDetails) {
        return patronRepository.findById(id)
            .map(patron -> {
                patron.setName(patronDetails.getName());
                patron.setContactInfo(patronDetails.getContactInfo());
                Patron updatedPatron = patronRepository.save(patron);
                return ResponseEntity.ok(updatedPatron);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // Remove a patron from the system
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        return patronRepository.findById(id)
            .map(patron -> {
                patronRepository.delete(patron);
                return ResponseEntity.noContent().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
