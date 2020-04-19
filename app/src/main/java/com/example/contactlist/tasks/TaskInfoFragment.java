    package com.example.contactlist.tasks;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contactlist.MainActivity;
import com.example.contactlist.R;


    /**
 * A simple {@link Fragment} subclass.
 */
public class TaskInfoFragment extends Fragment {

    public TaskInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_info, container, false);
    }
        public void displayTask(TaskListContent.Task task)
        {
            FragmentActivity activity = getActivity();
            TextView taskInfoName = activity.findViewById(R.id.taskInfoName);
            TextView taskInfoPhoneNumber = activity.findViewById(R.id.taskInfoPhoneNumber);
            TextView taskInfoBirthday = activity.findViewById(R.id.taskInfoBirthday);
            ImageView taskInfoImage = activity.findViewById(R.id.taskInfoImage);

            String name = task.name+" "+task.surname;
            taskInfoName.setText(name);
            String phoneNumber = "Numer telefonu: "+task.phoneNumber;
            taskInfoPhoneNumber.setText(phoneNumber);
            String birthday = "Data urodzenia: "+task.birthday;
            taskInfoBirthday.setText(birthday);
            if(task.picPath != null && !task.picPath.isEmpty())
            {
                if(task.picPath.contains("drawable"))
                {
                    Drawable taskDrawable;
                    switch(task.picPath)
                    {
                        case "drawable 1":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_1);
                            break;
                        case "drawable 2":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_2);
                            break;
                        case "drawable 3":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_3);
                            break;
                        case "drawable 4":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_4);
                            break;
                        case "drawable 5":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_5);
                            break;
                        case "drawable 6":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_6);
                            break;
                        case "drawable 7":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_7);
                            break;
                        case "drawable 8":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_8);
                            break;
                        case "drawable 9":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_9);
                            break;
                        case "drawable 10":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_10);
                            break;
                        case "drawable 11":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_11);
                            break;
                        case "drawable 12":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_12);
                            break;
                        case "drawable 13":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_13);
                            break;
                        case "drawable 14":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_14);
                            break;
                        case "drawable 15":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_15);
                            break;
                        case "drawable 16":
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_16);
                            break;
                        default:
                            taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_1);

                    }
                    taskInfoImage.setImageDrawable(taskDrawable);
                }
            }
            else
            {

                taskInfoImage.setImageDrawable(activity.getResources().getDrawable(R.drawable.avatar_1));
            }
        }
        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState)
        {
            super.onActivityCreated(savedInstanceState);
            Intent intent = getActivity().getIntent();
            if(intent!=null)
            {
                TaskListContent.Task receivedTask = intent.getParcelableExtra(MainActivity.taskExtra);
                if(receivedTask != null)
                {
                    displayTask(receivedTask);
                }
            }
        }
}
