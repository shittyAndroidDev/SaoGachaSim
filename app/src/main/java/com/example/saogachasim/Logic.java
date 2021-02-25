package com.example.saogachasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Pair;

public class Logic {


    private Logic(){
    }
    public static int[] scout(int bannerNum, int max){
        double roll = Math.random();
        if(bannerNum>=80){
            if(roll <=0.03){
                int ch = (int)(Math.random()*(max+0.99));
                return new int[]{bannerNum,6,ch};
            }else if(0.03 < roll && roll <=0.06){
                int banner = (int) ((Math.random() * (79 - 33)) + 33);
                int max5 = MainActivity.m[banner];
                int ch =(int)(Math.random()*(max5+0.99));
                return new int[]{banner,5,ch};
            }else if(0.06 < roll && roll <= 0.10){
                int banner = (int) ((Math.random() * (32 - 1)) + 1);
                int max4 = MainActivity.m[banner];
                int ch =(int)(Math.random()*(max4+0.99));
                return new int[]{banner,4,ch};
            }else if(0.10 < roll && roll <=0.35){
                int ch = (int)(Math.random()*29.99);
                return new int[]{-1,3,ch};
            }else{
                int ch = (int)(Math.random()*20.99);
                return new int[]{-1,2,ch};
            }
        }else if(33<=bannerNum){
            if(roll<=0.03){
                int ch = (int)(Math.random()*(max+0.99));
                return new int[]{bannerNum,5,ch};
            }else if(0.03<roll && roll <= 0.07){
                int banner = (int) ((Math.random() * (32 - 1)) + 1);
                int max4 = MainActivity.m[banner];
                int ch =(int)(Math.random()*(max4+0.99));
                return new int[]{banner,4,ch};
            }else if(0.07<roll && roll < 0.32){
                int ch = (int)(Math.random()*29.99);
                return new int[]{-1,3,ch};
            }else{
                int ch = (int)(Math.random()*20.99);
                return new int[]{-1,2,ch};
            }
        }else{
            if(roll<=0.04){
                int ch = (int)(Math.random()*(max+0.99));
                return new int[]{bannerNum,4,ch};
            }else if(0.04<roll && roll<=0.29){
                int ch = (int)(Math.random()*(29.99));
                return new int[]{-1,3,ch};
            }else{
                int ch = (int)(Math.random()*20.99);
                return new int[]{-1,2,ch};
            }
        }

    }

    public static Pair<String,String> constructName(int[] data){
        String fullImage=null;
        String thumbnail=null;

        if(data[1]==2){
            fullImage = "s2_"+data[2];
            thumbnail = "s2_t"+data[2];
        }else if(data[1]==3){
            fullImage = "s3_"+data[2];
            thumbnail = "s3_t"+data[2];
        }else if(data[1]==4){
            if(data[0]<10){
                fullImage = "b00"+data[0]+"_"+data[2];
                thumbnail = "b00"+data[0]+"_"+"t"+data[2];
            }else{
                fullImage = "b0"+data[0]+"_"+data[2];
                thumbnail = "b0"+data[0]+"_"+"t"+data[2];
            }
        }else if(data[1]==5){
            fullImage = "b0"+data[0]+"_"+data[2];
            thumbnail = "b0"+data[0]+"_"+"t"+data[2];
        }else if(data[1]==6){
            if(data[0]<100){
                fullImage = "b0"+data[0]+"_"+data[2];
                thumbnail = "b0"+data[0]+"_"+"t"+data[2];
            }else{
                fullImage = "b"+data[0]+"_"+data[2];
                thumbnail = "b"+data[0]+"_"+"t"+data[2];
            }
        }
        return new Pair<>(thumbnail,fullImage);
    }
    public static String getBanner(int bannerNum){
        String s;
        if(bannerNum<10){
            s="b00";
        }else if(bannerNum>=100){
            s="b";
        }else s = "b0";
        return s+bannerNum+"_scout_top";
    }

    public static Drawable getImg(String name, Context context){
        int id = context.getResources().getIdentifier(name,"drawable",context.getPackageName());
        return context.getResources().getDrawable(id,null);
    }
}
