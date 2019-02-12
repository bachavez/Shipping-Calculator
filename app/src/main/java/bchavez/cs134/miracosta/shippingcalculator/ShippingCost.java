package bchavez.cs134.miracosta.shippingcalculator;

public class ShippingCost {

    private double mWeight;
    private double mBaseCost;
    private double mAddedCost;
    private double mTotalCost;

    public ShippingCost() {
        this.mWeight = 0.0;
        this.mBaseCost = 3.0;
        this.mAddedCost = 0.0;
        this.mTotalCost = 0.0;
    }

    public double getWeight() {
        return mWeight;
    }

    public void setWeight(double mWeight) {
        this.mWeight = mWeight;
        recalculateCosts();
    }

    public double getBaseCost() {
        return mBaseCost;
    }

    public double getAddedCost() {
        return mAddedCost;
    }

    public double getTotalCost() {
        return mTotalCost;
    }

    private void recalculateCosts(){
        if(mWeight <= 16){
            mAddedCost = 0;
        } else {
            mAddedCost = mBaseCost + ((Math.floor(( mWeight - 16.1)/4 +1 ) *.5));
        }

        mTotalCost = mBaseCost + mAddedCost;
    }
}
