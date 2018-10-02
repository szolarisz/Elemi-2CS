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
        System.out.println("Szerepel a "+teszt+" a t�mbben: "+ contains(vektor,teszt));
        System.out.println("A keresett elem indexe: "+indexOf(vektor,teszt));
        felsorol(vektor);
        int [] rendez�shez = {12, 6, 7, 3, 2, 15, 14, 1, 4, 5, 13, 10, 11, 9, 8};
        System.out.println("Rendezve");
        rendezBubor�k(rendez�shez);
        felsorol(rendez�shez);
        System.out.println("A vektorban 3-mal oszthat� sz�mok sz�ma: "+
                megsz�ml�l(vektor));
        System.out.println("A maximum �rt�ke: " +vektor[ maximum(vektor) ]);
        System.out.println("A max indexe: "+ maximum(vektor));
        maximumMind(vektor);
        int [] haromMod  = kiv�logat�s(vektor);
        System.out.println("Csak 3-mal oszthat�k t�mbje:");
        felsorol(haromMod);
        
        int [] p�ratlanok = new int[vektor.length];
        int str�zsa = kiv�logatGuard(vektor, p�ratlanok);
        System.out.print("P�ratlanok:");
        for(int i=0; i<str�zsa; i++)
            System.out.print(" "+p�ratlanok[i]);
        System.out.println("");
        
        int [] halmazhoz = {3,6 ,3,8, 2, 7, 10, 1,2, 2, 3, 6, 7};
        int [] halmaz = halmazKiv�logat�s(halmazhoz);
        felsorol(halmaz);
        int halmaz2 [] = halmazTS(halmazhoz);
        felsorol(halmaz2);
        
        int [] halmazA = {1, 3, 5, 7, 9, 12, 14, 16, 18, 20};
        int [] halmazB = {3, 7, 8, 4, 6, 10, 14, 18, 20};
    }
    
    static boolean contains(int [] t�mb, int keres){
        boolean result = false;
        for(int elem: t�mb)
            if(elem == keres){
                result = true;
                break;
            }
        return result;
    }
    
    static int indexOf(int [] t�mb, int keres){
        int result = -1;
        for(int i=0; i<t�mb.length; i++)
            if(keres == t�mb[i]){
                result = i;
                break;
            }
        return result;
    }
    
    static void felsorol(int [] t�mb){
        for(int i=0; i<t�mb.length-1; i++)
            System.out.print(t�mb[i]+" ");
        System.out.println(t�mb[ t�mb.length-1 ]);
    }
    
    static void rendezBubor�k(int [] t�mb){
        for(int i=0; i<t�mb.length -1; i++)
            for(int j=0; j<t�mb.length - 1; j++)
                if(t�mb[j] > t�mb[j+1]){
                    int tmp = t�mb[j];
                    t�mb[j] = t�mb[j+1];
                    t�mb[j+1] = tmp;
                }
    }
    
    static int megsz�ml�l(int [] t�mb){
        int darab = 0;
        for(int elem : t�mb)
            if( elem % 3 == 0) //F - 3-mal oszthat�
                darab++;
        return darab;
    }
    
    static int maximum(int [] t�mb){
        int maxHely = 0;
        for(int i=1; i<t�mb.length; i++)
            if(t�mb[i] > t�mb[maxHely])
                maxHely = i;
        return maxHely;
    }
    
    static void maximumMind(int [] t�mb){
        int maxIndex = maximum(t�mb);
        System.out.print("A max elem: "+t�mb[maxIndex] +
                " a k�vetkez� helyeken fordul el�:");
        for(int i=0; i<t�mb.length; i++)
            if(t�mb[i] == t�mb[maxIndex])
                System.out.print(" "+i);
        System.out.println("");
    }
    
    static int [] kiv�logat�s(int [] t�mb){
        int darab = 0; //F 3-mal oszthat�
        for( int elem: t�mb)
            if(elem % 3 == 0)
                darab++;
        
        int [] eredm�ny = new int[darab];
        
        int index =0;
        for( int elem: t�mb)
            if(elem % 3 == 0)
                eredm�ny[index++] = elem;
        return eredm�ny;
    }
    
    static int kiv�logatGuard(int [] t�mb, int [] eredm�ny){
        int guard=0;
        for(int elem: t�mb)
            if(elem % 2 == 1)
                eredm�ny[guard++] = elem;
        return guard;
    }
    
    static int [] halmazKiv�logat�s(int [] t�mb){
        int guard = 0;
        int [] temp = new int [t�mb.length];
        for(int elem: t�mb){
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
    
    static int [] halmazTS(int [] t�mb){
        Integer [] temp = new Integer  [t�mb.length];
        for(int i=0; i<t�mb.length; i++)
            temp[i] = t�mb[i];
        ArrayList<Integer> seg�d = new ArrayList<>();
        seg�d.addAll( Arrays.asList(temp) );
        
        TreeSet<Integer> seg�dHalmaz = new TreeSet<>();
        seg�dHalmaz.addAll(Arrays.asList(temp));
        
        int [] result = new int [seg�dHalmaz.size()];
        int index = 0;
        for(int elem : seg�dHalmaz)
            result[index++] = elem;
        return result;
    }
    
    static int [] �sszefuttat�s(int [] egyik, int [] m�sik){
        int [] result = new int [egyik.length + m�sik.length];
        int guard=0;
        for(int elem: egyik)
            result[guard++] = elem;
        for(int elem: m�sik)
            result[guard++] = elem;
        return result;
    }
    
    static int [] uni�(int [] egyik, int [] m�sik){
        
//        int [] temp = �sszefuttat�s(egyik, m�sik);
//        int [] result = halmazKiv�logat�s(temp);
//        return result;
        
        return halmazKiv�logat�s(�sszefuttat�s(egyik,m�sik));
    }
    
    static int [] metszet(int [] egyik, int [] m�sik){
        int str�zsa =0;
        /*
        if a kisebb m�ret� t�mb keres�s�re
        */
        int [] result = new int[egyik.length];
        for(int i=0;i<egyik.length; i++)
            if(contains(m�sik, egyik[i]))
                result[str�zsa++] = egyik[i];
        int [] temp = new int[str�zsa];
        str�zsa = 0;
        for(int i=0; i<temp.length; i++)
            temp[str�zsa++] = result[i];
        return temp;
    }
    
    static int [] k�l�nbs�g(int [] egyik, int [] m�sik){
        //egyik \ m�sik
        int [] metszet = metszet(egyik,m�sik);
        int [] result = new int [egyik.length-metszet.length];
        int str�zsa = 0;
        for(int elem: egyik)
            if( !contains(metszet,elem) )
                result[str�zsa++] = elem;
        return result;
    }
}
