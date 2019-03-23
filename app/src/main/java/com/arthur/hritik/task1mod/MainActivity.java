package com.arthur.hritik.task1mod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTextChange, tvSum;
    Button btnAdd, btnStartActivity, btnShowToast, btnChange, btnExit;
    View.OnClickListener myClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //its a good practice to initialize all views in one place, or even better to do all this
        //initialization in a separate method, just like this:
        initView();

        //now adding the click listeners. There are three ways to do it. One you already know.
        //second one is what I'm doing now.
        //I'll first create a click listener object, and use that same listener for all buttons
        myClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here I'll handle all the clicks
                //first get the id of which button is clicked
                int id = v.getId();

                switch (id) {
                    case R.id.btn_start_act:
                        startActivity(new Intent(MainActivity.this, SecondActivity.class));
                        break;

                    case R.id.btn_toast:
                        Toast.makeText(MainActivity.this, "This is a beautiful toast, which cannot be eaten", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.btn_change_text:
                        tvTextChange.setText("Text Changed");
                        break;

                    case R.id.btn_add:
                        add();
                        break;

                    case R.id.btn_exit:
                        finish();
                }
            }
        };

        //now that we've made our click listener, we'll add it to all our buttons
        btnExit.setOnClickListener(myClickListener);
        btnChange.setOnClickListener(myClickListener);
        btnShowToast.setOnClickListener(myClickListener);
        btnStartActivity.setOnClickListener(myClickListener);
        btnAdd.setOnClickListener(myClickListener);
        //Now if any of these buttons will be clicked, the code in the myClickListener will execute
        //That code will first get the id of the button clicked, then will switch to that particular case & execute the code

        //and we're done
    }

    private void add() {
        EditText editText = findViewById(R.id.et_num_1);
        String value = editText.getText().toString();
        if (value.isEmpty()) {
            Toast.makeText(this, "Enter value", Toast.LENGTH_SHORT).show();
            return;
        }

        int num1 = Integer.parseInt(value);

        editText = findViewById(R.id.et_num_2);
        value = editText.getText().toString();
        if (value.isEmpty()) {
            Toast.makeText(this, "Enter value", Toast.LENGTH_SHORT).show();
            return;
        }

        int num2 = Integer.parseInt(value);

        int sum = num1 + num2;

        tvSum.setText("Sum is: " + sum); //as simple as that
    }

    private void initView() {
        //textviews init
        tvTextChange = findViewById(R.id.textToChange);
        tvSum = findViewById(R.id.tv_sum);

        //buttons init
        btnAdd = findViewById(R.id.btn_add);
        btnStartActivity = findViewById(R.id.btn_start_act);
        btnShowToast = findViewById(R.id.btn_toast);
        btnChange = findViewById(R.id.btn_change_text);
        btnExit = findViewById(R.id.btn_exit);
    }
}
