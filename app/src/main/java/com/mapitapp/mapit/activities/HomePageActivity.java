package com.mapitapp.mapit.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mapitapp.mapit.R;
import com.mapitapp.mapit.fragments.SelectTradesmanCriteriaFragment;
import com.mapitapp.mapit.fragments.SelectionFragment;
import com.mapitapp.mapit.model.TradesmanCriteria;


public class HomePageActivity extends ActionBarActivity implements SelectionFragment.onFindTradesmanListener,
        SelectTradesmanCriteriaFragment.onTradesmanCriteriaSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new SelectionFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
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

    @Override
    public void onFindTradesman() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new SelectTradesmanCriteriaFragment())
                .commit();
    }

    @Override
    public void onTradesmanCriteriaSelected(TradesmanCriteria criteria) {
        Toast.makeText(this, criteria.getProfession() + ", " + criteria.getCity() + ", " + criteria.getSuburb(), Toast.LENGTH_LONG).show();
    }
}
