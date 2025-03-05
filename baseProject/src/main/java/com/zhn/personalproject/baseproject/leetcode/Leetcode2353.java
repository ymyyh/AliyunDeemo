package com.zhn.personalproject.baseproject.leetcode;

import java.util.*;

public class Leetcode2353 {
    class Food{
        public Food(String kind, String name, int rate) {
            this.name = name;
            this.rate = rate;
            this.kind = kind;
        }
        String kind;
        String name;
        int rate;
    }

    Map<String, Food> nameToFood = new HashMap<>();
    Map<String, List<Food>> kindToFood = new HashMap<>();
    Map<String, Integer> nameToSort = new HashMap<>();
    public Leetcode2353(String[] foods, String[] cuisines, int[] ratings) {

        for(int i = 0;i < foods.length; ++i){
            Food food = new Food(cuisines[i], foods[i], ratings[i]);
            nameToFood.put(foods[i], food);
            if(kindToFood.containsKey(cuisines[i])){
                kindToFood.get(cuisines[i]).add(food);
            }else{
                List<Food> foodList = new ArrayList<>();
                foodList.add(food);
                kindToFood.put(cuisines[i], foodList);
            }
        }

        for(List<Food> foodList : kindToFood.values()){
            Collections.sort(foodList, new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    if(o1.rate != o2.rate){
                        return o2.rate - o1.rate;
                    }else{
                        return o1.name.compareTo(o2.name);
                    }
                }
            });
            for(int i = 0;i < foodList.size(); ++i){
                nameToSort.put(foodList.get(i).name, i);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        nameToFood.get(food).rate = newRating;
        List<Food> foodList = kindToFood.get(nameToFood.get(food).kind);
        int index = 0;
        foodList.remove((int) nameToSort.get(food));
        while(index < foodList.size()){
            if(nameToFood.get(food).rate > foodList.get(index).rate ||
                    (nameToFood.get(food).rate == foodList.get(index).rate && nameToFood.get(food).name.compareTo(foodList.get(index).name) >= 0)){
                break;
            }
        }
        foodList.add(index, nameToFood.get(food));
        nameToSort.put(food, index);
    }

    public String highestRated(String cuisine) {
        return kindToFood.get(cuisine).get(0).name;
    }
}
