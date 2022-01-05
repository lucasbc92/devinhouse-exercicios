package ex10.interfaces;

import ex10.entities.Product;
import ex10.exceptions.CannotBeExchangedException;
import ex10.exceptions.ExchangeDeniedException;
import ex10.exceptions.InsufficientStockException;

public interface Exchangeable {
    public static final double MINIMAL_PERCENTUAL_PRICE_DIFFERENCE = 0.1;
    public void exchange(Product product) throws InsufficientStockException, ExchangeDeniedException, CannotBeExchangedException;
}
