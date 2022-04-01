package rcsl.robotblock.kebbi2;

interface IVoiceEventCallback       
{
    void TTSCompleted(String sentence);
    void STTCompleted(boolean b, String result, String sentence);
}