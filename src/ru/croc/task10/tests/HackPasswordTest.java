package src.ru.croc.task10.tests;

import org.testng.annotations.Test;
import src.ru.croc.task10.password.GenerateHash;
import src.ru.croc.task10.password.HackPassword;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;

public class HackPasswordTest {
    private static final String INITIAL_HASH = "40682260CC011947FC2D0B1A927138C5";
    @Test
    private void positiveMainCaseTest() {
        int threadsNumber = 4;

        String password = HackPassword.calculatePassword(threadsNumber, INITIAL_HASH);
        String hash = GenerateHash.hashPassword(password);

        assertEquals(hash, INITIAL_HASH);
    }

    @Test
    private void negativeMainCaseTest() {
        int threadsNumber = 4;

        String someStrForTest = "smsmbls";
        String someStringHash = GenerateHash.hashPassword(someStrForTest);
        String password = HackPassword.calculatePassword(threadsNumber, someStringHash);
        String recalculatedHash = GenerateHash.hashPassword(password);

        assertNotSame(recalculatedHash, INITIAL_HASH);
    }
}
