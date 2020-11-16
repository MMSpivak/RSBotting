package scripts;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.input.Keyboard;
import org.tribot.api.input.Mouse;
import org.tribot.api.interfaces.Clickable07;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSObject;

import static scripts.Objs.findNearestObject;


public class Actions {

    public static void chopTree(int[] ids) {
        Timer time = new Timer(3000);
        final RSObject Tree = Objs.findNearestObject(15, ids);
        if(Tree != null){
            Tree.click("Chop down");
            time.reset();
            while(Player.getAnimation() == -1 && time.isRunning()){//creates dynamic sleep so that if the player is running to the ore and timer hasn't run out we sleep
                General.sleep_definite(100);
            }
            while(Player.getAnimation() == 879){
                General.sleep_definite(100);
            }
        }
    }

    public static void cook(int[] fire, int[] food){
        RSItem[] toCook = Inventory.find(food);
        RSObject Fire = findNearestObject(15,fire);

    }

    public static void sleepWhileMoving(){
        Timer time = new Timer(2000);
        time.reset();
        while(Player.isMoving() || time.isRunning()){
            General.sleep(100);
        }
        General.sleep(500,1000);
    }

    public static void sleepWhileMelee(){
        Timer time = new Timer(2000);
        time.reset();//426 for ranging with shortbow 711 for spells
        //1156 and 386 for melee
        //NEED TO UPDATE WITH MORE ACTIONS DEPENDING ON WHAT DOING
        while(Player.isMoving() || time.isRunning()){
            General.sleep(1000);
        }
        //add something where if a combat action doesnt come up after a certain time break loop
        time.reset();
        while(time.isRunning()){
            if(Player.getAnimation() == 1156 || Player.getAnimation() == 386 || Player.getAnimation() == 388 || Player.getAnimation() == 422 || Player.getAnimation() == 424){
                time.reset();
            }

        }
    }

    public static void sleepWhileRanged(){
        Timer time = new Timer(2000);
        time.reset();//426 for ranging with shortbow 711 for spells
        //NEED TO UPDATE WITH MORE ACTIONS DEPENDING ON WHAT DOING
        while(Player.isMoving() || time.isRunning()){
            General.sleep(1000);
        }
        //add something where if a combat action doesnt come up after a certain time break loop
        time.reset();
        while(time.isRunning()){
            if(Player.getAnimation() == 426){
                time.reset();
            }

        }
    }

    public static void sleepWhileSmith(){
        //animation is 899
        Timer time = new Timer(2000);
        while(time.isRunning()){
            if(Player.getAnimation() == 899){
                time.reset();
            }
        }
    }

    public static boolean containsCopTin(){
        return true;
    }

    public static void typeRandKey(int i){
        final String[] str = new String[] {"1", "2", "3","4","5","6","7","8","9","0","q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"};
        for(int t = 0; t<= i; t++){
            int b = General.random(0,str.length-1);
            Keyboard.typeString(str[b]);
            General.sleep(200,500);
        }
    }

    public static < T extends Clickable07 & Positionable> boolean attemptAimCamera(T clickableEntity, int maxDistance)
    {
        if(clickableEntity == null)
            return false;

        int numberOfCameraAdjusts = 0;
        int maxCameraAdjusts = General.random(2,5);

        while(!clickableEntity.isClickable() && numberOfCameraAdjusts < maxCameraAdjusts && Player.getPosition().distanceTo(clickableEntity.getPosition()) < maxDistance)
        {
            if(numberOfCameraAdjusts > 0) // If we fail to find by rotation, then lower the angle (to see further)
            {
                int angle = Camera.getCameraAngle();
                Camera.setCameraAngle(angle - General.randomSD(5,angle,30,11));
            }
            else // This runs first, always (could use improvement to avoid that pattern)
                Camera.turnToTile(clickableEntity);

            numberOfCameraAdjusts++;
        }

        return clickableEntity.isClickable();
    }

    public static void charCreate(){
        int t = General.random(10,25);

        while(t > 0){
            int i = General.random(1,12);
            int slp = General.random(500,3000);
            General.sleep(slp);
            switch(i){
                case 1:
                    Mouse.clickBox(150,75,183,98,1);
                    break;
                case 2:
                    Mouse.clickBox(150,113,180,131,1);
                    break;
                case 3:
                    Mouse.clickBox(150,147,183,166,1);
                    break;
                case 4:
                    Mouse.clickBox(150,180,183,200,1);
                    break;
                case 5:
                    Mouse.clickBox(150,217,183,242,1);
                    break;
                case 6:
                    Mouse.clickBox(150,250,183,275,1);
                    break;
                case 7:
                    Mouse.clickBox(150,285,183,310,1);
                    break;
                case 8:
                    Mouse.clickBox(460,75,500,98,1);
                    break;
                case 9:
                    Mouse.clickBox(460,113,500,131,1);
                    break;
                case 10:
                    Mouse.clickBox(460,147,500,166,1);
                    break;
                case 11:
                    Mouse.clickBox(460,180,500,200,1);
                    break;
                case 12:
                    Mouse.clickBox(460,285,500,310,1);
                    break;
                default:
                    General.println("PROBLEM WITH CHARCREATE");
            }

            t = t - 1;
        }

        General.sleep(2000);
        Mouse.clickBox(214,289,335,306,1);
    }

    public static void openInv(){
        Mouse.clickBox(630,172,650,200,1);
        General.sleep(200,600);
    }

    public static void openSkills(){
        Mouse.clickBox(565,174,586,198,1);
        General.sleep(200,600);
    }

    public static void openQuests(){
        Mouse.clickBox(595,170,620,200,1);
        General.sleep(200,600);
    }

    public static void openEquipment(){
        Mouse.clickBox(665,175,686,198,1);
        General.sleep(200,600);
    }

    public static void openCombat(){
        Mouse.clickBox(532,176,552,200,1);
        General.sleep(200,600);
    }

    public static void openPray(){
        Mouse.clickBox(700,176,720,200,1);
        General.sleep(200,600);
    }

    public static void openFriends(){
        Mouse.clickBox(564,470,587,493,1);
        General.sleep(200,600);
    }

    public static void openMagic(){
        Mouse.clickBox(730,176,750,200,1);
        General.sleep(200,600);
    }

    public boolean ringEquipped()
    {
        return Equipment.getItem(Equipment.SLOTS.RING) != null;
    }

}
