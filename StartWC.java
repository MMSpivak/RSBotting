package RSBot.Woodcutting;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest(author = "Otterblast", name = "StartWC", info = "gets your wcing up from level 1", version = 0.1, logo = "")

public class StartWC extends Script {



    public void onStart() throws InterruptedException{


    }

    public int onLoop() throws InterruptedException{
 
    	//final Position posit1 = new Position(3207,3220,2);
    	//final Position posit2 = new Position(3207,3219,2);
    	//final Position posit3 = new Position(3207,3218,2);
    	//final Position posit4 = new Position(3208,3220,2);
    	//final Position posit5 = new Position(3208,3219,2);
    	//final Position posit6 = new Position(3208,3218,2);
    	//final Position posit7 = new Position(3209,3220,2);
    	//final Position posit8 = new Position(3209,3219,2);
    	//final Position posit9 = new Position(3209,3218,2);
    	if(inventory.isFull()) {
			inventory.dropAll("Logs");
			sleep(random(2500,4000));
			shortTermAntiban();
		}else {
			cutTree();
			sleep(random(500,1000));
		}
    	

    	
    	
    return 500;
    }

    public void onExit() {


    }
    
    
    public void cutTree() throws InterruptedException{
    	
    	Area trees = new Area(3197,3218, 3188, 3230);
    	Entity tree = objects.closest("Tree");
    	
    	if(trees.contains(myPlayer())){
    		tree.interact("Chop down");
    		sleep(random(500,1500));
    		while(myPlayer().isAnimating() || myPlayer().isMoving()) {
    			shortTermAntiban();
    			sleep(random(1000,3500));
    		}
    		
    	}else {
    		walking.webWalk(trees);
    		shortTermAntiban();
    		sleep(random(1500,4000));
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
		int cameraAngle = (int)camera.getPitchAngle(); // did we want to do anything with this?
		
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
