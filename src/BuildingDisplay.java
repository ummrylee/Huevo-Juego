import processing.core.PApplet;

import java.util.ArrayList;

public class BuildingDisplay {

    public BuildingDisplay() {

    }

    public void draw(PApplet source, ArrayList<Building> buildings) {
        source.stroke(0);
        source.textSize(20);
        source.textAlign(source.LEFT, source.CENTER);

        float x = 60;
        float y = 60;
        for (Building b : buildings) {
            source.fill(200,200,200);
            source.rect(x, y, 185, 50);
            source.fill(0);
            source.text(Building.buildingNames[b.buildingID] + " (" + (int)b.nextCost() + ")",
                    x + 5, y + 25 - 3);
            y += 50;
            if (y >= 300) {
                x += 195;
                y = 60;
            }
        }
    }

}
