package rcsl.robotblock.kebbi2;

import android.content.Context;
import com.nuwarobotics.service.IClientId;
import com.nuwarobotics.service.agent.NuwaRobotAPI;

public class KebbiInstance{

    private static KebbiInstance instance;
    private NuwaRobotAPI mRobot;

    public KebbiInstance(Context context){
        IClientId id = new IClientId(context.getPackageName());
        mRobot = new NuwaRobotAPI(context, id);
    }

    public static NuwaRobotAPI getInstance(Context context){
        if(instance == null){
            synchronized(KebbiInstance.class){
                if(instance == null){
                    instance = new KebbiInstance(context);
                }    
            }
        } 
        return instance.mRobot;
    }
}