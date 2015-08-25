package com.demo.gallery;

import java.lang.reflect.Field;
import java.util.ArrayList;

import android.R.integer;
import android.R.layout;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View.OnTouchListener;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ViewSwitcher.ViewFactory;
import android.widget.ImageView;



public class GalleryActivity extends Activity implements ViewFactory{
    /** Called when the activity is first created. */
	private Gallery mGallery;
	private galleryAdapter adapter;
	private Field[] fields;
	private ArrayList<Integer> imgList;
	private ImageSwitcher iSwitcher;
	private int downX,upX;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //get img list
        getImageList();
        
        
        iSwitcher = (ImageSwitcher) findViewById(R.id.switcher);
        iSwitcher.setFactory(this);
        //add touch listener
        iSwitcher.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction()==MotionEvent.ACTION_DOWN) {
					downX = (int)event.getX();
					return true;
				}
				else if (event.getAction()==MotionEvent.ACTION_UP) {
					upX = (int)event.getX();
					int index = 0;
					if(upX - downX>100){
						
					}
				}
				return false;
			}
		});
        
        
        mGallery = (Gallery)findViewById(R.id.gallery);
        try {
        	adapter = new galleryAdapter(this);
        	adapter.setImageList(imgList);
			mGallery.setAdapter(adapter);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
        
        
        // add ItemSelectedListener
        mGallery.setOnItemSelectedListener(new OnItemSelectedListener() {
        	@Override
        	public void onItemSelected(AdapterView<?> arg0, View arg1,  
                    int position, long arg3){
        		adapter.setSelectItem(position);
        		iSwitcher.setImageResource(imgList.get(position));
        	}
        	@Override
        	public void onNothingSelected(AdapterView<?> arg0) {  
                // TODO Auto-generated method stub  
            }  
        });
    }
    
    // add method
    private void getImageList(){
    	fields = R.drawable.class.getDeclaredFields();
    	imgList = new ArrayList<Integer>();
    	for(Field field:fields){
    		if (!"icon".equals(field.getName())) {
				try {
					int index = field.getInt(R.drawable.class);
					imgList.add(index);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
    	}
    }
	@Override
	public View makeView() {
		// TODO Auto-generated method stub
		ImageViewExt imageViewExt = new ImageViewExt(this);
		imageViewExt.setBackgroundColor(Color.GREEN);
		imageViewExt.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		imageViewExt.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		return imageViewExt;
	}
}