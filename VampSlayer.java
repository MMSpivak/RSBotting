package RSBot.Quests;
import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.script.Script;


@ScriptManifest(author = "Otterblast", name = "VampSlayer", info = "Walking to Lumby", version = 0.1, logo = "")
//take some stuff out of vamp slayer and into own functions to make easier to debug if necessary
public class VampSlayer extends Script {
	public int onLoop() throws InterruptedException {
		
		//Position 
		if(!inventory.contains("Potato")) {
			pickPotato();
		}else {
			
			vampSlayer();
			
		}
		
		return 500;
	}
	
	public void vampSlayer() throws InterruptedException{
		
		NPC Morg = npcs.closest("Morgan");
		Area morg = new Area(3097, 3268, 3099, 3269);
		walking.webWalk(morg.getRandomPosition());
		shortTermAntiban();
		Morg.interact("Talk-to");
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().selectOption(2);
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		//now go get garlic
		Position gar = new Position(3096, 3270, 1);
		walking.webWalk(gar);
		shortTermAntiban();
		Entity cupb = objects.closest("Cupboard");
		shortTermAntiban();
		cupb.interact("Open");
		shortTermAntiban();
		sleep(random(2000,4000));
		cupb.interact("Search");
		shortTermAntiban();
		sleep(random(2000,4000));
		//now head to varrok, get 2gp from bank and talk to dude
		if(inventory.getAmount("Coins")<3 || !inventory.contains("Beer") || !inventory.contains("Hammer")) {
			Area bankarea = new Area(3183, 3435, 3185, 3438);
			Area inn = new Area(3218, 3402, 3226, 3393);
			NPC bartender = npcs.closest("Bartender");
			Area store = new Area(3216, 3415, 3217, 3414);
			NPC shopk = npcs.closest("Shop keeper");
			RS2Widget buyhammer = this.widgets.get(300, 16, 11);
			
			walking.webWalk(bankarea.getRandomPosition());
			shortTermAntiban();
			getBank().open();
			shortTermAntiban();
			getBank().withdraw("Coins", 3);
			shortTermAntiban();
			
			walking.webWalk(store.getRandomPosition());
			shortTermAntiban();
			shopk.interact("Trade");
			shortTermAntiban();
			buyhammer.interact("Buy 1");
			shortTermAntiban();
			
			walking.webWalk(inn.getRandomPosition());
			shortTermAntiban();
			bartender.interact("Talk-to");
			shortTermAntiban();
			sleep(random(2000,4000));
			this.getDialogues().clickContinue();
			shortTermAntiban();
			sleep(random(2000,4000));
			this.getDialogues().selectOption(1);
			shortTermAntiban();
			sleep(random(2000,4000));
			this.getDialogues().clickContinue();
			shortTermAntiban();
			sleep(random(2000,4000));
			this.getDialogues().clickContinue();
			shortTermAntiban();
			sleep(random(2000,4000));
			
		}
		Area inn = new Area(3218, 3402, 3226, 3393);
		walking.webWalk(inn.getRandomPosition());
		NPC har = npcs.closest("Dr Harlow");
		shortTermAntiban();
		har.interact("Talk-to");
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().selectOption(2);
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		har.interact("Talk-to");
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		this.getDialogues().clickContinue();
		shortTermAntiban();
		sleep(random(2000,4000));
		//time to go fight vampire
		String[] sword = {
               "Bronze sword"
        };
		String[] shield = {
	               "Wooden shield"
	        };
		//equip sword
		if(!inventory.contains(sword) && !equipment.contains(sword)) {
			Area bankarea = new Area(3183, 3435, 3185, 3438);
			walking.webWalk(bankarea.getRandomPosition());
			shortTermAntiban();
			getBank().open();
			shortTermAntiban();
			getBank().withdraw("Bronze sword", 1);
			shortTermAntiban();
			getInventory().getItem("Bronze sword").interact("Wield");
			shortTermAntiban();
			
		}else if(!equipment.contains(sword) && inventory.contains(sword)) {
			getInventory().getItem("Bronze sword").interact("Wield");
			shortTermAntiban();
		}
		//equip shield
		if(!inventory.contains(shield) && !equipment.contains(shield)) {
			Area bankarea = new Area(3183, 3435, 3185, 3438);
			walking.webWalk(bankarea.getRandomPosition());
			shortTermAntiban();
			getBank().open();
			shortTermAntiban();
			getBank().withdraw("Wooden shield", 1);
			shortTermAntiban();
			getInventory().getItem("Wooden shield").interact("Wield");
			shortTermAntiban();
			
		}else if(!equipment.contains(shield) && inventory.contains(shield)) {
			getInventory().getItem("Wooden shield").interact("Wield");
			shortTermAntiban();
		}
		Position coffin = new Position(3078, 9773, 0);
		log("walking to coffin make sure works");
		walking.webWalk(coffin);
		shortTermAntiban();
		Entity cof = objects.closest("Coffin");
		shortTermAntiban();
		cof.interact("Open");
		shortTermAntiban();
		sleep(5000);
		NPC count = npcs.closest("Count Draynor");
		count.interact("Attack");
		sleep(1000);
		int maxHP = skills.getStatic(Skill.HITPOINTS);
		
		while(myPlayer().isUnderAttack() || myPlayer().isAnimating() || count.isInteracting(myPlayer())) {//doesn't include myPlayer().moving so that if we click on a goblin thats around a long corner it can update and choose new closest goblin
			
			int currHP = skills.getDynamic(Skill.HITPOINTS);//initialize it right here so can be updated so we eat randomly
			while(currHP <= (maxHP / 2 + (int)random(-2,1)) && inventory.contains("Potato")){
				
				inventory.getItem("Potato").interact("Eat");
				currHP = currHP + 1;
				sleep(random(2000,3000));
				
			}
			
			
			if(!inventory.contains("Potato")) {
				log("out of potatoes make sure everything goes right");
				pickPotato();
				shortTermAntiban();
				walking.webWalk(coffin);
				shortTermAntiban();
				shortTermAntiban();
				cof.interact("Open");
				shortTermAntiban();
				sleep(5000);
				count = count;//I think reassigns who count is so can kill him
				count.interact("Attack");
				sleep(1000);
			}
			
			shortTermAntiban();
			
		}
		
		
	}
	
	public void pickPotato() throws InterruptedException{//creates a function
		
	Area field = new Area(3140, 3290, 3156, 3281);
	
		
	while(inventory.getAmount("Potato") <= 20)	{
		
	if(!field.contains(myPlayer())) {
		
		walking.webWalk(field.getRandomPosition());
		if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
        	sleep(random(5000,40000));
        }else {sleep(random(1000,3000));}
		
	}else {
		Entity potato = objects.closest("Potato");
		potato.interact("Pick");
		shortTermAntiban();
		if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
        	sleep(random(5000,40000));
        }else {sleep(random(2000,3000));}
		
	}
		
	}
	
}
	
	public void randomSleep() throws InterruptedException {
		
		int sleepint = (int)random(0,100);
		
		if (sleepint <= 75) { // short term sleep
			sleep(random(459,1500));
		}
		
		else if(sleepint <= 90) {  // medium sleep
			sleep(random(3500,7000));
		}
		
		else if (sleepint <= 100) {  // long sleep
			sleep(random(9000,13000));
		}
		
		else {
			log("There was an error with randomsleep() antiban");
		}
		
	}

	public void cameraRotation() throws InterruptedException {
		
		//log("Antiban = Moving the camera");
		int lowSide = (int)random(1,4);
		int highSide = (int)random(5,10);
		int medLowSide = (int)random(10,15);
		int medHighSide = (int)random(35,60);
		int highLowSide = (int)random(70,100);
		int highHighSide = (int)random(200,300);
		int cameraRotRandom = (int)random(0,1000);
		//int cameraAngle = (int)camera.getPitchAngle(); // did we want to do anything with this?
		
		// twitch
		if (cameraRotRandom <= 200) {
			//log("antiban, move camera, twitch");
			int twitchRandom = (int)random(1,4);
			
			if (twitchRandom == 1) {
				camera.movePitch(random(lowSide,highSide));
			}
			
			else if (twitchRandom == 2) {
				camera.moveYaw(random(lowSide,highSide));
			}
			
			else {
				if(random(0,3) == 1) {
					camera.moveYaw((random(lowSide,highSide)));
					sleep(random(100,300));
					camera.movePitch((random(lowSide,highSide)));
				}
				
				else {
					camera.movePitch(random(lowSide,highSide));
					sleep(random(100,300));
					camera.moveYaw((random(lowSide,highSide)));
				}
			}
		}		
		
		// medium movements
		
		else if (cameraRotRandom <= 900) {
			//log("antiban, move camera, medium");
			int medtwitchRandom = (int)random(1,4);
			
			if (medtwitchRandom == 1) {
				camera.movePitch(random(medLowSide,medHighSide));
			}
			
			else if (medtwitchRandom == 2) {
				camera.moveYaw(random(medLowSide,medHighSide));
			}
			
			else {
				if(random(0,3) == 1) {
					camera.moveYaw((random(medLowSide,medHighSide)));
					sleep(random(100,300));
					camera.movePitch((random(medLowSide,medHighSide)));
				}
				
				else {
					camera.movePitch(random(medLowSide,medHighSide));
					sleep(random(100,300));
					camera.moveYaw((random(medLowSide,medHighSide)));
				}
			}
			
		}
		
		// complete rotations
		
		else if (cameraRotRandom <= 1000) {
			//log("antiban, move camera, long rotation");
			int hightwitchRandom = (int)random(1,4);
			
			if (hightwitchRandom == 1) {
				camera.movePitch(random(highLowSide,highHighSide));
			}
			
			else if (hightwitchRandom == 2) {
				camera.moveYaw(random(highLowSide,highHighSide));
			}
			
			else {
				if(random(0,3) == 1) {
					camera.moveYaw((random(highLowSide,highHighSide)));
					sleep(random(100,300));
					camera.movePitch((random(highLowSide,highHighSide)));
				}
				
				else {
					camera.movePitch(random(highLowSide,highHighSide));
					sleep(random(100,300));
					camera.moveYaw((random(highLowSide,highHighSide)));
				}
			}
			
		}else {
			log("something went wrong with antiban camera rotation");
		}
		
		
		
		
	}
	
	public void mouseMovements() throws InterruptedException{  // random mouse movements over the screen
		//log("antiban, mouse movements");
		
		int intMouseX = (int)random(10,700);
		int intMouseY = (int)random(10,400);
		int randomMouse = (int)random(0,1000);
		
		// small movements
		if (randomMouse <= 400) {
			getMouse().move(intMouseX,intMouseY);
			sleep(random(100,300));
			getMouse().move((intMouseX + random(20,70)),(intMouseY + random(10,50)));
			sleep(random(100,300));
		
			if (randomMouse <= 300) {
				getMouse().move((intMouseX + random(20,70)),(intMouseY + random(10,50)));
				sleep(random(100,300));
			}
			
			else if (randomMouse <= 375) {
				getMouse().move((intMouseX + random(20,70)),(intMouseY + random(10,50)));
				sleep(random(100,300));
				getMouse().move((intMouseX + random(20,70)),(intMouseY + random(10,50)));
				sleep(random(100,300));
				
			}
		}
		
		// medium movements
		else if (randomMouse <= 800) {
			getMouse().move(intMouseX,intMouseY);
			sleep(random(100,300));
			getMouse().move((intMouseX + random(100,200)),(intMouseY + random(100,200)));
			sleep(random(100,300));
		
			if (randomMouse <= 600) {
				getMouse().move((intMouseX + random(100,200)),(intMouseY + random(100,200)));
				sleep(random(100,300));
			}
			
			else if (randomMouse <= 675) {
				getMouse().move((intMouseX + random(100,200)),(intMouseY + random(100,200)));
				sleep(random(100,300));
				getMouse().move((intMouseX + random(100,200)),(intMouseY + random(100,200)));
				sleep(random(100,300));
			
			}
		}
		
		// large movements
		else if (randomMouse <= 1000) {
			getMouse().move(intMouseX,intMouseY);
			sleep(random(100,300));
			getMouse().move((intMouseX + random(200,300)),(intMouseY + random(200,300)));
			sleep(random(100,300));
		
			if (randomMouse <= 950) {
				getMouse().move((intMouseX + random(200,300)),(intMouseY + random(200,300)));
				sleep(random(100,300));
			}
			
			else if (randomMouse <= 990) {
				getMouse().move((intMouseX + random(200,300)),(intMouseY + random(200,300)));
				sleep(random(100,300));
				getMouse().move((intMouseX + random(200,300)),(intMouseY + random(200,300)));
				sleep(random(100,300));
			
			}
		}else {
			log("something went wrong with antiban mouse movement");
		}
		
		
		
		
	} 
	
	public void shortTermAntiban() throws InterruptedException {
		
		int shortChoice = (int)random(0,1000);
		
		if (shortChoice <= 600) {
			randomSleep();
		}
		
		else if (shortChoice <= 800) {
			cameraRotation();
		}
		
		else if (shortChoice <= 1000) {
			mouseMovements();
		}
		
		else {
			log("error with antiban shortTermAntiban");
		}
	}
		
}
