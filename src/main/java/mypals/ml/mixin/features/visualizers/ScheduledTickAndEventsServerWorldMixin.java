package mypals.ml.mixin.features.visualizers;

import com.llamalad7.mixinextras.sugar.Local;
import mypals.ml.YetAnotherCarpetAdditionServer;
import mypals.ml.settings.YetAnotherCarpetAdditionRules;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.BlockEvent;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.tick.WorldTickScheduler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

@Mixin(ServerWorld.class)
public abstract class ScheduledTickAndEventsServerWorldMixin {
    @Shadow
    @Final
    private WorldTickScheduler<Block> blockTickScheduler;

    @Shadow
    @Final
    private WorldTickScheduler<Fluid> fluidTickScheduler;

    @Shadow
    public abstract ServerWorld toServerWorld();

    @Inject(
            method = "tick",
            at = @At("HEAD")
    )
    private void ServerTickAddScheduledTickMarker(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        Map<Long, Integer> blockTickCounter = new HashMap<>();
        Map<Long, Integer> fluidTickCounter = new HashMap<>();

        blockTickScheduler.chunkTickSchedulers.values().forEach(chunkTickScheduler -> {
            chunkTickScheduler.getQueueAsStream().forEach(orderedTick -> {
                if (YetAnotherCarpetAdditionRules.scheduledTickVisualize) {
                    long triggerTick = orderedTick.triggerTick();
                    int subOrder = blockTickCounter.compute(triggerTick, (k, v) -> (v == null ? 1 : v + 1));

                    YetAnotherCarpetAdditionServer.scheduledTickVisualizing.setVisualizer(
                            (ServerWorld) (Object) this,
                            orderedTick.pos(),
                            triggerTick,
                            orderedTick.priority().getIndex(),
                            subOrder,
                            Text.translatable(orderedTick.type().getTranslationKey()).getString(),
                            false
                    );
                }
            });
        });

        // Fluid Ticks 可视化
        fluidTickScheduler.chunkTickSchedulers.values().forEach(chunkTickScheduler -> {
            chunkTickScheduler.getQueueAsStream().forEach(orderedTick -> {
                if (YetAnotherCarpetAdditionRules.scheduledTickVisualize) {
                    long triggerTick = orderedTick.triggerTick();
                    int subOrder = fluidTickCounter.compute(triggerTick, (k, v) -> (v == null ? 1 : v + 1));

                    YetAnotherCarpetAdditionServer.scheduledTickVisualizing.setVisualizer(
                            (ServerWorld) (Object) this,
                            orderedTick.pos(),
                            triggerTick,
                            orderedTick.priority().getIndex(),
                            subOrder,
                            Text.translatable(
                                    orderedTick.type()
                                            .getStateManager()
                                            .getDefaultState()
                                            .getBlockState()
                                            .getBlock()
                                            .getTranslationKey()
                            ).getString(),
                            true
                    );
                }
            });
        });
    }

    @Inject(
            method = "tickChunk",
            at = @At(target = "Lnet/minecraft/world/chunk/ChunkSection;getBlockState(III)Lnet/minecraft/block/BlockState;", value = "INVOKE")
    )
    private void ServerTickAddRandomTickMarker(WorldChunk chunk, int randomTickSpeed, CallbackInfo ci, @Local BlockPos blockPos2) {
        if (YetAnotherCarpetAdditionRules.randomTickVisualize) {
            YetAnotherCarpetAdditionServer.randomTickVisualizing.setVisualizer(chunk.getWorld(), blockPos2);
        }
    }

    @Unique
    List<BlockEvent> eventCurrentTick = new ArrayList<>();

    @Inject(
            method = "processBlockEvent",
            at = @At("HEAD")
    )
    private void ServerTickAddBlockEventMarker(BlockEvent event, CallbackInfoReturnable<Boolean> cir) {
        if (YetAnotherCarpetAdditionRules.blockEventVisualize) {
            eventCurrentTick.add(event);
            YetAnotherCarpetAdditionServer.blockEventVisualizing.setVisualizer(this.toServerWorld(), event.pos(), event.pos().toCenterPos(), eventCurrentTick.size());
        }
    }

    @Inject(
            method = "processSyncedBlockEvents",
            at = @At("HEAD")

    )
    private void processSyncedBlockEvents(CallbackInfo ci) {
        eventCurrentTick.clear();
    }

    @Inject(
            method = "emitGameEvent",
            at = @At("HEAD")
    )
    private void ServerTickAddGameEventMarker(RegistryEntry<GameEvent> event, Vec3d emitterPos, GameEvent.Emitter emitter, CallbackInfo ci) {
        if (YetAnotherCarpetAdditionRules.gameEventVisualize) {
            String type = event.getKey().get().getValue().toString();
            String emitterName = "";
            if (emitter.sourceEntity() != null) {
                emitterName = Text.translatable(emitter.sourceEntity().getType().getTranslationKey()).getString();
            } else {
                if (emitter.affectedState() != null) {
                    emitterName = Text.translatable(emitter.affectedState().getBlock().getTranslationKey()).getString();
                }
            }
            String[] eventData = new String[]{emitterName, type};
            YetAnotherCarpetAdditionServer.gameEventVisualizing.setVisualizer(this.toServerWorld(), emitterPos, emitterPos, eventData);
        }
    }
}
