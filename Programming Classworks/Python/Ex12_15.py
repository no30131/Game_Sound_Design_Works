"""請撰寫一程式，用numpy做出以下的ndarray，並輸出以下資料
[ 0  1  2  3  4  5]
[10 11 12 13 14 15]
[20 21 22 23 24 25]
[30 31 32 33 34 35]
[40 41 42 43 44 45]
[50 51 52 53 54 55]
紅框圈起的四個角落的值[[0 5][50 55]]
黃框圈起的值[[23 24][33 34]]
計算每一排的總合15.75.135.195.255.315"""

import numpy as np

d1 = np.arange(6)
d2 = np.arange(10,16)
d3 = np.arange(20,26)
d4 = np.arange(30,36)
d5 = np.arange(40,46)
d6 = np.arange(50,56)

result = np.concatenate(([d1], [d2], [d3], [d4], [d5], [d6]))

print("紅框圈四角落的值：\n %s" %result[0::5,0::5])
print("黃框圈起的值：\n %s" %result[3:5,3:5])
print("計算每一排的總合：")
#方法一
print(np.sum(d1),np.sum(d2),np.sum(d3),np.sum(d4),np.sum(d5),np.sum(d6))
#方法二
print(np.sum(result, axis=1))
