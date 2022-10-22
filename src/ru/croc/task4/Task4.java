package src.ru.croc.task4;

public class Task4 {
    public static void main(String[] args) {
        String source = "/*\n" +
                " * My first ever program in Java!\n" +
                " */\n" +
                "class Hello { // class body starts here \n" +
                "  \n" +
                "  /* main method */\n" +
                "  public static void main(String[] args/* we put command line arguments here*/) {\n" +
                "    // this line prints my first greeting to the screen\n" +
                "    int a = 1 / 2 //dev\n" +
                "    System.out.println(\"Hi!\"); // :)\n" +
                "  }\n" +
                "} // the end\n" +
                "// to be continued...\n";
        String noComments = removeJavaComments(source);
        System.out.print(noComments);
    }

    private static String removeJavaComments(String text) {
        StringBuilder noComments = new StringBuilder();
        int i = 0;
        while(i < text.length() && i != -1) {
            char ch = text.charAt(i); //последовательно берем символ из сообщения
            if(ch == '/') {
                if(text.charAt(i + 1) == '/') { // комментарий - однострочный
                    i = text.indexOf('\n', i) - 1;
                } else if(text.charAt(i + 1) == '*') { // комментарий - многострочный
                    i = text.indexOf("*/", i) + 1;
                } else {
                    noComments.append(ch); // не комментарий (деление, например)
                }
            } else {
                noComments.append(ch);
            }
            i++;
        }
        return noComments.toString();
    }

}
