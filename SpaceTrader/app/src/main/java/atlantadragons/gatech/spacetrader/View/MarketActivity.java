package atlantadragons.gatech.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

import atlantadragons.gatech.spacetrader.Model.RepoHolder;
import atlantadragons.gatech.spacetrader.Model.Resource;
import atlantadragons.gatech.spacetrader.ViewModel.MarketViewModel;

public class MarketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);


        ListView marketList = findViewById(R.id.marketList);

        ListAdapter arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, Resource.values());
        marketList.setAdapter(arrayAdapter);

        marketList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MarketActivity.this, TradeActivity.class);
                intent.putExtra("RESOURCE_ID", position);
                startActivity(intent);
                finish();
            }
        });

        setTitle("Market");
        MarketViewModel viewModel = ViewModelProviders.of(this).get(MarketViewModel.class);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.load_save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RepoHolder rh = RepoHolder.getHolder();
        File file;

        switch (item.getItemId()) {
            case R.id.saveItem:
                file = new File(this.getFilesDir(), RepoHolder.DEFAULT_JSON_FILE_NAME);
                Toast.makeText(this, "Saved Game", Toast.LENGTH_SHORT).show();
                return rh.saveJson(file);
            case R.id.loadItem:
                file = new File(this.getFilesDir(), RepoHolder.DEFAULT_JSON_FILE_NAME);
                rh.loadJson(file);
                Toast.makeText(this, "Loaded Game", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MarketActivity.this, PlanetActivity.class));
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MarketActivity.this, PlanetActivity.class));
        finish();
    }
}
