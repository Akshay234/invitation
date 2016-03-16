package invite;

import display.PrintType;
import display.Printer;
import filter.Filter;
import format.record.DataParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Invitation {
    private final List<String> guestData;
    private Filter filter;

    public Invitation(Filter filter, List<String> guestData) {
        this.filter = filter;
        this.guestData = guestData;
    }

    private List<HashMap<String, String>> parseData() throws IOException {
        DataParser dataParser = new DataParser(guestData);
        return dataParser.parse();
    }

    private GuestList createGuestList() throws IOException {
        GuestList newGuestList = new GuestList();
        newGuestList.addAll(parseData());
        return newGuestList;
    }

    public void printLabel() throws IOException {
        Filter newFilter = filter.getNewFilter();
        PrintType printType = new PrintType();
        Printer printer = printType.getPrinterFor(newFilter.getLabelDesignCommand());
        GuestList guestList = createGuestList();

        for (int i = 0; i < guestList.size(); i++) {
            GenerateLabel labelGenerator = new GenerateLabel(guestList.getDetailsOf(i),newFilter);
            printer.print(labelGenerator);
        }
    }
}