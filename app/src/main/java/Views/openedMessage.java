package Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import Controller.DatabaseHandler;
import Model.Msg;
import Model.User;

public class openedMessage extends AppCompatActivity {

    private Bundle b;
    private DatabaseHandler db;
    private TextView msg,time;
    private FloatingActionButton delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opened_message);
        inti();

        Msg m=db.getMsg(Integer.parseInt(b.getString("id")));
        if(m!=null) {
            msg.setText(m.getMsg());
            time.setText(String.valueOf(m.getTime()));
        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteMsg(m);
                Intent i=new Intent(openedMessage.this,Messages.class);
                i.putExtra("Username",m.getReciver());
                startActivity(i);
                finish();
            }
        });
    }
    private void inti()
    {
        b=getIntent().getExtras();
        db=new DatabaseHandler(this);
        msg=findViewById(R.id.openedmsg);
        time=findViewById(R.id.date);
        delete=findViewById(R.id.delmsg);
    }
}