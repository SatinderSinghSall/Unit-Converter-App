package com.example.unitconvertor;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText userInput = findViewById(R.id.userInput);
        Button submitButton = findViewById(R.id.submitButton);
        TextView resultTextView = findViewById(R.id.resultTextView);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNumber = userInput.getText().toString().trim();

                if(TextUtils.isEmpty(userNumber)) {
                    userInput.setError("Please enter a value!");
                    Toast.makeText(MainActivity.this, "Input field can not be empty.", Toast.LENGTH_LONG).show();
                    return;
                }

                double inputValue = Double.parseDouble(userNumber);
                double result = inputValue * 2.205;
                resultTextView.setText(String.format("%.2f lbs", result));
                Toast.makeText(MainActivity.this, "Calculation Complete!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
