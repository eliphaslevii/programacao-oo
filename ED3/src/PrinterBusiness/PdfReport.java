package PrinterBusiness;

public class PdfReport implements Printable {
    private String author;
    private int totalPages;

    public PdfReport(String author, int totalPages) {
        // Validate inputs to ensure data integrity
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("O Autor do relatório não pode ser nulo.");
        }
        if (totalPages <= 0) { // A report should have at least one page
            throw new IllegalArgumentException("O número total de páginas deve ser maior que 0.");
        }
        this.author = author.trim();
        this.totalPages = totalPages;
    }

    // Getters for accessing properties, maintaining encapsulation
    public String getAuthor() {
        return author;
    }

    public int getTotalPages() {
        return totalPages;
    }

    @Override
    public void print() {
        // Standardized print format for system consistency
        System.out.println("--- Relatório PDF ---"); // Clear and consistent header
        System.out.println("Autor: " + author);
        System.out.println("Total de Páginas: " + totalPages);
        System.out.println(); // Maintain consistent spacing
    }
}