package src.ru.croc.task11.tests;

import org.testng.annotations.Test;
import src.ru.croc.task11.auction.Lot;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LotTest {

    @Test
    private void test() {
        Lot lot = new Lot(new BigDecimal("100.1"), LocalDateTime.now().plusHours(1));

    }
}
