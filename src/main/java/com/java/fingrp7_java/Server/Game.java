package com.java.fingrp7_java.Server;

import WordyGame.NoPlayersAvailable;
import WordyGame.WordyGamePlayer;

import java.util.ArrayList;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    public static ArrayList<WordyGamePlayer> players = new ArrayList<>();
    private String gameID;
    private String status;
    private WordyGamePlayer host; // host id
    private Timer timer = new Timer();
    private WordyGamePlayer winner;


    public Game(WordyGamePlayer host) {
        status = "Waiting";
        this.host = host;
        timer.schedule(new tenSecondTimer(), 10*1000);
    }

    public ArrayList<WordyGamePlayer> getClients() {
        return players;
    }

    public void setClients(ArrayList<WordyGamePlayer> clients) {
        this.players = clients;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    class tenSecondTimer extends TimerTask {
        public void run() {

            if (players.size() > 0 ) {
                System.out.println("Game starting...");
                status = "Match Started";
            } else {
                try {
                    status = "";
                    throw new NoPlayersAvailable("No other players have joined the game");
                } catch (NoPlayersAvailable e) {
                    throw new RuntimeException(e);
                }
            }
            timer.cancel();
        }
    }

    class roundCounter extends TimerTask     {
        public void run() {

        }
    }
}

