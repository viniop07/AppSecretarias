package com.example.appsecretarias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Lugar> lista;
    ArrayAdapter<Lugar> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);

        lista = new ArrayList<>();
        lista.add(new Lugar("Secretaria do meio ambiente e planejamento (SMMAP)","Rua Professor Eugênio Teani", -23.447150,-46.921710));
        lista.add(new Lugar("Secretaria da educação"," R. Prof. Edgar de Moraes", -23.443070,-46.922340));
        lista.add(new Lugar("Secretaria da mulher"," R. Fernão Dias Falcão", -23.446800,-46.917400));
        lista.add(new Lugar("Secretaria de administração (SMA) ","R. Fernão Dias Falcão", -23.444168,-46.918616));
        lista.add(new Lugar("Secretaria de esporte e lazer (SMAFEL) "," R. Suzana Dias", -23.444168,-46.918616));
        lista.add(new Lugar("Casa civil/gabinete "," R. Pedro Procópio", -23.446335,-46.918234));



        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Locais.class);
                intent.putExtra("latitude",lista.get(i).latitude);
                intent.putExtra("longitude",lista.get(i).longitude);
                intent.putExtra("titulo",lista.get(i).titulo);
                startActivity(intent);

            }
        });


    }
}