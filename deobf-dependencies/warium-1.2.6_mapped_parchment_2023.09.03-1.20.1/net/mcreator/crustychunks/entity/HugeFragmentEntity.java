package net.mcreator.crustychunks.entity;

import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.procedures.FragmentDespawnMechanicProcedure;
import net.mcreator.crustychunks.procedures.HugeBulletEntityHitProcedure;
import net.mcreator.crustychunks.procedures.HugeFragmentHitProcedure;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;

@OnlyIn(
   value = Dist.CLIENT,
   _interface = ItemSupplier.class
)
public class HugeFragmentEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM;

   public HugeFragmentEntity(SpawnEntity packet, Level world) {
      super((EntityType)CrustyChunksModEntities.HUGE_FRAGMENT.get(), world);
   }

   public HugeFragmentEntity(EntityType<? extends HugeFragmentEntity> type, Level world) {
      super(type, world);
   }

   public HugeFragmentEntity(EntityType<? extends HugeFragmentEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world);
   }

   public HugeFragmentEntity(EntityType<? extends HugeFragmentEntity> type, LivingEntity entity, Level world) {
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

   public void onHitEntity(EntityHitResult entityHitResult) {
      super.onHitEntity(entityHitResult);
      HugeBulletEntityHitProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), entityHitResult.getEntity(), this);
   }

   public void onHitBlock(BlockHitResult blockHitResult) {
      super.onHitBlock(blockHitResult);
      HugeFragmentHitProcedure.execute(this.level(), (double)blockHitResult.getBlockPos().getX(), (double)blockHitResult.getBlockPos().getY(), (double)blockHitResult.getBlockPos().getZ(), this);
   }

   public void tick() {
      super.tick();
      FragmentDespawnMechanicProcedure.execute(this);
      if (this.inGround) {
         this.discard();
      }

   }

   public static HugeFragmentEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 1.0F, 5.0D, 5);
   }

   public static HugeFragmentEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
      return shoot(world, entity, source, pullingPower * 1.0F, 5.0D, 5);
   }

   public static HugeFragmentEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      HugeFragmentEntity entityarrow = new HugeFragmentEntity((EntityType)CrustyChunksModEntities.HUGE_FRAGMENT.get(), entity, world);
      entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
      entityarrow.setSilent(true);
      entityarrow.setCritArrow(true);
      entityarrow.setBaseDamage(damage);
      entityarrow.setKnockback(knockback);
      world.addFreshEntity(entityarrow);
      return entityarrow;
   }

   public static HugeFragmentEntity shoot(LivingEntity entity, LivingEntity target) {
      HugeFragmentEntity entityarrow = new HugeFragmentEntity((EntityType)CrustyChunksModEntities.HUGE_FRAGMENT.get(), entity, entity.level());
      double dx = target.getX() - entity.getX();
      double dy = target.getY() + (double)target.getEyeHeight() - 1.1D;
      double dz = target.getZ() - entity.getZ();
      entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.20000000298023224D, dz, 2.0F, 12.0F);
      entityarrow.setSilent(true);
      entityarrow.setBaseDamage(5.0D);
      entityarrow.setKnockback(5);
      entityarrow.setCritArrow(true);
      entity.level().addFreshEntity(entityarrow);
      return entityarrow;
   }

   static {
      PROJECTILE_ITEM = new ItemStack((ItemLike)CrustyChunksModItems.TINYPROJECTILE_ITEM.get());
   }
}
