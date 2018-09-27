/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elemialgoritmusok_12dc_2cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 *
 * @author thomas
 */
public class ElemiAlgoritmusok_12dc_2cs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] vektor = {12, 6, 7, 3, 2, 15, 14, 1, 4, 15, 13, 10, 11, 9, 8};
        int teszt = 13;
        System.out.println("Szerepel a "+teszt+" a tömbben: "+ contains(vektor,teszt));
        System.out.println("A keresett elem indexe: "+indexOf(vektor,teszt));
        felsorol(vektor);
        int [] rendezéshez = {12, 6, 7, 3, 2, 15, 14, 1, 4, 5, 13, 10, 11, 9, 8};
        System.out.println("Rendezve");
        rendezBuborék(rendezéshez);
        felsorol(rendezéshez);
        System.out.println("A vektorban 3-mal osztható számok száma: "+
                megszámlál(vektor));
        System.out.println("A maximum értéke: " +vektor[ maximum(vektor) ]);
        System.out.println("A max indexe: "+ maximum(vektor));
        maximumMind(vektor);
        int [] haromMod  = kiválogatás(vektor);
        System.out.println("Csak 3-mal oszthatók tömbje:");
        felsorol(haromMod);
        
        int [] páratlanok = new int[vektor.length];
        int strázsa = kiválogatGuard(vektor, páratlanok);
        System.out.print("Páratlanok:");
        for(int i=0; i<strázsa; i++)
            System.out.print(" "+páratlanok[i]);
        System.out.println("");
        
        int [] halmazhoz = {3,6 ,3,8, 2, 7, 10, 1,2, 2, 3, 6, 7};
        int [] halmaz = halmazKiválogatás(halmazhoz);
        felsorol(halmaz);
        int halmaz2 [] = halmazTS(halmazhoz);
        felsorol(halmaz2);
        
        int [] halmazA = {1, 3, 5, 7, 9, 12, 14, 16, 18, 20};
        int [] halmazB = {3, 7, 8, 4, 6, 10, 14, 18, 20};
    }
    
    static boolean contains(int [] tömb, int keres){
        boolean result = false;
        for(int elem: tömb)
            if(elem == keres){
                result = true;
                break;
            }
        return result;
    }
    
    static int indexOf(int [] tömb, int keres){
        int result = -1;
        for(int i=0; i<tömb.length; i++)
            if(keres == tömb[i]){
                result = i;
                break;
            }
        return result;
    }
    
    static void felsorol(int [] tömb){
        for(int i=0; i<tömb.length-1; i++)
            System.out.print(tömb[i]+" ");
        System.out.println(tömb[ tömb.length-1 ]);
    }
    
    static void rendezBuborék(int [] tömb){
        for(int i=0; i<tömb.length -1; i++)
            for(int j=0; j<tömb.length - 1; j++)
                if(tömb[j] > tömb[j+1]){
                    int tmp = tömb[j];
                    tömb[j] = tömb[j+1];
                    tömb[j+1] = tmp;
                }
    }
    
    static int megszámlál(int [] tömb){
        int darab = 0;
        for(int elem : tömb)
            if( elem % 3 == 0) //F - 3-mal osztható
                darab++;
        return darab;
    }
    
    static int maximum(int [] tömb){
        int maxHely = 0;
        for(int i=1; i<tömb.length; i++)
            if(tömb[i] > tömb[maxHely])
                maxHely = i;
        return maxHely;
    }
    
    static void maximumMind(int [] tömb){
        int maxIndex = maximum(tömb);
        System.out.print("A max elem: "+tömb[maxIndex] +
                " a következõ helyeken fordul elõ:");
        for(int i=0; i<tömb.length; i++)
            if(tömb[i] == tömb[maxIndex])
                System.out.print(" "+i);
        System.out.println("");
    }
    
    static int [] kiválogatás(int [] tömb){
        int darab = 0; //F 3-mal osztható
        for( int elem: tömb)
            if(elem % 3 == 0)
                darab++;
        
        int [] eredmény = new int[darab];
        
        int index =0;
        for( int elem: tömb)
            if(elem % 3 == 0)
                eredmény[index++] = elem;
        return eredmény;
    }
    
    static int kiválogatGuard(int [] tömb, int [] eredmény){
        int guard=0;
        for(int elem: tömb)
            if(elem % 2 == 1)
                eredmény[guard++] = elem;
        return guard;
    }
    
    static int [] halmazKiválogatás(int [] tömb){
        int guard = 0;
        int [] temp = new int [tömb.length];
        for(int elem: tömb){
            boolean talalt = false;
            for(int i=0; i<guard;i++)
                if(elem == temp[i])
                    talalt = true;
            if(!talalt)
                temp[guard++] = elem;
        }
        //Ez itt elmaradhat
        int [] result = new int [guard];
        for(int i=0; i<result.length ; i++)
            result[i] = temp[i];
        return result;
    }
    
    static int [] halmazTS(int [] tömb){
        Integer [] temp = new Integer  [tömb.length];
        for(int i=0; i<tömb.length; i++)
            temp[i] = tömb[i];
        ArrayList<Integer> segéd = new ArrayList<>();
        segéd.addAll( Arrays.asList(temp) );
        
        TreeSet<Integer> segédHalmaz = new TreeSet<>();
        segédHalmaz.addAll(Arrays.asList(temp));
        
        int [] result = new int [segédHalmaz.size()];
        int index = 0;
        for(int elem : segédHalmaz)
            result[index++] = elem;
        return result;
    }
    
    static int [] összefuttatás(int [] egyik, int [] másik){
        int [] result = new int [egyik.length + másik.length];
        int guard=0;
        for(int elem: egyik)
            result[guard++] = elem;
        for(int elem: másik)
            result[guard++] = elem;
        return result;
    }
    
    static int [] unió(int [] egyik, int [] másik){
        
//        int [] temp = összefuttatás(egyik, másik);
//        int [] result = halmazKiválogatás(temp);
//        return result;
        
        return halmazKiválogatás(összefuttatás(egyik,másik));
    }
}
