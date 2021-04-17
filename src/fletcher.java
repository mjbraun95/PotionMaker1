//package fletcher1;

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

@ScriptManifest(author = "mjbraun95", info = "fletches bows", logo = "", name = "fletcher1", version = 1.0)
public class fletcher extends Script {
//    public Inventory inv;
//    public String logType;
//    public String bowType;
//    public RS2Object banker;
    public Bank bank;
    public String logType = "Maple Logs";
    public char fletchNum = '2';
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

//        logType = user_in.nextLine();  // Read user input
        log("Log type is: " + logType);  // Output user input
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
        int fletch_level = getSkills().getVirtualLevel(Skill.FLETCHING);
        log("fletch level: " + fletch_level);
        if (fletch_level < 5) {
            logType = "Logs";
            fletchNum = '1';
        }
        else if (fletch_level >= 5 && fletch_level < 10) {
            logType = "Logs";
            fletchNum = '3';
        }
        else if (fletch_level >= 10 && fletch_level < 20) {
            logType = "Logs";
            fletchNum = '4';
        }
        else if (fletch_level >= 20 && fletch_level < 25) {
            logType = "Oak Logs";
            fletchNum = '2';
        }
        else if (fletch_level >= 25 && fletch_level < 35) {
            logType = "Oak Logs";
            fletchNum = '3';
        }
        else if (fletch_level >= 35 && fletch_level < 40) {
            logType = "Willow Logs";
            fletchNum = '2';
        }
        else if (fletch_level >= 40 && fletch_level < 50) {
            logType = "Willow Logs";
            fletchNum = '3';
        }
        else if (fletch_level >= 50 && fletch_level < 55) {
            logType = "Maple Logs";
            fletchNum = '2';
        }
        else if (fletch_level >= 55 && fletch_level < 65) {
            logType = "Maple Logs";
            fletchNum = '3';
        }
        else if (fletch_level >= 65 && fletch_level < 70) {
            logType = "Yew Logs";
            fletchNum = '2';
        }
        else if (fletch_level >= 70 && fletch_level < 80) {
            logType = "Yew Logs";
            fletchNum = '3';
        }
        else if (fletch_level >= 80 && fletch_level < 84) {
            logType = "Magic Logs";
            fletchNum = '2';
        }

//		banker.interact("Bank");
        bank = getBank();
        bank.open();
        sleep(random(789,972));
        bank.depositAll();
        sleep(random(223,369));
        bank.withdraw("Knife", 1);
        bank.withdraw(logType, 27);
        sleep(random(789,972));
        bank.close();
        if (!getInventory().contains(logType) || !getInventory().contains("Knife")) {
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
        getInventory().getItem(logType).interact();
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
