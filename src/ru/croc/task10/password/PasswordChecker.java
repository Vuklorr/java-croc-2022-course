package ru.croc.task10.password;

import java.util.concurrent.Callable;

public class PasswordChecker implements Callable<String> {

    /**
     * Начальный символ.
     */
    private static final int A_AS_CHAR ='a';

    /**
     * Номер слова с которого начинается перебор.
     */
    private final long start;

    /**
     * Верхняя граница перебора.
     */
    private final long end;

    /**
     * Число символов в зашифрованном пароле
     */
    private final int symbolQuantity;

    /**
     * Хэш зашифрованного пароля.
     */
    private final String initialHash;

    /**
     * Ответ на случай, если не найден исходный пароль.
     */
    private final String defaultResponse;

    /**
     * Размер алфавита.
     */
    private final int alphabetPower;

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
    public PasswordChecker(long start, long end, String initialHash, int symbolQuantity, String defaultResponse, int alphabetPower) {
        this.start = start;
        this.end = end;
        this.initialHash = initialHash;
        this.symbolQuantity = symbolQuantity;
        this.defaultResponse = defaultResponse;
        this.alphabetPower = alphabetPower;
    }

    @Override
    public String call() {
        for (long i=start; i < end; i++) {
            char[] next = calculateInitialWord(i);
            String password = new String(next);
            String hash = GenerateHash.hashPassword(password);
            if (initialHash.equals(hash)) {
                return password;
            }
        }
        return defaultResponse;
    }

    /**
     * Получение пароля по номеру
     *
     * @param num начальное значение для перебора
     * @return первый пароль
     */
    private char[] calculateInitialWord(long num) {
        char[] password = new char[symbolQuantity];
        for (int i = symbolQuantity - 1; i >= 0; i--) {
            password[i] = (char) (num % alphabetPower + A_AS_CHAR);
            num = num / alphabetPower;
        }
        return password;
    }
}
