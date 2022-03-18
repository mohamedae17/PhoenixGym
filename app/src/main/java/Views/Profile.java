package Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import Controller.DatabaseHandler;
import Model.User;

public class Profile extends AppCompatActivity {

    private Bundle b;
    private DatabaseHandler db;
    private TextView name,age,gender,weight;
    private FloatingActionButton delete,send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        inti();
        User u=db.At(Integer.parseInt(b.getString("pos")));
        if(u!=null) {
            name.setText(u.getFirstname()+" "+u.getLastname()+"<"+ u.getUsername()+">");
            age.setText(String.valueOf(u.getAge()));
            weight.setText(String.valueOf(u.getWeight()));
            gender.setText(u.getGender());
        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteUser(u);
                startActivity(new Intent(Profile.this,Admin.class));
                finish();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Profile.this,WriteMsg.class);
                i.putExtra("reciver",u.getUsername());
                startActivity(i);
            }
        });
    }

    private void inti()
    {
        b=getIntent().getExtras();
        db=new DatabaseHandler(this);
        name=findViewById(R.id.pName);
        age=findViewById(R.id.pAge);
        gender=findViewById(R.id.pGnder);
        weight=findViewById(R.id.pWeight);
       // delete=findViewById(R.id.pdelete);
       // send=findViewById(R.id.sendmessage);

    }
}