package com.example.forminfo

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var fistName: EditText;
    private lateinit var lastName: EditText;
    private lateinit var genderGroup: RadioGroup;
    private lateinit var birthDay: EditText;
    private lateinit var address: EditText;
    private lateinit var email: EditText;
    private lateinit var checkBox: CheckBox;
    private lateinit var register: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_constraint_layout)

        fistName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        genderGroup = findViewById(R.id.genderGroup);
        birthDay = findViewById(R.id.birthDay);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        checkBox = findViewById(R.id.checkBox);
        register = findViewById(R.id.register);

        register.setOnClickListener {
            register();
        }
    }

    /**
     * Hàm validate khi nhấn nút register
     * @author DVHIEU (20/10/2023)
     */
    private fun register() {
        var hasError = false;
        if (fistName.text.toString().trim().isEmpty()) hasError = true;
        if (lastName.text.toString().trim().isEmpty()) hasError = true;
        if (genderGroup.checkedRadioButtonId == -1) hasError = true;
        if (birthDay.text.toString().trim().isEmpty()) hasError = true;
        if (address.text.toString().trim().isEmpty()) hasError = true;
        if (email.text.toString().trim().isEmpty()) hasError = true;
        if (!checkBox.isChecked) hasError = true;

        if (hasError) {
            val dialog = AlertDialog.Builder(this);
            val textView = TextView(this);
            textView.text = "Warning";
            textView.setTextColor(Color.RED)
            textView.setPadding(72, 32, 4 ,4);
            textView.textSize = 16F;
            dialog.setCustomTitle(textView);
            dialog.setMessage("You need to be enter all fields!");

            dialog.setPositiveButton("Cancel") {
                dialogInterface, which -> {}
            }

            dialog.show();
        }
    }
}