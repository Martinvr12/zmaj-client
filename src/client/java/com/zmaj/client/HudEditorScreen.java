package com.zmaj.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class HudEditorScreen extends Screen {
    private final Screen parent;
    public HudEditorScreen(Screen p){super(Component.literal("HUD Editor"));parent=p;}
    @Override public void render(GuiGraphics g,int x,int y,float d){
        renderBackground(g,x,y,d);
        g.drawString(font,"HUD EDITOR",20,20,0xFFFFFFFF,true);
        g.drawString(font,"HUD elements are shown here. Module toggles control visibility.",20,42,0xFFAAAAAA);
        int yy=80;
        for(Module m:ZmajClient.MODULES.all()) if(m.hud){
            g.fill(20,yy-4,250,yy+20,0x66333333);
            g.drawString(font,m.name,28,yy,0xFFFFFFFF);
            yy+=30;
        }
        super.render(g,x,y,d);
    }
    @Override public void onClose(){Minecraft.getInstance().setScreen(parent);}
}