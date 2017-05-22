/**
 * Created by Administrator on 2017/5/22 0022.
 */
import java.util.Scanner;
public class BowlingGame {
     public int getBowlingScore(String bowlingCode) {
          int count=0;
        int len=bowlingCode.length();
        String s1="";
        String s2="";
        if(bowlingCode.charAt(length=="\\|")){
            s1=bowlingCode.subString(0,len-2);  //前十个
        }
        else{
            s1=bowlingCode.split("\\|\\|")[0];  //qianshi
            s2=bowlingCode.split("\\|\\|")[1];
        }
        String[] score=s1.split("\\|");
        int[][] corrent = new int[11][4];
        if(s2!=""){
            for(int i=0;i<s2.length();i++)
                corrent[11][i]=s2.charAt(j) - '0';
        }
        for (int i = 0; i < 10; i++) {//循环10轮
            if (score[i] == "X") {
                corrent[i][0] = 10;
                corrent[i][1] = 10;

            } else {
                for (int j = 0; j < 2; j++) {
                    if (score[i].charAt(j) == '-') {
                        corrent[i][j] = 0;
                        if (score[i].charAt(j) == '/') {
                            corrent[i][j] = 10 - corrent[i][j - 1];
                        } else
                            corrent[i][j] = score[i].charAt(j) - '0';
                    }

                }
                corrent[i][2]=corrent[i][0] + corrent[i][1];

            }
        }
        for (int i = 0; i < corrent.length-1; i++) {//前11轮
            if (corrent[i][0] == 10 && i != 9) {
                if (corrent[i + 1][0] == 10 && i < 8){ //前8轮，一次10分 就记后面2投球的分数
                    corrent[i][2] = corrent[i][0] + corrent[i + 1][0]  + corrent[i + 2][0];
                }else if (corrent[i + 1][0] != 10 || i == 8){//第9轮10分 记第10轮2次的分数
                    corrent[i][2] = corrent[i][0]  + corrent[i + 1][0]  + corrent[i + 1][1];
                }
            }else{
                if (corrent[i][0] + corrent[i][1] == 10 && i < 9){//前9轮 补中10分 加上下轮第一次的分数
                    corrent[i][2] = corrent[i][0] + corrent[i][1] + corrent[i + 1][0];
                }else{
                    corrent[i][2] = corrent[i][0] + corrent[i][1];//2次不足10分 就记这么多
                }
            }
        }
        //求累计积分
        corrent[0][3] = corrent[0][2];
        for(int i = 1; i < corrent.length;i++ ){
            corrent[i][3]=corrent[i][2] + corrent[i - 1][3];
        }
        return corrent[11][3];
    }
   

   

}
