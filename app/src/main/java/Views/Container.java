package Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Container extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NavOptions navOptions = new NavOptions.Builder()
                .setPopUpTo(R.id.profile, true)
                .build();
        setContentView(R.layout.activity_container);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,  R.id.fragmentContainerView);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }
}