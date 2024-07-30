import pytest
from selenium.webdriver import Keys
from selenium.webdriver.common.by import By
import time
from selenium.webdriver.support import expected_conditions as ec
from selenium.webdriver.support.wait import WebDriverWait
from jproperties import Properties

class TestLogin:
    @pytest.mark.flipkart
    @pytest.mark.login
    def test_login_fnx(self, driver):
        configs = Properties()
        with open("config.properties", "rb") as file:
            configs.load(file)
        driver.get(f'{configs.get("link_login").data}')
        driver.maximize_window()
        wait = WebDriverWait(driver, 10)
        otp_button=wait.until(ec.presence_of_element_located((By.XPATH,
                                                   "//div[@id='container']/div/div[3]/div/div[2]/div/form/div[3]/button")))
        current_url = driver.current_url
        assert current_url == "https://www.flipkart.com/account/login?ret=/", "Wrong Page"

        # otp_button = driver.find_element(By.XPATH,
        #                                  "//div[@id='container']/div/div[3]/div/div[2]/div/form/div[3]/button")
        assert otp_button.is_displayed()

        placeholder = driver.find_element(By.XPATH,
                                          "//div[@id='container']/div/div[3]/div/div[2]/div/form/div[1]/input")
        placeholder.click()
        placeholder.send_keys(f'{configs.get("number").data}')
        placeholder.send_keys(Keys.RETURN)

        error_message = driver.find_element(By.XPATH,
                                            "//div[@id='container']/div/div[3]/div/div[2]/div/form/div[1]/span[3]/span")
        print("Error is: " + error_message.text)
        driver.implicitly_wait(3)
        placeholder.clear()
        time.sleep(3)
