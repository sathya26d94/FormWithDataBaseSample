package com.example.sathya.formdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        int formDBSize = Util.getDBSize();
        if (formDBSize > 0) {
            FormData formData1 = Util.getFormEntry(0);
            textView.setText("HI " + formData1.name);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, FormDetails.class),1234);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1234 && resultCode == Activity.RESULT_OK) {
            int formDBSize = Util.getDBSize();
            if (formDBSize > 0) {
                FormData formData1 = Util.getFormEntry(0);
                textView.setText("HI " + formData1.name);
            }
        }
    }
}
