class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        totalSum = sum(nums)
        
        if totalSum % 2:
            return False
        
        return self.isPossible(nums, 0, totalSum//2, {})
    
    def isPossible(self, nums, currentIndex, target, memo):
        
        if target == 0:
            return True
        
        if currentIndex >= len(nums):
            return False
        
        currentKey = (currentIndex, target)
        
        if currentKey in memo:
            return memo[currentKey]
        
        including = False
    
        if nums[currentIndex] <= target:
            including = self.isPossible(nums, currentIndex+1, target - nums[currentIndex], memo)

        excluding = self.isPossible(nums, currentIndex+1, target, memo)
        
        memo[currentKey] = including or excluding
        return memo[currentKey]
