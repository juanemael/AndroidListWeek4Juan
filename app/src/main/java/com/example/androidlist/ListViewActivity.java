package com.example.androidlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        prepareListView();
    }

    private void lookDetail(String title, String subTitle, int drawableID){
        Intent intent = new Intent(this, ViewDetail.class);
        Bundle details = new Bundle();
        details.putString("title", "Title1");
        details.putString("subTitle", "Lorem Ipsum");
        details.putInt("image",R.drawable.doge);
    }

    private void prepareListView(){
        RecyclerView rv = findViewById(R.id.activity_list_view_recycler_view);
        ArrayList<DataModel> dataModels  = new ArrayList<>();
        dataModels.add(new DataModel("Title1","Lorem Ipsum", R.drawable.doge));
        dataModels.add(new DataModel("Title2","Lorem Ipsum", R.drawable.ic_baseline_camera_24));
        dataModels.add(new DataModel("Title3","Lorem Ipsum", R.drawable.ic_baseline_bubble_chart_24));
        dataModels.add(new DataModel("Title4","Lorem Ipsum", R.drawable.ic_baseline_camera_24));
        dataModels.add(new DataModel("Title5","Lorem Ipsum", R.drawable.ic_baseline_bubble_chart_24));
        dataModels.add(new DataModel("Title6","Lorem Ipsum", R.drawable.ic_baseline_camera_24));
        dataModels.add(new DataModel("Title7","Lorem Ipsum", R.drawable.ic_baseline_bubble_chart_24));
        dataModels.add(new DataModel("Title6","Lorem Ipsum", R.drawable.ic_baseline_camera_24));
        dataModels.add(new DataModel("Title7","Lorem Ipsum", R.drawable.ic_baseline_bubble_chart_24));
        dataModels.add(new DataModel("Title6","Lorem Ipsum", R.drawable.ic_baseline_camera_24));
        dataModels.add(new DataModel("Title7","Lorem Ipsum", R.drawable.ic_baseline_bubble_chart_24));
        dataModels.add(new DataModel("Title6","Lorem Ipsum", R.drawable.ic_baseline_camera_24));
        dataModels.add(new DataModel("Title7","Lorem Ipsum", R.drawable.ic_baseline_bubble_chart_24));
        dataModels.add(new DataModel("Title6","Lorem Ipsum", R.drawable.ic_baseline_camera_24));
        dataModels.add(new DataModel("Title7","Lorem Ipsum", R.drawable.ic_baseline_bubble_chart_24));

        //VIEW HOLDER
        //ADAPTER : gunanya bagaimana bisa me manage susunan dari listview kita
        //LAYOUT MANAGER
        // pake alt insert buat constructer plus setter getter
        //LinearLayoutManager: per baris bisanya itemnya cuman satu aja yang dirender cuman mau vertical apa horizontal bisa diatur disini sama dari kiri ke kanana atau atas ke bawah
        //GridLayoutManager: Satu row, bisa lebih dari satu item contohnya di tokped satu baris bisa lebih dari satu barang

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DataModelAdapter dataModelAdapter = new DataModelAdapter(dataModels, this);

        rv.setAdapter(dataModelAdapter);
        rv.setLayoutManager(layoutManager);
    }
}

class DataModelAdapter extends RecyclerView.Adapter<DataModelViewHolder>{
    ArrayList<DataModel> dataModels;
    public DataModelAdapter(ArrayList<DataModel> dataModels, Context context) {
        this.dataModels = dataModels;
        this.context = context;
    }
    private Context context;

    @NonNull
    @Override
    public DataModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         context = parent.getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.list_view_card_view_holder, parent, false);
            return new DataModelViewHolder(view);
    }

    private void lookDetail(String title, String subTitle, int drawableID){
        Intent intent = new Intent(context, ViewDetail.class);
        Bundle details = new Bundle();
        details.putString("title", title);
        details.putString("subTitle", subTitle);
        details.putInt("image",drawableID);
        intent.putExtras(details);
        context.startActivity(intent);
    }

    @Override
    public void onBindViewHolder(@NonNull DataModelViewHolder holder, int position) {
        DataModel dm = dataModels.get(position);


        holder.wrapperView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookDetail(dm.getTitle(),dm.getSubTitle(),dm.getImageId());
            }
        });
        holder.titleTextView.setText(dm.getTitle());
        holder.subTitleTextView.setText(dm.getSubTitle());
        holder.imageView.setImageResource(dm.getImageId());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }
}

class DataModelViewHolder extends RecyclerView.ViewHolder{
    TextView titleTextView;
    TextView subTitleTextView;
    ImageView imageView;
    View wrapperView;

    public DataModelViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.list_view_card_view_holder_title_view);
        subTitleTextView = itemView.findViewById(R.id.list_view_card_view_holder_sub_title_view);
        imageView = itemView.findViewById(R.id.list_view_card_view_holder_image_view);
        wrapperView = itemView;
    }
}

class DataModel {
    private String title;
    private String subTitle;

    private int imageId;

    public DataModel(String title, String subTitle, int imageId) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}