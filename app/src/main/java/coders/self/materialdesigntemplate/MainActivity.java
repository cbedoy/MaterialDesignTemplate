package coders.self.materialdesigntemplate;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout drawerLayout;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();


        List<NavigationItem> navigationItems = new ArrayList<>();

        navigationItems.add(new NavigationItem("Carlos Bedoy", "carlos.bedoy@gmail.com", R.drawable.header_default_background, R.drawable.avatar));
        navigationItems.add(new NavigationItem("News", R.drawable.ic_action_news));
        navigationItems.add(new NavigationItem("Biography", R.drawable.ic_action_biography));
        navigationItems.add(new NavigationItem("Posts", R.drawable.ic_action_posts));
        navigationItems.add(new NavigationItem("Friends", R.drawable.ic_action_friends));
        navigationItems.add(new NavigationItem("About", R.drawable.ic_action_about));
        navigationItems.add(new NavigationItem("Self Coders", R.drawable.ic_action_test));


        mListView = (ListView) findViewById(R.id.list_view);

        NavigationAdapter navigationAdapter = new NavigationAdapter(getApplicationContext(), getLayoutInflater(), navigationItems);

        mListView.setAdapter(navigationAdapter);




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

}
