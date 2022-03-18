package Controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import Model.Msg;
import Views.openedMessage;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.Holder> {


    private Context context;
    private List<Msg> msgs;

    public MsgAdapter(Context context, List<Msg> msgs) {
        this.context = context;
        this.msgs = msgs;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.messageview,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Msg m=msgs.get(position);
        holder.message.setText(m.getMsg());
        holder.time.setText(m.getTime());
        holder.open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,openedMessage.class);
                i.putExtra("id",String.valueOf(m.getId()));
                context.startActivity(i);
                Log.d("h1", String.valueOf(m.getId()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return msgs.size();
    }


    public class Holder extends RecyclerView.ViewHolder {

        private TextView message,time;
        private FloatingActionButton open;
        public Holder(@NonNull View itemView) {
            super(itemView);
            intiviews();

        }

        private void intiviews()
        {
            message=itemView.findViewById(R.id.showed);
            time=itemView.findViewById(R.id.time);
            open=itemView.findViewById(R.id.open);
        }
    }
}
