package com.example.android.quizapp;

import android.content.Context;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final static String Q3Answer = "James Naismith";
    private final static String Q5Answer = "True";
    private Button Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Submit = findViewById(R.id.submit_button);
        Submit.setOnClickListener(v->onSubmitButtonPressed());

    }
    public void checkQuiz () {

        ArrayList<String> WrongAnswer = new ArrayList<>();
        int CorrectQuestions = 0;
        if (checkQ1()) {
            CorrectQuestions++;
        } else {
            WrongAnswer.add("Question 1");
        }
        if (checkQ2()) {
            CorrectQuestions++;
        } else {
            WrongAnswer.add("Question 2");
        }
        if (checkQ3()) {
            CorrectQuestions++;
        } else {
            WrongAnswer.add("Question 3");
        }
        if (checkQ4()) {
            CorrectQuestions++;
        } else {
            WrongAnswer.add("Question 4");
        }
        if (checkQ5()) {
            CorrectQuestions++;
        } else {
            WrongAnswer.add("Question 5");
        }
        if (checkQ6()) {
            CorrectQuestions++;
        }else {
            WrongAnswer.add("Question 6");
        }
        StringBuilder sb = new StringBuilder();
        for (String s : WrongAnswer) {
            sb.append(s);
            sb.append("\n");
        }
        Context context = getApplicationContext();
        CharSequence text = "You got " + CorrectQuestions + "/6 answers right.";
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    private boolean checkQ6() {
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkbox2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkbox3);
        CheckBox cb4 = (CheckBox) findViewById(R.id.checkbox4);
        CheckBox cb5 = (CheckBox) findViewById(R.id.checkbox5);

        if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && !cb4.isChecked() && cb5.isChecked()){
            return true;
        } else {
            return false;
        }

    }

    private void onSubmitButtonPressed() {
        checkQuiz();
    }

    private boolean checkQ5() {
        String ans = getQ5Answer();
        if (ans.trim().equalsIgnoreCase(Q5Answer)){
            return true;
        } else {
            return false;
        }

    }
    private String getQ5Answer(){
        EditText uInput = (EditText) findViewById(R.id.question5Ans);
        String answer = uInput.getText().toString();
        return answer;
    }

    private boolean checkQ4() {
        RadioButton question4Answer = (RadioButton) findViewById(R.id.correctAnswerQ4);
        boolean isQ4Checked = question4Answer.isChecked();
        if (isQ4Checked){
            return true;
        } else {
            return false;
        }
    }

    private boolean checkQ3() {
        String ans = getQuestion3Answer();
        if (ans.trim().equalsIgnoreCase(Q3Answer)){
            return true;
        } else {
            return false;
        }

    }
    private String getQuestion3Answer(){
        EditText userInput = (EditText) findViewById(R.id.question3Ans);
        String answer = userInput.getText().toString();
        return answer;
    }


    private boolean checkQ2() {
        RadioButton question2Answer = (RadioButton) findViewById(R.id.correctAnswerQ2);
        boolean isQ2AnswerChecked = question2Answer.isChecked();
        if (isQ2AnswerChecked) {
            return true;
        } else {
            return false;
        }

    }

    private boolean checkQ1() {
        RadioButton question1Answer = (RadioButton) findViewById(R.id.correctAnswerQ1);

        boolean isquestion1Right = question1Answer.isChecked();

        if (isquestion1Right) {
            return true;
        } else {
            return false;
        }
    }

}
