package design;

import java.util.Arrays;

public class CreateBorder {


    private String getHorizontalLineWith(char filler,int maxLength) {
        char[] chars = new char[maxLength];
        Arrays.fill(chars, filler);
        return new String(chars);
    }

    private String createDashPattenLine(char endSymbol, int maxLength) {
        String horizontalPattern = getHorizontalLineWith('-',maxLength);
        return endSymbol+horizontalPattern+endSymbol+"\n";
    }

    private String createGuestDataLabelWithBorder(String guestData,int maxLength) {
        int whiteSpaceLength = maxLength - guestData.length()-1;
        String whiteSpaceLine = getHorizontalLineWith(' ',whiteSpaceLength);
        return "| "+guestData+whiteSpaceLine+"|\n";
    }

    private int calculateMaxWidthOfLabel(String nameLabel, String addressLabel) {
        int extraAllowanceInLabelBorder = 2;
        int countryLength = addressLabel.split("\n")[1].length();
        int cityAndStateLength = addressLabel.split("\n")[0].length();
        return Math.max(Math.max(countryLength,cityAndStateLength),nameLabel.length())+extraAllowanceInLabelBorder;
    }

    public String create(String nameLabel, String addressLabel) {
        int labelWidth = calculateMaxWidthOfLabel(nameLabel,addressLabel);
        String decoratedLabel = "";

        decoratedLabel += createDashPattenLine('+',labelWidth)+ createGuestDataLabelWithBorder(nameLabel,labelWidth)+
                createDashPattenLine('|',labelWidth)+ createGuestDataLabelWithBorder(addressLabel.split("\n")[0],labelWidth);
        if(nameLabel.contains(addressLabel.split("\n")[1])) {
            decoratedLabel += createGuestDataLabelWithBorder(addressLabel.split("\n")[1], labelWidth);
        }
        decoratedLabel += createDashPattenLine('+',labelWidth);
        return decoratedLabel;
    }
}
