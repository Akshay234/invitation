package display;
import design.CreateBorder;
import invite.GenerateLabel;

public class PrintWithBorder implements Printer {

    @Override
    public void print(GenerateLabel labelGenerator) {
        CreateBorder borderCreator = new CreateBorder();
        System.out.println(borderCreator.create(labelGenerator.generate(), labelGenerator.addressLabel()));
    }
}
