import math

n = int(input())
digits = list(map(int,str(n)))
left = 0
right = len(digits) - 1
palin = True
while left <= right:
    if digits[left] != digits[right]:
        palin = False
        print('No')
        break
    left += 1
    right -= 1
if palin:
    print('Yes')