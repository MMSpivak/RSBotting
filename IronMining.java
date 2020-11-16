package RSBot.Mining;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest(author = "Otterblast", info = "for mining iron", logo = "", name = "IronMining", version = 0.1)

//Bugs to fix: when walking from bank to irondep ends up stranded a bit NEast of Varrok enterance, sometimes doesnt even webwalk back not sure why

public class IronMining extends Script{

	

	public void onStart(){
		
		log("started script");
		
	}
	
	public void onExit() {
		
		log("ended script");
		
    }
	
	
	public int onLoop() throws InterruptedException{
		
		Area irondep = new Area(3284, 3367, 3289, 3371);
		Area ironstep1 = new Area(3290, 3383, 3292, 3387);//first area bot walks to after mining
		Area ironstep2 = new Area(3291, 3499, 3293, 3403);
		Area ironstep3 = new Area(3286, 3414, 3288, 3418);
		Area ironstep4 = new Area(3272, 3427, 3276, 3429);
		Area ironstep5 = new Area(3255, 3428, 3259, 3430);
		Area bankarea = new Area(3251, 3419, 3255, 3420);
		//6 different paths - they take a while
		
		Entity rocks = objects.closest(11364, 11365);//if script not working might need to update these IDs as they apparently change
		
		if(inventory.isFull()){
			if(bankarea.contains(myPlayer())) {
				
				if(getBank().isOpen()) {
					getBank().depositAll();
					if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
                    	sleep(random(5000,40000));
                    }else {sleep(random(500,2000));}
				}else {
					getBank().open();
					if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
                    	sleep(random(5000,40000));
                    }else {sleep(random(1000,3000));}
				}
				
			}else {//start of walking sequence
				
				if(ironstep5.contains(myPlayer())) {
					
					walking.walk(bankarea.getRandomPosition());
					if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
                    	sleep(random(5000,40000));
                    }else {sleep(random(800,2000));}
					
				}else {
					if(ironstep4.contains(myPlayer())){
						walking.walk(ironstep5.getRandomPosition());
						if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
                        	sleep(random(5000,40000));
                        }else {sleep(random(500,2000));}
					}else {
						if(ironstep3.contains(myPlayer())){
							walking.walk(ironstep4.getRandomPosition());
							if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
                            	sleep(random(5000,40000));
                            }else {sleep(random(1000,2000));}
						}else {
							if(ironstep2.contains(myPlayer())){
							walking.walk(ironstep3.getRandomPosition());
							if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
                            	sleep(random(5000,40000));
                            }else {sleep(random(1000,2000));}
							}else {
								if(ironstep1.contains(myPlayer())){
							walking.walk(ironstep2.getRandomPosition());
							if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
                            	sleep(random(5000,40000));
                            }else {sleep(random(500,2000));}
								}else {
									if(irondep.contains(myPlayer())){
										walking.walk(ironstep1.getRandomPosition());
										if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
	                                    	sleep(random(5000,40000));
	                                    }else {sleep(random(1000,2000));}
									}else {
										log("something wrong with walking to bank");
										walking.webWalk(bankarea);//fail safe in case walking doesn't work or if logout not in an area
									}
								}
							}
						}
					}
		}
	}	
}else {
	if(irondep.contains(myPlayer())) {
		if (!myPlayer().isAnimating()) {
            if (!myPlayer().isMoving()) {
                    rocks.interact("Mine");
                    if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
                    	sleep(random(5000,40000));
                    }else {sleep(random(1000,3000));}
                    
            }
    }
	}else {
		if(ironstep1.contains(myPlayer())) {
			walking.walk(irondep);
			if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
            	sleep(random(5000,40000));
            }else {sleep(random(2500,4000));}
		}else {
			if(ironstep2.contains(myPlayer())) {
				walking.walk(ironstep1);
				if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
                	sleep(random(5000,40000));
                }else {sleep(random(1300,2000));}
			}else {
				if(ironstep3.contains(myPlayer())) {
					walking.walk(ironstep2);
					if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
                    	sleep(random(5000,40000));
                    }else {sleep(random(1300,2000));}
				}else {
					if(ironstep4.contains(myPlayer())) {
						walking.walk(ironstep3);
						if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
	                    	sleep(random(5000,40000));
	                    }else {sleep(random(1300,2500));}
					}else {
						if(ironstep5.contains(myPlayer())) {
							walking.walk(ironstep4);
							if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
		                    	sleep(random(5000,40000));
		                    }else {sleep(random(1300,3000));}
						}else{
							if(bankarea.contains(myPlayer())) {
								walking.walk(ironstep5);
								if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
			                    	sleep(random(5000,40000));
			                    }else {sleep(random(1300,2800));}
						}else {
							walking.webWalk(irondep);
							if((int)random(0,40) == 30) {//sets 1in40 chance of sleeping 5 to 45 seconds
		                    	sleep(random(5000,40000));
		                    }else {sleep(random(1000,2000));}
							log("something wrong with walking to iron deposit");
						}
							
						}
					}
				}
			}
		}
	}
	
	
}
		return 500;
}
	
}