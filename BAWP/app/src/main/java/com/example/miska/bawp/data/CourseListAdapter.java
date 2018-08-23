package com.example.miska.bawp.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miska.bawp.R;
import com.example.miska.bawp.model.Course;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder>  {

    private CourseData courseData = new CourseData();
    private OnItemClickListener itemClickListener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View courseRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_row, parent, false);
        return new ViewHolder(courseRow);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Context context = holder.courseTitle.getContext();
        Course course = courseData.courseList().get(position);
        holder.courseTitle.setText(course.getCourseName());
        Picasso.with(context)
                .load(course.getImageResourceID(context))
                .into(holder.courseImageView);
        Picasso.with(context)
                .load(course.getImageResourceID(context))
                .into(holder.authorImageView);
        Bitmap photo = BitmapFactory.decodeResource(context.getResources(), course.getImageResourceID(context));
        Palette.from(photo).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                int bgColor = palette.getMutedColor(ContextCompat.getColor(context, android.R.color.black));
                holder.courseTitle.setBackgroundColor(bgColor);
                holder.authorImageView.setBorderColor(bgColor);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseData.courseList().size();
    }

    public void setOnClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView courseTitle;
        ImageView courseImageView;
        CircleImageView authorImageView;

        ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            courseTitle = itemView.findViewById(R.id.courseTitleId);
            courseImageView = itemView.findViewById(R.id.courseImageId);
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
