package org.infernalstudios.infernalexp.util;

public class IEWorldSeedHolder {

    private static long SEED = 0;

    public static long getSeed() {
        return SEED;
    }

    public static void setSeed(long seed) {
        SEED = seed;
    }
}
