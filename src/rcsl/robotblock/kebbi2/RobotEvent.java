package rcsl.robotblock.kebbi2;

import com.nuwarobotics.service.agent.NuwaRobotAPI;
import com.nuwarobotics.service.agent.RobotEventListener;
import static com.nuwarobotics.service.agent.NuwaRobotAPI.SENSOR_PIR;
import static com.nuwarobotics.service.agent.NuwaRobotAPI.SENSOR_TOUCH;

public class RobotEvent implements RobotEventListener {
    
    NuwaRobotAPI mRobot;
    public static IRobotEventCallback robotEventCallback = null;

    public RobotEvent(NuwaRobotAPI mRobot){
        this.mRobot = mRobot;
        this.mRobot.registerRobotEventListener(this);
    }

    @Override
    public void onWikiServiceStart() {
        this.mRobot.requestSensor(SENSOR_TOUCH); 
        this.mRobot.requestSensor(SENSOR_PIR);
    }

    @Override
    public void onWikiServiceStop() {

    }

    @Override
    public void onWikiServiceCrash() {

    }

    @Override
    public void onWikiServiceRecovery() {

    }

    @Override
    public void onStartOfMotionPlay(String s) {
        robotEventCallback.onStartOfMotionPlay(s);
    }

    @Override
    public void onPauseOfMotionPlay(String s) {

    }

    @Override
    public void onStopOfMotionPlay(String s) {

    }

    @Override
    public void onCompleteOfMotionPlay(String s) {
        robotEventCallback.onCompleteOfMotionPlay(s);
    }

    @Override
    public void onPlayBackOfMotionPlay(String s) {

    }

    @Override
    public void onErrorOfMotionPlay(int i) {

    }

    @Override
    public void onPrepareMotion(boolean b, String s, float v) {

    }

    @Override
    public void onCameraOfMotionPlay(String s) {

    }

    @Override
    public void onGetCameraPose(float v, float v1, float v2, float v3, float v4, float v5, float v6, float v7, float v8, float v9, float v10, float v11) {

    }

    @Override
    public void onTouchEvent(int i, int i1) {

    }

    @Override
    public void onPIREvent(int i) {
        robotEventCallback.onPIREvent(i);
    }

    @Override
    public void onTap(int i) {
        robotEventCallback.onTap(i);
    }

    @Override
    public void onLongPress(int i) {

    }

    @Override
    public void onWindowSurfaceReady() {

    }

    @Override
    public void onWindowSurfaceDestroy() {

    }

    @Override
    public void onTouchEyes(int i, int i1) {

    }

    @Override
    public void onRawTouch(int i, int i1, int i2) {

    }

    @Override
    public void onFaceSpeaker(float v) {

    }

    @Override
    public void onActionEvent(int i, int i1) {

    }

    @Override
    public void onDropSensorEvent(int i) {

    }

    @Override
    public void onMotorErrorEvent(int i, int i1) {

    }
}