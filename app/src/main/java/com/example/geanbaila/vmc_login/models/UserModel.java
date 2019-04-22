package com.example.geanbaila.vmc_login.models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class UserModel extends Model {

    public UserModel(){
        super();
    }

    public Map authenticate(String user, String password){
        Map<String, Integer> result = new HashMap<>();

        try {
            Statement statement = getConnection().createStatement();
            String sql = "select id from dbo.usuario where username ='" + user
                    + "' and password='" + password + "' and 1=1";
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet==null){
                result.put("usuario_id",0);

            }else{
                while(resultSet.next()){
                    result.put("usuario_id",resultSet.getInt("id"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}