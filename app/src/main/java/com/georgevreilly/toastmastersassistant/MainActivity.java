package com.georgevreilly.toastmastersassistant;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;

import java.util.ArrayList;


public class MainActivity extends ExpandableListActivity {
    private ArrayList<String> parentItems = new ArrayList<>();
    private ArrayList<ArrayList<Pair<String, String>>> childItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    public void setGroupParents() {
        parentItems.add("Meeting Agenda");
        parentItems.add("Meeting Roles");
        parentItems.add("Competent Communicator Speeches");
    }

    public void setChildData() {
        // Meeting Agenda
        ArrayList<Pair<String, String>> child = new ArrayList<>();
        child.add(new Pair("Introductions", "Introduce the participants"));
        child.add(new Pair("Speeches", "Members present speeches based on projects in the Competent Communication and Advanced Communication manuals.  Usually at least three speakers are scheduled; however this may vary depending on the meeting program and length of meeting."));
        child.add(new Pair("Table Topics", "Members have an opportunity to present one- to- two minute impromptu talks with little time to prepare."));
        child.add(new Pair("Evaluations", "Each prepared speech and leadership role is verbally evaluated by a fellow member in a helpful, constructive manner using given evaluation criteria.  In addition, the evaluator prepares a written evaluation, and all members are invited to submit written comments too."));
        childItems.add(child);

        // Meeting Roles
        child = new ArrayList<>();
        child.add(new Pair("President", "Opens the meeting; runs the business"));
        child.add(new Pair("Toastmaster", "The Toastmaster is a meeting's director and host."));
        child.add(new Pair("Meeting Speaker", "Every speaker is a role model and club members learn from one another's speeches."));
        child.add(new Pair("Table Topics Master", "The Topicsmaster delivers the Table Topics portion of the meeting."));
        child.add(new Pair("Table Topic Speaker", "Table Topics helps members develop their impromptu speaking skills."));
        child.add(new Pair("Speech Evaluator", "Evaluators provide verbal and written feedback to meeting speakers."));
        child.add(new Pair("General Evaluator", "The General Evaluator evaluates everything that takes place during the club meeting."));
        child.add(new Pair("Timekeeper", "A Timer is responsible for monitoring the time of meeting segments and speakers."));
        child.add(new Pair("Grammarian", "The Grammarian helps club members improve their grammar and vocabulary."));
        childItems.add(child);

        // Competent Communicator Speeches
        child = new ArrayList<>();
        child.add(new Pair(
            "1. Ice Breaker",
            "The first speech of the Toastmasters program is about introducing yourself to your peers," +
                    " providing a benchmark for your current skill level, and standing and speaking without falling over."));
        child.add(new Pair(
            "2. Organize Your Speech",
            "Introduces the basic concepts of organizing a speech around a speech outline."));
        child.add(new Pair(
            "3. Get To The Point",
            "Clearly state your speech goal, and make sure that every element of your speech focuses on that goal."));
        child.add(new Pair(
            "4. How To Say It",
            "Examines word choice, sentence structure, and rhetorical devices."));
        child.add(new Pair(
            "5. Your Body Speaks",
            "Shows how to complement words with posture, stance, gestures, facial expressions, and eye contact."));
        child.add(new Pair(
            "6. Vocal Variety",
            "Guides you to add life to your voice with variations in pitch, pace, power, and pauses."));
        child.add(new Pair(
            "7. Research Your Topic",
            "Addresses the importance of backing up your arguments with evidence, " +
            "and touches on the types of evidence to use."));
        child.add(new Pair(
            "8. Get Comfortable With Visual Aids",
            "Examines the use of slides, transparencies, flip charts, whiteboards, or props."));
        child.add(new Pair(
            "9. Persuade With Power",
            "Discusses audience analysis and the different forms of persuasion available to a speaker."));
        child.add(new Pair(
            "10. Inspire Your Audience",
            "The last of ten speeches, this project challenges the speaker to draw all their skills" +
            " together to deliver a powerful inspirational message."));
        childItems.add(child);
    }
}
