package com.eemc.aida.views;
import android.view.*;
import android.content.*;
import android.graphics.*;
import java.util.*;
import android.widget.*;
import com.eemc.aida.*;

public class AIDAView extends View
{
	Paint p=new Paint();
	
	static HashMap<Integer,Integer> colors=new HashMap<Integer,Integer>();
	
	public AIDAView(Context con){
		super(con);
	}

	@Override
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
	/*
		 82b9e6:	b580      	push	{r7, lr}
		 82b9e8:	f662 ebb0 	blx	68e14c <_ZN19AppPlatformListenerD2Ev@plt>
		 82b9ec:	e8bd 4080 	ldmia.w	sp!, {r7, lr}
		 82b9f0:	f2c9 bc12 	b.w	af5218 <_ZNSt6vectorI14EntityUniqueIDSaIS0_EE19_M_emplace_back_auxIJRKS0_EEEvDpOT_+0x1ae>
	*/
		drawText(canvas,"§0h§1e§2l§3l§4o §2wro§4ld",0,30,30);
	}
	
	void drawText(Canvas canvas,String text,float x,float y,float size){
		p.setColor(0xff000000);
		p.setTextSize(size);
		
		int i=0;
		float xoffset=0;
		char[]c=text.toCharArray();
		StringBuilder sb=new StringBuilder("");
		while(i<text.length()){
			char c2=c[i++];
			if(c2=='§'){
				canvas.drawText(sb.toString(),x+xoffset,y,p);
				xoffset+=p.measureText(sb.toString());
				sb.delete(0,sb.length());
				p.setColor(colors.get(c[i++]-'0'));
			}else{
				sb.append(c2);
			}
		}
		
		canvas.drawText(sb.toString(),x+xoffset,y,p);
	}
	static{
		colors.put(0,0xff000000);
		colors.put(1,0xffff1111);
		colors.put(2,0xff11ff11);
		colors.put(3,0xff1111ff);
		colors.put(4,0xff2b58a9);
	}
}
