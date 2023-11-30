""" 請撰寫一程式，請使用者輸入容器大小n，
    然後在該容器中產生n 個1~100 的亂數，
    最後再將這n 個亂數以list 、
    tuple 、set 以及dict 的方式輸出
     ◆ 容器中的亂數不能重複 """
    
import random 
    
ct = int(input("請輸入容器大小(整數)： "))
ct_set = set()

while len(ct_set) < ct:
    num = random.randint(1,100)
    ct_set.add(num)
    
print("set：%s" %ct_set)
print("list：%s" %list(ct_set))
print("tuple：%s" %str(tuple(ct_set)))

ct_dict = {index + 1: element for index, element in enumerate(ct_set)}
print("dict: %s" % ct_dict)