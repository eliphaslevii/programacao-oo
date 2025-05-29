package PrinterBusiness;

import java.util.ArrayList;
import java.util.List;

public class Main { // Renamed the class for thematic relevance
    public static void main(String[] args) {
        // Create instances of your printable items with Power Rangers theme
        TextDocument doc = new TextDocument("Morfagem Power Rangers", "É hora de morfar! Os Power Rangers se unem para proteger a Terra dos ataques de Rita Repulsa.");
        DigitalImage img = new DigitalImage("Megazord_em_acao.jpg", "4000x2250 (Ultra HD)");
        StatisticalGraph graph = new StatisticalGraph("Contagem de Vilões Derrotados", "Gráfico de Barras"); // More descriptive graph type
        PdfReport report = new PdfReport("Zordon", 97); // Zordon's report, perhaps on Ranger progress

        // Create a list to hold all printable items
        List<Printable> printableItems = new ArrayList<>();
        printableItems.add(doc);
        printableItems.add(img);
        printableItems.add(graph);
        printableItems.add(report);

        // Iterate through the list and print each item
        System.out.println("--- Relatórios de impressões ---");
        for (Printable item : printableItems) {
            item.print();
        }

        // Example of handling invalid data (due to the validations added in classes)
        System.out.println("--- Tentativas de Criação de Itens Inválidos (Ameaças Falhas) ---");
        try {
            // An attempt to create a TextDocument for a Ranger without a name/identity
            new TextDocument(null, "Um novo Ranger sem nome e sem poder.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar Documento: " + e.getMessage());
        }

        try {
            // An attempt to create a PDFReport for a villain's plan with no substance
            new PdfReport("Rita Repulsa", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar Relatório de Plano Maligno: " + e.getMessage());
        }
    }
}