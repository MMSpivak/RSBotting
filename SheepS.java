package RSBot.Quests;
import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.script.Script;

@ScriptManifest(author = "Boomerwangs", name = "SheepS", info = "Walking to Lumby", version = 0.1, logo = "")
public class SheepS extends Script
{
	 public int onLoop() throws InterruptedException {
	final Position sheep1 = new Position(3189, 3274, 0);
    this.walking.webWalk(new Position[] { sheep1 });
    sleep((long)random(3400, 5000));
    final NPC npc2 = (NPC)this.npcs.closest(new String[] { "Fred the Farmer" });
    this.npcs.closest(new String[] { "Fred the Farmer" });
    npc2.interact(new String[] { "Talk-to" });
    sleep((long)random(1000, 3000));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().selectOption(1);
    sleep((long)random(1000, 2500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().selectOption(1);
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    final Position sheep2 = new Position(3211, 3263, 0);
    this.walking.webWalk(new Position[] { sheep2 });
    while (this.getInventory().getAmount(new String[] { "Wool" }) < 20L) {
        final NPC sheepMob1 = (NPC)this.getNpcs().closest(new String[] { "Sheep" });
        if (sheepMob1.hasAction(new String[] { "Shear" }) && this.getMap().canReach((Entity)sheepMob1)) {
            this.getCamera().toEntity((Entity)sheepMob1);
            sheepMob1.interact(new String[] { "Shear" });
            sleep((long)random(4000, 8000));
        }
        else {
            final Position sheepwalk1 = new Position(3201, 3266, 0);
            this.walking.webWalk(new Position[] { sheepwalk1 });
            sleep((long)random(2000, 3000));
            final NPC sheepMob2 = (NPC)this.getNpcs().closest(new String[] { "Sheep" });
            if (sheepMob2.hasAction(new String[] { "Shear" }) && this.getMap().canReach((Entity)sheepMob2)) {
                this.getCamera().toEntity((Entity)sheepMob2);
                sheepMob2.interact(new String[] { "Shear" });
                sleep((long)random(4000, 8000));
            }
            else {
                final Position sheepwalk2 = new Position(3197, 3266, 0);
                this.walking.webWalk(new Position[] { sheepwalk2 });
                sleep((long)random(2000, 3000));
                final NPC sheepMob3 = (NPC)this.getNpcs().closest(new String[] { "Sheep" });
                if (sheepMob3.hasAction(new String[] { "Shear" }) && this.getMap().canReach((Entity)sheepMob3)) {
                    this.getCamera().toEntity((Entity)sheepMob3);
                    sheepMob3.interact(new String[] { "Shear" });
                    sleep((long)random(4000, 8000));
                }
                else {
                    final Position sheepwalk3 = new Position(3204, 3271, 0);
                    this.walking.webWalk(new Position[] { sheepwalk3 });
                    sleep((long)random(2000, 3000));
                    final NPC sheepMob4 = (NPC)this.getNpcs().closest(new String[] { "Sheep" });
                    if (sheepMob4.hasAction(new String[] { "Shear" }) && this.getMap().canReach((Entity)sheepMob4)) {
                        this.getCamera().toEntity((Entity)sheepMob4);
                        sheepMob4.interact(new String[] { "Shear" });
                        sleep((long)random(4000, 8000));
                    }
                    else {
                        sleep((long)random(3000, 4000));
                    }
                }
            }
        }
    }
    final Position wool1 = new Position(3209, 3213, 1);
    this.walking.webWalk(new Position[] { wool1 });
    sleep((long)random(2000, 4000));
    final RS2Object spinwheel = (RS2Object)this.objects.closest(new String[] { "Spinning Wheel" });
    this.getInventory().interact("Use", new String[] { "Wool" });
    spinwheel.interact(new String[] { "Use" });
    sleep((long)random(2500, 4500));
    final RS2Widget woolMenu = this.widgets.get(270, 14);
    woolMenu.interact(new String[] { "Make" });
    sleep((long)random(500, 1000));
    sleep((long)random(45000, 55000));
    final Position farmer1 = new Position(3189, 3247, 0);
    this.walking.webWalk(new Position[] { farmer1 });
    final NPC ffarmer = (NPC)this.npcs.closest(new String[] { "Fred the Farmer" });
    this.npcs.closest(new String[] { "Fred the Farmer" });
    ffarmer.interact(new String[] { "Talk-to" });
    sleep((long)random(1000, 2000));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().selectOption(1);
    sleep((long)random(1000, 2500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    this.getDialogues().clickContinue();
    sleep((long)random(2400, 3500));
    return 500;
}
}
