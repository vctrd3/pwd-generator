package net.example.victor.calculate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGenerate = (Button)findViewById(R.id.btnGenerate);
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtInput1 = (EditText)findViewById(R.id.txtInput1);
                TextView txtResult = (TextView)findViewById(R.id.txtResult);

                int num1 = Integer.parseInt(txtInput1.getText().toString());
                char [] password = generatePassword(num1);
                String result="";
                for(char c : password){
                    result+=c;
                }
                txtResult.setText(result+"");

            }

            public char [] generatePassword(int length){
                String chars = "abcdefghijklmnopqrstuvwxyz";
                String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String numbers = "0123456789";
                String specialChars = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
                Random random = new Random();

                String initialValue = capitalChars+chars+numbers+specialChars;

                char[] password = new char[length];
                for(int x = 0; x< length; x++){

                    password[x]= initialValue.charAt(random.nextInt(initialValue.length()));
                }
                return password;
            }

        });
    }
}
