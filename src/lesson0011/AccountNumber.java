package lesson0011;

import java.util.Objects;

public class AccountNumber {
    private String value;
    //Номер счета объект-значение потому что он определяется своими данными, а счет определяется своей идентичностью, как сущность
    public AccountNumber(String value) {
        if (value == null || value.isBlank() || !value.startsWith("BANK")) {
            throw new IllegalArgumentException("Некорректное значение: ");
        }
        this.value = value;
    }

    public String getValue(){
        return value;
    }
//src/lesson0008/AccountNumber.java:19: error: method does not override or implement a method from a supertype
//    @Override
//    ^
//1 error
    @Override
    public boolean equals(Object o){//AccountNumber o произойдет перегрузка
        if (this == o){
            return true;
        }
        if (o == null || o.getClass() != getClass()){
            return false;
        }

        AccountNumber other = (AccountNumber) o;

        return value.equals(other.value);
    }

    @Override
    public int hashCode(){
        return Objects.hash(value);
    }

}