package com.wariumapi.ballistics;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public record ImpactContext(Level level, Entity shooter, Entity target, Vec3 hitPos, Vec3 hitNormal, BlockState blockState, Entity projectile, ProjectileProfile projectileProfile) {
   public ImpactContext(Level level, Entity shooter, Entity target, Vec3 hitPos, Vec3 hitNormal, BlockState blockState, Entity projectile, ProjectileProfile projectileProfile) {
      this.level = level;
      this.shooter = shooter;
      this.target = target;
      this.hitPos = hitPos;
      this.hitNormal = hitNormal;
      this.blockState = blockState;
      this.projectile = projectile;
      this.projectileProfile = projectileProfile;
   }

   public Level level() {
      return this.level;
   }

   public Entity shooter() {
      return this.shooter;
   }

   public Entity target() {
      return this.target;
   }

   public Vec3 hitPos() {
      return this.hitPos;
   }

   public Vec3 hitNormal() {
      return this.hitNormal;
   }

   public BlockState blockState() {
      return this.blockState;
   }

   public Entity projectile() {
      return this.projectile;
   }

   public ProjectileProfile projectileProfile() {
      return this.projectileProfile;
   }
}
