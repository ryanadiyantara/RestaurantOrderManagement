package adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.db.HistoryListDetail;
import com.example.db.R;

import java.io.Serializable;
import java.util.ArrayList;

import db.DbHelper;
import model.History;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.HistoryViewHolder> {

    private ArrayList<History> listHistory = new ArrayList<>();
    private Activity activity;
    private DbHelper dbHelper;

    public HistoryListAdapter(Activity activity) {
        this.activity = activity;
        dbHelper = new DbHelper(activity);
    }

    public ArrayList<History> getListHistory() {
        return listHistory;
    }

    public void setListHistory(ArrayList<History> listNotes) {
        if (listNotes.size() > 0) {
            this.listHistory.clear();
        }
        this.listHistory.addAll(listNotes);
        notifyDataSetChanged();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {

        final TextView item_tablenumber, item_customername, item_ordernote,
                item_americano, item_cappucino, item_macchiato, item_espressso, item_latte,
                item_chocolate, item_matchalatte, item_thaitea, item_redvelvet, item_greentea,
                item_sweets, item_cupcake, item_doughnut, item_croissant, item_cheesecake,
                item_totalprice;
        final Button btn_viewhistory, btn_update;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            item_tablenumber = itemView.findViewById(R.id.item_tablenumber);
            item_customername = itemView.findViewById(R.id.item_customername);
            item_ordernote = itemView.findViewById(R.id.item_ordernote);

            item_americano = itemView.findViewById(R.id.item_americano);
            item_cappucino = itemView.findViewById(R.id.item_cappucino);
            item_macchiato = itemView.findViewById(R.id.item_macchiato);
            item_espressso = itemView.findViewById(R.id.item_espresso);
            item_latte = itemView.findViewById(R.id.item_latte);
            item_chocolate = itemView.findViewById(R.id.item_chocolatte);
            item_matchalatte = itemView.findViewById(R.id.item_matchalatte);
            item_thaitea = itemView.findViewById(R.id.item_thaitea);
            item_redvelvet = itemView.findViewById(R.id.item_redvelvet);
            item_greentea = itemView.findViewById(R.id.item_greentea);
            item_sweets = itemView.findViewById(R.id.item_sweets);
            item_cupcake = itemView.findViewById(R.id.item_cupcake);
            item_doughnut = itemView.findViewById(R.id.item_doughnut);
            item_croissant = itemView.findViewById(R.id.item_croissant);
            item_cheesecake = itemView.findViewById(R.id.item_cheesecake);

            item_totalprice = itemView.findViewById(R.id.item_totalprice);

            btn_viewhistory = itemView.findViewById(R.id.btnviewhistory);
            btn_update = itemView.findViewById(R.id.btnupdate);
        }
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historylist, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int positionhistory) {

        holder.item_tablenumber.setText(listHistory.get(positionhistory).getTable_number());
        holder.item_customername.setText(listHistory.get(positionhistory).getCustomer_name());
        holder.item_ordernote.setText(listHistory.get(positionhistory).getOrder_note());

        holder.item_americano.setText(listHistory.get(positionhistory).getAmericano());
        holder.item_cappucino.setText(listHistory.get(positionhistory).getCappucino());
        holder.item_macchiato.setText(listHistory.get(positionhistory).getMacchiato());
        holder.item_espressso.setText(listHistory.get(positionhistory).getEspresso());
        holder.item_latte.setText(listHistory.get(positionhistory).getLatte());
        holder.item_chocolate.setText(listHistory.get(positionhistory).getChocolate());
        holder.item_matchalatte.setText(listHistory.get(positionhistory).getMatcha_latte());
        holder.item_thaitea.setText(listHistory.get(positionhistory).getThai_tea());
        holder.item_redvelvet.setText(listHistory.get(positionhistory).getRed_velvet());
        holder.item_greentea.setText(listHistory.get(positionhistory).getGreen_tea());
        holder.item_sweets.setText(listHistory.get(positionhistory).getSweets());
        holder.item_cupcake.setText(listHistory.get(positionhistory).getCupcake());
        holder.item_doughnut.setText(listHistory.get(positionhistory).getDoughnut());
        holder.item_croissant.setText(listHistory.get(positionhistory).getCroissant());
        holder.item_cheesecake.setText(listHistory.get(positionhistory).getCheesecake());

        holder.item_totalprice.setText(listHistory.get(positionhistory).getTotal_price());

        holder.btn_viewhistory.setOnClickListener((View v) -> {
            Intent intent = new Intent(activity, HistoryListDetail.class);
            intent.putExtra("user", (Serializable) listHistory.get(positionhistory));
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listHistory.size();
    }
}
