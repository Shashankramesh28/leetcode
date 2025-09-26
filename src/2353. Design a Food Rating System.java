import java.util.*;

class FoodRatings {

    class Food {
        String name;
        String cuisine;
        int rating;

        public Food(String name, String cuisine, int rating){
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        public String getName(){
            return this.name;
        }

        public String getCuisine(){
            return this.cuisine;
        }

        public int getRatings(){
            return this.rating;
        }

        public void setRating(int rating){
            this.rating = rating;
        }

        protected boolean equals(Food foodObj){
            return this.name.equals(foodObj.getName());
        }
    }
    HashMap<String, Food> foodMap = new HashMap<>();
    HashMap<String, PriorityQueue<Food>> cuisineMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0;i<foods.length;i++){
            Food f = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], f);
            cuisineMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>( (a, b) -> {
                if(a.getRatings() != b.getRatings()) return b.rating - a.rating;
                return a.getName().compareTo(b.getName());
            })).add(f);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food f = foodMap.get(food);
        Food updatedFood = new Food(food, f.getCuisine(), newRating);
        foodMap.put(food, updatedFood);
        cuisineMap.get(f.getCuisine()).add(updatedFood);
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> queue = cuisineMap.get(cuisine);

        while (!queue.isEmpty()) {
            Food top = queue.peek();
            Food temp = foodMap.get(top.name);
            if (top.rating == temp.rating) {
                return top.name;
            } else {
                queue.poll();
            }
        }
        return "";
    }
}