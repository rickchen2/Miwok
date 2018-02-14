package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hongyuchen on 2018-01-16.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private static  final String TAG="[WordAdapter]";
    private int mlistBackgroundColor;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words          A List of Word objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int listBackgroundColor) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        //resource ID for the background color of the list of words
        mlistBackgroundColor = listBackgroundColor;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        //Log.d(TAG,listItemView+"");

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        //Log.d(TAG,currentWord.getDefaultTranslation()+"-"+position);


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        //((TextView)listItemView.findViewById(R.id.miwok_text_view)).setTe

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());


        // Find the ImageView in the list_item.xml layout with the ID version_number
        ImageView miwokImageView = (ImageView) listItemView.findViewById(R.id.miwok_image_view);
        // Get the version number from the current Word object and
        // set image resource ID for this image view
        if (currentWord.hasImage()) {
            miwokImageView.setImageResource(currentWord.getmImageResourceId());
            //Log.d(TAG,"With Image, resource ID is " + currentWord.getmImageResourceId());
            miwokImageView.setVisibility(View.VISIBLE);
        }
        else {
            miwokImageView.setVisibility(View.GONE);
            //Log.d(TAG,"No image, resource ID is " + currentWord.getmImageResourceId());
        }
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView

        // Find the View in the list_item.xml layout with the ID version_number
        View myListView = listItemView.findViewById(R.id.list_item_main);

        //find the color the resource ID maps to
        int mycolor = ContextCompat.getColor(getContext(), mlistBackgroundColor);
        Log.d(TAG,"color passed in " + mlistBackgroundColor + "color converted" + mycolor);

        // Get the background color from the current Word Adapter constructor
        // set the background color

        myListView.setBackgroundColor(mycolor);

        return listItemView;
    }
}

