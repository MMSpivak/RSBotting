package RSBot.Fish_Cook;

import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.utility.ConditionalSleep;
import org.osbot.rs07.script.Script;

//167 95 121
@ScriptManifest(author = "Otterblast", name = "StartFishCook", info = "get your fish/cook lvls up", version = 0.1, logo = "")
//buggy with beginer clue scrolls in a bottle


public class StartFishCook extends Script{
	
	public void onStart() throws InterruptedException {
		if(!inventory.contains("Tinderbox") || !inventory.contains("Bronze axe") || !inventory.contains("Small fishing net")){
		getSupplies();
		}
	}

	public int onLoop() throws InterruptedException {
		
		if(!inventory.contains("Raw shrimps")) {
			inventory.dropAll("Shrimps");
			shortTermAntiban();
			inventory.dropAll("Burnt shrimp");
			shortTermAntiban();
			inventory.dropAll("Anchovies");
			shortTermAntiban();
			inventory.dropAll("Burnt fish");
			shortTermAntiban();
			fish();
			
			
		}else {
			
			cook();
			
		}
		
		return 500;
	}
	
	public void fish() throws InterruptedException {
		//make sure to only fish 25 fish so have room to cook
		Area fisharea = new Area(3240,3150,3244,3158);
		if(fisharea.contains(myPlayer())) {
			
			while(inventory.getAmount("Raw shrimps") + inventory.getAmount("Raw anchovies") < 24) {
				
				NPC fishspot = npcs.closest("Fishing spot");
				fishspot.interact("Net");
				sleep(random(2000, 4000));
				while(myPlayer().isAnimating() || myPlayer().isMoving()){
					
					shortTermAntiban();
					sleep(random(1000,2500));
					
				}
				
				
			}
			
			while(inventory.getAmount("Raw shrimps") + inventory.getAmount("Raw anchovies") > 24) {
				inventory.drop("Raw shrimps");
				shortTermAntiban();
			}
			
		}else {
			
			walking.webWalk(fisharea);
			shortTermAntiban();
			
		}
		
	}
	
	public void cook() throws InterruptedException {
		
		while(inventory.contains("Raw shrimps") || inventory.contains("Raw anchovies")) {
				
				while(inventory.contains("Raw shrimps")) {
					
					lightFire();
					RS2Object fire = getObjects().closest("Fire");
					
					inventory.getItem("Raw shrimps").interact("Use");
					shortTermAntiban();
					fire.interact("Use");
					shortTermAntiban();
					RS2Widget cookiconbutton = getWidgets().get(270, 14);
					cookiconbutton.interact();
					sleep(random(2000, 4000));
					while(myPlayer().isAnimating() || myPlayer().isMoving()){
						
						shortTermAntiban();
						sleep(random(1000,2500));
						
					}
				
				}
				
				sleep(random(1000,2000));
				inventory.dropAll("Shrimps");
				shortTermAntiban();
				inventory.dropAll("Burnt shrimp");
				shortTermAntiban();
				
				while(inventory.contains("Raw anchovies")) {
					
					lightFire();
					RS2Object fire = getObjects().closest("Fire");
					
					inventory.getItem("Raw anchovies").interact("Use");
					shortTermAntiban();
					fire.interact("Use");
					shortTermAntiban();
					RS2Widget cookiconbutton = getWidgets().get(270, 14);
					cookiconbutton.interact();
					new ConditionalSleep(600000) {
						@Override
						public boolean condition() {
							return !inventory.contains("Raw anchovies") || widgets.isVisible(233) || getDialogues().isPendingContinuation();
						}
				}.sleep();
				}
				
				sleep(random(1000,2000));
				inventory.dropAll("Anchovies");
				shortTermAntiban();
				inventory.dropAll("Burnt fish");
				shortTermAntiban();
				
				
			
			
			
		
		}
	}
	
	public void lightFire() throws InterruptedException {
	
		RS2Object fire = getObjects().closest("Fire");
	
	if(fire == null) {
		if(!inventory.contains("Logs")) {
		Area logspot = new Area(3216, 3173, 3221, 3175);
		walking.webWalk(logspot);
		shortTermAntiban();
		Entity tree = objects.closest("Dead tree");
		tree.interact("Chop down");
		shortTermAntiban();
		sleep(random(1000,2500));
		while(myPlayer().isAnimating() || myPlayer().isMoving()){
			
			shortTermAntiban();
			sleep(random(1000,2500));
			
		}
		}
		
		inventory.getItem("Tinderbox").interact("Use");
		shortTermAntiban();
		inventory.getItem("Logs").interact("Use");
		sleep(random(1000,2000));
		while(myPlayer().isAnimating() || myPlayer().isMoving()) {
			shortTermAntiban();
			sleep(random(1000,2500));
		}
		
	}
	}
	
	public void getSupplies() throws InterruptedException {
		
		Position bank = new Position(3208,3218,2);
		Position player = new Position(myPlayer().getPosition());
		
		if(bank.distance(player) > 10) {
			
			walking.webWalk(bank);
			shortTermAntiban();
			
		}
		
		if(!getBank().isOpen()) {
			
			getBank().open();
			shortTermAntiban();
			getBank().depositAll();
			shortTermAntiban();
			
		}
		
		if(!inventory.contains("Tinderbox")) {
			
			getBank().withdraw("Tinderbox", 1);
			shortTermAntiban();
			
		}else if(!getBank().contains("Tinderbox")) {
			log("no tinderbox found");
		}
		
		if(!inventory.contains("Small fishing net")) {
			
			getBank().withdraw("Small fishing net", 1);
			shortTermAntiban();
			
		}else if(!getBank().contains("Small fishing net")) {
			log("no Small fishing net found");
		}
		
		if(!inventory.contains("Bronze axe") && !equipment.contains("Bronze axe")) {
			
			getBank().withdraw("Bronze axe", 1);
			shortTermAntiban();
			
		}else if(!getBank().contains("Bronze axe")) {
			log("no Bronze axe found");
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
	
	public void mouseMovements() throws InterruptedException{
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
