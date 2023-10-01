public class DataSizeException extends RuntimeException {
    public DataSizeException(String pointer) {
            super(String.format("Вы ввели слишком %s данных!", pointer));
    }
}

