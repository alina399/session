package com.example.carsharing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;


public class DialogActivity extends AppCompatActivity {

        String dlg = "";

        public DialogActivity(String text) {
            dlg = text;
        }

        public AlertDialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
            builder.setTitle("")
                    .setMessage(dlg)
                    .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Закрываем окно
                            dialog.cancel();
                        }
                    });
            return builder.create();
        }
    }


    