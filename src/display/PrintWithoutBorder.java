package display;

import invite.GenerateLabel;

public class PrintWithoutBorder implements Printer {
    GenerateLabel labelGenerator;

    @Override
    public void print(GenerateLabel labelGenerator) {
        this.labelGenerator = labelGenerator;
        String labelWithoutBorder = labelGenerator.generate();
        System.out.println(labelWithoutBorder);
    }
}
