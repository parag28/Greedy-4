// TC:O(n)
// SC:O(1)

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> map = new HashMap();      // frequency hashmap  
        int n= tops.length;
        int candidate=-1;
            
        for(int i=0;i<n;i++){       // store frequency from both arrays of each digit
            int t= tops[i];
            map.put(t, map.getOrDefault(t,0)+1);
            int cntT= map.get(t);
            if(cntT>=n) {           // candidate is someone who occurs >=n
                candidate=t;    
                break;
            }
           int b= bottoms[i];
            map.put(b, map.getOrDefault(b,0)+1);
            int cntB= map.get(b);
            if(cntB>=n) {
                candidate=b;
                break;
            }
        }
        
        if(candidate==-1) return -1;
        int rotT=0, rotB=0;
        for(int i=0;i<n;i++){       //traverse both arrays simultaneously
            if(tops[i]!=candidate && bottoms[i]!=candidate)
                return -1;
            if(tops[i]== candidate && bottoms[i]!= candidate)
                rotT++;
            if(tops[i]!= candidate && bottoms[i]== candidate)
                rotB++;
        }
        
        return Math.min(rotT,rotB);
    }
}
