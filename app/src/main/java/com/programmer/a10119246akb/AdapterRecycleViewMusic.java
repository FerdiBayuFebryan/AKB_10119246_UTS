package com.programmer.a10119246akb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRecycleViewMusic  extends RecyclerView.Adapter<AdapterRecycleViewMusic.ViewHolder> {
    // Tanggal Pengerjaan   : 7 MEI 2022
    // NIM                  : 10119246
    // Nama                 : Ferdi Bayu Febryan
    // Kelas                : IF-6

    private String[] SubjectMusic;
    private Context context;
    public AdapterRecycleViewMusic(String[] subjectMusic, Context context) {
        SubjectMusic = subjectMusic;
        this.context = context;
    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        ViewHolder(View v) {

            super(v);
            textView = v.findViewById(R.id.textItem);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_music, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(SubjectMusic[position]);

    }

    @Override
    public int getItemCount() {
        return SubjectMusic.length;
    }
}
