package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @desc   生成验证码的工具类
 * @author wyh
 * @time   2022-01-06
 */
public class CodeUtils {
public static void main(String[] args) {
	
         	for(int i =0;i<100;i++)
         	{
         		  createCode();
         		
         	}
	
	
}

public static String createCode()
{
String[] beforeShuffle = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }; 
List<String> list=Arrays.asList(beforeShuffle);

Collections.shuffle(list);//自动洗牌

StringBuilder sb=new StringBuilder();

for(int i =0;i<list.size();i++)
{
	sb.append(list.get(i));
}

String resultStr = sb.toString();
String result = resultStr.substring(5,9);
System.out.println(result);
return result;
}


}
