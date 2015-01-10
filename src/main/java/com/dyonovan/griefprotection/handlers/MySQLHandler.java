package com.dyonovan.griefprotection.handlers;

import com.dyonovan.griefprotection.lib.MySql;
import cpw.mods.fml.common.FMLLog;

public class MySQLHandler {

    private static boolean mysql_loaded = false;

    public static synchronized boolean isMySQLLoaded(){
        return mysql_loaded;
    }

    public static void connectDB() {
        FMLLog.info("GP - Checking DB");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Throwable t) {
            FMLLog.severe("GP - No JDBC driver found!");
            return;
        }

        MySql handler = new MySql();
        if(!handler.connectDB()) {
            FMLLog.severe("GP - Could not connect to DB");
            return;
        } else {
            handler.cleanUp();
        }

        mysql_loaded = true;
    }
}
