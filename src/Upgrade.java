import java.util.ArrayList;

public class Upgrade {

    public static final String[] upgradeNames = new String[] {
            "Boiled Egg",
            "Coddled Egg",
            "Fried Egg",
            "Eggs in a Basket",
            "Poached Egg",
            "Basted Eggs",
            "Scrambled Egg",
            "Egg Tart",
            "Buttered Egg",
            "Deviled Egg",
            "Egg Salad",
            "Century Egg",
            "Eggs Benedict",
            "Scotch Egg",
            "Tea Egg"
    };

    private static final int[] hpsEffect = new int[] {
            3,
            2,
            2,
            3,
            3,
            3,
            2,
            3,
            2,
            2,
            2,
            2,
            2,
            2,
            3,
    };

    private static final String[] typeAffected = new String[] {
            "Chickens",
            "HuevoMultiplier",
            "Bowl",
            "WordValue",
            "FryingPan",
            "HuevoMultiplier",
            "Whisk",
            "Spatula",
            "WordValue",
            "Toppings",
            "HuevoMultiplier",
            "Separator",
            "Slicer",
            "Topper",
            "Chef"
    };

    public final int upgradeID;
    private int WordHuevosValue = 1;
    private int GlobalMultiplierEffect = 1;

    private boolean unlocked;

    public Upgrade(int upgradeID) {
        this.upgradeID = upgradeID;
        this.unlocked = false;
    }

    public Upgrade(String data) {
        String[] values = data.split(FileIO.ENTRY_SEPARATOR);
        this.upgradeID = Integer.parseInt(values[0]);
        this.unlocked = Boolean.parseBoolean(values[1]);
    }

    public void unlock() {
        this.unlocked = true;
    }

    public static String[] getEffects()
    {
        ArrayList<String> upgradeEffects = new ArrayList<>();
        for(int i = 0; i < upgradeNames.length; i++)
        {
            upgradeEffects.add(upgradeNames[i]);
            upgradeEffects.add(Integer.toString(hpsEffect[i]));
            upgradeEffects.add(typeAffected[i]);
        }
        String[] str = new String[upgradeEffects.size()];
        Object[] objArr = upgradeEffects.toArray();
        int i = 0;
        for (Object obj : objArr) {
            str[i++] = (String)obj;
        }
        return (str);
    }

    public String exportInfo() {
        return upgradeID + FileIO.ENTRY_SEPARATOR + this.unlocked;
    }
}
