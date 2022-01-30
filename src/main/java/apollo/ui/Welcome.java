package apollo.ui;

import java.time.LocalTime;

import static apollo.messages.Messages.LINE_FEED;

public class Welcome {

    private static String dayTime(LocalTime now) {
        // define the border values
        LocalTime eleven = LocalTime.of(11, 0);
        LocalTime four = LocalTime.of(4, 0);
        LocalTime fifteen = LocalTime.of(15, 0);
        LocalTime eighteenThirty = LocalTime.of(18, 30);

        // check if the time is after four and either before or exactly eleven
        if (now.isAfter(four) &&
                (now.isBefore(eleven) || now.equals(eleven)))
            return "morning";
            // check if the time is after eleven and either before or exactly fifteen
        else if (now.isAfter(eleven) &&
                (now.isBefore(fifteen) || now.equals(fifteen)))
            return "afternoon";
            // check if the time is after fifteen and either before or exactly eighteen thirty
        else if (now.isAfter(fifteen) &&
                (now.isBefore(eighteenThirty) || now.equals(eighteenThirty)))
            return "evening";
            // otherwise, it's night
        else return "night";
    }

    public static void printLogo() {
        String logo = "       @@@%      @@@@@@*.      :@@@@@.    %@@@@@+    @@@@@@        #@@@@=       \n"
                + "       @@@@=     @@@@@@@@@    @@@@@@@@#   @@@@@@*    @@@@@@.     -@@@@@@@@      \n"
                + "       @@@@@     @@@@@@@@@*  %@@@@@@@@@+  @@@@@@*    @@@@@@.    .@@@@@@@@@@     \n"
                + "      #@@@@@     +@@@@+@@@@  @@@@%+%@@@@   @@@@       @@@@      @@@@@**@@@@=    \n"
                + "      @@@@@@+     %@@@  @@@ =@@@#   @@@@:  @@@@       @@@@      @@@@    @@@@    \n"
                + "      @@@.@@@     #@@@ @@@@ %@@@     @@@#  @@@@       @@@%      @@@*    @@@@    \n"
                + "     .@@@ @@@     *@@@@@@@= @@@@     @@@@  @@@@       @@@#      @@@-    @@@@    \n"
                + "     =@@@@@@@*    *@@@@@@%  @@@@     @@@@  @@@@       @@@*      @@@-    @@@@    \n"
                + "     @@@@@@@@@    +@@@@%    #@@@.    @@@+  @@@@  @@%  @@@+  @@* @@@@    @@@@    \n"
                + "     @@@-:-@@@.   +@@@      -@@@@   @@@@   @@@@  @@@  @@@=  @@% @@@@*  *@@@%    \n"
                + "     @@@.  @@@#   +@@@       @@@@@@@@@@@  -@@@@-=@@@ -@@@*-*@@% #@@@@@@@@@@.    \n"
                + "    @@@@@:@@@@@@ @@@@@@@     =@@@@@@@@@   @@@@@@@@@@ @@@@@@@@@%  @@@@@@@@@%     \n"
                + "    @@@@@-@@@@@@ @@@@@@@      =@@@@@@@-   @@@@@@@@@@ @@@@@@@@@%   @@@@@@@@      \n"
                + "    @%#*+:+%#*+= -=+++++        =%@%=     --======== --=======-    :*@@*.       ";
        System.out.println(("Hello from\n" + logo).replace("\n", LINE_FEED));
    }

    public static String welcomeMessage(boolean isLoaded, LocalTime now) {
        String greeting = isLoaded
                ? "Welcome back sir. "
                : String.format("Good %s sir, I am Apollo. ", dayTime(now));
        return String.format("%s\nHow can I help you on this wonderful %s? ",
                greeting, dayTime(now));
    }
}
