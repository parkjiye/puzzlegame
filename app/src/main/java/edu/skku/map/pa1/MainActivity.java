package edu.skku.map.pa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] pickem = new int[1];
        pickem[0] =1;
        container=(LinearLayout)findViewById(R.id.container);
        Button btn1=(Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                pickem[0] =1;
                change(0);
            }
        });

        Button btn2=(Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                pickem[0]=2;
                change(2);
            }
        });

        Button shf=(Button)findViewById(R.id.shuffle);
        shf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(pickem[0]==1){
                    change(3);
                }
                else{
                    change(4);
                }
            }
        });
    }

    private void change(int button){
        LinearLayout frame=(LinearLayout)findViewById(R.id.container);
        if(frame.getChildCount()>0){
            frame.removeViewAt(0);
        }

        if(button==0){//3x3 initial
            LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.threebythree,container,true);

            GridView gridView=(GridView)findViewById(R.id.gridview);
            ImageAdapter adapter1 = new ImageAdapter(this);
            gridView.setAdapter(adapter1);
            //gridView.setAdapter(new ImageAdapter(this));

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int check=0;
                    Check.three(position, mThumbs3);
                    check++;

                    gridView.setAdapter(adapter1);

                    if(mThumbs3[0]==R.drawable.three1&&mThumbs3[1]==R.drawable.three2&&mThumbs3[2]==R.drawable.three3&&
                            mThumbs3[3]==R.drawable.three4&&mThumbs3[4]==R.drawable.three5&&mThumbs3[5]==R.drawable.three6&&
                            mThumbs3[6]==R.drawable.three7&&mThumbs3[7]==R.drawable.three8&&mThumbs3[8]==R.drawable.three9&&check>0){
                        Toast.makeText(getApplicationContext(), "FINISHED!", Toast.LENGTH_LONG).show();
                        check=0;
                    }
                }
            });
        }

        if(button==2){//4x4 initial
            LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.fourbyfour,container,true);

            GridView gridView=(GridView)findViewById(R.id.gridview);
            ImageAdapter3 adapter1 = new ImageAdapter3(this);
            gridView.setAdapter(adapter1);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int check=0;
                    Check.four(position, mThumbs4);
                    check++;

                    gridView.setAdapter(adapter1);
                    if(mThumbs4[0]==R.drawable.four1&&mThumbs4[1]==R.drawable.four2&&mThumbs4[2]==R.drawable.four3&&mThumbs4[3]==R.drawable.four4&&
                            mThumbs4[4]==R.drawable.four5&&mThumbs4[5]==R.drawable.four6&&mThumbs4[6]==R.drawable.four7&&mThumbs4[7]==R.drawable.four8&&
                            mThumbs4[8]==R.drawable.four9&&mThumbs4[9]==R.drawable.four10&&mThumbs4[10]==R.drawable.four11&&mThumbs4[11]==R.drawable.four12&&
                            mThumbs4[12]==R.drawable.four13&&mThumbs4[13]==R.drawable.four14&&mThumbs4[14]==R.drawable.four15&&mThumbs4[15]==R.drawable.four16&&check>0){
                        Toast.makeText(getApplicationContext(), "FINISHED!", Toast.LENGTH_LONG).show();
                        check=0;
                    }
                }
            });
        }

        if(button==3){//3x3 random
            LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.threebythree,container,true);

            GridView gridView=(GridView)findViewById(R.id.gridview);
            ImageAdapter2 adapter1 = new ImageAdapter2(this);
            gridView.setAdapter(adapter1);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Check.three(position, mThumbs3);
                    gridView.setAdapter(adapter1);
                    if(mThumbs3[0]==R.drawable.three1&&mThumbs3[1]==R.drawable.three2&&mThumbs3[2]==R.drawable.three3&&
                            mThumbs3[3]==R.drawable.three4&&mThumbs3[4]==R.drawable.three5&&mThumbs3[5]==R.drawable.three6&&
                            mThumbs3[6]==R.drawable.three7&&mThumbs3[7]==R.drawable.three8&&mThumbs3[8]==R.drawable.three9){
                        Toast.makeText(getApplicationContext(), "FINISHED!", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

        if(button==4){//4x4 random
            LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.fourbyfour,container,true);

            GridView gridView=(GridView)findViewById(R.id.gridview);
            ImageAdapter4 adapter1 = new ImageAdapter4(this);
            gridView.setAdapter(adapter1);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Check.four(position, mThumbs4);
                    gridView.setAdapter(adapter1);
                    if(mThumbs4[0]==R.drawable.four1&&mThumbs4[1]==R.drawable.four2&&mThumbs4[2]==R.drawable.four3&&mThumbs4[3]==R.drawable.four4&&
                            mThumbs4[4]==R.drawable.four5&&mThumbs4[5]==R.drawable.four6&&mThumbs4[6]==R.drawable.four7&&mThumbs4[7]==R.drawable.four8&&
                            mThumbs4[8]==R.drawable.four9&&mThumbs4[9]==R.drawable.four10&&mThumbs4[10]==R.drawable.four11&&mThumbs4[11]==R.drawable.four12&&
                            mThumbs4[12]==R.drawable.four13&&mThumbs4[13]==R.drawable.four14&&mThumbs4[14]==R.drawable.four15&&mThumbs4[15]==R.drawable.four16){
                        Toast.makeText(getApplicationContext(), "FINISHED!", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
    int [] mThumbs3={
            R.drawable.three1, R.drawable.three2, R.drawable.three3,
            R.drawable.three4, R.drawable.three5, R.drawable.three6,
            R.drawable.three7, R.drawable.three8, R.drawable.three9
    };

    int [] mThumbs4={
            R.drawable.four1, R.drawable.four2, R.drawable.four3, R.drawable.four4,
            R.drawable.four5, R.drawable.four6, R.drawable.four7, R.drawable.four8,
            R.drawable.four9, R.drawable.four10,R.drawable.four11,R.drawable.four12,
            R.drawable.four13,R.drawable.four14,R.drawable.four15,R.drawable.four16
    };

    public static class Switch{
        public static void three(int[] arr, int loc, int status){
            arr[status]=arr[loc];
            arr[loc]=R.drawable.three9;
        };
        public static void four(int[] arr, int loc, int status){
            arr[status]=arr[loc];
            arr[loc]=R.drawable.four16;
        }
        public static void random(int[] arr, int loc, int status){
            int x=arr[loc];
            arr[loc]=arr[status];
            arr[status]=x;
        }
    }

    public static class MIX{
        public static void mix(int[] data){
            Random number = new Random();
            for(int i=data.length-1; i>0; i--) {
                int value = number.nextInt(i + 1);
                if (value==i) {
                    ++i;
                }
                else {
                    Switch.random(data, value, i);
                }
            }
        }
    }
    public class ImageAdapter extends BaseAdapter{//3x3 initial
        private Context mContext;
        public ImageAdapter(Context c){
            mContext=c;
            mThumbs3=firstthree;
        }
        public int getCount(){
            return mThumbs3.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imgView;
            if(convertView==null){
                imgView=new ImageView(mContext);
                imgView.setLayoutParams(new ViewGroup.LayoutParams(330,330));
                imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imgView.setPadding(0,0,0,0);
            }
            else{
                imgView=(ImageView)convertView;
            }
            imgView.setImageResource(mThumbs3[position]);
            return imgView;
        }

        int [] firstthree={
                R.drawable.three1, R.drawable.three2, R.drawable.three3,
                R.drawable.three4, R.drawable.three5, R.drawable.three6,
                R.drawable.three7, R.drawable.three8, R.drawable.three9
        };
    }
    public class ImageAdapter2 extends BaseAdapter{//3x3 shuffle
        private Context mContext;
        public ImageAdapter2(Context c){
            mContext=c;
            MIX.mix(mThumbs3);
        }
        public int getCount(){
            return mThumbs3.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imgView;
            //Collections.shuffle(Arrays.asList(mThumbs3));
            if(convertView==null){
                imgView=new ImageView(mContext);
                imgView.setLayoutParams(new ViewGroup.LayoutParams(330,330));
                imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imgView.setPadding(0,0,0,0);
            }
            else{
                imgView=(ImageView)convertView;
            }
            imgView.setImageResource(mThumbs3[position]);
            return imgView;
        }
    }

    public class ImageAdapter3 extends BaseAdapter{//4x4 initial
        private Context mContext;
        public ImageAdapter3(Context c){
            mContext=c;
            mThumbs4=firstfour;
        }
        public int getCount(){
            return mThumbs4.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imgView;
            if(convertView==null){
                imgView=new ImageView(mContext);
                imgView.setLayoutParams(new ViewGroup.LayoutParams(225,225));
                imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imgView.setPadding(0,0,0,0);
            }
            else{
                imgView=(ImageView)convertView;
            }
            //Collections.shuffle(Arrays.asList(mThumbs));
            imgView.setImageResource(mThumbs4[position]);
            return imgView;
        }
        int [] firstfour={
                R.drawable.four1, R.drawable.four2, R.drawable.four3, R.drawable.four4,
                R.drawable.four5, R.drawable.four6, R.drawable.four7, R.drawable.four8,
                R.drawable.four9, R.drawable.four10,R.drawable.four11,R.drawable.four12,
                R.drawable.four13,R.drawable.four14,R.drawable.four15,R.drawable.four16
        };
    }

    public class ImageAdapter4 extends BaseAdapter{//4x4 random
        private Context mContext;
        public ImageAdapter4(Context c){
            mContext=c;
            MIX.mix(mThumbs4);
        }
        public int getCount(){
            return mThumbs4.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imgView;
            //shuffle(mThumbs4);
            if(convertView==null){
                imgView=new ImageView(mContext);
                imgView.setLayoutParams(new ViewGroup.LayoutParams(225,225));
                imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imgView.setPadding(0,0,0,0);
            }
            else{
                imgView=(ImageView)convertView;
            }
            imgView.setImageResource(mThumbs4[position]);
            return imgView;
        }

    }

    public static class Check{
        public static void three(int position, int [] mThumbs3){
            int white=R.drawable.three9;
            if(position==0){
                if(mThumbs3[1]==white){
                    Switch.three(mThumbs3, position, 1);
                }
                if(mThumbs3[3]==white){
                    Switch.three(mThumbs3, position, 3);
                }
            }
            if(position==1){
                if(mThumbs3[0]==white){
                    Switch.three(mThumbs3, position, 0);
                }
                if(mThumbs3[2]==white){
                    Switch.three(mThumbs3, position, 2);
                }
                if(mThumbs3[4]==white){
                    Switch.three(mThumbs3, position, 4);
                }
            }
            if(position==2){
                if(mThumbs3[1]==white){
                    Switch.three(mThumbs3, position, 1);
                }
                if(mThumbs3[5]==white){
                    Switch.three(mThumbs3, position, 5);
                }
            }
            if(position==3){
                if(mThumbs3[0]==white){
                    Switch.three(mThumbs3, position, 0);
                }
                if(mThumbs3[4]==white){
                    Switch.three(mThumbs3, position, 4);
                }
                if(mThumbs3[6]==white){
                    Switch.three(mThumbs3, position, 6);
                }
            }
            if(position==4){
                if(mThumbs3[1]==white){
                    Switch.three(mThumbs3, position, 1);
                }
                if(mThumbs3[3]==white){
                    Switch.three(mThumbs3, position, 3);
                }
                if(mThumbs3[5]==white){
                    Switch.three(mThumbs3, position, 5);
                }
                if(mThumbs3[7]==white){
                    Switch.three(mThumbs3, position, 7);
                }
            }
            if(position==5){
                if(mThumbs3[2]==white){
                    Switch.three(mThumbs3, position, 2);
                }
                if(mThumbs3[4]==white){
                    Switch.three(mThumbs3, position, 4);
                }
                if(mThumbs3[8]==white){
                    Switch.three(mThumbs3, position, 8);
                }
            }
            if(position==6){
                if(mThumbs3[3]==white){
                    Switch.three(mThumbs3, position, 3);
                }
                if(mThumbs3[7]==white){
                    Switch.three(mThumbs3, position, 7);
                }
            }
            if(position==7){
                if(mThumbs3[6]==white){
                    Switch.three(mThumbs3, position, 6);
                }
                if(mThumbs3[4]==white){
                    Switch.three(mThumbs3, position, 4);
                }
                if(mThumbs3[8]==white){
                    Switch.three(mThumbs3, position, 8);
                }
            }
            if(position==8){
                if(mThumbs3[5]==white){
                    Switch.three(mThumbs3, position, 5);
                }
                if(mThumbs3[7]==white){
                    Switch.three(mThumbs3, position, 7);
                }
            }
        }

        public static void four (int position, int [] mThumbs4){
            int white=R.drawable.four16;
            if(position==0){
                if(mThumbs4[1]==white){
                    Switch.four(mThumbs4, position, 1);
                }
                if(mThumbs4[4]==white){
                    Switch.four(mThumbs4, position, 4);
                }
            }
            if(position==1||position==2){
                if(mThumbs4[position-1]==white){
                    Switch.four(mThumbs4, position, position-1);
                }
                if(mThumbs4[position+1]==white){
                    Switch.four(mThumbs4, position, position+1);
                }
                if(mThumbs4[position+4]==white){
                    Switch.four(mThumbs4, position, position+4);
                }
            }
            if(position==3){
                if(mThumbs4[2]==white){
                    Switch.four(mThumbs4, position, 2);
                }
                if(mThumbs4[7]==white){
                    Switch.four(mThumbs4, position, 7);
                }
            }
            if(position==4||position==8){
                if(mThumbs4[position-4]==white){
                    Switch.four(mThumbs4, position, position-4);
                }
                if(mThumbs4[position+1]==white){
                    Switch.four(mThumbs4, position, position+1);
                }
                if(mThumbs4[position+4]==white){
                    Switch.four(mThumbs4, position, position+4);
                }
            }
            if(position==5||position==6||position==9||position==10){
                if(mThumbs4[position-4]==white){
                    Switch.four(mThumbs4, position, position-4);
                }
                if(mThumbs4[position-1]==white){
                    Switch.four(mThumbs4, position, position-1);
                }
                if(mThumbs4[position+1]==white){
                    Switch.four(mThumbs4, position, position+1);
                }
                if(mThumbs4[position+4]==white){
                    Switch.four(mThumbs4, position, position+4);
                }
            }
            if(position==7||position==11){
                if(mThumbs4[position-4]==white){
                    Switch.four(mThumbs4, position, position-4);
                }
                if(mThumbs4[position-1]==white){
                    Switch.four(mThumbs4, position, position-1);
                }
                if(mThumbs4[position+4]==white){
                    Switch.four(mThumbs4, position, position+4);
                }
            }
            if(position==12){
                if(mThumbs4[8]==white){
                    Switch.four(mThumbs4, position, 8);
                }
                if(mThumbs4[13]==white){
                    Switch.four(mThumbs4, position, 13);
                }
            }
            if(position==13||position==14){
                if(mThumbs4[position-4]==white){
                    Switch.four(mThumbs4, position, position-4);
                }
                if(mThumbs4[position-1]==white){
                    Switch.four(mThumbs4, position, position-1);
                }
                if(mThumbs4[position+1]==white){
                    Switch.four(mThumbs4, position, position+1);
                }
            }
            if(position==15){
                if(mThumbs4[position-4]==white){
                    Switch.four(mThumbs4, position, position-4);
                }
                if(mThumbs4[position-1]==white){
                    Switch.four(mThumbs4, position, position-1);
                }
            }
        }
    }
}