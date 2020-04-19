package com.example.contactlist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.contactlist.tasks.TaskFragment;
import com.example.contactlist.tasks.TaskInfoFragment;
import com.example.contactlist.tasks.TaskListContent;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
        implements
        TaskFragment.OnListFragmentInteractionListener,
        DeleteDialog.OnDeleteDialogInteractionListener,
        CallDialog.OnCallDialogInteractionListener
{
    private int currentItemPosition = -1;
    public static final int BUTTON_REQUEST = 1;
    public static final TaskListContent.Task newTask = null;
    public static final String taskExtra = "taskExtra";
    public static final String taskContact = "taskContact";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showDeleteDialog()
    {

        DeleteDialog.newInstance().show(getSupportFragmentManager(),getString(R.string.delete_dialog_tag));
    }
    public void showCallDialog()
    {

        CallDialog.newInstance().show(getSupportFragmentManager(),getString(R.string.call_dialog_tag));
    }

    @Override
    public void onListFragmentClickInteraction(TaskListContent.Task task, int position) {
        //Toast.makeText(this, getString(R.string.item_selected_msg), Toast.LENGTH_SHORT).show();
        currentItemPosition = position;
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            displayTaskInFragment(task);
        }
        else {
            startSecondActivity(task, position);
        }
    }

    @Override
    public void onListFragmentLongClickInteraction(int position) {
        showCallDialog();
    }

    @Override
    public void onListFragmentDeleteClickInteraction(int position) {
        showDeleteDialog();
        currentItemPosition = position;
    }

    private void startSecondActivity(TaskListContent.Task task, int position) {
        Intent intent = new Intent(this, TaskInfoActivity.class);
        intent.putExtra(taskExtra, task);
        startActivity(intent);
    }

    public void onButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(),NewContactActivity.class);
        startActivityForResult(intent,BUTTON_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            if(requestCode == BUTTON_REQUEST)
            {
                ((TaskFragment) getSupportFragmentManager().findFragmentById(R.id.taskFragment)).notifyDataChange();
            }
        }

    }
    private void displayTaskInFragment(TaskListContent.Task task)
    {
        TaskInfoFragment taskInfoFragment = ((TaskInfoFragment) getSupportFragmentManager().findFragmentById(R.id.displayFragment));
        if(taskInfoFragment!=null)
        {
            taskInfoFragment.displayTask(task);
        }
    }



    @Override
    public void onDeleteDialogPositiveClick(DialogFragment dialog) {
        if(currentItemPosition != -1 && currentItemPosition < TaskListContent.ITEMS.size())
        {
            TaskListContent.removeItem(currentItemPosition);
            ((TaskFragment) getSupportFragmentManager().findFragmentById(R.id.taskFragment)).notifyDataChange();
        }
    }

    @Override
    public void onDeleteDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(getApplicationContext(),"Anulowano",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCallDialogPositiveClick(DialogFragment dialog) {
        Toast.makeText(getApplicationContext(),"Wykonano połączenie",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCallDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(getApplicationContext(),"Anulowano",Toast.LENGTH_SHORT).show();
    }
}
