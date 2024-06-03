package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editText;
    private TextView binaryText;
    private TextView octalText;
    private TextView hexaText;
    private MaterialButton convertButton;
    private MaterialButton resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        binaryText = findViewById(R.id.binary);
        octalText = findViewById(R.id.octal);
        hexaText = findViewById(R.id.hexa);
        convertButton = findViewById(R.id.convert);
        resetButton = findViewById(R.id.reset);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertNumber();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
    }

    private void convertNumber() {
        String decimalStr = editText.getText().toString();
        if (!decimalStr.isEmpty()) {
            try {
                int decimalNumber = Integer.parseInt(decimalStr);
                binaryText.setText(DecimalConverter.toBinary(decimalNumber));
                octalText.setText(DecimalConverter.toOctal(decimalNumber));
                hexaText.setText(DecimalConverter.toHexadecimal(decimalNumber));
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter a valid decimal number", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter a decimal number", Toast.LENGTH_SHORT).show();
        }
    }

    private void resetFields() {
        editText.setText("");
        binaryText.setText("");
        octalText.setText("");
        hexaText.setText("");
    }
}
