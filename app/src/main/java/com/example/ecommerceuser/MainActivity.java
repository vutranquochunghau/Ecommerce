package com.example.ecommerceuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

import com.example.ecommerceuser.Adapter.MenuAdapter;
import com.example.ecommerceuser.model.ItemMenu;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ListView lv_Navi;
    Button camera;
    ArrayList<ItemMenu> arrayListMenu;
    MenuAdapter adapterMenu;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ActionToolBar();
        ActionMenu();
        ButtonAction();
    }

    private void ButtonAction() {
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                   Intent intent = new Intent();
                   intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                   startActivity(intent);
               }   catch (Exception e)
               {
                   e.printStackTrace();
               }
            }
        });
    }


    private void ActionMenu() {
        arrayListMenu = new ArrayList<>();
        arrayListMenu.add(new ItemMenu("Trang Chu", R.drawable.ic_action_home));
        arrayListMenu.add(new ItemMenu("Danh Muc", R.drawable.ic_action_category));
        arrayListMenu.add(new ItemMenu("Tim Kiem", R.drawable.ic_action_search));
        arrayListMenu.add(new ItemMenu("Thong Bao", R.drawable.ic_action_alarm));
        arrayListMenu.add(new ItemMenu("Trang Ca Nhan", R.drawable.ic_action_user));
        adapterMenu = new MenuAdapter(this, R.layout.model_menu, arrayListMenu);
        lv_Navi.setAdapter(adapterMenu);
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_menu);
        //tao su kien click
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void AnhXa() {
        toolbar = findViewById(R.id.toolBarNavi);
        drawerLayout = findViewById(R.id.drawerNavi);
        navigationView = findViewById(R.id.navigationView);
        lv_Navi = findViewById(R.id.lv_Navi);
        camera = findViewById(R.id.button);
    }
}