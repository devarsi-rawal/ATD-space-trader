package atlantadragons.gatech.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import atlantadragons.gatech.spacetrader.Model.Market;
import atlantadragons.gatech.spacetrader.Model.Planet;
import atlantadragons.gatech.spacetrader.ViewModel.MarketViewModel;
import atlantadragons.gatech.spacetrader.ViewModel.PlanetViewModel;

public class MarketActivity extends AppCompatActivity {

    ListView marketList;

    private MarketViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        marketList = findViewById(R.id.marketListView);

        setTitle("Market");
        viewModel = ViewModelProviders.of(this).get(MarketViewModel.class);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MarketActivity.this, PlanetActivity.class));
        finish();
    }
}
