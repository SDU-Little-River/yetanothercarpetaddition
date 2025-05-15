package mypals.ml.settings;

import carpet.api.settings.Rule;

import static carpet.api.settings.RuleCategory.*;
import static mypals.ml.settings.RuleValidators.MOVING_PISTON_SPEED_VALIDATOR;

public class YetAnotherCarpetAdditionRules {
    public static final String YACA = "YACA";
    @Rule(
            categories = {YACA, FEATURE, CREATIVE}
    )
    public static boolean enableTickStepCounter = false;
    @Rule(
            categories = {YACA, FEATURE, EXPERIMENTAL}
    )
    public static boolean enableMountPlayers = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stopTickingWorldBorder = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stopTickingWeather = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stopTickingTime = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stopTickingBlocks = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stopTickingFluids = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stopTickingRaid = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stopTickingChunkManager = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stopTickingBlockEvents = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stopTickingDragonFight = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stopCheckEntityDespawn = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stopTickingEntities = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stopTickingBlockEntities = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stopTickingSpawners = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean enchantCommandLimitOverwrite = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean enchantCommandBypassItemType = false;
    @Rule(
            categories = {YACA, FEATURE, COMMAND}
    )
    public static boolean mergeSmartAndRegularCommandSuggestions = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean optimizedStructureBlock = false;
    @Rule(
            categories = {YACA, FEATURE, EXPERIMENTAL}
    )
    public static boolean morphMovingPiston = false;
    @Rule(
            categories = {YACA, FEATURE, EXPERIMENTAL},
            validators = {MOVING_PISTON_SPEED_VALIDATOR.class}
    )
    public static float movingPistonSpeed = 0.5F;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean bedsRecordSleeperFacing = false;
    @Rule(
            categories = {YACA, FEATURE, CREATIVE}
    )
    public static boolean silenceTP = false;
    @Rule(
            categories = {YACA, FEATURE, COMMAND}
    )
    public static String commandEasyItemShadowing = "false";
    @Rule(
            categories = {YACA, FEATURE, COMMAND}
    )
    public static String commandRenameItem = "false";
    @Rule(
            categories = {YACA, FEATURE, EXPERIMENTAL}
    )
    public static boolean instantSchedule = false;
    @Rule(
            categories = {YACA, FEATURE, EXPERIMENTAL}
    )
    public static boolean instantFalling = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean copyablePlayerMessages = false;
    @Rule(
            categories = {YACA, FEATURE, EXPERIMENTAL}
    )
    public static boolean moreHardCollisions = false;
    @Rule(
            categories = {YACA, FEATURE, EXPERIMENTAL}
    )
    public static boolean farlandReintroduced = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean fallingSnowLayers = false;
    @Rule(
            categories = {YACA, FEATURE, COMMAND}
    )
    public static boolean bypassModifyPlayerDataRestriction = false;
    @Rule(
            categories = {YACA, FEATURE},
            options = {"off", "500", "1000", "6000"},
            strict = false

    )
    public static String hopperCounterDataRecorder = "false";
    @Rule(
            categories = {YACA, FEATURE, EXPERIMENTAL}
    )
    public static boolean bypassCrashForcibly = false;
    @Rule(
            categories = {YACA, FEATURE, EXPERIMENTAL}
    )
    public static boolean forceMaxLightLevel = false;
    @Rule(
            categories = {YACA, FEATURE, EXPERIMENTAL}
    )
    public static boolean disableLightUpdate = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean scheduledTickVisualize = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean hopperCooldownVisualize = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean randomTickVisualize = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean gameEventVisualize = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean blockEventVisualize = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean blockUpdateVisualize = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean stateUpdateVisualize = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean comparatorUpdateVisualize = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean blocksNoSelfCheck = false;

    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean blocksNoSuffocate = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean blocksPlaceAtAnywhere = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean blockNoBreakParticles = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean blocksNoHardness = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean unicodeArgumentsSupport = false;
    @Rule(
            categories = {YACA, FEATURE}
    )
    public static boolean commandEnhance = false;

}