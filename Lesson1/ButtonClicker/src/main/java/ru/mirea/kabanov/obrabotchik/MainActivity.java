package ru.mirea.kabanov.obrabotchik;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    private Button btnWhoAmI;
    private Button btnItIsNotMe;
    private TextView tvOut;
    private CheckBox cbMyCheckBox;
    private String currentText = ""; // Переменная для хранения текущего текста

    public void onItIsNotMeClick(View v)
    {
        tvOut.setText("Это не я сделал");
        Toast.makeText(this, "Ещё один способ!", Toast.LENGTH_SHORT).show();
        cbMyCheckBox.setChecked(false);
        currentText = "Это не я сделал";
        updateTextWithCheckboxEffect(); // Обновляем текст с учетом состояния CheckBox
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnWhoAmI = findViewById(R.id.btnWhoAmI);
        btnItIsNotMe = findViewById(R.id.btnItIsNotMe);
        tvOut = (TextView) findViewById(R.id.tvOut);
        cbMyCheckBox = findViewById(R.id.cbMyCheckBox);

        // Добавляем слушатель для CheckBox
        cbMyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTextWithCheckboxEffect(); // Обновляем текст при изменении состояния CheckBox
            }
        });

        btnWhoAmI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentText = "Мой номер по списку № 11 (по журналу)";
                cbMyCheckBox.setChecked(true);
                updateTextWithCheckboxEffect(); // Обновляем текст с учетом состояния CheckBox
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Метод для обновления текста с учетом состояния CheckBox
    private void updateTextWithCheckboxEffect() {
        if (cbMyCheckBox.isChecked() && !currentText.isEmpty()) {
            // Слегка меняем текст при отмеченном CheckBox
            String modifiedText = currentText;

            // Добавляем небольшие изменения в текст
            if (currentText.contains("номер по списку")) {
                modifiedText = currentText + " ✓";
            } else if (currentText.contains("не я сделал")) {
                modifiedText = currentText + " (точно!)";
            }

            // Добавляем легкий эффект смены регистра для демонстрации
            if (currentText.length() > 0) {
                // Делаем первую букву заглавной, если она была строчной, и наоборот
                char firstChar = currentText.charAt(0);
                if (Character.isUpperCase(firstChar)) {
                    modifiedText = Character.toLowerCase(firstChar) + currentText.substring(1);
                } else {
                    modifiedText = Character.toUpperCase(firstChar) + currentText.substring(1);
                }

                // Добавляем восклицательный знак в конце для акцента
                if (!modifiedText.endsWith("!")) {
                    modifiedText += "!";
                }
            }

            tvOut.setText(modifiedText);
        } else if (!currentText.isEmpty()) {
            // Возвращаем оригинальный текст, если CheckBox не отмечен
            tvOut.setText(currentText);
        }
    }
}