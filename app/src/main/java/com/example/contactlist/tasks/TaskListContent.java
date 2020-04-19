package com.example.contactlist.tasks;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.contactlist.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class TaskListContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Task> ITEMS = new ArrayList<Task>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Task> ITEM_MAP = new HashMap<String, Task>();

    private static final int COUNT = 3;

    static {
        // Add some sample items.

        addItem(new Task(Integer.toString(TaskListContent.ITEMS.size()+1),"Eryk","Piechowiak","06.08.1998","123456789"));
        addItem(new Task(Integer.toString(TaskListContent.ITEMS.size()+1),"Aleksander","Kowalski","01.02.1980","123456789"));
        addItem(new Task(Integer.toString(TaskListContent.ITEMS.size()+1),"Adam","Nowak","11.12.1976","123456789"));
    }

    public static void addItem(Task item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }
    public static void removeItem(int position)
    {
        String itemId = ITEMS.get(position).id;
        ITEMS.remove(position);
        ITEM_MAP.remove(itemId);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Task implements Parcelable{
        public final String id;
        public final String name;
        public final String surname;
        public final String birthday;
        public final String phoneNumber;
        public final String picPath;

        public Task(String id, String name, String surname, String birthday,String phoneNumber) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.birthday = birthday;
            this.picPath = "";
            this.phoneNumber = phoneNumber;
        }
        public Task(String id, String name, String surname, String birthday, String picPath,String phoneNumber)
        {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.birthday = birthday;
            this.picPath = picPath;
            this.phoneNumber = phoneNumber;
        }

        protected Task(Parcel in) {
            id = in.readString();
            name = in.readString();
            surname = in.readString();
            birthday = in.readString();
            picPath = in.readString();
            phoneNumber = in.readString();
        }

        public static final Creator<Task> CREATOR = new Creator<Task>() {
            @Override
            public Task createFromParcel(Parcel in) {
                return new Task(in);
            }

            @Override
            public Task[] newArray(int size) {
                return new Task[size];
            }
        };

        @Override
        public String toString() {
            return surname;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(name);
            dest.writeString(surname);
            dest.writeString(birthday);
            dest.writeString(picPath);
            dest.writeString(phoneNumber);
        }
    }
}
