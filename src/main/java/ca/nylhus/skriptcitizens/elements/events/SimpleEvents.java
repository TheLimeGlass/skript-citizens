package ca.nylhus.skriptcitizens.elements.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.util.SimpleEvent;
import org.skriptlang.skript.lang.converter.Converter;
import ch.njol.skript.registrations.EventValues;
import net.citizensnpcs.api.event.DespawnReason;
import net.citizensnpcs.api.event.NPCClickEvent;
import net.citizensnpcs.api.event.NPCCreateEvent;
import net.citizensnpcs.api.event.NPCDespawnEvent;
import net.citizensnpcs.api.event.NPCEvent;
import net.citizensnpcs.api.event.NPCLeftClickEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.event.NPCSelectEvent;
import net.citizensnpcs.api.event.NPCSpawnEvent;
import net.citizensnpcs.api.event.SpawnReason;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.eclipse.jdt.annotation.Nullable;

@SuppressWarnings("unused")
public class SimpleEvents {

    static {
        // Events
        Skript.registerEvent("Citizen Click", SimpleEvent.class, NPCClickEvent.class,
                        "(citizen|npc) click")
                .description("Called when an NPC is clicked by a player.")
                .examples("on npc click:", "\tbroadcast \"an NPC has been clicked!\"")
                .since("1.0.0");

        Skript.registerEvent("Citizen Left Click", SimpleEvent.class, NPCLeftClickEvent.class,
                        "(citizen|npc) left click")
                .description("Called when an NPC is left-clicked by a player.")
                .examples("on npc left click:", "\tkill player")
                .since("1.0.0");

        Skript.registerEvent("Citizen Right Click", SimpleEvent.class, NPCRightClickEvent.class,
                        "(citizen|npc) right click")
                .description("Called when an NPC is right-clicked by a player.")
                .examples("on npc right click:", "\tteleport player to spawn of world \"world\"")
                .since("1.0.0");

        Skript.registerEvent("Citizen Select", SimpleEvent.class, NPCSelectEvent.class,
                        "(citizen|npc) select")
                .description("Called when an NPC is selected by a player.")
                .since("1.0.0");

        Skript.registerEvent("Citizen Despawn", SimpleEvent.class, NPCDespawnEvent.class,
                        "(citizen|npc) despawn")
                .description("Called when an NPC despawns.")
                .since("1.0.0");

        Skript.registerEvent("Citizen Spawn", SimpleEvent.class, NPCSpawnEvent.class,
                        "(citizen|npc) spawn")
                .description("Called when an NPC spawns.")
                .since("1.0.0");

        Skript.registerEvent("Citizen Create", SimpleEvent.class, NPCCreateEvent.class,
                        "(citizen|npc) create")
                .description("Called when an NPC has been created")
                .examples("on npc create: \tteleport event-npc to spawn of world \"world\"")
                .since("1.0.0");

        // Event Values
        EventValues.registerEventValue(NPCEvent.class, NPC.class, new Converter<NPCEvent, NPC>() {
            @Override
            public @Nullable NPC convert(NPCEvent event) {
                return event.getNPC();
            }
        }, EventValues.TIME_NOW);

        EventValues.registerEventValue(NPCClickEvent.class, Player.class, new Converter<NPCClickEvent, Player>() {
            @Override
            public @Nullable Player convert(NPCClickEvent event) {
                return event.getClicker();
            }
        }, EventValues.TIME_NOW);

        EventValues.registerEventValue(NPCSelectEvent.class, CommandSender.class, new Converter<NPCSelectEvent, CommandSender>() {
            @Override
            public @Nullable CommandSender convert(NPCSelectEvent event) {
                return event.getSelector();
            }
        }, EventValues.TIME_NOW);

        EventValues.registerEventValue(NPCDespawnEvent.class, DespawnReason.class, new Converter<NPCDespawnEvent, DespawnReason>() {
            @Override
            public @Nullable DespawnReason convert(NPCDespawnEvent event) {
                return event.getReason();
            }
        }, EventValues.TIME_NOW);

        EventValues.registerEventValue(NPCSpawnEvent.class, Location.class, new Converter<NPCSpawnEvent, Location>() {
            @Override
            public @Nullable Location convert(NPCSpawnEvent event) {
                return event.getLocation();
            }
        }, EventValues.TIME_NOW);

        EventValues.registerEventValue(NPCSpawnEvent.class, SpawnReason.class, new Converter<NPCSpawnEvent, SpawnReason>() {
            @Override
            public @Nullable SpawnReason convert(NPCSpawnEvent event) {
                return event.getReason();
            }
        }, EventValues.TIME_NOW);
    }

}
