package com.ashdev.tictactoegame;

import android.annotation.SuppressLint;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7 , btn8 , btn9 , NewGame , History;
    private TextView LastWinner , Player1 , Player2;
    private String b1,b2,b3,b4,b5,b6,b7,b8,b9, history ;
    private ArrayList<String> arrhistory = new ArrayList<>();
    int flag=0;
    int count=0 , historycount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        restart("");

    }

    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        Player1 = findViewById(R.id.Player1);
        Player2 = findViewById(R.id.Player2);
        NewGame = findViewById(R.id.btnNewGame);
        LastWinner = findViewById(R.id.txtLastWinner);
        History = findViewById(R.id.btnHistory);
    }

    @SuppressLint("ResourceAsColor")
    public void Check(View view) {
        ++count;
        Button btncurrent = (Button) view;
        if (!btncurrent.getText().toString().equals("")) {
            return;
        }

        if (flag == 0) {
            // Player1 Turn
            // Changing opponent color
            Player2.setBackgroundColor(getResources().getColor(R.color.orange));
            Player2.setTextColor(this.getResources().getColor(R.color.splash));
            btncurrent.setText("O");
            btncurrent.setBackgroundColor(getResources().getColor(R.color.blue));
            // highlighting players turn
            Player1.setBackgroundColor(getResources().getColor(R.color.splash));
            Player1.setTextColor(this.getResources().getColor(R.color.orange));
            flag = 1;
        } else {
            // Player2 Turn
            // Changing opponent color
            Player1.setBackgroundColor(getResources().getColor(R.color.orange));
            Player1.setTextColor(this.getResources().getColor(R.color.splash));
            btncurrent.setText("X");
            btncurrent.setBackgroundColor(getResources().getColor(R.color.red));
            // highlighting players turn
            Player2.setBackgroundColor(getResources().getColor(R.color.splash));
            Player2.setTextColor(this.getResources().getColor(R.color.orange));
            flag = 0;
        }

        valuegetter();

        // conditions
        if(count>4){
            //Horizontal condition
            if (!b1.equals("") && b1.equals(b2) && b2.equals(b3)) {
                Toast.makeText(this, "Winner: "+b1, Toast.LENGTH_SHORT).show();
                LastWinner.setText("Last Winner was "+b1);
                restart(LastWinner.getText().toString());
            } else if (!b4.equals("") && b4.equals(b5) && b5.equals(b6)) {
                Toast.makeText(this, "Winner: "+b4, Toast.LENGTH_SHORT).show();
                LastWinner.setText("Last Winner was "+b4);
                restart(LastWinner.getText().toString());
            } else if (!b7.equals("") && b7.equals(b8) && b8.equals(b9) ) {
                Toast.makeText(this, "Winner: "+b7, Toast.LENGTH_SHORT).show();
                LastWinner.setText("Last Winner was "+b7);
                restart(LastWinner.getText().toString());
            }
            //Vertical Conditions
            else if (!b1.equals("") && b1.equals(b4) && b4.equals(b7) ) {
                Toast.makeText(this, "Winner: "+b1, Toast.LENGTH_SHORT).show();
                LastWinner.setText("Last Winner was "+b1);
                restart(LastWinner.getText().toString());
            } else if (!b2.equals("") && b2.equals(b5) && b5.equals(b8)) {
                Toast.makeText(this, "Winner: "+b2, Toast.LENGTH_SHORT).show();
                LastWinner.setText("Last Winner was "+b2);
                restart(LastWinner.getText().toString());
            } else if (!b3.equals("") && b3.equals(b6) && b6.equals(b9) ) {
                Toast.makeText(this, "Winner: "+b3, Toast.LENGTH_SHORT).show();
                LastWinner.setText("Last Winner was "+b3);
                restart(LastWinner.getText().toString());
            }
            // Diagonal Conditions
            else if (!b1.equals("") && b1.equals(b5) && b5.equals(b9)){
                Toast.makeText(this, "Winner: "+b1, Toast.LENGTH_SHORT).show();
                LastWinner.setText("Last Winner was "+b1);
                restart(LastWinner.getText().toString());
            }
            else if (!b3.equals("") && b3.equals(b5) && b5.equals(b7)){
                Toast.makeText(this, "Winner: "+b3, Toast.LENGTH_SHORT).show();
                LastWinner.setText("Last Winner was "+b3);
                restart(LastWinner.getText().toString());
            }else if ( count==9){
                Toast.makeText(this, "Game is Drawn", Toast.LENGTH_SHORT).show();
                LastWinner.setText("Last Game was Drawn!");
                restart(LastWinner.getText().toString());
            }
        }
    }
    public void restart(View v){
        restart("");
        Check(v);
    }
    public void history(View view){
        Intent ihistory = new Intent(MainActivity.this,HistoryActivity.class);
        Bundle bdlhistory = new Bundle();
        bdlhistory.putStringArrayList("key",arrhistory);
        ihistory.putExtras(bdlhistory);
        startActivity(ihistory);
    }
    private void restart(String Historydata){
        // History Data
        if (!Historydata.equals("")){
            ++historycount;
            arrhistory.add(historycount+". "+Historydata);
        }
        // Clearing Buttons
        btn1.setText("");
        btn1.setBackgroundColor(getResources().getColor(R.color.white));
        btn2.setText("");
        btn2.setBackgroundColor(getResources().getColor(R.color.white));
        btn3.setText("");
        btn3.setBackgroundColor(getResources().getColor(R.color.white));
        btn4.setText("");
        btn4.setBackgroundColor(getResources().getColor(R.color.white));
        btn5.setText("");
        btn5.setBackgroundColor(getResources().getColor(R.color.white));
        btn6.setText("");
        btn6.setBackgroundColor(getResources().getColor(R.color.white));
        btn7.setText("");
        btn7.setBackgroundColor(getResources().getColor(R.color.white));
        btn8.setText("");
        btn8.setBackgroundColor(getResources().getColor(R.color.white));
        btn9.setText("");
        btn9.setBackgroundColor(getResources().getColor(R.color.white));
        count=0;
        flag=0;
    }
    private void valuegetter(){
        b1 = btn1.getText().toString();
        b2 = btn2.getText().toString();
        b3 = btn3.getText().toString();
        b4 = btn4.getText().toString();
        b5 = btn5.getText().toString();
        b6 = btn6.getText().toString();
        b7 = btn7.getText().toString();
        b8 = btn8.getText().toString();
        b9 = btn9.getText().toString();
    }
}