package display;

import java.util.HashMap;

public class PrintType {
    private final HashMap<String, Printer> printingWays;

    public PrintType() {
        printingWays = new HashMap<>();
        printingWays.put("-b", new PrintWithBorder());
        printingWays.put("-nb", new PrintWithoutBorder());
    }

    public Printer getPrinterFor(String labelDesignCommand) {
        return printingWays.get(labelDesignCommand);
    }
}
