package atlantadragons.gatech.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import atlantadragons.gatech.spacetrader.ViewModel.PlanetViewModel;

public class PlanetActivity extends AppCompatActivity {

    private PlanetViewModel viewModel;

    private TextView planetTextView;
    private TextView techLevelTextView;
    private TextView resourceTextView;
    private TextView coordTextView;
    private Button marketButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_planet_activity);

        planetTextView = findViewById(R.id.planetTextView);
        techLevelTextView = findViewById(R.id.techLevelTextView);
        resourceTextView = findViewById(R.id.resourceTextView);
        coordTextView = findViewById(R.id.coordTextView);
        marketButton = findViewById(R.id.marketButton);



        setTitle("Current Planet");
        viewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);
    }


}
