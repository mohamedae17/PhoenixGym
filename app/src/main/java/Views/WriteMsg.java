package Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import Controller.DatabaseHandler;
import Model.Msg;

public class WriteMsg extends AppCompatActivity {

    private EditText msg;
    private Button sendbtn;
    private Bundle b;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_msg);
        inti();
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               db.sendMsg(new Msg(b.getString("reciver"),msg.getText().toString()));
               startActivity(new Intent(WriteMsg.this,Admin.class));
               finish();
            }
        });
    }

    private void  inti()
    {
        msg=findViewById(R.id.messageValue);
        sendbtn=findViewById(R.id.sendBtn);
        b=getIntent().getExtras();
        db=new DatabaseHandler(this);

    }

}