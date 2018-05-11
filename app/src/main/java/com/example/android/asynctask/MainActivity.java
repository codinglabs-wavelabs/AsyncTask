package com.example.android.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button async;
    EditText editText;
    String string;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        async = findViewById(R.id.asynctask);
        editText = findViewById(R.id.url);
        webView = findViewById(R.id.output);
        async.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = editText.getText().toString();
                new Asynctask().execute(string);
            }
        });
    }

    private class Asynctask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            webView.loadUrl(s);
        }
    }
}