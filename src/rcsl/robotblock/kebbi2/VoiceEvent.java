package rcsl.robotblock.kebbi2;

import com.nuwarobotics.service.agent.NuwaRobotAPI;
import com.nuwarobotics.service.agent.VoiceEventListener;
import com.nuwarobotics.service.agent.VoiceResultJsonParser;

public class VoiceEvent implements VoiceEventListener {

    NuwaRobotAPI mRobot;
    public static IVoiceEventCallback voiceEventCallback = null;

    String stt_result = "";
    public static String tts_sentence = "";

    public VoiceEvent(NuwaRobotAPI mRobot){
        this.mRobot = mRobot;
        this.mRobot.registerVoiceEventListener(this);
    }

    public void onWakeup(boolean b, String s, float v) {

    }

    public void onTTSComplete(boolean b) {
        voiceEventCallback.TTSCompleted(tts_sentence);
    }

    // // @SimpleEvent(description = "trigger this event when Text To Speech is finished.")
    // public void TTSCompleted(String sentence){
        
    // }

    public void onSpeechRecognizeComplete(boolean b, ResultType resultType, String s) {

    }

    public void onSpeech2TextComplete(boolean b, String s) {
        // Log.d("nSpeech2TextCompleted", "wait both action complete");
        stt_result = VoiceResultJsonParser.parseVoiceResult(s);
        // STTCompleted(b, s, stt_result);    
        voiceEventCallback.STTCompleted(b, s, stt_result);
    }

    // @SimpleEvent()
    // public void STTCompleted(boolean b, String result, String sentence){
    //     voiceEventCallback.STTCompleted(b, result, sentence);
    // }

    public void onMixUnderstandComplete(boolean b, ResultType resultType, String s) {

    }

    public void onSpeechState(ListenType listenType, SpeechState speechState) {

    }

    public void onSpeakState(SpeakType speakType, SpeakState speakState) {

    }

    public void onGrammarState(boolean b, String s) {

    }

    public void onListenVolumeChanged(ListenType listenType, int i) {

    }

    public void onHotwordChange(HotwordState hotwordState, HotwordType hotwordType, String s) {

    }
}