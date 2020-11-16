package scripts;

import org.tribot.api2007.Camera;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;

public class Objs {
    public static RSObject findNearestObject(int distance, int[] objectName) {
        RSObject[] objects = Objects.findNearest(distance, objectName);
        for (RSObject object : objects) {
            if (object != null)
                return object;		}		return null;	}

    public static void lookAt(RSObject i){
        RSTile pos = i.getPosition();
        Camera.turnToTile(pos);
    }
}
