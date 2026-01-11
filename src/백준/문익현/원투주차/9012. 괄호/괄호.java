package 백준.문익현

import java.io.*;
import java.util.*;

public class Main{

    private static String[] solution;
	public static void main(String args[]){
      Scanner sc = new Scanner(System.in);

      int cnt;

      cnt = sc.nextInt();
      solution = new String[cnt];
      sc.nextLine();
      for(int i =0; i<cnt; i++){
        String x = sc.nextLine();
        char[] input = x.toCharArray();
        NumStack ns = new NumStack(x.length());
       for(int number : input){
         if(ns.empty())
           ns.push(number);
         else
         {
           if(ns.peak()==40){
             if(number == 41)
               ns.pop();
             else
               ns.push(number);
           }
           else
             ns.push(number);
         }
       }
        if(ns.empty()){
          solution[i] = "YES";
        }
        else
          solution[i] = "NO";
      }

      for(int i =0; i<cnt; i++){
        System.out.println(solution[i]);
      }

      return;
}

public static class NumStack{
  int top;
  int size;
  int[] stack;
  
  NumStack(int size){
    top = -1;
    this.size = size;
    stack = new int[size];
  }

  public void push(int number){
    stack[++top] = number;
  }

  public void pop(){
    stack[top--] = 0;
  }

  public int peak(){
    if (top!=-1)
    return stack[top];
    else
      return 0;
  }

  public boolean empty(){
    if(top == -1){
      return true;
    }
    else
      return false;
  }
}
}