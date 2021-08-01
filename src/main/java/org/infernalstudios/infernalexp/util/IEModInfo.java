package org.infernalstudios.infernalexp.util;

public class IEModInfo {

    public static boolean isLoaded(String modID) {
        return net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded(modID);
    }
}
