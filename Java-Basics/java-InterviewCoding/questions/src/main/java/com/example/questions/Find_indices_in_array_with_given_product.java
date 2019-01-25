package com.example.questions;

public class Find_indices_in_array_with_given_product {

    //Find the indices of the elements in the array whose product is equal to
    //to the given product

    public static void main(String[] args) {

        int[] sampleInt = new int[]{2,3,5,4,5};
        System.out.println(findIndices(sampleInt, 25));

    }


    public static String findIndices(int[] arr, int product){

        int currentProduct = 0;
        String indices = null;


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                currentProduct = arr[i] * arr[j];
                if(currentProduct==product) indices ="[" + i + "," + j + "]";
            }
        }

        return indices;
    }

    public static String findIndicesWithBinary(int[] arr, int product) {



        return "";
    }
}
