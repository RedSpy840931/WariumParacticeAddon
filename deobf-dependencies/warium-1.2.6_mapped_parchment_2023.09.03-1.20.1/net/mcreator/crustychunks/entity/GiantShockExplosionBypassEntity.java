package net.mcreator.crustychunks.entity;

import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.procedures.GiantShockProcedureProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;

@OnlyIn(
   value = Dist.CLIENT,
   _interface = ItemSupplier.class
)
public class GiantShockExplosionBypassEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM;

   public GiantShockExplosionBypassEntity(SpawnEntity packet, Level world) {
      super((EntityType)CrustyChunksModEntities.GIANT_SHOCK_EXPLOSION_BYPASS.get(), world);
   }

   public GiantShockExplosionBypassEntity(EntityType<? extends GiantShockExplosionBypassEntity> type, Level world) {
      super(type, world);
   }

   public GiantShockExplosionBypassEntity(EntityType<? extends GiantShockExplosionBypassEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world);
   }

   public GiantShockExplosionBypassEntity(EntityType<? extends GiantShockExplosionBypassEntity> type, LivingEntity entity, Level world) {
      super(type, entity, world);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   @OnlyIn(Dist.CLIENT)
   public ItemStack getItem() {
      return PROJECTILE_ITEM;
   }

   protected ItemStack getPickupItem() {
      return PROJECTILE_ITEM;
   }

   protected void doPostHurtEffects(LivingEntity entity) {
      super.doPostHurtEffects(entity);
      entity.setArrowCount(entity.getArrowCount() - 1);
   }

   public void tick() {
      super.tick();
      GiantShockProcedureProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      if (this.inGround) {
         this.discard();
      }

   }

   public static GiantShockExplosionBypassEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 1.0F, 5.0D, 5);
   }

   public static GiantShockExplosionBypassEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
      return shoot(world, entity, source, pullingPower * 1.0F, 5.0D, 5);
   }

   public static GiantShockExplosionBypassEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      GiantShockExplosionBypassEntity entityarrow = new GiantShockExplosionBypassEntity((EntityType)CrustyChunksModEntities.GIANT_SHOCK_EXPLOSION_BYPASS.get(), entity, world);
      entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
      entityarrow.setSilent(true);
      entityarrow.setCritArrow(false);
      entityarrow.setBaseDamage(damage);
      entityarrow.setKnockback(knockback);
      world.addFreshEntity(entityarrow);
      return entityarrow;
   }

   public static GiantShockExplosionBypassEntity shoot(LivingEntity entity, LivingEntity target) {
      GiantShockExplosionBypassEntity entityarrow = new GiantShockExplosionBypassEntity((EntityType)CrustyChunksModEntities.GIANT_SHOCK_EXPLOSION_BYPASS.get(), entity, entity.level());
      double dx = target.getX() - entity.getX();
      double dy = target.getY() + (double)target.getEyeHeight() - 1.1D;
      double dz = target.getZ() - entity.getZ();
      entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.20000000298023224D, dz, 2.0F, 12.0F);
      entityarrow.setSilent(true);
      entityarrow.setBaseDamage(5.0D);
      entityarrow.setKnockback(5);
      entityarrow.setCritArrow(false);
      entity.level().addFreshEntity(entityarrow);
      return entityarrow;
   }

   static {
      PROJECTILE_ITEM = new ItemStack((ItemLike)CrustyChunksModItems.INVISIBLEITEM.get());
   }
}
