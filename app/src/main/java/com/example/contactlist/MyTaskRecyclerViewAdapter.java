package com.example.contactlist;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contactlist.tasks.TaskFragment.OnListFragmentInteractionListener;
import com.example.contactlist.tasks.TaskListContent.Task;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Task} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyTaskRecyclerViewAdapter extends RecyclerView.Adapter<MyTaskRecyclerViewAdapter.ViewHolder> {

    private final List<Task> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyTaskRecyclerViewAdapter(List<Task> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Task task = mValues.get(position);
        holder.mItem = task;
        String txt = task.name;
        holder.mContentView.setText(txt);


        final String picPath = task.picPath;
        Context context = holder.mView.getContext();
        if(picPath != null && !picPath.isEmpty())
        {
            if(picPath.contains("drawable"))
            {
                Drawable taskDrawable;
                switch (picPath)
                {
                    case "drawable 1":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_1);
                        break;
                    case "drawable 2":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_2);
                        break;
                    case "drawable 3":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_3);
                        break;
                    case "drawable 4":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_4);
                        break;
                    case "drawable 5":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_5);
                        break;
                    case "drawable 6":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_6);
                        break;
                    case "drawable 7":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_7);
                        break;
                    case "drawable 8":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_8);
                        break;
                    case "drawable 9":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_9);
                        break;
                    case "drawable 10":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_10);
                        break;
                    case "drawable 11":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_11);
                        break;
                    case "drawable 12":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_12);
                        break;
                    case "drawable 13":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_13);
                        break;
                    case "drawable 14":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_14);
                        break;
                    case "drawable 15":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_15);
                        break;
                    case "drawable 16":
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_16);
                        break;
                    default:
                        taskDrawable = context.getResources().getDrawable(R.drawable.avatar_1);

                }
                holder.mItemImageView.setImageDrawable(taskDrawable);
            }
            else
            {
                holder.mItemImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.avatar_1));

            }

        }

        holder.mView.findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onListFragmentDeleteClickInteraction(position);
            }
        });
        holder.mView.findViewById(R.id.item_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null != mListener)
                {
                    mListener.onListFragmentClickInteraction(holder.mItem,position);
                }
            }
        });
        holder.mView.findViewById(R.id.item_image).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mListener.onListFragmentLongClickInteraction(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public final ImageView mItemImageView;
        public Task mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mItemImageView =  view.findViewById(R.id.item_image);
            mContentView =  view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
