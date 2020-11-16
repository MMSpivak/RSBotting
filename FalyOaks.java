package RSBot.Woodcutting;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest(author = "Otterblast", info = "Cutting Oaks South of Falador", logo = "", name = "FalyOaks", version = 0.1)

//known bugs
//problem walking to bank

//Changes to make:
//update grabaxe lines to include iron and dragon and black axes




public class FalyOaks extends Script{
public void onStart(){
		
		log("started script");
		
	}
	
	public void onExit() {
		
		log("ended script");
		
    }
	
	public int onLoop() throws InterruptedException{
		
		if(!inventory.isFull()) {
			cutTree();
		}else if(inventory.isFull()) {
			walkBank();
		}
		
		return 500;
		
	}

public void walkBank() throws InterruptedException{
	
	Position bank = new Position(3013, 3356,0);
	Area bankarea = new Area(3011, 3356, 3015, 3355);
	Area walk1 = new Area(3008, 3326, 3006, 3324);
	Area walk2 = new Area(3008, 3342, 3006, 3340);
	Area falytrees = new Area(3005, 3310, 3011, 3319);
	String[] axes = {
            "Iron axe",
            "Mithril axe",
            "Rune axe",
            "Bronze axe",
            "Adamant axe"
    };
	while(inventory.contains("Oak logs")) {
		Position player = new Position(myPlayer().getPosition());
	if(bank.distance(player) < 10) {
		
			Entity bankbooth = objects.closest("Bank booth");
			bankbooth.interact("Bank");
			shortTermAntiban();
			sleep(random(3000,5000));
			getBank().depositAllExcept(axes);
			shortTermAntiban();
		
	}else {
		//walk to bank
		//log("started walking to bank");
		if(falytrees.contains(myPlayer())) {
			walking.walk(walk1.getRandomPosition());
			sleep(random(2000,3000));
			while(myPlayer().isAnimating() || myPlayer().isMoving()) {
				shortTermAntiban();
				sleep(random(1000,2500));
			}
			sleep(random(500,1500));
		}else if(walk1.contains(myPlayer())) {
			walking.walk(walk2.getRandomPosition());
			sleep(random(2000,3000));
			while(myPlayer().isAnimating() || myPlayer().isMoving()) {
				shortTermAntiban();
				sleep(random(1000,2500));
			}
			sleep(random(500,1500));
		}else if(walk2.contains(myPlayer())) {
			walking.walk(bankarea.getRandomPosition());
			sleep(random(2000,3000));
			while(myPlayer().isAnimating() || myPlayer().isMoving()) {
				shortTermAntiban();
				sleep(random(1000,2500));
			}
			sleep(random(500,1500));
		}else {
			log("problem walking to bank");
			walking.webWalk(bankarea.getRandomPosition());
			shortTermAntiban();
		}
		
	}
	}
	
}
	
public void cutTree() throws InterruptedException{
    	
	Area bankarea = new Area(3011, 3356, 3015, 3355);
	Area walk1 = new Area(3008, 3326, 3006, 3324);
	Area walk2 = new Area(3008, 3342, 3006, 3340);
	Area falytrees = new Area(3005, 3310, 3011, 3319);
    	Entity tree = objects.closest("Oak");
    	String[] axes = {
                "Bronze axe",
                "Iron axe",
                "Mithril axe",
                "Adamant axe",
                "Rune axe"
        };
    	//if(VWest.contains(myPlayer())) {
    	if(inventory.contains(axes) || equipment.contains(axes)) {
    		
    		if(falytrees.contains(myPlayer())){
    			tree.interact("Chop down");
    			sleep(random(500,1500));
    			while(myPlayer().isAnimating() || myPlayer().isMoving()) {
    				shortTermAntiban();
    				sleep(random(1000,3500));
    			}
    		
    		}else {
    			//walk to bank
    			//log("started walking to falytrees");
    			if(walk1.contains(myPlayer())) {
    				walking.walk(falytrees.getRandomPosition());
    				sleep(random(2000,3000));
    				while(myPlayer().isAnimating() || myPlayer().isMoving()) {
    					shortTermAntiban();
    					sleep(random(1000,2500));
    				}
    				sleep(random(500,1500));
    			}else if(walk2.contains(myPlayer())) {
    				walking.walk(walk1.getRandomPosition());
    				sleep(random(2000,3000));
    				while(myPlayer().isAnimating() || myPlayer().isMoving()) {
    					shortTermAntiban();
    					sleep(random(1000,2500));
    				}
    				sleep(random(500,1500));
    			}else if(bankarea.contains(myPlayer())) {
    				walking.walk(walk2.getRandomPosition());
    				sleep(random(2000,3000));
    				while(myPlayer().isAnimating() || myPlayer().isMoving()) {
    					shortTermAntiban();
    					sleep(random(1000,2500));
    				}
    				sleep(random(500,1500));
    			}else {
    				log("problem walking to falytrees");
    				walking.webWalk(falytrees.getRandomPosition());
    				shortTermAntiban();
    			}
    			
    		}
    	
    	
    	}else {
    		walking.webWalk(bankarea);
    		shortTermAntiban();
    		getBank().open();
    		shortTermAntiban();
    		getBank().depositAll();
    		getBank().depositWornItems();
    		shortTermAntiban();
    		
    		
    		int wc = skills.getStatic(Skill.WOODCUTTING);
    		
    		if(wc < 10 && getBank().contains(axes[0])) {
    		getBank().withdraw(axes[0], 1);
    		}else if(wc >= 21 && getBank().contains(axes[2]) && wc < 31) {
    			getBank().withdraw(axes[2], 1);
    		}else if(wc >= 31 && getBank().contains(axes[3]) && wc < 41) {
    			getBank().withdraw(axes[3], 1);
    		}else if(wc >= 41 && getBank().contains(axes[4])) {
    			getBank().withdraw(axes[4], 1);
    		}else if(wc >= 41 && !getBank().contains(axes[4]) && getBank().contains(axes[3])) {
    			getBank().withdraw(axes[3], 1);
    		}else if(wc >= 31 && !getBank().contains(axes[3]) && getBank().contains(axes[2])) {
    			getBank().withdraw(axes[2], 1);
    		}else if(wc >= 21 && !getBank().contains(axes[2]) && getBank().contains(axes[0])) {
    			getBank().withdraw(axes[0], 1);
    		}
    	}
    	//}else {
    		//walking.webWalk(trees.getRandomPosition());
    		//shortTermAntiban();
		//	randomSleep();
    	//}
    	
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
		
		if (shortChoice <= 350) {
			randomSleep();
		}
		
		else if (shortChoice <= 650) {
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