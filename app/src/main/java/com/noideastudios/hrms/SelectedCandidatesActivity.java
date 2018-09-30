package com.noideastudios.hrms;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectedCandidatesActivity extends AppCompatActivity {

    public static CandidateAdapter candidateAdapter;
    public static ListView selectedListView;
    DBhandler dBhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_candidates);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Selected Candidates");
        }
        setUpList();
    }

    private void setUpList() {
        dBhandler = new DBhandler(this, null, null, 1);
        selectedListView = findViewById(R.id.selectedCandidateList);
        ArrayList<Candidate> arrayList = dBhandler.returnCandidates(1);
        candidateAdapter = new CandidateAdapter(this, R.layout.candidate_tile, arrayList);
        selectedListView.setAdapter(candidateAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
