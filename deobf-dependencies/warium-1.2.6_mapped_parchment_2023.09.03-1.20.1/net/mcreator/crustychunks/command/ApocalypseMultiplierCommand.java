package net.mcreator.crustychunks.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.mcreator.crustychunks.procedures.ApocalypseSetMultiplierProcedure;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ApocalypseMultiplierCommand {
   @SubscribeEvent
   public static void registerCommand(RegisterCommandsEvent event) {
      event.getDispatcher().register((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.literal("WariumApocalypseMultiplier").requires((s) -> {
         return s.hasPermission(4);
      })).then(Commands.argument("multiplier", DoubleArgumentType.doubleArg(0.0D, 64.0D)).executes((arguments) -> {
         Level world = ((CommandSourceStack)arguments.getSource()).getUnsidedLevel();
         double x = ((CommandSourceStack)arguments.getSource()).getPosition().x();
         double y = ((CommandSourceStack)arguments.getSource()).getPosition().y();
         double z = ((CommandSourceStack)arguments.getSource()).getPosition().z();
         Entity entity = ((CommandSourceStack)arguments.getSource()).getEntity();
         if (entity == null && world instanceof ServerLevel) {
            ServerLevel _servLevel = (ServerLevel)world;
            entity = FakePlayerFactory.getMinecraft(_servLevel);
         }

         Direction direction = Direction.DOWN;
         if (entity != null) {
            direction = ((Entity)entity).getDirection();
         }

         ApocalypseSetMultiplierProcedure.execute(world, arguments, (Entity)entity);
         return 0;
      })));
   }
}
