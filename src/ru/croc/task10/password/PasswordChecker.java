package src.ru.croc.task10.password;

import java.util.concurrent.Callable;

public class PasswordChecker implements Callable<String> {

    /**
     * Номер слова с которого начинается перебор
     */
    private final long start;

    /**
     * Верхняя граница перебора.
     */
    private final long end;

    private final int symbolQuantity;

    /**
     * Хэш зашифрованного пароля.
     */
    private final String initialHash;

    /**
     * Ответ на случай, если не найден исходный пароль.
     */
    private final String defaultResponse;

    private final int alphabetPower;

    private static final int A_AS_CHAR ='a';

    /**
     * Конструктор.
     *
     * @param start начальное значение для перебора
     * @param end конечное значение для перебора
     * @param symbolQuantity - число символов в зашифрованном пароле
     * @param initialHash хэш зашифрованного пароля
     * @param defaultResponse ответ по умолчанию
     * @param alphabetPower сила словаря
     */
    public PasswordChecker(long start, long end, int symbolQuantity, String initialHash, String defaultResponse, int alphabetPower) {
        this.start = start;
        this.end = end;
        this.symbolQuantity = symbolQuantity;
        this.initialHash = initialHash;
        this.defaultResponse = defaultResponse;
        this.alphabetPower = alphabetPower;
    }

    @Override
    public String call() {
        for (long i=start; i < end; i++) {
//            System.out.println("Поток=" + defaultResponse + ", Started item=" + i);
            char[] next = calculateInitialWord(i, symbolQuantity, alphabetPower);
            String password = new String(next);
            System.out.println(password);
            String hash = GenerateHash.hashPassword(password);
            if (initialHash.equals(hash)) {
                return password;
            }
        }
        return defaultResponse;
    }

    /**
     * Подсчет изначального слова.
     *
     * @param start начальное значение для перебора
     * @param symbolQuantity число символов в пароле
     * @return первый пароль
     */
    private static char[] calculateInitialWord(long start, int symbolQuantity, int alphabetPower) {
        char[] password = new char[symbolQuantity];
        long current = start;
        for (int i = symbolQuantity - 1; i >= 0; i--) {
            password[i] = (char) (current % alphabetPower + A_AS_CHAR);
            current = current / alphabetPower;
        }
        return password;
        //return new char[]{'p','a','s','s','w','r','d'};
    }

    /*private char[] nextPassword(char[] current) {

    }*/
}
