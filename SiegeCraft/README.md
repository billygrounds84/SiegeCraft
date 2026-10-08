# SiegeCraft

A Minecraft Java Edition Fabric mod that adds an **optional Rainbow Six Siege-style game mode** while keeping normal Minecraft intact.

## Current milestone — 0.1.0

- Minecraft target: 26.1.2
- Fabric Loader: 0.19.5+
- Fabric API: 0.155.2+26.1.2
- Java: 25+
- Operator selection menu
- 78 current Siege operators represented as data-driven entries
- Attackers / Defenders filtering
- `O` opens the operator menu
- Normal survival, creative, and other Minecraft play remains untouched

## Planned milestones

1. Operator selection and match state
2. Attackers vs Defenders teams
3. Bomb / Hostage / Secure Area modes
4. Siege-style weapons and gadgets using original project implementations
5. Destructible/defensible Minecraft map systems
6. Multiplayer synchronization
7. Optional companion integration with the player's own Rainbow Six Siege installation where technically and legally appropriate
8. Dedicated Siege maps plus starting matches from ordinary Minecraft worlds

## Important asset boundary

This project does not ship Ubisoft's proprietary Rainbow Six Siege binaries, textures, models, sounds, maps, or other game files. Any future companion integration must read permitted content from the player's own installation rather than redistributing those files.

## Build

Minecraft 26.1 requires Java 25. From a machine with JDK 25 and Gradle/Gradle Wrapper available, run:

```text
./gradlew build
```

The first build also needs access to the Fabric/Minecraft Maven repositories.
