package com.programmer.a10119246akb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OnBoardingAdapter extends  RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder> {
    // Tanggal Pengerjaan   : 7 MEI 2022
    // NIM                  : 10119246
    // Nama                 : Ferdi Bayu Febryan
    // Kelas                : IF-6
    private List<com.programmer.a10119246akb.OnBoardingItem> onBoardingItemList;

    public OnBoardingAdapter(List<com.programmer.a10119246akb.OnBoardingItem> onBoardingItemList) {
        this.onBoardingItemList = onBoardingItemList;
    }

    @NonNull
    @Override
    public OnBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnBoardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_onboarding, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingViewHolder holder, int position) {
        holder.setOnBoardingData(onBoardingItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return onBoardingItemList.size();
    }

    class OnBoardingViewHolder extends RecyclerView.ViewHolder{
        private TextView textTittle, textDescription;
        private ImageView imageOnBoarding;

        OnBoardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textTittle = itemView.findViewById(R.id.textTittle);
            textDescription = itemView.findViewById(R.id.textDesc);
            imageOnBoarding = itemView.findViewById(R.id.imageOnBoarding);
        }

        void setOnBoardingData(com.programmer.a10119246akb.OnBoardingItem onBoardingItem){
            textTittle.setText(onBoardingItem.getTittle());
            textDescription.setText(onBoardingItem.getDescription());
            imageOnBoarding.setImageResource(onBoardingItem.getImage());
        }
    }
}
