package com.example.tpc01_ex01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText number;
    Button btn_parite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number);
        btn_parite = findViewById(R.id.btn_parite);

        btn_parite.setOnClickListener(view -> {
            try {
                String msg;
                int nbr = Integer.parseInt(number.getText().toString());
                if (nbr % 2 == 0) {
                    msg = "pair";
                } else {
                    msg = "impair";
                }
                showAlert(nbr, msg, true);
            } catch (Exception e) {
                showAlert(0, "Il faut saisir un entier !!!", false);
            }
        });
    }

    public void showAlert(int nbr, String msg, boolean test) {
        if (test) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Parité").setMessage(String.format("%d est %s ", nbr, msg)).setIcon(android.R.drawable.ic_dialog_info).show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Parité").setMessage(msg).setIcon(android.R.drawable.ic_dialog_alert).show();
        }
    }

}