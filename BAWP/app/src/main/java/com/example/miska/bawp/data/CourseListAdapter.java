package com.example.miska.bawp.data;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miska.bawp.R;
import com.example.miska.bawp.model.Course;
import com.squareup.picasso.Picasso;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder>  {

    private CourseData courseData = new CourseData();
    public OnItemClickListener itemClickListener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View courseRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_row, parent, false);
        return new ViewHolder(courseRow);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Course course = courseData.courseList().get(position);
        holder.courseTitle.setText(course.getCourseName());
        Picasso.with(holder.courseTitle.getContext())
                .load(course.getImageResourceID(holder.courseTitle.getContext()))
                .into(holder.couseImageView);
        Picasso.with(holder.courseTitle.getContext())
                .load(course.getImageResourceID(holder.courseTitle.getContext()))
                .into(holder.authorImageView);
    }

    @Override
    public int getItemCount() {
        return courseData.courseList().size();
    }

    public void setOnClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView courseTitle;
        public ImageView couseImageView, authorImageView;

        ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            courseTitle = itemView.findViewById(R.id.courseTitleId);
            couseImageView = itemView.findViewById(R.id.courseImageId);
            authorImageView = itemView.findViewById(R.id.authorImageID);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.OnItemClick(view, getAdapterPosition());
        }
    }

    public interface OnItemClickListener{
        void OnItemClick(View view, int position);
    }
}
