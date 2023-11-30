"""
請試著使用爬蟲，將批踢踢壇論的討論標題擷取出來
"""

from bs4 import BeautifulSoup as BS
import requests

url = "https://www.ptt.cc/bbs/index.html"
web = requests.get(url)

try:
    soup = BS(web.text, "lxml")
    data1 = soup.find_all("div", class_="bboard-title")

    for data in data1:
        print(data.text)
    
except Exception:
    print("error")