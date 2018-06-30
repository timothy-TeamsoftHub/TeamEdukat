package com.example.android.teamedukat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroupQuest1;

    private RadioButton radiobtnQ1;


    private RadioGroup radioGroupQuest2;

    private RadioButton radiobtnQ2;


    private CheckBox checkBoxQuest4a;
    private CheckBox checkBoxQuest4b;
    private CheckBox checkBoxQuest4c;
    private CheckBox checkBoxQuest4d;

    private RadioGroup radioGroupQuest5;

    private RadioButton radiobtnQ5;


    private EditText editQuest3;
    private Button btnDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void addListenerOnButton(View view) {

        //For Question 1
        radioGroupQuest1 = (RadioGroup) findViewById(R.id.radioQuest1);

        //For Question 2
        radioGroupQuest2 = (RadioGroup) findViewById(R.id.radioQuest2);

        //For Question 5
        radioGroupQuest5 = (RadioGroup) findViewById(R.id.radioQuest5);

        //Checking to make the radio button is selected
        if (radioGroupQuest1.getCheckedRadioButtonId() < 0) {
            Toast.makeText(this, "Error! Please select at least one answer in Question 1", Toast.LENGTH_SHORT).show();
            return;
        } else if (radioGroupQuest2.getCheckedRadioButtonId() < 0) {
            Toast.makeText(this, "Error! Please select at least one answer in Question 2", Toast.LENGTH_SHORT).show();
            return;
        } else if (radioGroupQuest5.getCheckedRadioButtonId() < 0) {
            Toast.makeText(this, "Error! Please select at least one answer in Question 5", Toast.LENGTH_SHORT).show();
            return;
        }


        // get selected radio button from radioGroupQuest1
        int selectedIdQ1 = radioGroupQuest1.getCheckedRadioButtonId();

        // find the radiobutton by returned id from radioGroupQuest1
        radiobtnQ1 = (RadioButton) findViewById(selectedIdQ1);


        // get selected radio button from radioGroupQuest2
        int selectedIdQ2 = radioGroupQuest2.getCheckedRadioButtonId();

        // find the radiobutton by returned id from radioGroupQuest2
        radiobtnQ2 = (RadioButton) findViewById(selectedIdQ2);


        // get selected radio button from radioGroupQuest5
        int selectedIdQ5 = radioGroupQuest5.getCheckedRadioButtonId();

        // find the radiobutton by returned id from radioGroupQuest5
        radiobtnQ5 = (RadioButton) findViewById(selectedIdQ5);

        //For Question 3
        // find the EditText by id and storing its content
        editQuest3 = (EditText) findViewById(R.id.radioAns3a);
        String typedAnswer = editQuest3.getText().toString();


        //For Question 4
        checkBoxQuest4a = (CheckBox) findViewById(R.id.checkAns4a);
        checkBoxQuest4b = (CheckBox) findViewById(R.id.checkAns4b);
        checkBoxQuest4c = (CheckBox) findViewById(R.id.checkAns4c);
        checkBoxQuest4d = (CheckBox) findViewById(R.id.checkAns4d);


        //Storing the correct answers
        String correctAns1 = getString(R.string.correctAns1);
        String correctAns2 = getString(R.string.correctAns2);
        String correctAns3 = getString(R.string.correctAns3);
        String correctAns4 = getString(R.string.correctAns4);
        String correctAns5 = getString(R.string.correctAns5);
        int score = 0;

        //Adding score for correct answer 1
        if (radiobtnQ1.getText() == correctAns1) {
            score += 1;
        }
        //Adding score for correct answer 2
        if (radiobtnQ2.getText() == correctAns2) {
            score += 1;
        }

        //Adding score for correct answer 3
        if (typedAnswer.equalsIgnoreCase(correctAns3)) {

            score += 1;
        }
        //Adding score for correct answer 4
        if (checkBoxQuest4a.isChecked() == true && checkBoxQuest4b.isChecked() == true && checkBoxQuest4c.isChecked() == false && checkBoxQuest4d.isChecked() == true) {

            score += 1;

        }

        //Adding score for correct answer 5
        if (radiobtnQ5.getText() == correctAns5) {
            score += 1;
        }
        //Displaying the message on a Toast
        String message = "The Total Score is " + score;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();


    }
}
