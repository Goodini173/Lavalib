package com.lavamen.lavalib.config;

import com.lavamen.lavalib.messages.*;
import org.bukkit.configuration.ConfigurationSection;

import javax.annotation.Nonnull;

/**
 * This class helps with loading messages from config.
 * See example config
 */
public class MessageLoader {

    public ConfigLoadResult<Message> load(@Nonnull ConfigurationSection messageConfig) {
        try {
            MessageType messageType = MessageType.valueOf(messageConfig.getString("type"));
            Message result;
            // TODO: сделать в енуме метод load чтобы он сам сообщения загружал
            // вообще енум убрать и сделать мапу статическую по строке
            switch (messageType) {
                case ACTION_BAR:
                    result = new ActionbarMessage(messageConfig.getString("message"));
                    break;
                case MESSAGE:
                    result = new TextMessage(messageConfig.getString("message"));
                    break;
                case TITLE:
                    result = new TitleMessage(messageConfig.getString("title"),
                            messageConfig.getString("subtitle"),
                            messageConfig.getInt("fade-in"),
                            messageConfig.getInt("stay"),
                            messageConfig.getInt("fade-out"));
                    break;
                default:
                    return new ConfigLoadResult<>(null, null,
                            "Could not load message: " + messageConfig.getName());
            }
            return new ConfigLoadResult<>(result, null, null);
        } catch (Exception e) {
            return new ConfigLoadResult<>(null,
                    e,
                    "Could not load message: " + messageConfig.getName());
        }
    }
}
