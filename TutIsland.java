package RSBot.Quests;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.api.ui.Tab;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.script.Script;

@ScriptManifest(author = "Otterblast", name = "TutIsland", info = "gets through tutorial island", version = 0.1, logo = "")
public class TutIsland extends Script{
	
	public int onLoop() throws InterruptedException {
		
		createC();
		shortTermAntiban();
		shortTermAntiban();
		inst1();
		
		
		return 500;
	}
	
	public void createC() throws InterruptedException{
		
		
		  RS2Widget namebar = getWidgets().get(558, 8); namebar.interact();
		  shortTermAntiban();
		  
		  
		  
		  log("started createname"); randomKey(); sleep(random(500,800));
		  
		  getKeyboard().pressKey(10); sleep(random(400,600));
		  getKeyboard().releaseKey(10); shortTermAntiban(); sleep(random(1000,2000));
		  
		  RS2Widget setname = getWidgets().get(558, 18, 0); setname.interact();
		  shortTermAntiban();
		 
		
		int index = 0;
		index = random(10,20);
		while(index > 0) {
			index = index - 1;
			log("while loop");
			randomWid();
			sleep(random(500,800));
			
		}
		
		RS2Widget next = getWidgets().get(269, 100);
		shortTermAntiban();
		next.interact();
		shortTermAntiban();
		
		NPC guide = npcs.closest("Gielinor Guide");
		guide.interact("Talk-to");
		shortTermAntiban();
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		this.getDialogues().selectOption(3);
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		getTabs().open(Tab.SETTINGS);
		sleep(random(1500,2500));
		guide.interact("Talk-to");
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		Area inst1 = new Area(3101,3098,3104,3094);
		walking.webWalk(inst1.getRandomPosition());
		sleep(random(3000,4500));
		
	}
	
	public void inst1() throws InterruptedException{
		
		NPC inst1 = npcs.closest("Survival Expert");
		inst1.interact("Talk-to");
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		getTabs().open(Tab.INVENTORY);
		sleep(random(1500,2500));
		NPC fishspot = npcs.closest("Fishing spot");
		fishspot.interact("Net");
		sleep(random(2000, 4000));
		while(myPlayer().isAnimating() || myPlayer().isMoving()){
			
			shortTermAntiban();
			sleep(random(1000,2500));
			
		}
		getTabs().open(Tab.SKILLS);
		sleep(random(1500,2500));
		inst1.interact("Talk-to");
		sleep(random(3000,4500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		this.getDialogues().clickContinue();
		sleep(random(1500,2500));
		getTabs().open(Tab.INVENTORY);
		sleep(random(1500,2500));
		Entity tree = objects.closest("Tree");
		tree.interact("Chop down");
		sleep(random(2000, 4000));
		while(myPlayer().isAnimating() || myPlayer().isMoving()){
			
			shortTermAntiban();
			sleep(random(1000,2500));
			
		}
		Area inst = new Area(3101,3098,3104,3094);
		walking.webWalk(inst.getRandomPosition());
		sleep(random(3000,4500));
		
		inventory.getItem("Tinderbox").interact("Use");
		shortTermAntiban();
		inventory.getItem("Logs").interact("Use");
		sleep(random(1000,2000));
		while(myPlayer().isAnimating() || myPlayer().isMoving()) {
			shortTermAntiban();
			sleep(random(1000,2500));
		}
		
		RS2Object fire = getObjects().closest("Fire");
		inventory.getItem("Raw shrimps").interact("Use");
		shortTermAntiban();
		fire.interact("Use");
		shortTermAntiban();
		sleep(random(1000,2000));
		while(myPlayer().isAnimating() || myPlayer().isMoving()) {
			shortTermAntiban();
			sleep(random(1000,2500));
		}
		
		
	}
	
	public void inst2() throws InterruptedException{
		
		
		
	}
	
	public void randomWid() throws InterruptedException{
		//randomly widgets to select an appearance
		int X = random(0,25);
		sleep(random(1000,2000));
		if(X == 1) {
			RS2Widget next = getWidgets().get(269, 106);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 2) {
			RS2Widget next = getWidgets().get(269, 107);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 3) {
			RS2Widget next = getWidgets().get(269, 108);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 4) {
			RS2Widget next = getWidgets().get(269, 109);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 5) {
			RS2Widget next = getWidgets().get(269, 110);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 6) {
			RS2Widget next = getWidgets().get(269, 111);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 7) {
			RS2Widget next = getWidgets().get(269, 112);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 8) {
			RS2Widget next = getWidgets().get(269, 113);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 9) {
			RS2Widget next = getWidgets().get(269, 114);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 10) {
			RS2Widget next = getWidgets().get(269, 115);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 11) {
			RS2Widget next = getWidgets().get(269, 116);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 12) {
			RS2Widget next = getWidgets().get(269, 117);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 13) {
			RS2Widget next = getWidgets().get(269, 118);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 14) {
			RS2Widget next = getWidgets().get(269, 119);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 15) {
			RS2Widget next = getWidgets().get(269, 105);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 16) {
			RS2Widget next = getWidgets().get(269, 121);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 17) {
			RS2Widget next = getWidgets().get(269, 122);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 18) {
			RS2Widget next = getWidgets().get(269, 123);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 19) {
			RS2Widget next = getWidgets().get(269, 124);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 20) {
			RS2Widget next = getWidgets().get(269, 125);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 21) {
			RS2Widget next = getWidgets().get(269, 127);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 22) {
			RS2Widget next = getWidgets().get(269, 129);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 23) {
			RS2Widget next = getWidgets().get(269, 130);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}else if(X == 24) {
			RS2Widget next = getWidgets().get(269, 131);
			shortTermAntiban();
			next.interact();
			shortTermAntiban();
		}
		
	}
	
	public void randomKey() throws InterruptedException{
	String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz"; 
	for (int i = 0; i < 13; i++) { 
		int index 
		= (int)(AlphaNumericString.length() 
				* Math.random()); 
		getKeyboard().typeKey(AlphaNumericString 
				.charAt(index));
		sleep(random(500,800));

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
			sleep(random(8000,12000));
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
