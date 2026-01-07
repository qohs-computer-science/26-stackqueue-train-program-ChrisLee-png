public class Train {
    private String name, product, origin, destination;
    private int weight, miles;

    public Train (String n, String p, String o, String d, int w, int m){
        name=n;
        product=p;
        origin=o;
        destination=d;
        weight=w;
        miles=m;
    }
    public Train (String n, String d){
        name=n;
        product="";
        origin="";
        destination=d;
    
    }
    public String getName(){
        return name;
    }
    public String getProduct(){
        return product;
    }
    public String getDestination(){
        return destination;
    }
    public int getWeight(){
        return weight;
    }
    public int getMiles(){
        return miles;
    }
    public void setMiles(int i){
        miles = i;
    }
    public String toString(){
        String r =name+product+origin+destination;
        if(weight!=0){
            r+=weight;
        }
        if(miles!=0){
            r+=miles;
        }
        return r;
    }

}
