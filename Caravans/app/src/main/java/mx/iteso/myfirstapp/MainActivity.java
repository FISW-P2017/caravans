package mx.iteso.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView tvHelloWorld2;
    TextView tvHelloWorld;
    EditText editName;
    int name;
    String FILENAME = "hegllo_fiae.txt";
    String string = "-1";
    FileOutputStream fos;
    FileInputStream fis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
           // fos = openFileOutput(FILENAME, Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
            //fos.write(0);
            fis = openFileInput(FILENAME);
            name = fis.read();
        } catch (Exception e){}




        if(name == 0) setContentView(R.layout.activity_main);
        else setContentView(R.layout.content_movie_detail);

        //Crear referencia al texto
        tvHelloWorld = (TextView) findViewById(R.id.tvHelloWorld);
        tvHelloWorld2 = (TextView) findViewById(R.id.tvHelloWorld2);
    }

    public void ShowDetail(View view) {
        Intent i = new Intent(this, MovieDetailActivity.class);
        startActivity(i);
        //estoyEnCaravana = true;
        try{
            fos = openFileOutput(FILENAME, Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
            fos.write(1);
            fos.close();
        } catch (Exception e){}


    }

}





