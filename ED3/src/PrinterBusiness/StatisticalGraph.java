package PrinterBusiness;

public class StatisticalGraph implements Printable {
    private String title;
    private String graphType; // e.g., "Bar Chart", "Line Graph", "Pie Chart"

    public StatisticalGraph(String title, String graphType) {
        // Essential validation for data integrity
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Graph title cannot be null or empty.");
        }
        if (graphType == null || graphType.trim().isEmpty()) {
            throw new IllegalArgumentException("Graph type cannot be null or empty.");
        }
        this.title = title.trim();
        this.graphType = graphType.trim();
    }

    // Getters for accessing properties, following encapsulation principles
    public String getTitle() {
        return title;
    }

    public String getGraphType() {
        return graphType;
    }

    @Override
    public void print() {
        // Standardized print format for clarity within the system
        System.out.println("--- Gráfico de estatísticas ---"); // Clear, consistent header
        System.out.println("Título: " + title); // Title should usually maintain its original casing
        System.out.println("Título de gráfico: " + graphType); // Graph type should also maintain original casing
        System.out.println(); // Consistent spacing for readability
    }
}