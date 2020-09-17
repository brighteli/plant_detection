package org.tensorflow.lite.examples.classification.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import org.tensorflow.lite.examples.classification.R;
import org.tensorflow.lite.examples.classification.models.Library;


import java.util.ArrayList;
import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.ViewHolder>{

    private  static  final String Tag = "RecyclerView";

    private  Context mContext;
    private ArrayList<Library> librarylist;

    public LibraryAdapter(Context mContext, ArrayList<Library> librarylist) {
        this.mContext = mContext;
        this.librarylist = librarylist;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.library_row_item,parent,false
        );

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.TreeName.setText(librarylist.get(position).getTreeName());
        holder.ScientificName.setText(librarylist.get(position).getScientificName());

        Glide.with(mContext).load(librarylist.get(position).getTreeImage())
                .into(holder.TreeImage);
    }

    @Override
    public int getItemCount() {
        return librarylist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        //
        ImageView TreeImage ;
        TextView  TreeName;
        TextView  ScientificName;



        public ViewHolder(@NonNull View itemView){

            super(itemView);

            TreeImage = itemView.findViewById(R.id.treeImage);
            TreeName = itemView.findViewById(R.id.treeName);
            ScientificName = itemView.findViewById(R.id.scientificName);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent LibraryActivity = new Intent(mContext, org.tensorflow.lite.examples.classification.LibraryActivity.class);
                    int position = getAdapterPosition();

                    LibraryActivity.putExtra("treename",librarylist.get(position).getTreeName());
                    LibraryActivity.putExtra("treeimage",librarylist.get(position).getTreeImage());
                    LibraryActivity.putExtra("scientificname",librarylist.get(position).getScientificName());
                    LibraryActivity.putExtra("treedescription",librarylist.get(position).getDescription());
                    LibraryActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(LibraryActivity);

                }
            });
        }
    }


}

