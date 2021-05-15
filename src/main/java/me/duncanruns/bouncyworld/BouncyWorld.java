package me.duncanruns.bouncyworld;

import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BouncyWorld implements ModInitializer {

    public static final boolean shouldDoFallDamage = false;

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "bouncyworld";
    public static final String MOD_NAME = "Bouncy World Mod";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}