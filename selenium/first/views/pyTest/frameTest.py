from selenium import webdriver
import time
import os

bs = webdriver.Firefox()
file_path = 'file:///'+os.path.abspath("F:\\python\\FirstTest\\first\\views\\frame.html")
bs.get(file_path)
bs.implicitly_wait(30)
# 先找到ifrome1（id = f1）
bs.switch_to_frame("f1")
# 在找到其下面的ifrome2（id=f2）
bs.switch_to_frame("f2")
# 下边就可以正常的操作元素了
bs.find_element_by_id("kw").send_keys("selenium")
bs.find_element_by_id("su").click()
time.sleep(3)
bs.quit()