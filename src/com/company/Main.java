package com.company;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author johntjones
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<String> keys = new ArrayList<String>(12);
        int size = keys.size();

        String c = new String("C");
        String cSharp = new String("C#");
        String d = new String("D");
        String dSharp = new String("D#");
        String e = new String("E");
        String f = new String("F");
        String fSharp = new String("F#");
        String g = new String("G");
        String gSharp = new String("G#");
        String a = new String("A");
        String aSharp = new String("A#");
        String b = new String("B");

        keys.add(c);
        keys.add(cSharp);
        keys.add(d);
        keys.add(dSharp);
        keys.add(e);
        keys.add(f);
        keys.add(fSharp);
        keys.add(g);
        keys.add(gSharp);
        keys.add(a);
        keys.add(aSharp);
        keys.add(b);

        Scanner input = new Scanner(System.in);

        System.out.println("What key would you like?");
        String answer = input.nextLine();
        System.out.println("What scale? Major or Minor");
        String scale = input.nextLine();

        String ans = new String("");
        for (String key: keys) {
            if (answer.toUpperCase().equals(key)) {
                ans = key;
            }
        }

        ArrayList<String> keysModified = new ArrayList<>();
        int place = 0;

        // Adds specified key to first place in modified key array.
        for (int r = 0; r < keys.size(); r++) {
            if (ans == keys.get(r)) {
                keysModified.add(keys.get(r));
                place = r + 1;
            }
        }

        // Adds keys after specified key to modified key array
        for (int v = place; v < keys.size(); v++) {
            keysModified.add(keys.get(v));
        }

        // Adds keys before specified key to modified key array
        for (int x = 0; x < place - 1; x++) {
            keysModified.add(keys.get(x));
        }

        // Creates new array containing only keys in specified scale
        ArrayList<String> scaleModified = new ArrayList<String>();
        if (scale.toLowerCase().equals("major")) {
            for (int i = 0; i < keysModified.size(); i++) {
                if (i == 0 || i == 2 || i == 4 || i == 5 || i == 7 || i == 9 || i == 11 || i == 12) {
                    scaleModified.add(keysModified.get(i));
                }
            }

            // Determines whether each key in scale will be played minor or major
            for (int j = 0; j < scaleModified.size(); j++) {
                if (j == 0 || j == 3 || j == 4) {
                    System.out.print(scaleModified.get(j) + "maj, ");
                } else if (j == 1 || j == 2 || j == 5) {
                    System.out.print(scaleModified.get(j) + "m, ");
                } else {
                    System.out.print(scaleModified.get(j) + "dim");
                }
            }
        }

        if (scale.toLowerCase().equals("minor")) {
            for (int i = 0; i < keysModified.size(); i++) {
                if (i == 0 || i == 2 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                    scaleModified.add(keysModified.get(i));
                }
            }

            for (int j = 0; j < scaleModified.size(); j++) {
                if (j == 0 || j == 3 || j == 4) {
                    System.out.print(scaleModified.get(j) + "m, ");
                } else if (j == 2 || j == 5 || j == 6) {
                    if (j == 6) {
                        System.out.print(scaleModified.get(j) + "maj");
                    } else {
                        System.out.print(scaleModified.get(j) + "maj, ");
                    }
                } else {
                    System.out.print(scaleModified.get(j) + "dim, ");
                }
            }
        }
    }
}
