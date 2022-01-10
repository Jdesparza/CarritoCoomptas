package com.example.carritocoomptas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

public class ListProducts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);

        setTitle("LISTADO DE PRODUCTOS");
    }


    public void addItemToCart(View view) {
        EventBus.getDefault().post(new CartEvent("nuevo artículo"));
    }

    public void openHome(View view) {
        onBackPressed();
    }
}