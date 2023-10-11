import processing.core.PApplet;
import processing.core.PImage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayManager extends PApplet {

    private EggDisplay eDisplay;
    private BuildingDisplay bDisplay;
    private UpgradeDisplay uDisplay;
    private int activeDisplay = 0;

    private String saveFile;

    private ArrayList<Building> buildings;
    private ArrayList<Upgrade> upgrades;
    private HuevoManager huevoManager;
    private TypingManager typingManager;

    public DisplayManager(String saveFile) {
        this.saveFile = saveFile;
        this.buildings = new ArrayList<>();
        for (int i = 0; i < Building.buildingNames.length; i++) {
            buildings.add(new Building(i));
        }
        this.upgrades = new ArrayList<>();
    }

    // The statements in the setup() function
    // execute once when the program begins
    public void setup() {
        huevoManager = new HuevoManager();
        typingManager = new TypingManager();

        PImage background = loadImage("img"+FileIO.FILE_SEPARATOR+"farmbackground.jpg");
        background.resize(width, height);

        eDisplay = new EggDisplay(loadImage("img"+FileIO.FILE_SEPARATOR+"fallingegg.png"), background);
        bDisplay = new BuildingDisplay();
        uDisplay = new UpgradeDisplay();
    }

    // The statements in draw() are executed until the
    // program is stopped. Each statement is executed in
    // sequence and after the last line is read, the first
    // line is executed again.
    public void draw() {
        background(255);   // Clear the screen with a white background
        if (activeDisplay == 0) {
            eDisplay.draw(this);
        } else if (activeDisplay == 1) {
            bDisplay.draw(this, buildings);
        } else if (activeDisplay == 2) {
            uDisplay.draw(this);
        } else {
            throw new IllegalArgumentException("Invalid activeDisplay value: " + activeDisplay);
        }
        typingManager.draw(this);
        huevoManager.draw(this);
        stroke(0);
        fill(255);
        if (activeDisplay == 0 || activeDisplay == 2) {
            rect(0, height/2 - 25, 50, 50);
            line(10, height/2, 40, height/2);
            line(10, height/2, 15, height/2 - 5);
            line(10, height/2, 15, height/2 + 5);
        }
        if (activeDisplay == 0 || activeDisplay == 1) {
            rect(width - 50, height/2 - 25, 50, 50);
            line(width - 10, height/2, width - 40, height/2);
            line(width - 10, height/2, width - 15, height/2 - 5);
            line(width - 10, height/2, width - 15, height/2 + 5);
        }
    }

    public void keyPressed() {
        boolean addHuevos = typingManager.acceptInput(this);
        if (addHuevos) {
            huevoManager.addTypedHuevos();
            eDisplay.addfallingegg(width);
        }
    }

    public void mousePressed() {
        boolean leftRegion = mouseX > 0 && mouseX < 50 && mouseY > height/2 - 25 && mouseY < height/2 + 25;
        boolean rightRegion = mouseX > width-50 && mouseX < width && mouseY > height/2 - 25 && mouseY < height/2 + 25;
        if (leftRegion) {
            if (activeDisplay == 0) {
                activeDisplay = 1;
            } else if (activeDisplay == 2) {
                activeDisplay = 0;
            }
        } else if (rightRegion) {
            if (activeDisplay == 0) {
                activeDisplay = 2;
            } else if (activeDisplay == 1) {
                activeDisplay = 0;
            }
        }
        if (activeDisplay == 1) {
            if (mouseX > 60 && mouseX < 60 + 185 && mouseY > 60 && mouseY < 60 + 50) {
                if (buildings.get(0).nextCost() <= huevoManager.getNumHuevos()) {
                    buildings.get(0).add(1);
                    huevoManager.removeHuevos(buildings.get(0).nextCost());
                }

            } else if (mouseX > 60 && mouseX < 60 + 185 && mouseY > 60 + 50 && mouseY < 60 + 50*2) {
                if (buildings.get(1).nextCost() <= huevoManager.getNumHuevos()) {
                    buildings.get(1).add(1);
                    huevoManager.removeHuevos(buildings.get(1).nextCost());
                }
            } else if (mouseX > 60 && mouseX < 60 + 185 && mouseY > 60 + 50*2 && mouseY < 60 + 50*3) {
                if (buildings.get(2).nextCost() <= huevoManager.getNumHuevos()) {
                    buildings.get(2).add(1);
                    huevoManager.removeHuevos(buildings.get(2).nextCost());
                }
            } else if (mouseX > 60 && mouseX < 60 + 185 && mouseY > 60 + 50*3 && mouseY < 60 + 50*4) {
                if (buildings.get(3).nextCost() <= huevoManager.getNumHuevos()) {
                    buildings.get(3).add(1);
                    huevoManager.removeHuevos(buildings.get(3).nextCost());
                }
            } else if (mouseX > 60 && mouseX < 60 + 185 && mouseY > 60 + 50*4 && mouseY < 60 + 50*5) {
                if (buildings.get(4).nextCost() <= huevoManager.getNumHuevos()) {
                    buildings.get(4).add(1);
                    huevoManager.removeHuevos(buildings.get(4).nextCost());
                }
            } else if (mouseX > 255 && mouseX < 255 + 185 && mouseY > 60 && mouseY < 60 + 50) {
                if (buildings.get(5).nextCost() <= huevoManager.getNumHuevos()) {
                    buildings.get(5).add(1);
                    huevoManager.removeHuevos(buildings.get(5).nextCost());
                }
            } else if (mouseX > 255 && mouseX < 255 + 185 && mouseY > 60 + 50 && mouseY < 60 + 50*2) {
                if (buildings.get(6).nextCost() <= huevoManager.getNumHuevos()) {
                    buildings.get(6).add(1);
                    huevoManager.removeHuevos(buildings.get(6).nextCost());
                }
            } else if (mouseX > 255 && mouseX < 255 + 185 && mouseY > 60 + 50*2 && mouseY < 60 + 50*3) {
                if (buildings.get(7).nextCost() <= huevoManager.getNumHuevos()) {
                    buildings.get(7).add(1);
                    huevoManager.removeHuevos(buildings.get(7).nextCost());
                }
            } else if (mouseX > 255 && mouseX < 255 + 185 && mouseY > 60 + 50*3 && mouseY < 60 + 50*4) {
                if (buildings.get(8).nextCost() <= huevoManager.getNumHuevos()) {
                    buildings.get(8).add(1);
                    huevoManager.removeHuevos(buildings.get(8).nextCost());
                }
            } else if (mouseX > 255 && mouseX < 255 + 185 && mouseY > 60 + 50*4 && mouseY < 60 + 50*5) {
                if (buildings.get(9).nextCost() <= huevoManager.getNumHuevos()) {
                    buildings.get(9).add(1);
                    huevoManager.removeHuevos(buildings.get(9).nextCost());
                }
            }
            huevoManager.update(buildings, upgrades);
        }
    }

    public void save() {
        ArrayList<String> output = new ArrayList<>();
        for (Building b : buildings) {
            output.add(b.exportInfo());
        }
        try {
            FileIO.writeFile(saveFile, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        ArrayList<String> input;
        try {
            input = FileIO.readFile(saveFile);
        } catch (FileNotFoundException e) {
            System.out.println("No source file");
            for (int i = 0; i < Building.buildingNames.length; i++) {
                buildings.add(new Building(i));
            }
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        for (int i = 0; i < Building.buildingNames.length; i++) {
            buildings.add(new Building(input.get(i)));
        }
    }

}