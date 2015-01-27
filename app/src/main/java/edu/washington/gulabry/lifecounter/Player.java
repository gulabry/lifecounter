package edu.washington.gulabry.lifecounter;

/**
 * Created by gulabry on 1/27/15.
 */
public class Player {

    private String playerNumber;
    private int life;

    public Player(String playerNumber) {
        this.playerNumber = playerNumber;
        this.life = 20;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int add) {
        this.life += add;
    }

    public String getPlayerNumber() {
        return this.playerNumber;
    }

}
