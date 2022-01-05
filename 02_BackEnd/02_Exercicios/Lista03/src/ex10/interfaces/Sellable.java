package ex10.interfaces;

import ex10.exceptions.CannotBeSoldException;
import ex10.exceptions.InsufficientStockException;

public interface Sellable {
    public void sell() throws InsufficientStockException, CannotBeSoldException;
}
