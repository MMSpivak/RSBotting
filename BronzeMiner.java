package scripts.Skilling;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.input.Keyboard;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import scripts.Actions;
import scripts.Objs;
import scripts.Timer;


import java.awt.*;
import java.awt.event.KeyEvent;


@ScriptManifest(name = "BronzeMiner", authors = { "Otterblast" }, category = "Mining")
public class BronzeMiner extends Script{


    final int[] TIN_ID = {11360,11361};
    final int[] COP_ID = {11161,10943};
    final int COP = 436;
    final int TIN = 438;
    final int[] PICKAXES = {1271, 1275,1265}; //adamant and rune pickaxe in order
    RSTile myPos = Player.getPosition();
    final RSArea BANK_AREA = new RSArea(new RSTile(3210,3220,2), new RSTile(3207, 3218,2));
    final RSArea ORE_AREA = new RSArea(new RSTile(3222,3149,0), new RSTile(3231,3145,0));
    Timer time = new Timer(3000);//time that rests until condition, allows dynamic sleeping


    private boolean onStart(){//useful for when you have GUI or multiple locations etc
        println("BronzeMiner has started.");
        equipPick();
        return true;
    }
    private boolean onStop(){
        println("BronzeMiner has ended.");
        return false;
    }

    @Override
    public void run() {

        if(onStart()){
            while (true){
                sleep(loop());
            }
        }

    }
    private int loop(){

        if(Inventory.isFull() || Inventory.getCount(2349) > 0){
            smith();
            RSTile myPos = Player.getPosition();
            if (!BANK_AREA.contains(myPos)) {
                WebWalking.walkTo(BANK_AREA.getRandomTile());
            }else{
                if(!Banking.isBankScreenOpen()){
                    Banking.openBank();
                }else {
                    Banking.depositAllExcept(PICKAXES);
                    sleep(1000);
                    Banking.close();
                }
            }
        }else{
            RSTile myPos = Player.getPosition();
            if (!ORE_AREA.contains(myPos)) {
                walkOre();
            }else {
                int i = General.random(1,2);
                if(i == 1) {//added randomness to either mine copper or tin first randomly
                    while (Inventory.getCount(COP) < 14) {
                        mineCop();
                        sleep(1000);
                        while (Player.getAnimation() == 625) {
                            sleep(100);
                        }
                    }
                    while (!Inventory.isFull()) {
                        mineTin();
                        sleep(1000);
                        while (Player.getAnimation() == 625) {
                            sleep(100);
                        }
                        if (Inventory.isFull()) {
                            break;
                        }
                    }
                }else{
                    while (Inventory.getCount(TIN) < 14) {
                        mineTin();
                        sleep(1000);
                        while (Player.getAnimation() == 625) {
                            sleep(100);
                        }
                    }
                    while (!Inventory.isFull()) {
                        mineCop();
                        sleep(1000);
                        while (Player.getAnimation() == 625) {
                            sleep(100);
                        }
                        if (Inventory.isFull()) {
                            break;
                        }
                    }
                }
            }
        }

        return 50;
    }

    public static void equipPick() {
        final int[] PICKAXES = {1271, 1275,1265}; //adamant and rune pickaxe in order
        if(Equipment.isEquipped(PICKAXES)){
            General.println("Pickaxe already equipped.");
        }else if(Inventory.find(PICKAXES) != null){
            RSItem[] pick = Inventory.find(PICKAXES);
            Clicking.click("Equip",pick);
            General.sleep(200,400);
            General.println("Attempting to equip pickaxe.");
        }else if((Inventory.find(PICKAXES) == null) && !Equipment.isEquipped(PICKAXES)){
            General.println("No pickaxe found in inventory or equipped, going to bank to get one.");
            final RSArea BANK_AREA = new RSArea(new RSTile(3210,3220,2), new RSTile(3207, 3218,2));
            WebWalking.walkTo(BANK_AREA.getRandomTile());
            Actions.sleepWhileMoving();
            Banking.openBank();
            Actions.sleepWhileMoving();
            Banking.depositAllExcept(PICKAXES);
            Banking.withdraw(1,PICKAXES);
            Banking.close();
            General.sleep(500,1000);
            RSItem[] pick = Inventory.find(PICKAXES);
            Clicking.click("Equip",pick);
        }

    }

    public int walkBank(){
        final RSArea BANK_AREA = new RSArea(new RSTile(3210,3220,2), new RSTile(3207, 3218,2));
        RSTile myPos = Player.getPosition();
        sleep(50);
        if (!BANK_AREA.contains(myPos)) {
            WebWalking.walkTo(BANK_AREA.getRandomTile());
        }
        return 50;
    }

    public int walkOre(){
        final RSArea ORE_AREA = new RSArea(new RSTile(3222,3149,0), new RSTile(3231,3145,0));
        RSTile myPos = Player.getPosition();
        if (!ORE_AREA.contains(myPos)) {
            WebWalking.walkTo(ORE_AREA.getRandomTile());
        }
        return 50;
    }

    public int mineTin(){
        final RSObject rock = findNearestObject(15, TIN_ID);
        if(rock != null){
            rock.click("Mine");
            time.reset();
            while(Player.getAnimation() == -1 && time.isRunning()) {//creates dynamic sleep so that if the player is running to the ore and timer hasn't run out we sleep
                sleep(100);
            }
        }
        return 10;
    }

    public int mineCop(){
        final RSObject rock = findNearestObject(15, COP_ID);
        if(rock != null){
            rock.click("Mine");
            time.reset();
            while(Player.getAnimation() == -1 && time.isRunning()){//creates dynamic sleep so that if the player is running to the ore and timer hasn't run out we sleep
                sleep(100);
            }
        }
        return 10;
    }

    public static void smith(){
        int COP = 436;
        int TIN = 438;
        RSItem[] cop = Inventory.find(COP);
        RSItem[] tin = Inventory.find(TIN);
        RSTile myPos = Player.getPosition();
        final RSArea SMITH_AREA = new RSArea(new RSTile(3225,3252,0), new RSTile(3227,3255,0));

        while(Inventory.getCount(COP) >0 && Inventory.getCount(TIN) >0){

            if(!SMITH_AREA.contains(myPos)){
                WebWalking.walkTo(SMITH_AREA.getRandomTile());
                Actions.sleepWhileMoving();
            }

            int[] furnace = {24009};
            RSObject furn = Objs.findNearestObject(15,furnace);

            if(furn == null){
                General.println("no furnace found");
            }else {
                Actions.attemptAimCamera(furn, 20);
                Clicking.click("Smelt",furn);
                Actions.sleepWhileMoving();
                Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
                Actions.sleepWhileSmith();
            }
        }
    }

    public RSObject findNearestObject(int distance, int[] objectName) {
        RSObject[] objects = Objects.findNearest(distance, objectName);
        for (RSObject object : objects) {
            if (object != null)
                return object;		}		return null;	}
}
