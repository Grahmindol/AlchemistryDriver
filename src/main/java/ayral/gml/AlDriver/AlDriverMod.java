package ayral.gml.AlDriver;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import li.cil.oc.api.Driver;

@Mod(modid = AlDriverMod.MODID, version = AlDriverMod.VERSION)
public class AlDriverMod {
    public static final String MODID = "aldriver";
    public static final String VERSION = "1.0";

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Driver.add(new DriverAtomizer());
        Driver.add(new DriverLiquifier());
        Driver.add(new DriverCombiner());
        Driver.add(new DriverDissolver());
        Driver.add(new DriverElectrolyzer());
        Driver.add(new DriverEvaporator());
        Driver.add(new DriverFissionController());
        Driver.add(new DriverFusionController());
    }
}
