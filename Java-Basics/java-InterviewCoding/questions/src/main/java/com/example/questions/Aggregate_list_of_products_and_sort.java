package com.example.questions;

import java.util.ArrayList;
import java.util.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aggregate_list_of_products_and_sort {


    public static void main(String[] args) {

        List<String> productList = new ArrayList<>();
        productList.add("product1");
        productList.add("product1");
        productList.add("product2");
        productList.add("product3");
        productList.add("product4");
        productList.add("product4");
        productList.add("product4");
        productList.add("product2");

        int[] arr = new int[]{2,3,4,5};
        getProductCount(productList);

    }

    private static List<Product> getProductCount(List<String> productList) {
        HashMap<String, Integer> productCount = countProducts(productList);

        List<Product> sortedProductList = getProductList(productCount);


        for (Product product : sortedProductList) {
            System.out.println(product.toString());
        }


        return null;
    }

    private static HashMap countProducts(List<String> productList) {

        HashMap<String, Integer> productCount = new HashMap<>();

        Integer count = null;
        for (String s : productList) {

            if (productCount.containsKey(s)) {
                count = productCount.get(s);
                count++;
                productCount.put(s, count);
            } else {
                productCount.put(s, 1);
            }

        }

        return productCount;
    }

    private static List getProductList(HashMap<String, Integer> productMap) {

        List<Product> productList = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : productMap.entrySet()) {

            Product product = new Product(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
            productList.add(product);

        }

        //sort list
        Collections.sort(productList);

        return productList;

    }


    static class Product implements Comparable<Product> {
        String name;
        int count;

        Product(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }

        @Override
        public int compareTo(Product product) {

            return product.count - this.count;
        }
    }


}
