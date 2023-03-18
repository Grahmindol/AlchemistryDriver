package ayral.gml.AlDriver;

import al132.alchemistry.tiles.TileLiquifier;
import li.cil.oc.api.driver.NamedBlock;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverSidedTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class DriverLiquifier extends DriverSidedTileEntity {

    @Override
    public Class<?> getTileEntityClass() {
        return TileLiquifier.class;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, BlockPos pos, EnumFacing side) {
        return new Environment((TileLiquifier) world.getTileEntity(pos));
    }

    public static final class Environment extends ManEnv<TileLiquifier> implements NamedBlock {
        public Environment(final TileLiquifier tileEntity) {
            super(tileEntity, "liquifier");
        }

        @Override
        public String preferredName() {
            return "liquifier";
        }

        @Override
        public int priority() {
            return 1;
        }



        @Callback(doc = "function():boolean -- Return if liquifier can process.")
        public Object[] canProcess(final Context context, final Arguments args){
            return new Object[] {tileEntity.canProcess()};
        }

        @Callback(doc = "function():table -- Get some information about this tank.")
        public Object[] getOutputTankInfo(final Context context, final Arguments args) {
            return new Object[]{tileEntity.getOutputTank().getInfo()};
        }

        @Callback(doc = "function():number -- Returns the amount of stored energy.")
        public Object[] getEnergyStored(final Context context, final Arguments args){
            return new Object[] {tileEntity.getEnergyStorage().getEnergyStored()};
        }

        @Callback(doc = "function():number -- Returns the maximum amount of stored energy.")
        public Object[] getMaxEnergyStored(final Context context, final Arguments args){
            return new Object[] {tileEntity.getEnergyStorage().getMaxEnergyStored()};
        }

    }
}