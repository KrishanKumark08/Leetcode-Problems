class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<Integer>();
        for(int stone:stones){
            list.add(stone);
        }
        Collections.sort(list);
        return func(list);
    }
    public int func(List<Integer> list)
    {
        if(list.size()==1)
            return list.get(0);
        if(list.size()==0)
            return 0;
        int diff = list.get(list.size()-1) - list.get(list.size()-2);
            list.remove(list.size()-1);
            list.remove(list.size()-1);
            if(diff!=0){
                list.add(diff);
                Collections.sort(list);
            }
        return func(list);
    }
}