package de.headchat.accessable;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeadFactory {

    public static Head createHead(UUID uid){
        return new Head(uid ,8 ,8);
    }
    public static Head createHead(UUID uid ,int ScaleX, int ScaleY){
        return new Head(uid ,ScaleX ,ScaleY);
    }
    public static Head createHead(UUID uid ,int ScaleX){
        return new Head(uid ,8 ,0);
    }
    public static String[] formattoMCode(String[][] msg, Head h){
        String[] ret = new String[8];
        for (int x = 1; x <= 8; x++) {
            String m = "";
            for (int y = 1; y <= 8; y++) {
                m += msg[y - 1][x - 1];

            }
            m = "§" + insert(m, "§", 2);

            m += " ";
            ret[x] = m;
            m = "";



        }
        return ret;
    }
    protected static String insert(String text, String insert, int period) {
        Pattern p = Pattern.compile("(.{" + period + "})", Pattern.DOTALL);
        Matcher m = p.matcher(text);
        return m.replaceAll("$1" + insert);
    }

}
