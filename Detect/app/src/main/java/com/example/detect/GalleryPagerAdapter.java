package com.example.detect;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class GalleryPagerAdapter extends RecyclerView.Adapter<GalleryPagerAdapter.GalleryViewHolder> {

    private Context context;
    private List<String> uriStringList;

    public GalleryPagerAdapter(Context context, List<String> uriStringList) {
        this.context = context;
        this.uriStringList = uriStringList;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gallery, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        Uri uri = Uri.parse(uriStringList.get(position));
        Glide.with(context)
                .load(uri)
                .fitCenter()
                .into(holder.fullImageView);
    }

    @Override
    public int getItemCount() {
        return uriStringList.size();
    }

    static class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView fullImageView;
        GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            fullImageView = itemView.findViewById(R.id.fullImageView);
        }
    }
}
