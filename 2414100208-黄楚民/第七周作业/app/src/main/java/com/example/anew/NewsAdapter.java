package com.example.anew;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.anew.databinding.ItemNewsBinding;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<News.Article> data;
    public NewsAdapter(List<News.Article> data) { this.data = data; }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup p, int t) {
        return new ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(p.getContext()), p, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.b.tvItemTitle.setText(data.get(i).title); // 直接绑定
        h.b.tvItemAuthor.setText(data.get(i).author_name);
    }

    @Override public int getItemCount() { return data == null ? 0 : data.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemNewsBinding b;
        ViewHolder(ItemNewsBinding b) { super(b.getRoot()); this.b = b; }
    }
}