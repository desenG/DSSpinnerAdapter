package com.example.desen.dsspinneradapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by desen on 2016-10-27.
 */

public class DSSpinnerAdapter<T> extends ArrayAdapter<T> {

    protected List<T> objects;
    private Context context;
    private LayoutInflater inflater;

    private String title;
    private List<DSButton>buttons;

    public DSSpinnerAdapter(Context context, int resourceId,
                                 List<T> objects) {
        super(context, resourceId, objects);
        this.objects = objects;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public DSSpinnerAdapter(Context context, int resourceId,
                            List<T> objects,String title, List<DSButton>buttons) {
        this(context, resourceId, objects);
        this.title = title;
        this.buttons = buttons;

        if(buttons != null && buttons.size() > 0)
        {
            objects.add(null);
        }

        if(title != null && title.length() > 0)
        {
            objects.add(null);
        }
    }

    @Override
    public int getCount()
    {
        if(title != null && title.length() > 0)
        {
            return super.getCount()-1;
        }
        return super.getCount();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomDropDownView(position, convertView, parent);
    }

    public View getCustomDropDownView(int position, View convertView, ViewGroup parent) {

        TempViewHolder tempViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_spinner_content, parent, false);
            tempViewHolder = new TempViewHolder();

            //container
            tempViewHolder.mainContent = (RelativeLayout) convertView.findViewById(R.id.main_content);
            tempViewHolder.noneContent = (LinearLayout) convertView.findViewById(R.id.none_content);
            tempViewHolder.rowContent = (LinearLayout) convertView.findViewById(R.id.row_content);

            convertView.setTag(tempViewHolder);

        } else {
            tempViewHolder = (TempViewHolder) convertView.getTag();
        }

        if ( buttons != null && buttons.size() > 0 && position == getCount() - 1) {
            //set the visibility of the different view in one layout view
            tempViewHolder.mainContent.setVisibility(View.GONE);
            tempViewHolder.noneContent.setVisibility(View.VISIBLE);
            tempViewHolder.noneContent.removeAllViews();
            int width = parent.getWidth()/buttons.size();
            int i = 0;
            for(DSButton button : buttons)
            {
                Button copybutton = new Button(context);
                copybutton.setText(button.getText());
                copybutton.setBackgroundColor(Color.TRANSPARENT);
                copybutton.setOnClickListener(button.getmOnClickListener());
                if(i != buttons.size()-1)
                copybutton.setBackgroundResource(R.drawable.rightborderbox);
                copybutton.setWidth(width);
                tempViewHolder.noneContent.addView(copybutton);
                i++;
            }


        } else {
            //set the visibility of the different view in one layout view
            tempViewHolder.mainContent.setVisibility(View.VISIBLE);
            tempViewHolder.noneContent.setVisibility(View.GONE);

            TextView lable = new TextView(context);
            if(objects.get(position) == null)
            {
                lable.setText(title);
                lable.setTextColor(ColorManager.getBlackSecondary(context));
            }
            else
            {
                lable.setText(objects.get(position).toString());
            }
            tempViewHolder.rowContent.removeAllViews();
            tempViewHolder.rowContent.addView(lable);
        }

        return convertView;
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        //the threshold object from the database
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_spinner_content, parent, false);

        TempViewHolder tempViewHolder;
        tempViewHolder = new TempViewHolder();

        tempViewHolder.mainContent = (RelativeLayout) convertView.findViewById(R.id.main_content);
        tempViewHolder.noneContent = (LinearLayout) convertView.findViewById(R.id.none_content);
        tempViewHolder.rowContent = (LinearLayout) convertView.findViewById(R.id.row_content);

        tempViewHolder.mainContent.setVisibility(View.VISIBLE);
        tempViewHolder.noneContent.setVisibility(View.GONE);

        TextView lable = new TextView(context);
        if(objects.get(position) == null)
        {
            lable.setText(title);
            lable.setTextColor(ColorManager.getBlackSecondary(context));
        }
        else
        {
            lable.setText(objects.get(position).toString());
        }
        tempViewHolder.rowContent.removeAllViews();
        tempViewHolder.rowContent.addView(lable);

        return convertView;
    }

    public List<T> getDatas() {
        return objects;
    }

    static class TempViewHolder {
        //container
        LinearLayout noneContent;
        RelativeLayout mainContent;
        LinearLayout rowContent;
    }
}
