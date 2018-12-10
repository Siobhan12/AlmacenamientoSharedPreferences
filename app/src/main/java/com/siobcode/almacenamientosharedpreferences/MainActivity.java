package com.siobcode.almacenamientosharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

    public class MainActivity extends Activity {
        private EditText et1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            et1=(EditText)findViewById(R.id.edtemail);

            SharedPreferences prefe=getSharedPreferences("datos",Context.MODE_PRIVATE);
            et1.setText(prefe.getString("mail",""));
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.activity_main, menu);
            return true;
        }

        public void ejecutar(View v) {
            SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
            Editor editor=preferencias.edit();
            editor.putString("mail", et1.getText().toString());
            editor.commit();
            finish();
        }
    }

