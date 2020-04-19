package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.contactlist.tasks.TaskFragment;
import com.example.contactlist.tasks.TaskListContent;
import com.google.android.material.datepicker.CalendarConstraints;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class NewContactActivity extends AppCompatActivity {
    public static final String taskContact = "taskContact";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
    }

    public void onButtonClicked(View view) {
        EditText nameEditTxt = findViewById(R.id.editTextName);
        EditText surnameEditTxt = findViewById(R.id.editTextSurname);
        EditText birthdayEditTxt = findViewById(R.id.editTextBirthday);
        EditText phoneNumberEditTxt = findViewById(R.id.editTextPhoneNumber);
        String name = nameEditTxt.getText().toString();
        String surname = surnameEditTxt.getText().toString();
        String birthday = birthdayEditTxt.getText().toString();
        String phoneNumber = phoneNumberEditTxt.getText().toString();

        Random rnd = new Random();
        String[] images = getResources().getStringArray(R.array.images);
        int index = rnd.nextInt()%16;
        index = Math.abs(index);
        String randomImage = images[index];
        if(!name.equals("") && !surname.equals("") && isValidDate(birthday) && isValidPhoneNumber(phoneNumber)) {
            TaskListContent.Task newTask = new TaskListContent.Task(Integer.toString(TaskListContent.ITEMS.size()+1),name, surname, birthday, randomImage, phoneNumber);
            TaskListContent.addItem(newTask);
            Intent data = new Intent();
            setResult(RESULT_OK);
            finish();
        }
        else
        {
            if(name.equals("") && surname.equals("") && !isValidDate(birthday) && !isValidPhoneNumber(phoneNumber))
            {
                Toast.makeText(getApplicationContext(), "Nie wprowadzono wszystkich danych", Toast.LENGTH_SHORT).show();

            }
            else if(!isValidDate(birthday))
            {
                Toast.makeText(getApplicationContext(),"Niepoprawna data! (dd-mm-yyyy)",Toast.LENGTH_SHORT).show();
            }
            else if(!isValidPhoneNumber(phoneNumber))
            {
                Toast.makeText(getApplicationContext(),"Niepoprawny numer telefonu! (poprawny nr składa się z 9 cyfr)",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Nie wprowadzono wymaganych danych!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean isValidDate(String date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
        } catch (ParseException pe) {

            return false;
        }
        return true;
    }
    private boolean isValidPhoneNumber(String number)
    {
        try{
            int num = Integer.parseInt(number);
            if(num>99999999 && num<1000000000)
            {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
