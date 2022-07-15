package src.Equipment;

import src.Equipment.Armors.ClothArmor;
import src.Equipment.Armors.IronArmor;
import src.Equipment.Armors.LeatherArmor;
import src.Equipment.Weapons.Axes.BronzeAxe;
import src.Equipment.Weapons.Axes.IronAxe;
import src.Equipment.Weapons.Axes.StoneAxe;
import src.Equipment.Weapons.Shields.BronzeShield;
import src.Equipment.Weapons.Shields.IronShield;
import src.Equipment.Weapons.Shields.WoodenShield;
import src.Equipment.Weapons.Swords.BronzeSword;
import src.Equipment.Weapons.Swords.IronSword;
import src.Equipment.Weapons.Swords.WoodenSword;

import java.util.Random;

/**
 * The Drops class holds an instance of every potential drop and controls when and what is dropped
 *
 * @author Cole Glass
 */
public class Drops {
    Equipment woodenSword = new WoodenSword();
    Equipment bronzeSword = new BronzeSword();
    Equipment ironSword = new IronSword();

    Equipment woodenShield = new WoodenShield();
    Equipment bronzeShield = new BronzeShield();
    Equipment ironShield = new IronShield();

    Equipment stoneAxe = new StoneAxe();
    Equipment bronzeAxe = new BronzeAxe();
    Equipment ironAxe = new IronAxe();

    Equipment clothArmor = new ClothArmor();
    Equipment leatherArmor = new LeatherArmor();
    Equipment ironArmor = new IronArmor();

    Random rand = new Random();

    public Drops() {
    }

    /**
     * Gets a random equipment and returns it
     *
     * @return Equipment
     */
    public Equipment getDroppedItem() {
        int flag = rand.nextInt(11);
        switch (flag) {
            case (0):
                return woodenSword;
            case (1):
                return woodenShield;
            case (2):
                return stoneAxe;
            case (3):
                return clothArmor;
            case (4):
                return bronzeSword;
            case (5):
                return bronzeShield;
            case (6):
                return bronzeAxe;
            case (7):
                return leatherArmor;
            case (8):
                return ironSword;
            case (9):
                return ironShield;
            case (10):
                return ironAxe;
            default:
                return ironArmor;
        }
    }
}
