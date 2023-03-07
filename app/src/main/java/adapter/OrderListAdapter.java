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

import com.example.db.OrderListDetail;
import com.example.db.R;
import com.example.db.UpdateOrder;

import java.io.Serializable;
import java.util.ArrayList;

import db.DbHelper;
import model.Order;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderViewHolder> {

    private ArrayList<Order> listOrder = new ArrayList<>();
    private Activity activity;
    private DbHelper dbHelper;

    public OrderListAdapter(Activity activity) {
        this.activity = activity;
        dbHelper = new DbHelper(activity);
    }

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public void setListOrder(ArrayList<Order> listNotes) {
        if (listNotes.size() > 0) {
            this.listOrder.clear();
        }
        this.listOrder.addAll(listNotes);
        notifyDataSetChanged();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {

        final TextView item_tablenumber, item_customername, item_ordernote,
        item_americano, item_cappucino, item_macchiato, item_espressso, item_latte,
        item_chocolate, item_matchalatte, item_thaitea, item_redvelvet, item_greentea,
        item_sweets, item_cupcake, item_doughnut, item_croissant, item_cheesecake,
        item_totalprice;
        final Button btn_view, btn_update;

        public OrderViewHolder(@NonNull View itemView) {
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

            btn_view = itemView.findViewById(R.id.btnview);
            btn_update = itemView.findViewById(R.id.btnupdate);
        }
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_orderlist, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        holder.item_tablenumber.setText(listOrder.get(position).getTable_number());
        holder.item_customername.setText(listOrder.get(position).getCustomer_name());
        holder.item_ordernote.setText(listOrder.get(position).getOrder_note());

        holder.item_americano.setText(listOrder.get(position).getAmericano());
        holder.item_cappucino.setText(listOrder.get(position).getCappucino());
        holder.item_macchiato.setText(listOrder.get(position).getMacchiato());
        holder.item_espressso.setText(listOrder.get(position).getEspresso());
        holder.item_latte.setText(listOrder.get(position).getLatte());
        holder.item_chocolate.setText(listOrder.get(position).getChocolate());
        holder.item_matchalatte.setText(listOrder.get(position).getMatcha_latte());
        holder.item_thaitea.setText(listOrder.get(position).getThai_tea());
        holder.item_redvelvet.setText(listOrder.get(position).getRed_velvet());
        holder.item_greentea.setText(listOrder.get(position).getGreen_tea());
        holder.item_sweets.setText(listOrder.get(position).getSweets());
        holder.item_cupcake.setText(listOrder.get(position).getCupcake());
        holder.item_doughnut.setText(listOrder.get(position).getDoughnut());
        holder.item_croissant.setText(listOrder.get(position).getCroissant());
        holder.item_cheesecake.setText(listOrder.get(position).getCheesecake());

        holder.item_totalprice.setText(listOrder.get(position).getTotal_price());

        holder.btn_view.setOnClickListener((View v) -> {
            Intent intent = new Intent(activity, OrderListDetail.class);
            intent.putExtra("user", (Serializable) listOrder.get(position));
            activity.startActivity(intent);
        });
        holder.btn_update.setOnClickListener((View v) -> {
            Intent intent = new Intent(activity, UpdateOrder.class);
            intent.putExtra("user", (Serializable) listOrder.get(position));
            activity.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return listOrder.size();
    }
}
