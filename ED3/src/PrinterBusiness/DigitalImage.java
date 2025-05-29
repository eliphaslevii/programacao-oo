package PrinterBusiness;

public class DigitalImage implements Printable {
    private String fileName;
    private String resolution;

    public DigitalImage(String fileName, String resolution) {
        // Validate inputs to ensure data integrity
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty.");
        }
        if (resolution == null || resolution.trim().isEmpty()) {
            throw new IllegalArgumentException("Resolution cannot be null or empty.");
        }
        this.fileName = fileName.trim();
        this.resolution = resolution.trim();
    }

    // Getters for accessing properties, maintaining encapsulation
    public String getFileName() {
        return fileName;
    }

    public String getResolution() {
        return resolution;
    }

    @Override
    public void print() {
        // Standardized print format for system consistency
        System.out.println("--- Imagem Digital ---"); // Clear header
        System.out.println("Nome do arquivo: " + fileName);
        System.out.println("Resolução: " + resolution);
        System.out.println(); // Maintain consistent spacing
    }
}