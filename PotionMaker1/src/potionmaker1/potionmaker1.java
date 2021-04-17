//package potionmaker1;

//import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

import java.awt.*;

import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.api.Keyboard;
import org.osbot.rs07.api.Bank;
import org.osbot.rs07.api.Inventory;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.utility.ConditionalSleep;

@ScriptManifest(author = "mjbraun95", info = "fletches bows", logo = "", name = "potionmaker1", version = 1.0)
public class fletcher extends Script {
//    public Inventory inv;
//    public String ingredientType;
//    public String bowType;
//    public RS2Object banker;
    public Bank bank;
    public String ingredientType = "Eye of newt";
    public String unfPotionType = "Guam potion (unf)";
    public char fletchNum = '4';
//    public void getInv() {
//        inv = getInventory();
//    }
    public void slep(int ms) {
        new ConditionalSleep(ms) {
            @Override
            public boolean condition() {
//                        return !getInventory().isFull();
                return false;
            }
        }.sleep();
    }

    @Override
    public void onStart() {

        log("started!");
//        Scanner user_in = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter log type");

//        ingredientType = user_in.nextLine();  // Read user input
        log("Log type is: " + ingredientType);  // Output user input
//        banker = getObjects().closest("Banker");
//        if (getObjects().closest("Banker") != null) {
//            log("banker is present!");
//            bank.getBank();
//        }
//        else {
//            log("banker is not present. Exiting");
////            System.exit(1);
//        }
    }
//    getExperience(Skill skill)
    @Override
    public int onLoop() throws InterruptedException {
        int herblore_level = getSkills().getVirtualLevel(Skill.FLETCHING);
        log("fletch level: " + herblore_level);
        if (herblore_level < 4) {
            log("herblore less than 4");
        }
        else if (herblore_level >= 4 && herblore_level < 5) {
            ingredientType = "Eye of newt";
            unfPotionType = "Guam potion (unf)";
        }
        else if (herblore_level >= 5 && herblore_level < 15) {
            ingredientType = "Unicorn horn dust";
            unfPotionType = "Marrentill potion (unf)";
        }
        else if (herblore_level >= 15 && herblore_level < 30) {
            ingredientType = "Ashes";
            unfPotionType = "Tarromin potion (unf)";
        }
        else if (herblore_level >= 30 && herblore_level < 34) {
            ingredientType = "White berries";
            unfPotionType = "Ranarr potion (unf)";
        }
        else if (herblore_level >= 34 && herblore_level < 36) {
            ingredientType = "Toad's legs";
            unfPotionType = "Toadflax potion (unf)";
        }
        else if (herblore_level >= 36 && herblore_level < 38) {
            ingredientType = "Goat horn dust";
            unfPotionType = "Harralander potion (unf)";
        }
        else if (herblore_level >= 38 && herblore_level < 45) {
            ingredientType = "Snape grass";
            unfPotionType = "Ranarr potion (unf)";
        }
        else if (herblore_level >= 45 herblore_level < 55) {
            ingredientType = "Eye of newt";
            unfPotionType = "Irit potion (unf)";
        }
        else if (herblore_level >= 55 && herblore_level < 63) {
            ingredientType = "Limpwurt root";
            unfPotionType = "Kwuarm potion (unf)";
        }
        else if (herblore_level >= 63 && herblore_level < 66) {
            ingredientType = "Red spiders' eggs";
            unfPotionType = "Snapdragon potion (unf)";
        }
        else if (herblore_level >= 66 && herblore_level < 76) {
            ingredientType = "White berries";
            unfPotionType = "Cadantine potion (unf)";
        }
        else if (herblore_level >= 76 && herblore_level < 81) {
            ingredientType = "Potato cactus";
            unfPotionType = "Lantadyme potion (unf)";
        }
        else if (herblore_level >= 81 && herblore_level < 87) {
            ingredientType = "Crushed nest";
            unfPotionType = "Toadflax potion (unf)";
        }
        else if (herblore_level >= 87 && herblore_level < 98) {
            ingredientType = "Zulrah's scales";
            unfPotionType = "Antidote++ (4)";
        }
        else if (herblore_level >= 98 && herblore_level < 99) {
            ingredientType = "Lava scale shard";
            unfPotionType = "Super antifire potion (4)";
        }

//		banker.interact("Bank");
        bank = getBank();
        bank.open();
        sleep(random(789,972));
        bank.depositAll();
        sleep(random(223,369));
        bank.withdraw("Knife", 1);
        bank.withdraw(ingredientType, 27);
        sleep(random(789,972));
        bank.close();
        if (!getInventory().contains(ingredientType) || !getInventory().contains("Knife")) {
            log("did not successfully withdraw. Exiting");
//            System.exit(1);
        }
        else {
            log("Withdrew items successfully!");
        }
//        if(!getInventory().isFull()) {
//            log("Inventory not full");
//        }
//        else {
//            log("Inventory full");
//        }
//        if(getInventory().isEmpty()) {
//            log("Inventory empty");
//        }
//        else {
//            log("Inventory not empty");
//        }
        getInventory().getItem("Knife").interact("Use");;
        sleep(random(223,369));
        getInventory().getItem(ingredientType).interact();
        sleep(random(1254,1391));
//        new ConditionalSleep(5000) {
//            @Override
//            public boolean condition() {
////                        return !getInventory().isFull();
//                return false;
//            }
//        }.sleep();

        keyboard.typeKey(fletchNum);

        sleep(random(1254,1391));
        new ConditionalSleep(49000) {
            @Override
            public boolean condition() {
                  return !myPlayer().isAnimating();
            }
        }.sleep();
        sleep(random(223,369));
//        sleep(random(48798,50242));
//        sleep(random(4000,20000));
//        new ConditionalSleep(5000) {
//            @Override
//            public boolean condition() {
////                        return !getInventory().isFull();
//                return false;
//            }
//        }.sleep();
        return 500;
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onPaint(Graphics2D g) {
//        g.drawString("Hello World", 50, 50);
    }
}
