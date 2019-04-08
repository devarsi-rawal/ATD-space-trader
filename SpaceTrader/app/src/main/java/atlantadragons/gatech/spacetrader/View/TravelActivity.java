package atlantadragons.gatech.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import atlantadragons.gatech.spacetrader.Model.Planet;
import atlantadragons.gatech.spacetrader.Model.RepoHolder;
import atlantadragons.gatech.spacetrader.Model.Resource;
import atlantadragons.gatech.spacetrader.Model.SolarSystem;
import atlantadragons.gatech.spacetrader.Model.Universe;
import atlantadragons.gatech.spacetrader.ViewModel.TradeViewModel;
import atlantadragons.gatech.spacetrader.ViewModel.TravelViewModel;

public class TravelActivity extends AppCompatActivity {

    private ListView planetList;
    private TravelViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        planetList = findViewById(R.id.planetList);
        ArrayList<SolarSystem> planets = RepoHolder.getHolder().getInteractor().getUniverse().getUniverseList();
        for (int i = 0; i < planets.size(); i++) {
            SolarSystem planet = planets.get(i);
            int currX = RepoHolder.getHolder().getInteractor().getUniverse().getxCoord();
            int currY = RepoHolder.getHolder().getInteractor().getUniverse().getyCoord();
            int nextX = planet.getxCoord();
            int nextY = planet.getyCoord();
            double currFuel = RepoHolder.getHolder().getInteractor().getShipFuelRemaining();
            double distance = Math.sqrt( Math.pow((nextX - currX), 2) + Math.pow((nextY - currY), 2) );

            if (distance > currFuel)
                    planets.remove(planet);

        }
        ArrayAdapter<SolarSystem> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planets);
        planetList.setAdapter(arrayAdapter);

        planetList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                SolarSystem temp = (SolarSystem) adapterView.getItemAtPosition(position);

                int currX = RepoHolder.getHolder().getInteractor().getUniverse().getxCoord();
                int currY = RepoHolder.getHolder().getInteractor().getUniverse().getyCoord();
                int nextX = temp.getxCoord();
                int nextY = temp.getyCoord();

                double currFuel = RepoHolder.getHolder().getInteractor().getShipFuelRemaining();
                double distance = Math.sqrt( Math.pow((nextX - currX), 2) + Math.pow((nextY - currY), 2) );

                RepoHolder.getHolder().getInteractor().setShipFuelRemaining((currFuel - distance));

                RepoHolder.getHolder().getInteractor().getUniverse().setCurrentSolarSystem(temp);

                onBackPressed();
            }
            });



        setTitle("Travel to Planet");
        viewModel = ViewModelProviders.of(this).get(TravelViewModel.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(TravelActivity.this, PlanetActivity.class));
        finish();
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
                startActivity(new Intent(TravelActivity.this, PlanetActivity.class));
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
