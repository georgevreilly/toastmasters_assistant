package com.georgevreilly.toastmastersassistant;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;

public class MainActivity extends ExpandableListActivity {
    private ArrayList<String> parentItems = new ArrayList<String>();
    private ArrayList<Object> childItems = new ArrayList<Object>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        super.onCreate(savedInstanceState);

        // this is not really  necessary as ExpandableListActivity contains an ExpandableList
        //setContentView(R.layout.main);

        ExpandableListView expandableList = getExpandableListView(); // you can use (ExpandableListView) findViewById(R.id.list)

        expandableList.setDividerHeight(2);
        expandableList.setGroupIndicator(null);
        expandableList.setClickable(true);

        setGroupParents();
        setChildData();

        MyExpandableAdapter adapter = new MyExpandableAdapter(parentItems, childItems);

        adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
        expandableList.setAdapter(adapter);
        expandableList.setOnChildClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void setGroupParents() {
        parentItems.add("Meeting Agenda");
        parentItems.add("Meeting Roles");
        parentItems.add("Competent Communicator Speeches");
    }

    public void setChildData() {
        // Meeting Agenda
        ArrayList<String> child = new ArrayList<>();
        child.add("Introductions");
        child.add("Speeches");
        child.add("Table Topics");
        child.add("Evaluations");
        childItems.add(child);

        // Meeting Roles
        child = new ArrayList<>();
        child.add("President");
        child.add("Toastmaster");
        child.add("Meeting Speaker");
        child.add("Topicsmaster");
        child.add("Topic Speaker");
        child.add("Speech Evaluator");
        child.add("General Evaluator");
        child.add("Timekeeper");
        child.add("Grammarian");
        childItems.add(child);

        // Competent Communicator Speeches
        child = new ArrayList<>();
        child.add("1. Ice Breaker");
        child.add("2. Organize Your Speech");
        child.add("3. Get To The Point");
        child.add("4. How To Say It");
        child.add("5. Your Body Speaks");
        child.add("6. Vocal Variety");
        child.add("7. Research Your Topic");
        child.add("8. Get Comfortable With Visual Aids");
        child.add("9. Persuade With Power");
        child.add("10. Inspire Your Audience");
        childItems.add(child);
    }
}
