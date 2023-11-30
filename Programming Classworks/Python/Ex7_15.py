"""請撰寫一程式，請使用者輸入3個整數，將這3個整數傳
入自訂函數後，請計算一元二次方程式的答案
1. b2-4ac > 0 → 兩相異解
2. b2-4ac = 0 → 兩相同解
3. b2-4ac < 0 → 無解"""

import math

x = int(input("請輸入整數a： "))
y = int(input("請輸入整數b： "))
z = int(input("請輸入整數c： ")) 
  
def solve_math (a,b,c):
    
    d = (b**2) - (4*a*c)
    sqrt_d = math.sqrt(d)
    
    if d > 0:
        ans1 = (-b + sqrt_d) / (2 * a)
        ans2 = (-b - sqrt_d) / (2 * a)
        print("答案為:", ans1, ans2)
        
    elif d == 0:
        ans3 = (-b + sqrt_d) / (2 * a)
        print("答案為:", ans3)
        
    else: 
        ans4 = (-b + sqrt_d) / (2 * a)
        print("答案為:", ans4)
   
solve_math(x,y,z)
 