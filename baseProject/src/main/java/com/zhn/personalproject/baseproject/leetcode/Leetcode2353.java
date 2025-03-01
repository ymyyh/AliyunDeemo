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

    Map<String, Food> kindToBestFood = new HashMap<>();
    public Leetcode2353(String[] foods, String[] cuisines, int[] ratings) {

        for(int i = 0;i < foods.length; ++i){
            Food food = new Food(cuisines[i], foods[i], ratings[i]);
            nameToFood.put(foods[i], food);
            if(kindToFood.containsKey(cuisines[i])){
                kindToFood.get(cuisines[i]).add(food);
            }else{
                List<Food> foodQueue = new ArrayList<>();
                foodQueue.add(food);
                kindToFood.put(cuisines[i], foodQueue);
            }
            if(!kindToBestFood.containsKey(cuisines[i])){
                kindToBestFood.put(cuisines[i], food);
            }else if(kindToBestFood.get(cuisines[i]).rate < food.rate ||
                    (kindToBestFood.get(cuisines[i]).rate == food.rate && kindToBestFood.get(cuisines[i]).name.compareTo(food.name) > 0)){
                kindToBestFood.put(cuisines[i], food);
            }

        }
    }

    public void changeRating(String food, int newRating) {

        Food tempFood = nameToFood.get(food);

        String kind = tempFood.kind;
        String bestName = kindToBestFood.get(kind).name;
        int bestRate = kindToBestFood.get(kind).rate;
        List<Food> foodList = kindToFood.get(kind);
        tempFood.rate = newRating;

        if(bestName.equals(food) &&
                (newRating < bestRate || (bestRate == newRating && bestName.compareTo(food) < 0))) {
            bestRate = newRating;
            for(Food entity : foodList){
                if(entity.rate > bestRate ||
                        (entity.rate == bestRate && entity.name.compareTo(bestName) < 0)){
                    bestRate = entity.rate;
                    bestName = entity.name;
                    kindToBestFood.put(kind, entity);
                }
            }
        }else if(bestRate < newRating ||
                (bestRate == newRating && bestName.compareTo(food) > 0)) {
            kindToBestFood.put(kind, tempFood);
        }
    }

    public String highestRated(String cuisine) {
        return kindToBestFood.get(cuisine).name;
    }
}
