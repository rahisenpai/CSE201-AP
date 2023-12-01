package ques3;

public class Search {
    int[] arr;
    Search(int[] arr){
        this.arr = arr;
    }
    public boolean binarySearch(int low, int high, int key){
        int mid = (high-low)/2 + low;
        if (low>high){
            return false;
        }
        if (this.arr[mid] == key){
            return true;
        }
        if (key<this.arr[mid]){
            return binarySearch(low,mid-1,key);
        }
        else{
            return binarySearch(mid+1,high,key);
        }
    }
}