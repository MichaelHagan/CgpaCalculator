package com.example.cgpacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int cummulativeCredit = 0;
    float cummulativeGradePoint = 0;
    int possibility = 0;
    short totalCredit = 0;
    short check = 0;
    //short tDecide = 1;
    int temp;
    short level = 100;
    int credit;
    short loop = 2;
    short loop1 = 2;
    float gradePoint;
    int level1 = 100;
    int switchCheck = 1;
    float tcgpa = 0;
    int firsttime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        select();
    }


    public void submitter(View v) {
        boolean err = true;

        try {
            EditText input = (EditText) findViewById(R.id.inputView);
            check = (short) Integer.parseInt(input.getText().toString());
        } catch (Exception e) {

            Toast.makeText(this, "Select Semester", Toast.LENGTH_SHORT).show();
            err = false;
        }
        if (err) {
            if (check != 0 && cummulativeCredit == 0) {

                display("Enter total Credit for level 100 semester 1");

            } else {

                Toast.makeText(this, "Switch to Credit submit", Toast.LENGTH_SHORT).show();

            }
        }
    }

    public void credit(View v) {

        if (loop > check) {

            Toast.makeText(this, "Switch to gradePoint submit", Toast.LENGTH_SHORT).show();

        } else {
            EditText input1 = (EditText) findViewById(R.id.inputView);
            credit = Integer.parseInt(input1.getText().toString());
            cummulativeCredit += credit;
            loop++;

            if (loop > check) {
                display("Enter total gradePoint for level 100 semester 1");
            } else {
                --loop;
                display("Enter total credit for level " + level + " semester " + (loop % 2 == 0 ? "2: " : "1: "));
                if (loop % 2 == 0) {
                    level += 100;
                }
                loop++;
            }

        }
    }

    public void gradePoint(View v) {

        if (loop1 > check) {

            Toast.makeText(this, "Switch to Target submit", Toast.LENGTH_SHORT).show();

        } else {
            EditText input1 = (EditText) findViewById(R.id.inputView);
            gradePoint = Float.parseFloat(input1.getText().toString());
            cummulativeGradePoint += gradePoint;
            loop1++;

            if (loop1 > check) {
                display(cgpa());
            } else {
                --loop1;
                display("Enter total gradePoint for level " + level1 + " semester " + (loop1 % 2 == 0 ? "2: " : "1: "));
                if (loop1 % 2 == 0) {
                    level1 += 100;
                }
                loop1++;
            }
        }
    }

    public void select() {

        display("Current Semester is the semester yet to release full results\n" + "Select your current semester\nEnter the number appended to it to select\n"
                + "1.100 first semester\n2.100 second semester\n3.200 first semester\n4.200 second semester  \n"
                + "5.300 first semester\n6.300 second semester\n7.400 first semester\n8.400 second semester\n\nEnter selection: ");

    }

    public String cgpa() {
        float cgpa;
        String output;
        cummulativeCredit *= 4;

        cgpa = (cummulativeGradePoint / cummulativeCredit) * 4;

        output = "Your cgpa is: " + cgpa + "\nEnter your target cgpa: ";


        return output;
    }

    public void display(String scanner) {
        TextView print = (TextView) findViewById(R.id.display);
        print.setText(scanner);
    }

    public void tcgpa(View v) {

        float tgradepoint;
        String finalle;

        switch (switchCheck) {
            case 1:
                try {
                    EditText input = (EditText) findViewById(R.id.inputView);
                    tcgpa = Float.parseFloat(input.getText().toString());
                    switchCheck++;
                    display("Enter your total credit hours for current semester: ");
                } catch (Exception e) {

                    Toast.makeText(this, "Enter Previous inputs", Toast.LENGTH_SHORT).show();

                }
                break;

            case 2:
                EditText input2 = (EditText) findViewById(R.id.inputView);
                totalCredit = (short) Integer.parseInt(input2.getText().toString());
                temp = (4 * totalCredit);
                cummulativeCredit += (4 * totalCredit);
                tgradepoint = ((cummulativeCredit * tcgpa) - (4 * cummulativeGradePoint)) / 4;
                finalle = "You need to obtain a total gradePoint of " + tgradepoint + " to obtain your target cgpa";
                possibility = totalCredit * 4;

                if (possibility < tgradepoint) {
                    finalle += "\nSorry, this is impossible";
                    display(finalle);
                } else {
                    finalle += "\nThis is possible";
                    display(finalle);
                }
                switchCheck++;
                break;

            default:
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
        }
    }

}

   /* public float minmax() {

        possibility = 0;
        cummulativeCredit = cummulativeCredit - temp;
        display("Enetr 1 to calculate target cgpa or 2 to exit: ");
        EditText input = (EditText) findViewById(R.id.inputView);
        tdecide = (short) Integer.parseInt(input.getText().toString());
        return 0;

    }*/


