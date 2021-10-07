package com.example.recycler2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MoviesrecyclerViewAdapter adapter;
    ArrayList<Movies> objMovies = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        objMovies.add(new Movies("Shang-Chi", "Action, Adventure, fantasy", "Destin Daniel Cretton", 7.9, "Shang-Chi, the master of weaponry-based Kung Fu, is forced to confront his past after being drawn into the Ten Rings organization.", "03 September 2021"));
        objMovies.add(new Movies("Free Guy", "Action, Adventure, Comedy", "Shawn Levy", 7.3, "A bank teller discovers that he's actually an NPC inside a brutal, open world video game.", "13 Agustus 2021"));
        objMovies.add(new Movies("Venom: Let There Be Carnage", "Action, Adventure, Sci-Fi", "Andy Serkis", 6.6, "Eddie Brock attempts to reignite his career by interviewing serial killer Cletus Kasady, who becomes the host of the symbiote Carnage and escapes prison after a failed execution.", "01 Oktober 2021"));

        adapter = new MoviesrecyclerViewAdapter(objMovies);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}