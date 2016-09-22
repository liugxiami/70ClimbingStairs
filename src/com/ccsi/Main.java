package com.ccsi;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(climbStairs2(5));
    }
    //You are climbing a stair case. it takes n steps to reach to the top.
    //Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    //1.递推      也可以用一数组来储存，空间0（N）
    public static int climbStairs(int n){
        if(n<=2)return n;
        int p=1,q=2;
        for (int i = 3; i <=n; i++) {
            int temp=p+q;
            p=q;
            q=temp;
        }
        return q;
    }
    //2.递归
    public static int climbStairs1(int n){
        if(n<=2)return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }
    //3.DP                    //因为有子问题重叠
    public static int climbStairs2(int n){
        Map<Integer,Integer> cache=new HashMap<>();
        return core(n,cache);
    }
    public static int core(int n,Map<Integer,Integer> cache){
        if(n>=1)cache.put(1,1);
        if(n>=2)cache.put(2,2);
        if(!cache.containsKey(n)){
            cache.put(n,core(n-1,cache)+core(n-2,cache));
        }
        return cache.get(n);
    }
}
