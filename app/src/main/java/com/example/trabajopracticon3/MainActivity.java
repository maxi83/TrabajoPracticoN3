package com.example.trabajopracticon3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText dolarEt;
    private EditText euroEt;
    private EditText convertirEt;
    private RadioButton dolarEuroRbutton;
    private RadioButton euroDolarRbutton;
    private Button convertir;
    private MainActivityViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        inicializarVista();

        vm.getActivoActEditexDolar().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                dolarEt.setEnabled(aBoolean);
                dolarEt.requestFocus();
            }
        });
        vm.getActivoActEditexEuro().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                euroEt.setEnabled(aBoolean);
                euroEt.requestFocus();
            }
        });
        vm.getResulMutable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                convertirEt.setText(s);
            }
        });

    }


    public void convertir(View v) {
        vm.convertir(dolarEuroRbutton.isChecked(), dolarEt.getText().toString(), euroEt.getText().toString());
    }
    private void inicializarVista() {
        dolarEt = findViewById(R.id.dolarEt);
        euroEt = findViewById(R.id.euroEt);
        convertirEt = findViewById(R.id.convertirEt);
        dolarEuroRbutton = findViewById(R.id.dolarEuroRbutton);
        euroDolarRbutton = findViewById(R.id.euroDolarRbutton);
        convertir = findViewById(R.id.convertir);

        dolarEt.requestFocus();

    }
}