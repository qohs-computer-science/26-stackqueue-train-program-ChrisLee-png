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
    }//end train constructor
    public Train (String n, String d){
        name=n;
        product="";
        origin="";
        destination=d;
    
    }//end enginer constructor
    public String getName(){
        return name;
    }//end name method
    public String getProduct(){
        return product;
    }//end product method
    public String getDestination(){
        return destination;
    }//end destination method
    public int getWeight(){
        return weight;
    }//end weight method
    public int getMiles(){
        return miles;
    }//end miles method
    public void setMiles(int i){
        miles = i;
    }// end set miles method
    public String toString(){
        String r =name+product+origin+destination;
        if(weight!=0){
            r+=weight;
        }//checks if train has weight 
        if(miles!=0){
            r+=miles;
        }//checks if engine has miles
        return r;
    }//end toString

}//end class
