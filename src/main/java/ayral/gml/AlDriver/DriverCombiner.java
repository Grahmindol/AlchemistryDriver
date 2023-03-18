package ayral.gml.AlDriver;

import al132.alchemistry.recipes.CombinerRecipe;
import al132.alchemistry.recipes.ModRecipes;
import al132.alchemistry.tiles.TileChemicalCombiner ;
import li.cil.oc.api.driver.NamedBlock;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverSidedTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class DriverCombiner extends DriverSidedTileEntity {

    @Override
    public Class<?> getTileEntityClass() {
        return TileChemicalCombiner.class;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, BlockPos pos, EnumFacing side) {
        return new Environment((TileChemicalCombiner) world.getTileEntity(pos));
    }

    public static final class Environment extends ManEnv<TileChemicalCombiner> implements NamedBlock {
        public Environment(final TileChemicalCombiner tileEntity) {
            super(tileEntity, "combiner");
        }

        @Override
        public String preferredName() {
            return "combiner";
        }

        @Override
        public int priority() {
            return 1;
        }



        @Callback(doc = "function():boolean -- Return if combiner can process.")
        public Object[] canProcess(final Context context, final Arguments args){
            return new Object[] {tileEntity.canProcess()};
        }

        @Callback(doc = "function():number -- Returns the amount of stored energy.")
        public Object[] getEnergyStored(final Context context, final Arguments args){
            return new Object[] {tileEntity.getEnergyStorage().getEnergyStored()};
        }

        @Callback(doc = "function():boolean -- Returns if the recipe is locked")
        public Object[] getRecipeIsLocked(final Context context, final Arguments args){
            return new Object[] {tileEntity.getRecipeIsLocked()};
        }

        @Callback(doc = "function(boolean:locked):boolean -- Set and Returns if the recipe is locked")
        public Object[] setRecipeIsLocked(final Context context, final Arguments args){
            tileEntity.setRecipeIsLocked(args.checkBoolean(0));
            return new Object[] {tileEntity.getRecipeIsLocked()};
        }

        @Callback(doc = "function():boolean[,string] -- Returns  the name of recipe's output item ")
        public Object[] getCurrentRecipe(final Context context, final Arguments args){
            return new Object[] {tileEntity.getCurrentRecipe().getOutput().getItem().getUnlocalizedName()};
        }

        @Callback(doc = "function(string:name):boolean -- Returns if recipe stage was modified")
        public Object[] setCurrentRecipe(final Context context, final Arguments args){
             String name = args.checkString(0);
             for(CombinerRecipe r : ModRecipes.INSTANCE.getCombinerRecipes()){
                if(r.getOutput().getItem().getUnlocalizedName().contentEquals(name)){
                    tileEntity.setCurrentRecipe(r);
                    tileEntity.setRecipeIsLocked(true);
                    return new Object[] {true};
                }
             }
            return new Object[] {false};
        }

        @Callback(doc = "function():number -- Returns the maximum amount of stored energy.")
        public Object[] getMaxEnergyStored(final Context context, final Arguments args){
            return new Object[] {tileEntity.getEnergyStorage().getMaxEnergyStored()};
        }
    }
}