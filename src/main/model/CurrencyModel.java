public class CurrencyModel {

    Double euros;
    Double dollars;
    Double pounds;
    public static String EUR = "EUR";
    public static String USD = "USD";
    public static String GBP = "GBP";
    Double EURtoUSD = 1.07;
    Double USDtoEUR = 0.93;
    Double EURtoGBP = 0.85;
    Double GBPtoEUR = 1.25;
    Double USDtoGBP = 0.8;
    Double GBPtoUSD = 1.2;

    public void converse(Double currency, String type, String toConvert) {
        if (type.equals(EUR)) {
            if (toConvert.equals(USD)) {
                euros = currency * EURtoUSD;
            } else if (toConvert.equals(GBP)) {
                euros = currency * EURtoGBP;
            } else {
                euros = currency;
                System.out.println("Not acceptable conversion");
            }
        } else if (type.equals(USD)) {
            if (toConvert.equals(EUR)) {
                dollars = currency * USDtoEUR;
            } else if (toConvert.equals(GBP)) {
                dollars = currency * USDtoGBP;
            } else {
                dollars = currency;
                System.out.println("Not acceptable conversion");
            }
        } else {
            if (toConvert.equals(EUR)) {
                pounds = currency * GBPtoEUR;
            } else if (toConvert.equals(USD)) {
                pounds = currency * GBPtoUSD;
            } else {
                pounds = currency;
                System.out.println("Not acceptable conversion");
            }
        }
    }

    public Double getCurrency(String type) {
        if (type.equals(EUR)) {
            return euros;
        } else if (type.equals(USD)) {
            return dollars;
        } else if (type.equals(GBP)){
            return pounds;
        } else {
            return null;
        }
    }

    public String getEUR() {
        return EUR;
    }

    public String getUSD() {
        return USD;
    }

    public String getGBP() {
        return GBP;
    }

    public Double getRate(String type1, String type2) {
        if (type1.equals(EUR)) {
           if (type2.equals(USD)) {
               return EURtoUSD;
           } else if (type2.equals(GBP)) {
               return EURtoGBP;
           } else {
               return null;
           }
        } else if (type1.equals(USD)) {
            if (type2.equals(EUR)) {
                return USDtoEUR;
            } else if (type2.equals(GBP)) {
                return USDtoGBP;
            } else {
                return null;
            }
        } else {
            if (type2.equals(EUR)) {
                return GBPtoEUR;
            } else if (type2.equals(USD)) {
                return GBPtoUSD;
            } else {
                return null;
            }
        }
    }
}
