package rcsl.robotblock.kebbi2;

interface IRobotEventCallback       
{
    void onPIREvent(int i);
    void EventOnTap(int bodypart);
    void onTap(int bodyPart);
    void onStartOfMotionPlay(String s);
    void onCompleteOfMotionPlay(String s);
}