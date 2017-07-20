package com.example.rishabh.trial;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.rishabh.trial.Activities.NewsActivity;
import com.example.rishabh.trial.Activities.NewsActivityHindu;
import com.example.rishabh.trial.Adapters.EducationAdapter;
import com.example.rishabh.trial.Adapters.GameAdapter;
import com.example.rishabh.trial.Adapters.NewsAdapter;
import com.example.rishabh.trial.POJOs.News;
import com.example.rishabh.trial.POJOs.education;
import com.example.rishabh.trial.POJOs.games;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView rvgames ;
    RecyclerView rveduc ;
    RecyclerView rvnews ;
    GameAdapter gameadapter;
    EducationAdapter educationadapter;
    NewsAdapter newsadapter;

    static ArrayList<games> generategame() {
        ArrayList<games> gamesArrayList = new ArrayList<>();
        gamesArrayList.add(new games("Clash of Clans", R.drawable.clash));
        gamesArrayList.add(new games("Elevate", R.drawable.elevate));
        gamesArrayList.add(new games("Fidget Spinner", R.drawable.fidget));
        gamesArrayList.add(new games("Final Fantasy", R.drawable.finalfantasy));
        gamesArrayList.add(new games("Hill Climbing", R.drawable.hillclimb));
        gamesArrayList.add(new games("Mario", R.drawable.mario));
        gamesArrayList.add(new games("Teen Patti", R.drawable.patti));
        gamesArrayList.add(new games("Score Hero", R.drawable.score));
        gamesArrayList.add(new games("Stick Cricket", R.drawable.stick));
        return gamesArrayList;
    }

    static ArrayList<education> generateedu() {
        ArrayList<education> educationArrayList = new ArrayList<>();
        educationArrayList.add(new education("Cat Mock Tests", R.drawable.cat));
        educationArrayList.add(new education("Interview Questions", R.drawable.inter));
        educationArrayList.add(new education("Mock Cat papers", R.drawable.mock));
        educationArrayList.add(new education("Ted talk", R.drawable.ted));
        educationArrayList.add(new education("Vocabulary Builder", R.drawable.vocab));
        return educationArrayList;
    }
    static ArrayList<News> generatenews(){
        ArrayList<News> NewsArrayList = new ArrayList<>();
        NewsArrayList.add(new News("Times of India",R.drawable.toi));
        NewsArrayList.add(new News("The Hindu",R.drawable.hindu));
        return NewsArrayList;

    }
    private void sendfeedback() {
        final Intent _Intent = new Intent(android.content.Intent.ACTION_SEND);
        _Intent.setType("text/html");
        _Intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]
                { getString(R.string.mail_feedback_email) });
        _Intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.mail_feedback_subject));
        _Intent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.mail_feedback_message));
        startActivity(Intent.createChooser(_Intent, getString(R.string.title_send_feedback)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvgames = (RecyclerView)findViewById(R.id.rvgames);
        rveduc = (RecyclerView)findViewById(R.id.rveduc);
        rvnews = (RecyclerView)findViewById(R.id.rvnews);


        ArrayList<games> gamesArrayList = generategame();
        ArrayList<education> educationArrayList = generateedu();
        ArrayList<News> NewsArrayList = generatenews();


        gameadapter = new GameAdapter(this, gamesArrayList);
        LinearLayoutManager li = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvgames.setLayoutManager(li);
        rvgames.setAdapter(gameadapter);

        educationadapter = new EducationAdapter(this,educationArrayList);
        LinearLayoutManager li1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rveduc.setLayoutManager(li1);
        rveduc.setAdapter(educationadapter);

        newsadapter = new NewsAdapter(this,NewsArrayList);
        LinearLayoutManager li2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvnews.setLayoutManager(li2);
        rvnews.setAdapter(newsadapter);
        newsadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(String itemid) {
                try{
                    if(itemid.equalsIgnoreCase("Times of India")) {
                        Intent web = new Intent(MainActivity.this, NewsActivity.class);
                        startActivity(web);
                    }
                    else if(itemid.equalsIgnoreCase("The Hindu")) {
                        Intent web = new Intent(MainActivity.this, NewsActivityHindu.class);
                        startActivity(web);
                    }
                }
                catch(ActivityNotFoundException ae)
                {
                    Toast.makeText(MainActivity.this, "activity not found", Toast.LENGTH_SHORT).show();

                }
            }
        });















































        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendfeedback();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Toast.makeText(this, "This is camera", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, "This is gallery", Toast.LENGTH_SHORT).show();


        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this, "This is slideshow", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_manage) {
            Toast.makeText(this, "This is manager", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_share) {
            Toast.makeText(this, "This is share", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_send) {
            Toast.makeText(this, "This is send", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
