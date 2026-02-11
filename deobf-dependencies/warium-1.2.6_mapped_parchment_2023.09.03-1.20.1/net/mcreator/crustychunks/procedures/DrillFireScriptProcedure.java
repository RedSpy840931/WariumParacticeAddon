package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.DrillProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.item.HandDrillItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DrillFireScriptProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (0.0D >= itemstack.getOrCreateTag().getDouble("T") && 2.0D <= itemstack.getOrCreateTag().getDouble("Fluid")) {
            itemstack.getOrCreateTag().putDouble("Fluid", itemstack.getOrCreateTag().getDouble("Fluid") - 2.0D);
            Level projectileLevel = entity.level();
            if (!projectileLevel.isClientSide()) {
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new DrillProjectileEntity((EntityType)CrustyChunksModEntities.DRILL_PROJECTILE.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, entity, 5.0F, 1);
               _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.7F, 0.0F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }

            if (itemstack.getItem() instanceof HandDrillItem) {
               itemstack.getOrCreateTag().putString("geckoAnim", "Fire");
            }

            itemstack.getOrCreateTag().putDouble("T", 7.0D);
         }

      }
   }
}
