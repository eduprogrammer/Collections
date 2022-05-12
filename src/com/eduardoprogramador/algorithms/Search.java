/*
 * Copyright 2022. Eduardo Programador
 * www.eduardoprogramador.com
 * Free softwares at Microsoft Store, PlayStore and Web Apps.
 * consultoria@eduardoprogramador.com
 *
 * All Rights Reserved.
 * */

package com.eduardoprogramador.algorithms;

public class Search {
    public static final int SEARCH_LINEAR = 0;
    public static final int SEARCH_BINARY = 1;

    private Search() {}

    public static boolean find(int[] numbers, int value) throws CollectionException {
        if(numbers == null)
            throw new CollectionException("The array that you must provide cannot be null.");
        return find(numbers,value,SEARCH_LINEAR);

    }

    public static boolean find(int[] numbers, int value, int type) throws CollectionException {

        if(numbers == null)
            throw new CollectionException("The array that you must provide cannot be null.");

        if(type == SEARCH_BINARY) {
            Collections collections = Collections.startRoutine();
            collections.load(numbers);
            collections.quickSort();
            int[] sorted = collections.result();
            int piv = sorted.length/2;
            for (int i = piv; i > 0 ; i--) {
                if(sorted[i] == value) {
                    return true;
                }
            }
            for (int i = piv; i < numbers.length ; i++) {
                if(sorted[i] == value) {
                    return true;
                }
            }
            return false;
        } else if(type == SEARCH_LINEAR) {
            for(int n : numbers) {
                if(value == n) {
                    return true;
                }
            }
            return false;
        } else {
            throw new CollectionException("You must choose a valid Search type (BINARY or LINEAR).");
        }
    }
}
