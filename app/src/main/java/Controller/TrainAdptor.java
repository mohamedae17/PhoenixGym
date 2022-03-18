package Controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

import Model.Practice;
import Views.Info;

public class TrainAdptor extends RecyclerView.Adapter<TrainAdptor.Holder> {

    Context context;
    List<Practice> p;

    public TrainAdptor(Context context, List<Practice> p) {
        this.context = context;
        this.p = p;
    }

    @NonNull
    @Override
    public TrainAdptor.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.practiceview,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainAdptor.Holder holder, int position) {
        Practice pr=p.get(position);
        holder.img.setImageResource(pr.getImage());
        holder.title.setText(pr.getTilte());


    }

    @Override
    public int getItemCount() {
        return p.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img;
        TextView title;

        public Holder(@NonNull View itemView) {
            super(itemView);
            inti();
        }


        private void inti() {
            img = itemView.findViewById(R.id.tImg);
            title = itemView.findViewById(R.id.tTitle);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            //Toast.makeText(context,title.getText().toString(),Toast.LENGTH_LONG).show();
            Intent i1 = new Intent(context, Info.class);
            Practice pr=p.get(getAdapterPosition());
            i1.putExtra("title",pr.getTilte());
            i1.putExtra("img",pr.getImage());
            i1.putExtra("info",pr.getInfo());
            context.startActivity(i1);

        }
    }
}
