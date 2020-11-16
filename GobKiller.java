package RSBot.Fighting;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;


@ScriptManifest(author = "Otterblast", info = "Kills Goblins and gets potatos to eat", logo = "", name = "GobKiller", version = 0.1)
//known bugs:


public class GobKiller extends Script{
	
public void onStart(){
		
		log("started script");
		
	}
	
	public void onExit() {
		
		log("ended script");
		
    }
	
	
	public int onLoop() throws InterruptedException{
		Area gobloc = new Area(3138, 3296, 3152, 3306);
		int maxHP = skills.getStatic(Skill.HITPOINTS);
		
//		Filter<NPC> underattack = new Filter<NPC>() {
//		    @Override
//		    public boolean match(NPC n) {
//		        if (n.getId() != 3029 || n.getId() != 3030)//might have to update this if ID's change 3029 3033 3031 30 32 34
//		            return false;
//		        if(!n.getName().equals("Goblin"))
//		            return false;
//		        if(n.isUnderAttack())
//		            return false;
//		        return true;
//		    }
//		};
		
		
		
		
		//start loop to kill goblins
		
		if(!inventory.contains("Potato")){
			
			pickPotato();
			
		}else {
			
			if(gobloc.contains(myPlayer())) {
				@SuppressWarnings("unchecked")
				NPC goblin = npcs.closest(n ->  n != null && n.getName().equals("Goblin") && !n.isHitBarVisible() && !n.isUnderAttack());
				
						
					sleep(100);
						
						goblin.interact("Attack");
						sleep(random(2000,3000));
						
						while(myPlayer().isUnderAttack() || myPlayer().isAnimating() || goblin.isInteracting(myPlayer())) {//doesn't include myPlayer().moving so that if we click on a goblin thats around a long corner it can update and choose new closest goblin
							
							int currHP = skills.getDynamic(Skill.HITPOINTS);//initialize it right here so can be updated so we eat randomly
							while(currHP <= (maxHP / 2 + (int)random(-2,1)) && inventory.contains("Potato")){
								
								inventory.getItem("Potato").interact("Eat");
								currHP = currHP + 1;
								sleep(random(2000,3000));
								
							}
							
							
							if(!inventory.contains("Potato")) {
								break;
							}else {
								sleep(random(2500,4000));//eventually take this out of loop and make it conditional sleep statement
							}
							
							shortTermAntiban();
							
						}
					
				
			}else {
				walking.webWalk(gobloc);
				shortTermAntiban();
				if((int)random(0,40) == 30) {
                	sleep(random(5000,40000));
                }else {sleep(random(1000,3000));}
			}
			
		}
		
		
		
		return 500;
	}
	
	
	//start of your functions
	
	public void pickPotato() throws InterruptedException{//creates a function
	
	Area field = new Area(3140, 3290, 3156, 3281);
	
		
	while(!inventory.isFull())	{
		
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
		
		if (shortChoice <= 200) {
			randomSleep();
		}
		
		else if (shortChoice <= 600) {
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
