class RandomizedSet {
    
    private Set<Integer> randomizeSet;

    public RandomizedSet() {
        this.randomizeSet = new HashSet<Integer>();
    }
    
    public boolean insert(int val) {
        if (this.randomizeSet.contains(val)) {
            return false;
        } else {
            this.randomizeSet.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (this.randomizeSet.contains(val)) {
            this.randomizeSet.remove(val);
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        Random rand = new Random();
        int n = rand.nextInt(this.randomizeSet.size());
        Integer[] arrayNumbers = this.randomizeSet.toArray(new Integer[this.randomizeSet.size()]);
        
        return arrayNumbers[n];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */