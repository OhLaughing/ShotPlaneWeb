package com.bigwanggang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gustaov on 2018/3/7.
 */
public class Util {
    public static final Pattern p = Pattern.compile("x:(\\d+),y:(\\d+)");

    public static Point getPoint(String s) {
        Matcher m = p.matcher(s);
        int x = -1;
        int y = -1;
        if(m.find()) {
            x = Integer.parseInt(m.group(1));
            y = Integer.parseInt(m.group(2));
        }
        return new Point(x, y);
    }
}
