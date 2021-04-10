package pages;

public enum FilterBrand {
    DOOGEE("Doogee"),
    GENERAL_MOBILE("General Mobile"),
    HUAWEI("Huawei"),
    SAMSUNG("Samsung"),
    XIAOMI("Xiaomi"),
    MEIZU("Meizu"),
    NOKIA("Nokia"),
    REALME("Realme"),
    VIVO("VIVO"),
    ZTE("ZTE");
    private final String brand;

    FilterBrand(String brand) {
        this.brand = brand;
    }
    public String getValue(){
        return this.brand;
    }
}
