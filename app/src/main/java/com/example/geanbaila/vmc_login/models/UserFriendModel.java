package com.example.geanbaila.vmc_login.models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserFriendModel extends Model {
    public UserFriendModel(){
        super();
    }

    public List<String> getFriend(int usuarioId){
        List<String> friends = new ArrayList<String>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "select id,nombres,apellidos from dbo.usuario_amigo where usuario_id = "+usuarioId+ " and 1=1";
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet!=null){
                while(resultSet.next()){
                    friends.add(resultSet.getString("nombres") +" "+resultSet.getString("apellidos"));
                }
            }
        } catch (Exception e) {
            System.out.print(e.getCause());
        }
        return friends;
    }
}