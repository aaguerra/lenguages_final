package com.yachai.reto.prueba1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Intro extends Activity {

    EditText usuario;
    EditText clave;
    EditText email;
    Button intro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        intro=(Button) findViewById(R.id.introButton);
        usuario=(EditText)findViewById(R.id.intro_name);
        clave=(EditText)findViewById(R.id.intro_pass);
        email=(EditText)findViewById(R.id.intro_email);

        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast;
                if (isEmpty(usuario) || isEmpty(clave) || isEmpty(email))
                {
                    CharSequence text = "No ingreso todos datos";
                    toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else if (!isEmail(email))
                {
                    CharSequence text = "No es email";
                    toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else
                {
                    Intent intent=new Intent(Intro.this,Main2Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        });


    }
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    private boolean isEmail(EditText etText) {
        String srt=etText.getText().toString();
        for (char legra:srt.toCharArray()) {
            if(legra=='@')
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}

