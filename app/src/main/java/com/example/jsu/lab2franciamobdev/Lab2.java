package com.example.jsu.lab2franciamobdev;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.*;
import java.util.Random;

public class Lab2 extends AppCompatActivity {

    private int playerCounter;
    private int cpuCounter;

    private Weapon playerWeapon;
    private Weapon cpuWeapon;

    Random rand = new Random();

    public void rockButtonClicked(View v) {
        playerWeapon = Weapon.ROCK;


        int n = rand.nextInt(3) + 0;

        switch(n){
            case 0: cpuWeapon = Weapon.PAPER;
                break;
            case 1: cpuWeapon = Weapon.ROCK;
                break;
            case 2: cpuWeapon = Weapon.SCISSORS;
                break;
        }
        displayScore();

    }
    public void paperButtonClicked(View v){

        playerWeapon = Weapon.PAPER;


        int n = rand.nextInt(3) + 0;

        switch(n){
            case 0: cpuWeapon = Weapon.PAPER;
                break;
            case 1: cpuWeapon = Weapon.ROCK;
                break;
            case 2: cpuWeapon = Weapon.SCISSORS;
                break;
        }

        displayScore();
    }
    public void scissorsButtonClicked(View v){
        playerWeapon = Weapon.SCISSORS;


        int n = rand.nextInt(3) + 0;

        switch(n){
            case 0: cpuWeapon = Weapon.PAPER;
                break;
            case 1: cpuWeapon = Weapon.ROCK;
                break;
            case 2: cpuWeapon = Weapon.SCISSORS;
                break;
        }

        displayScore();

    }


    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors"),
        STARTING("START");

        private String message;

        private Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

    };

    private void displayScore(){

        TextView player = (TextView) findViewById(R.id.playerWeaponView);
        TextView cpu = (TextView) findViewById(R.id.cpuWeaponView);
        TextView result = (TextView) findViewById(R.id.resultView);

        if (playerWeapon == Weapon.ROCK && cpuWeapon == Weapon.SCISSORS){
            playerCounter++;
            player.setText("Player's Weapon: " + playerWeapon.toString());
            cpu.setText("Computer's Weapon: " + cpuWeapon.toString());
            result.setText("Player wins ... Rock blunts scissors!");

        }
        else if (playerWeapon == Weapon.PAPER && cpuWeapon == Weapon.ROCK) {
            playerCounter++;
            player.setText("Player's Weapon: " + playerWeapon.toString());
            cpu.setText("Computer's Weapon: " + cpuWeapon.toString());
            result.setText("Player wins ... Paper covers rock!");
        }
        else if (playerWeapon == Weapon.SCISSORS && cpuWeapon == Weapon.PAPER){
            playerCounter++;
            player.setText("Player's Weapon: " + playerWeapon.toString());
            cpu.setText("Computer's Weapon: " + cpuWeapon.toString());
            result.setText("Player wins ... Scissors cuts paper!");
        }
        else if (cpuWeapon == Weapon.ROCK && playerWeapon == Weapon.SCISSORS){
            cpuCounter++;
            player.setText("Player's Weapon: " + playerWeapon.toString());
            cpu.setText("Computer's Weapon: " + cpuWeapon.toString());
            result.setText("Computer wins ... Rock blunts scissors!");
        }
        else if (cpuWeapon == Weapon.PAPER && playerWeapon == Weapon.ROCK) {
            cpuCounter++;
            player.setText("Player's Weapon: " + playerWeapon.toString());
            cpu.setText("Computer's Weapon: " + cpuWeapon.toString());
            result.setText("Computer wins ... Paper covers rock!");
        }
        else if (cpuWeapon == Weapon.SCISSORS && playerWeapon == Weapon.PAPER){
            cpuCounter++;
            player.setText("Player's Weapon: " + playerWeapon.toString());
            cpu.setText("Computer's Weapon: " + cpuWeapon.toString());
            result.setText("Computer wins ... Scissors cuts paper!");
        }

        if(cpuWeapon == playerWeapon){
            player.setText("Player's Weapon: " + playerWeapon.toString());
            cpu.setText("Computer's Weapon: " + cpuWeapon.toString());
            result.setText("DRAW!");
        }

        if(cpuWeapon == Weapon.STARTING && playerWeapon == Weapon.STARTING){
            player.setText("Player Ready!");
            cpu.setText("Computer Ready!");
            result.setText("BEGIN!");
        }
        TextView o = (TextView) findViewById(R.id.score);
        o.setText("Player: " + Integer.toString(playerCounter) + ", Computer: " + Integer.toString(cpuCounter));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        playerCounter = 0;
        cpuCounter = 0;
        playerWeapon = Weapon.STARTING;
        cpuWeapon = Weapon.STARTING;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        playerCounter = 0;
        cpuCounter = 0;
        displayScore();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lab2, menu);
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
}
