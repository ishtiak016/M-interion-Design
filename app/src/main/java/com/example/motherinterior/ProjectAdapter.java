package com.example.motherinterior;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {
    private Context mContext;
    private ArrayList<ProjectItem> mProjectList;
    private ProjectAdapter.OnItemClickListener mListener;
    public interface OnItemClickListener{
        void OnItemClick(int position);
    }
    public void setOnClickListener (OnItemClickListener listener){
        mListener=listener;
    }
    public ProjectAdapter(Context context, ArrayList<ProjectItem> projectList) {
        mContext = context;
        mProjectList = projectList;

    }
    public ProjectAdapter.ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate( R.layout.project_item,parent,false);
        return new ProjectViewHolder(v);
    }

    @Override

    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        ProjectItem currentItem=mProjectList.get(position);
        String imageUrl=currentItem.getMimage();
        String projectName=currentItem.getMproject_name();
        String mDescription=currentItem.getMdescription();
        String mLocation=currentItem.getMlocation();

       // holder.mTextViewProjectName.setText(""+projectName);
        holder.mTextViewDescription.setText(""+mDescription);
        holder.mTextViewLocation.setText(""+mLocation);
        Picasso.with(mContext).load(imageUrl).fit().centerCrop() .into(holder.mImageView);


    }
    @Override
    public int getItemCount() {
        return mProjectList.size();
    }
    public class ProjectViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewProjectName;
        public TextView mTextViewDescription;
        public TextView mTextViewLocation;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewProjectName = itemView.findViewById(R.id.text_view_project_name);
            mTextViewDescription = itemView.findViewById(R.id.text_view_decription);
            mTextViewLocation=itemView.findViewById((R.id.text_view_location));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
