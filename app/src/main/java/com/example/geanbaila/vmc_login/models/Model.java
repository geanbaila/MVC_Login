package com.example.geanbaila.vmc_login.models;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class Model {
    private Connection connection = null;

    public Model() {
        //String URL = "jdbc:sqlserver://192.168.0.21:1433;databaseName=agenda";
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            if (connection == null) {
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.36:1433;databaseName=agenda", "sa", "1234");
                Log.i("<><><><><><><><>", "una nueva conexión ha sido abierta");
            }
        }catch (Exception e) {
            if (connection == null) {
                Log.i("<><><><><><><><>", "imposible conectar a la base de datos");
            }
            System.out.println("Ha ocurrido un error indesperado \n" + e.getCause()+"\n\n\n\n");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(){
        connection = null;
    }

}