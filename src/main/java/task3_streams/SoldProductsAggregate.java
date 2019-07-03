package task3_streams;

import java.math.BigDecimal;
import java.util.List;

public class SoldProductsAggregate {
    List<SimpleSoldProduct> products;
    BigDecimal total;

    public SoldProductsAggregate(List<SimpleSoldProduct> products, BigDecimal total) {
        this.products = products;
        this.total = total;
    }

    public List<SimpleSoldProduct> getProducts() {
        return products;
    }

    public BigDecimal getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "task3_streams.SoldProductsAggregate{" +
                "products=" + products +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoldProductsAggregate that = (SoldProductsAggregate) o;

        if (products != null ? !products.equals(that.products) : that.products != null) return false;
        return total != null ? total.equals(that.total) : that.total == null;
    }

    @Override
    public int hashCode() {
        int result = products != null ? products.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }
}
