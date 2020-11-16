package scripts.Quests;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.input.Keyboard;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.*;
import org.tribot.api2007.types.*;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import scripts.Actions;
import scripts.Objs;
import scripts.Timer;

import java.awt.event.KeyEvent;

@ScriptManifest(name = "TutIsland", authors = { "Otterblast" }, category = "Quests", description  = "Takes the bot through tutorial island.")
public class TutIsland extends Script{
    private boolean onStart(){//useful for when you have GUI or multiple locations etc
        println("TutIsland has started.");
        return true;
    }
    private boolean onStop(){
        println("TutIsland has ended.");
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
    Timer time = new Timer(3000);
    final RSArea Inst1 = new RSArea(new RSTile(3101,3098,0), new RSTile(3104,3095,0));
    int slp = General.random(500,3000);

    private int loop(){
        final int rand1 = General.random(140,250);
        final int rand2 = General.random(255,275);
        Mouse.click(rand1,rand2, 1);
        sleep(1000);
        Actions.typeRandKey(12);
        Keyboard.pressEnter();
        General.sleep(3000,5000);
        Mouse.clickBox(300,250,400,275,1);
        General.sleep(3000,5000);
        Actions.charCreate();
        RSNPC[] guide = NPCs.findNearest(3308);
        sleep(slp);
        Clicking.click("Talk-to",guide[0]);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(1500);
        Keyboard.typeString("2");
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        sleep(slp);
        Mouse.clickBox(670,471,690,490,1);
        sleep(slp);
        Mouse.clickBox(600,295,643,330,1);
        sleep(slp);
        Clicking.click("Talk-to",guide[0]);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        int[] door12 = {9398};
        Camera.turnToTile(new RSTile(3097,3107,0));
        RSObject Door12 = Objs.findNearestObject(30,door12);
        Clicking.click("open",Door12);
        Actions.sleepWhileMoving();
        Walking.clickTileMM(Inst1.getRandomTile(),1);
        Actions.sleepWhileMoving();

        //first instructor

        RSNPC[] inst1 = NPCs.findNearest(8503);
        Clicking.click("Talk-to",inst1[0]);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        Mouse.clickBox(630,172,650,200,1);
        sleep(slp);
        RSNPC[] fspot = NPCs.findNearest(3317);
        Actions.attemptAimCamera(fspot[0],30);
        Clicking.click("Net",fspot[0]);
        time.reset();
        while(Player.getAnimation() == -1 && time.isRunning()){//creates dynamic sleep so that if the player is running to the ore and timer hasn't run out we sleep
            sleep(100);
        }
        while(Player.getAnimation() == 621){
            sleep(100);
        }
        //GameTab.open(GameTab.TABS.STATS);
        sleep(slp);
        Actions.openSkills();
        sleep(slp);
        Actions.attemptAimCamera(inst1[0],30);
        Clicking.click("Talk-to",inst1[0]);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        General.sleep(2000,3000);
        final int[] Trees = {9730};
        final RSObject Tree = Objs.findNearestObject(15,Trees);
        Actions.attemptAimCamera(Tree,30);
        if(Tree != null){
            Tree.click("Chop down");
            time.reset();
            while((Player.getAnimation() == -1 && time.isRunning()) || Player.getAnimation() == 879){//creates dynamic sleep so that if the player is running to the ore and timer hasn't run out we sleep
                sleep(100);
            }
        }
        NPCChat.clickContinue(true);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        Walking.blindWalkTo(Inst1.getRandomTile());
        sleep(2000);
        RSItem[] box = Inventory.find(590);
        RSItem[] log = Inventory.find(2511);
        Clicking.click("Use",box);
        sleep(500);
        Clicking.click("Use",log);
        time.reset();
        while((Player.getAnimation() == -1 && time.isRunning()) || Player.getAnimation() == 733 || Player.isMoving()){//creates dynamic sleep so that if the player is running to the ore and timer hasn't run out we sleep
            sleep(100);
        }
        sleep(slp);
        RSItem[] fish = Inventory.find(2514);
        final int[] Fire = {26185};
        RSObject fire = Objs.findNearestObject(15,Fire);
        Clicking.click("Use",fish[0]);
        sleep(500);
        Clicking.click("Use Raw Shrimps ->",fire);
        time.reset();
        while((Player.getAnimation() == -1 && time.isRunning()) || Player.getAnimation() == 897){//creates dynamic sleep so that if the player is running to the ore and timer hasn't run out we sleep
            sleep(100);
        }
        sleep(500);

        //COOK INSTRUCTOR

        WebWalking.walkTo(new RSTile(3090,3092,0));
        Actions.sleepWhileMoving();
        final int[] Gate = {9708};
        RSObject gate = Objs.findNearestObject(15,Gate);
        Clicking.click("Open",gate);
        Actions.sleepWhileMoving();
        Walking.blindWalkTo(new RSTile(3083,3084,0));
        Actions.sleepWhileMoving();
        int[] Door = {9709};
        RSObject door = Objs.findNearestObject(30,Door);
        Actions.attemptAimCamera(door,1);
        Clicking.click("Open",door);
        Actions.sleepWhileMoving();
        sleep(slp);
        RSNPC[] cook = NPCs.findNearest(3305);
        Clicking.click("Talk-to",cook[0]);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        RSItem[] pot = Inventory.find(2516);
        RSItem[] water = Inventory.find(1929);
        Clicking.click("Use",pot);
        sleep(500);
        Clicking.click("Use",water);
        sleep(500);
        final int[] Range = {9736};
        RSObject range = Objs.findNearestObject(15,Range);
        Actions.attemptAimCamera(range,20);
        sleep(slp);
        Clicking.click("Cook",range);
        General.sleep(5000,6000);

        int[] Door2 = {9710};
        RSObject door2 = Objs.findNearestObject(30,Door2);
        Actions.attemptAimCamera(door2,1);
        Clicking.click("Open",door2);
        Actions.sleepWhileMoving();

        RSArea step1 = new RSArea(new RSTile(3073,3106,0),new RSTile(3069,3101,0));
        RSArea step2 = new RSArea(new RSTile(3077,3116,0),new RSTile(3071,3118,0));
        RSArea step3 = new RSArea(new RSTile(3078,3129,0),new RSTile(3082,3126,0));
        Walking.blindWalkTo(step1.getRandomTile());
        Actions.sleepWhileMoving();
        Walking.blindWalkTo(step2.getRandomTile());
        Actions.sleepWhileMoving();
        Walking.blindWalkTo(step3.getRandomTile());
        Actions.sleepWhileMoving();
        int[] Door3 = {9716};
        RSObject door3 = Objs.findNearestObject(30,Door3);
        Actions.attemptAimCamera(door3,1);
        Clicking.click("Open",door3);
        Actions.sleepWhileMoving();


        //QUEST INSTRUCTOR

        RSNPC[] quest = NPCs.findNearest(3312);
        Actions.attemptAimCamera(quest[0],15);
        Clicking.click("Talk-to",quest[0]);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        //GameTab.open(GameTab.TABS.QUESTS);
        Actions.openQuests();
        Actions.attemptAimCamera(quest[0],15);
        Clicking.click("Talk-to",quest[0]);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);



        //walk to mining area
        final int[] Ladder = {9726};
        RSObject ladder1 = Objs.findNearestObject(15,Ladder);
        Actions.attemptAimCamera(ladder1,1);
        Clicking.click("Climb-down", ladder1);
        Actions.sleepWhileMoving();

        //MINING INSTRUCTOR

        final RSArea minearea = new RSArea(new RSTile(3083,9510,0), new RSTile(3079,9507,0));
        Walking.clickTileMM(minearea.getRandomTile(),1);
        Actions.sleepWhileMoving();
        RSNPC[] mineinst = NPCs.findNearest(3311);
        Actions.attemptAimCamera(mineinst[0],15);
        Clicking.click("Talk-to",mineinst);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        final int[] TIN_ID = {10080};
        final int[] COP_ID = {10079};
        final int[] ANVIL = {2097};
        final int[] FURNACE = {10082};
        RSObject rock =Objs.findNearestObject(15, TIN_ID);
        if(rock != null){
            Actions.attemptAimCamera(rock,15);
            rock.click("Mine");
            time.reset();
            while((Player.getAnimation() == -1 && time.isRunning()) || Player.getAnimation() == 625) {//creates dynamic sleep so that if the player is running to the ore and timer hasn't run out we sleep
                sleep(100);
            }
        }
        RSObject rock2 = Objs.findNearestObject(15, COP_ID);
        if(rock2 != null){
            Actions.attemptAimCamera(rock2,15);
            rock2.click("Mine");
            time.reset();
            while((Player.getAnimation() == -1 && time.isRunning()) || Player.getAnimation() == 625) {//creates dynamic sleep so that if the player is running to the ore and timer hasn't run out we sleep
                sleep(100);
            }
        }
        sleep(500);
        RSObject furnace = Objs.findNearestObject(15, FURNACE);
        RSObject anvil = Objs.findNearestObject(15, ANVIL);
        Actions.attemptAimCamera(furnace,20);
        furnace.click("Use");
        sleep(5000);
        Actions.attemptAimCamera(mineinst[0],15);
        Clicking.click("Talk-to",mineinst);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        Actions.attemptAimCamera(anvil,20);
        anvil.click("Smith");
        sleep(3218);
        String smt = "Smith";
        String smt2 = "Smith Bronze Dagger";
        RSInterface int1 = Interfaces.findWhereAction(smt);
        if(int1 == null){
            println("interface not found");
        }else{
            Clicking.click(smt2,int1);
            sleep(3218);
        }

        //Start of moving to and completing combat instructor

        final RSArea combarea = new RSArea(new RSTile(3105,9506,0), new RSTile(3107,9508,0));
        WebWalking.walkTo(combarea.getRandomTile());
        Actions.sleepWhileMoving();
        RSNPC[] combinstr = NPCs.findNearest(3307);
        Clicking.click("Talk-to",combinstr);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        //GameTab.open(GameTab.TABS.EQUIPMENT);
        Actions.openEquipment();
        Mouse.clickBox(560,415,590,446,1);
        sleep(slp);
        RSItem[] dagger = Inventory.find(1205);
        Clicking.click("Equip",dagger);
        sleep(slp);
        Mouse.clickBox(484,21,497,31,1);
        sleep(slp);
        Clicking.click("Talk-to",combinstr);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        RSItem[] sword = Inventory.find(1277);
        RSItem[] shield = Inventory.find(1171);
        Clicking.click("Wield",sword);
        sleep(slp);
        Clicking.click("Wield",shield);
        sleep(slp);
        //GameTab.open(GameTab.TABS.COMBAT);
        Actions.openCombat();
        sleep(slp);
        RSArea rats = new RSArea(new RSTile(3101,9516,0), new RSTile(3108,9520,0));
        WebWalking.walkTo(rats.getRandomTile());
        Actions.sleepWhileMoving();
        RSNPC[] rat = NPCs.findNearest(3313);
        Actions.attemptAimCamera(rat[0],30);
        Clicking.click("Attack", rat[0]);
        Actions.sleepWhileMelee();
        WebWalking.walkTo(combarea.getRandomTile());
        Actions.sleepWhileMoving();
        Clicking.click("Talk-to",combinstr);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        RSItem[] bow = Inventory.find(841);
        RSItem[] arrows = Inventory.find(882);
        Clicking.click("Wield",bow);
        Clicking.click("Wield",arrows);
        sleep(slp);
        RSNPC[] rat2 = NPCs.findNearest(3313);
        Actions.attemptAimCamera(rat2[0],30);
        Clicking.click("Attack", rat2[0]);
        Actions.sleepWhileRanged();
        Walking.clickTileMM(new RSTile(3111,9515,0),1);
        Actions.sleepWhileMoving();
        Walking.clickTileMM(new RSTile(3111,9525,0),1);
        Actions.sleepWhileMoving();
        final int[] Ladder2 = {9727};
        RSObject ladder2 = Objs.findNearestObject(15,Ladder2);
        Actions.attemptAimCamera(ladder2,30);
        sleep(slp);
        Clicking.click("Climb-up", ladder2);
        Actions.sleepWhileMoving();

        //banking and polls

        final RSArea bankarea = new RSArea(new RSTile(3120,3121,0), new RSTile(3121,3123,0));
        WebWalking.walkTo(bankarea.getRandomTile());
        Actions.sleepWhileMoving();
        Banking.openBank();
        Actions.sleepWhileMoving();
        Mouse.clickBox(484,21,497,31,1);
        General.sleep(500,1000);
        final int[] pollb = {26815};
        RSObject pollB = Objs.findNearestObject(15,pollb);
        Clicking.click("Use", pollB);
        sleep(1260);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);

        //ACCOUNT GUIDE

        WebWalking.walkTo(new RSTile(3126,3124,0));
        Actions.sleepWhileMoving();
        RSNPC[] accguy = NPCs.findNearest(3310);
        Clicking.click("Talk-to",accguy);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Mouse.clickBox(604,469,628,496,1);
        sleep(slp);
        Clicking.click("Talk-to",accguy);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        General.sleep(2000,4000);

        //PRAYER INSTR
        WebWalking.walkTo(new RSTile(3127,3106,0));
        Actions.sleepWhileMoving();
        RSNPC[] brother = NPCs.findNearest(3319);
        Actions.attemptAimCamera(brother[0],10);
        Clicking.click("Talk-to",brother);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        Actions.openPray();
        //GameTab.open(GameTab.TABS.PRAYERS);
        Actions.attemptAimCamera(brother[0],10);
        Clicking.click("Talk-to",brother);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        //GameTab.open(GameTab.TABS.FRIENDS);
        Actions.openFriends();
        Actions.attemptAimCamera(brother[0],10);
        Clicking.click("Talk-to",brother);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);

        //WIZ INSTR

        WebWalking.walkTo(new RSTile(3141,3087,0));
        sleep(7364);
        RSNPC[] wiz = NPCs.findNearest(3309);
        Actions.attemptAimCamera(wiz[0],10);
        Clicking.click("Talk-to",wiz);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        //GameTab.open(GameTab.TABS.MAGIC);
        Actions.openMagic();
        Actions.attemptAimCamera(wiz[0],10);
        Clicking.click("Talk-to",wiz);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);

        RSNPC[] chicken = NPCs.findNearest(3316);
        Magic.selectSpell("Wind Strike");
        sleep(slp);
        Clicking.click("Cast Wind Strike ->",chicken);
        sleep(slp);
        General.sleep(4000,7000);
        Actions.attemptAimCamera(wiz[0],10);
        Clicking.click("Talk-to",wiz);
        Actions.sleepWhileMoving();
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeString("1");
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeKeys((char) KeyEvent.VK_SPACE);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        Keyboard.typeString("3");
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        NPCChat.clickContinue(true);
        sleep(slp);
        println("end");



        return 50;
    }
    public boolean chooseChatOption(final String option){
        General.println(String.format(option));
        return NPCChat.selectOption(option,true);
    }

}