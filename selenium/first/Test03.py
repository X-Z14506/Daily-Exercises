

from selenium import webdriver
import time

driver = webdriver.Firefox()
driver.get("https://www.baidu.com")
time.sleep(3)
driver.find_element_by_id("kw").send_keys("周杰伦")
driver.find_element_by_id("su").click()
driver.maximize_window()
time.sleep(3)

# 浏览器的滚动条拖到最底端
js = "var q=document.documentElement.scrollTop=100000"
driver.execute_script(js)
time.sleep(3)

# 浏览器的滚动条拖到最顶端
js = "var q=document.documentElement.scrollTop=0"
driver.execute_script(js)
time.sleep(3)

# 设置浏览器界面的大小
driver.set_window_size(800, 800)
time.sleep(1)

# 同时控制上下左右
js = "window.scrollTo(200,200)"
driver.execute_script(js)
time.sleep(3)
driver.quit()

