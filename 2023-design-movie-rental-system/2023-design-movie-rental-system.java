class MovieRentingSystem {
    // shop -> (movie -> price)
    List<Map<Integer, Integer>> priceMap;
    // movie -> available rentals sorted by (price, shop)
    Map<Integer, TreeSet<Record>> available;
    // global rented movies sorted by (price, shop, movie)
    TreeSet<Record> rented;

    // Record class to store (price, shop, movie)
    static class Record {
        int price, shop, movie;
        Record(int p, int s, int m) {
            price = p;
            shop = s;
            movie = m;
        }
    }

    // Comparator for search results (price, shop)
    Comparator<Record> cmpSearch = (a, b) -> 
        (a.price != b.price) ? a.price - b.price : a.shop - b.shop;

    // Comparator for report (price, shop, movie)
    Comparator<Record> cmpReport = (a, b) -> {
        if (a.price != b.price) return a.price - b.price;
        if (a.shop != b.shop) return a.shop - b.shop;
        return a.movie - b.movie;
    };

    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new ArrayList<>();
        available = new HashMap<>();
        rented = new TreeSet<>(cmpReport);

        // initialize shops
        for (int i = 0; i < n; i++) {
            priceMap.add(new HashMap<>());
        }

        // add entries
        for (int[] e : entries) {
            int s = e[0], m = e[1], p = e[2];
            priceMap.get(s).put(m, p);

            available.putIfAbsent(m, new TreeSet<>(cmpSearch));
            available.get(m).add(new Record(p, s, m));
        }
    }

    // return up to 5 cheapest shops for a movie (not rented yet)
    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!available.containsKey(movie)) return result;

        for (Record rec : available.get(movie)) {
            result.add(rec.shop);
            if (result.size() == 5) break;
        }   
        return result;
    }

    // rent a movie from a shop
    public void rent(int shop, int movie) {
        int price = priceMap.get(shop).get(movie);
        Record rec = new Record(price, shop, movie);

        available.get(movie).remove(rec); // remove from available
        rented.add(rec);                  // add to rented
    }

    // drop a rented movie back to available
    public void drop(int shop, int movie) {
        int price = priceMap.get(shop).get(movie);
        Record rec = new Record(price, shop, movie);

        rented.remove(rec);               // remove from rented
        available.get(movie).add(rec);    // add back to available
    }

    // report up to 5 cheapest rented movies
    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        
        for (Record rec : rented) {
            result.add(Arrays.asList(rec.shop, rec.movie));
            if (result.size() == 5) break;
        }
        return result;
    }
}
