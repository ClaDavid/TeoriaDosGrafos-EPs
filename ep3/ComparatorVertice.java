package ep3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import ep0.*;


public class ComparatorVertice implements java.util.Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Vertice v1 = (Vertice) o1;
        Vertice v2 = (Vertice) o2;
        if (v1.f <  v2.f) {
            return 1;
        }
        if ( v1.f > v2.f) {
            return -1;
        }

        return 0;

    }
}