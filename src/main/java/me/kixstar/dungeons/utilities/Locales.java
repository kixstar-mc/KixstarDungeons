package me.kixstar.dungeons.utilities;

import com.boydti.fawe.configuration.InvalidConfigurationException;
import com.boydti.fawe.configuration.file.YamlConfiguration;
import me.kixstar.dungeons.KixstarDungeons;
import me.kixstar.dungeons.dungeons.KixstarDungeon;

import java.io.File;
import java.io.IOException;

public class Locales {
    private YamlConfiguration configuration = new YamlConfiguration();
    private final String[] defaultLocales = new String[]{
            "english"
    };

    public void initialize() {
        for (String defaultLocale : defaultLocales) {
            KixstarDungeons.getInstance().saveResource(String.format("languages/%s.yml", defaultLocale), false);
        }
    }

    public void selectLanguage(String language) throws InvalidConfigurationException, IOException {
        this.configuration.load(new File(this.getLanguageFolder(), String.format("%s.yml", language)));
    }

    public static String getString(String key) {
        return KixstarDungeons.getInstance().getLocales().getConfiguration().getString(key);
    }

    public String getSelectedLanguage() {
        return KixstarDungeons.getInstance().getConfig().getString("language", "english");
    }

    public synchronized File getLanguageFolder() {
        assert KixstarDungeons.getInstance() != null;
        return new File(KixstarDungeons.getInstance().getDataFolder(), "languages");
    }

    public YamlConfiguration getConfiguration() {
        return this.configuration;
    }
}
