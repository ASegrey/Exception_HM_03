package Seminar_03.HM_03;

public class DataException extends IllegalArgumentException {

    public DataException(String text) {
        super(String.format(text));
    }
}
