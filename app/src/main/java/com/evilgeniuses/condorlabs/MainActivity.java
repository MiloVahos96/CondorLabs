package com.evilgeniuses.condorlabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    // Componentes de la vista
    private Toolbar TMain;
    private RecyclerView    RVMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaración de componentes de la vista
        TMain   =   findViewById(R.id.TMain);
        RVMain  =   findViewById(R.id.RVMain);




    }
}
