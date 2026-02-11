package net.mcreator.crustychunks.entity;

import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.procedures.NoFriendlyFireProcedure;
import net.mcreator.crustychunks.procedures.StrikerAISystemProcedure;
import net.mcreator.crustychunks.procedures.StrikerDeathProcedure;
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
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.core.animation.AnimationController.State;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class StrikerEntity extends Monster implements GeoEntity {
   public static final EntityDataAccessor<Boolean> SHOOT;
   public static final EntityDataAccessor<String> ANIMATION;
   public static final EntityDataAccessor<String> TEXTURE;
   private final AnimatableInstanceCache cache;
   private boolean swinging;
   private boolean lastloop;
   private long lastSwing;
   public String animationprocedure;
   String prevAnim;

   public StrikerEntity(SpawnEntity packet, Level world) {
      this((EntityType)CrustyChunksModEntities.STRIKER.get(), world);
   }

   public StrikerEntity(EntityType<StrikerEntity> type, Level world) {
      super(type, world);
      this.cache = GeckoLibUtil.createInstanceCache(this);
      this.animationprocedure = "empty";
      this.prevAnim = "empty";
      this.xpReward = 0;
      this.setNoAi(false);
      this.setMaxUpStep(0.6F);
      this.setPersistenceRequired();
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(SHOOT, false);
      this.entityData.define(ANIMATION, "undefined");
      this.entityData.define(TEXTURE, "striker");
   }

   public void setTexture(String texture) {
      this.entityData.set(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.entityData.get(TEXTURE);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new OpenDoorGoal(this, true));
      this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6D, false));
      this.goalSelector.addGoal(3, new AvoidEntityGoal(this, DecimatorEntity.class, 40.0F, 1.0D, 1.2D));
      this.goalSelector.addGoal(4, new AvoidEntityGoal(this, StrikerEntity.class, 20.0F, 1.0D, 1.2D));
      this.goalSelector.addGoal(5, new AvoidEntityGoal(this, RiflerEntity.class, 20.0F, 1.0D, 1.2D));
      this.goalSelector.addGoal(6, new AvoidEntityGoal(this, BreacherEntity.class, 20.0F, 1.0D, 1.2D));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, Player.class, false, false));
      this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, Villager.class, false, false));
      this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, IronGolem.class, false, false));
      this.goalSelector.addGoal(10, new MeleeAttackGoal(this, 1.2D, true) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return (double)(this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth());
         }
      });
      this.goalSelector.addGoal(11, new RandomStrollGoal(this, 1.0D));
      this.targetSelector.addGoal(12, (new HurtByTargetGoal(this, new Class[0]) {
         public boolean canUse() {
            double x = StrikerEntity.this.getX();
            double y = StrikerEntity.this.getY();
            double z = StrikerEntity.this.getZ();
            Entity entity = StrikerEntity.this;
            Level world = StrikerEntity.this.level();
            return super.canUse() && NoFriendlyFireProcedure.execute(entity);
         }

         public boolean canContinueToUse() {
            double x = StrikerEntity.this.getX();
            double y = StrikerEntity.this.getY();
            double z = StrikerEntity.this.getZ();
            Entity entity = StrikerEntity.this;
            Level world = StrikerEntity.this.level();
            return super.canContinueToUse() && NoFriendlyFireProcedure.execute(entity);
         }
      }).setAlertOthers(new Class[0]));
      this.goalSelector.addGoal(13, new RandomLookAroundGoal(this));
   }

   public MobType getMobType() {
      return MobType.UNDEFINED;
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place"));
   }

   public boolean hurt(DamageSource source, float amount) {
      if (source.is(DamageTypes.IN_FIRE)) {
         return false;
      } else if (!(source.getDirectEntity() instanceof ThrownPotion) && !(source.getDirectEntity() instanceof AreaEffectCloud)) {
         if (source.is(DamageTypes.CACTUS)) {
            return false;
         } else if (source.is(DamageTypes.DROWN)) {
            return false;
         } else if (source.is(DamageTypes.WITHER)) {
            return false;
         } else {
            return source.is(DamageTypes.WITHER_SKULL) ? false : super.hurt(source, amount);
         }
      } else {
         return false;
      }
   }

   public void die(DamageSource source) {
      super.die(source);
      StrikerDeathProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }

   }

   public void baseTick() {
      super.baseTick();
      StrikerAISystemProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
      this.refreshDimensions();
   }

   public EntityDimensions getDimensions(Pose p_33597_) {
      return super.getDimensions(p_33597_).scale(1.0F);
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3D);
      builder = builder.add(Attributes.MAX_HEALTH, 10.0D);
      builder = builder.add(Attributes.ARMOR, 2.0D);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0D);
      builder = builder.add(Attributes.FOLLOW_RANGE, 32.0D);
      builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1.0D);
      return builder;
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         return !event.isMoving() && event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F ? event.setAndContinue(RawAnimation.begin().thenLoop("idle")) : event.setAndContinue(RawAnimation.begin().thenLoop("Walk"));
      } else {
         return PlayState.STOP;
      }
   }

   private PlayState procedurePredicate(AnimationState event) {
      if ((this.animationprocedure.equals("empty") || event.getController().getAnimationState() != State.STOPPED) && (this.animationprocedure.equals(this.prevAnim) || this.animationprocedure.equals("empty"))) {
         if (this.animationprocedure.equals("empty")) {
            this.prevAnim = "empty";
            return PlayState.STOP;
         }
      } else {
         if (!this.animationprocedure.equals(this.prevAnim)) {
            event.getController().forceAnimationReset();
         }

         event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
         if (event.getController().getAnimationState() == State.STOPPED) {
            this.animationprocedure = "empty";
            event.getController().forceAnimationReset();
         }
      }

      this.prevAnim = this.animationprocedure;
      return PlayState.CONTINUE;
   }

   protected void tickDeath() {
      ++this.deathTime;
      if (this.deathTime == 20) {
         this.remove(RemovalReason.KILLED);
         this.dropExperience();
      }

   }

   public String getSyncedAnimation() {
      return (String)this.entityData.get(ANIMATION);
   }

   public void setAnimation(String animation) {
      this.entityData.set(ANIMATION, animation);
   }

   public void registerControllers(ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "movement", 4, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 4, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   static {
      SHOOT = SynchedEntityData.defineId(StrikerEntity.class, EntityDataSerializers.BOOLEAN);
      ANIMATION = SynchedEntityData.defineId(StrikerEntity.class, EntityDataSerializers.STRING);
      TEXTURE = SynchedEntityData.defineId(StrikerEntity.class, EntityDataSerializers.STRING);
   }
}
