class Solution {
    public int lastStoneWeight(int[] stones) {
       // array = ArrayUtils.remove(array, index);
       List<Integer> list = new ArrayList<Integer>();
        for(int stone:stones){
            list.add(stone);
        }
        stonei(list);
        return list.get(0);
    }
    public void stonei(List<Integer> targetList)
    {
        if(targetList.size()==1)
            return;
        Collections.sort(targetList);
       // Arrays.copyOf(stones, stones.length-1);
        int r=targetList.get(targetList.size()-1)-targetList.get(targetList.size()-2);
        targetList.set(targetList.size()-2,r);
        targetList.remove(targetList.size()-1);
        stonei(targetList);
    }
}