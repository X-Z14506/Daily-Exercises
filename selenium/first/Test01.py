

from selenium import webdriver
import time

driver = webdriver.Firefox()
driver.get("https://www.baidu.com/")
time.sleep(3)
driver.find_element_by_xpath("//*[@id='kw']").send_keys("春招")
driver.find_element_by_id("su").submit()
driver.maximize_window()

# time.sleep(10) 固定等待
# # 智能等待
# # driver.implicitly_wait()
# # driver.find_element_by_link_text("陕西春招信息-官方招生咨询平台【招生指南_信息查询】").click()
# # time.sleep(3)

# 浏览器后退至上一，为啥无法后退，代码走不到这里
driver.back()
time.sleep(3)

# 浏览器继续前进
driver.forward()
time.sleep(3)

driver.quit()
