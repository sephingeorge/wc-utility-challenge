package challenge.coding.wc.display;

public class DisplayMessage {

    private DisplayMessage() {
        throw new IllegalStateException("Not supported");
    }

    public static void displayBannerMessage() {
        System.out.println("""
                ******************************************************************************
                ******************************************************************************
                ******************************************************************************
                ********  ****** ***        ***********************        ***           *****
                ******** *** *** *** ****************************** ********** ***************
                ******** *** *** *** **************      **********        *** ***       *****
                ******** ** ** * *** ************************************* *** ****** ** *****
                ******** * ***** ***        ***********************        ***        ** *****
                ******************************************************************************
                ******************************************************************************
                ******************************************************************************
                """);
    }

    public static void displayExitMessage() {
        System.out.println("Type \"exit\" to quit the terminal");
    }

    public static void displayHelpMessage() {
        System.out.println("""
                ===================================================================
                COMMAND           OPTIONS        PARAMETER
                ===================================================================
                   wc                -c          Returns bytes length
                   wc                -l          Returns number of lines
                   wc                -w          Returns number of words
                   wc                -m          Returns number of characters
                   help                          Shows commands and options
                   exit                          exit from command line
                ===================================================================
                """);
    }

    public static void displayResult(int length) {
        System.out.print(length + " " );
    }

    public static void displayName(String name) {
        System.out.println(name);
    }
}
