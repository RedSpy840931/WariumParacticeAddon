package com.wariumapi.ballistics;

import java.util.Collection;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public interface BallisticsService {
   void registerProfile(ResourceLocation var1, ProjectileProfile var2);

   void bindProfile(ResourceLocation var1, EntityType<?> var2);

   void bindProfile(ResourceLocation var1, Class<? extends Entity> var2);

   Optional<ProjectileProfile> getProfile(ResourceLocation var1);

   Optional<ProjectileProfile> getProfile(Entity var1);

   Collection<ResourceLocation> listProfiles();
}
