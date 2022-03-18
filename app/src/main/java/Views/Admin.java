package Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Controller.Adaptor;
import Controller.DatabaseHandler;
import Model.User;

public class Admin extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        intiViews();

    }

    private void intiViews()
    {
        recyclerView=findViewById(R.id.users);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        db=new DatabaseHandler(this);
        adapter=new Adaptor(this,db.ALL());
        recyclerView.setAdapter(adapter);
    }
}