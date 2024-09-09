package com.example.mydialerapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    private EditText numberDisplay;
    private ImageButton btnDelete;
    private Button btnCall;
    private Button[] numberButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing  the UI elements
        numberDisplay = findViewById(R.id.number_display);
        btnDelete = findViewById(R.id.btn_delete);
        btnCall = findViewById(R.id.btn_call);

        // Initializing the dial buttons
        numberButtons = new Button[12];
        numberButtons[0] = findViewById(R.id.btn_0);
        numberButtons[1] = findViewById(R.id.btn_1);
        numberButtons[2] = findViewById(R.id.btn_2);
        numberButtons[3] = findViewById(R.id.btn_3);
        numberButtons[4] = findViewById(R.id.btn_4);
        numberButtons[5] = findViewById(R.id.btn_5);
        numberButtons[6] = findViewById(R.id.btn_6);
        numberButtons[7] = findViewById(R.id.btn_7);
        numberButtons[8] = findViewById(R.id.btn_8);
        numberButtons[9] = findViewById(R.id.btn_9);
        numberButtons[10] = findViewById(R.id.btn_star);
        numberButtons[11] = findViewById(R.id.btn_hash);

        setNumberButtonListeners();
        setDeleteButtonListener();
        setCallButtonListener();
    }

    private void setNumberButtonListeners() {
        for (Button button : numberButtons) {
            button.setOnClickListener(v -> {
                String currentText = numberDisplay.getText().toString();
                numberDisplay.setText(currentText + ((Button) v).getText().toString());
            });
        }
    }

    private void setDeleteButtonListener() {
        btnDelete.setOnClickListener(v -> {
            String currentText = numberDisplay.getText().toString();
            if (!currentText.isEmpty()) {
                numberDisplay.setText(currentText.substring(0, currentText.length() - 1));
            }
        });
    }

    private void setCallButtonListener() {
        btnCall.setOnClickListener(v -> {
            String phoneNumber = numberDisplay.getText().toString();
            if (!phoneNumber.isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNumber));

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setCallButtonListener();
            }
        }
    }
}
