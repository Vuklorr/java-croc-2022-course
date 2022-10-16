package src.ru.croc.task2;

public class Task2 {
    public static void main(String[] args) {
        double b = Double.parseDouble(args[0]);
        String str = "B"; //единицы измерения
        int i = 0;
        while (b >= 1024.0) {
            b /= 1024.0;
            i++;
            if(i == 5) {
                break;
            }
        }
        switch (i) {
            case 1:
                str = "KB";
                break;
            case 2:
                str = "MB";
                break;
            case 3:
                str = "GB";
                break;
            case 4:
                str = "TB";
                break;
            case 5:
                str = "PB";
                break;
        }

        System.out.printf("%.1f %s\n", b, str);
    }
}
