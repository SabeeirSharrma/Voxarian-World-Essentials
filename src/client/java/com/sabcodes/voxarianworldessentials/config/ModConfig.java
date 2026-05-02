package com.sabcodes.voxarianworldessentials.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModConfig {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "voxarian-world-essentials.json");

    public static ModConfigData INSTANCE = new ModConfigData();

    public static class ModConfigData {
        public List<String> forcedResourcePacks = new ArrayList<>();
    }

    public static void load() {
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                INSTANCE = GSON.fromJson(reader, ModConfigData.class);
                if (INSTANCE == null) {
                    INSTANCE = new ModConfigData();
                }
            } catch (IOException e) {
                System.err.println("Failed to load Voxarian World Essentials config!");
                e.printStackTrace();
            }
        } else {
            save();
        }
    }

    public static void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(INSTANCE, writer);
        } catch (IOException e) {
            System.err.println("Failed to save Voxarian World Essentials config!");
            e.printStackTrace();
        }
    }
}
