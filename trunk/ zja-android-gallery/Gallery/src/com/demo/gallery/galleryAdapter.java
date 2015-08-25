package com.demo.gallery;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

    public class galleryAdapter extends BaseAdapter{
    	private Context mContext;
    	private ArrayList<Integer> imgList = new ArrayList<Integer>();
    	private ArrayList<Object> imgSizes = new ArrayList<Object>();
    	
    	private int selectItem;
    	
    	public galleryAdapter(Context c)throws IllegalArgumentException, IllegalAccessException{
    		mContext = c;
    	}
    	
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imgList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		
		public void setSelectItem(int selectItem){
			if (this.selectItem != selectItem) {
				this.selectItem = selectItem;
				notifyDataSetChanged();
			}
		}
		public void setImageList(ArrayList<Integer> arrayList){
			imgList = arrayList;
		}
		
		@Override
		public View getView(int position, View couvertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageViewExt i = new ImageViewExt(mContext);
			
			if (selectItem == position) {
				
				Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.scale);
				i.setLayoutParams(new Gallery.LayoutParams(110,110));
				i.startAnimation(animation);
				i.setImageResource(imgList.get(position).intValue());
			}
			else{
				i.setImageResource(imgList.get(position).intValue());
				i.setLayoutParams(new Gallery.LayoutParams(100, 100));
				
			}
			
			i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
			i.setBackgroundColor(Color.WHITE);
			
			return i;
		}
    	
    }