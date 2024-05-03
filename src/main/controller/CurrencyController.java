

public class CurrencyController {
    private CurrencyView gui;

    private final CurrencyModel converter = new CurrencyModel();

    public CurrencyController(CurrencyView gui) {
        this.gui = gui;
    }

    public Double startConversion(Double currency, String type1, String toConvert) {
        converter.converse(currency, toConvert, type1);
        return converter.getCurrency(toConvert);
    }
}
