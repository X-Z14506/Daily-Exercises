from selenium import webdriver
import time
from selenium.webdriver.common.keys import Keys

driver = webdriver.Firefox()
driver.get("https://www.baidu.com")
driver.maximize_window()
driver.find_element_by_id("kw").send_keys("牛年")
driver.find_element_by_id("su").click()
driver.implicitly_wait(3)
# 组合键：全选ctrl+a
driver.find_element_by_id("kw").send_keys(Keys.CONTROL, 'a')
time.sleep(3)
# 组合键：剪切
driver.find_element_by_id("kw").send_keys(Keys.CONTROL, 'x')
time.sleep(3)
driver.find_element_by_id("kw").send_keys("牛气冲天")
time.sleep(3)
driver.quit()
