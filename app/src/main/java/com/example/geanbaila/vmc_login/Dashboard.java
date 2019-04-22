package com.example.geanbaila.vmc_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.geanbaila.vmc_login.models.UserFriendModel;

import java.util.List;

public class Dashboard extends AppCompatActivity {
    TextView tvUserName;
    ListView lvFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Bundle bundle = getIntent().getExtras();
        int usuarioId = Integer.parseInt(bundle.getString("USUARIOID"));
        UserFriendModel userFriend = new UserFriendModel();
        tvUserName = (TextView) findViewById(R.id.tv_username);
        tvUserName.setText("Mis amigos");
        List<String> friend = userFriend.getFriend(usuarioId);
        System.out.println("<><><><><><><><>\n\n\n");
        System.out.println(friend);
        System.out.println("<><><><><><><><>\n\n\n");
        ArrayAdapter<String> adapterFriend = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,friend);
        lvFriend = (ListView) findViewById(R.id.lv_friend);
        lvFriend.setAdapter(adapterFriend);
    }
}