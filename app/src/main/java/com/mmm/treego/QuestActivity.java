package com.mmm.treego;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class QuestActivity extends Activity {
    // Array of strings...
    String[] mobileArray = {"Take part in a Biodiversity Guided Walk at Jurong Lake Gardens",
            "Take part in a mangrove guided walk at Pasir Ris Park",
            "Take part in Operation Deadline at Pulau Ubin",
            "Take part in the Heron Watch from 26Jan to 3Feb",
            "Volunteer for invasive species management at Central Catchment Nature Reserve"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest_activity);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.quest);
        listView.setAdapter(adapter);
    }
}