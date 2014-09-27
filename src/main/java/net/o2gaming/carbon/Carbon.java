package net.o2gaming.carbon;

import net.o2gaming.carbon.listeners.BlockListener;
import net.o2gaming.carbon.reflection.Injector;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Carbon extends JavaPlugin {
    private BlockListener blockListener = new BlockListener(this);
    public final static Logger log = Logger.getLogger("minecraft");
    private Injector injector;
    public static Carbon instance;
    
    @Override
    public void onEnable() {
        try {
                DynamicEnumType.loadReflection();
        } catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
        }
        instance = this;
        Bukkit.getServer().getPluginManager().registerEvents(blockListener, this);
        injector = new Injector();
        injector.registerAll();
        injector.registerRecipes();
        log.info("Carbon has finished injecting all 1.8 functionalities.");
    }

    public Injector getInjector() {
        return injector;
    }

    public BlockListener getBlockListener() {
        return blockListener;
    }
    
}