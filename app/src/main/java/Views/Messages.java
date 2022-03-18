package Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import Controller.DatabaseHandler;
import Controller.MsgAdapter;
import Model.Msg;
import Model.User;

public class Messages extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private DatabaseHandler db;
    private Bundle b;
    private FloatingActionButton edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        inti();
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Messages.this,edit.class);
                Log.d("hello",String.valueOf(b.getString("myid")));
                i.putExtra("Userid2",String.valueOf(b.getString("myid")));
                startActivity(i);
            }
        });

    }

    private void inti()
    {
        recyclerView=findViewById(R.id.Messages);
        edit=findViewById(R.id.edit);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        db=new DatabaseHandler(this);
        b=getIntent().getExtras();
        adapter=new MsgAdapter(this,db.getUserMsgs(b.getString("Username")));
        recyclerView.setAdapter(adapter);
    }
}