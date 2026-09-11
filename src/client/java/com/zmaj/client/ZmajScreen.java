package com.zmaj.client;

import java.util.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class ZmajScreen extends Screen {
    private final Screen parent;
    private String category="HUD";
    private int scroll=0;
    private final String[] categories={"HUD","Visual","Player","World","Performance","Macros","Profiles","Settings"};

    public ZmajScreen(Screen parent){ super(Component.literal("Zmaj Client")); this.parent=parent; }

    @Override protected void init() { rebuild(); }

    private void rebuild() {
        clearWidgets();
        int left=22;
        int top=60;
        for(int i=0;i<categories.length;i++){
            final String c=categories[i];
            addRenderableWidget(Button.builder(Component.literal(c),b->{category=c; rebuild();})
                    .bounds(left,top+i*34,118,28).build());
        }
        if(category.equals("Macros")) {
            addRenderableWidget(Button.builder(Component.literal("Record Macro"),b->MacroManager.startRecording())
                    .bounds(170,90,150,28).build());
            addRenderableWidget(Button.builder(Component.literal("Stop Recording"),b->MacroManager.stopRecording())
                    .bounds(330,90,150,28).build());
            addRenderableWidget(Button.builder(Component.literal("Play Last Macro"),b->MacroManager.playLast(Minecraft.getInstance()))
                    .bounds(170,125,150,28).build());
            addRenderableWidget(Button.builder(Component.literal("Command Macro: /hub"),b->MacroManager.sendCommand(Minecraft.getInstance(),"/hub"))
                    .bounds(330,125,150,28).build());
            return;
        }
        List<Module> list=ZmajClient.MODULES.category(category);
        int y=60;
        for(Module m:list) {
            String label=(m.enabled?"ON  ":"OFF ")+m.name;
            addRenderableWidget(Button.builder(Component.literal(label),b->{ZmajClient.MODULES.toggle(m); rebuild();})
                    .bounds(170,y,250,28).build());
            y+=34;
        }
        if(category.equals("HUD")) {
            addRenderableWidget(Button.builder(Component.literal("Open HUD Editor"),b->Minecraft.getInstance().setScreen(new HudEditorScreen(this)))
                    .bounds(440,60,180,28).build());
        }
    }

    @Override public void render(GuiGraphics g,int mouseX,int mouseY,float delta) {
        renderBackground(g,mouseX,mouseY,delta);
        g.fill(0,0,width,height,0xD90B0B0F);
        g.fill(0,0,6,height,0xFFE33B3B);
        g.drawString(font,"ZMAJ CLIENT",22,22,0xFFFFFFFF,true);
        g.drawString(font,"Fabric 1.21.11",22,38,0xFFAAAAAA,false);
        g.drawString(font,category,170,38,0xFFE33B3B,true);
        super.render(g,mouseX,mouseY,delta);
    }
    @Override public void onClose(){ Minecraft.getInstance().setScreen(parent); }
}