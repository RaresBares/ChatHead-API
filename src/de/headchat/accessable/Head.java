package de.headchat.accessable;

import de.headchat.accessable.api.Map_Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.UUID;

import static de.headchat.accessable.HeadFactory.insert;

public class Head {

    private UUID uuid;
    private int ScaleX;
    private int ScaleY;

    public Head(UUID uid, int scalex, int scaley) {
        uuid = uid;
        ScaleX = scalex;
        ScaleY = scaley;
    }

    public String[][] getMessage() throws Exception {

        URL url = new URL("https://crafatar.com/avatars/" + this.uuid.toString().replace("-", ""));
        BufferedImage bi = ImageIO.read(url);

        String[][] msg = new String[8][8];

        for (int x = 0; x < (bi.getWidth()); x += 160/ScaleX) {
            for (int y = 0; y < (bi.getHeight()); y += 160/ScaleY) {
                Color m = new Color(bi.getRGB(x, y));
                msg[(x) / (160/ScaleX)][(y) / (160/ScaleY)] = Map_Utils.RoundColor(m.getRed(), m.getGreen(), m.getBlue()) + "▓";
            }

        }

        return msg;
    }

    public int getScaleX() {
        return ScaleX;
    }

    public int getScaleY() {
        return ScaleY;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setScaleX(int scaleX) {
        ScaleX = scaleX;
    }

    public void setScaleY(int scaleY) {
        ScaleY = scaleY;
    }

    public String[] formattoMCode() throws Exception {
        String[][] msg = this.getMessage();
        String[] ret = new String[ScaleY];
        for (int x = 1; x <= ScaleY; x++) {
            String m = "";
            for (int y = 1; y <= ScaleX; y++) {
                m += msg[y - 1][x - 1];

            }
            m = "§" + insert(m, "§", 2);

            m += " ";
            ret[x] = m;
            m = "";



        }
        return ret;
    }
}
