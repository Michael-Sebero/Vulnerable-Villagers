package com.michaelsebero.vulnerablevillagers;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VillagerBehaviorHandler {
    
    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntityVillager) {
            EntityVillager villager = (EntityVillager) event.getEntity();
            addVillagerAvoidanceAI(villager);
        } else if (isHostileMob(event.getEntity()) && event.getEntity() instanceof EntityCreature) {
            EntityCreature hostile = (EntityCreature) event.getEntity();
            addVillagerTargetingAI(hostile);
        }
    }
    
    private void addVillagerAvoidanceAI(EntityVillager villager) {
        // Make villagers run away from hostile mobs
        villager.tasks.addTask(1, new EntityAIAvoidEntity<EntityMob>(villager, EntityMob.class, 16.0F, 0.8D, 1.33D));
        villager.tasks.addTask(1, new EntityAIAvoidEntity<EntitySlime>(villager, EntitySlime.class, 16.0F, 0.8D, 1.33D));
        villager.tasks.addTask(1, new EntityAIAvoidEntity<EntityGhast>(villager, EntityGhast.class, 16.0F, 0.8D, 1.33D));
        villager.tasks.addTask(1, new EntityAIAvoidEntity<EntityShulker>(villager, EntityShulker.class, 16.0F, 0.8D, 1.33D));
    }
    
    private void addVillagerTargetingAI(EntityCreature hostile) {
        // Make hostile mobs target villagers
        hostile.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityVillager>(hostile, EntityVillager.class, false));
    }
    
    private boolean isHostileMob(net.minecraft.entity.Entity entity) {
        return entity instanceof EntityMob || 
               entity instanceof EntitySlime || 
               entity instanceof EntityGhast || 
               entity instanceof EntityShulker ||
               entity instanceof EntityBlaze ||
               entity instanceof EntityCreeper ||
               entity instanceof EntitySkeleton ||
               entity instanceof EntitySpider ||
               entity instanceof EntityWitch ||
               entity instanceof EntityEndermite ||
               entity instanceof EntityGuardian ||
               entity instanceof EntitySilverfish ||
               entity instanceof EntityWitherSkeleton ||
               entity instanceof EntityStray;
    }
}
