package net.terurion.api.spacedata;

import java.sql.Connection;

/*
    Information! This api is only for SQL Insert getter.
    And for those devs who wan't to use Getter and Setter in Data. You can use SpaceAPI to use.
    And keep in mind that SpaceAPI only supports for Spigot 1.17+. Under version of this
    Api are not compatible and not recommended.
 */
public final class SpaceData {
    private static Connection globalConnection;

    public static Connection getGlobalConnection() {
        return globalConnection;
    }

    public static void setGlobalConnection(Connection globalConnection) {
        SpaceData.globalConnection = globalConnection;
    }
}
