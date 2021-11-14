// Tutorial: https://www.youtube.com/watch?v=0DjCppOSB3c

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    private static void example1(){
        String string = "Hallo Welt";
        Pattern pattern = Pattern.compile("Hallo Welt");
        printOutResult(string, pattern);
    }

    // \w: ist ein word character und steht für einen beliebigen Buchstaben im Alphabet oder eine Zahl
    // \\: Erster Backslash ist Escape-Character für Java, zweiter Backslash ist Escape-Character für Regex-Engine
    // *: Wiederholung von 0 bis unendlich
    private static void example2(){
        String string = "Apfel Zuckerguss Affe Ampel Label";
        Pattern pattern = Pattern.compile("A(\\w*)");
        printOutResult(string, pattern);
    }

    // .: x-beliebiges Zeichen
    private static void example3(){
        String string = "Apfel Zuckerguss Affe Ampel Label";
        Pattern pattern = Pattern.compile("A(.*)l");
        printOutResult(string, pattern);
    }

    private static void example4(){
        String string = "Das sind mehrere Saetze. Es soll immer das letzte Wort gefunden werden. Okay.";
        Pattern pattern = Pattern.compile("\\w*\\.");
        printOutResult(string, pattern);
    }

    // \\d: digit -> Zahl von 0 bis 9
    // [0-3]: Range von 0 bis und mit 3
    private static void example5(){
        String string = "00:02:10-Error Mah Gawd! 00:02:12-Everything makes bomm!00:02:14-Ded :-(" +
                "25:00:00 not valid time";
        Pattern pattern = Pattern.compile("(([0-1]\\d)|(2[0-3])):\\d\\d:\\d\\d");
        printOutResult(string, pattern);
    }

    // \\s: Space-Character
    // +: Wiederholung von 1 bis unendlich (* hingegen ist von 0 bis unendlich)
    private static void example6(){
        String string = "Hallo Merkel Hallo Welt Hallo Java Hallo     Welt Hallo Hallo HalloWelt";
        Pattern pattern = Pattern.compile("Hallo(\\s+)Welt");
        printOutResult(string, pattern);
    }

    // \\s: Space-Character
    // {1,3}: Range mit oberer und unterer Grenze. Hier also 1, 2 oder 3 Spaces erlaubt zwischen Hallo und Welt
    private static void example7(){
        String string = "Hallo Merkel,HalloWelt, Hallo Welt, Hallo  Welt, Hallo   Welt, Hallo    Welt Hallo Hallo HalloWelt";
        Pattern pattern = Pattern.compile("Hallo(\\s{1,3})Welt");
        printOutResult(string, pattern);
    }

    // []: Ist ein Set mit möglichen erlaubten Zeichen
    // [\\w.%+-]: hier also ein Zeichen der folgenden: word characters, Punkte, Prozentzeichen, Plus und Minus
    // [\\w.%+-]+: das Plus am Ende sagt, dass das Zeichen 1 bis unendlich oft Vorkommt
    private static void example8(){
        System.out.println("**************************");
        String string = "Max.Mustermann@Beispiel.de"
                + "\nHallo@Welt.de"
                + "\nIrgendwas Anderes"
                + "\nBöse Adresse@¢¢¢.de"
                + "\nDieHier@GehtWieder.de"
                + "\nAuch0192Zahlen@sindErlaubt.com"
                + "\nLokaler_Teil_Erlaubt_unterstriche@Tests.com"
                + "\nTests@Globaler_Teile_Aber_nicht.com"
                + "\nHierIstTopLevelDomainZuKurz@Beispiel.c";
        System.out.println(string);
        System.out.println("**************************\n");
        Pattern pattern = Pattern.compile("[\\w.%+-]+@[[\\w.-]&&[^_]]+\\.[a-z]{2,}");
        printOutResult(string, pattern);
    }

    public static void main(String[] args) {
        example8();
    }

    private static void printOutResult(String string, Pattern pattern){

        Matcher matcher = pattern.matcher(string);

        while(matcher.find())
        System.out.println(matcher.group() + " " + matcher.start() + " " + matcher.end());
    }

}
