package fengras.com.fengran1502l0410.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/4/10.
 */
public class Myprogress extends View {
    //声明画笔
    private Paint mpaint,m2paint,tpaint;
    private float length;
    private int progress;
    private RectF rect;
    //给文本初始值
    private String text="0%";
    //主线程
    private Handler hander=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progress++;
            //每次都重新绘制
            invalidate();
            if(progress<360){
                //每次调用
                hander.sendEmptyMessageDelayed(0,50);
            }
        }
    };

    public Myprogress(Context context) {
        super(context);
        //初始化画笔
        initview();
    }

    private void initview() {
        mpaint=new Paint();
        mpaint.setColor(Color.GREEN);
        mpaint.setStrokeWidth(50);
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setAntiAlias(true);




        m2paint=new Paint();
        m2paint.setColor(Color.YELLOW);
        m2paint.setStrokeWidth(40);
        m2paint.setStyle(Paint.Style.STROKE);
        m2paint.setAntiAlias(true);



        tpaint=new Paint();
        tpaint.setColor(Color.RED);
        tpaint.setStrokeWidth(0);
        tpaint.setStyle(Paint.Style.STROKE);
        tpaint.setAntiAlias(true);

    }

    public Myprogress(Context context, AttributeSet attrs) {
        super(context, attrs);
        initview();
    }

    public Myprogress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制圆环 并且给text赋值
        text=(int)(progress*100/360)+"%";
        //实例化出矩形四个点
        rect=new RectF((float)(length*0.1),(float)(length*0.1),(float)(length*0.9),(float)(length*0.9));
          //起始位置
        canvas.drawArc(rect,0,360,false,mpaint);
        canvas.drawArc(rect,0,progress,false,m2paint);
        //测量字体宽度，我们需要根据字体的宽度设置在圆环中间
        float textWidth = tpaint.measureText(text);
        //设置字体的位置    为圆环的中心位置
        canvas.drawText(text, (int) (length / 2 - textWidth / 2), (int) (length / 2 + textWidth / 2), tpaint);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
       //当宽度发生改变时 回调的方法
        length=w;


    }
    public void setprogress(){
        //hander发送延时消息
        hander.sendEmptyMessageDelayed(0,50);

    }
    public void resetprogress(){
        //重新设置进度
        progress=0;
        hander.removeMessages(0);
        setprogress();
    }
}
