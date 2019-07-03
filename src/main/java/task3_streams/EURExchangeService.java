package task3_streams;

import java.math.BigDecimal;
import java.util.Optional;

public class EURExchangeService implements ExchangeService {
    @Override
    public Optional<BigDecimal> rate(String currency) {
        Optional<BigDecimal> result = Optional.empty();
        switch (currency){
            case "USD": result = Optional.of(new BigDecimal("1.13"));
                        break;
            case "UAH": result = Optional.of(new BigDecimal("29.50"));
                        break;
            case "RUB": result = Optional.of(new BigDecimal("71.40"));
                break;
            default: break;
        }
        return result;
    }
}
