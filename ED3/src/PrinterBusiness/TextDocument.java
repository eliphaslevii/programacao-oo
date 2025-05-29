package PrinterBusiness;

public class TextDocument implements Printable {
    private String title;
    private String content;

    public TextDocument(String title, String content) {
        // Basic validation for title and content
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Document title cannot be null or empty.");
        }
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Document content cannot be null or empty.");
        }
        this.title = title.trim(); // Trim whitespace
        this.content = content.trim(); // Trim whitespace
    }

    // Getters for title and content (good practice for immutability and access)
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public void print() {
        // Using a more robust string formatter or builder for potential future expansion
        System.out.println("--- " + title.toUpperCase() + " ---"); // Add separators for clarity
        System.out.println(content);
        System.out.println(); // Keep the empty line for spacing
    }
}