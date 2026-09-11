# Zmaj Client

Fabric 1.21.11 client-side starter project.

Included:
- Right Shift opens Zmaj GUI
- Clean client GUI with categories
- HUD modules: FPS, CPS, Keystrokes, Armor Status, Coordinates, Potion Effects, Scoreboard
- Visual modules: Zoom, Crosshair, Fullbright, Motion Blur, Hit Color
- Performance modules: Entity Culling, Fast Menu
- HUD Editor screen
- Macro screen with recording/playback scaffold and command macro
- Profiles and Settings categories ready for expansion
- Java 21
- Fabric API 0.141.6+1.21.11

Build:
Windows: gradlew.bat build
Linux/macOS: ./gradlew build

Output:
build/libs/zmaj-client-1.0.0.jar

The macro recorder in this version is a safe client-side scaffold. Full low-level mouse/keyboard replay requires additional input-hook implementation and careful server compatibility testing.
