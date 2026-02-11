package net.mcreator.crustychunks.entity;

import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.procedures.AIHurtProcedure;
import net.mcreator.crustychunks.procedures.BreacherAIProcedure;
import net.mcreator.crustychunks.procedures.StrikerDeathProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages.SpawnEntity;
import net.minecraftforge.registries.ForgeRegistries;

public class BreacherEntity extends Monster {
   public BreacherEntity(SpawnEntity packet, Level world) {
      this((EntityType)CrustyChunksModEntities.BREACHER.get(), world);
   }

   public BreacherEntity(EntityType<BreacherEntity> type, Level world) {
      super(type, world);
      this.setMaxUpStep(1.2F);
      this.xpReward = 0;
      this.setNoAi(false);
      this.setPersistenceRequired();
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new AvoidEntityGoal(this, BreacherEntity.class, 12.0F, 1.0D, 1.2D));
      this.goalSelector.addGoal(2, new AvoidEntityGoal(this, EradicatorEntity.class, 30.0F, 1.0D, 1.2D));
      this.goalSelector.addGoal(3, new AvoidEntityGoal(this, WorkerEntity.class, 30.0F, 1.0D, 1.2D));
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Villager.class, false, false));
      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, IronGolem.class, false, false));
      this.goalSelector.addGoal(7, new MeleeAttackGoal(this, 1.0D, true) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return (double)(this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth());
         }
      });
      this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1.0D));
      this.goalSelector.addGoal(9, new BreakDoorGoal(this, (e) -> {
         return true;
      }));
      this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
      this.goalSelector.addGoal(11, new FloatGoal(this));
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

   public boolean hurt(DamageSource damagesource, float amount) {
      double x = this.getX();
      double y = this.getY();
      double z = this.getZ();
      Level world = this.level();
      Entity sourceentity = damagesource.getEntity();
      Entity immediatesourceentity = damagesource.getDirectEntity();
      AIHurtProcedure.execute(this, sourceentity);
      if (damagesource.is(DamageTypes.IN_FIRE)) {
         return false;
      } else if (damagesource.getDirectEntity() instanceof AbstractArrow) {
         return false;
      } else if (!(damagesource.getDirectEntity() instanceof ThrownPotion) && !(damagesource.getDirectEntity() instanceof AreaEffectCloud)) {
         if (damagesource.is(DamageTypes.CACTUS)) {
            return false;
         } else {
            return damagesource.is(DamageTypes.DROWN) ? false : super.hurt(damagesource, amount);
         }
      } else {
         return false;
      }
   }

   public boolean fireImmune() {
      return true;
   }

   public void die(DamageSource source) {
      super.die(source);
      StrikerDeathProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
   }

   public void baseTick() {
      super.baseTick();
      BreacherAIProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.5D);
      builder = builder.add(Attributes.MAX_HEALTH, 30.0D);
      builder = builder.add(Attributes.ARMOR, 1.0D);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 6.0D);
      builder = builder.add(Attributes.FOLLOW_RANGE, 16.0D);
      builder = builder.add(Attributes.ATTACK_KNOCKBACK, 4.0D);
      return builder;
   }
}
