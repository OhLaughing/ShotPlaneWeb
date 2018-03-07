package com.bigwanggang;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PlayPlaneService {
    private boolean player1Ready = false;
    private boolean player2Ready = false;
    private Map<String, Point> heads = new HashMap<String ,Point>();

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
}
