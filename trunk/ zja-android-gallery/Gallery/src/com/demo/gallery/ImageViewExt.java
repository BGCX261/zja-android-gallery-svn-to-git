package com.demo.gallery;
import android.R.integer;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ImageViewExt extends ImageView{
	private int color;
	
	public ImageViewExt(Context context){
		super(context);
		color = Color.GRAY;
	}
	
	public ImageViewExt(Context context,AttributeSet attrs) {
		super(context,attrs);
		color = Color.GRAY;
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		//»­±ß¿ò
		Rect rect = canvas.getClipBounds();
		rect.bottom--;
		rect.right--;
		Paint paint = new Paint();
		paint.setColor(color);
		paint.setStrokeWidth(5);
		paint.setStyle(Paint.Style.STROKE);
		canvas.drawRect(rect, paint);
	}
	
	public void setColor(int xColor) {
		color = xColor;
	}
}