package com.bigwanggang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gustaov on 2018/3/7.
 */
public class Util {
    public static final Pattern POINTPATTERN = Pattern.compile("x:(\\d+),y:(\\d+)");
    public static final Pattern POSITIONPATTERN = Pattern.compile("p:(\\d+)");

    public static Point getPoint(String s) {
        Matcher m = POINTPATTERN.matcher(s);
        int x = -1;
        int y = -1;
        if(m.find()) {
            x = Integer.parseInt(m.group(1));
            y = Integer.parseInt(m.group(2));
        }
        return new Point(x, y);
    }
    public static int getPosition(String s) {
        Matcher m = POSITIONPATTERN.matcher(s);
        int p = -1;
        if(m.find()) {
            p = Integer.parseInt(m.group(1));
        }
        return p;
    }
}
