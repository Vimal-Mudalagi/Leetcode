class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101];
        for (int[] log : logs) {
            for (int i = log[0]; i < log[1]; i++) {
                years[i - 1950]++;
            }
        }    
        int maxPopulation = 0;
        int maxYear = 0;
       
        for (int i = 0; i < years.length; i++) {
            if (years[i] > maxPopulation) {
                maxPopulation = years[i];
                maxYear = i + 1950;
            }
        }    
        return maxYear;
    }
}