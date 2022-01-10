package com.example.carritocoomptas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<CartEvent> cartEventList = new ArrayList<>();
    TextView cartContView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cartContView = findViewById(R.id.cartCont);

        setTitle("CARRITO DE COMPRAS");
    }

    @Subscribe
    public void onCartItemAdd(CartEvent cartEvent){
        cartEventList.add(cartEvent);
        String cartTotalItems = String.valueOf(cartEventList.size());
        cartContView.setText(cartTotalItems);
        Toast.makeText(this, "Producto agregado al carrito", Toast.LENGTH_SHORT).show();
    }

    public void open(View view) {
        Intent intent = new Intent(this, ListProducts.class);

        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}