@RestController
@RequestMapping("/api/borrow")
public class BorrowingController {
    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;

    public BorrowingController(BorrowingRecordRepository borrowingRecordRepository,
                               BookRepository bookRepository,
                               PatronRepository patronRepository) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }

    @PostMapping("/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        Optional<Book> book = bookRepository.findById(bookId);
        Optional<Patron> patron = patronRepository.findById(patronId);

        if (book.isPresent() && patron.isPresent()) {
            BorrowingRecord record = new BorrowingRecord();
            record.setBook(book.get());
            record.setPatron(patron.get());
            record.setBorrowDate(LocalDate.now());
            BorrowingRecord savedRecord = borrowingRecordRepository.save(record);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        Optional<BorrowingRecord> record = borrowingRecordRepository.findByBookIdAndPatronId(bookId, patronId);

        if (record.isPresent()) {
            BorrowingRecord borrowingRecord = record.get();
            borrowingRecord.setReturnDate(LocalDate.now());
            BorrowingRecord updatedRecord = borrowingRecordRepository.save(borrowingRecord);
            return ResponseEntity.ok(updatedRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
