package nl.gblokict.firebasetest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends FirebaseRecyclerAdapter<
        Woord, ItemAdapter.ItemViewholder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ItemAdapter(@NonNull FirebaseRecyclerOptions<Woord> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull ItemViewholder holder, int position, @NonNull Woord model) {
        holder.tvWoordned.setText(model.getWoordned());
        holder.tvWoordamz.setText(model.getWoordamz());
    }
    
    @NonNull
    @Override
    public ItemAdapter.ItemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.woord_layout, parent, false);
        return new ItemAdapter.ItemViewholder(view);

    }
    public class ItemViewholder extends RecyclerView.ViewHolder {

        TextView tvWoordned, tvWoordamz;
        ImageView ivWoord;
        
        public ItemViewholder(@NonNull View itemView) {
            super(itemView);
            tvWoordned = itemView.findViewById(R.id.tvWoordned2);
            tvWoordamz = itemView.findViewById(R.id.tvWoordamz2);
            ivWoord = itemView.findViewById(R.id.ivWoord2);
            
            
        }
    }
}