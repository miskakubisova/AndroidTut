package com.example.miska.bawp.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.miska.bawp.R;
import com.example.miska.bawp.data.CourseListAdapter;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private CourseListAdapter adapter;
    private Menu menu;
    private boolean isListVieew = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        recyclerView = findViewById(R.id.courceRecyclerView);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        isListVieew = true;
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        adapter = new CourseListAdapter();
        recyclerView.setAdapter(adapter);

        adapter.setOnClickListener(new CourseListAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                startActivity(newIntent(DashboardActivity.this, position));
            }
        });
    }

    public Intent newIntent(Context context, int position){
        Intent intent =  new Intent(context, DetailsActivity.class);
        intent.putExtra("course_id", position);
        return intent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_toggle) {
            toggle();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toggle(){
         if(isListVieew){
             showGridView();
         }
         else {
             showListView();
         }
    }

    private void showListView() {
        staggeredGridLayoutManager.setSpanCount(1);
        MenuItem item = menu.findItem(R.id.action_toggle);
        item.setIcon(R.drawable.ic_grid_on_black_24dp);
        item.setTitle(getString(R.string.show_as_grid));
        isListVieew = true;
    }

    private void showGridView() {
        staggeredGridLayoutManager.setSpanCount(2);
        MenuItem item = menu.findItem(R.id.action_toggle);
        item.setIcon(R.drawable.ic_view_list_black_24dp);
        item.setTitle(getString(R.string.show_as_list));
        isListVieew = false;
    }
}
