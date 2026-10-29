package lesson0013;

public enum Currency {
    RUB("Российский рубль"), USD("Доллар США"), EUR("Евро");

    private final String displayName;

    Currency(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    public String symbol (){
        return switch (this){
            case EUR -> "€";
            case RUB -> "₽";
            case USD -> "$";
        };
    }
}