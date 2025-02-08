def solution(nums):
    take_nums = len(nums) // 2
    nums = set(nums)
    if take_nums > len(nums):
        return len(nums)
    else:
        return take_nums