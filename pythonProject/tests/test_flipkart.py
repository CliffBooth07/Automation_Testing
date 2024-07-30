import pytest

import time
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as ec
from jproperties import Properties


class TestFlipkart:
    @pytest.mark.flipkart
    @pytest.mark.search
    def test_search_fnx(self, driver):
        configs = Properties()
        with open("config.properties", "rb") as file:
            configs.load(file)
        driver.get(f'{configs.get("link").data}')
        driver.maximize_window()
        wait = WebDriverWait(driver, 10)
        search_bar = wait.until(ec.presence_of_element_located((By.XPATH,
                                                                "//div[@id='container']/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input")))
        current_url = driver.current_url
        assert current_url == "https://www.flipkart.com/", "Wrong Page"

        # search_bar = driver.find_element(By.XPATH,"//div[@id='container']/div/div[1]/div/div/div/div/div[
        # 1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input")
        search_bar.click()
        search_bar.send_keys(f'{configs.get("item").data}')
        search_bar.send_keys(Keys.RETURN)

        results_found = wait.until(ec.presence_of_element_located(
            (By.XPATH, "//div[@id='container']/div/div[3]/div[1]/div[2]/div[1]/div/div/span")))

        # results_found = driver.find_element(By.XPATH,'//div[@id="container"]/div/div[3]/div[1]/div[2]/div[
        # 1]/div/div/span')
        print(results_found.text)

        product_found = driver.find_elements(By.CLASS_NAME, "KzDlHZ")
        file = open("../result_found.txt", "w")
        for product in product_found:
            print(product.text)
            file.writelines(product.text + "\n")
        file.close()

        window_before = driver.current_window_handle
        print("Before: " + window_before)
        driver.find_element(By.XPATH, "//div[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a").click()
        time.sleep(3)
        for handle in driver.window_handles:
            if handle != window_before:
                print(handle)
                window_after = handle
                break
        print("After: " + window_after)
        driver.switch_to.window(window_after)
        product_name = wait.until(ec.presence_of_element_located(
            (By.XPATH, "//div[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/h1/span")))

        # product_name = driver.find_element(By.XPATH,
        #                                    "//div[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/h1/span")
        print(product_name.text)
        add_to_cart = driver.find_element(By.XPATH,
                                          "//div[@id='container']/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
        assert add_to_cart.is_displayed(), "It not got displayed"

        driver.find_element(By.XPATH, "//div[@id='container']/div/div[1]/div[1]/div[2]/div[1]/div/a[1]").click()
        driver.implicitly_wait(3)
        try:
            driver.find_element(By.XPATH,
                                '//div[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/div').click()
        except:
            driver.implicitly_wait(4)
            print("Pop up showed")
            driver.find_element(By.XPATH, "/html/body/div[3]/div/span").click()
            driver.find_element(By.XPATH,
                                '//div[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/div').click()
        time.sleep(4)