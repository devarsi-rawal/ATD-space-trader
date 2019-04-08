package atlantadragons.gatech.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import atlantadragons.gatech.spacetrader.Model.RepoHolder;
import atlantadragons.gatech.spacetrader.ViewModel.PlanetViewModel;

public class PlanetActivity extends AppCompatActivity {

    private PlanetViewModel viewModel;

    private TextView planetTextView;
    private TextView techLevelTextView;
    private TextView resourceTextView;
    private TextView coordTextView;
    private TextView fuelTextView;
    private Button marketButton;
    private Button travelButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_planet);


        planetTextView = findViewById(R.id.planetTextView);
        techLevelTextView = findViewById(R.id.techLevelTextView);
        resourceTextView = findViewById(R.id.resourceTextView);
        coordTextView = findViewById(R.id.coordTextView);
        marketButton = findViewById(R.id.marketButton);
        fuelTextView = findViewById(R.id.fuelTextView);
        travelButton = findViewById(R.id.travelButton);


        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlanetActivity.this, MarketActivity.class));
                finish();
            }
        });

        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlanetActivity.this, TravelActivity.class));
                finish();
            }
        });

        setTitle("Current Planet");
        planetTextView.setText(String.format("Planet: (%s)", RepoHolder.getHolder().getInteractor().getUniverse().getCurrentPlanetName()));
        techLevelTextView.setText(String.format("Tech Level: (%s)", RepoHolder.getHolder().getInteractor().getUniverse().getTechLevel().getLevelName()));
        resourceTextView.setText(String.format("Resource: (%s)", RepoHolder.getHolder().getInteractor().getUniverse().getResourceType().getName()));
        coordTextView.setText(String.format("Coordinates: (%d, %d)",
                RepoHolder.getHolder().getInteractor().getUniverse().getxCoord(),
                RepoHolder.getHolder().getInteractor().getUniverse().getyCoord()));
        fuelTextView.setText(String.format("Fuel Remaining: %.2f", RepoHolder.getHolder().getInteractor().getShipFuelRemaining()));

        viewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);

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
                startActivity(new Intent(PlanetActivity.this, PlanetActivity.class));
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
