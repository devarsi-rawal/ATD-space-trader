package atlantadragons.gatech.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import atlantadragons.gatech.spacetrader.Model.RepoHolder;
import atlantadragons.gatech.spacetrader.ViewModel.PlanetViewModel;

public class PlanetActivity extends AppCompatActivity {

    private PlanetViewModel viewModel;

    private TextView planetTextView;
    private TextView techLevelTextView;
    private TextView resourceTextView;
    private TextView coordTextView;
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

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlanetActivity.this, MarketActivity.class));
                finish();
            }
        });

//        planetTextView.setText(RepoHolder.getHolder().getInteractor().getUniverse().getPlanetNames().get(0));
//        techLevelTextView.setText(RepoHolder.getHolder().getInteractor().getUniverse().getTechLevel().getLevelName());
//        resourceTextView.setText(RepoHolder.getHolder().getInteractor().getUniverse().getResourceType().getName());
//        coordTextView.setText(String.format("Coordinates: (%d, %d)",
//                RepoHolder.getHolder().getInteractor().getUniverse().getyCoord(),
//                RepoHolder.getHolder().getInteractor().getUniverse().getxCoord()));

        setTitle("Current Planet");
        viewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);

        planetTextView.setText(viewModel.getPlanetName());
        techLevelTextView.setText(viewModel.getPlanetTechLevel());
        resourceTextView.setText(viewModel.getPlanetResourceType());
        coordTextView.setText("Coordinates: " + viewModel.getCoordinates());
    }



}
