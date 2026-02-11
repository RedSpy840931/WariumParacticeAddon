package net.mcreator.crustychunks.entity;

import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.procedures.AIHurtProcedure;
import net.mcreator.crustychunks.procedures.ReaperAIProcedure;
import net.mcreator.crustychunks.procedures.ReaperDeathProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;
import net.minecraftforge.registries.ForgeRegistries;

public class ReaperEntity extends Monster {
   public static final EntityDataAccessor<Integer> DATA_spawnx;
   public static final EntityDataAccessor<Integer> DATA_spawnz;

   public ReaperEntity(SpawnEntity packet, Level world) {
      this((EntityType)CrustyChunksModEntities.REAPER.get(), world);
   }

   public ReaperEntity(EntityType<ReaperEntity> type, Level world) {
      super(type, world);
      this.setMaxUpStep(0.0F);
      this.xpReward = 0;
      this.setNoAi(false);
      this.setPersistenceRequired();
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(DATA_spawnx, 0);
      this.entityData.define(DATA_spawnz, 0);
   }

   protected PathNavigation createNavigation(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   protected void registerGoals() {
      super.registerGoals();
   }

   public MobType getMobType() {
      return MobType.UNDEFINED;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
   }

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
   }

   public boolean hurt(DamageSource damagesource, float amount) {
      double x = this.getX();
      double y = this.getY();
      double z = this.getZ();
      Level world = this.level();
      Entity sourceentity = damagesource.getEntity();
      Entity immediatesourceentity = damagesource.getDirectEntity();
      AIHurtProcedure.execute(this, sourceentity);
      if (!(damagesource.getDirectEntity() instanceof ThrownPotion) && !(damagesource.getDirectEntity() instanceof AreaEffectCloud)) {
         if (damagesource.is(DamageTypes.DRAGON_BREATH)) {
            return false;
         } else {
            return !damagesource.is(DamageTypes.WITHER) && !damagesource.is(DamageTypes.WITHER_SKULL) ? super.hurt(damagesource, amount) : false;
         }
      } else {
         return false;
      }
   }

   public void die(DamageSource source) {
      super.die(source);
      ReaperDeathProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putInt("Dataspawnx", (Integer)this.entityData.get(DATA_spawnx));
      compound.putInt("Dataspawnz", (Integer)this.entityData.get(DATA_spawnz));
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Dataspawnx")) {
         this.entityData.set(DATA_spawnx, compound.getInt("Dataspawnx"));
      }

      if (compound.contains("Dataspawnz")) {
         this.entityData.set(DATA_spawnz, compound.getInt("Dataspawnz"));
      }

   }

   public void baseTick() {
      super.baseTick();
      ReaperAIProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
   }

   protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
   }

   public void setNoGravity(boolean ignored) {
      super.setNoGravity(true);
   }

   public void aiStep() {
      super.aiStep();
      this.setNoGravity(true);
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.0D);
      builder = builder.add(Attributes.MAX_HEALTH, 60.0D);
      builder = builder.add(Attributes.ARMOR, 0.0D);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0D);
      builder = builder.add(Attributes.FOLLOW_RANGE, 128.0D);
      builder = builder.add(Attributes.FLYING_SPEED, 0.0D);
      return builder;
   }

   static {
      DATA_spawnx = SynchedEntityData.defineId(ReaperEntity.class, EntityDataSerializers.INT);
      DATA_spawnz = SynchedEntityData.defineId(ReaperEntity.class, EntityDataSerializers.INT);
   }
}
