package utils;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class BitmapCache implements ImageCache{

	private LruCache<String, Bitmap> mCache;  
	
	  public BitmapCache() {  
	        int maxSize = 10 * 1024 * 1024;  //将缓存图片的大小设置为10M
	        mCache = new LruCache<String, Bitmap>(maxSize) {  
	            @Override  
	            protected int sizeOf(String key, Bitmap bitmap) {  
	                return bitmap.getRowBytes() * bitmap.getHeight();  
	            }  
	        };  
	    }  
	  
	@Override
	public Bitmap getBitmap(String url) {
		// TODO Auto-generated method stub
		return mCache.get(url);  
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		// TODO Auto-generated method stub
		mCache.put(url, bitmap);
	}

}
