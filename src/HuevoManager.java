import processing.core.PApplet;

import java.util.ArrayList;

public class HuevoManager {

    private String saveFile;

    private double numHuevos;
    private long lastUpdated;
    private double currentHuevoRate;
    private double huevoMultiplier;

    public HuevoManager() {
        this.lastUpdated = System.currentTimeMillis();
        this.huevoMultiplier = 1;
        getNumHuevos();
    }

    /**
     * Calculates and retrieves the number of eggs that
     * the user has at the time of this method call.
     * @return the current number of eggs
     */
    public double getNumHuevos() {
        long now = System.currentTimeMillis();
        double secondsSince = (now-lastUpdated)/1000.0;
        numHuevos += currentHuevoRate*secondsSince*huevoMultiplier;
        lastUpdated = now;
        return numHuevos;
    }

    public void addTypedHuevos() {
        numHuevos++;
        // TODO
    }

    public void removeHuevos(double toRemove) {
        numHuevos -= toRemove;
    }

    public void unlockUpgrade(int upgradeID) {
        // upgrades.get(upgradeID).unlock();
        // update();
    }

    public void update(ArrayList<Building> buildings, ArrayList<Upgrade> upgrades) {
        currentHuevoRate = 0;
        for (Building b : buildings) {
            currentHuevoRate += b.getTotalHPS();
        }
        //for (Upgrade u : upgrades) {
            //some code with u.getEffect()
        //}
    }

    public void draw(PApplet source) {
        source.noStroke();
        source.fill(200,200,200);
        source.textSize(40);
        source.textAlign(source.CENTER, source.CENTER);
        source.rect(0, source.height-50, source.width-1, 50);
        source.fill(50,50,50);
        source.text((int)Math.floor(getNumHuevos()) + " huevos (" + currentHuevoRate + " HPS)",
                (float)source.width/2, (float)source.height - 50.0f/2 - 3);
    }

}
