package com.zmaj.client;

import net.minecraft.client.Minecraft;
import java.util.*;

public final class MacroManager {
    private static boolean recording;
    private static final List<String> lastEvents=new ArrayList<>();
    private MacroManager(){}
    public static void startRecording(){recording=true;lastEvents.clear();lastEvents.add("START");}
    public static void stopRecording(){if(recording){recording=false;lastEvents.add("STOP");}}
    public static void playLast(Minecraft mc){
        if(mc.player!=null) mc.player.displayClientMessage(net.minecraft.network.chat.Component.literal("Zmaj Macro: "+Math.max(0,lastEvents.size()-2)+" events recorded."),true);
    }
    public static void sendCommand(Minecraft mc,String command){
        if(mc.player==null)return;
        if(command.startsWith("/")) mc.player.connection.sendCommand(command.substring(1));
        else mc.player.connection.sendChat(command);
    }
}