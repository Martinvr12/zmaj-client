package com.zmaj.client;

public final class Module {
    public final String name;
    public final String category;
    public boolean enabled;
    public boolean hud;
    public int key;

    public Module(String name, String category, boolean hud, int key) {
        this.name = name; this.category = category; this.hud = hud; this.key = key;
    }
}