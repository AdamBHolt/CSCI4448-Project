package com.escape.escape;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        savedGameCheck();
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void savedGameCheck() {
        Button btn = (Button) findViewById(R.id.button);
        try{ //see if we can find the saved file
            FileInputStream fis = this.openFileInput("saved_state.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            String state = bufferedReader.readLine();
            if (state == null){
                btn.setEnabled(false);
            }
            else{
                btn.setEnabled(true);
            }
        }
        catch (FileNotFoundException e) {btn.setEnabled(false);}
        catch (IOException e) {btn.setEnabled(false);}
    }

    public void loadIntro(View view) {
        Intent intent = new Intent(MainActivity.this, IntroScreen.class);
        startActivity(intent);
    }

    public void loadGame(View view) {

    }
}
