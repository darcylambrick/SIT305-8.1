package com.example.llamaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText usernameInput;
    Button startChatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameInput = findViewById(R.id.usernameInput);
        startChatButton = findViewById(R.id.startChatButton);

        startChatButton.setOnClickListener(v -> {
            String username = usernameInput.getText().toString();
            if (!username.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}
