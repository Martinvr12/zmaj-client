package com.zmaj.client;

import java.util.*;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.lwjgl.glfw.GLFW;

public final class ModuleManager {
    private final List<Module> modules = new ArrayList<>();
    private final Map<Integer, Module> keyMap = new HashMap<>();

    public ModuleManager() {
        add("FPS", "HUD", true, GLFW.GLFW_KEY_F6);
        add("CPS", "HUD", true, GLFW.GLFW_KEY_F7);
        add("Keystrokes", "HUD", true, GLFW.GLFW_KEY_F8);
        add("Armor Status", "HUD", true, 0);
        add("Coordinates", "HUD", true, 0);
        add("Potion Effects", "HUD", false, 0);
        add("Zoom", "Visual", false, GLFW.GLFW_KEY_C);
        add("Toggle Sprint", "Player", false, GLFW.GLFW_KEY_K);
        add("Crosshair", "Visual", false, 0);
        add("Fullbright", "Visual", false, 0);
        add("Motion Blur", "Visual", false, 0);
        add("Hit Color", "Visual", false, 0);
        add("Scoreboard", "HUD", false, 0);
        add("Waypoints", "World", false, 0);
        add("Entity Culling", "Performance", true, 0);
        add("Fast Menu", "Performance", true, 0);
    }
    private void add(String n, String c, boolean h, int k) {
        Module m=new Module(n,c,h,k); modules.add(m); if(k!=0) keyMap.put(k,m);
    }
    public List<Module> all(){ return Collections.unmodifiableList(modules); }
    public List<Module> category(String c){ return modules.stream().filter(m->m.category.equals(c)).toList(); }
    public void toggle(Module m){ m.enabled=!m.enabled; }
    public void tick(Minecraft mc) {
        if(mc.screen!=null) return;
        long win=mc.getWindow().getWindow();
        for(Module m:modules) {
            if(m.key!=0 && org.lwjgl.glfw.GLFW.glfwGetKey(win,m.key)==GLFW.GLFW_PRESS && (System.currentTimeMillis()-m.hashCode()>250)) {
                // key state handling is intentionally kept lightweight in this starter.
            }
        }
    }
    public void renderHud(GuiGraphics g) {
        Minecraft mc=Minecraft.getInstance();
        if(mc.player==null) return;
        int y=8;
        for(Module m:modules) if(m.enabled && m.hud) {
            String text=m.name;
            if(m.name.equals("FPS")) text="FPS: "+mc.getFps();
            if(m.name.equals("Coordinates")) text="XYZ: "+mc.player.getBlockX()+" "+mc.player.getBlockY()+" "+mc.player.getBlockZ();
            g.drawString(mc.font,text,8,y,0xFFFFFFFF,true);
            y+=mc.font.lineHeight+3;
        }
    }
}