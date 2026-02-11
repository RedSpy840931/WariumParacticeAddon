package net.mcreator.crustychunks.procedures;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules.BooleanValue;

public class ApocalypseModeToggleProcedure {
   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
      if (entity != null) {
         double Riflers = 0.0D;
         double Commanders = 0.0D;
         double Decimators = 0.0D;
         double spawnx = 0.0D;
         double spawnz = 0.0D;
         double Mortarers = 0.0D;
         double Flamers = 0.0D;
         double Hunters = 0.0D;
         ((BooleanValue)world.getLevelData().getGameRules().getRule(CrustyChunksModGameRules.APOCALYPSE_MODE)).set(BoolArgumentType.getBool(arguments, "Toggle"), world.getServer());
         Player _player;
         if (BoolArgumentType.getBool(arguments, "Toggle")) {
            if (entity instanceof Player) {
               _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("Apocalypse Mode set to: True"), false);
               }
            }
         } else if (entity instanceof Player) {
            _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("Apocalypse Mode set to False"), false);
            }
         }

      }
   }
}
