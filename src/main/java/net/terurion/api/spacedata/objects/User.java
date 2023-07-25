package net.terurion.api.spacedata.objects;

import net.terurion.api.spacedata.SpaceData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class User {
    private UUID uuid;

    private String nickname;

    private String colorPrefix;

    public User(UUID uuid) {
        if (uuid == null) {
            this.uuid = uuid;
        }

        loader();

        if (!next()) {
            this.uuid = null;
        }
    }

    private void loader() {
        Connection connection = SpaceData.getGlobalConnection();
        String sql = "";

        if (connection == null) return;

        try {
            sql = "select * from users where uuid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, uuid.toString());

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                this.nickname = resultSet.getString("nick");

                switch (resultSet.getString("rank")) {
                    case "DEFAULT":
                        this.colorPrefix = "&7";
                        break;
                    case "CAT":
                        break;
                    case "DOG":
                        break;
                    case "ALLIGATOR":
                        break;
                    case "LION":
                        break;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean next() {
        Connection connection = SpaceData.getGlobalConnection();
        String sql = "";

        if (connection == null) return false;

        try {
            sql = "select * from users where uuid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, uuid.toString());

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return true;
            } return false;
        }catch (SQLException e) {
            e.printStackTrace();
        } return false;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getNickname() {
        return nickname;
    }

    public String getColorPrefix() {
        return colorPrefix;
    }
}
