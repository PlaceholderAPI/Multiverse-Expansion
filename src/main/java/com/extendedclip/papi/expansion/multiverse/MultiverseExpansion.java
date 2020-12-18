package com.extendedclip.papi.expansion.multiverse;

import me.clip.placeholderapi.expansion.*;
import com.onarandombox.MultiverseCore.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import me.clip.placeholderapi.*;
import com.onarandombox.MultiverseCore.api.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MultiverseExpansion extends PlaceholderExpansion implements Cacheable {
    private MultiverseCore core;

    public boolean canRegister() {
        return (core = (MultiverseCore) Bukkit.getPluginManager().getPlugin(getRequiredPlugin())) != null;
    }

    @NotNull
    @Override
    public String getAuthor() {
        return "clip";
    }

    @NotNull
    @Override
    public String getIdentifier() {
        return "multiverse";
    }

    @NotNull
    @Override
    public String getRequiredPlugin() {
        return "Multiverse-Core";
    }

    @NotNull
    @Override
    public String getVersion() {
        return "1.0.1";
    }

    @NotNull
    @Override
    public String onPlaceholderRequest(@Nullable final Player p, @NotNull final String s) {
        if (p == null) {
            return "";
        }
        final MultiverseWorld mvworld = this.core.getMVWorldManager().getMVWorld(p.getWorld());
        if (!this.core.getMVWorldManager().isMVWorld(p.getWorld())) {
            return "";
        }
        switch (s) {
            case "world_alias":
                return mvworld.getAlias() != null ? mvworld.getAlias() : "";
            case "world_all_property_names":
                return mvworld.getAllPropertyNames() != null ? mvworld.getAllPropertyNames() : "";
            case "world_generator":
                return mvworld.getGenerator() != null ? mvworld.getGenerator() : "";
            case "world_name":
                return mvworld.getName() != null ? mvworld.getName() : "";
            case "world_name_colored":
                return mvworld.getColoredWorldString() != null ? mvworld.getColoredWorldString() : "";
            case "world_permissible_name":
                return mvworld.getPermissibleName() != null ? mvworld.getPermissibleName() : "";
            case "world_time":
                return mvworld.getTime() != null ? mvworld.getTime() : "";
            case "world_animals_spawn_enabled":
                return mvworld.canAnimalsSpawn() ? PlaceholderAPIPlugin.booleanTrue() : PlaceholderAPIPlugin.booleanFalse();
            case "world_monsters_spawn_enabled":
                return mvworld.canMonstersSpawn() ? PlaceholderAPIPlugin.booleanTrue() : PlaceholderAPIPlugin.booleanFalse();
            case "world_access_permission":
                return mvworld.getAccessPermission() != null ? mvworld.getAccessPermission().getName() : "";
            case "world_adjust_spawn_enabled":
                return mvworld.getAdjustSpawn() ? PlaceholderAPIPlugin.booleanTrue() : PlaceholderAPIPlugin.booleanFalse();
            case "world_allow_flight_enabled":
                return mvworld.getAllowFlight() ? PlaceholderAPIPlugin.booleanTrue() : PlaceholderAPIPlugin.booleanFalse();
            case "world_auto_heal_enabled":
                return mvworld.getAutoHeal() ? PlaceholderAPIPlugin.booleanTrue() : PlaceholderAPIPlugin.booleanFalse();
            case "world_auto_load_enabled":
                return mvworld.getAutoLoad() ? PlaceholderAPIPlugin.booleanTrue() : PlaceholderAPIPlugin.booleanFalse();
            case "world_bed_respawn_enabled":
                return mvworld.getBedRespawn() ? PlaceholderAPIPlugin.booleanTrue() : PlaceholderAPIPlugin.booleanFalse();
            case "world_color":
                return mvworld.getColor() != null ? mvworld.getColor().toString() : "";
            case "world_currency":
                return String.valueOf(mvworld.getCurrency());
            case "world_difficulty":
                return mvworld.getDifficulty() != null ? mvworld.getDifficulty().name() : "";
            case "world_environment":
                return mvworld.getEnvironment() != null ? mvworld.getEnvironment().name() : "";
            case "world_gamemode":
                return mvworld.getGameMode() != null ? mvworld.getGameMode().name() : "";
            case "world_hunger_enabled":
                return mvworld.getHunger() ? PlaceholderAPIPlugin.booleanTrue() : PlaceholderAPIPlugin.booleanFalse();
            case "world_player_limit":
                return String.valueOf(mvworld.getPlayerLimit());
            case "world_price":
                return String.valueOf(mvworld.getPrice());
            case "world_seed":
                return String.valueOf(mvworld.getSeed());
            case "world_style":
                return mvworld.getStyle() != null ? mvworld.getStyle().toString() : "";
            case "world_type":
                return mvworld.getWorldType() != null ? mvworld.getWorldType().getName() : "";
        }

        return (mvworld.getStyle() != null) ? mvworld.getStyle().toString() : "";
    }

    @Override
    public void clear() {
        this.core = null;
    }
}
