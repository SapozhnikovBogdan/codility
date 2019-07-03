package task3_streams;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class SoldProductsAggregator {

    private final EURExchangeService exchangeService;

    SoldProductsAggregator(EURExchangeService EURExchangeService) {
        this.exchangeService = EURExchangeService;
    }

    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {

        Collector<SimpleSoldProduct, List<SimpleSoldProduct>, SoldProductsAggregate> soldProductsCollector =
            Collector.of(ArrayList<SimpleSoldProduct>::new,
                         List::add,
                         (l1, l2) -> {l1.addAll(l2); return l1;},
                         (l)->new SoldProductsAggregate(l,
                            new BigDecimal(l.stream().mapToDouble(p->p.getPrice().doubleValue()).sum()).setScale(2, RoundingMode.HALF_EVEN))
                         );

       return products.map(p ->
                new SimpleSoldProduct(p.name,
                        p.price.divide(exchangeService.rate(p.currency).filter(r -> r.compareTo(BigDecimal.ZERO)>0).orElse(BigDecimal.ONE), 2, RoundingMode.HALF_EVEN))
        ).collect(soldProductsCollector);
    }

}