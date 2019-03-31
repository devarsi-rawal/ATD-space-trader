package atlantadragons.gatech.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import atlantadragons.gatech.spacetrader.Model.Resource;
import atlantadragons.gatech.spacetrader.ViewModel.MarketViewModel;

public class MarketActivity extends AppCompatActivity {

    private ListView marketList;

    private MarketViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        marketList = findViewById(R.id.marketList);

        ArrayAdapter<Resource> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Resource.values());
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
        viewModel = ViewModelProviders.of(this).get(MarketViewModel.class);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MarketActivity.this, PlanetActivity.class));
        finish();
    }
}
