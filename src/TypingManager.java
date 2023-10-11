import processing.core.PApplet;

import java.io.IOException;
import java.util.ArrayList;

public class TypingManager {

    public static ArrayList<String> nouns = null;
    static {
        try {
            nouns = FileIO.readFile("data/nouns.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> adjectives = null;
    static {
        try {
            adjectives = FileIO.readFile("data/adjectives.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> verbs = null;
    static {
        try {
            verbs = FileIO.readFile("data/verbs.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> adverbs = null;
    static {
        try {
            adverbs = FileIO.readFile("data/adverbs.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String currentPhrase = "Welcome";
    private int currentIndex;
    private int backspacesRequired;

    public TypingManager() {
        pickNewPhrase();
        backspacesRequired = 0;
    }

    private void pickNewPhrase() {
        currentPhrase = adjectives.get((int)(Math.random()*adjectives.size()));
        currentPhrase += " " + nouns.get((int)(Math.random()*nouns.size()));
        //currentPhrase += " " + verbs.get((int)(Math.random()*verbs.size()));
        //currentPhrase += " " + adverbs.get((int)(Math.random()*adverbs.size()));
        currentIndex = 0;
    }

    public boolean acceptInput(PApplet source) {
        if (source.keyCode == source.SHIFT || source.keyCode == source.CONTROL || source.keyCode == source.ALT) {
            return false; // don't want to handle here
        }
        if (backspacesRequired > 0) {
            if (source.key == source.BACKSPACE) {
                backspacesRequired--;
            } else if (currentIndex + backspacesRequired < currentPhrase.length()) { // not @ end of word
                backspacesRequired++;
            }
        } else if (source.key == currentPhrase.charAt(currentIndex)) {
            currentIndex++;
            if (currentIndex == currentPhrase.length()) {
                pickNewPhrase();
            }
            return true;
        } else if (source.key != source.BACKSPACE) {
            backspacesRequired++;
        }
        return false;
    }

    public void draw(PApplet source) {
        while (source.textWidth(currentPhrase) > source.width) {
            pickNewPhrase();
        }

        source.noStroke();
        source.fill(200,200,200);
        source.textSize(40);
        source.textAlign(source.LEFT, source.CENTER);
        source.rect(0, 0, source.width-1, 50);

        float totalWidth = source.textWidth(currentPhrase);
        float left = (float)source.width/2 - totalWidth/2;
        float height = 50/2 - 3;

        String typed = currentPhrase.substring(0, currentIndex);
        String backspace = currentPhrase.substring(currentIndex, currentIndex + backspacesRequired);
        backspace = backspace.replace(' ', '_');
        String remaining = currentPhrase.substring(currentIndex + backspacesRequired);

        source.fill(0,0,0);
        source.text(typed, left, height);
        source.fill(255,0,0);
        source.text(backspace, left + source.textWidth(typed), height);
        source.fill(120,120,120);
        source.text(remaining, left + source.textWidth(typed + backspace), height);
    }
}
