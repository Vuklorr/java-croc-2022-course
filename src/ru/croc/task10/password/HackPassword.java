package src.ru.croc.task10.password;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HackPassword {

    private static final int ALPHABET_POWER = 26;
    private static final int WORD_LENGTH = 7;
    private static final String DEFAULT_RESPONSE = "NOT_FOUND";

    public static String calculatePassword(int threadsNumber, String initialHash) {
        List<Future<String>> responses = new ArrayList<>(threadsNumber);
        long step = calculateStep(threadsNumber);

        for (int i=0; i < threadsNumber; i++) { //FIXME граничные элементы каждого отрезка подсчитываются дважды
            PasswordChecker item = new PasswordChecker(step*i, step*(i+1), WORD_LENGTH, initialHash, DEFAULT_RESPONSE, ALPHABET_POWER);
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<String> future = executorService.submit(item);
            responses.add(future);
        }

        //FIXME холостой цикл с ожиданиями побочных потоков

        try {
            while (true) { 
                long count = responses.stream().filter(Future::isDone).count();
                for (Future<String> item : responses) {
                    if (!DEFAULT_RESPONSE.equals(item.get())) {
                        return item.get();
                    }
                }
                if (count == threadsNumber) {
                    break;
                }
            }
            return DEFAULT_RESPONSE;
        } catch (InterruptedException | ExecutionException e) {
            System.err.print(e.getMessage());
            return DEFAULT_RESPONSE;
        }
    }

    private static long calculateStep(int threadsNumber) { //FIXME дробные периоды 500/3
        return Math.round(Math.pow(ALPHABET_POWER, WORD_LENGTH)/threadsNumber);
    }
}