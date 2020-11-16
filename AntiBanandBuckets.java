package RSBot;

import org.osbot.rs07.api.Bank;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.map.Position;
import java.util.List;
import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.api.model.Player;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.api.ui.Tab;
import java.util.Random;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.script.Script;

@ScriptManifest(author = "Boomerwangs", name = "AntiBanandBuckets", info = "Walking to Lumby", version = 0.1, logo = "")
public class AntiBanandBuckets extends Script
{
    public void doFishAntiban() throws InterruptedException {
        this.log("Fish antiban activated");
        if (this.myPlayer().isAnimating()) {
            final Random rand = new Random();
            final int high = 10;
            final int result = rand.nextInt(high);
            if (result == 1) {
                this.log("Antiban option 1 in use, hover fishing skill");
                this.getTabs().open(Tab.SKILLS);
                sleep((long)(100 + random(300, 700)));
                this.getWidgets().get(320, 9).hover();
                sleep((long)random(2000, 3000));
                this.getTabs().open(Tab.INVENTORY);
                sleep((long)random(100, 300));
            }
            else if (result == 2) {
                this.log("Antiban option 2 in use, do nothing");
            }
            else if (result == 3) {
                this.log("Antiban option 3 in use, slightly rotate camera");
                final int targetPitch = random(40, 45);
                this.camera.movePitch(targetPitch);
                sleep((long)random(100, 300));
            }
            else if (result == 4) {
                this.log("Antiban option 4 in use, hover mouse over fishing spot");
                final RS2Object fishspothover = (RS2Object)this.getObjects().closest(new String[] { "Fishing spot" });
                fishspothover.hover();
                sleep((long)random(500, 1000));
            }
            else if (result == 5) {
                this.log("Antiban option 5 in use, clicking some tabs");
                this.getTabs().open(Tab.PRAYER);
                sleep((long)random(100, 400));
                this.getTabs().open(Tab.MAGIC);
                sleep((long)random(1000, 1200));
                this.getTabs().open(Tab.PRAYER);
                sleep((long)random(100, 2000));
                this.getTabs().open(Tab.FRIENDS);
                sleep((long)random(100, 543));
            }
            else if (result == 6) {
                this.log("Anitban option 6 in use, move camera a lot");
                final int targetPitch = random(10, 70);
                this.camera.movePitch(targetPitch);
                sleep((long)random(100, 300));
            }
            else if (result == 7) {
                this.log("Anitban option 7 in use, hover over rowboat");
                final RS2Object rowboat = (RS2Object)this.getObjects().closest(new String[] { "Rowboat" });
                rowboat.hover();
                sleep((long)random(500, 1000));
            }
            else if (result == 8) {
                this.log("Antiban option 8 in use, hover mouse over fishing spot");
                final RS2Object fishspothover = (RS2Object)this.getObjects().closest(new String[] { "Fishing spot" });
                fishspothover.hover();
                sleep((long)random(500, 1000));
            }
            else {
                this.log("Anitban passed");
            }
        }
    }
    
    public void doGeneralAntiban() throws InterruptedException {
        final Random rand = new Random();
        switch (12) {
            case 1: {
                this.log("General Antiban 1 - random pitch movement");
                final int targetPitch = random(22, 67);
                this.getCamera().movePitch(targetPitch);
                break;
            }
            case 2: {
                this.log("General Antiban 2 - short pause");
                sleep((long)random(200, 1000));
                break;
            }
            case 3: {
                this.log("General Antiban 3 - skills then inventory");
                this.getTabs().open(Tab.SKILLS);
                sleep((long)(100 + random(1000, 1700)));
                this.getTabs().open(Tab.INVENTORY);
                sleep((long)random(100, 300));
                break;
            }
            case 4: {
                this.log("General Antiban 3 -  check friends then inventory");
                this.getTabs().open(Tab.FRIENDS);
                sleep((long)(100 + random(800, 1200)));
                this.getTabs().open(Tab.INVENTORY);
                sleep((long)random(100, 400));
                break;
            }
            case 5: {
                this.log("General Antiban 5 - misclick quest then skill then inventory");
                this.getTabs().open(Tab.QUEST);
                sleep((long)random(150, 450));
                this.getTabs().open(Tab.SKILLS);
                sleep((long)random(400, 900));
                this.getTabs().open(Tab.INVENTORY);
                sleep((long)random(400, 900));
                break;
            }
            case 6: {
                this.log("General Antiban 6 - slightly rotate camera pitch");
                final int randomPitch = random(1, 7);
                final int comboPitch = randomPitch + this.getCamera().getPitchAngle();
                this.getCamera().movePitch(comboPitch);
                sleep((long)random(100, 500));
                break;
            }
            case 7: {
                this.log("General Antiban 7 - slightly rotate camera pitch down");
                final int randomPitch2 = random(1, 7);
                final int comboPitch2 = this.getCamera().getPitchAngle() - randomPitch2;
                this.getCamera().movePitch(comboPitch2);
                sleep((long)random(100, 500));
                break;
            }
            case 8: {
                this.log("General Antiban 8 - reset camera and move mouse random location");
                final RS2Widget compass = this.widgets.get(164, 29);
                compass.interact(new String[] { "Look North" });
                sleep((long)random(200, 400));
                final int randomX = random(84, 492);
                final int randomY = random(15, 279);
                this.getMouse().move(randomX, randomY);
                sleep((long)random(250, 500));
                break;
            }
            case 9: {
                this.log("General Antiban 9 - moderatley rotate camera pitch");
                final int randomPitch3 = random(1, 30);
                final int randomPitch4 = random(1, 30);
                final int comboPitch3 = this.getCamera().getPitchAngle() - randomPitch3 + randomPitch4;
                this.getCamera().movePitch(comboPitch3);
                sleep((long)random(100, 500));
                break;
            }
            case 10: {
                this.log("General Antiban 10 - random mouse movement into inventory area");
                final int randomX2 = random(579, 742);
                final int randomY2 = random(175, 400);
                this.getMouse().move(randomX2, randomY2);
                sleep((long)random(250, 700));
                break;
            }
            case 11: {
                this.log("General Antiban 11 - small mouse movements");
                final int randomX3 = random(485, 558);
                final int randomY3 = random(145, 220);
                final int randomX4 = random(400, 570);
                final int randomY4 = random(175, 270);
                final int randomX5 = random(485, 558);
                final int randomY5 = random(200, 295);
                this.getMouse().move(randomX3, randomY3);
                sleep((long)random(50, 250));
                this.getMouse().move(randomX4, randomY4);
                sleep((long)random(50, 250));
                this.getMouse().move(randomX5, randomY5);
                sleep((long)random(50, 250));
                break;
            }
            case 12: {
                this.log("General Antiban 12 - hover over player");
                final Random randplayer = new Random();
                if (this.getPlayers().getAll() == null) {
                    break;
                }
                final List<Player> p = (List<Player>)this.getPlayers().getAll();
                final int randomNum = randplayer.nextInt(p.size() - 1 - 0 + 1) + 0;
                final Player randomPlayer = p.get(randomNum);
                if (randomPlayer != null) {
                    randomPlayer.hover();
                    sleep((long)random(700, 1400));
                    break;
                }
                break;
            }
            case 13: {
                this.log("General Antiban - move mouse near skill tab");
                final int randomX6 = random(484, 716);
                final int randomY6 = random(321, 462);
                final int randomX7 = random(480, 720);
                final int randomY7 = random(321, 462);
                final int randomX8 = random(480, 720);
                final int randomY8 = random(320, 460);
                this.getMouse().move(randomX6, randomY6);
                sleep((long)random(50, 250));
                this.getMouse().move(randomX7, randomY7);
                sleep((long)random(50, 250));
                this.getMouse().move(randomX8, randomY8);
                sleep((long)random(50, 250));
                break;
            }
            case 14: {
                this.log("General Antiban - move mouse in middle");
                final int randomX9 = random(153, 453);
                final int randomY9 = random(102, 245);
                final int randomX10 = random(153, 453);
                final int randomY10 = random(102, 245);
                final int randomX11 = random(153, 453);
                final int randomY11 = random(102, 245);
                this.getMouse().move(randomX9, randomY9);
                sleep((long)random(50, 250));
                this.getMouse().move(randomX10, randomY10);
                sleep((long)random(50, 250));
                this.getMouse().move(randomX11, randomY11);
                sleep((long)random(50, 250));
                break;
            }
            case 15: {
                this.log("General Antiban 15 - slightly move camera yaw");
                final int randomYaw1 = random(1, 30);
                final int randomYaw2 = random(1, 30);
                final int comboYaw1 = this.getCamera().getPitchAngle() - randomYaw1 + randomYaw2;
                this.getCamera().moveYaw(comboYaw1);
            }
            case 16: {
                this.log("General Antiban 16 - moderatley move camera yaw");
                final int randomYaw3 = random(1, 50);
                final int randomYaw4 = random(1, 50);
                final int comboYaw2 = this.getCamera().getPitchAngle() - randomYaw3 + randomYaw4;
                this.getCamera().moveYaw(comboYaw2);
                break;
            }
        }
    }
    
    public void doComplexAntiban() throws InterruptedException {
    }
    
    public void walkGE() throws InterruptedException {
        final Position GE1 = new Position(3168, 3488, 0);
        final Position GE2 = new Position(3166, 3487, 0);
        final Position GE3 = new Position(3165, 3487, 0);
        final Position GE4 = new Position(3162, 3488, 0);
        final Position GE5 = new Position(3161, 3486, 0);
        final Position GE6 = new Position(3162, 3485, 0);
        final Position GE7 = new Position(3166, 3492, 0);
        final Position GE8 = new Position(3168, 3491, 0);
        final Position GE9 = new Position(3169, 3490, 0);
        final Position GE10 = new Position(3164, 3487, 0);
        final Random rand = new Random();
        final int high = 10;
        final int result = rand.nextInt(high);
        if (result == 1) {
            this.log("Walking to GE1");
            this.walking.webWalk(new Position[] { GE1 });
            sleep((long)random(1000, 10000));
        }
        else if (result == 2) {
            this.log("Walking to GE2");
            this.walking.webWalk(new Position[] { GE2 });
            sleep((long)random(1000, 10000));
        }
        else if (result == 3) {
            this.log("Walking to GE3");
            this.walking.webWalk(new Position[] { GE3 });
            sleep((long)random(1000, 10000));
        }
        else if (result == 4) {
            this.log("Walking to GE4");
            this.walking.webWalk(new Position[] { GE4 });
            sleep((long)random(1000, 10000));
        }
        else if (result == 5) {
            this.log("Walking to GE5");
            this.walking.webWalk(new Position[] { GE5 });
            sleep((long)random(1000, 10000));
        }
        else if (result == 6) {
            this.log("Walking to GE6");
            this.walking.webWalk(new Position[] { GE6 });
            sleep((long)random(1000, 10000));
        }
        else if (result == 7) {
            this.log("Walking to GE7");
            this.walking.webWalk(new Position[] { GE7 });
            sleep((long)random(1000, 10000));
        }
        else if (result == 8) {
            this.log("Walking to GE8");
            this.walking.webWalk(new Position[] { GE8 });
            sleep((long)random(1000, 10000));
        }
        else if (result == 9) {
            this.log("Walking to GE9");
            this.walking.webWalk(new Position[] { GE9 });
            sleep((long)random(1000, 10000));
        }
        else {
            this.log("Walking to GE10");
            this.walking.webWalk(new Position[] { GE10 });
            sleep((long)random(1000, 10000));
        }
    }
    
    public void fillBuckets() throws InterruptedException {
        this.log("started bucket filling");
        sleep((long)random(1000, 2000));
        final NPC banker = (NPC)this.npcs.closest(new String[] { "Banker" });
        banker.interact(new String[] { "Bank" });
        sleep((long)random(1000, 1200));
        this.getBank().depositAll();
        sleep((long)random(500, 1000));
        this.getBank().withdrawAll("Bucket");
        sleep((long)random(500, 1000));
        this.getBank().close();
        sleep((long)random(500, 2000));
        final Area fountain1 = new Area(3189, 3473, 3192, 3469);
        this.walking.webWalk(new Area[] { fountain1 });
        sleep((long)random(1000, 4000));
        final RS2Object fountain2 = (RS2Object)this.objects.closest(new String[] { "Fountain" });
        this.getInventory().getItem(new String[] { "Bucket" }).interact(new String[] { "Use" });
        sleep((long)random(1000, 2000));
        fountain2.interact(new String[] { "Use" });
        sleep((long)random(18000, 24000));
        if (!this.getInventory().contains(new String[] { "Bucket of water" }) && this.getInventory().contains(new String[] { "Bucket" })) {
            final RS2Object fountain3 = (RS2Object)this.objects.closest(new String[] { "Fountain" });
            this.getInventory().getItem(new String[] { "Bucket" }).interact(new String[] { "Use" });
            sleep((long)random(1000, 2000));
            fountain3.interact(new String[] { "Use" });
            sleep((long)random(18000, 24000));
        }
        this.walkGE();
        banker.interact(new String[] { "Bank" });
        sleep((long)random(1000, 2200));
        this.getBank().depositAll();
        sleep((long)random(2000, 3000));
        this.getBank().close();
        sleep((long)random(400, 900));
    }
    
    public void buyBuckets() throws InterruptedException {
        this.log("Buying buckets");
        final int bucketprice = 8;
        this.walkGE();
        this.log("logged you walked to ge");
        final NPC banker = (NPC)this.npcs.closest(new String[] { "Banker" });
        banker.interact(new String[] { "Bank" });
        sleep((long)random(1000, 1600));
        this.getBank().depositAll();
        sleep((long)random(500, 1000));
        this.getBank().depositWornItems();
        sleep((long)random(1000, 2000));
        this.log("Deposited items");
        sleep((long)random(1000, 2000));
        if (this.getBank().getItem(new String[] { "Coins" }).getAmount() < 56 * bucketprice) {
            this.getBank().withdrawAll("Coins");
            sleep((long)random(500, 3000));
        }
        else {
            if (this.getBank().getItem(new String[] { "Coins" }).getAmount() < 56 * bucketprice) {
                sleep((long)random(500, 3000));
                return;
            }
            this.getBank().withdraw("Coins", 448);
            sleep((long)random(500, 3000));
        }
        this.getBank().close();
        sleep((long)random(500, 3000));
        final int bucketsToBuy = (int)(this.inventory.getAmount(new String[] { "Coins" }) / bucketprice);
        sleep((long)random(100, 400));
        final NPC geClerk = (NPC)this.npcs.closest(new String[] { "Grand Exchange Clerk" });
        geClerk.interact(new String[] { "Exchange" });
        sleep((long)random(500, 3000));
        this.getGrandExchange().buyItem(1925, "Bucket", bucketprice, bucketsToBuy);
        sleep((long)random(10000, 15000));
        this.getGrandExchange().collect();
        sleep((long)random(1000, 2000));
    }
    
    public void sellBuckets() throws InterruptedException {
        this.log("Selling Buckets");
        sleep((long)random(500, 1500));
        final int bucketsellprice = 18;
        final NPC banker2 = (NPC)this.npcs.closest(new String[] { "Banker" });
        banker2.interact(new String[] { "Bank" });
        sleep((long)random(1000, 2000));
        this.getBank().depositAll();
        sleep((long)random(1000, 2000));
        this.getBank().enableMode(Bank.BankMode.WITHDRAW_NOTE);
        sleep((long)random(1000, 2000));
        this.getBank().withdrawAll("Bucket of water");
        sleep((long)random(1000, 2000));
        this.getBank().close();
        sleep((long)random(1000, 3000));
        final NPC geClerk2 = (NPC)this.npcs.closest(new String[] { "Grand Exchange Clerk" });
        geClerk2.interact(new String[] { "Exchange" });
        sleep((long)random(1000, 3000));
        this.getGrandExchange().sellItem(1930, bucketsellprice, 999);
        sleep((long)random(10000, 20000));
        this.getGrandExchange().collect();
        this.log("sold all the buckets of water");
        this.walkGE();
        banker2.interact(new String[] { "Bank" });
        sleep((long)random(1000, 3000));
        this.getBank().depositAll();
        sleep((long)random(1000, 3000));
        this.log("Deposited the booty in the bank");
    }
    
    public void doBuckets() throws InterruptedException {
        this.log("Doing master buckets");
        this.buyBuckets();
        this.walkGE();
        this.fillBuckets();
        this.sellBuckets();
        this.buyBuckets();
        this.walkGE();
        this.fillBuckets();
        this.sellBuckets();
        this.buyBuckets();
        this.walkGE();
        this.fillBuckets();
        this.sellBuckets();
    }
    
    public void onStart() {
        this.log("Starting!");
    }
    
    public int onLoop() throws InterruptedException {
        this.doGeneralAntiban();
        this.log("here");
        sleep((long)random(5000, 7000));
        return 500;
    }
    
    public void onExit() {
    	//if(between.contains(myPlayer())) {
			//walking.walk(bankarea.getRandomPosition());
//			if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
 //           	sleep(random(5000,40000));
   //         }else {sleep(random(3000,6000));}
	//	}else {
		//	if(oaks.contains(myPlayer())) {
			//	walking.walk(between.getRandomPosition());
				//if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
                	//sleep(random(5000,40000));
                //}else {sleep(random(3000,6000));}
//			}else {
//				walking.webWalk(bankarea.getRandomPosition());
	//			log("something wrong with walking to bankarea");
//				if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
  //              	sleep(random(5000,40000));
    //            }else {sleep(random(5000,6000));
    //            getBank().open();
      //          }
		//	}

    }
}
