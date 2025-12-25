package ru.mirea.kabanov.control_lesson1;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Находим PlainText и меняем текст
        EditText plainText = findViewById(R.id.plainText);
        plainText.setText("New life for mirea activity!");

        // Находим кнопки (пример для первой кнопки)
        Button button1 = findViewById(R.id.button1);
        // Можно добавить обработчики кликов при необходимости
    }
}