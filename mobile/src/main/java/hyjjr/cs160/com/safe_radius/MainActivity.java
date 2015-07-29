package hyjjr.cs160.com.safe_radius;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tab1 = tabHost.newTabSpec(getString(R.string.tab1_name))
                .setIndicator(getString(R.string.tab1_name))
                .setContent(new Intent(this, RadarActivity.class));
        TabHost.TabSpec tab2 = tabHost.newTabSpec(getString(R.string.tab2_name))
                .setIndicator(getString(R.string.tab2_name))
                .setContent(new Intent(this, RadarActivity.class));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
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
}
