package com.michaelsebero.vulnerablevillagers;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Mod(modid = VulnerableVillagers.MODID, name = VulnerableVillagers.NAME, version = VulnerableVillagers.VERSION)
public class VulnerableVillagers {
    public static final String MODID = "vulnerablevillagers";
    public static final String NAME = "Vulnerable Villagers";
    public static final String VERSION = "1.0.0";
    
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Vulnerable Villagers is loading...");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new VillagerBehaviorHandler());
        LOGGER.info("Vulnerable Villagers loaded successfully!");
    }
}
