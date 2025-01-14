package de.chojo.repbot.util;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;
import java.util.stream.Collectors;

public final class FilterUtil {

    private FilterUtil() {
        throw new UnsupportedOperationException("This is a utility class.");
    }

    /**
     * Get all channel where the bot user can write and read.
     *
     * @param guild guild
     * @return list of accessable text channel
     */
    public static List<TextChannel> getAccessableTextChannel(Guild guild) {
        return filterChannelByPermission(guild, Permission.MESSAGE_READ, Permission.MESSAGE_WRITE);
    }

    public static List<TextChannel> filterChannelByPermission(Guild guild, Permission... permissions) {
        var self = guild.getSelfMember();
        return guild.getTextChannels().stream().filter(textChannel -> self.hasPermission(textChannel, permissions)).collect(Collectors.toList());
    }
}
