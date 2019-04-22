package com.example.geanbaila.vmc_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.geanbaila.vmc_login.models.UserModel;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText edUsuario, edClave;
    Button btnIngresar;
    UserModel user = new UserModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsuario = (EditText) findViewById(R.id.ed_usuario);
        edClave = (EditText) findViewById(R.id.ed_clave);
    }

    public void ingresar(View view){
        //UserModel user = new UserModel();
        String password = edClave.getText().toString();
        String username = edUsuario.getText().toString();
        Map<String,Integer> result = user.authenticate(username, password);
        for(Map.Entry<String,Integer> data: result.entrySet()){
            System.out.println("los valores son: " + data.getKey() +" "+ data.getValue());
            if(data.getKey() == "usuario_id"){
                 if(data.getValue() > 0){
                     Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                     intent.putExtra("USUARIOID", data.getValue().toString());
                     startActivity(intent);
                 }else{
                     Toast.makeText(this, "Usuario/Clave incorrectos",Toast.LENGTH_SHORT).show();
                     break;
                 }
            }
        }
    }
}