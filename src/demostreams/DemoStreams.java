/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demostreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *
 * @author veselin
 */
public class DemoStreams {

    /**
     * @param args the command line arguments
     */
    
    public static int f(int n){
        for (int i = 1; i < 10000; i++) {
            n = (n ^ i) % i;
            if (n <= 10) {
                n = 10;
            }
        }
        return n;
    }
    
    
    public static void main(String[] args) {
        
        List<Integer> data;
        data = new ArrayList<>();
        Random rnd = new Random();
        
        for (int i = 0; i < 1000000; i++) {
            System.out.println(rnd.nextInt());
            data.add(rnd.nextInt());
        }
        
       //data.stream().
       
        System.out.println("Starting");
           
//        int result = 0;
//        for (int i : data) {
//            result += f(i);
//        }
//        System.out.println(result);
        
        int result = data.parallelStream().map(i -> f(i)).reduce(Integer::sum).get();
        System.out.println(result);
    }
    
}
