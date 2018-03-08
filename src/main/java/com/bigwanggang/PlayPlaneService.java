package com.bigwanggang;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class PlayPlaneService {
    private boolean player1Ready = false;
    private boolean player2Ready = false;
    private Map<String, Point> heads = new HashMap<String, Point>();
    private Map<String, Set<Point>> planeBodys = new HashMap<String, Set<Point>>();

    public boolean isGameBegin() {
        return player1Ready && player2Ready;
    }

    public void setPlayer1Ready(boolean player1Ready) {
        this.player1Ready = player1Ready;
    }

    public void setPlayer2Ready(boolean player2Ready) {
        this.player2Ready = player2Ready;
    }

    public void addHead(String name, Point point) {
        heads.put(name, point);
    }

    public Point getHead(String name) {
        return heads.get(name);
    }

    public void addBody(String name, Point p, int position) {
        Set<Point> points = new HashSet<Point>();
        int x = p.getX();
        int y = p.getY();
        switch (position) {
            case 0:
                for (int i = -2; i <= 2; i++) {
                    points.add(new Point(x + i, y + 1));
                }
                points.add(new Point(x, y + 2));
                for (int i = -1; i <= 1; i++) {
                    points.add(new Point(x + i, y + 3));
                }
                break;
            case 1:
                for (int i = -2; i <= 2; i++) {
                    points.add(new Point(x - 1, y + i));
                }
                points.add(new Point(x - 2, y));
                for (int i = -1; i <= 1; i++) {
                    points.add(new Point(x - 3, y + i));
                }
                break;
            case 2:
                for (int i = -2; i <= 2; i++) {
                    points.add(new Point(x + i, y - 1));
                }
                points.add(new Point(x, y - 2));
                for (int i = -1; i <= 1; i++) {
                    points.add(new Point(x + i, y - 3));
                }
                break;
            case 3:
                for (int i = -2; i <= 2; i++) {
                    points.add(new Point(x + 1, y + i));
                }
                points.add(new Point(x + 2, y));
                for (int i = -1; i <= 1; i++) {
                    points.add(new Point(x + 3, y + i));
                }
                break;
        }
        planeBodys.put(name, points);

    }

    public boolean ifShotBody(String name, Point point) {
        return planeBodys.get(name).contains(point);
    }
}
