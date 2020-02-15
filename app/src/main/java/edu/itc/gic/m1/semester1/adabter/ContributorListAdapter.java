package edu.itc.gic.m1.semester1.adabter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.itc.gic.m1.semester1.R;
import edu.itc.gic.m1.semester1.model.Contributor;

public class ContributorListAdapter extends RecyclerView.Adapter<ContributorListAdapter.ContributorViewHolder> {

    private List<Contributor> data;
    public ContributorListAdapter(List<Contributor> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ContributorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_contributor, null);
        ContributorViewHolder viewHolder = new ContributorViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContributorViewHolder holder, int position) {
        Contributor contributor = getItem(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public Contributor getItem(int position) {
        return data.get(position);
    }

    public class ContributorViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle, itemTime;

        public ContributorViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
