package com.wariumapi.internal;

import com.wariumapi.ballistics.BallisticsService;
import com.wariumapi.ballistics.ProjectileProfile;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

final class NoopBallisticsService implements BallisticsService {
   public void registerProfile(ResourceLocation id, ProjectileProfile profile) {
   }

   public void bindProfile(ResourceLocation profileId, EntityType<?> entityType) {
   }

   public void bindProfile(ResourceLocation profileId, Class<? extends Entity> entityClass) {
   }

   public Optional<ProjectileProfile> getProfile(ResourceLocation id) {
      return Optional.empty();
   }

   public Optional<ProjectileProfile> getProfile(Entity projectileEntity) {
      return Optional.empty();
   }

   public Collection<ResourceLocation> listProfiles() {
      return Collections.emptyList();
   }
}
