package com.georgevreilly.toastmastersassistant;

/**
 * Created by georgevreilly on 4/3/16.
 * Adapted from https://examples.javacodegeeks.com/android/core/ui/expandablelistview/android-expandablelistview-example/
 */
import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MyExpandableAdapter extends BaseExpandableListAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private ArrayList<String> parentItems;
    private ArrayList<ArrayList<SummaryDetail>> childItems;

    public MyExpandableAdapter(
            ArrayList<String> parents,
            ArrayList<ArrayList<SummaryDetail>> children) {
        this.parentItems = parents;
        this.childItems = children;
    }

    public void setInflater(LayoutInflater inflater, Activity activity) {
        this.inflater = inflater;
        this.activity = activity;
    }

    private ArrayList<String> summaries(int groupPosition) {
        ArrayList<SummaryDetail> childPairs = childItems.get(groupPosition);
        ArrayList<String> child = new ArrayList<>();

        for (SummaryDetail sumDetail : childPairs) {
            child.add(sumDetail.first);
        }

        return child;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ArrayList<String> child = summaries(groupPosition);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.group, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.group_textView);
        textView.setText(child.get(childPosition));

        convertView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(activity, child.get(childPosition),
                        Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row, null);
        }

        ((CheckedTextView) convertView).setText(parentItems.get(groupPosition));
        ((CheckedTextView) convertView).setChecked(isExpanded);

        return convertView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<String> child = summaries(groupPosition);
        return child.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return parentItems.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
