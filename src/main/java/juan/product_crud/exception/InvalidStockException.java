package juan.product_crud.exception;

public class InvalidStockException extends RuntimeException {
    public InvalidStockException(String message) {
        super(message);
    }
}
