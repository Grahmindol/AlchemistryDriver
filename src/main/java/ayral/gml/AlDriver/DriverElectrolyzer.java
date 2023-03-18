package ayral.gml.AlDriver;

import al132.alchemistry.tiles.TileElectrolyzer ;
import li.cil.oc.api.driver.NamedBlock;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverSidedTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class DriverElectrolyzer extends DriverSidedTileEntity {

    @Override
    public Class<?> getTileEntityClass() {
        return TileElectrolyzer.class;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, BlockPos pos, EnumFacing side) {
        return new Environment((TileElectrolyzer) world.getTileEntity(pos));
    }

    public static final class Environment extends ManEnv<TileElectrolyzer> implements NamedBlock {
        public Environment(final TileElectrolyzer tileEntity) {
            super(tileEntity, "electrolyzer");
        }

        @Override
        public String preferredName() {
            return "electrolyzer";
        }

        @Override
        public int priority() {
            return 1;
        }



        @Callback(doc = "function():boolean -- Return if atomizer can process.")
        public Object[] canProcess(final Context context, final Arguments args){
            return new Object[] {tileEntity.canProcess()};
        }

        @Callback(doc = "function():table -- Get some information about this tank.")
        public Object[] getInputTankInfo(final Context context, final Arguments args) {
            return new Object[]{tileEntity.getInputTank().getInfo()};
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