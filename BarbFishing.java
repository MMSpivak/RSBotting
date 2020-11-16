package RSBot.Fish_Cook;

import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.script.Script;


@ScriptManifest(author = "Otterblast", name = "StartFishCook", info = "get your fish/cook lvls up", version = 0.1, logo = "")

public class BarbFishing extends Script{
	
	public void onStart() throws InterruptedException {
		if(!inventory.contains("Fly fishing rod") || !inventory.contains("Feather")){
		log("either no fly fishing rod or feathers please get then resume script");
		}
	}

	public int onLoop() throws InterruptedException {
		
		if(inventory.isFull()) {
			
			if(inventory.contains("Raw trout") || inventory.contains("Raw salmon")) {
				
				cook();
				
			}else {
				log("inv full of some other shit");
			}
			
		}else {
			
			fish();
			
		}
		
		return 500;
	}
	
	public void fish() throws InterruptedException {
		
		Area fisharea = new Area(3104,3430,3109,3434);
		if(fisharea.contains(myPlayer())) {
			
			while(!inventory.isFull()) {
				
				NPC fishspot = npcs.closest("Rod Fishing spot");
				fishspot.interact("Lure");
				sleep(random(2000, 4000));
				while(myPlayer().isAnimating() || myPlayer().isMoving()){
					
					shortTermAntiban();
					sleep(random(1000,2500));
					
				}
				
				
			}
			
		}else {
			
			walking.webWalk(fisharea);
			shortTermAntiban();
			
		}
		
	}
	
	public void cook() throws InterruptedException {
		
		while(inventory.contains("Raw trout") || inventory.contains("Raw salmon")) {
			
			while(inventory.contains("Raw trout")){
				
				RS2Object fire = getObjects().closest("Fire");
				inventory.getItem("Raw trout").interact("Use");
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
			
			while(inventory.contains("Raw salmon")){
				
				RS2Object fire = getObjects().closest("Fire");
				inventory.getItem("Raw salmon").interact("Use");
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
		}
		//could eventually make it so it drop
		inventory.dropAllExcept("Fly fishing rod", "Feather");
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
