package coders.self.materialdesigntemplate.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import coders.self.materialdesigntemplate.R;
import coders.self.materialdesigntemplate.adapters.NavigationAdapter;
import coders.self.materialdesigntemplate.fragments.PostFragment;
import coders.self.materialdesigntemplate.items.NavigationItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout drawerLayout;
    private ListView mListView;

    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
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

        navigationItems.add(new NavigationItem("Carlos Bedoy", "carlos.bedoy@gmail.com", R.drawable.wallpaper_02, R.drawable.avatar));
        navigationItems.add(new NavigationItem("News", R.drawable.ic_action_news));
        navigationItems.add(new NavigationItem("Biography", R.drawable.ic_action_biography));
        navigationItems.add(new NavigationItem("Posts", R.drawable.ic_action_posts));
        navigationItems.add(new NavigationItem("Friends", R.drawable.ic_action_friends));
        navigationItems.add(new NavigationItem("About", R.drawable.ic_action_about));
        navigationItems.add(new NavigationItem("Self Coders", R.drawable.ic_action_test));


        mListView = (ListView) findViewById(R.id.list_view);

        NavigationAdapter navigationAdapter = new NavigationAdapter(getApplicationContext(), getLayoutInflater(), navigationItems);

        mListView.setAdapter(navigationAdapter);


        PostFragment postFragment = new PostFragment();

        presentFragment(postFragment);

    }

    public void presentFragment(Fragment fragment){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out);
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(fragment.getTag());
        fragmentTransaction.commit();
    }

}
