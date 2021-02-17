from selenium import webdriver
import unittest
import time
class imageTest(unittest.TestCase):
    def setUp(self):
        self.driver=webdriver.Firefox()
        self.driver.get("http://localhost:8080/index.html")
        self.driver.maximize_window()

    def tearDown(self):
       self.driver.quit()

    def test_upload(self):
       self.driver.find_element_by_name("upload").send_keys("C:\\Users\\123\\Desktop\\护眼模式\\image2.jpg")
       time.sleep(3)
       self.driver.find_element_by_xpath("//*[@id='blog-collapse']/form/div[2]").click()
       time.sleep(3)

    def test_delete(self):
        self.driver.find_element_by_xpath("//*[@id='container']/div[1]/button").click()
        alert=self.driver.switch_to.alert()
        alert.accept()
    if __name__=="__main__":
        unittest.main()