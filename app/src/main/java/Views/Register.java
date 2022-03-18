package Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import Controller.DatabaseHandler;
import Model.User;

public class Register extends AppCompatActivity {


    EditText username,firstname,lastname;
    EditText age,gender,weight,password;
    FloatingActionButton reg;
    DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inti();
    }

    private void inti()
    {
        db=new DatabaseHandler(this);
        username=findViewById(R.id.regUsename);
        firstname=findViewById(R.id.regFirst);
        lastname=findViewById(R.id.regLast);
        age=findViewById(R.id.regAge);
        gender=findViewById(R.id.regGender);
        weight=findViewById(R.id.regWeight);
        password=findViewById(R.id.regPassword);
        reg=findViewById(R.id.rBtn);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found=false;
                List<User> users=db.ALL();
                for(User u:users)
                {
                    if(u.getUsername().equals(username.getText().toString()))
                    {
                        found=true;
                        break;
                    }
                }
                if(found)
                {
                    Toast.makeText(getApplicationContext(),"this uername is already used",Toast.LENGTH_LONG).show();
                    username.setText("");
                }
                else if(username.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"Pls enter user name",Toast.LENGTH_LONG).show();
                }
                else if (password.getText().toString().length()<8)
                {
                    Toast.makeText(getApplicationContext(),"Pls enter longer password",Toast.LENGTH_LONG).show();
                    password.setText("");
                }
                else {
                    db.addUser(new User(username.getText().toString(), firstname.getText().toString(), lastname.getText().toString(),
                            Integer.parseInt(age.getText().toString()), gender.getText().toString(), password.getText().toString(),
                            Integer.parseInt(weight.getText().toString())));
                    startActivity(new Intent(Register.this, Start.class));
                    finish();
                }

            }
        });

    }

}