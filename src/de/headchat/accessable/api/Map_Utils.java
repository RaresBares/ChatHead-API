package de.headchat.accessable.api;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
public class Map_Utils {

    protected static HashMap<MyPoint, ColorCodes> content = new HashMap<MyPoint, ColorCodes>();

    protected static void init() {

        for (ColorCodes c : ColorCodes.values()) {

            content.put(new MyPoint(c.r, c.g, c.b), c);

        }


    }

    public static String RoundColor(int r, int g, int b) {
        MyPoint p1 = new MyPoint(r, g, b);
        ArrayList<Double> dists = new ArrayList<>();
        HashMap<Double, MyPoint> cords = new HashMap<>();
        for (MyPoint c : content.keySet()) {
            double dist = p1.distance(c);
            dists.add(dist);
            cords.put(dist, c);
        }

        dists.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1.compareTo(o2);
            }
        });


        MyPoint c = cords.get(dists.get(0));
        return "" + content.get(c).getC();
    }


}
