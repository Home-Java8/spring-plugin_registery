package utils;

import org.springframework.plugin.core.Car;

public class PrintUtil {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_GRAY_BACKGROUND = "\u001B[47m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private static final String ANSI_FONT_BOLD_ON = "\u001B[1m"; // \u001B[1m  // \033[1m

    private static final String SEPARATOR_OUT = "+----------------------+----------------------+----------------------+----------------------+----------------------+----------------------+----------------------+",
            HEAD_OUT = "| " + ANSI_FONT_BOLD_ON + "%1$-20s" + ANSI_RESET + " | "+ANSI_FONT_BOLD_ON + "%2$-20s" + ANSI_RESET + " | %3$-20s | %4$-20s | %5$-20s | %6$-20s | %7$-20s |\n",
            DATA_OUT_0 = "| " + ANSI_YELLOW + "%1$-20s" + ANSI_RESET + " | " + ANSI_YELLOW + "%2$-20s" + ANSI_RESET + " | " + ANSI_YELLOW + "%3$-20s" + ANSI_RESET + " | " + ANSI_YELLOW + "%4$-20s" + ANSI_RESET + " | " + ANSI_YELLOW + "%5$-20s" + ANSI_RESET + " | " + ANSI_YELLOW + "%6$-20s" + ANSI_RESET + " | " + ANSI_YELLOW + "%7$-20s" + ANSI_RESET + " |\n",
            DATA_OUT_1 = "| " + ANSI_GREEN + "%1$-20s" + ANSI_RESET + " | " + ANSI_GREEN + "%2$-20s" + ANSI_RESET + " | " + ANSI_GREEN + "%3$-20s" + ANSI_RESET + " | " + ANSI_GREEN + "%4$-20s" + ANSI_RESET + " | " + ANSI_GREEN + "%5$-20s" + ANSI_RESET + " | " + ANSI_GREEN + "%6$-20s" + ANSI_RESET + " | " + ANSI_GREEN + "%7$-20s" + ANSI_RESET + " |\n";

    public static void format(String[] args) {
        System.out.println(PrintUtil.SEPARATOR_OUT);
        System.out.format(PrintUtil.HEAD_OUT, args);
        System.out.println(PrintUtil.SEPARATOR_OUT);
    }

    public static void format(Car car) {
        String[] out = new String[]{
                car.getBrand(),
                car.getType(),
                car.getPower()==0 ? "" : String.valueOf(car.getPower()),
                car.getTorque()==0 ? "" : String.valueOf(car.getTorque()),
                car.getGears()==0 ? "" : String.valueOf(car.getGears()),
                car.getColor(),
                ""
        };
        System.out.format(PrintUtil.DATA_OUT_0, out);
        System.out.println(PrintUtil.SEPARATOR_OUT);
    }
}
