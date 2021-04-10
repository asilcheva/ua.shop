package pages;

public enum FilterPrices {
    FIRST("100", "3000"),
    SECOND("3000", "5000"),
    THIRD("5000", "8000"),
    FOURTH("8000", "15000"),
    FIFTH("15000", "100000");
    private final String lowPrice;
    private final String highPrice;

    FilterPrices(String key, String value) {
        this.lowPrice = key;
        this.highPrice = value;
    }


    public String getLowPrice() {
        return this.lowPrice;
    }

    public String getHighPrice() {
        return this.highPrice;
    }


}
