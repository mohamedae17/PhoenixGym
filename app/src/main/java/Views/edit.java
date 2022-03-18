package Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import Controller.DatabaseHandler;
import Model.User;

public class edit extends AppCompatActivity {

    EditText newpass;
    FloatingActionButton edit;
    DatabaseHandler db;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        inti();
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User myuser=db.At(Integer.parseInt(b.getString("Userid2")));
                myuser.setPassword(newpass.getText().toString());
                db.updateUser(myuser);
                Intent i=new Intent(edit.this,Messages.class);
                i.putExtra("Username",myuser.getUsername());
                startActivity(i);
                finish();
            }
        });
    }

    private void inti()
    {
        newpass=findViewById(R.id.newpass);
        edit=findViewById(R.id.newedit);
        db=new DatabaseHandler(this);
        b=getIntent().getExtras();

    }
}