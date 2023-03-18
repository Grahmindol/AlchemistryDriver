package ayral.gml.AlDriver;

import al132.alchemistry.tiles.TileFissionController ;
import li.cil.oc.api.driver.NamedBlock;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverSidedTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class DriverFissionController extends DriverSidedTileEntity {

    @Override
    public Class<?> getTileEntityClass() {
        return TileFissionController.class;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, BlockPos pos, EnumFacing side) {
        return new Environment((TileFissionController) world.getTileEntity(pos));
    }

    public static final class Environment extends ManEnv<TileFissionController> implements NamedBlock {
        public Environment(final TileFissionController tileEntity) {
            super(tileEntity, "fission_controller");
        }

        @Override
        public String preferredName() {
            return "fission_controller";
        }

        @Override
        public int priority() {
            return 1;
        }



        @Callback(doc = "function():boolean -- Return if fission controller can process.")
        public Object[] canProcess(final Context context, final Arguments args){
            return new Object[] {tileEntity.canProcess()};
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