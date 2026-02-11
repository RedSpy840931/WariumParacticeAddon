package net.mcreator.crustychunks.entity;

import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.procedures.MuzzleFlashProducerWhileProjectileFlyingTickProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;
import net.minecraftforge.registries.ForgeRegistries;

@OnlyIn(
   value = Dist.CLIENT,
   _interface = ItemSupplier.class
)
public class MuzzleFlashProducerEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM;

   public MuzzleFlashProducerEntity(SpawnEntity packet, Level world) {
      super((EntityType)CrustyChunksModEntities.MUZZLE_FLASH_PRODUCER.get(), world);
   }

   public MuzzleFlashProducerEntity(EntityType<? extends MuzzleFlashProducerEntity> type, Level world) {
      super(type, world);
   }

   public MuzzleFlashProducerEntity(EntityType<? extends MuzzleFlashProducerEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world);
   }

   public MuzzleFlashProducerEntity(EntityType<? extends MuzzleFlashProducerEntity> type, LivingEntity entity, Level world) {
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
      MuzzleFlashProducerWhileProjectileFlyingTickProcedure.execute(this.level(), this);
      if (this.inGround) {
         this.discard();
      }

   }

   public static MuzzleFlashProducerEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 0.0F, 0.0D, 0);
   }

   public static MuzzleFlashProducerEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
      return shoot(world, entity, source, pullingPower * 0.0F, 0.0D, 0);
   }

   public static MuzzleFlashProducerEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      MuzzleFlashProducerEntity entityarrow = new MuzzleFlashProducerEntity((EntityType)CrustyChunksModEntities.MUZZLE_FLASH_PRODUCER.get(), entity, world);
      entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
      entityarrow.setSilent(true);
      entityarrow.setCritArrow(false);
      entityarrow.setBaseDamage(damage);
      entityarrow.setKnockback(knockback);
      world.addFreshEntity(entityarrow);
      world.playSound((Player)null, entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.5F + 1.0F) + power / 2.0F);
      return entityarrow;
   }

   public static MuzzleFlashProducerEntity shoot(LivingEntity entity, LivingEntity target) {
      MuzzleFlashProducerEntity entityarrow = new MuzzleFlashProducerEntity((EntityType)CrustyChunksModEntities.MUZZLE_FLASH_PRODUCER.get(), entity, entity.level());
      double dx = target.getX() - entity.getX();
      double dy = target.getY() + (double)target.getEyeHeight() - 1.1D;
      double dz = target.getZ() - entity.getZ();
      entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.20000000298023224D, dz, 0.0F, 12.0F);
      entityarrow.setSilent(true);
      entityarrow.setBaseDamage(0.0D);
      entityarrow.setKnockback(0);
      entityarrow.setCritArrow(false);
      entity.level().addFreshEntity(entityarrow);
      entity.level().playSound((Player)null, entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1.0F, 1.0F / (RandomSource.create().nextFloat() * 0.5F + 1.0F));
      return entityarrow;
   }

   static {
      PROJECTILE_ITEM = new ItemStack((ItemLike)CrustyChunksModItems.INVISIBLEITEM.get());
   }
}
