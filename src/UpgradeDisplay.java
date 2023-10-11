import processing.core.PApplet;

public class UpgradeDisplay {
    public UpgradeDisplay(){

    }
    public void draw(PApplet source) {
        source.rect(0, 50, source.width / 3, (source.height-100) / 5);
        source.textSize(20);
        source.stroke(0);
        source.fill(0,0,0);
        source.text("Boiled Egg", 70, 80);
        source.fill(255);
        source.rect(0, 130, source.width / 3, (source.height-100) / 5);
        source.rect(0, 210, source.width / 3, (source.height-100) / 5);
        source.rect(0, 290, source.width / 3, (source.height-100) / 5);
        source.rect(0, 370, source.width / 3, (source.height-100) / 5);
        source.rect(166, 50, source.width / 3, (source.height-100) / 5);
        source.rect(166, 130, source.width / 3, (source.height-100) / 5);
        source.rect(166, 210, source.width / 3, (source.height-100) / 5);
        source.rect(166, 290, source.width / 3, (source.height-100) / 5);
        source.rect(166, 370, source.width / 3, (source.height-100) / 5);
        source.rect(332, 50, source.width / 3, (source.height-100) / 5);
        source.rect(332, 130, source.width / 3, (source.height-100) / 5);
        source.rect(332, 210, source.width / 3, (source.height-100) / 5);
        source.rect(332, 290, source.width / 3, (source.height-100) / 5);
        source.rect(332, 370, source.width / 3, (source.height-100) / 5);
    }

}
