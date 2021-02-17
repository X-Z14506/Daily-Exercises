from selenium import webdriver
import os
import time

bs = webdriver.Firefox()
file_path = 'file:///'+os.path.abspath("F:\\python\\FirstTest\\first\\views\\drop_down.html")
bs.get(file_path)
time.sleep(2)
bs.maximize_window()
# xpath定位
# bs.find_element_by_xpath("//*[@value='10.69']").click()
# time.sleep(3)

# 循环遍历
lists = bs.find_elements_by_tag_name("option")
for list in lists:
    if list.get_attribute('value') == "10.69":
        list.click()
time.sleep(3)
# 通过下标
lists[3].click()
time.sleep(3)

bs.quit()