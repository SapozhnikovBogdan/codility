package task3_streams;

import org.junit.Before;
import org.junit.Test;
import task3_streams.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class SoldProductsAggregatorTest {

    private EURExchangeService exchangeService;

    @Before
    public  void init(){
      exchangeService = new EURExchangeService();
    }

    @Test
    public void aggregate() throws Exception {
        SoldProductsAggregate soldProductsAggregate;

        List<SimpleSoldProduct> simpleSoldProducts = Arrays.asList(
                new SimpleSoldProduct("Monitor", new BigDecimal("200.53")),
                new SimpleSoldProduct("PC", new BigDecimal(("523.30"))),
                new SimpleSoldProduct("Keyboard", new BigDecimal("15.00")),
                new SimpleSoldProduct("Mouse", new BigDecimal("2.35")));

        List<SoldProduct> soldProducts = Arrays.asList(
                new SoldProduct("Monitor", new BigDecimal("200.53"), "USD"),
                new SoldProduct("PC", new BigDecimal(("10523.30")), "UAH"),
                new SoldProduct("Keyboard", new BigDecimal("15.00"), "USD"),
                new SoldProduct("Mouse", new BigDecimal("282.35"), "RUB"));

        SoldProductsAggregator soldAgg = new SoldProductsAggregator(exchangeService);
        soldProductsAggregate = soldAgg.aggregate(soldProducts.stream());
        System.out.println(soldProductsAggregate);
        //assertEquals(2000.55, soldProductsAggregate.getTotal().doubleValue(), 2.00);
    }

}