package com.zmaj.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.lwjgl.glfw.GLFW;

public class ZmajClient implements ClientModInitializer {
    public static final ModuleManager MODULES = new ModuleManager();
    private static KeyMapping guiKey;
    private static long lastTick;

    @Override
    public void onInitializeClient() {
        guiKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.zmaj.open_gui", GLFW.GLFW_KEY_RIGHT_SHIFT, "category.zmaj"));
        KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.zmaj.toggle_sprint", GLFW.GLFW_KEY_K, "category.zmaj"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (guiKey.consumeClick()) client.setScreen(new ZmajScreen(null));
            MODULES.tick(client);
        });
        HudRenderCallback.EVENT.register((graphics, tickDelta) -> MODULES.renderHud(graphics));
    }

    public static void openGui(Minecraft mc, Screen parent) {
        mc.setScreen(new ZmajScreen(parent));
    }
}