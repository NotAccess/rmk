package ru.mirea.kabanov.control_lesson1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private CheckBox checkBoxNotifications;
    private CheckBox checkBoxDarkTheme;
    private Button buttonSave;
    private ImageButton imageButtonShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        checkBoxNotifications = findViewById(R.id.checkBoxNotifications);
        checkBoxDarkTheme = findViewById(R.id.checkBoxDarkTheme);
        buttonSave = findViewById(R.id.buttonSave);
        imageButtonShare = findViewById(R.id.imageButtonShare);

        // Заполнение начальными данными (для примера)
        editTextName.setText("Даниил Кабанов");
        editTextEmail.setText("kabanov.d.a@edu.mirea.ru");
        checkBoxNotifications.setChecked(true);

        // Обработчик кнопки сохранения
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                boolean notifications = checkBoxNotifications.isChecked();
                boolean darkTheme = checkBoxDarkTheme.isChecked();

                // Проверка заполнения полей
                if (name.isEmpty() || email.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Заполните все поля!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // В реальном приложении здесь был бы код сохранения данных
                String message = "Данные сохранены!\n" +
                        "Имя: " + name + "\n" +
                        "Email: " + email + "\n" +
                        "Уведомления: " + (notifications ? "Вкл" : "Выкл") + "\n" +
                        "Тёмная тема: " + (darkTheme ? "Вкл" : "Выкл");

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

        // Обработчик кнопки "Поделиться"
        imageButtonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Поделиться профилем",
                        Toast.LENGTH_SHORT).show();
                // Здесь мог бы быть код для открытия диалога "поделиться"
            }
        });

        // Обработчик изменения темы
        checkBoxDarkTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String theme = isChecked ? "Тёмная тема включена" : "Тёмная тема выключена";
            Toast.makeText(MainActivity.this, theme, Toast.LENGTH_SHORT).show();
        });
    }
}